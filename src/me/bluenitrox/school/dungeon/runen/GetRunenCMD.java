package me.bluenitrox.school.dungeon.runen;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetRunenCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        RunenUtils utils = new RunenUtils();
        if(!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        player.getInventory().addItem(utils.getRune("darkness_rune"));
        player.getInventory().addItem(utils.getRune("engels_rune"));
        player.getInventory().addItem(utils.getRune("regeneration_rune"));
        player.getInventory().addItem(utils.getRune("strenght_rune"));
        player.getInventory().addItem(utils.getRune("fastmine_rune"));
        player.getInventory().addItem(utils.getRune("earth_rune"));
        player.getInventory().addItem(utils.getRune("speed_rune"));
        player.getInventory().addItem(utils.getRune("fire_rune"));
        player.getInventory().addItem(utils.getRune("water_rune"));
        return false;
    }
}
