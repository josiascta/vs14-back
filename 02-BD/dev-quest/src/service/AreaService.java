package service;

import exceptions.DatabaseException;
import model.Area;
import model.Project;
import model.Question;
import model.QuestionOption;
import repository.ProjectRepository;
import repository.QuestionOptionRepository;
import repository.QuestionRepository;

import java.util.List;

public class AreaService {
    private ProjectRepository projectRepository;
    private QuestionRepository questionRepository;
    private QuestionOptionRepository questionOptionRepository;

    public AreaService() {
        projectRepository = new ProjectRepository();
        questionRepository = new QuestionRepository();
        questionOptionRepository = new QuestionOptionRepository();
    }

    public Area findById(Integer id) {
        Area area = new Area();

        try {
            List<Project> projects = projectRepository.findByAreaId(id);

            for (Project project : projects) {
                List<Question> questions = questionRepository.findByProjectId(project.getId());

                for (Question question : questions) {
                    List<QuestionOption> questionOptions = questionOptionRepository.findByQuestionId(question.getId());

                    question.setQuestionOptions(questionOptions);
                }

                project.setQuestions(questions);

            }

            area.setProjects(projects);

            return area;

        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("TRACE: ");
            e.printStackTrace();
        }

        return area;
    }
}
