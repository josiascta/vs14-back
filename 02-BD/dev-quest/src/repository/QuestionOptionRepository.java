package repository;

import exceptions.DatabaseException;
import model.QuestionOption;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionOptionRepository {

    public List<QuestionOption> findByQuestionId(Integer questionId) throws DatabaseException {
        List<QuestionOption> questionOptions = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = " SELECT * " +
                    "     FROM QUESTION_OPTION " +
                    "     WHERE QUESTION_ID = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, questionId);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                QuestionOption questionOption = getProjectFromResultSet(res);
                questionOptions.add(questionOption);
            }

            return questionOptions;
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

    private QuestionOption getProjectFromResultSet(ResultSet res) throws SQLException {
        QuestionOption questionOption = new QuestionOption();
        questionOption.setId(res.getInt("ID"));
        questionOption.setText(res.getString("TEXT"));
        questionOption.setCorrect(res.getInt("CORRECT"));
        return questionOption;
    }
}
