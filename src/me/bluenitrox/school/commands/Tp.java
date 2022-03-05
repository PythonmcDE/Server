package me.bluenitrox.school.commands;

import me.bluenitrox.school.haendler.NPCAPI;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {

        final Player p = (Player)cs;
        if(p.hasPermission(PermissionsManager.mod)) {
            if(args.length == 1) {
                final Player target = Bukkit.getPlayer(args[0]);
                if(target != null) {
                    p.teleport(target.getLocation());
                    AngelminenManager.quitAngelmine(p);
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast dich zum Spieler §6" + target.getName() + " §7teleportiert!");
                }
                else {
                    p.sendMessage(MessageManager.PREFIX + "§7Der Spieler ist nicht online!");
                }
            }
            else if(args.length == 2){
                final Player tp = Bukkit.getPlayer(args[0]);
                final Player target = Bukkit.getPlayer(args[1]);
                if(tp != null && target != null){
                    tp.teleport(target.getLocation());
                    AngelminenManager.quitAngelmine(p);
                    p.sendMessage(MessageManager.PREFIX + "§7Der Spieler §6" + tp.getName() + " §7wurde zu dem Spieler " + target.getName() + "§7teleportiert!");
                }
                else {
                    p.sendMessage(MessageManager.PREFIX + "§7Der Spieler ist nicht online!");
                }
            }
            else if(args.length == 3){
                p.teleport(new Location(p.getWorld(), (double)Float.valueOf(args[0]), (double)Float.valueOf(args[1]), (double)Float.valueOf(args[2])));
                AngelminenManager.quitAngelmine(p);
                p.sendMessage(MessageManager.PREFIX + "§7Du wurdest zu §6X: " + args[0] + " §6Y: " + args[1] + " §6Z: " + args[2] + " §7teleportiert!");
            }
            else {
                p.sendMessage(MessageManager.PREFIX + "§7Nutze: §6/tp <Spieler> §7oder §6 /tp <x y z>§7!");
            }
        }
        else {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
        }

        return true;
    }
}

