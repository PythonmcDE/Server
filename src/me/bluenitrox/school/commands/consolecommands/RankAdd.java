package me.bluenitrox.school.commands.consolecommands;

import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import eu.thesimplecloud.api.service.ICloudService;
import eu.thesimplecloud.module.permission.player.IPermissionPlayer;
import eu.thesimplecloud.module.permission.player.PlayerPermissionGroupInfo;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.GetDisplayColor;
import me.bluenitrox.school.utils.UUIDFetcher;
import me.bluenitrox.school.warzone.CombatAPI;
import me.daarkii.nicksystem.NickAddon;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RankAdd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(!(sender instanceof ConsoleCommandSender)) return true;

        if(command.getName().equalsIgnoreCase("rankconsole")) {

            if(args.length == 4) {

                UUID uuid = UUIDFetcher.getUUID(args[1]);

                IPermissionPlayer permissionPlayer = GetDisplayColor.getIPermissionPlayer(uuid);

                int duration = Integer.parseInt(args[3]);
                if(duration == -1) {
                    permissionPlayer.addPermissionGroup(new PlayerPermissionGroupInfo(args[2], -1));
                } else {
                    long timeout = System.currentTimeMillis() + TimeUnit.DAYS.toMillis(duration);
                    permissionPlayer.addPermissionGroup(new PlayerPermissionGroupInfo(args[2], timeout));
                }
                permissionPlayer.update();

                Player player = Bukkit.getPlayer(uuid);
                if(player != null) {
                    if(args[2].equalsIgnoreCase("vip")) {
                        player.sendMessage(MessageManager.PREFIX + "§7Dein §6§lVIP §7Rang wurde dir gutgeschrieben. Danke für deine §6§lUnterstützung§7!");
                    } else if(args[2].equalsIgnoreCase("python")) {
                        player.sendMessage(MessageManager.PREFIX + "§7Dein §a§lPython §7Rang wurde dir gutgeschrieben. Danke für deine §6§lUnterstützung§7!");
                    } else if(args[2].equalsIgnoreCase("king-queen")) {
                        ICloudPlayer iCloudPlayer = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(player.getUniqueId());
                        player.sendMessage(MessageManager.PREFIX + "§7Dein §5§lKing §7bzw §5§lQueen §7Rang wurde dir gutgeschrieben. Du wirst in die §6§lLobby §7verschoben um ihn zu konfigurieren. Danke für deine §6§lUnterstützung§7!");
                        if(CombatAPI.fight.containsKey(player)) {

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    if(!CombatAPI.fight.containsKey(player)) {
                                        this.cancel();
                                        iCloudPlayer.connect(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-1"));
                                    }
                                }
                            }.runTask(SchoolMode.getInstance());
                        } else {
                            iCloudPlayer.connect(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-1"));
                        }
                    }
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        NickAddon.getInstance().updateNameTags(all);
                    }
                }
            }


        }

        return false;
    }
}
