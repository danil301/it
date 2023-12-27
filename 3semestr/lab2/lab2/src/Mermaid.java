public abstract class Mermaid extends Monster{

    public Mermaid()
    {
        super("Русалка", 100, 100, 100,false);
    }
    public Mermaid(String name, int hp, int lvl, int attack, boolean ShowInf) {
        super(name, hp, lvl, attack, ShowInf);
    }

    public abstract void Move();

    public abstract void Attack();
}
