package me.bluenitrox.school.commands;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.features.StatsAPI;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.mine.manager.MinenManager;
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
            p.sendMessage("§3[]-=-*-=-[] §cDeine Stats §3[]-=-*-=-[]");
            p.sendMessage("§6§l▶ §7Kills: " + api.getKillsDatabase(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Deaths: " + api.getDeathsDatabase(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Aktuelle Mine: " + SchoolMode.getPlayerMine(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Aktuelles Level: " + ExpManager.getLevel(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Aktuelle XP: " + api.getPlayerEXP(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Abgebaute Blöcke: " + SchoolMode.getPlayerBlocks(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Geöffnete Cases: " + api.getCase(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Geöffnete Kisten: " + api.getChest(p.getUniqueId()));
            p.sendMessage("§6§l▶ §7Getötete Monster: " + api.getMob(p.getUniqueId()));
            p.sendMessage("§3[]-=-*-=-[] §cDeine Stats §3[]-=-*-=-[]");
        }else if(args.length == 1){
            /*
            /stats [Spieler] shows stats of other Players
             */
            String playername = args[0];
            try {
                UUID uuid = UUIDFetcher.getUUID(playername);
                p.sendMessage("§3[]-=-*-=-[] §c" + playername + " Stats §3[]-=-*-=-[]");
                p.sendMessage("§6§l▶ §7Kills: " + api.getKillsDatabase(uuid));
                p.sendMessage("§6§l▶ §7Deaths: " + api.getDeathsDatabase(uuid));
                p.sendMessage("§6§l▶ §7Aktuelle Mine: " + MinenManager.getMineDatabase(uuid));
                p.sendMessage("§6§l▶ §7Aktuelles Level: " + ExpManager.getLevelDatabase(uuid));
                p.sendMessage("§6§l▶ §7Aktuelle XP: " + api.getPlayerEXP(uuid));
                p.sendMessage("§6§l▶ §7Abgebaute Blöcke: " + SchoolMode.getPlayerBlocks(uuid));
                p.sendMessage("§6§l▶ §7Geöffnete Cases: " + api.getCase(uuid));
                p.sendMessage("§6§l▶ §7Geöffnete Kisten: " + api.getChest(uuid));
                p.sendMessage("§6§l▶ §7Getötete Monster: " + api.getMob(uuid));
                p.sendMessage("§3[]-=-*-=-[] §c" + playername + " Stats §3[]-=-*-=-[]");
            }catch (Exception e){
                p.sendMessage(MessageManager.PREFIX + "§7Dieser Spieler wurde §cnicht §7gefunden ");
            }

        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
        }
        return false;
    }
}
