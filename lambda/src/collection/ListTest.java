package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author qihaodong
 */
public class ListTest {

    private void createComparator() {
        // JAVA8 前对字符串链表按长度进行排序
        List<String> list = Arrays.asList("x", "xx", "xxx", "xxxx", "xxxxx");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null) {
                    return -1;
                }
                if (o2 == null) {
                    return 1;
                }
                return o1.length() - o2.length();
            }
        });

        // 使用 lambda 表达式
        Collections.sort(list, (o1, o2) -> {
            if (o1 == null) {
                return -1;
            }
            if (o2 == null) {
                return 1;
            }
            return o1.length() - o2.length();
        });
    }

}