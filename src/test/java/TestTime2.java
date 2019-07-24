/**
 * Created by weijun on 2016/10/17.
 */
import util.TimeUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
public class TestTime2 {
    private static void testDayTime(TimeZone timeZone) {
        System.out.println("Time Zone is : " + timeZone.getDisplayName() + " : " + timeZone.getID());

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar start = Calendar.getInstance(timeZone);
        start.setTime(new Date(0)); // UTC 1970-01-01
        System.out.println("start=" + df.format(start.getTime()));  // will print: start=1970-01-01 08:00:00

        Calendar end = Calendar.getInstance(timeZone);
        end.add(Calendar.YEAR, 5);
        System.out.println("end=" + df.format(end.getTime()));


        boolean find = false;
        for (long i = start.getTimeInMillis(); i < end.getTimeInMillis(); i = start.getTimeInMillis()) {
            start.add(Calendar.DATE, 1); // add one day

            if ((start.getTimeInMillis() - i) % (24 * 3600 * 1000L) != 0) { // 是否能被24整除
                find = true;

                System.out.println("from " + df.format(new Date(i)) + " to " + df.format(start.getTime()) + " has "
                        + (start.getTimeInMillis() - i) + "ms" + "[" + (start.getTimeInMillis() - i) / (3600 * 1000L)
                        + "hours]");
            }

        }

        if (!find) {
            System.out.println("Every day is ok.");
        }
    }

    public static void main(String[] args) {

      /*  String[] ss=TimeZone.getAvailableIDs();
        for (String s:ss){
            System.out.println(s);
        }
*/
        //Time Zone is : 中国标准时间 : Asia/Shanghai
       // TimeZone timeZone = TimeZone.getDefault();
        //TestTime2.testDayTime(timeZone);
        TimeZone timeZone=TimeZone.getTimeZone("America/Los_Angeles");
        //TestTime2.testDayTime(timeZone);
        //Etc/GMT-8

        //Time Zone is : GMT+08:00 : Etc/GMT-8
        TimeZone tz=TimeZone.getTimeZone("Etc/GMT+7");
       // TestTime2.testDayTime(tz);


       // long t1=1414918799000L;
        long t1=1414918800000L;
       // String r1= TimeUtil.getTargetStringTime(t1, 0);
        SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        fmt.setTimeZone(timeZone);
        String sTime=fmt.format(new Date(t1));

        System.out.println(t1 + "," + sTime);

       // String r3=TimeUtil.getTargetStringTime(t1, -3);
        fmt.setTimeZone(tz);
        String sTime2=fmt.format(new Date(t1));

        System.out.println(t1+","+sTime2);






       /* System.out.println(" -------------------- ");
        timeZone = TimeZone.getTimeZone("GMT");
        TestTime2.testDayTime(timeZone);
        System.out.println(" -------------------- ");

        timeZone = TimeZone.getTimeZone("America/Los_Angeles");
        TestTime2.testDayTime(timeZone);*/
    }

}
