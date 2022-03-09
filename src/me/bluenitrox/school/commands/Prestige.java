package me.bluenitrox.school.commands;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.Firework;
import me.bluenitrox.school.utils.GetDisplayColor;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NameFetcher;
import me.daarkii.nicksystem.NickAddon;
import org.apache.logging.log4j.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class Prestige implements CommandExecutor {

    private static String guiname = "§6§lPrestige";

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(args.length == 0){
            Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

            ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lPrestigen").setLore("§6§l▶ §7Durch das §6prestigen §7erhälst du §fVorteile", "§6§l▶ §7wie der Zugang zu §4neuen Dungeons§7, oder", "§6§l▶ §7die Möglichkeit, §4weitere Skills §7freizuschalten.", " ", "§c§lAchtung:", "§6§l▶ §7Du behälst zwar deine §fSkillpunkte §7und", "§6§l▶ §faktuellen Xp§7, dein Level wird aber wieder", "§6§l▶ §7auf §6§l1§7 heruntergesetzt.").build();
            ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
            ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
            ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cJetzt Prestigen!").setLore("§6§l▶ §7Du musst mindestens §6§lLevel 80", "§6§l▶ §7sein, um zu prestigen!").build();
            ItemStack jetzt = new ItemBuilder(Material.INK_SACK,(short)10).setDisplayname("§8» §aJetzt Prestigen").setLore("§6§l▶ §7Klicke hier, um zu §fprestigen §7und", "§6§l▶ §7dein Level somit auf §6§lLevel 1 §7runterzusetzen.", "§6§l▶ §7Dadurch erhälst du tolle Belohnungen.").build();

            ItemStack barrier1 = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §6§lPrestige 1").setLore("§6§l▶ §7Du hast dieses Prestige noch nicht freigeschalten.").build();
            ItemStack barrier2 = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §6§lPrestige 2").setLore("§6§l▶ §7Du hast dieses Prestige noch nicht freigeschalten.").build();
            ItemStack barrier3 = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §6§lPrestige 3").setLore("§6§l▶ §7Du hast dieses Prestige noch nicht freigeschalten.").build();

            ItemStack prestige1 = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§8» §6§lPrestige 1").setLore("§6§l▶ §7Du hast dieses Prestige freigeschalten.", "§6§l▶ §7Du erhälst zugang zu §cweitern §7Dungeons§7.").build();
            ItemStack prestige2 = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§8» §6§lPrestige 2").setLore("§6§l▶ §7Du hast dieses Prestige freigeschalten.", "§6§l▶ §7Du erhälst zugang zu §cweitern §7Dungeons§7.").build();
            ItemStack prestige3 = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§8» §6§lPrestige 3").setLore("§6§l▶ §7Du hast dieses Prestige freigeschalten.", "§6§l▶ §7Du erhälst zugang zu §cweitern §7Dungeons§7.").build();
            ItemStack prestige0 = new ItemBuilder(Material.COAL_BLOCK).setDisplayname("§8» §6§lPrestige 0").setLore("§6§l▶ §7Du hast dieses Prestige freigeschalten.", "§6§l▶ §7Du erhälst zugang zum §cersten §7Dungeon.").build();

            inv.setItem(9, prestige0);
            if(ExpManager.getPrestige(p.getUniqueId()) >= 1){
                inv.setItem(10, prestige1);
            }else {
                inv.setItem(10, barrier1);
            }
            if(ExpManager.getPrestige(p.getUniqueId()) >= 2){
                inv.setItem(11, prestige2);
            }else {
                inv.setItem(11, barrier3);
            }
            if(ExpManager.getPrestige(p.getUniqueId()) >= 3){
                inv.setItem(12, prestige3);
            }else {
                inv.setItem(12, barrier3);
            }

            for(int i = 0; i<= 8;i++){
                inv.setItem(i, glas);
            }
            for(int i = 36; i<= 44;i++){
                inv.setItem(i, glas);
            }
            for(int i = 45; i<=53; i++){
                inv.setItem(i, glasblack);
            }

            inv.setItem(4, sign);

            if(ExpManager.getLevel(p.getUniqueId()) >= 80){
                inv.setItem(49,jetzt);
            }else {
                inv.setItem(49,barrier);
            }
            p.openInventory(inv);

        }
        return false;
    }
    public static void onClick(final InventoryClickEvent e) {
        if (e.getCurrentItem() != null) {
            if (e.getClickedInventory().getName().equalsIgnoreCase(guiname)) {
                e.setCancelled(true);
                if (e.getCurrentItem().getType() == Material.INK_SACK) {
                    UUID uuid = e.getWhoClicked().getUniqueId();
                    Player p = (Player) e.getWhoClicked();
                    if (ExpManager.getLevel(uuid) >= 80) {
                        SchoolMode.playerlevel.remove(uuid);
                        SchoolMode.playerlevel.put(uuid, 1);
                        SchoolMode.setPlayerExp(uuid, 0);
                        TTA_Methods.sendTitle(p, "§6§lGlückwunsch", 40, 40, 40, "§8» §bPrestige Upgrade", 40, 40, 40);
                        p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1L, 1L);
                        p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1L, 1L);
                        p.playSound(p.getLocation(), Sound.AMBIENCE_THUNDER, 1L, 1L);
                        Firework.Firework(p);
                        Firework.Firework(p);
                        Firework.Firework(p);
                        MoneyManager.updateMoney(uuid, 5000000, false, true, true);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §65 Mio Gems §7erhalten.");
                        Bukkit.broadcastMessage(MessageManager.PREFIX + GetDisplayColor.getRankColor(GetDisplayColor.getIPermissionPlayer(p.getUniqueId())) + NameFetcher.getName(p.getUniqueId()) + "§7 hat gerade ein §6§lPrestige Upgrade §7erhalten. §6§lHerzlichen Glückwunsch!!");
                        ExpManager.updatePrestige(uuid, 1, false);

                        for (Player all : Bukkit.getOnlinePlayers()) {
                            NickAddon.getInstance().updateNameTags(all);
                        }
                    }
                }
            }
        }
    }
}
