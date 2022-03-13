package me.bluenitrox.school.seasonpass;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class SeasonpassCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) return true;

        Player player = (Player) sender;

        SeasonpassInventorys inventorys = new SeasonpassInventorys(player);

        player.openInventory(inventorys.normalPage());

        return false;
    }
}
