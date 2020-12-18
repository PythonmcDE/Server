package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(p.hasPermission(PermissionsManager.HEAL) || p.hasPermission(PermissionsManager.HEAL_OTHER) || p.hasPermission(PermissionsManager.ALLPERMS)) {
            if (args.length == 1) {
                if(p.hasPermission(PermissionsManager.HEAL_OTHER) || p.hasPermission(PermissionsManager.ALLPERMS)){
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t == null){
                        p.sendMessage(MessageManager.PLAYERISOFFLINE(PlayerJoinManager.language));
                        return true;
                    }
                    t.setHealth(t.getMaxHealth());
                    t.setFoodLevel(20);
                    p.sendMessage(MessageManager.PLAYERHEAL);
                    t.sendMessage(MessageManager.PLAYERWASHEAL(PlayerJoinManager.language));
                    return true;
                }else {
                    p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                    return true;
                }
            }else if(args.length == 0){
                p.setHealth(p.getMaxHealth());
                p.setFoodLevel(20);
                p.sendMessage(MessageManager.SETOWNHEALTH);
                return true;
            }else {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                return true;
            }
        }else {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }
    }
}
