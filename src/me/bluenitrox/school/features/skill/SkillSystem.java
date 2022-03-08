package me.bluenitrox.school.features.skill;

import me.bluenitrox.school.features.skill.SkillAPI;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class SkillSystem {

    public static String guiname = "§6§lSkills";

    public Inventory openSkillInv(Player p){
        UUID uuid = p.getUniqueId();
        SkillAPI api = new SkillAPI();

        int swordprozent = 3*api.get(uuid,"angriff");
        int swordlevel = api.get(uuid,"angriff");
        int swordprozent2 = swordlevel+1;

        int armorprozent = 3*api.get(uuid,"verteidigung");
        int armorlevel = api.get(uuid,"verteidigung");
        int armorprozent2 = armorlevel+1;

        int energieprozent = 3*api.get(uuid,"extraenergie");
        int energielevel = api.get(uuid,"extraenergie");
        int energieprozent2 = energielevel+1;

        int scharfprozent = 3*api.get(uuid,"scharfschütze");
        int scharflevel = api.get(uuid,"scharfschütze");
        int scharfprozent2 = scharflevel+1;

        int miningprozent = 3*api.get(uuid,"mining");
        int mininglevel = api.get(uuid,"mining");
        int miningprozent2 = mininglevel+1;

        int händlerprozent = 3*api.get(uuid,"handler");
        int händlerlevel = api.get(uuid,"handler");
        int händlerprozent2 = händlerlevel+1;

        int alcheprozent = 3*api.get(uuid,"alchemist");
        int alchelevel = api.get(uuid,"alchemist");
        int alcheprozent2 = alchelevel+1;

        int warzoneprozent = 3*api.get(uuid,"bonusloot");
        int warzonelevel = api.get(uuid,"bonusloot");
        int warzoneprozent2 = warzonelevel+1;

        int glückprozent = 3*api.get(uuid,"gluckspilz");
        int glücklevel = api.get(uuid,"gluckspilz");
        int glückprozent2 = glücklevel+1;


        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack glaswhite = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build("isInInv");
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build("isInInv");
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lSkills").setLore("§6§l▶ §7Du erhälst durch das §6Aufteigen", "§6§l▶ §7im §6Level §aSkillpunkte", "§6§l▶ §7Hier kannst du mit ihnen §ebesondere", "§6§l▶ §eFähigkeiten §6freischalten §7und §6leveln§7!").build("isInInv");
        ItemStack pearl = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§6§lSkillpunkte").setLore("§8» §7Dein Level:§6§l " + ExpManager.getLevel(uuid), "§8» §7Aktuelle Skillpunkte:§a§l " + api.getSkillpunkte(uuid)).build("isInInv");

        ItemStack sword = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§6§l§oAngriff").setLore("§7Erhöht deinen Nahkampfschaden.", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"angriff"), "§8» §7Prozentsatz:§6 " + swordprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ swordprozent2, "  ", "§aKlicke, zum upgraden").build();
        ItemStack armor = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§6§l§oVerteidigung").setLore("§7Reduziert den erlittenen Schaden..", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"verteidigung"), "§8» §7Prozentsatz:§6 "+ armorprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ armorprozent2, "  ", "§aKlicke, zum upgraden").build();
        ItemStack energie = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§6§l§oEntraenergie").setLore("§7Ermöglicht es dir zusätzliche Herzen zu erlangen.", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"extraenergie"), "§8» §7Prozentsatz:§6 "+ energieprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ energieprozent2, "  ", "§aKlicke, zum upgraden").build();
        ItemStack scharf = new ItemBuilder(Material.BOW).setDisplayname("§6§l§oScharfschütze").setLore("§7Erhöht deinen Schaden mit Pfeil und Bogen.", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"scharfschütze"), "§8» §7Prozentsatz:§6 "+ scharfprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ scharfprozent2, "  ", "§aKlicke, zum upgraden").build();
        ItemStack mining = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§6§l§oMining").setLore("§7Verdoppelt möglicherweise deine abgebauten Erze.", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"mining"), "§8» §7Prozentsatz:§6 "+ miningprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ miningprozent2, "  ", "§aKlicke, zum upgraden").build();
        ItemStack händler = new ItemBuilder(Material.EMERALD).setDisplayname("§6§l§oHändler").setLore("§7Du verdienst beim Verkaufen mehr Gems.", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"handler"), "§8» §7Prozentsatz:§6 "+ händlerprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ händlerprozent2, "  ", "§aKlicke, zum upgraden").build();
        ItemStack alche = new ItemBuilder(Material.POTION).setDisplayname("§6§l§oAlchemist").setLore("§7Verlängert die Laufzeit eines getrunkenen Tranks.", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"alchemist"), "§8» §7Prozentsatz:§6 "+ alcheprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ alcheprozent2, "  ", "§aKlicke, zum upgraden", "§c§lDieser Skill benötigt §6§lPrestige I").build();
        ItemStack warzone = new ItemBuilder(Material.CHEST).setDisplayname("§6§l§oBonusloot").setLore("§7Du bekommst beim öffnen einer Warzonekiste mehr Loot.", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"bonusloot"), "§8» §7Prozentsatz:§6 "+ warzoneprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ warzoneprozent2, "  ", "§aKlicke, zum upgraden", "§c§lDieser Skill benötigt §6§lPrestige II").build();
        ItemStack glück = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§6§l§oGlückspilz").setLore("§7Lässt beim öffnen einer Warzone-Kiste, eine weitere spawnen..", " ", "§8» §7Aktuelles Level:§a " + api.get(uuid,"gluckspilz"), "§8» §7Prozentsatz:§6 "+ glückprozent + "%", "§8» §7Benötigte Skillpunkte:§a "+ glückprozent2, "  ", "§aKlicke, zum upgraden", "§c§lDieser Skill benötigt §6§lPrestige III").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i, glaswhite);
        }
        for(int i = 36; i<= 44; i++){
            inv.setItem(i,glaswhite);
        }
        for(int i = 45; i<= 53; i++){
            inv.setItem(i, glasblack);
        }

        inv.setItem(49,pearl);
        inv.setItem(4, sign);

        inv.setItem(18,sword);
        inv.setItem(19,armor);
        inv.setItem(20,energie);
        inv.setItem(21,scharf);
        inv.setItem(22,mining);
        inv.setItem(23,händler);
        inv.setItem(24,alche);
        inv.setItem(25,warzone);
        inv.setItem(26,glück);

        return inv;
    }

    public static void onClick(final InventoryClickEvent e) {
        UUID uuid = e.getWhoClicked().getUniqueId();
        Player p = (Player)e.getWhoClicked();
        SkillAPI api = new SkillAPI();
        int swordlevel = api.get(uuid,"angriff");
        int swordprozent2 = swordlevel+1;
        int armorlevel = api.get(uuid,"verteidigung");
        int armorprozent2 = armorlevel+1;
        int energielevel = api.get(uuid,"extraenergie");
        int energieprozent2 = energielevel+1;
        int scharflevel = api.get(uuid,"scharfschütze");
        int scharfprozent2 = scharflevel+1;
        int mininglevel = api.get(uuid,"mining");
        int miningprozent2 = mininglevel+1;
        int händlerlevel = api.get(uuid,"handler");
        int händlerprozent2 = händlerlevel+1;
        int alchelevel = api.get(uuid,"alchemist");
        int alcheprozent2 = alchelevel+1;
        int warzonelevel = api.get(uuid,"bonusloot");
        int warzoneprozent2 = warzonelevel+1;
        int glücklevel = api.get(uuid,"gluckspilz");
        int glückprozent2 = glücklevel+1;
        int skillpoints = api.getSkillpunkte(uuid);

        if (e.getClickedInventory().getName().equalsIgnoreCase(guiname)) {
            e.setCancelled(true);
            if(e.getCurrentItem() != null){
                if(e.getCurrentItem().getItemMeta() != null){
                    if(e.getCurrentItem().getItemMeta().getDisplayName() != null){
                        if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oAngriff")) {
                            if(skillpoints >= swordprozent2){
                                api.update(uuid, 1, false, "angriff");
                                api.updateSkillpunkte(uuid, swordprozent2, true);
                                p.closeInventory();
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            }else {
                                p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                                return;
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oVerteidigung")) {
                            if(skillpoints >= armorprozent2){
                                api.update(uuid, 1, false, "verteidigung");
                                api.updateSkillpunkte(uuid, armorprozent2, true);
                                p.closeInventory();
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            }else {
                                p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                                return;
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oEntraenergie")) {
                            if(skillpoints >= energieprozent2){
                                api.update(uuid, 1, false, "extraenergie");
                                api.updateSkillpunkte(uuid, energieprozent2, true);
                                p.closeInventory();
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            }else {
                                p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                                return;
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oScharfschütze")) {
                            if(skillpoints >= scharfprozent2){
                                api.update(uuid, 1, false, "scharfschütze");
                                api.updateSkillpunkte(uuid, scharfprozent2, true);
                                p.closeInventory();
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            }else {
                                p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                                return;
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oHändler")) {
                            if(skillpoints >= händlerprozent2){
                                api.update(uuid, 1, false, "handler");
                                api.updateSkillpunkte(uuid, händlerprozent2, true);
                                p.closeInventory();
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            }else {
                                p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                                return;
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oAlchemist")) {
                            if(ExpManager.getPrestige(uuid) >= 1) {
                                if (skillpoints >= alcheprozent2) {
                                    api.update(uuid, 1, false, "alchemist");
                                    api.updateSkillpunkte(uuid, alcheprozent2, true);
                                    p.closeInventory();
                                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                } else {
                                    p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                    p.closeInventory();
                                    return;
                                }
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oBonusloot")) {
                            if(ExpManager.getPrestige(uuid) >= 2) {
                                if (skillpoints >= warzoneprozent2) {
                                    api.update(uuid, 1, false, "bonusloot");
                                    api.updateSkillpunkte(uuid, warzoneprozent2, true);
                                    p.closeInventory();
                                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                } else {
                                    p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                    p.closeInventory();
                                    return;
                                }
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oGlückspilz")) {
                            if(ExpManager.getPrestige(uuid) >= 3) {
                                if (skillpoints >= glückprozent2) {
                                    api.update(uuid, 1, false, "gluckspilz");
                                    api.updateSkillpunkte(uuid, glückprozent2, true);
                                    p.closeInventory();
                                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                } else {
                                    p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                    p.closeInventory();
                                    return;
                                }
                            }
                        }else if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6§l§oMining")) {
                            if (skillpoints >= miningprozent2) {
                                api.update(uuid, 1, false, "mining");
                                api.updateSkillpunkte(uuid, miningprozent2, true);
                                p.closeInventory();
                                p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            } else {
                                p.sendMessage(MessageManager.NOTENOUGHSKILLPOINTS);
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

}
