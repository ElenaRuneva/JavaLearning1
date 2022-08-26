package day11.task1;

public class Picker implements Worker{
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
        this.salary += this.warehouse.getPickerSalaryRate();
        this.warehouse.pickOrder();
    }

    @Override
    public void bonus() {
        if (this.getIsPaid()){
            System.out.println("Bonus was already paid to the picker");
            return;
        }
        if (this.warehouse.getCountPickedOrders()>=this.warehouse.PICKER_BONUS_ORDERS_LEVEL){
            this.isPayed = true;
            System.out.println("Bonus has been added to the picker account");
        }
        else
            System.out.println("Bonus is not available for pickers yet");
    }

    public String toString(){
        return "Picker: current salary = "+this.getSalary()+"; bonus was paid = "+this.getIsPaid();
    }
    public Picker(Warehouse warehouse, int salary, boolean isPaid){
        this.warehouse = warehouse;
        this.salary = salary;
        this.isPayed = isPaid;
    }
}
