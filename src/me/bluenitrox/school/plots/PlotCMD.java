package me.bluenitrox.school.plots;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.utils.UUIDFetcher;
import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class PlotCMD implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (!(commandSender instanceof Player)) return true;

        Player player = (Player) commandSender;
        PlotInventory inventory = new PlotInventory(player.getUniqueId());
        if (args.length == 0) {
            player.openInventory(inventory.inventory());
            return true;
        } else if (args.length == 1) {
            switch (args[0]) {
                case "help":
                    player.sendMessage(MessageManager.PREFIX + "§7Plot Hilfe");
                    player.sendMessage("§8» §6/plot");
                    //Test
                    player.sendMessage("§8» §6/plot info");
                    player.sendMessage("§8» §6/plot home [Player]");
                    player.sendMessage("§8» §6/plot add <Player>");
                    player.sendMessage("§8» §6/plot remove <Player>");
                    player.sendMessage("§8» §6/plot ban <Player>");
                    player.sendMessage("§8» §6/plot unban <Player>");
                    player.sendMessage("§8» §6/plot kick <Player>");
                    break;
                case "info":
                    player.performCommand("plots info");
                    break;
                case "home":
                    player.performCommand("plots h");
                    player.playSound(player.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                    player.sendMessage(MessageManager.PREFIX + "§7Du hast dich zu deinem Plot §3teleportiert§7!");
                    DungeonManager dm = new DungeonManager();
                    dm.onQuitDungeon(player);
                    AngelminenManager.quitAngelmine(player);
                    break;
            }
        } else if (args.length == 2) {
            UUID uuid = UUIDFetcher.getUUID(args[1]);
            if (uuid == null) {
                player.sendMessage(MessageManager.PREFIX + "§6§l" + args[1] + " §7existiert nicht.");
                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                return true;
            }
            switch (args[0]) {
                case "add":
                    if(PlayerJoinManager.isUserExists(UUIDFetcher.getUUID(args[1]))) {
                        if (player.getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)) {
                            if(PlotManager.isalreadybanned(player.getUniqueId(), args[1])){
                                PlotManager.removePlayer(player.getUniqueId(), args[1]);
                            }
                            if(!PlotManager.isalreadyadded(player.getUniqueId(), args[1])) {
                                PlotManager.trustPlayer(player.getUniqueId(), args[1]);
                                player.performCommand("plots trust " + args[1]);
                                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                                player.sendMessage(MessageManager.PREFIX + "§7Du vertraust §6" + args[1] + "§7 nun!");
                            }else {
                                player.sendMessage(MessageManager.PREFIX + "§7Diesem Spieler vertraust du bereits!");
                                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            }
                        } else {
                            player.sendMessage(MessageManager.PREFIX + "§7Dazu musst du auf deinem plot sein!");
                            player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        }
                    }
                    break;
                case "remove":
                    if(PlayerJoinManager.isUserExists(UUIDFetcher.getUUID(args[1]))) {
                        if (player.getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)) {
                            PlotManager.removeAddPlayer(player.getUniqueId(), args[1]);
                            player.performCommand("plots remove " + args[1]);
                            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                            player.sendMessage(MessageManager.PREFIX + "§7Du vertraust §6" + args[1] + "§7 nun §cnichtmehr§7!");
                        } else {
                            player.sendMessage(MessageManager.PREFIX + "§7Dazu musst du auf deinem plot sein!");
                            player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        }
                    }
                    break;
                case "unban":
                    if(PlayerJoinManager.isUserExists(UUIDFetcher.getUUID(args[1]))) {
                        if (player.getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)) {
                            PlotManager.removePlayer(player.getUniqueId(), args[1]);
                            player.performCommand("plots remove " + args[1]);
                            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                            player.sendMessage(MessageManager.PREFIX + "§6" + args[1] + "§7 ist nun §cnichtmehr§7 gebannt!");
                        } else {
                            player.sendMessage(MessageManager.PREFIX + "§7Dazu musst du auf deinem plot sein!");
                            player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        }
                    }
                    break;
                case "ban":
                    if(PlayerJoinManager.isUserExists(UUIDFetcher.getUUID(args[1]))) {
                        if (player.getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)) {
                            if(PlotManager.isalreadyadded(player.getUniqueId(), args[1])){
                                PlotManager.removeAddPlayer(player.getUniqueId(), args[1]);
                            }
                            if (!PlotManager.isalreadybanned(player.getUniqueId(), args[1])) {
                                PlotManager.banPlayer(player.getUniqueId(), args[1]);
                                player.performCommand("plots deny " + args[1]);
                                player.playSound(player.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                                player.sendMessage(MessageManager.PREFIX + "§6" + args[1] + "§7 ist nun §cgebannt§7!");
                            }else {
                                player.sendMessage(MessageManager.PREFIX + "§7Diesen Spieler hast du bereits §cgebannt§7!");
                                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            }
                        } else {
                            player.sendMessage(MessageManager.PREFIX + "§7Dazu musst du auf deinem plot sein!");
                            player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        }
                    }
                    break;
                case "kick":
                    player.performCommand("plots kick " + args[1]);
                    player.sendMessage(MessageManager.PREFIX + "§7Du hast §6" + args[1] + "§7 von deinem Plot gekickt!");
                    player.playSound(player.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                    break;
            }
            switch (args[0]){
                case "home":
                    if(PlotManager.isUserExists(uuid)){
                        player.performCommand("plots h " + args[1]);
                        player.sendMessage(MessageManager.PREFIX + "§7Du bist nun auf dem Plot von §6" + args[1]);
                        player.playSound(player.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                        DungeonManager dm = new DungeonManager();
                        dm.onQuitDungeon(player);
                        AngelminenManager.quitAngelmine(player);
                    }
                    break;
            }
        }
        return false;
    }
}
