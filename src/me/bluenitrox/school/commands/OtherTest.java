package me.bluenitrox.school.commands;

import me.bluenitrox.school.enchants.Enchant;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class OtherTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        Player p = (Player)cs;
        NBTTags nbt = new NBTTags(p.getItemInHand());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("Felix coole Picke").addEnchant(org.bukkit.enchantments.Enchantment.DIG_SPEED, 10, true).addEnchant(org.bukkit.enchantments.Enchantment.DURABILITY, 10, true).setLore(EnchantManager.Rausch + "I").build());
        return false;
    }
}
