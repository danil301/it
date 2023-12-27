public abstract class Goblin extends Monster{
    private int Armor;

    public Goblin()
    {
        super("Гоблин",  100, 20, 100, false);
        Armor = 0;
    }

    public Goblin(String name, int hp, int lvl, int attack, int armor, boolean showinf)
    {
        super(name, hp, lvl, attack, showinf);
        Armor = armor;
    }

    public int GetArmor() { return Armor; }
    public void SetArmor(int armor) { Armor = armor; }

    public abstract void Move();

    public abstract void Attack();
}
