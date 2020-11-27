package me.bluenitrox.school.listener;

import me.bluenitrox.school.features.InventoryLoader;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.managers.ScoreboardManager;
import me.bluenitrox.school.utils.Antidupe;
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

        p.getInventory().clear();
        InventoryLoader.loadInv(p);

        PlayerJoinManager.updateBelowName(p);

        ScoreboardManager.setBoard(p);
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        p.teleport(new LocationManager("spawn").getLocation());
        Antidupe.checkInventory(e.getPlayer().getInventory(), e.getPlayer());
    }
}

