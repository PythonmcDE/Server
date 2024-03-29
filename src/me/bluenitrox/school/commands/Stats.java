package me.bluenitrox.school.commands;

import me.bluenitrox.school.features.stats.StatsAPI;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerBreakBlockManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.GetDisplayColor;
import me.bluenitrox.school.utils.NameFetcher;
import me.bluenitrox.school.utils.UUIDFetcher;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Stats implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command command, String s, String[] args) {
        Player p = (Player)cs;
        StatsAPI api = new StatsAPI();
        if(args.length == 0){
            /*
            /stats shows your own stats
            */
            String playername;
            UUID uuid = p.getUniqueId();
            playername = GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(uuid)) + p.getName();
            try {
                p.sendMessage("§a§lPythonMC " + "§b» §7Statistiken von " + playername);
                p.sendMessage("§b» §7Kills: §6§l" + api.getKillsDatabase(uuid));
                p.sendMessage("§b» §7Tode: §6§l" + api.getDeathsDatabase(uuid));
                p.sendMessage("§b» §7Abgebaute Blöcke: §6§l" +  PlayerBreakBlockManager.getBlocks(uuid));
                p.sendMessage("§b» §7Geangelte Items: §6§l0");
                p.sendMessage("§b» §7Getötete Monster: §6§l" + StatsAPI.getMobDatabase(uuid));
                p.sendMessage("§b» §7Besiegte Bosse: §6§l0");
                p.sendMessage("§b» §7Geöffnete Kisten: §6§l" + api.getChest(uuid));
                p.sendMessage("§b» §7Geöffnete Cases: §6§l" + api.getCase(uuid));
                p.sendMessage("§b» §7Aktuelles Level: §6§l" + ExpManager.getLevel(uuid));
                p.sendMessage("§b» §7Prestige Stufe: §6§l" + ExpManager.getPrestige(uuid));


                //aussortiert
                //p.sendMessage("§6§l▶ §7Aktuelle XP: " + api.getPlayerEXP(uuid));
                //p.sendMessage("§3[]-=-*-=-[] §6Stats von " + playername + " Stats §3[]-=-*-=-[]");
                //p.sendMessage("§6§l▶ §7Aktuelle Mine: " + MinenManager.getMineDatabase(uuid));
            }catch (Exception e){
                p.sendMessage(MessageManager.PREFIX + "§7Dieser Spieler wurde §cnicht §7gefunden.");
            }
        }else if(args.length == 1){
            /*
            /stats [Spieler] shows stats of other Players
             */
            String playername;
            UUID uuid = UUIDFetcher.getUUID(args[0]);
            if(uuid == null) {
                p.sendMessage(MessageManager.PREFIX + "§7Dieser Spieler wurde §cnicht §7gefunden.");
                return true;
            }
            playername = GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(uuid)) + NameFetcher.getName(uuid);
            try {
                p.sendMessage("§a§lPythonMC " + "§b» §7Statistiken von " + playername);
                p.sendMessage("§b» §7Kills: §6§l" + api.getKillsDatabase(uuid));
                p.sendMessage("§b» §7Tode: §6§l" + api.getDeathsDatabase(uuid));
                p.sendMessage("§b» §7Abgebaute Blöcke: §6§l" +  PlayerBreakBlockManager.getBlocksDatabase(uuid));
                p.sendMessage("§b» §7Geangelte Items: §6§l0");
                p.sendMessage("§b» §7Getötete Monster: §6§l" + StatsAPI.getMobDatabase(uuid));
                p.sendMessage("§b» §7Besiegte Bosse: §6§l0");
                p.sendMessage("§b» §7Geöffnete Kisten: §6§l" + api.getChestsDatabase(uuid));
                p.sendMessage("§b» §7Geöffnete Cases: §6§l" + api.getCasesDatabase(uuid));
                p.sendMessage("§b» §7Aktuelles Level: §6§l" + ExpManager.getLevelDatabase(uuid));
                p.sendMessage("§b» §7Prestige Stufe: §6§l" + ExpManager.getPrestigeDatabase(uuid));


                //aussortiert
                //p.sendMessage("§6§l▶ §7Aktuelle XP: " + api.getPlayerEXP(uuid));
                //p.sendMessage("§3[]-=-*-=-[] §6Stats von " + playername + " Stats §3[]-=-*-=-[]");
                //p.sendMessage("§6§l▶ §7Aktuelle Mine: " + MinenManager.getMineDatabase(uuid));
            }catch (Exception e){
                p.sendMessage(MessageManager.PREFIX + "§7Dieser Spieler wurde §cnicht §7gefunden.");
            }

        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        return false;
    }
}
