package me.bluenitrox.school.commands;

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

public class Fly implements CommandExecutor {

    public static ArrayList<UUID> isflying = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(p.hasPermission(PermissionsManager.FLY) || p.hasPermission(PermissionsManager.FLY_OTHER) || p.hasPermission(PermissionsManager.ALLPERMS)) {
            if (args.length == 1) {
                if(p.hasPermission(PermissionsManager.FLY_OTHER) || p.hasPermission(PermissionsManager.ALLPERMS)){
                    Player t = Bukkit.getPlayer(args[0]);
                    if(t == null){
                        p.sendMessage(MessageManager.PLAYERISOFFLINE(PlayerJoinManager.language));
                        return true;
                    }
                    if(isflying != null){
                        if(isflying.contains(t.getUniqueId())) {
                            t.setAllowFlight(false);
                            t.setFlying(false);
                            isflying.remove(p.getUniqueId());
                            p.sendMessage(MessageManager.SETFLYOTHERFALSE);
                            t.sendMessage(MessageManager.WASSETFLYFALSE(PlayerJoinManager.language));
                        } else {
                            t.setAllowFlight(true);
                            t.setFlying(true);
                            isflying.add(p.getUniqueId());
                            p.sendMessage(MessageManager.SETFLYOTHERTRUE);
                            t.sendMessage(MessageManager.WASSETFLYTRUE(PlayerJoinManager.language));
                        }
                    }else {
                        t.setAllowFlight(true);
                        t.setFlying(true);
                        isflying.add(p.getUniqueId());
                        p.sendMessage(MessageManager.SETFLYOTHERTRUE);
                        t.sendMessage(MessageManager.WASSETFLYTRUE(PlayerJoinManager.language));
                    }
                    return true;
                }else {
                    p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                    return true;
                }
            }else if(args.length == 0){
                if(isflying != null){
                    if(isflying.contains(p.getUniqueId())) {
                        p.setAllowFlight(false);
                        p.setFlying(false);
                        isflying.remove(p.getUniqueId());
                        p.sendMessage(MessageManager.SETOWNFLYFALSE);
                    } else {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        isflying.add(p.getUniqueId());
                        p.sendMessage(MessageManager.SETOWNFLYTRUE);
                    }
                }else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    isflying.add(p.getUniqueId());
                    p.sendMessage(MessageManager.SETOWNFLYTRUE);
                }
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
