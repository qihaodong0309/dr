package jzoffer;

import java.util.Stack;

/**
 * @author qihaodong
 */
public class JzOffer33 {

    public static void main(String[] args) {
        JzOffer33 test = new JzOffer33();
        test.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3});
    }

    /**
     * 递归
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        return echo(postorder, 0, postorder.length - 1);
    }

    private boolean echo(int[] record, int start, int end) {
        if (start >= end) {
            return true;
        }
        int index = record[end], i = start;
        for (; i < end; i++) {
            if (record[i] > index) {
                break;
            }
        }
        for (int j = i + 1; j < end; j++) {
            if (record[j] < index) {
                return false;
            }
        }
        return echo(record, start, i - 1) && echo(record, i, end - 1);
    }

    /**
     * 基于单调栈
     *
     * @param postorder
     * @return
     */
    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int record = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > record) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                record = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }

}
