package me.bluenitrox.school.haendler.rangfeatures;

import me.bluenitrox.school.haendler.commands.Taxi;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TaxiCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        if(player.hasPermission(PermissionsManager.vip)) {
           Taxi.onInteract(player);
        } else {
            player.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
        }

        return false;
    }
}
