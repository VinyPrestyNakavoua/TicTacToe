import java.util.Scanner;

/**
 * Cette classe représente un jeu de Tic-Tac-Toe en mode console, permettant à deux joueurs
 * de jouer au tour par tour jusqu'à ce qu'il y ait un gagnant ou une égalité.
 */
public class TicTacToeFinal {

    /**
     * Grille du jeu où chaque case contient le symbole du joueur ('X', 'O') ou un espace vide.
     */
    char[][] board = new char[3][3];

    /**
     * Symbole du joueur X.
     */
    char playerX = 'X';

    /**
     * Symbole du joueur O.
     */
    char playerO = 'O';

    /**
     * Symbole du joueur actuel ('X' ou 'O').
     */
    char currentPlayer = playerX;

    /**
     * Indicateur de fin de partie. Devient true lorsque le jeu est terminé par une victoire ou une égalité.
     */
    boolean gameOver = false;

    /**
     * Compteur de tours joués. Utilisé pour détecter une égalité après 9 tours sans gagnant.
     */
    int turns = 0;

    /**
     * Constructeur de la classe TicTacToeConsole qui initialise la grille
     * et lance la boucle de jeu.
     */
    public TicTacToeFinal() {
        initializeBoard();
        playGame();
    }

    /**
     * Initialise la grille de jeu en remplissant chaque case avec un espace vide.
     */
    void initializeBoard() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c] = ' ';
            }
        }
    }

    /**
     * Affiche la grille dans la console, en ajoutant des séparateurs pour une meilleure lisibilité.
     */
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

    /**
     * Fonction principale du jeu qui gère le tour par tour. Elle demande les coups des joueurs
     * et vérifie les conditions de victoire ou d'égalité après chaque coup.
     */
    void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            printBoard();
            System.out.println("Joueur " + currentPlayer + ", entrez votre ligne et colonne (1, 2 ou 3) séparées par un espace:");
            int row = scanner.nextInt() - 1; // Convertit la ligne en index
            int col = scanner.nextInt() - 1; // Convertit la colonne en index

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                turns++;
                checkWinner();
                if (!gameOver) {
                    currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
                }
            } else {
                System.out.println("Coup invalide. Réessayez.");
            }
        }
        printBoard();
        scanner.close();
    }

    /**
     * Vérifie si le mouvement à la position spécifiée est valide.
     * @param row La ligne choisie par le joueur (indexé entre 0 et 2 après conversion).
     * @param col La colonne choisie par le joueur (indexé entre 0 et 2 après conversion).
     * @return true si la case est libre et dans les limites de la grille, sinon false.
     */
    boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ';
    }

    /**
     * Vérifie les conditions de victoire en parcourant les lignes, colonnes et diagonales.
     * Si un joueur a aligné trois symboles, il est déclaré gagnant. Vérifie également l'égalité.
     */
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

    /**
     * Déclare le joueur actuel comme gagnant, affiche un message et met fin à la partie.
     */
    void declareWinner() {
        System.out.println("Le joueur " + currentPlayer + " a gagné !");
        gameOver = true;
    }

}


