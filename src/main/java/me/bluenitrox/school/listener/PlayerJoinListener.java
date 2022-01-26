package me.bluenitrox.school.listener;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
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

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerJoinManager.cachPlayerData(p.getUniqueId());
        SchoolMode.playerwason.add(p.getUniqueId());

        p.getInventory().clear();
        ArmorUtil.setArmorNull(p);

        PlayerJoinManager.updateBelowName(p);

        ScoreboardManager.setBoard(p);
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        p.teleport(new LocationManager("spawn").getLocation());
        PlayerRespawnEvent.erhaltItems(p);
        Antidupe.checkInventory(e.getPlayer().getInventory(), e.getPlayer());
    }

}

