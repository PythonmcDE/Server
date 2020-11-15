package me.bluenitrox.school.commands;

import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class NBTTagtest implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        ItemStack i = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§bMashala krass").build();
        NBTTags nbt = new NBTTags(i);
        nbt.setNBTTag("Coolness", "400");
        p.getInventory().addItem(i);
        return false;
    }
}
