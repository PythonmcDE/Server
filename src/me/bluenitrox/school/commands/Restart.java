package me.bluenitrox.school.commands;

import de.Herbystar.TTA.TTA_Methods;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Restart implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args){
        if(cs.hasPermission(PermissionsManager.ALLPERMS)) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet §6jetzt §7neu!");
                all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 0 Sekunden", 20, 20, 20);
            }
            Bukkit.setWhitelist(true);
            if (CombatAPI.fight != null) {
                CombatAPI.fight.clear();
                CombatAPI.fightwarzone.clear();
            }
            for (Player all : Bukkit.getOnlinePlayers()) {
                ICloudPlayer player = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(all.getName());
                player.connect(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-1"));
            }
            new BukkitRunnable() {
                @Override
                public void run() {
                    Bukkit.getServer().shutdown();
                }
            }.runTaskLater(SchoolMode.getInstance(), 20 * 5);
        }
        return false;
    }
}
