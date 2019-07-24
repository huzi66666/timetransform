import util.TimeUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Created by weijun on 2016/6/14.
 */
public class testTime {
    public static void main(String[] args){
        //long ==> string
        long t1=1463626800000L;
        String r1=TimeUtil.getTargetStringTime(t1,0);
        System.out.println(t1+","+r1);

        String r3=TimeUtil.getTargetStringTime(t1,-3);
        System.out.println(t1+","+r3);

        String r4=TimeUtil.getTargetStringTime(t1,8);
        System.out.println(t1+","+r4);

        //string ==> long
       /* String t2="2016-5-19 00:00:00";
        long r2=TimeUtil.getTargetLongTime(t2, -3);
        System.out.println(r2+","+t2);*/



    }




}
