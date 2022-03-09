package me.bluenitrox.school.commands.infocommands;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.managers.GemLimitManager;
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
            GemLimitManager gemLimit = new GemLimitManager(p.getUniqueId());
            p.sendMessage(MessageManager.PREFIX + "§7Dein maximales Gemlimit ist §6§l" + ValuetoString.valueToString(gemLimit.getGemLimit()) + " Gems§7.");
            p.sendMessage(MessageManager.PREFIX + "§7Davon sind noch §6§l" + ValuetoString.valueToStringGemLimit(gemLimit.getRestGemLimit()) + " Gems§7 übrig!");
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        return false;
    }
}
