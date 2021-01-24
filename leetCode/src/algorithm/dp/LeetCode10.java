package algorithm.dp;

/**
 * 同 JzOffer19
 *
 * @author qihaodong
 */
public class LeetCode10 {

    /**
     * dp
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] result = new boolean[sl + 1][pl + 1];
        result[0][0] = true;
        for (int i = 0; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (p.charAt(j - 1) == '*') {
                    result[i][j] = result[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        result[i][j] |= result[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        result[i][j] = result[i - 1][j - 1];
                    }
                }
            }
        }
        return result[sl][pl];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        } else {
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }

}
