package innerclass;

public class MainClass {

    public static void main(String[] args) {

        Animal animal = new Animal() {
            @Override
            public void run() {
                System.out.println("10km/h");
            }
        };
        animal.run();

        new Animal() {
            @Override
            public void run() {
                System.out.println("30km/h");
            }
        }.run();
    }
}
