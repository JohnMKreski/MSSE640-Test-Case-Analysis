import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Student Score: ");
        double score = in.nextDouble();

        String result = studentScore.evaluateScore(score);

        // Call the method from studentScore if validScore is true and print result
        if (studentScore.validScore(score)) {
            System.out.println("Student's completion status: " + result);
        } else {
            System.out.println(result);
            System.out.println("Please enter a value between 0 and 100.");

        }


        in.close(); // good practice to close the scanner
    }
}

