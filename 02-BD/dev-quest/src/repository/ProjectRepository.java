package repository;

import exceptions.DatabaseException;
import model.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    public List<Project> findByAreaId(Integer areaId) throws DatabaseException {
        List<Project> projects = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = " SELECT * " +
                    "     FROM PROJECT " +
                    "     WHERE AREA_ID = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, areaId);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Project project = getProjectFromResultSet(res);
                projects.add(project);
            }

            return projects;
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

    private Project getProjectFromResultSet(ResultSet res) throws SQLException {
        Project project = new Project();
        project.setId(res.getInt("ID"));
        project.setTitle(res.getString("TITLE"));
        project.setMaxErrors(res.getInt("MAX_ERRORS"));
        project.setScore(res.getInt("SCORE"));
        return project;
    }

    public Project deleteProject(Project project) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "DELETE FROM PROJECT WHERE ID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, project.getId());
            stmt.executeUpdate();
            return project;
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

    public Project save(Project project) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "INSERT INTO PROJECT (TITLE, MAX_ERRORS, SCORE) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, project.getTitle());
            stmt.setInt(2, project.getMaxErrors());
            stmt.setInt(3, project.getScore());
            stmt.executeUpdate();
            return project;
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

    public Project update(Project project) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            String sql = "UPDATE PROJECT SET TITLE = ?, MAX_ERRORS = ?, SCORE = ? WHERE ID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, project.getTitle());
            stmt.setInt(2, project.getMaxErrors());
            stmt.setInt(3, project.getScore());
            stmt.setInt(4, project.getId());
            stmt.executeUpdate();
            return project;
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

