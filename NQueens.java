import java.util.*;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, board, solutions, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return solutions;
    }

    private void backtrack(int row, char[][] board, List<List<String>> solutions,
                           Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {

        int n = board.length;
        if (row == n) {
            solutions.add(construct(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int diag = row - col;
            int antiDiag = row + col;

            if (cols.contains(col) || diagonals.contains(diag) || antiDiagonals.contains(antiDiag)) {
                continue; 
            }

            board[row][col] = 'Q';
            cols.add(col);
            diagonals.add(diag);
            antiDiagonals.add(antiDiag);

            backtrack(row + 1, board, solutions, cols, diagonals, antiDiagonals);

            board[row][col] = '.';
            cols.remove(col);
            diagonals.remove(diag);
            antiDiagonals.remove(antiDiag);
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
    }

    public static void main(String[] args) {
        NQueens nq = new NQueens();
        List<List<String>> results = nq.solveNQueens(4);
        for (List<String> board : results) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
