package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Vanish implements CommandExecutor {

    public static List<Player> vanished = new ArrayList<>();


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(MessageManager.PREFIX + "§cDazu musst du ein Spieler sein!");
            return true;
        }
        Player p = (Player) sender;

        if(CombatAPI.fight != null) {
            if (CombatAPI.fight.containsKey(p)) {
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                p.sendMessage(MessageManager.CANTDOINFIGHT);
                return true;
            }
        }


        if(!p.hasPermission(PermissionsManager.VANISH)) {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }

        if(args.length == 0) {
            if (vanished.contains(p)) {
                vanished.remove(p);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast den Vanishmodus §cverlassen§7!");
                for (Player all : Bukkit.getOnlinePlayers()) {
                    all.showPlayer(p);
                }
            } else {
                vanished.add(p);
                p.sendMessage(MessageManager.PREFIX + "§7Du hast den Vanishmodus §abetreten§7!");
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if (!all.hasPermission(PermissionsManager.team)) {
                        all.hidePlayer(p);
                    }
                }
            }
        }
        return false;
    }

}
