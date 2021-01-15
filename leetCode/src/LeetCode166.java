import java.util.HashMap;
import java.util.Map;

/**
 * @author qihaodong
 */
public class LeetCode166 {

    /**
     * 直接操作字符串
     *
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        boolean judge = false;
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            judge = true;
            numerator = numerator < 0 ? -1 * numerator : numerator;
            denominator = denominator < 0 ? -1 * denominator : denominator;
        }
        String result = "";
        long num = numerator * 1L / denominator, temp = numerator * 1L % denominator;
        Map<Long, Integer> map = new HashMap<>();
        result += num;
        if (temp != 0) {
            result = result + ".";
            int start = result.length();
            do {
                map.put(temp, start++);
                temp = temp * 10;
                num = temp / denominator;
                temp = temp % denominator;
                result += num;
            } while (temp != 0 && !map.containsKey(temp));
            if (temp != 0) {
                int index = map.get(temp);
                result = result.substring(0, index) + "(" + result.substring(index) + ")";
            }
        }
        return (judge && !result.startsWith("-")) ? "-" + result : result;
    }

}
