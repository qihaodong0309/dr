package i20210708;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qihaodong
 */
public class Q1 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        if (groupSizes == null || groupSizes.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int temp = groupSizes[i];
            if (!map.containsKey(temp)) {
                List<Integer> list = new ArrayList<>();
                map.put(temp, list);
            }
            List<Integer> list = map.get(temp);
            list.add(i);
            if (list.size() == temp) {
                result.add(list);
                map.remove(temp);
            }
        }
        return result;
    }

}
