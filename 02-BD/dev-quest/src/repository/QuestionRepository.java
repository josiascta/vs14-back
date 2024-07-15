package repository;

import exceptions.DatabaseException;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {

    public List<Question> findByProjectId(Integer projectId) throws DatabaseException {
        List<Question> questions = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = " SELECT * " +
                    "     FROM QUESTION " +
                    "     WHERE PROJECT_ID = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, projectId);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Question question = getQuestionFromResultSet(res);
                questions.add(question);
            }

            return questions;
        } catch (SQLException e) {
            throw new DatabaseException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Question getQuestionFromResultSet(ResultSet res) throws SQLException {
        Question question = new Question();
        question.setId(res.getInt("ID"));
        question.setStatement(res.getString("STATEMENT"));
        question.setAnswerSecretWord(res.getString("ANSWER_SECRET_WORD"));
        question.setScore(res.getInt("SCORE"));
        question.setQuestionType(QuestionType.ofTipo(res.getInt("QUESTION_TYPE_ID")));
        return question;
    }

    public void deleteQuestion(Question question) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = "DELETE FROM QUESTION WHERE ID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, question.getId());

            int res = stmt.executeUpdate();
            System.out.println("deleteQuestion.res=" + res);

            if (res == 0) {
                throw new DatabaseException("Question ID: " + question.getId() + " não encontrado");
            }
        } catch (SQLException e) {
            throw new DatabaseException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateQuestion(Question question) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = "UPDATE QUESTION SET STATEMENT = ?, answerSecretWord = ?, score = ?, project = ?, questionType = ?, questionOptions = ? WHERE ID = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, question.getStatement());
            stmt.setString(2, question.getAnswerSecretWord());
            stmt.setInt(3, question.getScore());
            stmt.setObject(4, question.getProject());
            stmt.setObject(5, question.getQuestionType());
            stmt.setObject(6, question.getQuestionOptions());

            int res = stmt.executeUpdate();
            System.out.println("updateQuestion.res=" + res);

            if (res == 0) {
                throw new DatabaseException("Question ID: " + question.getId() + "não encontrado");
            }
        } catch (SQLException e) {
            throw new DatabaseException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Integer getNextId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_QUESTION.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");

        }
        return null;
    }

    public Question store(Question question) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            Integer nextId = this.getNextId(con);
            question.setId(nextId);

            String sql = "INSERT INTO Question\n" +
                    "(id, statement, answer_Secret_Word, score, project_id, question_Type_id)\n" +
                    "VALUES(?, ?, ?, ?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, question.getId());
            stmt.setString(2, question.getStatement());
            stmt.setString(3, question.getAnswerSecretWord());
            stmt.setInt(4, question.getScore());
            stmt.setInt(5, question.getProject().getId());
            stmt.setObject(6, question.getQuestionType());

            int res = stmt.executeUpdate();
            System.out.println("adicionarQuestion.res=" + res);
            return question;
        } catch (SQLException e) {
            throw new DatabaseException(e.getCause());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
