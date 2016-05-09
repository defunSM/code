import java.util.Scanner;

public class ex6 {
    public static void main(String argcs[]) {
        int result = 0;
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                result+=10;

            } else {
                result+=1;
            }
        }
        System.out.println(result);
    }
}
