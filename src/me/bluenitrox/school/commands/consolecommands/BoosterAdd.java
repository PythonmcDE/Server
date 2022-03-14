package me.bluenitrox.school.commands.consolecommands;

import me.bluenitrox.school.boost.BoosterAPI;
import me.bluenitrox.school.boost.manager.BoosterManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class BoosterAdd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(command.getName().equalsIgnoreCase("consoleboosteradd")) {
            if(sender instanceof ConsoleCommandSender) {

                if (args.length == 4) {
                    String booster = args[2];
                    int amount = Integer.parseInt(args[3]);

                    Player player = Bukkit.getPlayer(args[1]);

                    UUID uuid;
                    BoosterAPI boosterAPI = new BoosterAPI();
                    if (player != null) {
                        uuid = player.getUniqueId();
                        boosterAPI.updateBooster(uuid, booster, amount, false);
                        player.sendMessage(MessageManager.PREFIX + "§7Deine §6§lBooster §7wurden dir gutgeschrieben! Danke für deine §6§lUnterstützung§7!");
                    } else {
                        uuid = UUIDFetcher.getUUID(args[1]);
                        boosterAPI.updateBoosterDatabase(uuid, booster, amount);
                    }

                }
            }
        }

        return false;
    }
}
