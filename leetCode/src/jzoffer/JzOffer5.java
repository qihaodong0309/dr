package jzoffer;

/**
 * @author qihaodong
 */
public class JzOffer5 {

    /**
     * 直接使用java函数
     *
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    /**
     * 使用字符数组
     *
     * @param s
     * @return
     */
    public String replaceSpace2(String s) {
        int index = 0, length = s.length();
        char[] result = new char[3 * length];
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                result[index++] = '%';
                result[index++] = '2';
                result[index++] = '0';
            } else {
                result[index++] = c;
            }
        }
        return new String(result, 0, index);
    }

}
