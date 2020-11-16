package me.bluenitrox.school.cases;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class CaseItems {

    public static ArrayList<ItemStack> daily = new ArrayList<>();
    public static ArrayList<ItemStack> gewöhnlich = new ArrayList<>();
    public static ArrayList<ItemStack> ungewöhnlich = new ArrayList<>();
    public static ArrayList<ItemStack> selten = new ArrayList<>();
    public static ArrayList<ItemStack> legendär = new ArrayList<>();
    public static ArrayList<ItemStack> mysthische = new ArrayList<>();
    public static ArrayList<ItemStack> tier = new ArrayList<>();
    public static ArrayList<ItemStack> magische = new ArrayList<>();

    public static ArrayList<ItemStack> casepot = new ArrayList<>();


    void registerLegendär(){
        ItemStack is1 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer").build();
        ItemStack is2 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL1").build();
        ItemStack is3 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL2").build();
        ItemStack is4 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL3").build();
        ItemStack is5 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL4").build();
        ItemStack is6 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL5").build();
        ItemStack is7 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL6").build();
        legendär.add(is1);
        legendär.add(is2);
        legendär.add(is3);
        legendär.add(is4);
        legendär.add(is5);
        legendär.add(is6);
        legendär.add(is7);
    }

    void registerDaily(){
        ItemStack is1 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6Zertrümmerer").build();
        ItemStack is2 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is3 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is4 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is5 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is6 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is7 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        daily.add(is1);
        daily.add(is2);
        daily.add(is3);
        daily.add(is4);
        daily.add(is5);
        daily.add(is6);
        daily.add(is7);
    }

    void registerGewöhnlich(){

    }

    void registerUngewöhnlich(){

    }

    void registerSelten(){

    }

    void registerMagisch(){

    }

    void registerMysthische(){

    }

    void registerTier(){

    }

}
