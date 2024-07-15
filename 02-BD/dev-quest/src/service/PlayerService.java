package service;

import exceptions.DatabaseException;
import model.Player;
import repository.PlayerRepository;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService() {
        playerRepository = new PlayerRepository();
    }

    public Player store(Player player) {
        Player newPlayer = new Player();
        try {
            newPlayer = playerRepository.store(player);
            System.out.println("Player adicinado com sucesso! " + newPlayer);
        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("TRACE: ");
            e.printStackTrace();
        }
        return newPlayer;
    }

    public List<Player> findByNickname(String nickname) {
        List<Player> players = new ArrayList<>();
        try {
            players = playerRepository.findByNickname(nickname);
        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("TRACE: ");
            e.printStackTrace();
        }
        return players;
    }

    public void updatePlayer(Player player) {
        Player updatedPlayer = new Player();
        try {
            playerRepository.updatePlayer(player);
            System.out.println("Player atualizado com sucesso! " + player);
        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("TRACE: ");
            e.printStackTrace();
        }
    }

    public List<Player> findAll() {
        List<Player> players = new ArrayList<>();
        try {
            players = playerRepository.findAll();
        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("TRACE: ");
            e.printStackTrace();
        }
        return players;
    }

    public void addCompletedProject(Integer playerId, Integer projectId) {
        try {
            playerRepository.addCompletedProject(playerId, projectId);
            System.out.println("Player_Project atualizado com sucesso!");
        } catch (DatabaseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            System.out.println("TRACE: ");
            e.printStackTrace();
        }
    }
}
