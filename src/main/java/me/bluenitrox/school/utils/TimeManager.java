package me.bluenitrox.school.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManager {

    public static boolean restartServer(){
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm");
        if(sdf.format(currentDate).equalsIgnoreCase("03-07")){
            return true;
        }else if(sdf.format(currentDate).equalsIgnoreCase("11-07")){
            return true;
        }
        return false;
    }

}
