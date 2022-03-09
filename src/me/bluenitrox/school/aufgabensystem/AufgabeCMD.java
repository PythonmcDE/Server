package me.bluenitrox.school.aufgabensystem;

import me.bluenitrox.school.listener.PlayerJoinListener;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.lang.reflect.Member;

public class AufgabeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 0){
            p.sendMessage(Aufgaben.getTask(p));
            p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1L, 1L);
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        return false;
    }
}
