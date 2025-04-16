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
