package ink.gfwl.util.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author jianpòlan
 * @version 1.0
 **/
public class TimeUtils {

    private final static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年
     */
    public final static int YEAR = 1;

    /**
     * 月
     */
    public final static int MONTH = 2;

    /**
     * 日
     */
    public final static int DATE = 3;

    /**
     * 时
     */
    public final static int HOUR = 4;

    /**
     * 分
     */
    public final static int MINUTE = 5;

    /**
     * 秒
     */
    public final static int SECOND = 6;

    /**
     * 时间格式化
     * @param data 时间
     * @return 格式化结果
     */
    public static String format(Date data){
        return new SimpleDateFormat(FORMAT_FULL).format(data);
    }

    /**
     * 时间格式化
     * @param data 时间
     * @return 格式化结果
     */
    public static String format(long data){
        return new SimpleDateFormat(FORMAT_FULL).format(data);
    }

    /**
     * 获取秒
     * @param timeUnit 类型
     * @return 秒
     */
    public static long getTimeSeconds(int timeUnit){
        Calendar calendar = Calendar.getInstance();
        if(timeUnit <= SECOND){
            calendar.set(Calendar.MILLISECOND, 0);
        }
        if(timeUnit <= MINUTE){
            calendar.set(Calendar.SECOND, 0);
        }
        if(timeUnit <= HOUR){
            calendar.set(Calendar.MINUTE, 0);
        }
        if(timeUnit <= DATE){
            calendar.set(Calendar.HOUR_OF_DAY, 0);
        }
        if(timeUnit <= MONTH){
            calendar.set(Calendar.DATE, 1);
        }
        if(timeUnit <= YEAR){
            calendar.set(Calendar.MONTH, 0);
        }
        return calendar.getTimeInMillis() / 1000;
    }

    public static void main(String[] args) {
        long timeSeconds = getTimeSeconds(TimeUtils.YEAR);
        System.out.println(format(timeSeconds*1000));
    }
}
