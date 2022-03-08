package me.bluenitrox.school.commands.admincommands;

import de.Herbystar.TTA.TTA_Methods;
import eu.thesimplecloud.api.CloudAPI;
import eu.thesimplecloud.api.player.ICloudPlayer;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.NameFetcher;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StopCommand implements CommandExecutor {

    public static boolean alreadystarted = false;

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(alreadystarted){
            cs.sendMessage(MessageManager.PREFIX + "§7Der Server startet §cbereits §7neu!");
            return true;
        }
        if(args.length == 0){
            restartServer();
        }else if(args.length == 1){
            if(args[0].equalsIgnoreCase("skip")){
                Bukkit.setWhitelist(true);
                for(Player all : Bukkit.getOnlinePlayers()){
                    all.kickPlayer("§7Der Server startet nun neu!");
                }
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        Bukkit.getServer().shutdown();
                    }
                }.runTaskLater(SchoolMode.getInstance(), 20*5);
            }else {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }

    public static void restartServer(){
        alreadystarted = true;
        for(Player all: Bukkit.getOnlinePlayers()) {
            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §63 Minuten §7neu!");
            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 3 Minuten", 20, 20, 20);
            all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
        }
        new BukkitRunnable(){
            @Override
            public void run() {
                for(Player all: Bukkit.getOnlinePlayers()) {
                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §62 Minuten §7neu!");
                    all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 2 Minuten", 20, 20, 20);
                }
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        for(Player all: Bukkit.getOnlinePlayers()) {
                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §61 Minute §7neu!");
                            all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 1 Minute", 20, 20, 20);
                        }
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                for(Player all: Bukkit.getOnlinePlayers()) {
                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §630 Sekunden §7neu!");
                                    all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 30 Sekunden", 20, 20, 20);
                                }
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §620 Sekunden §7neu!");
                                            all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 20 Sekunden", 20, 20, 20);
                                        }
                                        new BukkitRunnable(){
                                            @Override
                                            public void run() {
                                                for(Player all: Bukkit.getOnlinePlayers()) {
                                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §610 Sekunden §7neu!");
                                                    all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 10 Sekunden", 20, 20, 20);
                                                }
                                                new BukkitRunnable(){
                                                    @Override
                                                    public void run() {
                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §65 Sekunden §7neu!");
                                                            all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 5 Sekunden", 20, 20, 20);
                                                        }
                                                        SchoolMode.registerMine();
                                                        Bukkit.broadcastMessage("minenreset");
                                                        new BukkitRunnable(){
                                                            @Override
                                                            public void run() {
                                                                for(Player all: Bukkit.getOnlinePlayers()) {
                                                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §63 Sekunden §7neu!");
                                                                    all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 3 Sekunden", 20, 20, 20);
                                                                }
                                                                new BukkitRunnable(){
                                                                    @Override
                                                                    public void run() {
                                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §62 Sekunden §7neu!");
                                                                            all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 2 Sekunden", 20, 20, 20);
                                                                        }
                                                                        new BukkitRunnable(){
                                                                            @Override
                                                                            public void run() {
                                                                                for(Player all: Bukkit.getOnlinePlayers()) {
                                                                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet in §61 Sekunde §7neu!");
                                                                                    all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                                                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 1 Sekunde", 20, 20, 20);
                                                                                }
                                                                                new BukkitRunnable(){
                                                                                    @Override
                                                                                    public void run() {
                                                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server startet §6jetzt §7neu!");
                                                                                            all.playSound(all.getLocation(), Sound.NOTE_BASS, 1L, 1L);
                                                                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 0 Sekunden", 20, 20, 20);
                                                                                        }
                                                                                        Bukkit.setWhitelist(true);
                                                                                        if(CombatAPI.fight != null) {
                                                                                            CombatAPI.fight.clear();
                                                                                            CombatAPI.fightwarzone.clear();
                                                                                        }
                                                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                                                            ICloudPlayer player = CloudAPI.getInstance().getCloudPlayerManager().getCachedCloudPlayer(NameFetcher.getName(all.getUniqueId()));
                                                                                            player.connect(CloudAPI.getInstance().getCloudServiceManager().getCloudServiceByName("Lobby-1"));
                                                                                        }
                                                                                        new BukkitRunnable(){
                                                                                            @Override
                                                                                            public void run() {
                                                                                                Bukkit.getServer().shutdown();
                                                                                            }
                                                                                        }.runTaskLater(SchoolMode.getInstance(), 20*5);
                                                                                    }
                                                                                }.runTaskLater(SchoolMode.getInstance(), 20);
                                                                            }
                                                                        }.runTaskLater(SchoolMode.getInstance(), 20);
                                                                    }
                                                                }.runTaskLater(SchoolMode.getInstance(), 20);
                                                            }
                                                        }.runTaskLater(SchoolMode.getInstance(), 20*2);
                                                    }
                                                }.runTaskLater(SchoolMode.getInstance(), 20*5);
                                            }
                                        }.runTaskLater(SchoolMode.getInstance(), 20*10);
                                    }
                                }.runTaskLater(SchoolMode.getInstance(), 20*10);
                            }
                        }.runTaskLater(SchoolMode.getInstance(), 20*30);
                    }
                }.runTaskLater(SchoolMode.getInstance(), 20*60);
            }
        }.runTaskLater(SchoolMode.getInstance(), 20*60);

    }

}
