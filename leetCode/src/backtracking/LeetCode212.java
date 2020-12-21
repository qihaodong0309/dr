package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode212 {

    public static void main(String[] args) {
        new LeetCode212().findWords(new char[][]{{'a', 'b', 'c'}, {'a', 'e', 'd'}, {'a', 'f', 'g'}}, new String[]{"eaabcdgfa"});
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || board.length == 0) {
            return result;
        }
        boolean judge = true;
        for (String s : words) {
            judge = true;
            for (int i = 0; i < board.length && judge; i++) {
                for (int j = 0; j < board[0].length && judge; j++) {
                    if (board[i][j] == s.charAt(0) && echo(board, s, 0, s.length(), new int[board.length][board[0].length], i, j)) {
                        result.add(s);
                        judge = false;
                    }
                }
            }
        }
        return result;
    }

    int[] choose1 = {1, -1, 0, 0};
    int[] choose2 = {0, 0, 1, -1};

    private boolean echo(char[][] chars, String s, int index, int end, int[][] record, int x, int y) {
        if (x < 0 || y < 0 || x >= chars.length || y >= chars[0].length || record[x][y] == 1 || s.charAt(index) != chars[x][y]) {
            return false;
        }
        if (index == end - 1) {
            return true;
        }
        record[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            if (echo(chars, s, index + 1, end, record, x + choose1[i], y + choose2[i])) {
                return true;
            }
        }
        record[x][y] = 0;
        return false;
    }

}
