package dp.type5;

/**
 * @author qihaodong
 */
public class LeetCode1055 {

    public static void main(String[] args) {
        LeetCode1055 test = new LeetCode1055();
        test.shortestWay("abc", "abcbc");
    }

    public int shortestWay(String source, String target) {
        if (source == null || source.length() == 0) {
            return -1;
        }
        int result = 0, sS = 0, tS = 0;
        while (tS < target.length()) {
            if (!source.contains(String.valueOf(target.charAt(tS)))) {
                return -1;
            }
            while (source.charAt(sS) != target.charAt(tS)) {
                result = sS == 0 ? result + 1 : result;
                sS = sS == source.length() - 1 ? 0 : sS + 1;
            }
            result = sS == 0 ? result + 1 : result;
            sS = sS == source.length() - 1 ? 0 : sS + 1;
            tS++;
        }
        return result;
    }

}
