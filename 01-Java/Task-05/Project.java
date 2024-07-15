package task05;

import task05.questions.Question;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String title;
    private int maxErrors;
    private boolean completed;
    private int score;
    private List<Question> questions;

    public Project(String title, int maxErrors, boolean completed, int score) {
        this.title = title;
        this.maxErrors = maxErrors;
        this.completed = completed;
        this.score = score;
        questions = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public int getMaxErrors() {
        return maxErrors;
    }

    public int getScore() {
        return score;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
}
