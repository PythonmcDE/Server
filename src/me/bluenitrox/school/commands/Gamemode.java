package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(p.hasPermission(PermissionsManager.GAMEMODE) || p.hasPermission(PermissionsManager.GAMEMODE_OTHER) || p.hasPermission(PermissionsManager.ALLPERMS)) {
            if (args.length == 2) {
                if(p.hasPermission(PermissionsManager.GAMEMODE_OTHER) || p.hasPermission(PermissionsManager.ALLPERMS)){
                    if(args[0].equals("1") || args[0].equals("3") || args[0].equals("2") || args[0].equals("0")){
                        Player t = Bukkit.getPlayer(args[1]);
                        if(t == null){
                            p.sendMessage(MessageManager.PLAYERISOFFLINE(PlayerJoinManager.language));
                            return true;
                        }
                        t.setGameMode(toGamemode(Integer.parseInt(args[0])));
                        p.sendMessage(MessageManager.PLAYERSETGAMEMODE);
                        t.sendMessage(MessageManager.PLAYERWASSETGAMEMODE(PlayerJoinManager.language));
                        return true;
                    }
                    p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                    return true;
                }else {
                    p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
                    return true;
                }
            }else if(args.length == 1){
                if(args[0].equals("1") || args[0].equals("3") || args[0].equals("2") || args[0].equals("0")){
                    p.setGameMode(toGamemode(Integer.parseInt(args[0])));
                    p.sendMessage(MessageManager.SETOWNGAMEMODE);
                    return true;
                }
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
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

    public GameMode toGamemode(int i){
        if(i == 0){
            return GameMode.SURVIVAL;
        }else if(i == 1){
            return GameMode.CREATIVE;
        }else if(i == 2){
            return GameMode.ADVENTURE;
        }else {
            return GameMode.SPECTATOR;
        }
    }
}
