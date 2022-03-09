package me.bluenitrox.school.ah;

import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.managers.*;
import me.bluenitrox.school.managers.GemLimitManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Ah_CMD implements CommandExecutor {

    public static String GUI_NAME = "§6§lMarkt";

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(cs == null){
            cs.sendMessage(MessageManager.NOPLAYER);
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
            if(MessageManager.ah) {
                Inventory invah = Bukkit.createInventory(null, 9 * 6, GUI_NAME);

                AhManager.openAh(invah, 1, p);

            }else {
                p.sendMessage(MessageManager.PREFIX + "§7Das §6Auktionshaus §7ist derzeit in §cWartungw!");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else if(args.length == 2) {
            if(MessageManager.ah) {
                if (args[0].equals("sell") || args[0].equals("s")) {

                    int allowedItems = 1;

                    if (p.hasPermission(PermissionsManager.vip)) {
                        allowedItems += 2;
                    }
                    if (p.hasPermission(PermissionsManager.python)) {
                        allowedItems += 3;
                    }
                    if (p.hasPermission(PermissionsManager.kingqueen)) {
                        allowedItems += 4;
                    }

                    if (AhManager.getAhItems(p) >= allowedItems) {
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast bereits die maximale Anzahl an Items ins Ah gestellt [§a" + allowedItems + "§7 ]!");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        return true;
                    }


                    int preis = Integer.parseInt(args[1]);
                    if (p.getItemInHand().getType() == Material.AIR) {
                        p.sendMessage(MessageManager.PREFIX + "§cBitte halte ein Item in der Hand!");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        return true;
                    }
                    if(preis <= 0){
                        p.sendMessage(MessageManager.PREFIX + "§cDer Preis ist so nicht möglich");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        return true;
                    }
                    if(preis > 1000000000){
                        preis = 1000000000;
                    }
                    if(!CheckAmount.check(args[1])){
                        p.sendMessage(MessageManager.PREFIX + "§cDer Preis ist so nicht möglich");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        return true;
                    }
                    GemLimitManager gemLimit = new GemLimitManager(p.getUniqueId());
                    if(preis > gemLimit.getRestGemLimit()){
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst heute §ckeine §7Gems mehr verdienen.");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        return true;
                    }
                    Inventory invah = Bukkit.createInventory(null, 9 * 6, GUI_NAME);

                    if(AufgabenManager.getTask(p.getUniqueId()) == 9){
                        AufgabenManager.onComplete(p.getUniqueId(), 9);
                    }
                    AhManager.sellItem(p.getItemInHand(), p, preis, invah);

                } else {
                    p.sendMessage(MessageManager.PREFIX + "§7Das §6Auktionshaus §7ist derzeit in §cWartungw!");
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            } else {
                p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L); 
            }
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
            if(p.hasPermission(PermissionsManager.AHOFF)){
                if(!MessageManager.ah) {
                    MessageManager.ah = true;
                    p.sendMessage(MessageManager.PREFIX + "§aAh aktiviert!");
                }else {
                    MessageManager.ah = false;
                    p.sendMessage(MessageManager.PREFIX + "§cAh deaktiviert!");
                }
            }
        }
        return false;
    }

}

