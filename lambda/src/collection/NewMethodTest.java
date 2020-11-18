package collection;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/**
 * 本类主要介绍 JAVA8 新引入的方法
 *
 * @author qihaodong
 */
public class NewMethodTest {

    /**
     * 遍历所有集合元素，执行 accept() 方法
     * 输出所有长度大于 3 的字符串
     */
    private void testForEach() {
        List<String> list = Arrays.asList("x", "xx", "xxx", "xxxx", "xxxxx");
        // 传统方法
        for (String s : list) {
            if (s.length() > 3) {
                System.out.println(s);
            }
        }
        // 使用匿名内部类
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                if (s.length() > 3) {
                    System.out.println(s);
                }
            }
        });
        // 使用 lambda 表达式
        list.forEach(s1 -> {
            if (s1.length() > 3) {
                System.out.println(s1);
            }
        });
    }

    /**
     * 删除容器中所有满足条件的元素
     * 删除所有长度大于 3 的字符串
     */
    private void testRemoveIf() {
        List<String> list = Arrays.asList("x", "xx", "xxx", "xxxx", "xxxxx");
        // 传统方法
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().length() > 3) {
                it.remove();
            }
        }
        // 使用匿名内部类
        list.removeIf(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 3;
            }
        });
        // 使用 lambda 表达式，带大括号的情况
        list.removeIf(s -> {
            return s.length() > 3;
        });
        // lambda 表达式，不使用大括号
        list.removeIf(s -> s.length() > 3);
    }

    /**
     * 替换容器中所有元素
     * 如果长度大于 3，就在它后面再加上自己
     */
    private void testReplaceAll() {
        List<String> list = Arrays.asList("x", "xx", "xxx", "xxxx", "xxxxx");
        // 传统方法实现
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.length() > 3) {
                list.set(i, s + s);
            }
        }
        // 使用匿名内部类实现
        list.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.length() > 3) {
                    return s + s;
                }
                return s;
            }
        });
        // 使用 lambda 实现
        list.replaceAll(s -> {
            if (s.length() > 3) {
                s += s;
            }
            return s;
        });
    }

    /**
     * 测试排序方法
     * 按照字符串长度进行增序排序
     */
    private void testSort() {
        List<String> list = Arrays.asList("xxxxx", "xxxx", "xxx", "xx", "x");
        // 传统方法
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        // 传统方法改 lambda
        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
        // 使用匿名内部类
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        // 使用 lambda
        list.sort((s1, s2) -> s1.length() - s2.length());
    }

    /**
     * 返回容器的可拆分迭代器
     */
    private void testSpliterator() {
        List<String> list = Arrays.asList("xxxxx", "xxxx", "xxx", "xx", "x");
        Spliterator<String> spliterator = list.spliterator();
    }

}