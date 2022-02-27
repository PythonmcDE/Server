package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.GetDisplayColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TK implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 1){
            Player t = Bukkit.getPlayer(args[0]);
            if(t != null) {
                if (p.hasPermission(PermissionsManager.TKCMD)) {
                    t.setVelocity(t.getVelocity().setX(0.5D));
                    t.setVelocity(t.getVelocity().setZ(0.5D));
                    t.setVelocity(t.getVelocity().setY(0.5D));
                    p.sendMessage(MessageManager.PREFIX + "§7Das Knockback von " + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(t.getUniqueId())) + "§7 wurde getestet!");

                }else {
                    p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                }
            }else {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
