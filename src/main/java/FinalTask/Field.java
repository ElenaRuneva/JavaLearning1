package FinalTask;

public class Field {
    private BoxStatus[][] boxes;

    //создать поле заданного размера, заполнить все ячейки статусом SEA
    public Field(int size) {
        boxes = new BoxStatus[size][size];
        for (int i=0; i<size; i++) {
            for (int j = 0; j<size; j++)
                boxes[i][j] = BoxStatus.SEA;
        }
    }
    //возвращает 1 - ОК, корабль можно добавить и он был добавлен
    // -1 - некорректные координаты (корабль угловой или в координатах есть промежутки или отрицательные координаты)
    // -2 - внесенная координата уже занята
    // -3 - нарушен ореол
    public static int addBoat(int[] x, int[] y, Field field){ //одна из координат - x или y - заполнена одинаковым значением
        if (x.length != y.length)
            return -1;

        //допустить неправильный порядок координат - проверить, что все необходимые координаты внесены:
        //найти минимальное и максимальное значение -->
        //через разность max-min и сумму всех координат проверить, что корабль непрерывный и не угловой
        int min_x = field.getSize()-1;
        int max_x = 0;
        int min_y = field.getSize()-1;
        int max_y = 0;
        int sum_x = 0;
        int sum_y = 0;
        for (int i=0; i<x.length; i++){
            if (x[i]<min_x)
                min_x = x[i];
            if (x[i]>max_x)
                max_x = x[i];
            if (y[i]<min_y)
                min_y = y[i];
            if (y[i]>max_y)
                max_y = y[i];
            sum_x += x[i];
            sum_y += y[i];
        }

        if (min_x < 0 || max_x > field.getSize()-1 || min_y < 0 || max_y > field.getSize()-1)
            return -1;
        if (!(min_x == max_x) && !(min_y == max_y))
            return -1;

        if ((! ((max_x - min_x + 1) == x.length)) && (! ((max_y - min_y + 1) == x.length)))
            return -1;

        if (min_x == max_x) {
            if (!(min_x * x.length == sum_x))
                return -1;
        }
        else if (!((max_x+min_x)*(max_x-min_x+1)/2 == sum_x))
            return -1;

        if (min_y == max_y) {
            if (!(min_y * y.length == sum_y))
                return -1;
        }
        else if (!((max_y+min_y)*(max_y-min_y+1)/2 == sum_y))
            return -1;

        //проверить, что все клетки свободны
        for (int i=0; i<x.length; i++){
            if (field.getBoxStatus(x[i], y[i]) != BoxStatus.SEA)
                return -2;
        }
        //клетки самого корабля проверяются повторно, но при таких объемах вычислений это не имеет значения
        for (int x_oreol=Math.max(min_x-1,0); x_oreol<=Math.min(max_x+1, field.getSize()-1); x_oreol++){
            for (int y_oreol=Math.max(min_y-1,0); y_oreol<=Math.min(max_y+1, field.getSize()-1); y_oreol++){
                if (field.getBoxStatus(x_oreol, y_oreol) != BoxStatus.SEA)
                    return -3;
             }
        }
        //все ок, установить статусы на поле
        for (int i=0; i<x.length; i++){
            field.setBoxStatus(BoxStatus.BOAT_WHOLE, x[i], y[i]);
        }
        return 1;
    }
    public void setBoxStatus(BoxStatus status, int x, int y){
        this.boxes[x][y] = status;
    }
    public BoxStatus getBoxStatus(int x, int y){
        return this.boxes[x][y];
    }
    public int getSize(){
        return boxes.length;
    }
    public void print(){
        //все значки имеют разный размер, даже белый меньше остальных, поле не выводится в виде ровного квадрата,
        //поэтому я использую одинаковые картинки для всех типов клеток - разноцветные квадраты
        //коричневый - целый корабль, красный - подбитый, фиолетовый - ореол, зеленый - море
        int fieldSize = getSize();
        for (int i=0; i<fieldSize; i++){
            for (int j=0; j<fieldSize; j++){
                if (getBoxStatus(i, j) == BoxStatus.SEA) {
                    boolean isOreol = false;
                    //проверить соседние клетки - определить статус ореол
                    for (int l = Math.max(0, i-1); l <= Math.min(fieldSize-1, i+1); l++) {
                        for (int k = Math.max(0, j-1); k <= Math.min(fieldSize-1, j+1); k++) {
                            if (getBoxStatus(l, k) != BoxStatus.SEA){
                                isOreol = true;
                                System.out.print("\uD83D\uDFEA");   //ореол
                                break;
                            }
                        }
                        if (isOreol)
                            break;
                    }
                    if (! isOreol)
                        System.out.print("\uD83D\uDFE9");  //пустое поле
                }
                else if (getBoxStatus(i, j) == BoxStatus.BOAT_WHOLE)    //целый корабль или его часть
                    System.out.print("\uD83D\uDFEB");
                else if (getBoxStatus(i, j) == BoxStatus.BOAT_SHOT) //подбитый корабль или его часть
                    System.out.print("\uD83D\uDFE5");
            }
            System.out.print("\n");
        }
    }
}
