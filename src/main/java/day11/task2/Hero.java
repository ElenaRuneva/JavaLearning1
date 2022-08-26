package day11.task2;

public abstract class Hero implements PhysAttack {
    //ПРИМЕЧАНИЕ, почему этот интерфейс здесь
    //возможно, оба интерфейса Attack надо было реализовывоть одинаково в классах всех героев,
    //т.к. сейчас у всех есть физ.атака, а потом появится новый герой без нее.
    //Я сделала по-разному, чтобы посмотреть интерфейс в абстрактном классе и как наследник реализует интерфейс, указанный в родителе.

    //ВОПРОС
    //корректно ли объявлять переменную в родителе, как protected, чтобы она работала в наследующих классах аналогично, как private,
    //т.е. чтобы извне к ней не было доступа?
    protected int physDef;
    protected int magicDef;
    protected int physAtt;

    //ВОПРОС
    //корректно ли присваивать эти значения прямо здесь или надо в конструкторе этого класса?
    public final int HEALTH_MIN = 0;
    public final int HEALTH_MAX = 100;
    protected int health = 100;

    public int getPhysDef(){
        return physDef;
    }
    public int getMagicDef(){
        return magicDef;
    }

    //ВОПРОС
    //этот метод точно одинаковый для всех героев, поэтому он реализуется в абстр. классе,
    //а не в интерфейсе - это корректная логика проектирования?
    public void changeHealth(int change){
        int newHealth = this.health + change;
        if (newHealth < this.HEALTH_MIN)
            this.health = this.HEALTH_MIN;
        else if (newHealth > this.HEALTH_MAX)
            this.health = this.HEALTH_MAX;
        else
            this.health = newHealth;
    }
}
