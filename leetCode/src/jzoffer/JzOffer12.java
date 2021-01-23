package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer12 {

    /**
     * dfs + 回溯，只要有一组解满足，就返回
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }
        int xLength = board.length, yLength = board[0].length;
        int[][] record = new int[xLength][yLength];
        for (int i = 0; i < xLength; i++) {
            for (int j = 0; j < yLength; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, record, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    int[] columnX = new int[]{1, -1, 0, 0};
    int[] columnY = new int[]{0, 0, 1, -1};

    private boolean dfs(char[][] board, int[][] record, String word, int index, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length
                || record[x][y] == 1
                || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        record[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            if (dfs(board, record, word, index + 1, x + columnX[i], y + columnY[i])) {
                return true;
            }
        }
        record[x][y] = 0;
        return false;
    }

    // 优化上述 dfs,减少递归层数

    private boolean dfs2(char[][] board, int[][] record, String word, int index, int x, int y) {
        if (index == word.length() - 1) {
            return true;
        }
        record[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int newX = x + columnX[i], newY = y + columnY[i];
            if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length
                    || record[newX][newY] == 1
                    || board[newX][newY] != word.charAt(index + 1)) {
                continue;
            }
            if (dfs2(board, record, word, index + 1, newX, newY)) {
                return true;
            }
        }
        record[x][y] = 0;
        return false;
    }

    /**
     * 代码更简洁的 dfs + 回溯
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist3(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs3(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs3(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        if (dfs3(board, word, i + 1, j, k + 1)
                || dfs3(board, word, i, j + 1, k + 1)
                || dfs3(board, word, i - 1, j, k + 1)
                || dfs3(board, word, i, j - 1, k + 1)) {
            return true;
        }
        board[i][j] = word[k];
        return false;
    }

}
