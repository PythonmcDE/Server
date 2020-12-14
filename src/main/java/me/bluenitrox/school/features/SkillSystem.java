package me.bluenitrox.school.features;

import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class SkillSystem {

    public static String guiname = "§6§lSkills";

    public Inventory openSkillInv(Player p){
        UUID uuid = p.getUniqueId();

        Inventory inv = Bukkit.createInventory(null, 9*6, guiname);

        ItemStack glaswhite = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build("isInInv");
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)15).setDisplayname(" ").build("isInInv");
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lSkills").setLore("§6§l▶ §7Du erhälst durch das §6Aufteigen", "§6§l▶ §7im §6Level §aSkillpunkte", "§6§l▶ §7Hier kannst du mit ihnen §ebesondere", "§6§l▶ §eFähigkeiten §6freischalten §7und §6leveln§7!").build("isInInv");
        ItemStack pearl = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§6§lSkillpunkte").setLore("§8» §7Dein Level:§6§l " + ExpManager.getLevel(uuid), "§8» §7Aktuelle Skillpunkte:§a§l ").build("isInInv");

        ItemStack sword = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§c§l§oAngriff").setLore("§7Erhöht deinen Nahkampfschaden.", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden").build();
        ItemStack armor = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§6§l§oVerteidigung").setLore("§7Reduziert den erlittenen Schaden..", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden").build();
        ItemStack energie = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§c§l§oEntraenergie").setLore("§7Ermöglicht es dir zusätzliche Herzen zu erlangen.", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden").build();
        ItemStack scharf = new ItemBuilder(Material.BOW).setDisplayname("§6§l§oScharfschütze").setLore("§7Erhöht deinen Schaden mit Pfeil und Bogen.", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden").build();
        ItemStack mining = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§c§l§oMining").setLore("§7Verdoppelt möglicherweise deine abgebauten Erze.", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden").build();
        ItemStack händler = new ItemBuilder(Material.EMERALD).setDisplayname("§6§l§oHändler").setLore("§7Du verdienst beim Verkaufen mehr Gems.", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden").build();
        ItemStack alche = new ItemBuilder(Material.POTION).setDisplayname("§c§l§oAlchemist").setLore("§7Verlängert die Laufzeit eines getrunkenen Tranks.", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden", "§c§lDieser Skill benötigt §6§lPrestige I").build();
        ItemStack warzone = new ItemBuilder(Material.CHEST).setDisplayname("§6§l§oBonusloot").setLore("§7Du bekommst beim öffnen einer Warzonekiste mehr Loot.", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden", "§c§lDieser Skill benötigt §6§lPrestige III").build();
        ItemStack glück = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§c§l§oGlückspilz").setLore("§7Lässt beim öffnen einer Warzone-Kiste, eine weitere spawnen..", " ", "§8» §7Aktuelles Level:§a ", "§8» §7Prozentsatz:§6" + "%", "§8» §7Benötigte Skillpunkte:§a", "  ", "§aKlicke, zum upgraden", "§c§lDieser Skill benötigt §6§lPrestige III").build();

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

    public static void onClick(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null){
            e.setCancelled(true);
        }
    }

}
