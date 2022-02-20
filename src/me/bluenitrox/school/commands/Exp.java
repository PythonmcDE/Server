package me.bluenitrox.school.commands;

import me.bluenitrox.school.features.StatsAPI;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Exp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        StatsAPI api = new StatsAPI();
        if(args.length == 0){
            p.sendMessage(MessageManager.CURRENTLEVEL(PlayerJoinManager.language) + ExpManager.getLevel(p.getUniqueId()));
            p.sendMessage(MessageManager.TOTALEXP(PlayerJoinManager.language) + ValuetoString.valueToStringXP(api.getPlayerEXP(p.getUniqueId())));
            p.sendMessage(MessageManager.NEEDEDEXP(PlayerJoinManager.language) + ValuetoString.valueToStringXP(ExpManager.neededExp(p.getUniqueId())));
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
