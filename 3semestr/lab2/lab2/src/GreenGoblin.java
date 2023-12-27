public class GreenGoblin extends Goblin{
    public GreenGoblin(){
        super("Зеленый гоблин", 100, 100, 100, 100,false);
    }

    public GreenGoblin(String name, int hp, int lvl, int attack, int armor, boolean showinf)
    {
        super(name, hp, lvl, attack, armor, showinf);
    }
    @Override
    public void Move() {
        System.out.printf(this.getName() + " идёт");
    }

    @Override
    public void Attack() {
        System.out.printf(this.getName() + " ыыатакует");
    }
}
