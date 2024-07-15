package task05;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
    private String nickname;
    private int score;
    private Project currentProject;
    private LinkedList<Project> completedProjects;

    public Player(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
        completedProjects = new LinkedList<>();
    }

    public LinkedList<Project> getCompletedProjects() {
        return completedProjects;
    }

    public void setCompletedProjects(LinkedList<Project> completedProjects) {
        this.completedProjects = completedProjects;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public void addCompletedProject (Project project) {
        completedProjects.add(project);
    }
}
