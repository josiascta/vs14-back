package task05.questions;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice extends Question {
    private List<String> options;

    public MultipleChoice(String statement, int answer, int score) {
        super(statement, String.valueOf(answer), score);
        options = new ArrayList<>();
    }

    public List<String> getOptions() {
        return options;
    }

    public void addOption(String option) {
        options.add(option);
    }

    @Override
    public boolean checkAnswer(String answer) {
        return answer.equals(this.getAnswer());
    }
}
