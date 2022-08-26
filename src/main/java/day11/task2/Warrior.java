package day11.task2;

public class Warrior extends Hero {

    public void physicalAttack(Hero hero){
        hero.changeHealth(-(int)(Math.round(this.physAtt * (1-hero.getPhysDef()/100.0))));
    }
    public String toString(){
        return "Warrior {health="+this.health+"}";
    }
    public Warrior(){
        this.physAtt = 30;
        this.physDef = 80;
        this.magicDef = 0;
    }
}
