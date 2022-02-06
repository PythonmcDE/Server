package me.bluenitrox.school.commands;

import eu.thesimplecloud.api.player.PlayerServerConnectState;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveSchoolXP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] strings) {
        if(cs.hasPermission("*")){
            Player player = (Player) cs;
            player.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 100000 XP").setAmount(64).build());
        }
        return false;
    }


}
