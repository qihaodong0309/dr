package time;

/**
 * @author qihaodong
 */
public class TimeUtil {

    public static void main(String[] args) {
        TimeUtil timeUtil = new TimeUtil();
    }

    /**
     * Long 毫秒值转 xx(时)-xx(分)-xx(秒)
     * 调用该方法不要超过 24 小时
     *
     * @param time
     * @return
     */
    private String LongToHourMinuteSecond(Long time) {
        long hourTemp = time / (1000 * 60 * 60);
        long minuteTemp = (time % (1000 * 60 * 60)) / (1000 * 60);
        long secondTemp = (time % (1000 * 60)) / 1000;
        String hour = String.valueOf(hourTemp).length() == 1 ?
                "0" + hourTemp : String.valueOf(hourTemp);
        String minute = String.valueOf(minuteTemp).length() == 1 ?
                "0" + minuteTemp : String.valueOf(minuteTemp);
        String second = String.valueOf(secondTemp).length() == 1 ?
                "0" + secondTemp : String.valueOf(secondTemp);
        return hour + ":" + minute + ":" + second;
    }

}
