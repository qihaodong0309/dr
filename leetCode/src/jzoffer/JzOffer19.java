package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer19 {

    public static void main(String[] args) {
        JzOffer19 test = new JzOffer19();
        test.isMatch2("aa", "a*");
    }

    /**
     * dp思想
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

    /**
     * 上述 dp 改为递归
     *
     * @param s
     * @param p
     * @return
     */
    private boolean isMatch2(String s, String p) {
        return echo(s, p, 0, 0);
    }

    private boolean echo(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }
        if (j == p.length()) {
            return false;
        }
        if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
            boolean judge = echo(s, p, i, j + 2);
            if (!judge && matches2(s, p, i, j)) {
                judge = echo(s, p, i + 1, j);
            }
            return judge;
        } else if (matches2(s, p, i, j)) {
            return echo(s, p, i + 1, j + 1);
        }
        return false;
    }

    private boolean matches2(String s, String p, int i, int j) {
        if (i >= s.length()) {
            return false;
        }
        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }

}
