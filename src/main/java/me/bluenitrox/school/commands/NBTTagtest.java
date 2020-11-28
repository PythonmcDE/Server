package me.bluenitrox.school.commands;

import me.bluenitrox.school.enchants.Schatzmeister;
import me.bluenitrox.school.features.InventoryLoader;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import java.io.IOException;

public class NBTTagtest implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).setLore(EnchantManager.schatzmeister).build());

        return false;
    }
}
