
public class Main {
    public static void main(String[] args) {

        FireDragon fd = new FireDragon();
        fd.Attack();
        System.out.println("");

        BlueMermaid bm = new BlueMermaid();
        bm.Move();
        System.out.println("");

        GreenGoblin grg = new GreenGoblin("Зеленый гоблин", 100, 100, 22,100, true);
        grg.Move();
    }
}