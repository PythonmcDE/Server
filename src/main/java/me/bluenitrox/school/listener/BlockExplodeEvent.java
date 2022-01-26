package me.bluenitrox.school.listener;

import me.bluenitrox.school.managers.WorldManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockExplodeEvent implements Listener {

    @EventHandler
    public void onExplode(final org.bukkit.event.block.BlockExplodeEvent e){
        e.blockList().clear();
        e.setCancelled(true);
    }

}
