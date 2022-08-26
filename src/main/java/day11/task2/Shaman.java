package day11.task2;

public class Shaman extends Hero implements MagicAttack, Healer{
    private int magicAtt;

    public void physicalAttack(Hero hero){
        hero.changeHealth(-(int)(Math.round((this.physAtt) * (1-hero.getPhysDef()/100.0))));
    }
    public void magicalAttack(Hero hero){
        hero.changeHealth(-(int)(Math.round(this.magicAtt * (1-hero.getMagicDef()/100.0))));
    }

    public void healHimself(){
        int heal = 50;
        this.changeHealth(heal);
    }
    public void healTeammate(Hero hero){
        int heal = 30;
        hero.changeHealth(heal);
    }
    public String toString(){
        return "Shaman {health="+this.health+"}";
    }
    public Shaman(){
        this.physAtt = 10;
        this.magicAtt = 15;
        this.physDef = 20;
        this.magicDef = 20;
    }
}
