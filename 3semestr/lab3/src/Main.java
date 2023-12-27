// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        CarTable carTable = new CarTable();
        System.out.println(carTable.isEmpty());
        System.out.println(carTable.size());

        Car car1 = new Car("Dodge", "Daytona", 1989);
        carTable.put("123H", car1);
        Car car2 = new Car("McLaren", "720S", 2017);
        carTable.put("213K", car2);

        System.out.println(carTable.size());
        System.out.println(carTable.get("123H").Model);
        System.out.println(carTable.isEmpty());
        carTable.remove("123H");
        System.out.println(carTable.size());

    }
}