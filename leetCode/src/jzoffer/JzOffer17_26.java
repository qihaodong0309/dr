package jzoffer;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author qihaodong
 */
public class JzOffer17_26 {

    public static void main(String[] args) {
        double d = 114.1455;
        d = (double) Math.round(d * 1000) / 1000;
        System.out.println(d);
    }

    public List<String> computeSimilarities(int[][] docs) {
        List<String> result = new ArrayList<>();
        if (docs.length == 0) {
            return result;
        }
        int n = docs.length;
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int[] temp = docs[i];
            for (int j : temp) {
                set.add(j);
            }
            for (int j = i + 1; j < n; j++) {
                int[] temp2 = docs[j];
                int jj = 0, bj = set.size();
                for (int z : temp2) {
                    if (set.contains(z)) {
                        jj++;
                    } else {
                        bj++;
                    }
                }
                if (jj != 0) {
                    double value = (jj * 1.0) / bj;
                    value = (double) Math.round(value * 10000) / 10000;
                    result.add(i + "," + j + ": " + decimalFormat.format(value));
                }
            }
            set.clear();
        }
        return result;
    }

}
