package jzoffer;

import java.util.Arrays;

/**
 * @author qihaodong
 */
public class JzOffer45 {

    /**
     * k神思路（基于快速排序）
     *
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] strS = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strS[i] = String.valueOf(nums[i]);
        }
        quickSort(strS, 0, nums.length - 1);
        StringBuffer sb = new StringBuffer();
        for (String s : strS) {
            sb.append(s);
        }
        return sb.toString();
    }

    private void quickSort(String[] strS, int start, int end) {
        if (start >= end) {
            return;
        }
        int l = start, r = end;
        String temp = strS[l];
        while (l < r) {
            while ((strS[r] + strS[start]).compareTo(strS[start] + strS[r]) >= 0 && l < r) {
                r--;
            }
            while ((strS[l] + strS[start]).compareTo(strS[start] + strS[l]) <= 0 && l < r) {
                l++;
            }
            temp = strS[l];
            strS[l] = strS[r];
            strS[r] = temp;
        }
        strS[l] = strS[start];
        strS[start] = temp;
        quickSort(strS, start, l - 1);
        quickSort(strS, l + 1, end);
    }

    /**
     * 快排改 lambda
     *
     * @param nums
     * @return
     */
    public String minNumber2(int[] nums) {
        String[] strS = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strS[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strS, (s1, s2) -> {
            return (s1 + s2).compareTo(s2 + s1);
        });
        StringBuffer sb = new StringBuffer();
        for (String s : strS) {
            sb.append(s);
        }
        return sb.toString();
    }

}
