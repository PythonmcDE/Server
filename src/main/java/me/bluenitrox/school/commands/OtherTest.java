package me.bluenitrox.school.commands;

import me.bluenitrox.school.utils.Antidupe;
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
        if(p.getInventory().getItemInHand() != null) {
            if(p.getItemInHand().getItemMeta() != null) {
                NBTTags nbt = new NBTTags(p.getItemInHand());
                p.sendMessage(Antidupe.nextItemID + "");
                if (nbt.getNBTTag("antidupe") != null) {
                    p.sendMessage(nbt.getNBTTag("antidupe").toString());
                }
                Antidupe.checkInventory(p.getInventory());
            }
        }
        return false;
    }
}
