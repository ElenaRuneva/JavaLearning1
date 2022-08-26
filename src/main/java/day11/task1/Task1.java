package day11.task1;

public class Task1 {
    public static void main(String[] args) {
        Warehouse wh1 = new Warehouse(80, 70000, 10000,100, 50000, 10000);
        Picker picker1 = new Picker(wh1,0, false);
        Courier courier1 = new Courier(wh1, 0, false);
        System.out.println("_______WAREHOUSE 1_______");
        businessProcess(picker1);
        businessProcess(courier1);
        System.out.println(wh1);
        System.out.println(picker1);
        System.out.println(courier1);

        System.out.println("_______WAREHOUSE 2_______");
        Warehouse wh2 = new Warehouse(80, 70000, 10000,100, 50000, 10000);
        Picker picker2 = new Picker(wh2,0, false);
        Courier courier2 = new Courier(wh2, 0, false);
        picker2.doWork();
        courier2.doWork();
        picker2.bonus();
        courier2.bonus();
        System.out.println(wh2);
        System.out.println(picker2);
        System.out.println(courier2);

        System.out.println("_______WAREHOUSE 1 AFTER WAREHOUSE 2 WAS ADDED_______");
        System.out.println(wh1);
    }
    static void businessProcess(Worker worker){
        for (int i=0; i<10000; i++)
            worker.doWork();
        worker.bonus();
    }
}
