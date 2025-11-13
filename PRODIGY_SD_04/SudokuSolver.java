public class SudokuSolver {

    private static final int SIZE = 9; // Sudoku grid size

    // Function to print Sudoku grid
    private static void printGrid(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % 3 == 0)
                System.out.print("");
        }
    }

    // Check if number can be placed at board[row][col]
    private static boolean isSafe(int[][] board, int row, int col, int num) {
        // Row check
        for (int x = 0; x < SIZE; x++)
            if (board[row][x] == num)
                return false;

        // Column check
        for (int x = 0; x < SIZE; x++)
            if (board[x][col] == num)
                return false;

        // 3x3 subgrid check
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++)
            for (int j = startCol; j < startCol + 3; j++)
                if (board[i][j] == num)
                    return false;

        return true;
    }

    // Backtracking function to solve Sudoku
    private static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty)
                break;
        }

        // No empty space left
        if (isEmpty)
            return true;

        // Try filling numbers 1–9
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n))
                    return true;
                else
                    board[row][col] = 0; // backtrack
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] board = new int[][] {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };

        if (solveSudoku(board, SIZE))
            printGrid(board);
        else
            System.out.println("No solution exists.");
    }
}
