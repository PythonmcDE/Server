package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.features.InventoryLoader;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.managers.ScoreboardManager;
import me.bluenitrox.school.utils.Antidupe;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerJoinManager.cachPlayerData(p.getUniqueId());

        //p.getInventory().clear();
        InventoryLoader.loadInv(p);

        //

        org.bukkit.scoreboard.ScoreboardManager manager = (org.bukkit.scoreboard.ScoreboardManager) Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        Objective objective = board.registerNewObjective("showhealth", "health");
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.setDisplayName(" §6§lLevel");
        for(Player online : Bukkit.getOnlinePlayers()){
            online.setScoreboard(board);
        }
        p.setScoreboard(board);

        //

        ScoreboardManager.setBoard(p);
        p.setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage(null);
        p.teleport(new LocationManager("spawn").getLocation());
        Antidupe.checkInventory(e.getPlayer().getInventory(), e.getPlayer());
    }
}

