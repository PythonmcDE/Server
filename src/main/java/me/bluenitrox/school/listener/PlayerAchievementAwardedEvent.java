package me.bluenitrox.school.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerAchievementAwardedEvent implements Listener {

    @EventHandler
    public void onErfolg(final org.bukkit.event.player.PlayerAchievementAwardedEvent e){
        e.setCancelled(true);
    }

}
