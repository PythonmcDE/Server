package me.bluenitrox.school.features.kit;

import me.bluenitrox.school.utils.ItemBuilder;
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
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§7Holzschwert").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_PICKAXE).setDisplayname("§7Holzspitzhacke").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_AXE).setDisplayname("§7Holzaxt").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.WOOD_SPADE).setDisplayname("§7Holzschaufel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.APPLE).setDisplayname("§7Apfel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_HELMET).setDisplayname("§7Lederkappe").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_CHESTPLATE).setDisplayname("§7Lederjacke").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_LEGGINGS).setDisplayname("§7Lederhose").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.LEATHER_BOOTS).setDisplayname("§7Lederstiefel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }
    void addSteinItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.STONE_SWORD).setDisplayname("§7Steinschwert").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.STONE_PICKAXE).setDisplayname("§7Steinspitzhacke").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.STONE_AXE).setDisplayname("§7Steinaxt").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.STONE_SPADE).setDisplayname("§7Steinschaufel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.BREAD).setDisplayname("§7Brot").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_HELMET).setDisplayname("§7Goldhelm").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§7Goldharnisch").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_LEGGINGS).setDisplayname("§7Goldbeinschutz").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_BOOTS).setDisplayname("§7Goldstiefel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }
    void addEisenItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.IRON_SWORD).setDisplayname("§7Eisenschwert").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§7Eisenspitzhacke").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_AXE).setDisplayname("§7Eisenaxt").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_SPADE).setDisplayname("§7Eisenschaufel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.COOKED_BEEF).setDisplayname("§7Steak").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_HELMET).setDisplayname("§7Eisenhelm").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§7Eisenbrustpanzer").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§7Eisenbeinschutz").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§7Eisenstiefel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }
    void addWarzoneItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.BOW).setDisplayname("§7Bogen").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.ARROW).setDisplayname("§7Pfeil").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.POTION, (short) 8194).setDisplayname("§7Trank der Schnelligkeit").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.POTION, (short) 8201).setDisplayname("§7Trank der Stärke").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.POTION, (short) 8227).setDisplayname("§7Trank der Feuerresistenz").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldener Apfel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(8).build());
        p.getInventory().addItem(new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperle").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(8).build());

    }
    void addDiamantItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§7Diamantschwert").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§7Diamantspitzhacke").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_AXE).setDisplayname("§7Diamantaxt").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SPADE).setDisplayname("§7Diamantschaufel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§7Diamanthelm").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§7Diamantbrustpanzer").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§7Diamantbeinschutz").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§7Diamantstiefel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }
    void addBergarbeiterItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§7Diamantspitzhacke").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").addEnchant(Enchantment.DIG_SPEED, 5, false).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(2).build());
    }
    void addGoldfingerItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Goldblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(3).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldener Apfel").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(4).build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§7Erfahrungsflasche").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(5).build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP","§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }
    void addJuwelierItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(5).build());
        p.getInventory().addItem(new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP","§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }
    void addBänkerItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.GOLDEN_CARROT).setDisplayname("§7Goldene Karotten").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(8).build());
        p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Zufällige §5§lVerzauberung")
                .setLore("§eLevel §e§lI", "§7Rechtsklicke dieses Buch", "§7um eine §6§lzufällige Verzauberung", "§7zu erhalten","§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP","§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }
    void addNinjaItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.MELON).setDisplayname("§7Melone").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_PICKAXE).setDisplayname("§2Bambus Häcksler").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP","§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.MELON_BLOCK).setDisplayname("§7Melonenblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(8).build());
    }
    void addSenseiItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.MELON).setDisplayname("§7Melone").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.SUGAR_CANE).setDisplayname("§2Bambus-Kapfstab eines Ninjas").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.KNOCKBACK, 1, false).setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP")
                .setLore("§8» §7Beinhaltet:§6§l 1200 XP","§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(3).build());
        p.getInventory().addItem(new ItemBuilder(Material.MELON_BLOCK).setDisplayname("§7Melonenblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(20).build());
    }
    void addMeisterItems(Player p) {

        p.getInventory().addItem(new ItemBuilder(Material.MELON).setDisplayname("§7Melone").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(12).build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_HELMET).setDisplayname("§2Helm eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§2Robe eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_LEGGINGS).setDisplayname("§2Hose eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
        p.getInventory().addItem(new ItemBuilder(Material.GOLD_BOOTS).setDisplayname("§2Schuhe eines Ninjas").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());

        p.getInventory().addItem(new ItemBuilder(Material.MELON_BLOCK).setDisplayname("§7Melonenblock").setLore("§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").setAmount(35).build());
        p.getInventory().addItem(new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Zufällige §5§lVerzauberung")
                .setLore("§eLevel §e§lI", "§7Rechtsklicke dieses Buch", "§7um eine §6§lzufällige Verzauberung", "§7zu erhalten","§6§l▶ §7Du kannst dieses Item §cnicht droppen§7!").build());
    }

}