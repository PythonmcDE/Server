package me.bluenitrox.school.cases;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CaseItems {

    public static ArrayList<ItemStack> legendär = new ArrayList<>();
    public static ArrayList<ItemStack> daily = new ArrayList<>();

    public static ItemStack[] casepot;

    public ItemStack[] getCasePot(int cases){
        /*
        0 = Daily
        1 = Gewöhnlich
        2 = Ungewöhnlich
        3 = Selten
        4 = Legendäre
        5 = Mysthische
        6 = Tier
        7 = Magische


         */

        registerDaily();
        registerLegendär();

        return casepot;
    }

    private void registerLegendär(){
        ItemStack is1 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer").build();
        ItemStack is2 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is3 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is4 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is5 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is6 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        ItemStack is7 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6Zertrümmerer LELELELEL").build();
        legendär.add(is1);
        legendär.add(is2);
        legendär.add(is3);
        legendär.add(is4);
        legendär.add(is5);
        legendär.add(is6);
        legendär.add(is7);
    }

    private void registerDaily(){
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

}
