package model;

import java.util.List;

public class Question {
    private Integer id;
    private String statement;
    private String answerSecretWord;
    private Integer score;
    private Project project;
    private QuestionType questionType;
    private List<QuestionOption> questionOptions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getAnswerSecretWord() {
        return answerSecretWord;
    }

    public void setAnswerSecretWord(String answerSecretWord) {
        this.answerSecretWord = answerSecretWord;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public void setQuestionType(QuestionType questionType) {
        this.questionType = questionType;
    }

    public List<QuestionOption> getQuestionOptions() {
        return questionOptions;
    }

    public void setQuestionOptions(List<QuestionOption> questionOptions) {
        this.questionOptions = questionOptions;
    }
}
