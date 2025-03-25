import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class studentScoreTest {

    /*
                    ECP Test Cases
     */

    // Class 1 – Valid (Fail)
    @Test
    public void testValidFailingScore() {
        System.out.println("Testing if 25 is valid.");
        assertTrue(studentScore.validScore(25));
        assertEquals("Student FAILED", studentScore.evaluateScore(25));
    }

    // Class 2 – Valid (Pass)
    @Test
    public void testValidPassingScore() {
        System.out.println("Testing if 75 is valid");
        assertTrue(studentScore.validScore(75));
        assertEquals("Student PASSED", studentScore.evaluateScore(75));
    }

    // Class 3 – Invalid (<0)
    @Test
    public void testInvalidLowScore() {
        System.out.println("Testing if -10 is invalid");
        assertFalse(studentScore.validScore(-10));
        assertEquals("Invalid score.", studentScore.evaluateScore(-10));
    }

    // Class 4 – Invalid (>100)
    @Test
    public void testInvalidHighScore() {
        System.out.println("Testing if 150 is invalid");
        assertFalse(studentScore.validScore(150));
        assertEquals("Invalid score.", studentScore.evaluateScore(150));
    }

    /* ==============================================
                    BVA Test Cases
     ================================================ */

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