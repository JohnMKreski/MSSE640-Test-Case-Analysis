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

    // Rule 2 – Score between 0–49 → FAILING
    @Test
    public void testRule2_ValidFailingScore() {
        double score = 30;
        assertTrue(studentScore.validScore(score));
        assertEquals("Student FAILED", studentScore.evaluateScore(score));
    }

    // Rule 3 – Score between 50–100 → PASSING
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
