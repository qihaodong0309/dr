package mock_interview.i20210709;

/**
 * @author qihaodong
 */
public class Q2 {

    public boolean increasingTriplet(int[] nums) {
        int a = nums[0], b = -1, c = -1;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            if (b == -1) {
                if (temp > a) {
                    b = temp;
                } else {
                    a = temp;
                }
            } else {
                if (temp > b) {
                    return true;
                } else if (temp > a && temp <= b) {
                    b = temp;
                } else {
                    a = temp;
                }
            }
        }
        return false;
    }

}
