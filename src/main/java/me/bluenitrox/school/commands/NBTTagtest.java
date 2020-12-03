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
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).setLore(EnchantManager.schatzmeister, EnchantManager.AntiVenom + "I", EnchantManager.Kopfgeld + "X", EnchantManager.Assassine + "I").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setLore(EnchantManager.Heilzauber + "I", EnchantManager.Tank + "V").build());

        return false;
    }
}
