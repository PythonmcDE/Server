package me.bluenitrox.school.commands;

import me.bluenitrox.school.features.CaseAPI;
import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Bukkit;
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
        Bukkit.broadcastMessage(nbt.getNBTTag("invsafeid")+ "");
        return false;
    }
}
