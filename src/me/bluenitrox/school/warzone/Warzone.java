package me.bluenitrox.school.warzone;

import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

public class Warzone implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(!(cs instanceof Player)){
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }
        if(p.hasPermission(PermissionsManager.WZTELEPORT)) {
            if (args.length == 0) {
                if(!CombatAPI.playerinwarzone.containsKey(p.getUniqueId())){
                    p.teleport(new LocationManager("wzspawn").getLocation());
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                    p.sendMessage(MessageManager.PREFIX +  "§7Du wurdest zur §aWarzone §7teleportiert!");
                    AngelminenManager.quitAngelmine(p);
                }
            } else {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else {
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        return false;
    }
}
