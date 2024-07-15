package repository;

import exceptions.DatabaseException;
import model.Player;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PlayerRepository {

    public Integer getNextId(Connection connection) throws SQLException {
        String sql = "SELECT SEQ_PLAYER.nextval mysequence from DUAL";

        Statement stmt = connection.createStatement();
        ResultSet res = stmt.executeQuery(sql);

        if (res.next()) {
            return res.getInt("mysequence");

        }
        return null;
    }

    public Player store(Player player) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            Integer nextId = this.getNextId(con);
            player.setId(nextId);

            String sql = "INSERT INTO PLAYER\n" +
                    "(ID, NICKNAME, SCORE)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, player.getId());
            stmt.setString(2, player.getNickname());
            stmt.setInt(3, player.getScore());

            int res = stmt.executeUpdate();
            System.out.println("adicionarPlayer.res=" + res);
            return player;
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

    public List<Player> findByNickname(String nickname) throws DatabaseException {
        List<Player> players = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = "SELECT * " +
                    "       FROM PLAYER " +
                    "      WHERE NICKNAME = ? ";

            // Executa-se a consulta
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nickname);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Player player = getPlayerFromResultSet(res);
                players.add(player);
            }
            return players;
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

    private Player getPlayerFromResultSet(ResultSet res) throws SQLException {
        Player player = new Player();
        player.setId(res.getInt("ID"));
        player.setNickname(res.getString("NICKNAME"));
        player.setScore(res.getInt("SCORE"));
        return player;
    }

    public void updatePlayer(Player player) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = "UPDATE PLAYER SET NICKNAME = ?, SCORE = ? WHERE ID = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, player.getNickname());
            stmt.setInt(2, player.getScore());
            stmt.setInt(3, player.getId());

            int res = stmt.executeUpdate();
            System.out.println("updatePlayer.res=" + res);

            if (res == 0) {
                throw new DatabaseException("Player ID: " + player.getId() + "não encontrado");
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

    public void deletePlayer(Player player) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = "DELETE FROM PLAYER WHERE ID = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, player.getId());

            int res = stmt.executeUpdate();
            System.out.println("deletePlayer.res=" + res);

            if (res == 0) {
                throw new DatabaseException("Player ID: " + player.getId() + " não encontrado");
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

    public List<Player> findAll() throws DatabaseException {
        List<Player> players = new ArrayList<>();
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = "SELECT * " +
                    "       FROM PLAYER " +
                    "       ORDER BY SCORE DESC";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet res = stmt.executeQuery();

            while (res.next()) {
                Player player = getPlayerFromResultSet(res);
                players.add(player);
            }
            return players;
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

    public void addCompletedProject(Integer playerId, Integer projectId) throws DatabaseException {
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();

            String sql = "INSERT INTO PLAYER_PROJECT\n" +
                    "(PLAYER_ID, PROJECT_ID, COMPLETED_AT)\n" +
                    "VALUES(?, ?, ?)\n";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, playerId);
            stmt.setInt(2, projectId);
            stmt.setDate(3, java.sql.Date.valueOf(LocalDate.now()));

            int res = stmt.executeUpdate();
            System.out.println("adicionarPlayerProject.res=" + res);
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
