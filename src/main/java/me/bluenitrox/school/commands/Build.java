package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Build implements CommandExecutor {

    public static ArrayList<Player> build = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender cs, Command c, String s, String[] args) {
        if (!(cs instanceof Player)) {
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }

        Player p = (Player) cs;
        if (!p.hasPermission(PermissionsManager.BUILD) || !p.hasPermission(PermissionsManager.ALLPERMS)) {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }

        if (args.length == 0) {
            if (build.contains(p)) {
                build.remove(p);
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(MessageManager.QUIT_BUILD);
            } else {
                build.add(p);
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(MessageManager.JOIN_BUILD);
            }
        } else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }

        return false;
    }
}
