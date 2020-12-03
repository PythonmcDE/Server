package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Clear implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 1){
            if(p.hasPermission(PermissionsManager.CLEAR)){
                Player t = (Player) Bukkit.getPlayer(args[0]);
                if(t != null) {
                    t.getInventory().clear();
                    t.sendMessage(MessageManager.PREFIX + "§7Dein Inventar wurde geleert");
                    p.sendMessage(MessageManager.PREFIX + "§7Das Inventar wurde geleert");
                }else {
                    p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                }
            }else {
                p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            }
        }else if(args.length == 0){
            if(p.hasPermission(PermissionsManager.CLEAR)){
                p.getInventory().clear();
                p.sendMessage(MessageManager.PREFIX + "§7Dein Inventar wurde geleert");
            }else {
                p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
