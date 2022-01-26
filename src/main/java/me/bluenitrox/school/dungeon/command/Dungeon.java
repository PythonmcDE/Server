package me.bluenitrox.school.dungeon.command;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Dungeon implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        Player p = (Player)cs;
        DungeonManager dm = new DungeonManager();
        if(CombatAPI.fight != null) {
            if (CombatAPI.fight.containsKey(p)) {
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                p.sendMessage(MessageManager.CANTDOINFIGHT);
                return true;
            }
        }
        if(args.length == 0){
            p.teleport(new LocationManager("Dungeonspawn").getLocation());
            dm.onJoinDungeon(p);
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            return true;
        }
        return false;
    }
}
