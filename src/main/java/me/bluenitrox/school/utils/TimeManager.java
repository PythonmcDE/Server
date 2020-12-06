package me.bluenitrox.school.utils;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeManager {

    public static boolean restartServer(){
        Date currentDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH-mm");
        if(sdf.format(currentDate).equalsIgnoreCase("03-07")){
            new BukkitRunnable(){
                @Override
                public void run() {
                    try(PreparedStatement ps1 = MySQL.getConnection().prepareStatement("DROP TABLE DailyReward")){
                        ps1.executeUpdate();
                    }catch (SQLException e){

                    }
                }
            }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*60);
            return true;
        }else if(sdf.format(currentDate).equalsIgnoreCase("11-07")){
            return true;
        }
        return false;
    }

}
