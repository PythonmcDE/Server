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
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 0){
            new BukkitRunnable(){
                @Override
                public void run() {
                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §63 Minuten §7neu!");
                    TTA_Methods.sendTitle(p, "§6§lServerneustart",20,20,20,"§8» §7in 3 Minuten",20,20,20);
                    this.cancel();
                }
            }.runTaskLater(SchoolMode.getInstance(), 20*60);
            new BukkitRunnable(){
                @Override
                public void run() {
                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §62 Minuten §7neu!");
                    TTA_Methods.sendTitle(p, "§6§lServerneustart",20,20,20,"§8» §7in 2 Minuten",20,20,20);
                    this.cancel();
                }
            }.runTaskLater(SchoolMode.getInstance(), 20*60);
            new BukkitRunnable(){
                @Override
                public void run() {
                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §630 Sekunden §7neu!");
                    TTA_Methods.sendTitle(p, "§6§lServerneustart",20,20,20,"§8» §7in 30 Sekunden",20,20,20);
                    this.cancel();
                }
            }.runTaskLater(SchoolMode.getInstance(), 20*30);
            new BukkitRunnable(){
                @Override
                public void run() {
                    Bukkit.broadcastMessage(MessageManager.PREFIX + "§7Der Server Startet in §620 Sekunden §7neu!");
                    TTA_Methods.sendTitle(p, "§6§lServerneustart",20,20,20,"§8» §7in 20 Sekunden",20,20,20);
                    this.cancel();
                }
            }.runTaskLater(SchoolMode.getInstance(), 20*10);
        }else if(args.length == 1){

        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
