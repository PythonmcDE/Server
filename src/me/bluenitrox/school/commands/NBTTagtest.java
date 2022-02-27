package me.bluenitrox.school.commands;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.utils.ItemBuilder;
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
        p.getInventory().addItem(new ItemBuilder(Material.RAW_FISH,(short)1).setDisplayname("§7Roher Lachs").setAmount(64).build());
        p.getInventory().addItem(new ItemBuilder(Material.RAW_FISH).setDisplayname("§7Roher Fisch").setAmount(64).build());
        return false;
    }

}
