package jzoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qihaodong
 */
public class JzOffer20 {

    /**
     * 常规方法
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.trim();
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        for (int i = 0; i < s.length(); i++) {
            //判定为数字，则标记numFlag
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numFlag = true;
            } else if (s.charAt(i) == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;
            } else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
            } else {
                return false;
            }
        }
        return numFlag;
    }

    /**
     * 官方题解
     *
     * @param s
     * @return
     */
    public boolean isNumber2(String s) {
        Map[] states = {
                // 0：字符串前的空字符状态
                new HashMap() {{
                    put(' ', 0);
                    put('s', 1);
                    put('d', 2);
                    put('.', 4);
                }},
                // 1：正负号栏位
                new HashMap() {{
                    put('d', 2);
                    put('.', 4);
                }},
                // 2：小数点前数字栏位
                new HashMap() {{
                    put('d', 2);
                    put('.', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 3：小数点、小数点后的数字
                new HashMap() {{
                    put('d', 3);
                    put('e', 5);
                    put(' ', 8);
                }},
                // 4：当小数点前为空格时，小数点、小数点后的数字
                new HashMap() {{
                    put('d', 3);
                }},
                // 5：幂符号
                new HashMap() {{
                    put('s', 6);
                    put('d', 7);
                }},
                // 6：幂符号后的正负号
                new HashMap() {{
                    put('d', 7);
                }},
                // 7：幂符号后的数字
                new HashMap() {{
                    put('d', 7);
                    put(' ', 8);
                }},
                // 8：结尾的空格
                new HashMap() {{
                    put(' ', 8);
                }}
        };
        int p = 0;
        char t;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                t = 'd';
            } else if (c == '+' || c == '-') {
                t = 's';
            } else if (c == 'e' || c == 'E') {
                t = 'e';
            } else if (c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if (!states[p].containsKey(t)) {
                return false;
            }
            p = (int) states[p].get(t);
        }
        // 2、3、7、8 是可以正常结束的状态
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

}
