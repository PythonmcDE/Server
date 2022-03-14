package me.bluenitrox.school.commands.consolecommands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.seasonpass.SeasonpassManager;
import me.bluenitrox.school.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GoldPassAdd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof ConsoleCommandSender)) return true;

        if(!command.getName().equalsIgnoreCase("goldpassconsole")) return true;
        if(args.length == 2) {
            UUID uuid = UUIDFetcher.getUUID(args[1]);

            SeasonpassManager seasonpassManager = new SeasonpassManager();
            seasonpassManager.setGoldpass(uuid);

            Player player = Bukkit.getPlayer(uuid);
            if(player != null) {
                player.sendMessage(MessageManager.PREFIX + "§7Dein §6§lGoldpass §7wurde §aaktiviert§7. Danke für die §6§lUnterstützung§7!");
            }
        }

        return false;
    }
}
