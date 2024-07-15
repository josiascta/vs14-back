package view;

import model.*;
import service.AreaService;
import service.PlayerService;

import java.util.List;
import java.util.Scanner;

public class Game {
    private static final Scanner sc = new Scanner(System.in);
    private static Player loggedPlayer = null;

    private static final PlayerService playerService = new PlayerService();
    private static final AreaService areaService = new AreaService();

    public static class TerminalColors {
        public static final String RESET = "\u001B[0m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
    }

    public void start() {
        boolean flag = true;
        while (flag) {
            try {
                System.out.println(TerminalColors.BLUE + """
                                         _______   ___________    ____        ______      __    __   _______     _______.___________.
                                        |       \\ |   ____\\   \\  /   /       /  __  \\    |  |  |  | |   ____|   /       |           |
                                        |  .--.  ||  |__   \\   \\/   / ______|  |  |  |   |  |  |  | |  |__     |   (----`---|  |----`
                                        |  |  |  ||   __|   \\      / |______|  |  |  |   |  |  |  | |   __|     \\   \\       |  |    \s
                                        |  '--'  ||  |____   \\    /         |  `--'  '--.|  `--'  | |  |____.----)   |      |  |    \s
                                        |_______/ |_______|   \\__/           \\_____\\_____\\\\______/  |_______|_______/       |__|    \s
                        """ + TerminalColors.RESET);
                System.out.println(TerminalColors.RED + "                                                  D E V - Q U E S T " + TerminalColors.RESET + TerminalColors.YELLOW + " V 1.2.0 by SouTeam" + TerminalColors.RESET);
                System.out.println(TerminalColors.BLUE + "                                          D" + TerminalColors.RESET + "evelopers " + TerminalColors.BLUE + " B" + TerminalColors.RESET + "uilding " + TerminalColors.BLUE + " C" + TerminalColors.RESET + "onnections");
                System.out.println("- Olá, seja bem-vindo(a) ao" + TerminalColors.RED + " Dev-Quest!!!" + TerminalColors.RESET);
                System.out.println("\n1." + TerminalColors.GREEN + " Entrar" + TerminalColors.RESET);
                System.out.println("2. Ver ranking");
                System.out.println("0." + TerminalColors.RED + " Sair do jogo" + TerminalColors.RESET);
                System.out.print("\nDigite uma opção: ");
                int option = Integer.parseInt(sc.nextLine());
                switch (option) {
                    case 1:
                        runProject();
                        break;
                    case 2:
                        showRanking();
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println(TerminalColors.RED + "Opção inválida!" + TerminalColors.RESET);
                        break;
                }
            } catch (Exception e) {
                System.out.println(TerminalColors.RED + "Opção inválida!" + TerminalColors.RESET);
            }

        }
    }

    public static void runProject() {
        String nickname;
        do {
            System.out.print(TerminalColors.PURPLE + "\nDigite seu Nickname: " + Game.TerminalColors.RESET);
            nickname = sc.nextLine();
        } while (nickname.isEmpty());

        if (!playerService.findByNickname(nickname).isEmpty()) {
            loggedPlayer = playerService.findByNickname(nickname).getFirst();
            System.out.println("\nBem-vindo(a) de volta a D.B.C, " + Game.TerminalColors.GREEN + loggedPlayer.getNickname() + Game.TerminalColors.RESET + "!");
        } else {
            Player player = new Player();
            player.setNickname(nickname);
            player.setScore(0);

            loggedPlayer = playerService.store(player);
            System.out.println(loggedPlayer.getId());
            System.out.println("\nBem-vindo(a) a D.B.C, " + Game.TerminalColors.GREEN + loggedPlayer.getNickname() + Game.TerminalColors.RESET + "!");
        }

        boolean flag = true;
        while (flag) {
            try {
                showPlayerInfo();
                System.out.println("\n1." + TerminalColors.GREEN + " Iniciar novo projeto" + TerminalColors.RESET);
                System.out.println("2. Ver ranking");
                System.out.println("3. Trocar nickname");
                System.out.println("4. Ver projetos concluídos");
                System.out.println("0." + TerminalColors.RED + " Sair da conta" + TerminalColors.RESET);
                System.out.print(TerminalColors.BLUE + "\nDigite uma opção: " + TerminalColors.RESET);
                int option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        showPlayerInfo();
                        System.out.println(TerminalColors.BLUE + "\nEscolha uma trilha: " + TerminalColors.RESET);
                        System.out.println("\n1. Frontend");
                        System.out.println("2. Backend");
                        System.out.println("3. QA");
                        System.out.print(TerminalColors.BLUE + "\nDigite uma opção: " + TerminalColors.RESET);
                        option = Integer.parseInt(sc.nextLine());

                        String areaName = null;
                        Project project = null;

                        areaName = getAreaName(option);

                        Area selectedArea = areaService.findById(option);

                        project = selectedArea.returnRandomProject();

                        showPlayerInfo(areaName);

                        System.out.println("\n- Você escolheu a Trilha " + TerminalColors.GREEN + areaName + TerminalColors.RESET + ".");
                        System.out.printf("\n- Você trabalhará no projeto:" + TerminalColors.GREEN + " %s", project.getTitle() + TerminalColors.RESET);
                        System.out.println();
                        System.out.println("\nPressione" + TerminalColors.GREEN + " ENTER " + TerminalColors.RESET + "para continuar");
                        sc.nextLine();

                        List<Question> questions = project.getQuestions();

                        int countErrors = 0;
                        int progress = 0;
                        for (Question question : questions) {

                            showPlayerInfo(areaName);
                            showProgressBar(progress);

                            System.out.println();
                            System.out.println(question.getStatement());
                            System.out.println();

                            boolean correct;
                            if (question.getQuestionType().equals(QuestionType.MULTIPLE_CHOICE)) {
                                List<QuestionOption> questionOptions = question.getQuestionOptions();

                                for (QuestionOption questionOption : questionOptions) {
                                    System.out.println(questionOption.getText());
                                }

                                System.out.print((TerminalColors.BLUE) + "\nDigite o n° da alternativa: " + TerminalColors.RESET);
                                int answer = Integer.parseInt(sc.nextLine());

                                correct = questionOptions.get(answer - 1).getCorrect() == 1;
                            } else {
                                System.out.print(TerminalColors.BLUE + "\nEscreva a resposta correta: " + TerminalColors.RESET);
                                String answer = sc.nextLine().trim().toLowerCase();

                                correct = answer.equalsIgnoreCase(question.getAnswerSecretWord());
                            }

                            if (correct) {
                                System.out.println(TerminalColors.GREEN + "\n- Parabéns! Você conseguiu! " + "(+" + question.getScore() + " Pontos)" + TerminalColors.RESET);
                                loggedPlayer.addScore(question.getScore());
                                playerService.updatePlayer(loggedPlayer);
                                progress++;
                            } else {
                                System.out.println(TerminalColors.RED + "\n- Resposta incorreta..." + TerminalColors.RESET);
                                countErrors++;
                            }

                            if (countErrors > project.getMaxErrors()) {
                                showPlayerInfo(areaName);
                                showProgressBar(progress);
                                System.out.println(TerminalColors.RED + "\n- Que pena... não foi possível entregar o projeto no prazo." + TerminalColors.RESET);
                                break;
                            }
                        }

                        if (countErrors <= project.getMaxErrors()) {
                            showPlayerInfo(areaName);
                            showProgressBar(progress);
                            loggedPlayer.addCompletedProject(project);
                            playerService.addCompletedProject(loggedPlayer.getId(), project.getId());
                            loggedPlayer.addScore(project.getScore());
                            playerService.updatePlayer(loggedPlayer);
                            System.out.println(TerminalColors.GREEN + "\n- Parabéns! Você conseguiu ajudar a equipe a concluir o projeto \n" +
                                    "no prazo. (+ " + project.getScore() + ") Pontos)" + TerminalColors.RESET);
                        }
                        break;
                    case 2:
                        showRanking();
                        break;
                    case 3:
                        String newNickname;
                        do {
                            System.out.print(TerminalColors.PURPLE + "Digite seu novo Nickname: " + TerminalColors.RESET);
                            newNickname = sc.nextLine();
                        } while (newNickname.isEmpty());
                        if (!playerService.findByNickname(nickname).isEmpty()) {
                            updatePlayerNickname(loggedPlayer, newNickname);
                            playerService.updatePlayer(loggedPlayer);
                        }else{
                            System.out.println(TerminalColors.RED + "\nEsse nickname já está sendo usado. " + TerminalColors.RESET);
                        }
                        break;
                    case 4:
                        break;
                    case 0:
                        flag = false;
                        break;
                    default:
                        System.out.println(TerminalColors.RED + "\nOpção inválida!" + TerminalColors.RESET);
                        break;
                }

            } catch (Exception e) {
                System.out.println(TerminalColors.RED + "\nOpção inválida!" + TerminalColors.RESET);
            }
        }
    }

    public static void showPlayerInfo() {
        System.out.println(TerminalColors.YELLOW + "\nJogador: " + TerminalColors.CYAN + loggedPlayer.getNickname() + TerminalColors.YELLOW + "     |     " + "Pontuação: " + TerminalColors.CYAN + loggedPlayer.getScore() + TerminalColors.RESET);
    }

    public static void showPlayerInfo(String area) {
        System.out.println(TerminalColors.YELLOW + "\nJogador: " + TerminalColors.CYAN + loggedPlayer.getNickname() + TerminalColors.YELLOW + "     |     " + "Trilha: " + TerminalColors.CYAN + area + TerminalColors.YELLOW + "     |     " + "Pontuação: " + TerminalColors.CYAN + loggedPlayer.getScore() + TerminalColors.RESET);
    }

    public static String getAreaName(int option) {
        switch (option) {
            case 1:
                return "Frontend";
            case 2:
                return "Backend";
            case 3:
                return "QA";
            default:
                return null;
        }
    }

    public static void showProgressBar(int progress) {
        int totalBars = 7;
        int completedBars = progress;
        int remainingBars = totalBars - completedBars;
        int percentage = (completedBars * 100) / totalBars;

        StringBuilder progressBar = new StringBuilder("[");
        for (int i = 0; i < completedBars; i++) {
            progressBar.append("#");
        }
        for (int i = 0; i < remainingBars; i++) {
            progressBar.append("-");
        }
        progressBar.append("] ").append(percentage).append("%");

        String centeredProgressBar = String.format("%" + (40 + progressBar.length() / 2) + "s", progressBar.toString());
        System.out.println("\n" + TerminalColors.GREEN + centeredProgressBar + TerminalColors.RESET);
    }

    public static Player updatePlayerNickname(Player player, String newNickName) {

        player.setNickname(newNickName);
        return player;
    }

    public static void showRanking() {
        playerService.findAll();

        System.out.println(TerminalColors.YELLOW + "\n                     Ranking" + TerminalColors.RESET);
        int position = 1;
        for (Player player : playerService.findAll()) {
            System.out.printf(TerminalColors.YELLOW + "\n%s - %10s %20s pontos"+ TerminalColors.RESET, position, player.getNickname(), player.getScore() );
            position++;
        }
        System.out.println();
    }
}
