package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author qihaodong
 */
public class LeetCode51 {

    public static void main(String[] args) {
        new LeetCode51().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] record = new char[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(record[i], '.');
        }
        echo(result, record, 1);
        return result;
    }

    private void echo(List list, char[][] record, int num) {
        int n = record.length;
        if (num == n) {
            list.add(changeArrayToList(record));
        }
        for (int i = 1; i < n; i++) {
            if (isValid(record, num, i)) {
                record[num][i] = 'Q';
                echo(list, record, num + 1);
                record[num][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] record, int x, int y) {
        int n = record.length;
        for (int i = x - 1, k = 1; i >= 1; i--, k++) {
            if (record[i][y] == 'Q') {
                return false;
            }
            if (y - k >= 1 && record[i][y - k] == 'Q') {
                return false;
            }
            if (y + k < n && record[i][y + k] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> changeArrayToList(char[][] temp) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < temp.length; i++) {
            result.add(String.valueOf(temp[i]).substring(1));
        }
        return result;
    }

}
