package me.bluenitrox.school.commands;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
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
            alreadystarted = true;
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
        new BukkitRunnable(){
            @Override
            public void run() {
                for(Player all: Bukkit.getOnlinePlayers()) {
                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §63 Minuten §7neu!");
                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 3 Minuten", 20, 20, 20);
                }
                this.cancel();
                new BukkitRunnable(){
                    @Override
                    public void run() {
                        for(Player all: Bukkit.getOnlinePlayers()) {
                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §62 Minuten §7neu!");
                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 2 Minuten", 20, 20, 20);
                        }
                        this.cancel();
                        new BukkitRunnable(){
                            @Override
                            public void run() {
                                for(Player all: Bukkit.getOnlinePlayers()) {
                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §630 Sekunden §7neu!");
                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 30 Sekunden", 20, 20, 20);
                                }
                                this.cancel();
                                new BukkitRunnable(){
                                    @Override
                                    public void run() {
                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §620 Sekunden §7neu!");
                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 20 Sekunden", 20, 20, 20);
                                        }
                                        this.cancel();
                                        new BukkitRunnable(){
                                            @Override
                                            public void run() {
                                                for(Player all: Bukkit.getOnlinePlayers()) {
                                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §610 Sekunden §7neu!");
                                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 10 Sekunden", 20, 20, 20);
                                                }
                                                this.cancel();
                                                new BukkitRunnable(){
                                                    @Override
                                                    public void run() {
                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §65 Sekunden §7neu!");
                                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 5 Sekunden", 20, 20, 20);
                                                        }
                                                        this.cancel();;
                                                        new BukkitRunnable(){
                                                            @Override
                                                            public void run() {
                                                                for(Player all: Bukkit.getOnlinePlayers()) {
                                                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §63 Sekunden §7neu!");
                                                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 3 Sekunden", 20, 20, 20);
                                                                }
                                                                this.cancel();
                                                                new BukkitRunnable(){
                                                                    @Override
                                                                    public void run() {
                                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §62 Sekunden §7neu!");
                                                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 2 Sekunden", 20, 20, 20);
                                                                        }
                                                                        this.cancel();
                                                                        new BukkitRunnable(){
                                                                            @Override
                                                                            public void run() {
                                                                                for(Player all: Bukkit.getOnlinePlayers()) {
                                                                                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §61 Sekunde §7neu!");
                                                                                    TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 1 Sekunde", 20, 20, 20);
                                                                                }
                                                                                this.cancel();
                                                                                new BukkitRunnable(){
                                                                                    @Override
                                                                                    public void run() {
                                                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                                                            Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §6jetzt §7neu!");
                                                                                            TTA_Methods.sendTitle(all, "§6§lServerneustart", 20, 20, 20, "§8» §7in 0 Sekunden", 20, 20, 20);
                                                                                        }
                                                                                        this.cancel();
                                                                                        Bukkit.setWhitelist(true);
                                                                                        for(Player all: Bukkit.getOnlinePlayers()) {
                                                                                            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "kick " + all.getName());
                                                                                        }
                                                                                        new BukkitRunnable(){
                                                                                            @Override
                                                                                            public void run() {
                                                                                                Bukkit.getServer().shutdown();
                                                                                            }
                                                                                        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*5);
                                                                                    }
                                                                                }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20);
                                                                            }
                                                                        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20);
                                                                    }
                                                                }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20);
                                                            }
                                                        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*2);
                                                    }
                                                }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*5);
                                            }
                                        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*10);
                                    }
                                }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*10);
                            }
                        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*30);
                    }
                }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*60);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*60);

    }

}
