package me.bluenitrox.school.features.cases;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class CaseItems2 {

    public static LinkedList<ItemStack> daily = new LinkedList<>();;
    public static LinkedList<ItemStack> gewöhnlich = new LinkedList<>();
    public static LinkedList<ItemStack> selten = new LinkedList<>();
    public static LinkedList<ItemStack> episch = new LinkedList<>();
    public static LinkedList<ItemStack> legendär = new LinkedList<>();
    public static LinkedList<ItemStack> mysthische = new LinkedList<>();
    public static LinkedList<ItemStack> tier = new LinkedList<>();

    public static ArrayList<ItemStack> casepot = new ArrayList<>();


    /*
    Idee hinter dem ganzen:
    Es soll nicht direkt am Anfang viele Op Items geben,

    deshalb nur Prot 7 und Schärfe 6 1mal in der Mythischen Case!

    Prot 6 = Legendär
    prot 4, 5 = Episch
    prot 3 = selten
    prot 1, 2 = gewöhnlich

    Sharp 5 = Legendär
    Sharp 4 = Episch
    Sharp 3 = Selten
    Sharp 2, 1 = Gewöhnlich

    Stärke 5 + Infinity = Mythisch
    Stärke 5, 6 = Legendär
    Stärke 4 = Episch
    Stärke 2,3 = Selten
    Stärke 1 = Gewöhnlich

    Effizienz 7 = Mythisch
    Effizienz 6 = Legendär
    Effizienz 4, 5 = Episch
    Effizienz 3 = Selten
    Effizienz 1, 2 = Gewöhnlich

    1er Enchant = Gewöhnlich
    2er Enchant = Selten, Episch
    3er Enchant = Legendär, Mythisch
    (ausgenommen extra Items)
     */


    void registerLegendär(){
        /*
        Erledigt,
        aber Extra Items nochmal überdenken
         */


        /*
        Rüstungen:
        Mutantenrüstung (Dia) - Schutz 7, Haltbarkeit 3 -> Schutz 6, Haltbarkeit 5
        Rüstung des Drachenjägers (Dia) - Schutz 6, Haltbarkeit 5 -> remove

        Chestplates:
        Schulrucksack (Leder)  - Schutz 6, Haltbarkeit 10 (Unbreakable) -> Schutz 4, Haltbarkeit 10

        Schwerter:
        Drachenbezwinger (Dia) - Schärfe 6, Haltbarkeit 6 -> Schärfe 5,Haltbarkeit 5
        Schwert des Imperators (Iron) - Schärfe 6, Verbrennung 1 -> Schärfe 3, Haltbarkeit 2, Verbrennung 1

        Bögen:
        Armbrust des Drachenjägers - Stärke 6, Haltbarkeit 3 -> Stärke 6, Haltbarkeit 3
        Satans Bogen - Stärke 5, Haltbarkeit 5

        Spitzhacken:
        Schatzgräber (Dia) - Effizienz 7, Haltbarkeit 10 -> Effizienz 6, Haltbarkeit 10

        Angeln:
        Dreizack des Poseidons - Haltbarkeit 10, Luck 3
         */

        //Rüstungen
        ItemStack is = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Mutantenhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lStacheln III").build();

        ItemStack is1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Mutantenharnisch").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).addEnchant(Enchantment.THORNS, 1, false).setLore("§a§lWiderstand III").build();

        ItemStack is2 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Mutantenbeinschutz").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lMagieschild III").build();

        ItemStack is3 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Mutantenstiefel").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lHeilzauber III").build();


        //removed
       /* ItemStack is4 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Drachenjäger Helm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lObsidian-Schild III").build();

        ItemStack is5 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Drachenjäger Brustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, false)
                .addEnchant(Enchantment.DURABILITY, 5, false).setLore("§a§lEis III").build();

        ItemStack is6 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Drachenjäger Brustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, false)
                .addEnchant(Enchantment.DURABILITY, 5, false).setLore("§a§lÜberladung III").build();

        ItemStack is7 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Drachenjäger Schuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, false)
                .addEnchant(Enchantment.DURABILITY, 5, false).setLore("§a§lTank III").build();
        */


        //Lederrüstung
        ItemStack lederhelm = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta lederhelmItemMeta = (LeatherArmorMeta)lederhelm.getItemMeta();
        lederhelmItemMeta.setColor(Color.AQUA);
        lederhelmItemMeta.setDisplayName("§6Schulmütze");
        lederhelmItemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        lederhelmItemMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        lederhelmItemMeta.setLore(Arrays.asList("§a§lTank II", ""));
        lederhelmItemMeta.spigot().setUnbreakable(true);
        lederhelm.setItemMeta(lederhelmItemMeta);

        ItemStack is14 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta100 = (LeatherArmorMeta)is14.getItemMeta();
        meta100.setColor(Color.AQUA);
        meta100.setDisplayName("§6Schulrucksack");
        meta100.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        meta100.addEnchant(Enchantment.DURABILITY, 3, false);
        meta100.setLore(Arrays.asList("§a§lTank II", ""));
        meta100.spigot().setUnbreakable(true);
        is14.setItemMeta(meta100);

        ItemStack lederhose = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta lederhoseItemMeta = (LeatherArmorMeta)lederhose.getItemMeta();
        lederhoseItemMeta.setColor(Color.AQUA);
        lederhoseItemMeta.setDisplayName("§6Schuluniform Hose");
        lederhoseItemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        lederhoseItemMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        lederhoseItemMeta.setLore(Arrays.asList("§a§lTank II", ""));
        lederhoseItemMeta.spigot().setUnbreakable(true);
        lederhose.setItemMeta(lederhelmItemMeta);

        ItemStack lederschuhe = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta lederschuheItemMeta = (LeatherArmorMeta)lederschuhe.getItemMeta();
        lederschuheItemMeta.setColor(Color.AQUA);
        lederschuheItemMeta.setDisplayName("§6Schuluniform Schuhe");
        lederschuheItemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
        lederschuheItemMeta.addEnchant(Enchantment.DURABILITY, 3, false);
        lederschuheItemMeta.setLore(Arrays.asList("§a§lTank II", ""));
        lederschuheItemMeta.spigot().setUnbreakable(true);
        lederschuhe.setItemMeta(lederhelmItemMeta);




        //Schwerter
        ItemStack is8 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Drachenbezwinger").addEnchant(Enchantment.DAMAGE_ALL, 5, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§c§lAnti-Venom III", "§c§lAssassine III").build();


        ItemStack is9 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§6Schwert des Imperators").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 2, false).addEnchant(Enchantment.FIRE_ASPECT, 1, false).setLore("§c§lKopfgeld III", "§c§lEnergieentzug III").build();




        //Bögen
        ItemStack is10 = new ItemBuilder(Material.BOW).setDisplayname("§6Armbrust des Drachenjägers").addEnchant(Enchantment.ARROW_DAMAGE, 6, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§9§lElektrisiert III", "§9§lBlackout III").build();


        ItemStack is11 = new ItemBuilder(Material.BOW).setDisplayname("§6Satans Bogen").addEnchant(Enchantment.ARROW_DAMAGE, 5, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§9§lTod III").build();



        //Spitzhacken
        /*ItemStack is12 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6Schatzgräber").addEnchant(Enchantment.DIG_SPEED, 8, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lRausch III", "§6§lDuplizierung III").build();
         */


        ItemStack is13 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6Schatzgräber").addEnchant(Enchantment.DIG_SPEED, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lLaser III", "§6§lAusgrabung III").build();


        //Angeln
        ItemStack is15 = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§6Dreizack des Poseidons").addEnchant(Enchantment.DURABILITY, 10, true)
                .addEnchant(Enchantment.LURE, 3, false).setLore("§6§lFischerglück III", "§6§lGoldhaken III").build();


        ItemStack is18 = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblöcke").setAmount(64).build();
        ItemStack is27 = new ItemBuilder(Material.EMERALD_BLOCK).setDisplayname("§7Smaragdblöcke").setAmount(64).build();
        ItemStack is19 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 500 XP").setAmount(24).build();
        ItemStack is20 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§6Endermanspawner").build();
        ItemStack is21 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§6Creeperspawner").build();
        ItemStack is26 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§6Creeperspawner").build();

        legendär.add(is);
        legendär.add(is1);
        legendär.add(is2);
        legendär.add(is3);
        legendär.add(is8);
        legendär.add(is9);
        legendär.add(is10);
        legendär.add(is11);
        legendär.add(is13);
        legendär.add(is14);
        legendär.add(is15);
        legendär.add(is18);
        legendär.add(is19);
        legendär.add(is20);
        legendär.add(is21);
        legendär.add(is27);
        legendär.add(is26);
        legendär.add(lederhose);
        legendär.add(lederhelm);
        legendär.add(lederschuhe);
    }

    void registerDaily(){

        //Gewöhnliche Items

        ItemStack rd = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§7Harlekin Mütze").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank I").build();
        ItemStack rd1 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§7Halekin Jacke").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank I").build();
        ItemStack rd2 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§7Halekin Hose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank I").build();
        ItemStack rd3 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§7Halekin Schuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank I").build();

        ItemStack rd4 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§7Taschenmesser").addEnchant(Enchantment.DAMAGE_ALL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§c§lEntdecker I").build();

        ItemStack rd5 = new ItemBuilder(Material.BOW).setDisplayname("§7Pfeilgeschoss").addEnchant(Enchantment.ARROW_DAMAGE, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§9§lFesseln I").build();

        ItemStack rd6 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§7Erzpulverisator").addEnchant(Enchantment.DIG_SPEED, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§lZorn I").build();

        ItemStack rd7 = new ItemBuilder(Material.ARROW).setDisplayname("§7Pfeile").setAmount(16).build();
        ItemStack rd8 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldene Äpfel").setAmount(16).build();
        ItemStack rd9 = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperlen").setAmount(16).build();

        ItemStack rd10 = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisenblöcke").setAmount(32).build();
        ItemStack rd11 = new ItemBuilder(Material.GOLD_BLOCK).setAmount(32).setDisplayname("§7Goldblöcke").build();

        ItemStack rd111 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 500 XP").setAmount(2).build();

        //Seltene Items

        ItemStack rd12 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§9Helm des Grabunholds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lStacheln I").build();
        ItemStack rd13 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§9Brustplatte des Grabunholds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lStacheln I").build();
        ItemStack rd14 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§9Hose des Grabunholds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lStacheln I").build();
        ItemStack rd15 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9Schuhe des Grabunholds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lStacheln I").build();

        ItemStack rd16 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§9Giftiger Skorpion Dolch").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§c§lFluch I").build();

        ItemStack rd17 = new ItemBuilder(Material.BOW).setDisplayname("§9Halunkenbogen").addEnchant(Enchantment.ARROW_DAMAGE, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§9§lDynamite I").build();

        ItemStack rd18 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§9Minenplünderer Hacke").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 2, false).setLore("§6§lErfahrung I").build();

        ItemStack rd19 = new ItemBuilder(Material.ARROW).setDisplayname("§7Pfeile").setAmount(32).build();
        ItemStack rd20 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldene Äpfel").setAmount(32).build();
        ItemStack rd21 = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperlen").setAmount(16).build();

        ItemStack rd22 = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisenblöcke").setAmount(64).build();
        ItemStack rd23 = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Goldblöcke").setAmount(64).build();
        ItemStack rd24 = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblöcke").setAmount(32).build();


        ItemStack rd222 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 500 XP").setAmount(4).build();

        // Epische Items

        ItemStack rd25 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§5Barbarenhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lEis II", "§a§lÜberladung II").build();
        ItemStack rd26 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Barbarenbrustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lMagieschild II", "§a§lÜberladung II").build();
        ItemStack rd27 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§5Barbarenhose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lHeilzauber II").build();
        ItemStack rd28 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Barbarenschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lÜberladung II").build();

        ItemStack rd29 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§5Vergifteter Assassinendolch").addEnchant(Enchantment.DAMAGE_ALL, 5, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§c§lKobra II").build();

        ItemStack rd30 = new ItemBuilder(Material.BOW).setDisplayname("§5Elfenbogen").addEnchant(Enchantment.ARROW_DAMAGE, 5, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§9§lElektrisiert II").build();

        ItemStack rd31 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§5Minenzerberster").addEnchant(Enchantment.DIG_SPEED, 5, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§6§lDuplizierung","§6§lAusgrabung II").build();

        ItemStack rd333 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 500 XP").setAmount(6).build();



        daily.add(rd);
        daily.add(rd1);
        daily.add(rd2);
        daily.add(rd3);
        daily.add(rd4);
        daily.add(rd5);
        daily.add(rd6);
        daily.add(rd7);
        daily.add(rd8);
        daily.add(rd9);
        daily.add(rd10);
        daily.add(rd11);
        daily.add(rd12);
        daily.add(rd13);
        daily.add(rd14);
        daily.add(rd15);
        daily.add(rd16);
        daily.add(rd17);
        daily.add(rd18);
        daily.add(rd19);
        daily.add(rd20);
        daily.add(rd21);
        daily.add(rd22);
        daily.add(rd23);
        daily.add(rd24);
        daily.add(rd25);
        daily.add(rd26);
        daily.add(rd27);
        daily.add(rd28);
        daily.add(rd111);
        daily.add(rd222);
        daily.add(rd333);



    }

    void registerGewöhnlich(){
        /*
        Erledigt,
        aber extra Items anpassen
         */

        /*
        Rüstungen:
        Diebesrüstung (Dia) - Schutz 1, Haltbarkeit 3 -> bleibt so
        Rabaukenrüstung (Eisen -> Dia) - Schutz 1, Haltbarkeit 3 -> Schutz 2, Haltbarkeit 1

        Schuhe:
        Gefederte Schuhe (Ketten) - Federfall 4, Haltbarkeit 3 -> bleibt so

        Schwerter:
        Stumpfes Messer (Holz) - Schärfe 4, Haltbarkeit 3
        HINZUFÜGEN: Schwert aus Stahl (Dia) - Schärfe 1, Haltbarkeit 3

        Bögen:
        Wikingerbogen - Stärke 2, Haltbarkeit 3 -> Stärke 1, Haltbarkeit 3
        Präziser Bogen - Stärke 2, Haltbarkeit 3 -> Stärke 2, Haltbarkeit 1

        Spitzhacken:
        Abgenutzte Spitzhacke (Stein) - Effizienz 5, Haltbarkeit 5 -> bleibt so
        Rostiger Sparten (Stein -> ) - Effizienz 4, Haltbarkeit 5 -> Effizienz 1, Haltbarkeit 3

        Angel:
        Kescher - Haltbarkeit 3

        Extra:
        Abgebrochene Speerspitze - Schärfe 3, Haltbarkeit 2, Knockback 1
         */

        ItemStack gw1 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§7Diebeskaputze").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack gw2 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§7Diebesjacke").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack gw3 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§7Diebeshose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).build();
        ItemStack gw4 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§7Diebesschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).build();


        ItemStack gw5 = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§7Rabaukenmütze").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§a§lMagieschild I").build();
        ItemStack gw6 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§7Rabaukenjacke").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§a§lEis I").build();
        ItemStack gw7 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§7Rabaukenhose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§a§lStacheln I").build();
        ItemStack gw8 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§7Rabaukenschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§a§lObsidian-Schild I").build();



        ItemStack gw9 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§7Stumpfes Messer").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§c§lFluch I").build();
        ItemStack gw23 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§7Schwert aus Stahl").addEnchant(Enchantment.DAMAGE_ALL, 1, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§c§lKobra I").build();


        ItemStack gw10 = new ItemBuilder(Material.STICK).setDisplayname("§7Abgebrochene Speerspitze").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 2, false).addEnchant(Enchantment.KNOCKBACK, 1, false).build();

        ItemStack gw11 = new ItemBuilder(Material.BOW).setDisplayname("§7Wikingerbogen").addEnchant(Enchantment.ARROW_DAMAGE, 1, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§9§lBlackout I").build();
        ItemStack gw12 = new ItemBuilder(Material.BOW).setDisplayname("§7Präziser Bogen").addEnchant(Enchantment.ARROW_DAMAGE, 2, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§9§lStrahlen I").build();

        ItemStack gw13 = new ItemBuilder(Material.STONE_PICKAXE).setDisplayname("§7Abgenutzte Spitzhacke").addEnchant(Enchantment.DIG_SPEED, 5, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§6§lErfahrung I").build();
        ItemStack gw14 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§7Rostiger Sparten").addEnchant(Enchantment.DIG_SPEED, 1, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§6§lRausch I").build();

        ItemStack gw15 = new ItemBuilder(Material.CHAINMAIL_BOOTS).setDisplayname("§7Gefederte Schuhe").addEnchant(Enchantment.PROTECTION_FALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).build();


        ItemStack gw16 = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblöcke").setAmount(16).build();
        ItemStack gw17 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldene Äpfel").setAmount(12).build();
        ItemStack gw18 = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperlen").setAmount(8).build();
        ItemStack gw19 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§7Schweinespawner").build();
        ItemStack gw20 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§7Kaninchenspawner").build();

        ItemStack gw21 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 500 XP").setAmount(3).build();

        ItemStack gw22 = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§7Kescher").addEnchant(Enchantment.DURABILITY, 3, false)
                .setLore("§6§lGroßer-Fang I").build();


        gewöhnlich.add(gw1);
        gewöhnlich.add(gw2);
        gewöhnlich.add(gw3);
        gewöhnlich.add(gw4);
        gewöhnlich.add(gw5);
        gewöhnlich.add(gw6);
        gewöhnlich.add(gw7);
        gewöhnlich.add(gw8);
        gewöhnlich.add(gw9);
        gewöhnlich.add(gw10);
        gewöhnlich.add(gw11);
        gewöhnlich.add(gw12);
        gewöhnlich.add(gw13);
        gewöhnlich.add(gw14);
        gewöhnlich.add(gw15);
        gewöhnlich.add(gw16);
        gewöhnlich.add(gw17);
        gewöhnlich.add(gw18);
        gewöhnlich.add(gw19);
        gewöhnlich.add(gw20);
        gewöhnlich.add(gw21);
        gewöhnlich.add(gw22);
        gewöhnlich.add(gw23);




    }

    void registerSelten(){
        /*
        Erledigt,
        aber extra Items noch eventuell überarbeiten.
         */
        /*

        Rüstung:
        Druiden Rüstung (Dia) - Schutz 3, Haltbarkeit 3
        Ganovenrüstung (Dia) - Schutz 2, Haltbarkeit 3

        Schwerter:
        Vollstrecker Schwert (Iron) - Schärfe 4, Haltbarkeit 5
        Dolch des Berggeists (Dia) - Schärfe 3, Haltbarkeit 3
        Schwert des Feuerteufels (Gold) - Schärfe 4, Haltbarkeit 3, Fire Aspect 1
        Hirschfänger (Stein) - Schärfe 3, Haltbarkeit 3, Plünderung 2

        Bögen:
        Schwere Armbrust - Stärke 1, Haltbarkeit 3 -> Stärke 2, Haltbarkeit 3
        Banditenbogen - Stärke 3, Haltbarkeit 3 -> Stärke 3, Haltbarkeit 3

        Spitzhacken:
        Schatzgräber (Dia) - Effizienz 3, Haltbarkeit 3 -> bleibt so
        Bohrmaschine (Iron) - Effizienz 4, Haltbarkeit 5 -> bleibt so
        Schmieders Hacke (Dia) - Effizienz 4, Haltbarkeit 5 -> Effizienz 4, Haltbarkeit 1

        Angeln:
        Angel des Wassergeistes - Haltbarkeit 5, Luck 1
         */

        ItemStack rs = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§9Kaputze des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lMagieschild II").build();
        ItemStack rs1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§9Mantel des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lHeilzauber II").build();
        ItemStack rs2 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§9Hose des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lMagieschild II").build();
        ItemStack rs3 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9Schuhe des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lHeilzauber II").build();

        ItemStack rs4 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§9Ganovenhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II").build();
        ItemStack rs5 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§9Ganovenbrustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II").build();
        ItemStack rs6 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§9Ganovenhose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II").build();
        ItemStack rs7 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9Ganovenstiefel").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II").build();



        ItemStack rs8 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§9Vollstrecker Schwert").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§c§lKobra I").build();
        ItemStack rs9 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§9Dolch des Berggeists").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§c§lKopfgeld I").build();

        ItemStack rs10 = new ItemBuilder(Material.BOW).setDisplayname("§9Schwere Armbrust").addEnchant(Enchantment.ARROW_DAMAGE, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§9§lElektrisiert II").build();
        ItemStack rs11 = new ItemBuilder(Material.BOW).setDisplayname("§9Banditenbogen").addEnchant(Enchantment.ARROW_DAMAGE, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§9§lStrahlen II").build();




        ItemStack rs12 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§9Schatzgräber").addEnchant(Enchantment.DIG_SPEED, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§lAusgrabung II").build();
        ItemStack rs13 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§9Bohrmaschine").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§6§lDuplizierung II").build();



        ItemStack rs14 = new ItemBuilder(Material.GOLD_SWORD).setDisplayname("§9Schwert des Feuerteufels").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).addEnchant(Enchantment.FIRE_ASPECT, 1, false).build();


        ItemStack rs15 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§9Schmieders Hacke").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 1, false).setLore("§6§lZorn II").build();


        ItemStack rs16 = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblöcke").setAmount(32).build();
        ItemStack rs17 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldene Äpfel").setAmount(24).build();
        ItemStack rs18 = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperlen").setAmount(16).build();

        ItemStack rs19 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§9Skelettspawner").build();
        ItemStack rs20 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§9Kuhspawner").build();

        ItemStack rs21 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 500 XP").setAmount(6).build();

        ItemStack rs22 = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§9Wassergeist Angel").addEnchant(Enchantment.DURABILITY, 5, true)
                .addEnchant(Enchantment.LURE, 1, false).setLore("§6§lGoldhaken II", "§6§lFischerglück II").build();

        ItemStack rs23 = new ItemBuilder(Material.STONE_SWORD).setDisplayname("§9Hirschfänger").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, false).build();


        selten.add(rs);
        selten.add(rs1);
        selten.add(rs2);
        selten.add(rs3);
        selten.add(rs4);
        selten.add(rs5);
        selten.add(rs6);
        selten.add(rs7);
        selten.add(rs8);
        selten.add(rs9);
        selten.add(rs10);
        selten.add(rs11);
        selten.add(rs12);
        selten.add(rs13);
        selten.add(rs14);
        selten.add(rs15);
        selten.add(rs16);
        selten.add(rs17);
        selten.add(rs18);
        selten.add(rs19);
        selten.add(rs20);
        selten.add(rs21);
        selten.add(rs22);
        selten.add(rs23);
    }

    void registerEpisch(){
        /*
        Erledigt,
        extra Items eventuell
         */

        /*
        Rüstung:
        Rüstung des Drachenjägers (Dia) - Schutz 5, Haltbarkeit 3 -> bleibt so
        Abgrundrüstung (Dia) - Schutz 4, Haltbarkeit 5 -> bleibt so


        Solarplattenrüstung (Iron) - Schutz 7, Haltbarkeit 3 -> ?


        Schwerter:
        Antikes Schwert (Dia) - Schärfe 5, Haltbarkeit 3 -> Schärfe 4, Haltbarkeit 4

        Schwert befleckt von Drachenblut (Iron) - Schärfe 5, Haltbarkeit 8, Plünderung 2 -> ?
        Piratenmesser (Iron) - Schärfe 6, Haltbarkeit 3 -> bleibt so

        Bögen:
        Schurken Kanone - Stärke 6, Haltbarkeit 8 -> remove
        Bogen des Schattendieners - Stärke 5, Haltbarkeit 7 -> Stärke 4, Haltbarkeit 4

        Spitzhacke:
        Spitzhacke des Bankräubers (Dia) - Effizienz 5, Haltbarkeit 3 -> Effizienz 4, Haltbarkeit 4
        Erzengel (Dia) - hinzufügen: Effizienz 5, Haltbarkeit 5

        Spitzhacke aus außerirdischem Material (Iron) -> außerirdische Spitzhacke - Effizienz 7, Haltbarkeit 12 -> Effizienz 7, Haltbarkeit 10
        Gruftlord Spitzhacke (Iron) - Effizienz 6, Haltbarkeit 12 -> remove

        Angeln:
        Angel mit verstärkter Rute - Haltbarkeit 5, Luck 3
         */

        //Rüstung
        ItemStack re = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§5Helm des Drachenjägers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lMagieschild II").build();

        ItemStack re1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Brustplatte des Drachenjägers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lObsidian-Schild II").build();

        ItemStack re2 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§5Hose des Drachenjägers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lWiderstand II").build();

        ItemStack re3 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§5Schuhe des Drachenjägers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lHeilzauber II").build();



        ItemStack re4 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§5Helm des Abgrunds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lHeilzauber II").build();

        ItemStack re5 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Harnisch des Abgrunds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank II").build();

        ItemStack re6 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§5Beinschienen des Abgrunds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lObsidian-Schild II").build();

        ItemStack re7 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§5Stiefel des Abgrunds").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lStacheln II").build();



        ItemStack re23 = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§5Solarplattenhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II","§a§lStacheln II").build();

        ItemStack re24 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§5Solarplattenharnisch").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II","§a§lStacheln II").build();

        ItemStack re25 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§5Solarplattenhose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II","§a§lStacheln II").build();

        ItemStack re26 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§5Solarplattenschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank II","§a§lStacheln II").build();



        //Schwerter
        ItemStack re8 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§5Antikes Schwert").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 4, true).setLore("§c§lAnti-Venom II").build();


        ItemStack re9 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§5Schwert befleckt von Drachenblut").addEnchant(Enchantment.DAMAGE_ALL, 5, false)
                .addEnchant(Enchantment.DURABILITY, 8, true).addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, false).setLore("§c§lJäger II","§c§lEntdecker II").build();

        ItemStack re22 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§5Piratenmesser").addEnchant(Enchantment.DAMAGE_ALL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§c§lEnergieentzug II").build();



        //Bögen
       /* ItemStack re10 = new ItemBuilder(Material.BOW).setDisplayname("§5Schurken Kanone").addEnchant(Enchantment.ARROW_DAMAGE, 6, true)
                .addEnchant(Enchantment.DURABILITY, 8, true).setLore("§9§lFesseln II", "§9§lBlackout II").build(); */


        ItemStack re11 = new ItemBuilder(Material.BOW).setDisplayname("§5Attentäter Gewehr").addEnchant(Enchantment.ARROW_DAMAGE, 4, false)
                .addEnchant(Enchantment.DURABILITY, 4, true).setLore("§9§lDynamite II").build();



        //Spitzhacken
        ItemStack re12 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§5Bankräuber Spitzhacke").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 4, true).setLore("§6§lLaser II").build();

        ItemStack re10 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§5Erzengel").addEnchant(Enchantment.DIG_SPEED, 5, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§lErfahrung II").build();


        ItemStack re13 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§5Spitzhacke aus außerirdischem Material").addEnchant(Enchantment.DIG_SPEED, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lAusgrabung II", "§6§lDuplizierung II").build();


/*        ItemStack re27 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§5Gruftlord Spitzhacke").addEnchant(Enchantment.DIG_SPEED, 6, true)
                .addEnchant(Enchantment.DURABILITY, 12, true).setLore("§6§lLaser II", "§6§lErfahrung II").build(); */




        //Angeln
        ItemStack re21 = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§5Angel mit verstärkter Rute").addEnchant(Enchantment.DURABILITY, 5, true)
                .addEnchant(Enchantment.LURE, 2, false).setLore("§6§lGroßer-Fang II", "§6§lFischerglück II").build();



        //Extra Items
        ItemStack re14 = new ItemBuilder(Material.STICK).setDisplayname("§5Zauberstab").addEnchant(Enchantment.DAMAGE_ALL, 5, false)
                .addEnchant(Enchantment.KNOCKBACK, 2, false).setLore("§c§lAssassine II").build();


        ItemStack re15 = new ItemBuilder(Material.IRON_AXE).setDisplayname("§5Berserkeraxt").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lGärtner II", "§6§lBaumpflege II").build();



        //Standard Case Items
        ItemStack re16 = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblöcke").setAmount(64).build();

        ItemStack re17 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldene Äpfel").setAmount(48).build();

        ItemStack re18 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§5Wächterspawner").build();

        ItemStack re19 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§5Blazespawner").build();

        ItemStack re20 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 500 XP").setAmount(12).build();



        episch.add(re);
        episch.add(re1);
        episch.add(re2);
        episch.add(re3);
        episch.add(re4);
        episch.add(re5);
        episch.add(re6);
        episch.add(re7);
        episch.add(re8);
        episch.add(re9);
        episch.add(re10);
        episch.add(re11);
        episch.add(re12);
        episch.add(re13);
        episch.add(re14);
        episch.add(re15);
        episch.add(re16);
        episch.add(re17);
        episch.add(re18);
        episch.add(re19);
        episch.add(re20);
        episch.add(re21);
        episch.add(re22);
        episch.add(re23);
        episch.add(re24);
        episch.add(re25);
        episch.add(re26);
    }


    void registerMysthische() {

        /*
            Rüstungen:
            Phönixrüstung (Dia) - Schutz 7, Haltbarkeit 10 -> Schutz 7, Haltbarkeit 10
            Rüstung des mysteriösen Drachenkriegers(Dia) - Schutz 8, Haltbarkeit 3 -> Schutz 6, Haltbarkeit 10

            Schwerter:
            Attentäter (Dia) - Schärfe 6, Haltbarkeit 10 -> Schärfe 6, Haltbarkeit 10
            Hexenmesser (Iron) - Schärfe 7, Haltbarkeit 12 -> Schärfe 7, Haltbarkeit 10

            Bögen:
            Bogen des gefallenen Engels - Stärke 8,Haltbarkeit 10, Punch 1 -> Stärke 6, Haltbarkeit 10
            Dämonenblitz - Stärke 7, Haltbarkeit 10, Infinity 1 -> Stärke 5, Haltbarkeit 10, Infinity 1

            Spitzhacken:
            Spitzhacke des erzürnten Miners (Dia) -> Bedrockbrecher2001 - Effizienz 7, Haltbarkeit 12 -> Effizienz 7, Haltbarkeit 10
            Dämonenhacke (Iron) - Effizienz 9, Haltbarkeit 12 -> Effizienz 8, Haltbarkeit 10

            Angeln:
            Fänger der Meeresungeheuer - Haltbarkeit 12, Luck 4 -> Haltbarkeit 10, Luck 4

            Extra Items:
            Köpfer der tropischen Anakonda (Dia = Axt) - Schärfe 7, Haltbarkeit 12 = Kopfgelditem -> Schärfe 5, Haltbarkeit 10 (Enchant auf 7)
            Maske des Totenkopf-Zauberers (Kopf) - Schutz 12, Haltbarkeit 5
         */

        //Rüstungen
        ItemStack rm = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Feuerroter Phönixhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lÜberladung III").build();

        ItemStack rm2 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Feuerrote Phönixbrustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lTank III").build();

        ItemStack rm3 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Feuerrote Phönixhose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lEis III").build();

        ItemStack rm4 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Feuerrote Phönixschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lMagieschild III").build();


        ItemStack rm5 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Helm des mysteriösen Drachenkriegers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lMagieschild III", "§a§lStacheln III").build();

        ItemStack rm6 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Brustplatte des mysteriösen Drachenkriegers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lÜberladung III", "§a§lWiderstand III").build();

        ItemStack rm7 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Hose des mysteriösen Drachenkriegers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lEis III", "§a§lTank III").build();

        ItemStack rm8 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Schuhe des mysteriösen Drachenkriegers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lObsidian-Schild III", "§a§lHeilzauber III").build();


        //Schwerter
        ItemStack rm9 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Attentäter").addEnchant(Enchantment.DAMAGE_ALL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§c§lAssassine III").build();


        ItemStack rm10 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§6Hexenmesser").addEnchant(Enchantment.DAMAGE_ALL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 7, true).setLore("§c§lAnti-Venom III", "§c§lEnergie-Entzug III").build();


        //Bögen
        ItemStack rm11 = new ItemBuilder(Material.BOW).setDisplayname("§6Bogen des gefallenen Engels").addEnchant(Enchantment.ARROW_DAMAGE, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false).setLore("§9§lDynamite III", "§9§lStrahlen III").build();


        ItemStack rm12 = new ItemBuilder(Material.BOW).setDisplayname("§6Dämonenblitz").addEnchant(Enchantment.ARROW_DAMAGE, 5, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).addEnchant(Enchantment.ARROW_INFINITE, 1, false).setLore("§9§lFesseln III", "§9§lStrahlen III").build();


        //Spitzhacke
        ItemStack rm13 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6Bedrockbrecher2001").addEnchant(Enchantment.DIG_SPEED, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lLaser III", "§6§lErfahrung III").build();


        ItemStack rm14 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§6Dämonenhacke").addEnchant(Enchantment.DIG_SPEED, 8, true)
                .addEnchant(Enchantment.DURABILITY, 8, true).setLore("§6§lDuplizierung III", "§6§lAusgrabung III").build();


        //Extra Items
        ItemStack rm16 = new ItemBuilder(Material.GOLD_AXE).setDisplayname("§6Köpfer der tropischen Anakonda").addEnchant(Enchantment.DAMAGE_ALL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 12, true).setLore("§c§lKopfgeld VII").build();

        ItemStack rm15 = new ItemBuilder(Material.SKULL_ITEM).setDisplayname("§6Maske des Totenkopf-Zauberers").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 12, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lObsidian-Schild III", "§a§lHeilzauber III").build();


        //besondere Case Items
        ItemStack rm17 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setLore("§8» §7Beinhaltet:§6§l 50000 XP").build();
        ItemStack rm18 = new ItemBuilder(Material.MOB_SPAWNER).setDisplayname("§6Zombie-Pigman Spawner").build();


        //Angeln
        ItemStack rm19 = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§6Fänger der Meeresungeheuer").addEnchant(Enchantment.DURABILITY, 10, true)
                .addEnchant(Enchantment.LURE, 4, true).setLore("§6§lFischerglück III", "§6§lGroßer-Fang III").build();


        mysthische.add(rm);
        mysthische.add(rm2);
        mysthische.add(rm3);
        mysthische.add(rm4);
        mysthische.add(rm5);
        mysthische.add(rm6);
        mysthische.add(rm7);
        mysthische.add(rm8);
        mysthische.add(rm9);
        mysthische.add(rm10);
        mysthische.add(rm11);
        mysthische.add(rm12);
        mysthische.add(rm13);
        mysthische.add(rm14);
        mysthische.add(rm15);
        mysthische.add(rm16);
        mysthische.add(rm17);
        mysthische.add(rm18);
        mysthische.add(rm19);


    }


    void registerTier(){

        ItemStack ti1 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kleine Packung").setLore("§8» §7Enthält:§f 100 Haustier XP").build();
        ItemStack tig1 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kleine Packung").setLore("§8» §7Enthält:§f 100 Haustier XP").build();
        ItemStack tig2 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kleine Packung").setLore("§8» §7Enthält:§f 100 Haustier XP").build();
        ItemStack tig3 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kleine Packung").setLore("§8» §7Enthält:§f 100 Haustier XP").build();
        ItemStack tig4 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kleine Packung").setLore("§8» §7Enthält:§f 100 Haustier XP").build();

        ItemStack ti2 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Nährstoff Packung").setLore("§8» §7Enthält:§f 200 Haustier XP").build();
        ItemStack tig5 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Nährstoff Packung").setLore("§8» §7Enthält:§f 200 Haustier XP").build();
        ItemStack tig6 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Nährstoff Packung").setLore("§8» §7Enthält:§f 200 Haustier XP").build();
        ItemStack tig7 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Nährstoff Packung").setLore("§8» §7Enthält:§f 200 Haustier XP").build();

        ItemStack ti3 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kraftfutter Packung").setLore("§8» §7Enthält:§f 300 Haustier XP").build();
        ItemStack tig8 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kraftfutter Packung").setLore("§8» §7Enthält:§f 300 Haustier XP").build();
        ItemStack tig9 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Kraftfutter Packung").setLore("§8» §7Enthält:§f 300 Haustier XP").build();

        ItemStack ti4 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Protein Packung").setLore("§8» §7Enthält:§f 400 Haustier XP").build();
        ItemStack ti11 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Protein Packung").setLore("§8» §7Enthält:§f 400 Haustier XP").build();

        ItemStack ti5 = new ItemBuilder(Material.RABBIT_STEW).setDisplayname("§6Riesige Packung").setLore("§8» §7Enthält:§f 500 Haustier XP").build();

        ItemStack tie1 = new ItemBuilder(Material.MONSTER_EGG, (short) 90).setDisplayname("§6Haustier : Benjamin").setLore("§8» §7Rechtsklicke, um dieses Tier §aeinzulösen§7.").build();
        ItemStack tie2 = new ItemBuilder(Material.MONSTER_EGG, (short) 91).setDisplayname("§6Haustier : Merlin").setLore("§8» §7Rechtsklicke, um dieses Tier §aeinzulösen§7.").build();
        ItemStack tie3 = new ItemBuilder(Material.MONSTER_EGG, (short) 92).setDisplayname("§6Haustier : Eddy").setLore("§8» §7Rechtsklicke, um dieses Tier §aeinzulösen§7.").build();
        ItemStack tie4 = new ItemBuilder(Material.MONSTER_EGG, (short) 98).setDisplayname("§6Haustier : Anton").setLore("§8» §7Rechtsklicke, um dieses Tier §aeinzulösen§7.").build();
        ItemStack tie5 = new ItemBuilder(Material.MONSTER_EGG, (short) 93).setDisplayname("§6Haustier : Helgar").setLore("§8» §7Rechtsklicke, um dieses Tier §aeinzulösen§7.").build();
        ItemStack tie6 = new ItemBuilder(Material.MONSTER_EGG, (short) 95).setDisplayname("§6Haustier : Farid").setLore("§8» §7Rechtsklicke, um dieses Tier §aeinzulösen§7.").build();
        ItemStack tie7 = new ItemBuilder(Material.MONSTER_EGG, (short) 101).setDisplayname("§6Haustier : Peter").setLore("§8» §7Rechtsklicke, um dieses Tier §aeinzulösen§7.").build();


        for(int i = 0; i<= 3; i++) {
            tier.add(ti1);
            tier.add(tig1);
            tier.add(tig2);
            tier.add(tig3);
            tier.add(tig4);
            tier.add(ti2);
            tier.add(tig5);
            tier.add(tig6);
            tier.add(tig7);
            tier.add(ti3);
            tier.add(tig8);
            tier.add(tig9);
            tier.add(ti11);
            tier.add(ti4);
            tier.add(ti5);
        }

        tier.add(tie1);
        tier.add(tie2);
        tier.add(tie3);
        tier.add(tie4);
        tier.add(tie5);
        tier.add(tie6);
        tier.add(tie7);
    }

}
