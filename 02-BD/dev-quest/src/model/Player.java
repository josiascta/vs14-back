package model;

import java.util.LinkedList;

public class Player {
    private Integer id;
    private String nickname;
    private Integer score;
    private LinkedList<Project> completedProjects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void addCompletedProject (Project project) {
        completedProjects.add(project);
    }

    public LinkedList<Project> getCompletedProjects() {
        return completedProjects;
    }

}
