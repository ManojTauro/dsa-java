//https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=15

import java.util.Arrays;

public class ZeroOneMatrix {
    static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
//        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};

        char[][] board = {{'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}, {'X', 'O', 'X', 'O', 'X', 'O'}, {'O', 'X', 'O', 'X', 'O', 'X'}};

        solve(board);

        for(char[] row: board) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static void dfs(int cRow, int cCol, char[][] board, boolean[][] vis, int rows, int cols) {
        vis[cRow][cCol] = true;

        for(int[] dir: dirs) {
            int i = dir[0] + cRow;
            int j = dir[1] + cCol;

            if(i>=0 && i<rows && j>=0 && j<cols && !vis[i][j] && board[i][j] == 'O') {
                dfs(i, j, board, vis, rows, cols);
            }
        }

    }

    private static void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] vis = new boolean[rows][cols];

        // Traverse row
        for(int i=0; i<cols; i++) {
            if(!vis[0][i] && board[0][i] == 'O') {
                // vis[0][i] = true;
                dfs(0, i, board, vis, rows, cols);
            }

            if(!vis[rows-1][i] && board[rows-1][i] == 'O') {
                // vis[rows-1][i] = true;
                dfs(rows-1, i, board, vis, rows, cols);
            }
        }

        // Traverse Colum
        for(int i=0; i<rows; i++) {
            if(!vis[i][0] && board[i][0] == 'O') {
                // vis[i][0] = true;
                dfs(i, 0, board, vis, rows, cols);
            }

            if(!vis[i][cols-1] && board[i][cols-1] == 'O') {
                // vis[i][cols-1] = true;
                dfs(i, cols-1, board, vis, rows, cols);
            }
        }

        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(!vis[i][j] && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
    }
}
