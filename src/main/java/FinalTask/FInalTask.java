package FinalTask;
import java.util.Random;
import java.util.Scanner;

public class FInalTask {
    public static void main(String[] args) {
        //можно задать другой размер поля (только квадрат) или другой состав кораблей
        Field field_1 = new Field(10);
        Field field_2 = new Field(10);
        //первая координата в массиве - тип корабля (количество палуб), вторая - количество таких кораблей
        int[][] fleet = {{4,1}, {3,2}, {2,3}, {1,4}};
        //int[][] fleet = {{1,1}};
        int boatsNumber = 0;    //количество кораблей для подсчета баланса оставшихся
        for (int i=0; i<fleet.length; i++)
            boatsNumber += fleet[i][1];

        Scanner sc = new Scanner(System.in);
        //ввод кораблей
        System.out.println("Первый Игрок начинает вводить координаты своих кораблей. Второй Игрок, не смотрите.");
        if (! SetUpTheBoats(1, field_1, fleet, sc)) //пользователь прервал программу
            return;
        System.out.println("Ввод поля Первого Игрока завершен. Проверьте результат:");
        field_1.print();

        System.out.println("Для продолжения нажмите 'Clear all' в консоли. Затем введите цифру 2 и пригласите Второго Игрока вносить данные.");
        System.out.println("Для выхода из программы введите цифру 9");

        while (sc.hasNextLine()){
            String nextStep = sc.nextLine();
            if (nextStep.equals("9")){
                System.out.println("Программа остановлена пользователем");
                return;
            }
            if (nextStep.equals("2"))  //продолжить программу
                break;
        }
        System.out.println("Второй Игрок начинает вводить координаты своих кораблей. Первый Игрок, не смотрите.");
        if (! SetUpTheBoats(2, field_2, fleet, sc))
            return;
        System.out.println("Ввод поля Второго Игрока завершен. Проверьте результат:");
        field_2.print();

        System.out.println("Для продолжения нажмите 'Clear all' в консоли. Затем введите цифру 1, игра будет начата.");
        System.out.println("Для выхода из программы введите цифру 9");
        while (sc.hasNextLine()){
            String nextStep = sc.nextLine();
            if (nextStep.equals("9")){
                System.out.println("Программа остановлена пользователем");
                sc.close();
                return;
            }
            if (nextStep.toLowerCase().equals("f1"))
                field_1.print();
            else if (nextStep.toLowerCase().equals("f2"))
                field_2.print();
            else if (nextStep.equals("9")){
                System.out.println("Программа остановлена пользователем");
                return;
            }
            else if (nextStep.equals("1"))
                break;
        }
        Random rnd = new Random();
        System.out.println("Вводите по очереди координаты своего удара в формате ( x,y ).");
        System.out.println("Для вывода текущего состояния поля вводите соответственно F1 или F2 для Первого или Второго Игрока");
        int currentPlayer = rnd.nextInt(2)+1;
        int opponent = ((currentPlayer == 1) ? 2 : 1);
        System.out.println("ВНИМАНИЕ! Начинает "+currentPlayer+"-й Игрок:");

        Field[] fields = {field_1, field_2};    //для быстрого обращения [0] / [1]
        int[] boatBalance = {boatsNumber, boatsNumber};   //для хранения количества оставшихся кораблей

        while (sc.hasNextLine()){
            String nextStep = sc.nextLine();
            if (nextStep.equals("9")){
                System.out.println("Программа остановлена пользователем");
                sc.close();
                return;
            }
            if (nextStep.toLowerCase().equals("f1"))
                field_1.print();
            else if (nextStep.toLowerCase().equals("f2"))
                field_2.print();
            else {
                String[] coordinates = nextStep.split(",");
                if (coordinates.length != 2)
                    System.out.println("Неверный формат. Повторите ввод в формате ( x,y ):");
                else{
                    int x = Integer.parseInt(coordinates[0]);
                    int y = Integer.parseInt(coordinates[1]);
                    if (x<0 || x>field_1.getSize()-1 || y<0 || y>field_1.getSize()-1)
                        System.out.println("Неверные координаты. Повторите ввод, используя значения от 0 до "+(field_1.getSize()-1)+":");
                    else {  //наконец все правильно
                        int shotResult;
                        shotResult = MakeTheShot(fields[opponent-1], x, y);
                        if (shotResult == 0) {
                            System.out.println("МИМО!");
                            opponent = currentPlayer;
                            currentPlayer = ((currentPlayer == 1) ? 2 : 1);
                            System.out.println("Следующий ход Игрока "+currentPlayer+ ":");
                        }
                        else if (shotResult == 1) {
                            System.out.println("Попал!");
                            System.out.println("Ход остается у Игрока " +currentPlayer+":");
                        }
                        else{
                            System.out.println("Утопил!");
                            boatBalance[opponent-1] -= 1;
                            //проверить остальной флот
                            if (boatBalance[opponent-1] == 0) {  //кораблей больше нет
                                System.out.println("Игрок " + currentPlayer + " потопил все корабли соперника и одержал победу. Поздравляем ✨\uD83C\uDFC6✨ ! Игра окончена. ");
                                sc.close();
                                return;
                            }
                            else
                                System.out.println("Ход остается у Игрока " +currentPlayer+":");
                        }
                    }
                }
            }
        }
    }

    // 0 - мимо, 1 - ранил, 2 - убил
    public static int MakeTheShot(Field field, int x, int y){
        BoxStatus status = field.getBoxStatus(x, y);
        if (status == BoxStatus.SEA)
            return 0;
        else{ // BoxStatus.BOAT_SHOT или BoxStatus.BOAT_WHOLE; первичный или повторный удар, значения не имеет
            field.setBoxStatus(BoxStatus.BOAT_SHOT, x, y);
            int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}};
            // идти от клетки удара по горизонтали влево, потом вправа, потом вниз и вверх
            for (int i=0; i<4; i++){
                int x1 = x;
                int y1 = y;
                //если найдена целая часть корабля - сразу вернуть "ранил"
                if (CheckTheBoat(field, x1, y1, moves[i][0], moves[i][1]) == 1)
                    return 1;
            } //если прошел до конца и не нашел целой части -> убит
            return 2;
        }
    }

    // 1 - найдена целая часть корабля, 2 - дошли до границы поля или до моря и целой части корабля не нашли
    // если найдена целая часть корабля, сразу вернуть "ранил";
    // если прошел всё до конца и встретил только статус SEA или край поля = "убил".
    public static int CheckTheBoat(Field field, int x1, int y1, int incr_x, int incr_y){
        int x = x1 + incr_x;
        int y = y1 + incr_y;
        while (true){
            BoxStatus status = BoxStatus.SEA;
            if (x>=0 && y>=0 && x<field.getSize() && y<field.getSize())
                status = field.getBoxStatus(x ,y);
            if (status == BoxStatus.BOAT_WHOLE)
                return 1;   //нашли целую часть корабля -> не м.б. убит, выйти
            else if (status == BoxStatus.SEA)
                return 2;   //дошли до границы поля или до моря
            x += incr_x;
            y += incr_y;
        }
    }
    public static boolean SetUpTheBoats(int playerNumber, Field field, int[][] fleet, Scanner sc) {
        String message1 = "ПЕРВЫЙ";
        System.out.println("(для выхода из программы введите STOP)");
        System.out.println("(для вывода текущего состояния своего поля введите F)");
        if (playerNumber == 2)
            message1 = "ВТОРОЙ";

        for (int i = 0; i < fleet.length; i++) { //fleet[i][0] - тип корабля
            String format = "x,y";
            int boatSize = fleet[i][0];
            for (int k = 1; k < boatSize; k++)
                format = format + ";x,y";

            int countBoats = fleet[i][1]; //fleet[i][1] - количество кораблей этого типа
            for (int j = 0; j < countBoats; j++) {
                String message2 = "";
                if (countBoats > 1)
                    message2 = " " + (j+1) + "-го ";
                System.out.println(message1 + " Игрок, введите координаты" + message2 + " " + boatSize + "-палубного корабля (формат: "+format+" ):");
                int[] x = new int[boatSize];
                int[] y = new int[boatSize];

                String coordinates = "";
                while (sc != null) {
                    if (InsertCoordinates(sc, boatSize, x, y, field))
                        if (addBoat_here(x, y, field))
                            break;
                }
            }
        }
        return (sc != null);
    }

    public static boolean InsertCoordinates(Scanner sc, int boatSize, int[] x, int[] y, Field field){
        //возврат true, если внесены корректные координаты, помещены в массив
        String coordinates = sc.nextLine();
        if (coordinates.toLowerCase().equals("stop")) {
            sc.close();
            sc = null;
            return false;
        }
        else if (coordinates.toLowerCase().equals("f")){
            field.print();
            return false;
        }
        String[] pairs = coordinates.split(";");
        if (pairs.length != boatSize) {
            System.out.println("Введены не все координаты или неверный формат. Повторите ввод:");
            return false;
        }
        for(int i=0; i<boatSize; i++) {
            String[] x_and_y = pairs[i].split(",");
            if (x_and_y.length != 2){
                System.out.println("Введены не все координаты или неверный формат. Повторите ввод:");
                return false;
            }
            x[i] = Integer.parseInt(x_and_y[0]);
            y[i] = Integer.parseInt(x_and_y[1]);
        }
        return true;
    }

    public static boolean addBoat_here(int[] x, int[] y, Field field) {
        switch (Field.addBoat(x, y, field)) {
            case -1:
                System.out.println("Внесены неверные координаты. Корабль не размещен, повторите ввод (для вывода своего поля введите F):");
                return false;
            case -2:
                System.out.println("На этом месте уже расположен корабль. Корабль не размещен, повторите ввод (для вывода своего поля введите F):");
                return false;
            case -3:
                System.out.println("Новый корабль нарушает ореол других кораблей. Корабль не размещен, повторите ввод (для вывода своего поля введите F):");
                return false;
            case 1:
                System.out.println("Корабль успешно размещен");
                return true;
            default:
                System.out.println("Получено неизвестное исключение. Попробуйте внести координаты снова. Для выхода из программы введите STOP");
                return false;
        }
    }
}