public class FireDragon extends Dragon{
    public FireDragon()
    {
        super("Огненный дракон", 100, 100, 100, false);
    }

    @Override
    public void Move() {
        System.out.printf(this.getName() + " летит");
    }

    @Override
    public void Attack() {
        System.out.printf(this.getName() + " атакует");
    }

    public FireDragon(String name, int hp, int lvl, int attack, boolean showinf)
    {
        super(name, hp, lvl, attack, showinf);
    }
}
