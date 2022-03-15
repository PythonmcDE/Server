package me.bluenitrox.school.seasonpass;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SeasonpassCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;
        SeasonpassInventorys inventorys = new SeasonpassInventorys(player); //get the Inventory from here

        //open Inventory
        player.openInventory(inventorys.normalPage());

        //a args.lenght check is useless in this Case because the only thing you can do with the seasonpass command is to open this inventory

        return false;
    }
}
