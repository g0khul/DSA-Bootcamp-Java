public class Metric {
    float score;
    int numeratorSum;
    int denominatorSum;
    ArrayList<Integer> questionWindowNumerator;
    ArrayList<Integer> questionWindowDenominator;

    public Metric(float score, int numeratorSum, int denominatorSum, ArrayList<Integer> questionWindowNumerator,
            ArrayList<Integer> questionWindowDenominator) {
        this.score = score;
        this.numeratorSum = numeratorSum;
        this.denominatorSum = denominatorSum;
        this.questionWindowNumerator = questionWindowNumerator;
        this.questionWindowDenominator = questionWindowDenominator;
    }
}
