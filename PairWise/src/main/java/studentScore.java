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

