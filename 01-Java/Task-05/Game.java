package task05;

import task05.questions.Completing;
import task05.questions.MultipleChoice;
import task05.questions.Question;

import java.util.*;

public class Game {
    private static List<Player> players;
    private static Area frontendArea;
    private static Area backendArea;
    private static Area qaArea;
    private static Scanner sc = new Scanner(System.in);
    private static Player loggedPlayer = null;
    private static LinkedHashMap<String, Integer> ranking = new LinkedHashMap<>();

    public Game() {
        players = new ArrayList<>();
        frontendArea = Area.loadFrontendArea();
        backendArea = Area.loadBackendArea();
        qaArea = Area.loadQaArea();
    }

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

        // Dados para teste
        Player playerZe = new Player("Ze", 0);
        Player playerAna = new Player("Ana", 0);
        playerZe.addCompletedProject(frontendArea.returnRandomProject());
        playerAna.addCompletedProject(backendArea.returnRandomProject());
        players.add(playerZe);
        players.add(playerAna);
        ranking.put(playerZe.getNickname(), playerZe.getScore());
        ranking.put(playerAna.getNickname(), playerAna.getScore());

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
                System.out.println(TerminalColors.RED + "                                                  D E V - Q U E S T " + TerminalColors.RESET);
                System.out.println(TerminalColors.BLUE + "                                          D" + TerminalColors.RESET + "evelopers " + TerminalColors.BLUE + " B" + TerminalColors.RESET + "uilding " + TerminalColors.BLUE +  " C" + TerminalColors.RESET + "onnections");
                System.out.println("- Olá, seja bem-vindo(a) ao" + TerminalColors.RED + " Dev-Quest!!!" + TerminalColors.RESET);
                System.out.println("\n1." + TerminalColors.GREEN + " Entrar" + TerminalColors.RESET);
                System.out.println("2. Ver ranking");
                System.out.println("0." + TerminalColors.RED + " Sair do jogo"+ TerminalColors.RESET);
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
            System.out.print(TerminalColors.PURPLE + "\nDigite seu Nickname: " + TerminalColors.RESET);
            nickname = sc.nextLine();
        } while (nickname.isEmpty());

        boolean registeredPlayer = false;
        for (Player player : players) {
            if (player.getNickname().equalsIgnoreCase(nickname)) {
                loggedPlayer = player;
                registeredPlayer = true;
                break;
            }
        }

        if (registeredPlayer) {
            System.out.println("\nBem-vindo(a) de volta a D.B.C, " + TerminalColors.GREEN + loggedPlayer.getNickname() + TerminalColors.RESET + "!");
        } else {
            loggedPlayer = new Player(nickname, 0);
            players.add(loggedPlayer);
            ranking.put(loggedPlayer.getNickname(), 0);
            System.out.println("\nBem-vindo(a) a D.B.C, " + TerminalColors.GREEN + loggedPlayer.getNickname() + TerminalColors.RESET + "!");
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
                        if (areaName != null) {
                            project = getProjectByArea(option);
                        } else {
                            System.out.println(TerminalColors.RED + "\nOpção inválida!" + TerminalColors.RESET);
                            break;
                        }

                        if (project == null) {
                            System.out.println(TerminalColors.PURPLE + "Não existem mais projetos dessa área." + TerminalColors.RESET);
                            break;
                        }

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

                            boolean correct = false;
                            if ((question) instanceof MultipleChoice) {
                                MultipleChoice multipleChoice = (MultipleChoice) question;
                                List<String> options = multipleChoice.getOptions();

                                for (String opt : options) {
                                    System.out.println(opt);
                                }

                                System.out.print((TerminalColors.BLUE) + "\nDigite o n° da alternativa: " + TerminalColors.RESET);
                                String answer = sc.nextLine().trim().toLowerCase();

                                correct = multipleChoice.checkAnswer(answer);
                            } else if ((question) instanceof Completing) {
                                Completing completing = (Completing) question;
                                System.out.print(TerminalColors.BLUE + "\nEscreva a resposta correta: " + TerminalColors.RESET);
                                String answer = sc.nextLine().trim().toLowerCase();

                                correct = completing.checkAnswer(answer);
                            }

                            if (correct) {
                                System.out.println(TerminalColors.GREEN + "\n- Parabéns! Você conseguiu! " + "(+" + question.getScore() + " Pontos)" + TerminalColors.RESET);
                                loggedPlayer.addScore(question.getScore());
                                updateRanking(loggedPlayer);
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
                            loggedPlayer.addScore(project.getScore());
                            updateRanking(loggedPlayer);
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
                        boolean alreadyUsed = false;
                        for (Player p : players) {
                            if (p.getNickname().equals(newNickname)) {
                                System.out.println(TerminalColors.RED + "\nEsse nickname já está sendo usado. " + TerminalColors.RESET);
                                alreadyUsed = true;
                                break;

                            }
                        }
                        if (!alreadyUsed) {
                            updatePlayerNickname(loggedPlayer, newNickname);
                        }
                        break;
                    case 4:
                        LinkedList<Project> completedProjects = loggedPlayer.getCompletedProjects();
                        System.out.println(TerminalColors.PURPLE + "\nProjetos concluídos\n" + TerminalColors.RESET);
                        for (Project project1 : completedProjects) {
                            System.out.println(TerminalColors.PURPLE + "- " + project1.getTitle() + TerminalColors.RESET);
                        }
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
        System.out.println(TerminalColors.YELLOW + "\nJogador: " + TerminalColors.CYAN + loggedPlayer.getNickname() + TerminalColors.YELLOW + "     |     " + "Trilha: " + TerminalColors.CYAN + area +  TerminalColors.YELLOW + "     |     " + "Pontuação: " + TerminalColors.CYAN + loggedPlayer.getScore() + TerminalColors.RESET);
    }

    public static void showRanking() {
        List<Map.Entry<String, Integer>> rankList = new ArrayList<>(ranking.entrySet());
        rankList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        System.out.println(TerminalColors.YELLOW + "\n                     Ranking" + TerminalColors.RESET);
        int position = 1;
        for (Map.Entry<String, Integer> entry : rankList) {
            System.out.printf(TerminalColors.YELLOW + "\n%s - %10s %20s pontos"+ TerminalColors.RESET, position, entry.getKey(), entry.getValue() );
            position++;
        }
        System.out.println();
    }

    public static void updateRanking(Player player) {
        ranking.put(player.getNickname(), player.getScore());
        sortRanking();
    }

    public static void sortRanking() {
        List<Map.Entry<String, Integer>> rankList = new ArrayList<>(ranking.entrySet());
        rankList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        LinkedHashMap<String, Integer> sortedRanking = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : rankList) {
            sortedRanking.put(entry.getKey(), entry.getValue());
        }
        ranking = sortedRanking;
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

    public static Project getProjectByArea(int option) {
        Area selectedArea = null;
        switch (option) {
            case 1:
                selectedArea = frontendArea;
                break;
            case 2:
                selectedArea = backendArea;
                break;
            case 3:
                selectedArea = qaArea;
                break;
            default:
                return null;
        }

        Project project = null;
        do {
            project = selectedArea.returnRandomProject();
            int completedProjectsCount = 0;
            for (Project p : selectedArea.getProjects()) {
                if (loggedPlayer.getCompletedProjects().contains(p)) {
                    completedProjectsCount++;
                }
            }
            if (completedProjectsCount == selectedArea.getProjects().size()) {
                return null;
            }
        } while (loggedPlayer.getCompletedProjects().contains(project));
        return project;
    }

    public static void updatePlayerNickname(Player player, String newNickName) {
        ranking.remove(player.getNickname());
        player.setNickname(newNickName);
        ranking.put(player.getNickname(), player.getScore());
        sortRanking();
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
}
