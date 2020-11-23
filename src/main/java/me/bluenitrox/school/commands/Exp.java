package me.bluenitrox.school.commands;

import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Exp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 0){
            ExpManager.updateXP(p.getUniqueId(), 100, false);
            p.sendMessage(MessageManager.CURRENTLEVEL(PlayerJoinManager.language) + ExpManager.getLevel(p.getUniqueId()));
            p.sendMessage(MessageManager.TOTALEXP(PlayerJoinManager.language) + ExpManager.getExp(p.getUniqueId()));
            p.sendMessage(MessageManager.NEEDEDEXP(PlayerJoinManager.language) + ExpManager.neededExp(p.getUniqueId()));
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
