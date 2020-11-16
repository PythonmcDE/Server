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

    public static ArrayList<ItemStack> casepot = new ArrayList<>();


    void registerLegendär(){
        ItemStack is = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("ifwefhewhfhuiew").build();


        legendär.add(is);
    }

    void registerDaily(){

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


        ItemStack is5 = new ItemBuilder(Material.IRON_HELMET).setDisplayname("§8Diebeskaputze").addEnchant(Enchantment.PROTECTION_PROJECTILE,4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lStacheln I").build();
        ItemStack is6 = new ItemBuilder(Material.IRON_CHESTPLATE).setDisplayname("§8Diebesjacke").addEnchant(Enchantment.PROTECTION_PROJECTILE,4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lStacheln I").build();
        ItemStack is7 = new ItemBuilder(Material.IRON_LEGGINGS).setDisplayname("§8Diebeshose").addEnchant(Enchantment.PROTECTION_PROJECTILE,4, false)
                .addEnchant(Enchantment.DURABILITY, 10, true).setLore("§a§lStacheln I").build();
        ItemStack is8 = new ItemBuilder(Material.IRON_BOOTS).setDisplayname("§8Diebesschuhe").addEnchant(Enchantment.PROTECTION_PROJECTILE,4, false)
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

    }

    void registerEpisch(){

    }


    void registerMysthische(){

        ItemStack rm1 = new ItemBuilder(Material.DIAMOND_HELMET).setDisplayname("§6Helm des Schattendieners").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 7, true)
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
        rm6.setItemMeta(im);

        ItemStack rm7 = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta im3 = rm7.getItemMeta();
        im3.setDisplayName("§6Schlangenleder Hose");
        im3.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        im3.addEnchant(Enchantment.DURABILITY, 10, true);
        im3.spigot().setUnbreakable(true);
        LeatherArmorMeta meta3 = (LeatherArmorMeta)rm7.getItemMeta();
        meta3.setColor(Color.YELLOW);
        im3.setLore(Arrays.asList("§a§lMagieschild V", "§a§lHeilzauber V"));
        rm7.setItemMeta(im);

        /*ItemStack rm8 = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta im = rm5.getItemMeta();
        im.setDisplayName("§6Schlangenleder Mütze");
        im.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 8, true);
        im.addEnchant(Enchantment.DURABILITY, 10, true);
        im.spigot().setUnbreakable(true);
        LeatherArmorMeta meta = (LeatherArmorMeta)rm5.getItemMeta();
        meta.setColor(Color.YELLOW);
        im.setLore(Arrays.asList("§a§lMagieschild V", "§a§lHeilzauber V"));
        rm5.setItemMeta(im);*/

    }

    void registerTier(){

    }

}
