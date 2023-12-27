public abstract class Dragon extends Monster{


    public Dragon(String name, int hp, int lvl, int attack, boolean ShowInf) {
        super(name, hp, lvl, attack, ShowInf);
    }

    public Dragon()
    {
        super("Дракон", 100, 100, 100, false);
    }

    public abstract void Move();

    public abstract void Attack();
}
