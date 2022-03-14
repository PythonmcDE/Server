package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.aufgabensystem.AufgabenMethods;
import me.bluenitrox.school.haendler.NPCAPI;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.managers.ScoreboardManager;
import me.bluenitrox.school.mine.minensettings.GetOptions;
import me.bluenitrox.school.mine.minensettings.SellOptions;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerJoinManager.cachPlayerData(p.getUniqueId());
        SchoolMode.playerwason.add(p.getUniqueId());

        NPCAPI.setJoinNPC(e);
        SellOptions sellOptions = new SellOptions();

        ScoreboardManager.setBoard(p);
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        if(new LocationManager("Spawn").getLocation() != null) {
            p.teleport(new LocationManager("spawn").getLocation());
        }
        PlayerRespawnEvent.erhaltItems(p);
        GetOptions.getMiningSettings().setInHashMap(e);
        SellOptions.getInstance().setInHashMap(e);
        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60*20, 1));
        AufgabenMethods.onJoin(e);
    }

}

