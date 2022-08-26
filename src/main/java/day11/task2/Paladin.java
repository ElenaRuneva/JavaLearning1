package day11.task2;

public class Paladin extends Hero implements Healer {
    public void physicalAttack(Hero hero){
        //(геттер для physAtt не добавлен для экономии времени, т.к. обращение идет только внутри класса)
        hero.changeHealth(-(int)(Math.round(this.physAtt * (1-hero.getPhysDef()/100.0))));
    }
    public void healHimself(){
        //ВОПРОС
        //как корректно хранить норматив лечения - в константе этого героя или в переменной?
        int heal = 25;
        this.changeHealth(heal);
    }
    public void healTeammate(Hero hero){
        int heal = 10;
        hero.changeHealth(heal);
    }
    public String toString(){
        return "Paladin {health="+this.health+"}";
    }
    public Paladin(){
        this.physAtt = 15;
        this.physDef = 50;
        this.magicDef = 20;
    }
}
