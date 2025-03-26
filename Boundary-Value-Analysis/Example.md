# Boundary Value Analysis (BVA) — Student Score Evaluation

This project demonstrates the **Boundary Value Analysis** (BVA) testing technique using the same student score evaluation program introduced in the Equivalence Class Partitioning (ECP) [example](https://github.com/JohnMKreski/MSSE640-Test-Case-Analysis/blob/main/Equivalence-Class-Partitioning/Example.md). BVA focuses on testing values at and around the boundaries of defined input partitions to detect edge-related errors.

---

## BVA Focus: Boundary Points

The program's input domain is based on predefined equivalence classes:

| Class Type        | Input Range      | Expected Output |
|-------------------|------------------|------------------|
| Valid – Failing   | 0 to 49          | FAILING          |
| Valid – Passing   | 50 to 100        | PASSING          |
| Invalid – Low     | Less than 0      | Invalid score    |
| Invalid – High    | Greater than 100 | Invalid score    |

BVA test cases target these **boundary points**:
- Just below, at, and just above the **lower and upper bounds** of each valid class.
- Ensuring that values at the edges transition correctly between valid and invalid states.

---

## Summary

This project illustrates how Boundary Value Analysis provides deeper validation at the critical edges of input ranges. By selecting values such as `-1`, `0`, `49`, `50`, `100`, and `101`, we validate system behavior precisely where it’s most prone to boundary-related bugs.

---

## Program Implementation

The Java program remains the same as in the ECP example and includes two classes:

### `Main.java`
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Student Score: ");
        double score = in.nextDouble();

        String result = studentScore.evaluateScore(score);

        if (studentScore.validScore(score)) {
            System.out.println("Student's completion status: " + result);
        } else {
            System.out.println(result);
            System.out.println("Please enter a value between 0 and 100.");
        }

        in.close();
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

## BVA Unit Testing

Boundary Value Analysis targets edge conditions by testing values immediately **before, on, and after** class boundaries. Below are representative BVA test cases.

### `studentScoreTest.java`
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class studentScoreTest {

    /* --------------------------------------------------
            Failing Range (0, 49) BVA Test Cases
     ---------------------------------------------------- */

    /*
    ------------ Lower Bound (0) ----------------
    */

    // BLB1 - Just Below Lower Bound (0)
    @Test
    public void testScoreFailJustBelowLowerBound() {
        System.out.println("Testing if -1 is invalid (BLB1)");
        assertFalse(studentScore.validScore(-1));
        assertEquals("Invalid score.", studentScore.evaluateScore(-1));
    }

    // LB1 - Lower Bound (0)
    @Test
    public void testScoreFailAtLowerBound() {
        System.out.println("Testing if 0 is valid (LB1)");
        assertTrue(studentScore.validScore(0));
        assertEquals("Student FAILED", studentScore.evaluateScore(0));
    }

    // ALB1 - Just Above Lower Bound (0)
    @Test
    public void testScoreFailJustAboveLowerBound() {
        System.out.println("Testing if 1 is valid (ALB1)");
        assertTrue(studentScore.validScore(1));
        assertEquals("Student FAILED", studentScore.evaluateScore(1));
    }

    /*
    ------------ Upper Bound (49) ----------------
    */

    // BUB1 - Just Below Upper Bound for FAILING (49)
    @Test
    public void testScoreFailJustBelowUpperBound() {
        System.out.println("Testing if 48 is valid (BUB1)");
        assertTrue(studentScore.validScore(48));
        assertEquals("Student FAILED", studentScore.evaluateScore(48));
    }

    // UB1 - Upper Bound for FAILING (49)
    //UB1 === BLB2
    @Test
    public void testScoreFailAtUpperBound() {
        System.out.println("Testing if 49 is valid (UB1)");
        assertTrue(studentScore.validScore(49));
        assertEquals("Student FAILED", studentScore.evaluateScore(49));
    }

    // AUB1 - Just Above Fail Range (Start of PASS) (49)
    // AUB1 === LB2
    @Test
    public void testScoreFailJustAboveUpperBound() {
        System.out.println("Testing if 50 is valid (AUB1)");
        assertTrue(studentScore.validScore(50));
        assertEquals("Student PASSED", studentScore.evaluateScore(50));
    }

    /* ----------------------------------------------------------
                   Upper Bounds (50, 100) Test Cases
     ------------------------------------------------------------ */

    /*
    ------------ Lower Bound (50) ----------------
    */

    // BLB2 - Just Below Lower Bound (50)
    //BLB2 === UB1
    @Test
    public void testScorePassJustBelowLowerBound() {
        System.out.println("Testing if 49 is valid (BLB2)");
        assertTrue(studentScore.validScore(49));
        assertEquals("Student FAILED", studentScore.evaluateScore(49));
    }

    // LB2 - Lower Bound (0)
    // LB2 === AUB1
    @Test
    public void testScorePassAtLowerBound() {
        System.out.println("Testing if 50 is valid (LB2)");
        assertTrue(studentScore.validScore(50));
        assertEquals("Student PASSED", studentScore.evaluateScore(50));
    }

    // ALB2 - Just Above Lower Bound (0)
    @Test
    public void testScorePassJustAboveLowerBound() {
        System.out.println("Testing if 51 is valid (ALB2)");
        assertTrue(studentScore.validScore(51));
        assertEquals("Student PASSED", studentScore.evaluateScore(51));
    }

    /*
    ------------ Upper Bound (100) ----------------
    */

    // BUB2 - Just Below Upper Bound for PASSING (100)
    @Test
    public void testScorePassJustBelowUpperBound() {
        System.out.println("Testing if 99 is valid (BUB2)");
        assertTrue(studentScore.validScore(99));
        assertEquals("Student PASSED", studentScore.evaluateScore(99));
    }

    // UB2 - Upper Bound (100)
    @Test
    public void testScorePassAtUpperBound() {
        System.out.println("Testing if 100 is valid (UB2)");
        assertTrue(studentScore.validScore(100));
        assertEquals("Student PASSED", studentScore.evaluateScore(100));
    }

    // AUB2 - Just Above Upper Bound (100)
    @Test
    public void testScorePassJustAboveUpperBound() {
        System.out.println("Testing if 101 is invalid (AUB2)");
        assertFalse(studentScore.validScore(101));
        assertEquals("Invalid score.", studentScore.evaluateScore(101));
    }
}
```

---

This implementation supports comprehensive BVA test coverage and clearly demonstrates how boundary tests complement equivalence class tests by targeting the most error-prone values.



