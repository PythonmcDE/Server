package me.bluenitrox.school.features;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CaseItems {

    public static ArrayList<ItemStack> daily = new ArrayList<>();;
    public static ArrayList<ItemStack> gewöhnlich = new ArrayList<>();
    public static ArrayList<ItemStack> selten = new ArrayList<>();
    public static ArrayList<ItemStack> episch = new ArrayList<>();
    public static ArrayList<ItemStack> legendär = new ArrayList<>();
    public static ArrayList<ItemStack> mysthische = new ArrayList<>();
    public static ArrayList<ItemStack> tier = new ArrayList<>();

    public static ArrayList<ItemStack> casepot = new ArrayList<>();

    void registerDaily() {

        //Gewöhnliche Daily-Items
        ItemStack g1 = new ItemBuilder(Material.DIAMOND_BLOCK)
                .setAmount(8).build();
        ItemStack g2 = new ItemBuilder(Material.EMERALD_BLOCK)
                .setAmount(8).build();
        ItemStack g3 = new ItemBuilder(Material.GOLDEN_APPLE)
                .setAmount(8).build();
        ItemStack g4 = new ItemBuilder(Material.ENDER_PEARL)
                .setAmount(8).build();
        ItemStack g5 = new ItemBuilder(Material.ARROW)
                .setAmount(8).build();
        ItemStack g6 = new ItemBuilder(Material.EXP_BOTTLE)
                .setDisplayname("§6§lSchool XP").setLore("§b» §6§l500 XP").build();

        ItemStack g7 = new ItemBuilder(Material.IRON_HELMET)
                .setDisplayname("§7Rostiger Helm")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack g8 = new ItemBuilder(Material.IRON_CHESTPLATE)
                .setDisplayname("§7Rostige Brustplatte")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack g9 = new ItemBuilder(Material.IRON_CHESTPLATE)
                .setDisplayname("§7Rostige Hose")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack g10 = new ItemBuilder(Material.IRON_CHESTPLATE)
                .setDisplayname("§7Rostige Hose")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

        ItemStack g11 = new ItemBuilder(Material.IRON_SWORD)
                .setDisplayname("§7Stumpfes Messer")
                .addEnchant(Enchantment.DAMAGE_ALL, 1, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack g12 = new ItemBuilder(Material.WOOD_SWORD)
                .setDisplayname("§7Speerspitze")
                .addEnchant(Enchantment.DURABILITY, 3, false).addEnchant(Enchantment.KNOCKBACK, 1, false).build();

        ItemStack g13 = new ItemBuilder(Material.BOW)
                .setDisplayname("§7Alter Revolver")
                .addEnchant(Enchantment.ARROW_DAMAGE, 1, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

        ItemStack g14 = new ItemBuilder(Material.IRON_PICKAXE)
                .setDisplayname("§7Rostiger Sparten")
                .addEnchant(Enchantment.DIG_SPEED, 1, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

        ItemStack g15 = new ItemBuilder(Material.FISHING_ROD)
                .setDisplayname("§7Rostige Angel")
                .addEnchant(Enchantment.DURABILITY, 3, false).build();


        //Seltene Daily-Items
        ItemStack s1 = new ItemBuilder(Material.DIAMOND_BLOCK)
                .setAmount(16).build();
        ItemStack s2 = new ItemBuilder(Material.EMERALD_BLOCK)
                .setAmount(16).build();
        ItemStack s3 = new ItemBuilder(Material.GOLDEN_APPLE)
                .setAmount(16).build();
        ItemStack s4 = new ItemBuilder(Material.ENDER_PEARL)
                .setAmount(16).build();
        ItemStack s5 = new ItemBuilder(Material.ARROW)
                .setAmount(16).build();
        ItemStack s6 = new ItemBuilder(Material.EXP_BOTTLE)
                .setDisplayname("§6§lSchool XP").setLore("§b» §6§l2500 XP").build();

        ItemStack s7 = new ItemBuilder(Material.CHAINMAIL_HELMET)
                .setDisplayname("§eGzuz´s Brille")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
        ItemStack s8 = new ItemBuilder(Material.CHAINMAIL_CHESTPLATE)
                .setDisplayname("§e187 Merch")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
        ItemStack s9 = new ItemBuilder(Material.CHAINMAIL_LEGGINGS)
                .setDisplayname("§eHigh & Hungry Jogginghose")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
        ItemStack s10 = new ItemBuilder(Material.CHAINMAIL_BOOTS)
                .setDisplayname("§eHaifischnikez")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 4, true).build();

        ItemStack s11 = new ItemBuilder(Material.STONE_SWORD)
                .setDisplayname("§eJibbit")
                .addEnchant(Enchantment.DAMAGE_ALL, 4, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
        ItemStack s12 = new ItemBuilder(Material.STONE_SWORD)
                .setDisplayname("§eGanovendolch")
                .addEnchant(Enchantment.DURABILITY, 3, false).addEnchant(Enchantment.KNOCKBACK, 2, false).build();

        ItemStack s13 = new ItemBuilder(Material.BOW)
                .setDisplayname("§eBogen aus der Hood").setLore("§9§lTod I")
                .addEnchant(Enchantment.ARROW_DAMAGE, 3, false).addEnchant(Enchantment.DURABILITY, 4, true).build();

        ItemStack s14 = new ItemBuilder(Material.STONE_PICKAXE)
                .setDisplayname("§eBrecheisen 187").setLore("§6§lLaser I")
                .addEnchant(Enchantment.DIG_SPEED, 7, true).addEnchant(Enchantment.DURABILITY, 8, true).build();

        ItemStack s15 = new ItemBuilder(Material.FISHING_ROD)
                .setDisplayname("§eZitteraal Peitsche")
                .addEnchant(Enchantment.DURABILITY, 4, true).addEnchant(Enchantment.LURE, 1, false).build();


        //Epische Daily-Items
        ItemStack e1 = new ItemBuilder(Material.DIAMOND_BLOCK)
                .setAmount(32).build();
        ItemStack e2 = new ItemBuilder(Material.EMERALD_BLOCK)
                .setAmount(32).build();
        ItemStack e3 = new ItemBuilder(Material.GOLDEN_APPLE)
                .setAmount(32).build();
        ItemStack e4 = new ItemBuilder(Material.ENDER_PEARL)
                .setAmount(32).build();
        ItemStack e5 = new ItemBuilder(Material.ARROW)
                .setAmount(32).build();
        ItemStack e6 = new ItemBuilder(Material.EXP_BOTTLE)
                .setDisplayname("§6§lSchool XP").setLore("§b» §6§l5000 XP").build();

        ItemStack e7 = new ItemBuilder(Material.DIAMOND_HELMET)
                .setDisplayname("§5Himmelswächter Helm").setLore("§a§lTank I")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 6, true).build();
        ItemStack e8 = new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                .setDisplayname("§5Himmelswächter Brustplatte").setLore("§a§lTank I")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 6, true).build();
        ItemStack e9 = new ItemBuilder(Material.DIAMOND_LEGGINGS)
                .setDisplayname("§5Himmelswächter Hose").setLore("§a§lTank I")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 6, true).build();
        ItemStack e10 = new ItemBuilder(Material.DIAMOND_BOOTS)
                .setDisplayname("§5Himmelswächter Schuhe").setLore("§a§lTank I")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 6, true).build();

        ItemStack e11 = new ItemBuilder(Material.DIAMOND_SWORD)
                .setDisplayname("§5Mächtiges Breitschwert").setLore("§c§lFluch I")
                .addEnchant(Enchantment.DAMAGE_ALL, 4, false).addEnchant(Enchantment.DURABILITY, 6, true).build();
        ItemStack e12 = new ItemBuilder(Material.DIAMOND_SWORD)
                .setDisplayname("§5Excalibur")
                .addEnchant(Enchantment.DURABILITY, 10, true).addEnchant(Enchantment.KNOCKBACK, 2, false).build();

        ItemStack e13 = new ItemBuilder(Material.BOW)
                .setDisplayname("§5Anti-Titanen Kanone").setLore("§9§lKäfig I")
                .addEnchant(Enchantment.ARROW_DAMAGE, 5, false).addEnchant(Enchantment.DURABILITY, 6, true).build();

        ItemStack e14 = new ItemBuilder(Material.DIAMOND_PICKAXE)
                .setDisplayname("§5Baggerarm").setLore("§6§lLaser I")
                .addEnchant(Enchantment.DIG_SPEED, 4, false).addEnchant(Enchantment.DURABILITY, 6, true).build();

        ItemStack e15 = new ItemBuilder(Material.FISHING_ROD)
                .setDisplayname("§5Klabautermanns Angel")
                .addEnchant(Enchantment.DURABILITY, 6, true).addEnchant(Enchantment.LURE, 2, false).build();


        // Gewöhnlich: 3x

        daily.add(g1);
        daily.add(g1);
        daily.add(g1);
        daily.add(g1);
        daily.add(g2);
        daily.add(g2);
        daily.add(g2);
        daily.add(g2);
        daily.add(g3);
        daily.add(g3);
        daily.add(g3);
        daily.add(g3);
        daily.add(g4);
        daily.add(g4);
        daily.add(g4);
        daily.add(g4);
        daily.add(g5);
        daily.add(g5);
        daily.add(g5);
        daily.add(g5);
        daily.add(g6);
        daily.add(g6);
        daily.add(g6);
        daily.add(g6);
        daily.add(g7);
        daily.add(g7);
        daily.add(g7);
        daily.add(g7);
        daily.add(g8);
        daily.add(g8);
        daily.add(g8);
        daily.add(g8);
        daily.add(g9);
        daily.add(g9);
        daily.add(g9);
        daily.add(g9);
        daily.add(g10);
        daily.add(g10);
        daily.add(g10);
        daily.add(g10);
        daily.add(g11);
        daily.add(g11);
        daily.add(g11);
        daily.add(g11);
        daily.add(g12);
        daily.add(g12);
        daily.add(g12);
        daily.add(g12);
        daily.add(g13);
        daily.add(g13);
        daily.add(g13);
        daily.add(g13);
        daily.add(g14);
        daily.add(g14);
        daily.add(g14);
        daily.add(g14);
        daily.add(g15);
        daily.add(g15);
        daily.add(g15);
        daily.add(g15);

        // Selten: 2x

        daily.add(s1);
        daily.add(s1);
        daily.add(s2);
        daily.add(s2);
        daily.add(s3);
        daily.add(s3);
        daily.add(s4);
        daily.add(s4);
        daily.add(s5);
        daily.add(s5);
        daily.add(s6);
        daily.add(s6);
        daily.add(s7);
        daily.add(s7);
        daily.add(s8);
        daily.add(s8);
        daily.add(s9);
        daily.add(s9);
        daily.add(s10);
        daily.add(s10);
        daily.add(s11);
        daily.add(s11);
        daily.add(s12);
        daily.add(s12);
        daily.add(s13);
        daily.add(s13);
        daily.add(s14);
        daily.add(s14);
        daily.add(s15);
        daily.add(s15);

        // Episch: 1x

        daily.add(e1);
        daily.add(e2);
        daily.add(e3);
        daily.add(e4);
        daily.add(e5);
        daily.add(e6);
        daily.add(e7);
        daily.add(e8);
        daily.add(e9);
        daily.add(e10);
        daily.add(e11);
        daily.add(e12);
        daily.add(e13);
        daily.add(e14);
        daily.add(e15);

    }

    void registerGewöhnlich() {
        ItemStack itemStack1 = new ItemBuilder(Material.IRON_HELMET)
                .setDisplayname("§7Werwolfsgebiss")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
        ItemStack itemStack2 = new ItemBuilder(Material.IRON_CHESTPLATE)
                .setDisplayname("§7Werwolfsfell")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
        ItemStack itemStack3 = new ItemBuilder(Material.IRON_CHESTPLATE)
                .setDisplayname("§7Werwolfsbeine")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
        ItemStack itemStack4 = new ItemBuilder(Material.IRON_CHESTPLATE)
                .setDisplayname("§7Werwolfskrallen")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).addEnchant(Enchantment.DURABILITY, 4, true).build();

        ItemStack itemStack5 = new ItemBuilder(Material.IRON_HELMET)
                .setDisplayname("§7Mundi Helm")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack itemStack6 = new ItemBuilder(Material.IRON_CHESTPLATE)
                .setDisplayname("§7Mundi Jacke")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack itemStack7 = new ItemBuilder(Material.IRON_LEGGINGS)
                .setDisplayname("§7Mundi Hose")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack itemStack8 = new ItemBuilder(Material.IRON_BOOTS)
                .setDisplayname("§7Mundi Schuhe")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

        ItemStack itemStack9 = new ItemBuilder(Material.WOOD_SWORD)
                .setDisplayname("§7Küchenmesser")
                .addEnchant(Enchantment.DAMAGE_ALL, 3, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack itemStack10 = new ItemBuilder(Material.WOOD_SWORD)
                .setDisplayname("§7Taschenmesser")
                .addEnchant(Enchantment.DAMAGE_ALL, 2, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

        ItemStack itemStack11 = new ItemBuilder(Material.BOW)
                .setDisplayname("§7Hölzerne Armbrust")
                .addEnchant(Enchantment.ARROW_DAMAGE, 2, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

        ItemStack itemStack12 = new ItemBuilder(Material.WOOD_PICKAXE)
                .setDisplayname("§7Suppenkelle")
                .addEnchant(Enchantment.DIG_SPEED, 5, false).addEnchant(Enchantment.DURABILITY, 5, true).build();
        ItemStack itemStack13 = new ItemBuilder(Material.WOOD_PICKAXE)
                .setDisplayname("§7Löffel")
                .addEnchant(Enchantment.DIG_SPEED, 4, false).addEnchant(Enchantment.DURABILITY, 5, true).build();

        ItemStack itemStack14 = new ItemBuilder(Material.FISHING_ROD)
                .setDisplayname("§7Rissiges Fischernetz")
                .addEnchant(Enchantment.DURABILITY, 3, false).build();

        ItemStack itemStack15 = new ItemBuilder(Material.DIAMOND_BLOCK)
                .setAmount(8).build();
        ItemStack itemStack16 = new ItemBuilder(Material.EMERALD_BLOCK)
                .setAmount(8).build();
        ItemStack itemStack17 = new ItemBuilder(Material.GOLDEN_APPLE)
                .setAmount(8).build();
        ItemStack itemStack18 = new ItemBuilder(Material.ENDER_PEARL)
                .setAmount(8).build();
        ItemStack itemStack19 = new ItemBuilder(Material.ARROW)
                .setAmount(8).build();
        ItemStack itemStack20 = new ItemBuilder(Material.EXP_BOTTLE)
                .setDisplayname("§6§lSchool XP").setLore("§b» §6§l500 XP").build();

        gewöhnlich.add(itemStack1);
        gewöhnlich.add(itemStack2);
        gewöhnlich.add(itemStack3);
        gewöhnlich.add(itemStack4);
        gewöhnlich.add(itemStack5);
        gewöhnlich.add(itemStack6);
        gewöhnlich.add(itemStack7);
        gewöhnlich.add(itemStack8);
        gewöhnlich.add(itemStack9);
        gewöhnlich.add(itemStack10);
        gewöhnlich.add(itemStack11);
        gewöhnlich.add(itemStack12);
        gewöhnlich.add(itemStack13);
        gewöhnlich.add(itemStack14);
        gewöhnlich.add(itemStack15);
        gewöhnlich.add(itemStack16);
        gewöhnlich.add(itemStack17);
        gewöhnlich.add(itemStack18);
        gewöhnlich.add(itemStack19);
        gewöhnlich.add(itemStack20);
    }

        void registerSelten() {

            ItemStack Selten1 = new ItemBuilder(Material.GOLD_HELMET)
                    .setDisplayname("§eHut der Wunderhexe").setLore("§a§lÜberladung I", "§a§lHeilzauber I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 6, true).build();
            ItemStack Selten2 = new ItemBuilder(Material.GOLD_CHESTPLATE)
                    .setDisplayname("§eRobe der Wunderhexe").setLore("§a§lÜberladung I", "§a§lHeilzauber I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 6, true).build();
            ItemStack Selten3 = new ItemBuilder(Material.GOLD_LEGGINGS)
                    .setDisplayname("§eHose der Wunderhexe").setLore("§a§lÜberladung I", "§a§lHeilzauber I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 6, true).build();
            ItemStack Selten4 = new ItemBuilder(Material.GOLD_BOOTS)
                    .setDisplayname("§eStiefel der Wunderhexe").setLore("§a§lÜberladung I", "§a§lHeilzauber I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 6, true).build();

            ItemStack Selten5 = new ItemBuilder(Material.IRON_HELMET)
                    .setDisplayname("§eMutantenhelm")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 5, true).build();
            ItemStack Selten6 = new ItemBuilder(Material.IRON_CHESTPLATE)
                    .setDisplayname("§eMutantenbrustplatte")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 5, true).build();
            ItemStack Selten7 = new ItemBuilder(Material.IRON_LEGGINGS)
                    .setDisplayname("§eMutantenhose")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 5, true).build();
            ItemStack Selten8 = new ItemBuilder(Material.IRON_BOOTS)
                    .setDisplayname("§eMutantenschuhe")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).addEnchant(Enchantment.DURABILITY, 5, true).build();

            ItemStack Selten9 = new ItemBuilder(Material.STONE_SWORD)
                    .setDisplayname("§eSchädelsense")
                    .addEnchant(Enchantment.DAMAGE_ALL, 4, false).addEnchant(Enchantment.DURABILITY, 4, true).build();
            ItemStack Selten10 = new ItemBuilder(Material.STONE_SWORD)
                    .setDisplayname("§eVollstrecker")
                    .addEnchant(Enchantment.DAMAGE_ALL, 3, false).addEnchant(Enchantment.DURABILITY, 4, true).build();

            ItemStack Selten11 = new ItemBuilder(Material.BOW)
                    .setDisplayname("§eAttentäter Bogen").setLore("§9§lBlackout I")
                    .addEnchant(Enchantment.ARROW_DAMAGE, 3, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

            ItemStack Selten12 = new ItemBuilder(Material.STONE_PICKAXE)
                    .setDisplayname("§aMinenplünderer")
                    .addEnchant(Enchantment.DIG_SPEED, 6, true).addEnchant(Enchantment.DURABILITY, 5, true).build();
            ItemStack Selten13 = new ItemBuilder(Material.STONE_PICKAXE)
                    .setDisplayname("§eHöhlenforscher")
                    .addEnchant(Enchantment.DIG_SPEED, 5, false).addEnchant(Enchantment.DURABILITY, 5, true).build();

            ItemStack Selten14 = new ItemBuilder(Material.FISHING_ROD)
                    .setDisplayname("§eAnker")
                    .addEnchant(Enchantment.DURABILITY, 5, true).addEnchant(Enchantment.LURE, 1, false).build();

            ItemStack Selten15 = new ItemBuilder(Material.GHAST_TEAR)
                    .setDisplayname("§eVampirzahn").setLore("§c§lVampir III")
                    .addEnchant(Enchantment.DAMAGE_ALL, 9, true).build();

            ItemStack Selten16 = new ItemBuilder(Material.DIAMOND_BLOCK)
                    .setAmount(16).build();
            ItemStack Selten17 = new ItemBuilder(Material.EMERALD_BLOCK)
                    .setAmount(16).build();
            ItemStack Selten18 = new ItemBuilder(Material.GOLDEN_APPLE)
                    .setAmount(16).build();
            ItemStack Selten19 = new ItemBuilder(Material.ENDER_PEARL)
                    .setAmount(16).build();
            ItemStack Selten20 = new ItemBuilder(Material.ARROW)
                    .setAmount(16).build();
            ItemStack Selten21 = new ItemBuilder(Material.EXP_BOTTLE)
                    .setDisplayname("§6§lSchool XP").setLore("§b» §6§l2500 XP").build();

            selten.add(Selten1);
            selten.add(Selten2);
            selten.add(Selten3);
            selten.add(Selten4);
            selten.add(Selten5);
            selten.add(Selten6);
            selten.add(Selten7);
            selten.add(Selten8);
            selten.add(Selten9);
            selten.add(Selten10);
            selten.add(Selten11);
            selten.add(Selten12);
            selten.add(Selten13);
            selten.add(Selten14);
            selten.add(Selten15);
            selten.add(Selten16);
            selten.add(Selten17);
            selten.add(Selten18);
            selten.add(Selten19);
            selten.add(Selten20);
            selten.add(Selten21);
        }

        void registerEpisch() {


            ItemStack Episch1 = new ItemBuilder(Material.DIAMOND_HELMET)
                    .setDisplayname("§5Elfen Helm").setLore("§a§lStacheln I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
            ItemStack Episch2 = new ItemBuilder(Material.DIAMOND_CHESTPLATE)
                    .setDisplayname("§5Elfen Brustplatte").setLore("§a§lStacheln I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
            ItemStack Episch3 = new ItemBuilder(Material.DIAMOND_LEGGINGS)
                    .setDisplayname("§5Elfen Hose").setLore("§a§lStacheln I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
            ItemStack Episch4 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§5Elfen Schuhe").setLore("§a§lStacheln I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

            ItemStack Episch5 = new ItemBuilder(Material.IRON_HELMET)
                    .setDisplayname("§5Schattenjäger Helm")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 8, true).build();
            ItemStack Episch6 = new ItemBuilder(Material.IRON_CHESTPLATE)
                    .setDisplayname("§5Schattenjäger Brustplatte")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 8, true).build();
            ItemStack Episch7 = new ItemBuilder(Material.IRON_LEGGINGS)
                    .setDisplayname("§5Schattenjäger Hose")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 8, true).build();
            ItemStack Episch8 = new ItemBuilder(Material.IRON_BOOTS)
                    .setDisplayname("§5Schattenjäger Schuhe")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 8, true).build();

            ItemStack Episch9 = new ItemBuilder(Material.IRON_SWORD)
                    .setDisplayname("§5Elfenschwert").setLore("§c§lSchatzmeister I")
                    .addEnchant(Enchantment.DAMAGE_ALL, 5, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
            ItemStack Episch10 = new ItemBuilder(Material.DIAMOND_SWORD)
                    .setDisplayname("§5Teuflischer Schlächter").setLore("§c§lKopfgeld I")
                    .addEnchant(Enchantment.DAMAGE_ALL, 5, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
            ItemStack Episch22 = new ItemBuilder(Material.DIAMOND_SWORD)
                    .setDisplayname("§5Vergifteter Assassinendolch").setLore("§c§lToxic IV")
                    .addEnchant(Enchantment.DAMAGE_ALL, 4, false).addEnchant(Enchantment.DURABILITY, 8, true).build();

            ItemStack Episch11 = new ItemBuilder(Material.BOW)
                    .setDisplayname("§5Feuerwerkskanone").setLore("§9§lExplosion I")
                    .addEnchant(Enchantment.ARROW_DAMAGE, 4, false).addEnchant(Enchantment.DURABILITY, 3, false).build();

            ItemStack Episch15 = new ItemBuilder(Material.DIAMOND_PICKAXE)
                    .setDisplayname("§5Teuflische Walze").setLore("§6§lErfahrung I")
                    .addEnchant(Enchantment.DIG_SPEED, 5, false).addEnchant(Enchantment.DURABILITY, 3, false).build();
            ItemStack Episch12 = new ItemBuilder(Material.IRON_PICKAXE)
                    .setDisplayname("§5Presslufthammer")
                    .addEnchant(Enchantment.DIG_SPEED, 7, true).addEnchant(Enchantment.DURABILITY, 5, true).build();
            ItemStack Episch13 = new ItemBuilder(Material.IRON_PICKAXE)
                    .setDisplayname("§5Bohrmaschine")
                    .addEnchant(Enchantment.DIG_SPEED, 6, true).addEnchant(Enchantment.DURABILITY, 5, true).build();

            ItemStack Episch14 = new ItemBuilder(Material.FISHING_ROD)
                    .setDisplayname("§5Piratennetz")
                    .addEnchant(Enchantment.DURABILITY, 8, true).addEnchant(Enchantment.LURE, 2, false).build();

            ItemStack Episch16 = new ItemBuilder(Material.DIAMOND_BLOCK)
                    .setAmount(32).build();
            ItemStack Episch17 = new ItemBuilder(Material.EMERALD_BLOCK)
                    .setAmount(32).build();
            ItemStack Episch18 = new ItemBuilder(Material.GOLDEN_APPLE)
                    .setAmount(32).build();
            ItemStack Episch19 = new ItemBuilder(Material.ENDER_PEARL)
                    .setAmount(32).build();
            ItemStack Episch20 = new ItemBuilder(Material.ARROW)
                    .setAmount(32).build();
            ItemStack Episch21 = new ItemBuilder(Material.EXP_BOTTLE)
                    .setDisplayname("§6§lSchool XP").setLore("§b» §6§l5000 XP").build();

            selten.add(Episch1);
            selten.add(Episch2);
            selten.add(Episch3);
            selten.add(Episch4);
            selten.add(Episch5);
            selten.add(Episch6);
            selten.add(Episch7);
            selten.add(Episch8);
            selten.add(Episch9);
            selten.add(Episch10);
            selten.add(Episch11);
            selten.add(Episch12);
            selten.add(Episch13);
            selten.add(Episch14);
            selten.add(Episch15);
            selten.add(Episch16);
            selten.add(Episch17);
            selten.add(Episch18);
            selten.add(Episch19);
            selten.add(Episch20);
            selten.add(Episch21);
            selten.add(Episch22);

        }

        void registerLegendär() {




            ItemStack Legi1 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§8Todesengel Helm").setLore("§a§lStacheln I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 3, false)
                    .addEnchant(Enchantment.OXYGEN, 1, false).build();
            ItemStack Legi2 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§8Todesengel Brustplatte").setLore("§a§lObsidian-Schild I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 3, false)
                    .addEnchant(Enchantment.PROTECTION_PROJECTILE, 1, false).build();
            ItemStack Legi3 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§8Todesengel Hose").setLore("§a§lMagieschild I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 3, false)
                    .addEnchant(Enchantment.PROTECTION_FIRE, 1, false).build();
            ItemStack Legi4 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§8Todesengel Schuhe").setLore("§a§lWiderstand I")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true).addEnchant(Enchantment.DURABILITY, 3, false)
                    .addEnchant(Enchantment.PROTECTION_FALL, 1, false).build();


            ItemStack Legi5 = new ItemBuilder(Material.DIAMOND_SWORD)
                    .setDisplayname("§8Seelenschwert").setLore("§c§lAssassine I")
                    .addEnchant(Enchantment.DAMAGE_ALL, 6, true).addEnchant(Enchantment.DURABILITY, 3, false).build();

            ItemStack Legi6 = new ItemBuilder(Material.BOW)
                    .setDisplayname("§8Dämonenbogen").setLore("§9§lStrahlen I")
                    .addEnchant(Enchantment.ARROW_DAMAGE, 6, true).addEnchant(Enchantment.DURABILITY, 3, false)
                    .addEnchant(Enchantment.ARROW_INFINITE, 1, false).build();

            ItemStack Legi7 = new ItemBuilder(Material.DIAMOND_PICKAXE)
                    .setDisplayname("§8Asteroidenzerstörer").setLore("§6§lErfahrung III" , "§6§lDuplizierung III")
                    .addEnchant(Enchantment.DIG_SPEED, 7, true).addEnchant(Enchantment.DURABILITY, 10, true).build();
            ItemStack Legi8 = new ItemBuilder(Material.DIAMOND_PICKAXE)
                    .setDisplayname("§6Erzengel Spitzhacke").setLore("§6§lErfahrung I")
                    .addEnchant(Enchantment.DIG_SPEED, 6, true).addEnchant(Enchantment.DURABILITY, 8, true).build();

            ItemStack Legi9 = new ItemBuilder(Material.FISHING_ROD)
                    .setDisplayname("§6Dreizack des Poseidons")
                    .addEnchant(Enchantment.DURABILITY, 10, true).addEnchant(Enchantment.LURE, 3, false).build();

            ItemStack Legi10 = new ItemBuilder(Material.DIAMOND_AXE)
                    .setDisplayname("§aKöpfer der tropischen Anakonda").setLore("§c§lKobra III" , "§c§lKopfgeld VI")
                    .addEnchant(Enchantment.DAMAGE_ALL, 6, true).addEnchant(Enchantment.DURABILITY, 10, true).build();

            ItemStack Legi11 = new ItemBuilder(Material.DIAMOND_BLOCK)
                    .setAmount(64).build();
            ItemStack Legi12 = new ItemBuilder(Material.EMERALD_BLOCK)
                    .setAmount(64).build();
            ItemStack Legi13 = new ItemBuilder(Material.EXP_BOTTLE)
                    .setDisplayname("§6§lSchool XP").setLore("§b» §6§l12000 XP").build();

            selten.add(Legi1);
            selten.add(Legi2);
            selten.add(Legi3);
            selten.add(Legi4);
            selten.add(Legi5);
            selten.add(Legi6);
            selten.add(Legi7);
            selten.add(Legi8);
            selten.add(Legi9);
            selten.add(Legi10);
            selten.add(Legi11);
            selten.add(Legi12);
            selten.add(Legi13);

        }

        void registerMythisch() {


            ItemStack my1 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§6Feuerroter Phönixhelm").setLore("§a§lStacheln III", "§a§lMagieschild IV", "§a§lObsidian-Schild IV")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 12, true).build();
            ItemStack my2 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§6Feuerrote Phönixbrustplatte").setLore("§a§lObsidian-Schild III", "§a§lTank IV", "§a§lHeilzauber IV")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 12, true).build();
            ItemStack my3 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§6Feuerrote Phönixhose").setLore("§a§lMagieschild III", "§a§lStacheln IV", "§a§lÜberladung IV")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 12, true).build();
            ItemStack my4 = new ItemBuilder(Material.DIAMOND_BOOTS)
                    .setDisplayname("§6Feuerrote Phönixschuhe").setLore("§a§lÜberladung III", "§a§lWiderstand IV", "§a§lObsidian-Schild IV")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true).addEnchant(Enchantment.DURABILITY, 12, true).build();

            ItemStack my5 = new ItemBuilder(Material.SKULL_ITEM)
                    .setDisplayname("§6Maske des Totenkopf-Zauberers").setLore("§a§lObsidian-Schild III" , "§c§lHeilzauber III")
                    .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 12, true).addEnchant(Enchantment.DURABILITY, 5, true).build();

            ItemStack my6 = new ItemBuilder(Material.DIAMOND_PICKAXE)
                    .setDisplayname("§6Wunsch von Ithuriel").setLore("§6§lLaser III" , "§6§lRausch IV", "§6§lErfahrung IV")
                    .addEnchant(Enchantment.DIG_SPEED, 7, true).addEnchant(Enchantment.DURABILITY, 12, true).build();

            ItemStack my7 = new ItemBuilder(Material.DIAMOND_SWORD)
                    .setDisplayname("§6Glorious").setLore("§c§lVampir III", "§c§lKopfgeld IV", "§c§lAssassine IV")
                    .addEnchant(Enchantment.DAMAGE_ALL, 7, true).addEnchant(Enchantment.DURABILITY, 12, true).build();

            mysthische.add(my1);
            mysthische.add(my2);
            mysthische.add(my3);
            mysthische.add(my4);
            mysthische.add(my5);
            mysthische.add(my6);
            mysthische.add(my7);

        }

        void registerTier() {
            ItemStack itemStack1 = new ItemBuilder(Material.RABBIT_STEW) //Material
                    .setDisplayname("§6Kleine Packung") // Name vom Item
                    .setLore("§8» §7Enthält:§f 200 Haustier XP")
                    .build(); //wichtig

            //Wenn etwas öfter vorkommen soll, als andere fügst du das öfter ein.
            //z.B. Wenn es gewöhnlich ist 4mal, selten 3mal, episch 2 mal, legendär 1mal
            //nur wichtig bei der Daily Case und der Haustier Case


            //Weil Gewöhnlich 4 mal
            tier.add(itemStack1);
            tier.add(itemStack1);
            tier.add(itemStack1);
            tier.add(itemStack1);


        }

    }