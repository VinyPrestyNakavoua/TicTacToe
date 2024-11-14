import java.util.Scanner;

public class TicTacToeConsole {
    char[][] board = new char[3][3]; // Grille de jeu
    char playerX = 'X';
    char playerO = 'O';
    char currentPlayer = playerX;
    boolean gameOver = false;
    int turns = 0;

    public TicTacToeConsole() {
        initializeBoard();
        playGame();
    }

    // Initialise la grille avec des espaces vides
    void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    // Affiche la grille dans la console
    void printBoard() {
        System.out.println("---------");
        for (int r = 0; r < 3; r++) {
            System.out.print("| ");
            for (int c = 0; c < 3; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    // Fonction principale du jeu
    void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            printBoard();
            System.out.println("Joueur " + currentPlayer + ", entrez votre ligne et colonne (0, 1 ou 2) séparées par un espace:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                turns++;
                checkWinner();
                if (!gameOver) {
                    if (currentPlayer == playerX) {
                        currentPlayer = playerO;
                    } else {
                        currentPlayer = playerX;
                    }
                    
                }
            } else {
                System.out.println("Coup invalide. Réessayez.");
            }
        }
        printBoard();
        scanner.close();
    }

    // Vérifie si le mouvement est valide
    boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    // Vérifie les conditions de victoire ou d'égalité
    void checkWinner() {
        // Vérification des lignes
        for (int r = 0; r < 3; r++) {
            if (board[r][0] != ' ' && board[r][0] == board[r][1] && board[r][1] == board[r][2]) {
                declareWinner();
                return;
            }
        }

        // Vérification des colonnes
        for (int c = 0; c < 3; c++) {
            if (board[0][c] != ' ' && board[0][c] == board[1][c] && board[1][c] == board[2][c]) {
                declareWinner();
                return;
            }
        }

        // Vérification des diagonales
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            declareWinner();
            return;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            declareWinner();
            return;
        }

        // Vérification d'un match nul
        if (turns == 9) {
            System.out.println("Égalité !");
            gameOver = true;
        }
    }

    // Déclare le gagnant
    void declareWinner() {
        System.out.println("Le joueur " + currentPlayer + " a gagné !");
        gameOver = true;
    }


}
