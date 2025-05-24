package practice;

import java.util.Scanner;

public class TicTacToe {

    // Constants for the players and board size
    private static final int BOARD_SIZE = 3;
    private static final char EMPTY = '-';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    private char[][] board; // 2D array to represent the board
    private char currentPlayer; // Current player (X or O)
    private boolean isGameOver; // Flag to track if the game is over

    // Constructor to initialize the game
    public TicTacToe() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        currentPlayer = PLAYER_X;
        isGameOver = false;
        initializeBoard();
    }

    // Method to initialize the board with empty cells
    private void initializeBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // Method to start the game
    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // Game loop
        while (!isGameOver) {
            // Print current board
            printBoard();

            // Get player move
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] column [1-3]):");
            // Try to get valid integer input for row and column, catch non-integer input
            try {
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;

                // Check if the move is valid
                if (isValidMove(row, col)) {
                    board[row][col] = currentPlayer;

                    // Check if the current player wins
                    if (checkWin(row, col)) {
                        printBoard();
                        System.out.println("Player " + currentPlayer + " wins!");
                        isGameOver = true;
                    } else {
                        // Check if the board is full (tie)
                        if (isBoardFull()) {
                            printBoard();
                            System.out.println("It's a tie!");
                            isGameOver = true;
                        } else {
                            // Switch to the next player
                            currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
                        }
                    }
                } else {
                    System.out.println("Invalid move! Please try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter numbers between 1 and 3 for row and column.");
                scanner.next(); // Consume the invalid token
                continue; // Re-prompt the user
            }
        }

        scanner.close();
    }

    // Method to check if a move is valid
    private boolean isValidMove(int row, int col) {
        // Check if the cell is empty and within bounds
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE && board[row][col] == EMPTY;
    }

    // Method to check if the current player wins
    private boolean checkWin(int row, int col) {
        // Check row, column, and diagonals for the current player's mark
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
                || (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
                || (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer)
                || (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    // Method to check if the board is full
    private boolean isBoardFull() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to print the current board state
    private void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Main method to start the game
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.startGame();
    }
}
