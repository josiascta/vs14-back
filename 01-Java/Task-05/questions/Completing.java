package task05.questions;

public class Completing extends Question {
    private String secretWord;

    public Completing(String statement, String answer, int score, String secretWord) {
        super(statement, answer, score);
        this.secretWord = secretWord;
    }

    public Completing(String statement, int score, String secretWord) {
        super(score, statement);
        this.secretWord = secretWord;
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.equals(secretWord);
    }
}
