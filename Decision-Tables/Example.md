# Decision Tables — Student Score Evaluation

This project demonstrates the **Decision Table Testing** technique using the same student score evaluation program introduced in the Equivalence Class Partitioning (ECP) and Boundary Value Analysis (BVA) examples. Decision tables help define and validate the program's behavior based on logical combinations of input conditions.

---

## Test Classes in This Program

This Java project includes one dedicated JUnit 5 test class for Decision Table testing:

### `studentScoreDTTest.java`
Tests based on **Decision Table rules**, ensuring each combination of input conditions results in the correct output: PASS, FAIL, or INVALID.

---

## Decision Table Logic

The decision table below defines the different outcomes of the student score program based on input score conditions:

| Condition                            | Rule 1 | Rule 2 | Rule 3 | Rule 4 |
|-------------------------------------|--------|--------|--------|--------|
| Score < 0                           |   Y    |   N    |   N    |   N    |
| Score between 0 and 49 (inclusive)  |   N    |   Y    |   N    |   N    |
| Score between 50 and 100 (inclusive)|   N    |   N    |   Y    |   N    |
| Score > 100                         |   N    |   N    |   N    |   Y    |
| **Action**                          | Invalid | Fail   | Pass   | Invalid |

Each rule represents a distinct scenario, and the output reflects the correct result the program should return.

---

## Program Logic

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

### `studentScoreDTTest.java`
```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class studentScoreDTTest {

    // Rule 1 – Score < 0 → Invalid
    @Test
    public void testRule1_InvalidLowScore() {
        double score = -5;
        assertFalse(studentScore.validScore(score));
        assertEquals("Invalid score.", studentScore.evaluateScore(score));
    }

    // Rule 2 – Score 0–49 → FAILING
    @Test
    public void testRule2_ValidFailingScore() {
        double score = 30;
        assertTrue(studentScore.validScore(score));
        assertEquals("Student FAILED", studentScore.evaluateScore(score));
    }

    // Rule 3 – Score 50–100 → PASSING
    @Test
    public void testRule3_ValidPassingScore() {
        double score = 85;
        assertTrue(studentScore.validScore(score));
        assertEquals("Student PASSED", studentScore.evaluateScore(score));
    }

    // Rule 4 – Score > 100 → Invalid
    @Test
    public void testRule4_InvalidHighScore() {
        double score = 120;
        assertFalse(studentScore.validScore(score));
        assertEquals("Invalid score.", studentScore.evaluateScore(score));
    }
}
```

---

For more detailed implementations, refer to the ECP and BVA example files in the same repository.

