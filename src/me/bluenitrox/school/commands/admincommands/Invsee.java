package me.bluenitrox.school.commands.admincommands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Invsee implements CommandExecutor {

    public static ArrayList<UUID> invsee = new ArrayList();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(MessageManager.PREFIX + "§cDazu musst du ein Spieler sein!");
            return true;
        }
        Player p = (Player) sender;

        if(!p.hasPermission(PermissionsManager.INVSEE)) {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
        }
        else if(args.length == 0) {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        else if(args.length == 1) {
            if(!p.hasPermission(PermissionsManager.INVSEE)) {
                p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                return true;
            }
            Player target = Bukkit.getPlayer(args[0]);
            if(target == null ) {
                p.sendMessage(MessageManager.PREFIX + "§7Dieser Spieler ist nicht online!");
                return true;
            }
            p.openInventory(target.getInventory());
            p.sendMessage(MessageManager.PREFIX + "§7Du schaust nun in das §aIntentar §7von §6" + target.getName() +".");
            invsee.contains(p.getUniqueId());


        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}