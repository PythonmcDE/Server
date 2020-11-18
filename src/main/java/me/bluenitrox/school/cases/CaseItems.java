package me.bluenitrox.school.cases;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class CaseItems {

    public static ArrayList<ItemStack> daily = new ArrayList<>();
    public static ArrayList<ItemStack> gewöhnlich = new ArrayList<>();
    public static ArrayList<ItemStack> selten = new ArrayList<>();
    public static ArrayList<ItemStack> episch = new ArrayList<>();
    public static ArrayList<ItemStack> legendär = new ArrayList<>();
    public static ArrayList<ItemStack> mysthische = new ArrayList<>();
    public static ArrayList<ItemStack> tier = new ArrayList<>();


    void registerLegendär(){
        ItemStack is = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Mutantenhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFlink IV").setLore("§a§lHeilzauber IV").build();
        ItemStack is1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Mutantenharnish").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFlink IV").setLore("§a§lHeilzauber IV").build();
        ItemStack is2 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Mutantenbeinschutz").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFlink IV").setLore("§a§lHeilzauber IV").build();
        ItemStack is3 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Mutantenstiefel").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFlink IV").setLore("§a§lHeilzauber IV").build();

        ItemStack is4 = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§6Solarplattenhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 9, true)
                .addEnchant(Enchantment.DURABILITY, 8, true).setLore("§a§lTank IV").setLore("§a§lStacheln IV").build();
        ItemStack is5 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§6Solarplattenbrustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 9, true)
                .addEnchant(Enchantment.DURABILITY, 8, true).setLore("§a§lTank IV").setLore("§a§lStacheln IV").build();
        ItemStack is6 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§6Solarplattenhose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 9, true)
                .addEnchant(Enchantment.DURABILITY, 8, true).setLore("§a§lTank IV").setLore("§a§lStacheln IV").build();
        ItemStack is7 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§6Solarplattenschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 9, true)
                .addEnchant(Enchantment.DURABILITY, 8, true).setLore("§a§lTank IV").setLore("§a§lStacheln IV").build();

        ItemStack is8 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Toxingläve").addEnchant(Enchantment.DAMAGE_ALL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§c§lGiftzahn IV").setLore("§c§lAssassine IV").build();
        ItemStack is9 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§6Schwert des Imperators").addEnchant(Enchantment.DAMAGE_ALL, 6, true)
                .addEnchant(Enchantment.FIRE_ASPECT, 1, false).setLore("§c§lKopfgeld IV").setLore("§c§lHungersnot IV").build();

        ItemStack is10 = new ItemBuilder(Material.BOW).setDisplayname("§6Bogen des Gruftlords").addEnchant(Enchantment.ARROW_DAMAGE, 7, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).addEnchant(Enchantment.ARROW_INFINITE, 1, false).setLore("§9§lElektrisiert IV").setLore("§9§lFeuerwerk IV").build();
        ItemStack is11 = new ItemBuilder(Material.BOW).setDisplayname("§6Piraten Kanone").addEnchant(Enchantment.ARROW_DAMAGE, 6, true)
                .addEnchant(Enchantment.DURABILITY, 5, true).addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false).setLore("§9§lDynamite IV").setLore("§9§lStrahlen IV").build();

        ItemStack is12 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6Bohrmaschine").addEnchant(Enchantment.DIG_SPEED, 8, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lRausch IV").setLore("§6§lDuplizierung IV").build();
        ItemStack is13 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6Schatzgräber").addEnchant(Enchantment.DIG_SPEED, 8, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§lLaser IV").setLore("§6§lAusgrabung IV").build();


        ItemStack is14 = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta ffm2 = is14.getItemMeta();
        ffm2.setDisplayName("§6Schulrucksack");
        ffm2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        ffm2.addEnchant(Enchantment.DURABILITY, 10, true);
        LeatherArmorMeta meta100 = (LeatherArmorMeta)is14.getItemMeta();
        meta100.setColor(Color.RED);
        ffm2.setLore(Arrays.asList("§a§lBackpack VIII"));
        is14.setItemMeta(ffm2);

        legendär.add(is);
        legendär.add(is1);
        legendär.add(is2);
        legendär.add(is3);
        legendär.add(is4);
        legendär.add(is5);
        legendär.add(is6);
        legendär.add(is7);
        legendär.add(is8);
        legendär.add(is9);
        legendär.add(is10);
        legendär.add(is11);
        legendär.add(is12);
        legendär.add(is13);
        legendär.add(is14);
    }

    void registerDaily(){

        //Gewöhnliche Items

        ItemStack rd = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§8Helm des Halekin").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lKonfetti I").build();
        ItemStack rd1 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§8Brustplatte des Halekin").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lKonfetti I").build();
        ItemStack rd2 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§8Hose des Halekin").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lKonfetti I").build();
        ItemStack rd3 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§8Schuhe des Halekin").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lKonfetti I").build();

        ItemStack rd4 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§8Taschenmesser").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§c§lKopfgeld I").build();

        ItemStack rd5 = new ItemBuilder(Material.BOW).setDisplayname("§8Pfeilgeschoss").addEnchant(Enchantment.ARROW_DAMAGE, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§9§lFesseln I").build();

        ItemStack rd6 = new ItemBuilder(Material.GOLD_PICKAXE).setDisplayname("§8Kupfer Spitzhacke").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§c§lRausch I").build();

        ItemStack rd7 = new ItemBuilder(Material.ARROW).setDisplayname("§7Pfeile").setAmount(16).build();
        ItemStack rd8 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldene Äpfel").setAmount(16).build();
        ItemStack rd9 = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperlen").setAmount(16).build();

        ItemStack rd10 = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisenblöcke").setAmount(32).build();
        ItemStack rd11 = new ItemBuilder(Material.GOLD_BLOCK).setAmount(32).setDisplayname("§7Goldblöcke").build();

        //Seltene Items

        ItemStack rd12 = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§9Helm des Kommandanten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§a§lStacheln II").build();
        ItemStack rd13 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§9Brustplatte des Kommandanten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§a§lStacheln II").build();
        ItemStack rd14 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§9Hose des Kommandanten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§a§lStacheln II").build();
        ItemStack rd15 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§9Schuhe des Kommandanten").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§a§lStacheln II").build();

        ItemStack rd16 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§9Giftiger Skorpion Dolch").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§c§lGiftzahn II").build();

        ItemStack rd17 = new ItemBuilder(Material.BOW).setDisplayname("§9Metzler Armbrust").addEnchant(Enchantment.ARROW_DAMAGE, 5, false)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§9§lDynamite II").build();

        ItemStack rd18 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§9Erzpulverisator").addEnchant(Enchantment.DIG_SPEED, 5, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§c§lZorn I").build();

        ItemStack rd19 = new ItemBuilder(Material.ARROW).setDisplayname("§7Pfeile").setAmount(32).build();
        ItemStack rd20 = new ItemBuilder(Material.GOLDEN_APPLE).setDisplayname("§7Goldene Äpfel").setAmount(32).build();
        ItemStack rd21 = new ItemBuilder(Material.ENDER_PEARL).setDisplayname("§7Enderperlen").setAmount(16).build();

        ItemStack rd22 = new ItemBuilder(Material.IRON_BLOCK).setDisplayname("§7Eisenblöcke").setAmount(64).build();
        ItemStack rd23 = new ItemBuilder(Material.GOLD_BLOCK).setDisplayname("§7Goldblöcke").setAmount(64).build();
        ItemStack rd24 = new ItemBuilder(Material.DIAMOND_BLOCK).setDisplayname("§7Diamantblöcke").setAmount(32).build();

        // Epische Items

        ItemStack rd25 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§5Barbarenhelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lDompteur III").setLore("§a§lGlückspilz III").build();
        ItemStack rd26 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Barbarenbrustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lDompteur III").setLore("§a§lGlückspilz III").build();
        ItemStack rd27 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§5Barbarenhose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lDompteur III").setLore("§a§lGlückspilz III").build();
        ItemStack rd28 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Barbarenschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lDompteur III").setLore("§a§lGlückspilz III").build();



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



    }

    void registerGewöhnlich(){

        ItemStack is1 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§8Bronzehelm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank I").build();
        ItemStack is2 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§8Bronzeharnish").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank I").build();
        ItemStack is3 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§8Bronzebeinschutz").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank I").build();
        ItemStack is4 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§8Bronzeschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lTank I").build();


        ItemStack is5 = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§8Diebeskaputze").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lStacheln I").build();
        ItemStack is6 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§8Diebesjacke").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lStacheln I").build();
        ItemStack is7 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§8Diebeshose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lStacheln I").build();
        ItemStack is8 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§8Diebesschuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL,4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lStacheln I").build();

        ItemStack is9 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§8Vollstrecker").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§c§lErbittert I").build();
        ItemStack is10 = new ItemBuilder(Material.STONE_SWORD).setDisplayname("§8Hirschfänger").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).addEnchant(Enchantment.LOOT_BONUS_MOBS, 2, false).build();

        ItemStack is11 = new ItemBuilder(Material.BOW).setDisplayname("§8Rabaukenbogen").addEnchant(Enchantment.ARROW_DAMAGE, 3, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false).setLore("§9§lDynamite I").build();
        ItemStack is12 = new ItemBuilder(Material.BOW).setDisplayname("§8Elfenbogen").addEnchant(Enchantment.ARROW_DAMAGE, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§9§lTod I").build();

        ItemStack is13 = new ItemBuilder(Material.STONE_PICKAXE).setDisplayname("§8Felsenbrecher").addEnchant(Enchantment.DIG_SPEED, 6, true)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§6§lLaser I").build();
        ItemStack is14 = new ItemBuilder(Material.STONE_PICKAXE).setDisplayname("§8Erntesichel").addEnchant(Enchantment.DIG_SPEED, 5, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lRausch I").build();

        ItemStack is15 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§8Gefederte Schuhe").addEnchant(Enchantment.PROTECTION_FALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§a§lEis I").build();


        gewöhnlich.add(is1);
        gewöhnlich.add(is2);
        gewöhnlich.add(is3);
        gewöhnlich.add(is4);
        gewöhnlich.add(is5);
        gewöhnlich.add(is6);
        gewöhnlich.add(is7);
        gewöhnlich.add(is8);
        gewöhnlich.add(is9);
        gewöhnlich.add(is10);
        gewöhnlich.add(is11);
        gewöhnlich.add(is12);
        gewöhnlich.add(is13);
        gewöhnlich.add(is14);
        gewöhnlich.add(is15);




    }

    void registerSelten(){

        ItemStack rs = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§9Kaputze des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFeuerwehr II").setLore("§a§lMagieschütze II").build();
        ItemStack rs1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§9Mantel des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFeuerwehr II").setLore("§a§lMagieschütze II").build();
        ItemStack rs2 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§9Hose des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFeuerwehr II").setLore("§a§lMagieschütze II").build();
        ItemStack rs3 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9Schuhe des Druiden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFeuerwehr II").setLore("§a§lMagieschütze II").build();

        ItemStack rs4 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§9Schmieders Kappe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank II").setLore("§a§lHeilzauber II").build();
        ItemStack rs5 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§9Schmieders Harnish").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank II").setLore("§a§lHeilzauber II").build();
        ItemStack rs6 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§9Schmieders Beinschutz").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank II").setLore("§a§lHeilzauber II").build();
        ItemStack rs7 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9Schmieders Stiefel").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lTank II").setLore("§a§lHeilzauber II").build();

        ItemStack rs8 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§9Scharfer Säbel").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§c§lGiftzahn II").setLore("§c§lErbittert II").build();
        ItemStack rs9 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§9Messer der Ewigkeit").addEnchant(Enchantment.DAMAGE_ALL, 3, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§c§lHungersnot II").setLore("§c§lKopfgeld II").build();

        ItemStack rs10 = new ItemBuilder(Material.BOW).setDisplayname("§9Falkenbogen").addEnchant(Enchantment.ARROW_DAMAGE, 4, false)
                .addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false).setLore("§9§lFesseln II").setLore("§9§lElektrisiert II").build();
        ItemStack rs11 = new ItemBuilder(Material.BOW).setDisplayname("§9Banditenbogen").addEnchant(Enchantment.ARROW_DAMAGE, 5, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§9§lTod II").setLore("§9§lStrahlen II").build();

        ItemStack rs12 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§9Seelensense").addEnchant(Enchantment.DIG_SPEED, 7, true)
                .addEnchant(Enchantment.DURABILITY, 7, true).setLore("§6§lErfahrung II").setLore("§6§lAusgrabung II").build();
        ItemStack rs13 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§9Stahlhammer").addEnchant(Enchantment.DIG_SPEED, 6, true)
                .addEnchant(Enchantment.DURABILITY, 6, true).setLore("§6§lLaser II").setLore("§6§lDuplizierung II").build();

        ItemStack rs14 = new ItemBuilder(Material.GOLD_SWORD).setDisplayname("§9Schwert des Feuerteufels").addEnchant(Enchantment.DAMAGE_ALL, 4, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).addEnchant(Enchantment.FIRE_ASPECT, 1, false).setLore("§c§lAssassine II").build();

        ItemStack rs15 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§9Schuhe des Reisenden").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false)
                .addEnchant(Enchantment.DURABILITY, 5, true).setLore("§a§lFlink IV").build();


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
    }

    void registerEpisch(){

        ItemStack re = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§5Wikinger Helm").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lTank III").setLore("§a§lKonfetti III").build();
        ItemStack re1 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Wikinger Brustplatte").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lTank III").setLore("§a§lKonfetti III").build();
        ItemStack re2 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§5Wikinger Hose").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lTank III").setLore("§a§lKonfetti III").build();
        ItemStack re3 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§5Wikinger Schuhe").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lTank III").setLore("§a§lKonfetti III").build();

        ItemStack re4 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§5Helm des Abgrundes").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz III").setLore("§a§lBackpack III").build();
        ItemStack re5 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§5Harnish des Abgrundes").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz III").setLore("§a§lBackpack III").build();
        ItemStack re6 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§5Beinschienen des Abgrundes").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz III").setLore("§a§lBackpack III").build();
        ItemStack re7 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§5Schuhe des Abgrundes").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz III").setLore("§a§lBackpack III").build();

        ItemStack re8 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§5Schwert des Kammerjägers").addEnchant(Enchantment.DAMAGE_ALL, 5, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§c§lJäger III").setLore("§c§lEntdecker III").build();
        ItemStack re9 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§5Albtraumbiss").addEnchant(Enchantment.DAMAGE_ALL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).addEnchant(Enchantment.LOOT_BONUS_MOBS, 1, false).setLore("§c§lGiftzahn III").build();

        ItemStack re10 = new ItemBuilder(Material.BOW).setDisplayname("§5Dschinnbogen").addEnchant(Enchantment.ARROW_DAMAGE, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).addEnchant(Enchantment.ARROW_INFINITE, 1, false).setLore("§9§lFesseln III").setLore("§9§lDynamite III").build();
        ItemStack re11 = new ItemBuilder(Material.BOW).setDisplayname("§5Kanone des Schurken").addEnchant(Enchantment.ARROW_DAMAGE, 5, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false).setLore("§9§lTod III").setLore("§9§lBlackout III").build();

        ItemStack re12 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§5Bankräuber Spitzhacke").addEnchant(Enchantment.DIG_SPEED, 7, true)
                .addEnchant(Enchantment.DURABILITY, 3, false).setLore("§6§lLaser III").setLore("§6§lErfahrung III").build();
        ItemStack re13 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§5Tresoraufbrecher").addEnchant(Enchantment.DIG_SPEED, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, false).setLore("§6§lZorn III").setLore("§6§lRausch III").build();

        ItemStack re14 = new ItemBuilder(Material.STICK).setDisplayname("§5Zauberstab").addEnchant(Enchantment.DAMAGE_ALL, 5, false)
                .addEnchant(Enchantment.KNOCKBACK, 2, false).setLore("§c§lAssassine III").setLore("§c§lGiftzahn III").build();
        ItemStack re15 = new ItemBuilder(Material.IRON_AXE).setDisplayname("§5Berserkeraxt").addEnchant(Enchantment.DIG_SPEED, 4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lGärtner III").setLore("§6§lBaumpflege III").build();



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
    }


    void registerMysthische(){

        ItemStack rm = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Helm des Schattendieners").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz V").setLore("§a§lKonfetti V").build();
        ItemStack rm2 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setDisplayname("§6Brustplatte des Schattendieners").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz V").setLore("§a§lKonfetti V").build();
        ItemStack rm3 = new ItemBuilder(Material.DIAMOND_LEGGINGS).setDisplayname("§6Hose des Schattendieners").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz V").setLore("§a§lKonfetti V").build();
        ItemStack rm4 = new ItemBuilder(Material.DIAMOND_BOOTS).setDisplayname("§6Schuhe des Schattendieners").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lGlückspilz V").setLore("§a§lKonfetti V").build();

        ItemStack rm5 = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta im = rm5.getItemMeta();
        im.setDisplayName("§6Schlangenleder Mütze");
        im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        im.addEnchant(Enchantment.DURABILITY, 10, true);
        im.spigot().setUnbreakable(true);
        LeatherArmorMeta meta = (LeatherArmorMeta)rm5.getItemMeta();
        meta.setColor(Color.YELLOW);
        im.setLore(Arrays.asList("§a§lMagieschild V", "§a§lHeilzauber V"));
        rm5.setItemMeta(im);

        ItemStack rm6 = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta im2 = rm6.getItemMeta();
        im2.setDisplayName("§6Schlangenleder Jacke");
        im2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        im2.addEnchant(Enchantment.DURABILITY, 10, true);
        im2.spigot().setUnbreakable(true);
        LeatherArmorMeta meta2 = (LeatherArmorMeta)rm6.getItemMeta();
        meta2.setColor(Color.YELLOW);
        im2.setLore(Arrays.asList("§a§lMagieschild V", "§a§lHeilzauber V"));
        rm6.setItemMeta(im2);

        ItemStack rm7 = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta im3 = rm7.getItemMeta();
        im3.setDisplayName("§6Schlangenleder Hose");
        im3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        im3.addEnchant(Enchantment.DURABILITY, 10, true);
        im3.spigot().setUnbreakable(true);
        LeatherArmorMeta meta3 = (LeatherArmorMeta)rm7.getItemMeta();
        meta3.setColor(Color.YELLOW);
        im3.setLore(Arrays.asList("§a§lMagieschild V", "§a§lHeilzauber V"));
        rm7.setItemMeta(im3);

        ItemStack rm8 = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta im4 = rm8.getItemMeta();
        im4.setDisplayName("§6Schlangenleder Schuhe");
        im4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        im4.addEnchant(Enchantment.DURABILITY, 10, true);
        im4.spigot().setUnbreakable(true);
        LeatherArmorMeta meta4 = (LeatherArmorMeta)rm8.getItemMeta();
        meta4.setColor(Color.YELLOW);
        im4.setLore(Arrays.asList("§a§lMagieschild V", "§a§lHeilzauber V"));
        rm8.setItemMeta(im4);


        ItemStack rm9 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Finsternes Katana").addEnchant(Enchantment.DAMAGE_ALL, 6, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§c§lVampir V").setLore("§c§lErbittert V").build();
        ItemStack rm10 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§6Dolch einer außerirdischen Spezies").addEnchant(Enchantment.DAMAGE_ALL, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§c§lVampir V").setLore("§c§lEntdecker V").build();

        ItemStack rm11 = new ItemBuilder(Material.BOW).setDisplayname("§6Bogen des Grabunhold").addEnchant(Enchantment.ARROW_DAMAGE, 8, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§9§lFesseln V").setLore("§9§lStrahlen V").build();
        ItemStack rm12 = new ItemBuilder(Material.BOW).setDisplayname("§6Bogen des weisen Kriegers").addEnchant(Enchantment.ARROW_DAMAGE, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).addEnchant(Enchantment.ARROW_KNOCKBACK, 1, false).setLore("§9§lElektrisiert V").setLore("§9§lFeuerwerk V").build();

        ItemStack rm13 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6Spitzhacke des erzürnten Miners").addEnchant(Enchantment.DIG_SPEED, 9, true)
                .addEnchant(Enchantment.DURABILITY, 2, false).setLore("§6§lErfahrung V").setLore("§6§lAusgrabung V").build();
        ItemStack rm14 = new ItemBuilder(Material.IRON_PICKAXE).setDisplayname("§6Höhlenforscher Spitzhacke").addEnchant(Enchantment.DIG_SPEED, 10, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lDuplizierung V").setLore("§6§lAusgrabung V").build();
        ItemStack rm15 = new ItemBuilder(Material.DIAMOND_AXE).setDisplayname("§6Mondstein Axt").addEnchant(Enchantment.DIG_SPEED, 7, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§6§lWindböe V").setLore("§6§lHolzfäller V").build();
        ItemStack rm16 = new ItemBuilder(Material.GOLD_AXE).setDisplayname("§6Köpfer der tropischen Anakonda").addEnchant(Enchantment.DAMAGE_ALL, 8, true)
                .addEnchant(Enchantment.DURABILITY, 10, true)./*setUnbreakable(true).*/setLore("§6§lKopfgeld VII").build();


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


    }

    void registerTier(){

    }

}
