package model;

import java.util.List;
import java.util.Random;

public class Area {
    private Integer id;
    private String title;
    private List<Project> projects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Project returnRandomProject() {
        if (projects.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(projects.size());
        return projects.get(index);
    }
}
