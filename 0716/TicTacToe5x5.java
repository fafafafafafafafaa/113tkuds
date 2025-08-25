import java.util.Scanner;

public class TicTacToe5x5 {
    static final int SIZE = 5;
    static char[][] board = new char[SIZE][SIZE];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        initBoard();
        System.out.println("=== 5x5 井字遊戲 ===");
        printBoard();

        char currentPlayer = 'X';
        boolean gameEnded = false;

        while (!gameEnded) {
            System.out.print("玩家 " + currentPlayer + " 請輸入 row col：");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (!isValidMove(row, col)) {
                System.out.println("輸入錯誤，請重新輸入！");
                continue;
            }

            board[row][col] = currentPlayer;
            System.out.println("玩家 " + currentPlayer + " 在位置 (" + row + ", " + col + ") 放置棋子");
            printBoard();

            if (checkWin(currentPlayer)) {
                System.out.println("玩家 " + currentPlayer + " 獲勝！");
                gameEnded = true;
            } else if (isDraw()) {
                System.out.println("平手！");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        sc.close();
    }

    static void initBoard() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                board[i][j] = '.';
    }

    static void printBoard() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < SIZE; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    static boolean isValidMove(int row, int col) {
        return (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '.');
    }

    static boolean checkWin(char player) {
        // 檢查行與列
        for (int i = 0; i < SIZE; i++) {
            if (checkLine(player, i, 0, 0, 1) || checkLine(player, 0, i, 1, 0))
                return true;
        }
        // 檢查對角線
        return checkLine(player, 0, 0, 1, 1) || checkLine(player, 0, SIZE - 1, 1, -1);
    }

    static boolean checkLine(char player, int startRow, int startCol, int dr, int dc) {
        for (int i = 0; i < SIZE; i++) {
            int row = startRow + dr * i;
            int col = startCol + dc * i;
            if (board[row][col] != player)
                return false;
        }
        return true;
    }

    static boolean isDraw() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == '.')
                    return false;
        return true;
    }
}
