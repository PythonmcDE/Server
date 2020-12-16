package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NBTTagtest implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;

        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("LELE").setLore(EnchantManager.Tank + "I").build());

        return false;
    }
}
