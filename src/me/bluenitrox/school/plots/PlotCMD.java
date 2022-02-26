package me.bluenitrox.school.plots;

import me.bluenitrox.school.commands.Build;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.UUIDFetcherWithName;
import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class PlotCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player)) return true;

        Player player = (Player)commandSender;
        PlotInventory inventory = new PlotInventory(player.getUniqueId());
        switch (args.length) {
            case 1:
                player.sendMessage(MessageManager.PREFIX + "§7Plot Hilfe");
                player.sendMessage("§8» §6/plot");
                player.sendMessage("§8» §6/plot add");
                player.sendMessage("§8» §6/plot remove");
                player.sendMessage("§8» §6/plot ");
                break;
            case 2:
                Player target = Bukkit.getPlayer(args[0]);
                UUID uuid = UUIDFetcherWithName.getUUID(target.getName());
                if(uuid == null) {
                    player.sendMessage(MessageManager.PREFIX + "§6§l" + args[0] + " §7existiert nicht.");
                    return true;
                }

                switch (args[0]) {
                    case "add":
                        break;
                    case "remove":
                        break;
                    case "ban":
                        break;
                }
                break;
            default:
                player.openInventory(inventory.inventory());
        }
        return false;
    }
}
