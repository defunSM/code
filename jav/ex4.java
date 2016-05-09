import java.util.Scanner;

public class ex4 {
    public static void main(String argcs[]) {
        Scanner keywords = new Scanner(System.in);
        int a = 19;
        double b = 3;
        double c = a / b;

        if (c == 6) {
            System.out.println("Yes.");
            System.out.println(c);
        } else {
            System.out.println("No");
            System.out.println(c);

        }
    }
}
