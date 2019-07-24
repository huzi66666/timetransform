package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by cocky on 2016/3/21.
 */
public class TimeUtil {
    /**
     * 把时间转换成毫秒
     * @param strTime  字符串格式时间
     * @param zone  时区
     * @return  毫秒数
     */
    public static long getTargetLongTime(String strTime, String zone){
        SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fmt.setTimeZone(getTimeZoneStr(zone));
        long targetTime=0L;
        try{
            targetTime=fmt.parse(strTime).getTime();
            //targetTime=TimeUtil.getNDayOn000000Ago(m,0);
        }catch(Exception e){
            e.printStackTrace();
        }
        return targetTime;
    }



    public static  TimeZone getTimeZoneStr(String zoneStr){
        TimeZone timeZone=null;
        try{
            int zone=Integer.parseInt(zoneStr);
            if(zone > 0){
                timeZone=TimeZone.getTimeZone("GMT+" + zone);
            }else{
                timeZone=TimeZone.getTimeZone("GMT" + zone);
            }
        }catch (Exception e){
            e.printStackTrace();
            timeZone=TimeZone.getTimeZone(zoneStr);
        }
        return timeZone;
    }

    public static  TimeZone getTimeZone(int zone){
        TimeZone timeZone = null;
        if (zone > 0) {
            timeZone = TimeZone.getTimeZone("GMT+" + zone);
        } else {
            timeZone = TimeZone.getTimeZone("GMT" + zone);
        }
        return timeZone;
    }

  /*  public static long getLontTime(Long time,int zone){
        Calendar c = Calendar.getInstance();
        c.setTimeZone(getTimeZone(zone));
        c.setTimeInMillis(time);
        return c.getTimeInMillis();
    }*/


    /**
     * 把毫秒转换成格式化时间
     * @param ltime  毫秒时间
     * @param zone  时区
     * @return  格式化后字符串时间
     */
    public static String getTargetStringTime(Long ltime,int zone){
        SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fmt.setTimeZone(getTimeZone(zone));
        String sTime=fmt.format(new Date(ltime));
        return sTime;
    }
    public static String getTargetStringTime(Long ltime,String zone){
        SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fmt.setTimeZone(getTimeZoneStr(zone));
        String sTime=fmt.format(new Date(ltime));
        return sTime;
    }

    /**
     * 获取几天前的时间 0时0分0秒
     * @param time
     * @param N
     * @return
     */
   /* public static long getNDayOn000000Ago( long time,int N,TimeZone tz) {
        Calendar c = Calendar.getInstance();
        c.setTimeZone(tz);
        c.setTimeInMillis(time);
        c.add(Calendar.DAY_OF_MONTH, N);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTimeInMillis();
    }*/


    /**
     * 获取几天前的时间 23时59分59秒
     * @param time
     * @param N
     * @return
     */
   /* public static long getNDayOn235959Ago( long time,int N,TimeZone tz) {

        Calendar c = Calendar.getInstance();
        c.setTimeZone(tz);
        c.setTimeInMillis(time);
        c.add(Calendar.DAY_OF_MONTH, N);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        return c.getTimeInMillis();
    }*/

}
