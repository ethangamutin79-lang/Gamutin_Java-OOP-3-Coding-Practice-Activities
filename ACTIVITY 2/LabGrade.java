/**
 *
 * @author ethan
 */
public class LabGrade {

    private String studentName;
    private int quizScore;
    private int labScore;

    // Constructor
    public LabGrade(String studentName, int quizScore, int labScore) {
        this.studentName = studentName;

        if (quizScore >= 0 && quizScore <= 100) {
            this.quizScore = quizScore;
        } else {
            this.quizScore = 0;
        }

        if (labScore >= 0 && labScore <= 100) {
            this.labScore = labScore;
        } else {
            this.labScore = 0;
        }
    }

    // Update scores
    public boolean updateScores(int quizScore, int labScore) {
        if (quizScore >= 0 && quizScore <= 100 &&
            labScore >= 0 && labScore <= 100) {

            this.quizScore = quizScore;
            this.labScore = labScore;
            return true;
        } else {
            return false;
        }
    }

    // Calculate final grade
    public double getFinalGrade() {
        return (quizScore * 0.40) + (labScore * 0.60);
    }

    // Check if passing
    public boolean isPassing() {
        return getFinalGrade() >= 75.0;
    }

    // Main method
    public static void main(String[] args) {

        LabGrade ana = new LabGrade("Ana", 80, 90);
        LabGrade ben = new LabGrade("Ben", 101, 85);

        System.out.println("Ana: " + ana.getFinalGrade() + "; Passing: " + ana.isPassing());
        System.out.println("Ben: " + ben.getFinalGrade() + "; Passing: " + ben.isPassing());

        // Update Ana's scores to 95 and 101
        System.out.println(ana.updateScores(95, 101));
        System.out.println("Ana's grade: " + ana.getFinalGrade());

        // Update Ana’s scores to 74 and 75
        System.out.println(ana.updateScores(74, 75));
        System.out.println("Ana’s grade: " + ana.getFinalGrade() + "; Passing: " + ana.isPassing());

        // Update Ana’s scores to 75 and 75
        System.out.println(ana.updateScores(75, 75));
        System.out.println("Ana’s grade: " + ana.getFinalGrade() + "; Passing: " + ana.isPassing());

        // Check Ben’s record again
        System.out.println("Ben’s grade: " + ben.getFinalGrade() + "; Passing: " + ben.isPassing());
    }
}
//ACTIVITY 3 Q&A
//Q1. Why must you validate both new scores before assigning either one?
//Both scores must be checked first to make sure they are valid before changing the old scores. This 
//prevents one score from being updated while the other is invalid and keeps the original grades 
//unchanged if the update fails.
