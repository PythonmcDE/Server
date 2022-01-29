package me.bluenitrox.school.commands;

import me.bluenitrox.school.ah.AhManager;
import me.bluenitrox.school.features.SkillSystem;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Skill implements CommandExecutor {

    public static ArrayList<Player> cantopenSkill = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 0){
            if(cantopenSkill != null){
                if(cantopenSkill.contains(p)){
                    p.sendMessage(MessageManager.PREFIX + "§7Deine §3Skillpunkte §7werden gerade noch geladen. Bitte warte einen Moment");
                    p.playSound(p.getLocation(),  Sound.VILLAGER_NO, 1L , 1L);
                    return true;
                }
            }
            SkillSystem api = new SkillSystem();
            if(!AhManager.openedAH.contains(p)) {
                AhManager.openedAH.add(p);
                p.openInventory(api.openSkillInv(p));
            }else {
                p.sendMessage(MessageManager.PREFIX + "§7Warte einen §6Augenblick§7, bis du das §6Skill-Menü §7wieder öffnen kannst.");
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
