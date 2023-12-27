public class BlueMermaid extends Mermaid{

    public BlueMermaid()
    {
        super("Синяя русалка", 100, 100, 100, false);
    }

    public BlueMermaid(String name, int hp, int lvl, int attack, boolean showinf)
    {
        super(name, hp, lvl, attack, showinf);
    }

    @Override
    public void Move() {
        System.out.printf(this.getName() + " плывёт");
    }

    @Override
    public void Attack() {
        System.out.printf(this.getName() + " атакует");
    }
}
