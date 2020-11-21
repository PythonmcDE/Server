package me.bluenitrox.school.ah;

import me.bluenitrox.school.SchoolMode;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class ItemTimeManager {

    int id;

    private int taskid;

    public static HashMap<Integer, Integer> time = new HashMap<>();

    public void startTicking(int id){
        new BukkitRunnable(){

            @Override
            public void run() {
                if(time.get(id) == 0){
                    AhManager.removeItem(id);
                    stop();
                }else {
                    time.put(id, time.get(id) - 1);
                }

            }
        }.runTaskTimerAsynchronously(SchoolMode.getInstance(), 20, 20);

    }
    public void stop(){
        Bukkit.getServer().getScheduler().cancelTask(this.taskid);
    }

    public String getTimeFromItem(int id){
        try {
            int sek = getTime(id);
            int min = 0;
            while(sek > 60){
                min ++;
                sek-=60;
            }
            if(sek < 10){
                return min + ":0" + sek;
            }
            return min + ":" + sek;
        }catch (Exception e){
            Bukkit.broadcastMessage(e.getMessage());
            return "0";
        }
    }

    public void setValues(int id, int time){
        this.time.put(id, time);
        startTicking(id);
    }

    public int getTime(int id){
        return this.time.get(id);
    }


}
