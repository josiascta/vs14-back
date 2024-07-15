package task05.questions;

public abstract class Question {
    private String statement;
    private String answer;
    private int score;

    public Question(String statement, String answer, int score) {
        this.statement = statement;
        this.answer = answer;
        this.score = score;
    }

    public Question(int score, String statement) {
        this.score = score;
        this.statement = statement;
    }

    public String getStatement() {
        return statement;
    }

    public String getAnswer() {
        return answer;
    }

    public int getScore() {
        return score;
    }

    public abstract boolean checkAnswer(String answer);
}
