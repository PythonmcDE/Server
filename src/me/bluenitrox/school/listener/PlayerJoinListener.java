package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.aufgabensystem.Aufgaben;
import me.bluenitrox.school.aufgabensystem.AufgabenMethods;
import me.bluenitrox.school.commands.School;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.managers.ScoreboardManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ArmorUtil;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerJoinManager.cachPlayerData(p.getUniqueId());
        SchoolMode.playerwason.add(p.getUniqueId());
        AufgabenMethods methods = new AufgabenMethods();

        PlayerJoinManager.updateBelowName(p);

        ScoreboardManager.setBoard(p);
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        if(new LocationManager("Spawn").getLocation() != null) {
            p.teleport(new LocationManager("spawn").getLocation());
        }
        PlayerRespawnEvent.erhaltItems(p);

        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60*20, 1));
        new BukkitRunnable(){
            @Override
            public void run() {
                AufgabenMethods.sendActionBar(p, Aufgaben.getTask(p), 20*60*60);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*5);
    }

}

