import java.util.Scanner;

public class ex5 {
    public static void main(String argcs[]) {
        System.out.println("> Enter the factorial you want! <");
        Scanner keywords = new Scanner(System.in);

        int value = 1;
        int foo = Integer.parseInt(keywords.nextLine());
        for(int i = 1; foo != 1; i++) {

            value *= foo;
            --foo;

        }
        System.out.println(value);
    }
}
