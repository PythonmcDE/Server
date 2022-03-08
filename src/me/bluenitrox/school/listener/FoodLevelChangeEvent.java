package me.bluenitrox.school.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.Random;

public class FoodLevelChangeEvent  implements Listener {

    @EventHandler
    public void onChange(final org.bukkit.event.entity.FoodLevelChangeEvent event){
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();

        int oldFoodLevel = player.getFoodLevel();
        int newFoodLevel = event.getFoodLevel();

        if(oldFoodLevel < newFoodLevel) return;

        Random r = new Random();
        int z = r.nextInt(5);
        switch (z){
            case 1:
                break;
            default:
                event.setCancelled(true);
                break;
        }
    }
}
