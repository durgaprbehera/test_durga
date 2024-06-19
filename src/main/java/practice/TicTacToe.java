package practice;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class TicTacToe {

    static ArrayList<Integer> playerPosList = new ArrayList<>();
    static ArrayList<Integer> cpuPosList = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGameBoard(gameBoard);
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the Position (1-9): ");
            int playerPos = scan.nextInt();

            while (playerPosList.contains(playerPos) || cpuPosList.contains(playerPos)) {
                System.out.println("Re-enter the Position (1-9): ");
                playerPos = scan.nextInt();
            }

            updatePositionOnBoard(playerPos, gameBoard, "player");

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;

            while (playerPosList.contains(cpuPos) || cpuPosList.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }

            updatePositionOnBoard(cpuPos, gameBoard, "cpu");

            printGameBoard(gameBoard);
            checkWinner(gameBoard);
            scan.close();
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void updatePositionOnBoard(int pos, char[][] gameBoard, String user) {
        char symbol = ' ';

        if (user.equalsIgnoreCase("player")) {
            symbol = 'X';
            playerPosList.add(pos);
        } else {
            symbol = 'O';
            cpuPosList.add(pos);
        }

        if (playerPosList.size() + cpuPosList.size() == 9) {
            System.out.println("TIE!!!");
            System.exit(0);
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }

    }

    public static void checkWinner(char[][] gameBoard) {

        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                if (gameBoard[i][j] == 'X' || gameBoard[i][j] == 'O') {
                    if (i == j && i + 4 < gameBoard.length && j + 4 < gameBoard.length
                            && gameBoard[i][j] == gameBoard[i + 2][j + 2]
                            && gameBoard[i][j] == gameBoard[i + 4][j + 4]) {

                        System.out.println("gameBoard[i][j]" + gameBoard[i][j]);
                        System.out.println("gameBoard[i+2][j+2]" + gameBoard[i + 2][j + 2]);
                        System.out.println("gameBoard[i+4][j+4]" + gameBoard[i + 4][j + 4]);
                        printWinner(gameBoard[i][j]);

                    } else if (j + 4 < gameBoard.length && gameBoard[i][j] == gameBoard[i][j + 2]
                            && gameBoard[i][j] == gameBoard[i][j + 4]) {
                        System.out.println("gameBoard[i][j]" + gameBoard[i][j]);
                        System.out.println("gameBoard[i][j+2]" + gameBoard[i][j + 2]);
                        System.out.println("gameBoard[i][j+4]" + gameBoard[i][j + 4]);
                        printWinner(gameBoard[i][j]);

                    } else if (i + 4 < gameBoard.length && gameBoard[i][j] == gameBoard[i + 2][j]
                            && gameBoard[i][j] == gameBoard[i + 4][j]) {
                        System.out.println("gameBoard[i][j]" + gameBoard[i][j]);
                        System.out.println("gameBoard[i+2][j]" + gameBoard[i + 2][j]);
                        System.out.println("gameBoard[i+4][j]" + gameBoard[i + 4][j]);
                        printWinner(gameBoard[i][j]);
                    } else
                        continue;
                } else if (i + 4 < gameBoard.length && j + 4 < gameBoard.length
                        && gameBoard[i][j + 4] == gameBoard[i + 2][j + 2] && gameBoard[i][j + 4] == gameBoard[i + 4][j]
                        && (gameBoard[i][j + 4] == 'X' || gameBoard[i][j + 4] == 'O')) {
                    System.out.println("gameBoard[i][j+4]" + gameBoard[i][j + 4]);
                    System.out.println("gameBoard[i+2][j+2]" + gameBoard[i + 2][j + 2]);
                    System.out.println("gameBoard[i+4][j]" + gameBoard[i + 4][j]);
                    printWinner(gameBoard[i][j]);

                } else
                    continue;
            }
        }

    }

    public static void printWinner(char value) {
        if (value == 'X') {
            System.out.println("Player Won!");
            System.exit(0);
        } else {
            System.out.println("CPU Won!");
            System.exit(0);
        }
    }


}
