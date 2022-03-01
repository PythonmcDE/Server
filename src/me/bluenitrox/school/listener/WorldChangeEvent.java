package me.bluenitrox.school.listener;

import me.bluenitrox.school.haendler.NPCAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class WorldChangeEvent implements Listener {

    @EventHandler
    public void onChange(final PlayerChangedWorldEvent e){
        NPCAPI.destroyAllNPCS();
        NPCAPI.summonAllNPCS();
    }

}
