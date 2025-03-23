

# Equivalence Class Partitioning (ECP) — Student Score Evaluation

This project demonstrates the **Equivalence Class Partitioning** (ECP) testing technique using a simple Java program. It includes a scoring system that classifies student performance as **PASSING**, **FAILING**, or **INVALID**, based on the input value. The program is accompanied by unit tests built with **JUnit 5** to validate each equivalence class.

---

## Test Class Breakdown

For this program, the input domain is divided as follows:

| Class Type        | Input Range      | Expected Output |
|-------------------|------------------|------------------|
| Valid – Failing   | 0 to 49          | FAILING          |
| Valid – Passing   | 50 to 100        | PASSING          |
| Invalid – Low     | Less than 0      | Invalid score    |
| Invalid – High    | Greater than 100 | Invalid score    |

---

## Summary

This project highlights the effectiveness of Equivalence Class Partitioning for reducing test cases and improving testing efficiency. By selecting representative values from defined input ranges, we can confidently assess the correctness of program behavior with minimal redundancy.

---

## Program Implementation

The Java program consists of two classes:

### `Main.java`
```java
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
```

### `studentScore.java`
```java
public class studentScore {

    public static boolean validScore(double score) {
        return !(score < 0) && !(score > 100);
    }

    public static String evaluateScore(double score) {
        if (validScore(score)) {
            if (score >= 50) {
                return "Student PASSED";
            } else {
                return "Student FAILED";
            }
        } else {
            return "Invalid score.";
        }
    }
}
```

---

## ECP Unit Testing
If a condition of one partition is true, then the condition of another equal partition must also be true, and if a condition of one partition is false, then the condition of another equal partition must also be false.

### `studentScoreTest.java`
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class studentScoreTest {

    // Valid class: 0–49 → "FAILING"
    @Test
    public void testValidFailingScore() {
        System.out.println("Testing if 25 is valid.");
        assertTrue(studentScore.validScore(25));
        assertEquals("Student FAILED", studentScore.evaluateScore(25));
    }

    // Valid class: 50–100 → "PASSING"
    @Test
    public void testValidPassingScore() {
        System.out.println("Testing if 75 is valid");
        assertTrue(studentScore.validScore(75));
        assertEquals("Student PASSED", studentScore.evaluateScore(75));
    }

    // Invalid class: score < 0
    @Test
    public void testInvalidLowScore() {
        System.out.println("Testing if -10 is invalid");
        assertFalse(studentScore.validScore(-10));
        assertEquals("Invalid score.", studentScore.evaluateScore(-10));
    }

    // Invalid class: score > 100
    @Test
    public void testInvalidHighScore() {
        System.out.println("Testing if 150 is invalid");
        assertFalse(studentScore.validScore(150));
        assertEquals("Invalid score.", studentScore.evaluateScore(150));
    }
}
```

