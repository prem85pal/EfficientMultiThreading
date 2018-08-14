package LambdaBenifit;

public class MainClass {

    public static void main(String[] args) {


        TaskComparator taskComparator = (int a1, int a2) -> {
            return a1 > a2;
        };

        boolean result = taskComparator.compare(5, 6);

        System.out.println(result);
    }

}
