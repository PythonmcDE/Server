package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tphere implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;

        if(p.hasPermission(PermissionsManager.TP)) {
            if(args.length == 1) {
                if(Bukkit.getPlayer(args[0]) != null) {
                    Player t = Bukkit.getPlayer(args[0]);
                    t.teleport(p);
                    t.getLocation();
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast den Spieler §6" + t.getName() + " §7zu dir teleportiert");
                }
                else {
                    p.sendMessage(MessageManager.PREFIX + "§7Der Spieler ist nicht online!");
                }
            }
            else {
                p.sendMessage(MessageManager.PREFIX + "§7Nutze: §6/tphere <Spieler>");
            }
        } else {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
        }
        return true;
    }
}
