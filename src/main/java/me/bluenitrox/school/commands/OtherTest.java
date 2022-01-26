package me.bluenitrox.school.commands;

import me.bluenitrox.school.features.CaseAPI;
import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import net.minecraft.server.v1_8_R3.Enchantment;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import javax.swing.plaf.basic.BasicTabbedPaneUI;

public class OtherTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] strings) {
        Player p = (Player)cs;
        NBTTags nbt = new NBTTags(p.getItemInHand());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("Felix coole Picke").addEnchant(org.bukkit.enchantments.Enchantment.DIG_SPEED, 10, true).addEnchant(org.bukkit.enchantments.Enchantment.DURABILITY, 10, true).build());
        return false;
    }
}
