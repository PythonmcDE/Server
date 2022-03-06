package me.bluenitrox.school.commands;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.haendler.NPCAPI;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.warzone.chests.ChestLoot;
import me.bluenitrox.school.warzone.chests.ChestsFuctions;
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
        ChestsFuctions cf = new ChestsFuctions();
        cf.spawnChest(1, 1);
        return false;
    }

}
