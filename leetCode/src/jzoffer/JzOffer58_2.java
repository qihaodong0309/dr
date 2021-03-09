package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer58_2 {

    /**
     * 基础方法
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        int length = s.length();
        n = n % length;
        return s.substring(n) + s.substring(0, n);
    }

    /**
     * K神解法
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    /**
     * K神方法二优化
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords3(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));
        }
        return sb.toString();
    }

}
