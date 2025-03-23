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