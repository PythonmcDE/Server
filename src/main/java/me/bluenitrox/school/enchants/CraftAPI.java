package me.bluenitrox.school.enchants;

import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CraftAPI {

    public static ArrayList<String> armor = new ArrayList<>();
    public static ArrayList<String> sword = new ArrayList<>();
    public static ArrayList<String> pickaxe = new ArrayList<>();
    public static ArrayList<String> bow = new ArrayList<>();
    public static ArrayList<String> rod = new ArrayList<>();

    public static void registerEnchants(){
        armor.add(EnchantManager.Tank);
        armor.add(EnchantManager.Heilzauber);
        armor.add(EnchantManager.Magieschild);
        armor.add(EnchantManager.Stacheln);
        armor.add(EnchantManager.ObsidianSchild);
        armor.add(EnchantManager.Eis);
        armor.add(EnchantManager.Tank);
        armor.add(EnchantManager.Widerstand);
        armor.add(EnchantManager.Überladung);

        sword.add(EnchantManager.schatzmeister);
        sword.add(EnchantManager.Fluch);
        sword.add(EnchantManager.Kopfgeld);
        sword.add(EnchantManager.Assassine);
        sword.add(EnchantManager.Vampir);
        sword.add(EnchantManager.Kobra);
        sword.add(EnchantManager.Energieentzug);
        sword.add(EnchantManager.AntiVenom);
        sword.add(EnchantManager.Wilderei);
        sword.add(EnchantManager.Jäger);
        sword.add(EnchantManager.Entdecker);

        bow.add(EnchantManager.Blackout);
        bow.add(EnchantManager.Dynamite);
        bow.add(EnchantManager.Tod);
        bow.add(EnchantManager.Strahlen);
        bow.add(EnchantManager.Feuerwerk);

        pickaxe.add(EnchantManager.Rausch);
        pickaxe.add(EnchantManager.Laser);
        pickaxe.add(EnchantManager.Zorn);
        pickaxe.add(EnchantManager.Duplizierung);
        pickaxe.add(EnchantManager.Erfahrung);
        pickaxe.add(EnchantManager.Ausgrabung);

        rod.add(EnchantManager.Großerfang);
        rod.add(EnchantManager.Fischerglück);
        rod.add(EnchantManager.Goldhaken);
    }

    public Inventory openCraftInv(Player p){
        Inventory inv = Bukkit.createInventory(null,9*5, "§8» §5Amboss");

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
        ItemStack notpossible = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cUngültige Kombination").setLore("§8● §7Diese Verzauberung ist leider nicht möglich.").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 9; i<= 18; i++){
            inv.setItem(i,glas);
        }
        inv.setItem(20,glasblack);
        inv.setItem(21,glasblack);
        inv.setItem(23,glasblack);
        inv.setItem(24,glasblack);

        for(int i = 26; i<=35; i++){
            inv.setItem(i,glasblack);
        }
        for(int i = 36; i<= 44; i++){
            inv.setItem(i,glas);
        }

        inv.setItem(25,notpossible);

        return inv;
    }

    private void craftBooksTogether(Player p, ItemStack item, String enchant, Inventory clickedInv){
        String[] levelofbooksarray = item.getItemMeta().getLore().get(0).split(" ");
        int levelofbooks = Integer.parseInt(levelofbooksarray[1]);

        ItemStack books = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(enchant + intToString(levelofbooks+1)).build();


        //TODO BEIDE SLOTS WO ITEMS LIEGEN IM ANVIL
        clickedInv.setItem(13, new ItemBuilder(Material.AIR).build());
        clickedInv.setItem(15, new ItemBuilder(Material.AIR).build());

        MoneyManager.updateMoney(p.getUniqueId(),getPrice(intToString(levelofbooks +1)),true,false);
        p.getInventory().addItem(Antidupe.addID(books));
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);

    }

    private String intToString(int i){
        if(i == 1){
            return "I";
        }else if(i == 2){
            return "II";
        }else if(i == 3){
            return "III";
        }else if(i == 4){
            return "IV";
        }else if(i == 5){
            return "V";
        }else if(i == 6){
            return "VI";
        }else if(i == 7){
            return "VII";
        }else if(i == 8){
            return "VIII";
        }else if(i == 9){
            return "IX";
        }else if(i == 10){
            return "X";
        }else {
            return "I";
        }
    }

    private int stringToInt(String s){
        if(s.equalsIgnoreCase("I")){
            return 1;
        }else if(s.equalsIgnoreCase("II")){
            return 2;
        }else if(s.equalsIgnoreCase("III")){
            return 3;
        }else if(s.equalsIgnoreCase("IV")){
            return 4;
        }else if(s.equalsIgnoreCase("V")){
            return 5;
        }else if(s.equalsIgnoreCase("VI")){
            return 6;
        }else if(s.equalsIgnoreCase("VII")){
            return 7;
        }else if(s.equalsIgnoreCase("VIII")){
            return 8;
        }else if(s.equalsIgnoreCase("IX")){
            return 9;
        }else if(s.equalsIgnoreCase("X")){
            return 10;
        }else {
            return 1;
        }
    }

    private boolean craftBooks(ItemStack book1, ItemStack book2){
        String book1lore = book1.getItemMeta().getLore().get(0);
        String book2lore = book2.getItemMeta().getLore().get(0);

        if(book1lore.equalsIgnoreCase(book2lore)){
            return true;
        }else {
            return false;
        }
    }

    private boolean hasItemEnchant(ItemStack item, String enchant){
        int line = 200;
        if(item.getItemMeta() != null) {
            if (item.getItemMeta().getLore() != null) {
                for (int i = 0; i <= 20; i++) {
                    if(item.getItemMeta().getLore().get(i).startsWith(enchant)){
                        line = i;
                    }
                }
            }
        }
        if(line == 200){
            return false;
        }else {
            return true;
        }
    }

    private float getPrice(String s){
        int standard = 20000;
        if(s.equalsIgnoreCase("I")){
            return standard;
        }else if(s.equalsIgnoreCase("II")){
            return standard*2;
        }else if(s.equalsIgnoreCase("III")){
            return standard*3;
        }else if(s.equalsIgnoreCase("IV")){
            return standard*4;
        }else if(s.equalsIgnoreCase("V")){
            return standard*5;
        }else if(s.equalsIgnoreCase("VI")){
            return standard*6;
        }else if(s.equalsIgnoreCase("VII")){
            return standard*7;
        }else if(s.equalsIgnoreCase("VIII")){
            return standard*8;
        }else if(s.equalsIgnoreCase("IX")){
            return standard*9;
        }else if(s.equalsIgnoreCase("X")){
            return standard*10;
        }else {
            return standard*10;
        }
    }

}
