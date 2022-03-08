package me.bluenitrox.school.commands;

import me.bluenitrox.school.features.kit.KitAPI;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kit implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(!(cs instanceof Player)){
            cs.sendMessage("Dazu musst du ein Spieler sein!");
            return true;
        }
        if(CombatAPI.fight != null) {
            if (CombatAPI.fight.containsKey(p)) {
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                p.sendMessage(MessageManager.CANTDOINFIGHT);
                return true;
            }
        }
        if(args.length == 0){
            KitAPI api = new KitAPI();
            api.openKitMenu(p);
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }
}
