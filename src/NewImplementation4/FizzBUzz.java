package NewImplementation4;

import java.util.Scanner;

public class FizzBUzz {

    public static void main(String args[]) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        int N = Integer.parseInt(input.nextLine().trim());
        for (int c = 1; c < N; c++) {
            if (c % 3 == 0 && c % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (c % 3 == 0) {
                System.out.println("Fizz");
            } else if (c % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(c);
            }
        }
    }
}
