package me.bluenitrox.school.commands.infocommands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gemlimit implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(!(cs instanceof Player)){
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }
        if(args.length == 0){
            p.sendMessage(MessageManager.PREFIX + "§7Von deinem Gemlimit sind noch §6§l" + ValuetoString.valueToString(MoneyManager.getGemlimit(p.getUniqueId())) + " Gems§7 übrig!");
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        return false;
    }
}
