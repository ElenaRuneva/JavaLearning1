package day11.task1;

public class Warehouse {
    private int countPickedOrders;
    private int countDeliveredOrders;
    private int pickerBonusRate;    //допустим, ставки могут меняться по ходу программы
    private int courierBonusRate;
    private int pickerSalaryRate;
    private int courierSalaryRate;
    public final int COURIER_BONUS_ORDERS_LEVEL;
    public final int PICKER_BONUS_ORDERS_LEVEL;
    public int getCountDeliveredOrders(){
        return countDeliveredOrders;
    }
    public int getCountPickedOrders(){
        return countPickedOrders;
    }
    public void pickOrder(){
        this.countPickedOrders ++;
    }
    public void deliverOrder(){
        this.countDeliveredOrders ++;
    }
    public int getPickerBonusRate(){
        return this.pickerBonusRate;
    }
    public int getCourierBonusRate(){
        return this.courierBonusRate;
    }
    public int getPickerSalaryRate(){
        return this.pickerSalaryRate;
    }
    public int getCourierSalaryRate(){
        return courierSalaryRate;
    }
    public String toString(){
        return "Warehouse: picked orders = "+this.getCountPickedOrders()+"; delivered orders = "+this.getCountDeliveredOrders();
    }
    public Warehouse(int pickerSalaryRate, int pickerBonusRate, int PICKER_BONUS_ORDERS_LEVEL, int courierSalaryRate, int courierBonusRate, int COURIER_BONUS_ORDERS_LEVEL){
        //количество заказов и доставок у нового склада = 0
        this.courierBonusRate = courierBonusRate;
        this.courierSalaryRate = courierSalaryRate;
        this.pickerBonusRate = pickerBonusRate;
        this.pickerSalaryRate = pickerSalaryRate;
        this.PICKER_BONUS_ORDERS_LEVEL = PICKER_BONUS_ORDERS_LEVEL;
        this.COURIER_BONUS_ORDERS_LEVEL = COURIER_BONUS_ORDERS_LEVEL;
    }
}
