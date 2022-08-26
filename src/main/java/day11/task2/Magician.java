package day11.task2;

public class Magician extends Hero implements MagicAttack {
    private int magicAtt;

    //ВОПРОС
    //если логика метода physicalAttack одинакова для всех героев и если бы он точно был у всех героев,
    //то коррекно будет разместить этот метод в родительском классе?
    public void physicalAttack(Hero hero){
        //(геттер для physAtt не добавлен для экономии времени, т.к. обращение идет только внутри класса)
        //ВОПРОС
        //насколько корректно так приводить типы:
        hero.changeHealth(-(int)(Math.round(this.physAtt * (1-hero.getPhysDef()/100.0))));
    }
    public void magicalAttack(Hero hero){
        hero.changeHealth(-(int)(Math.round(this.magicAtt * (1-hero.getMagicDef()/100.0))));
    }
    public String toString(){
        return "Magician {health="+this.health+"}";
    }
    public Magician(){
        this.physAtt = 5;
        this.magicAtt = 20;
        this.physDef = 0;
        this.magicDef = 80;
    }
}
