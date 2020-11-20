package me.bluenitrox.school.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerCommandPreprocessEvent implements Listener {

    @EventHandler
    public void onCommandSend(final org.bukkit.event.player.PlayerCommandPreprocessEvent e){
        Player p = (Player)e.getPlayer();
        p.sendMessage(e.getMessage());
    }

}
