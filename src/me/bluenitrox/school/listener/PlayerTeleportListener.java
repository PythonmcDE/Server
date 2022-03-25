package me.bluenitrox.school.listener;

import io.github.znetworkw.znpcservers.npc.NPC;
import io.github.znetworkw.znpcservers.user.ZUser;
import me.bluenitrox.school.SchoolMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerTeleportListener implements Listener {

    @EventHandler
    public void onTeleport(PlayerTeleportEvent e){
        if(e.getCause()== PlayerTeleportEvent.TeleportCause.COMMAND){
            //NPCAPI.updateNPCs(e.getPlayer());
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60*10, 1));
        }
        if(e.getCause()== PlayerTeleportEvent.TeleportCause.PLUGIN){
            //NPCAPI.updateNPCs(e.getPlayer());

            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60*10, 1));
        }
    }


}
