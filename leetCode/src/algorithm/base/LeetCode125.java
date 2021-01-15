package algorithm.base;

/**
 * @author qihaodong
 */
public class LeetCode125 {

    public static void main(String[] args) {
        new LeetCode125().isPalindrome("A man, a plan, a canal: Panama");
    }

    /**
     * 采用 StringBuffer 函数 reverse() 直接判断
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        String s1 = "";
        for (char c : s.toCharArray()) {
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                s1 += c;
            }
        }
        String s2 = new StringBuffer(s1).reverse().toString();
        return s1.equalsIgnoreCase(s2);
    }

    /**
     * 使用双指针法
     *
     * @param s
     * @return
     */
    public boolean isPalindrome2(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

}
