package me.bluenitrox.school.commands.rangfeatures;

import me.bluenitrox.school.enchants.CraftAPI;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Anvil implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;
        if(!player.hasPermission(PermissionsManager.vip)) {
            player.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }
        CraftAPI craftAPI = new CraftAPI();
        player.openInventory(craftAPI.openCraftInv(player));
        return false;
    }

}
