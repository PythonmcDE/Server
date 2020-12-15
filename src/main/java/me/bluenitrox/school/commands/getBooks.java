package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class getBooks implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] strings) {
        Player p = (Player)cs;
        if(p.hasPermission(PermissionsManager.ALLPERMS)){
            p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setLore(EnchantManager.Tank + "I").build());
        }
        return false;
    }
}
