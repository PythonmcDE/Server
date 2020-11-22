package me.bluenitrox.school.features;

import me.bluenitrox.school.utils.ItemBuilder;
import net.minecraft.server.v1_8_R3.ItemBanner;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;

public class KitItems {

    /*TODO
        Alle Kit Items wie unten aufgezeigt für jedes kit einzeln registieren
        "KITNAME" in der unteren Methode replacen
        BITTE ACHTE AUF RECHTSCHREIBUNG UND RICHTIGE BENNUNG DER ITEMS

        Wenn es ein Kit ist das nicht über Leveln sondern durch z.b. Gems
        freigeschalten werden soll schreibe bitte vor die Methode folgenden Text;

        //TODO **Art und weise wie man es freischält**

     */

    void addHolzItems(Player p){
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§7Holzschwert").build());
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_PICKAXE).setDisplayname("§7Holzspitzhacke").build());
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_AXE).setDisplayname("§7Holzaxt").build());
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_SPADE).setDisplayname("§7Holzschaufel").build());
        p.getInventory().addItem(new ItemBuilder(Material.APPLE).setDisplayname("§7Apfel").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setDisplayname("§7Lederhelm").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayname("§7Lederbrustplatte").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setDisplayname("§7Lederhose").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setDisplayname("§7Lederschuhe").build());
    }
    void addSteinItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.STONE_SWORD).setDisplayname("§7Steinschwert").build());
        p.getInventory().addItem(new ItemBuilder(Material.STONE_PICKAXE).setDisplayname("§7Steinspitzhacke").build());
        p.getInventory().addItem(new ItemBuilder(Material.STONE_AXE).setDisplayname("§7Steinaxt").build());
        p.getInventory().addItem(new ItemBuilder(Material.STONE_SPADE).setDisplayname("§7Steinschaufel").build());
        p.getInventory().addItem(new ItemBuilder(Material.BREAD).setDisplayname("§7Brot").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_HELMET).setDisplayname("§7Goldhelm").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§7Goldbrustplatte").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_LEGGINGS).setDisplayname("§7Goldhose").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_BOOTS).setDisplayname("§7Goldschuhe").build());
    }
    void addEisenItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.IRON_SWORD).setDisplayname("§7Eisenschwert").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§7Eisenspitzhacke").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_AXE).setDisplayname("§7Eisenaxt").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_SPADE).setDisplayname("§7Eisenschaufel").build());
        p.getInventory().addItem(new ItemBuilder(Material.COOKED_BEEF).setDisplayname("§7Steak").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_HELMET).setDisplayname("§7Eisenhelm").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§7Eisenbrustplatte").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§7Eisenhose").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§7Eisenschuhe").build());
    }
    void addWarzoneItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.BOW).setDisplayname("§7Bogen").build());
        p.getInventory().addItem(new ItemBuilder(Material.ARROW).setDisplayname("§7Pfeile").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.POTION, (short) 8194).setDisplayname("§7Trank der Schnelligkeit").build());
        p.getInventory().addItem(new ItemBuilder(Material.POTION, (short) 8201).setDisplayname("§7Trank der Stärke").build());
        p.getInventory().addItem(new ItemBuilder(Material.POTION, (short) 8227).setDisplayname("§7Trank der Feuerresistenz").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldener Apfel").setAmount(8).build());
        p.getInventory().addItem(new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperle").setAmount(8).build());

    }
    void addDiamantItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§7Diamantschwert").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§7Diamantspitzhacke").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_AXE).setDisplayname("§7Diamantaxt").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SPADE).setDisplayname("§7Diamantschaufel").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§7Diamanthelm").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§7Diamantbrustplatte").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§7Diamanthose").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§7Diamantschuhe").build());
    }
    void addBergarbeiterItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§7Diamantspitzhacke").addEnchant(Enchantment.DIG_SPEED, 5, false).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblock").setAmount(2).build());
    }
    void addGoldfingerItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Goldblock").setAmount(3).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldener Apfel").setAmount(4).build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§7Erfahrungsflasche").setAmount(5).build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP").build());
    }
    void addJuwelierItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblock").setAmount(5).build());
        p.getInventory().addItem(new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblock").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP").build());
    }
    void addBänkerItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblock").setAmount(8).build());
        p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Zufällige §5§lVerzauberung")
                .setLore("§eLevel §e§lI", "§7Rechtsklicke dieses Buch", "§7um eine §6§lzufällige Verzauberung", "§7zu erhalten").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP").build());
    }
    void addNinjaItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.MELON).setDisplayname("§7Melone").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_PICKAXE).setDisplayname("§2Bambus Häcksler").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lDuplizierung II").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP").build());
        p.getInventory().addItem(new ItemBuilder(Material.MELON_BLOCK).setDisplayname("§7Melonenblock").setAmount(8).build());
    }
    void addSenseiItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.MELON).setDisplayname("§7Melone").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_PICKAXE).setDisplayname("§2Bambus-Kapfstab eines Ninjas").addEnchant(Enchantment.DAMAGE_ALL, 6, true)
                .addEnchant(Enchantment.KNOCKBACK, 1, false).setLore("§c§lKopfgeld II").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP").setAmount(3).build());
        p.getInventory().addItem(new ItemBuilder(Material.MELON_BLOCK).setDisplayname("§7Melonenblock").setAmount(20).build());
    }
    void addMeisterItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.MELON).setDisplayname("§7Melone").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_HELMET).setDisplayname("§2Helm eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückpilz II").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§2Robe eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückpilz II").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_LEGGINGS).setDisplayname("§2Hose eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückpilz II").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_BOOTS).setDisplayname("§2Schuhe eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückpilz II").build());

        p.getInventory().addItem(new ItemBuilder(Material.MELON_BLOCK).setDisplayname("§7Melonenblock").setAmount(35).build());
        p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Zufällige §5§lVerzauberung")
                .setLore("§eLevel §e§lI", "§7Rechtsklicke dieses Buch", "§7um eine §6§lzufällige Verzauberung", "§7zu erhalten").build());
    }

}