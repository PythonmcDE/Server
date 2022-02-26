package me.bluenitrox.school.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;

public class FoodLevelChangeEvent  implements Listener {

    @EventHandler
    public void onChange(final org.bukkit.event.entity.FoodLevelChangeEvent e){
        Random r = new Random();
        int z = r.nextInt(5);
        switch (z){
            case 1:
                break;
            default:
                e.setCancelled(true);
                break;
        }
    }
}
