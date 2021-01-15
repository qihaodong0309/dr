package collection.stack;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class LeetCode224 {

    public static void main(String[] args) {
        String t = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new LeetCode224().calculate2(t));
    }

    /**
     * 从前往后，笨办法
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int result = 0, temp = 0, judge = 1;
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (c == ')') {
                while (stack.peek() != '(') {
                    char a = stack.pop();
                    if (a >= '0' && a <= '9') {
                        temp = temp + (int) (a - '0') * judge;
                        judge = judge * 10;
                    } else {
                        result = a == '+' ? result + temp : result - temp;
                        temp = 0;
                        judge = 1;
                    }
                }
                result = result + temp;
                temp = 0;
                judge = 1;
                stack.pop();
                if (result < 0) {
                    result = result * -1;
                    if (stack.isEmpty()) {
                        stack.push('-');
                    } else {
                        char x = stack.pop();
                        stack.push(x == '+' ? '-' : '+');
                    }
                }
                while (result != 0) {
                    char x = (char) (result % 10 + '0');
                    stack2.push(x);
                    result = result / 10;
                }
                while (!stack2.isEmpty()) {
                    stack.push(stack2.pop());
                }
                continue;
            }
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c >= '0' && c <= '9') {
                temp = temp + (int) (c - '0') * judge;
                judge = judge * 10;
            } else {
                result = c == '+' ? result + temp : result - temp;
                temp = 0;
                judge = 1;
            }
        }
        return result + temp;
    }

    /**
     * 代码优化(从后往前遍历)
     *
     * @param s
     * @return
     */
    public int calculate2(String s) {
        Stack<Object> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int num = 0, record = 1, n = chars.length;
        for (int i = n - 1; i >= 0; i--) {
            char temp = chars[i];
            if (temp == ' ') {
                continue;
            }
            if (temp >= '0' && temp <= '9') {
                num += (int) (temp - '0') * record;
                record *= 10;
            } else {
                if (record != 1) {
                    stack.push(num);
                    num = 0;
                    record = 1;
                }
                if (temp == '(') {
                    int val = evalStack(stack);
                    stack.pop();
                    stack.push(val);
                } else {
                    stack.push(temp);
                }
            }
        }
        if (record != 1) {
            stack.push(num);
        }
        return evalStack(stack);
    }

    private int evalStack(Stack stack) {
        int result = 0;
        if (!stack.isEmpty()) {
            result = (int) stack.pop();
        }
        while (!stack.isEmpty() && (char) stack.peek() != ')') {
            char temp = (char) stack.pop();
            if (temp == '+') {
                result += (int) stack.pop();
            } else {
                result -= (int) stack.pop();
            }
        }
        return result;
    }

}
