# Pairwise Testing — Student Score Evaluation Example

This example demonstrates how the **Pairwise Testing** technique has been implemented in Java. The student score evaluation program has been extended to include a second input variable — `courseType` — to allow testing multiple combinations of inputs.

---

## Program Files

### `studentScore.java`
This class includes logic to evaluate whether a score is valid and determine if the student passes, fails, or receives an invalid result. A second overloaded method accepts a `courseType` input to enable Pairwise testing, though it does not affect the logic.

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

    public static String evaluateScore(double score, String courseType) {
        // For now, courseType doesn't change logic, but it's part of the test input
        return evaluateScore(score);
    }
}
```

---

### `studentScorePairwiseTest.java`
This test class verifies program behavior using five test cases that cover all combinations of the `score` and `courseType` input pairs.

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class studentScorePairwiseTest {

    @Test
    public void testInvalidLowScoreCoreCourse() {
        assertEquals("Invalid score.", studentScore.evaluateScore(-5, "Core"));
    }

    @Test
    public void testFailingScoreElectiveCourse() {
        assertEquals("Student FAILED", studentScore.evaluateScore(30, "Elective"));
    }

    @Test
    public void testPassingScoreCoreCourse() {
        assertEquals("Student PASSED", studentScore.evaluateScore(50, "Core"));
    }

    @Test
    public void testHighPassingScoreElectiveCourse() {
        assertEquals("Student PASSED", studentScore.evaluateScore(85, "Elective"));
    }

    @Test
    public void testInvalidHighScoreCoreCourse() {
        assertEquals("Invalid score.", studentScore.evaluateScore(120, "Core"));
    }
}
```

---

These test cases were chosen using **pairwise analysis** to ensure every pair of inputs is covered at least once, optimizing test coverage with minimal redundancy.

