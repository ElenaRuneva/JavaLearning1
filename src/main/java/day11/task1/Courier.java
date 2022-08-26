package day11.task1;

public class Courier implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;
    public int getSalary(){
        return this.salary;
    }
    public boolean getIsPaid(){
        return this.isPayed;
    }
    @Override
    public void doWork(){
        this.salary += this.warehouse.getCourierSalaryRate();
        this.warehouse.deliverOrder();
    }
    @Override
    public void bonus(){
        if (this.getIsPaid()){
            System.out.println("Bonus was already paid to the courier");
            return;
        }
        if (this.warehouse.getCountDeliveredOrders()>=this.warehouse.COURIER_BONUS_ORDERS_LEVEL){
            this.isPayed = true;
            System.out.println("Bonus has been added to the courier account");
        }
        else
            System.out.println("Bonus is not available for couriers yet");
    }
    public String toString(){
        return "Courier: current salary = "+this.getSalary()+"; bonus was paid = "+this.getIsPaid();
    }
    public Courier(Warehouse warehouse, int salary, boolean isPaid){
        this.warehouse = warehouse;
        this.salary = salary;
        this.isPayed = isPaid;
    }

}
