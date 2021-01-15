package collection.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author qihaodong
 */
public class LeetCode649 {

    public static void main(String[] args) {
        new LeetCode649().predictPartyVictory("RDD");
    }

    /*
    可以使用遍历的方法
     */


    public String predictPartyVictory(String senate) {
        char[] record = senate.toCharArray();
        int[] temp = new int[record.length];
        int rNum = 0, dNum = 0, index = 0;
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 'R') {
                rNum++;
            } else {
                dNum++;
            }
            temp[i] = 1;
        }
        while (rNum > 0 && dNum > 0) {
            int delIndex = -1;
            if (temp[index] == 0) {
                index = index == record.length - 1 ? 0 : index + 1;
                continue;
            }
            for (int i = index + 1; i < record.length; i++) {
                if (temp[i] == 1 && record[i] != record[index]) {
                    delIndex = i;
                    temp[i] = 0;
                    break;
                }
            }
            if (delIndex == -1) {
                for (int i = index - 1; i >= 0; i--) {
                    if (temp[i] == 1 && record[i] != record[index]) {
                        delIndex = i;
                        temp[i] = 0;
                        break;
                    }
                }
            }
            if (record[delIndex] == 'R') {
                rNum--;
            } else {
                dNum--;
            }
            index = index == record.length - 1 ? 0 : index + 1;
        }
        return rNum == 0 ? "Dire" : "Radiant";
    }

    /**
     * 队列法
     *
     * @param senate
     * @return
     */
    public String predictPartyVictory2(String senate) {
        int n = senate.length();
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                queue1.offer(i);
            } else {
                queue2.offer(i);
            }
        }
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int index1 = queue1.poll(), index2 = queue2.poll();
            if (index1 > index2) {
                queue2.offer(index2 + n);
            } else {
                queue1.offer(index1 + n);
            }
        }
        return queue1.isEmpty() ? "Dire" : "Radiant";
    }

}
