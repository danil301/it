public abstract class Monster {
    private String Name;
    private int HP;

    private int LVL;

    private int Attack;

    private static int counter;

    public Monster(String name, int hp, int lvl, int attack, boolean ShowInf)
    {
        this.Name = name;
        this.HP = hp;
        this.LVL = lvl;
        this.Attack = attack;
        counter++;
        if (ShowInf) ShowMonsterStatus();
    }

    public String getName() { return Name; }
    public void setName(String name) { this.Name = name; }

    public int GetHp() { return HP; }
    public void SetHp(int hp) { this.HP = hp; }

    public int GetLvl() { return LVL; }
    public void SetLvl(int lvl) { this.LVL = lvl; }


    private void ShowMonsterStatus()
    {
        System.out.println("Name: " + Name);
        System.out.println("HP: " + HP);
        System.out.println("LVL: " + LVL);
        System.out.println("Создано монстров: " + counter);
    }

    public abstract void Move();
    public abstract void Attack();
}
