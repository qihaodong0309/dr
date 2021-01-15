package collection.array;

/**
 * @author qihaodong
 */
public class LeetCode208 {

    public static void main(String[] args) {
        LeetCode208 l = new LeetCode208();
        l.insert("apple");
        System.out.println(l.search("apple"));
        System.out.println(l.search("app"));
        System.out.println(l.startsWith("app"));
        l.insert("app");
        System.out.println(l.search("app"));
    }

    public LeetCode208() {
        head = new Node();
    }

    Node head = null;

    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Node temp = head;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            int num = word.charAt(i) - 'a';
            if (temp.child[num] == null) {
                temp.child[num] = new Node();
            }
            temp = temp.child[num];
            if (i == n - 1) {
                temp.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        Node temp = head;
        for (char c : word.toCharArray()) {
            int num = c - 'a';
            if (temp.child[num] == null) {
                return false;
            }
            temp = temp.child[num];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return false;
        }
        Node temp = head;
        for (char c : prefix.toCharArray()) {
            int num = c - 'a';
            if (temp.child[num] == null) {
                return false;
            }
            temp = temp.child[num];
        }
        return true;
    }

    class Node {
        Node[] child = new Node[26];
        boolean isEnd;

        public Node() {
            isEnd = false;
        }
    }

}
