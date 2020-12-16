package me.bluenitrox.school.enchants;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import net.minecraft.server.v1_8_R3.ItemArmor;
import net.minecraft.server.v1_8_R3.ItemMapEmpty;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class CraftAPI {

    private static ArrayList<String> armor = new ArrayList<>();
    private static ArrayList<String> sword = new ArrayList<>();
    private static ArrayList<String> pickaxe = new ArrayList<>();
    private static ArrayList<String> bow = new ArrayList<>();
    private static ArrayList<String> rod = new ArrayList<>();

    private static ArrayList<Player> dontgiveItem = new ArrayList<>();

    public static final String guiname = "§8» §5Amboss";


    public static final int slot1 = 19;
    public static final int slot2 = 22;

    public void onClick(final InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        UUID uuid = p.getUniqueId();
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null){
             if(e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.SLIME_BALL || e.getCurrentItem().getType() == Material.BARRIER){
                 e.setCancelled(true);
             }

             if(e.getCurrentItem().getType() == Material.SLIME_BALL){
                 if(e.getClickedInventory().getItem(slot1).getType() == Material.ENCHANTED_BOOK && e.getClickedInventory().getItem(slot2).getType() == Material.ENCHANTED_BOOK){
                     if(craftBooks(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))) {
                         String[] preis = e.getClickedInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                         float price = getPrice(preis[1]);
                         int level = getLevel(preis[1]);
                         if (MoneyManager.getMoney(uuid) >= price && p.getLevel() >= level) {
                             craftBooksTogether(p, e.getClickedInventory().getItem(slot1), getEnchantofItem(e.getClickedInventory().getItem(slot1)), e.getClickedInventory());
                         }else {
                             p.sendMessage(MessageManager.PREFIX + "§7Du hast §cnicht §7genug §6Geld §7oder §6Level§7.");
                             p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                             p.closeInventory();
                         }
                     }else {
                         p.sendMessage(MessageManager.PREFIX + "§7Das ist so nicht möglich. Schaue auf unserer Website §8(§fDemonMC.eu§8) §7wie du es richtig machst!");
                         p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                         p.closeInventory();
                     }
                 }else if(shouldCraftOn(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))){
                     String[] preis = e.getClickedInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                     float price = getPrice(preis[1]);
                     int level = getLevel(preis[1]);
                     if (MoneyManager.getMoney(uuid) >= price && p.getLevel() >= level) {
                         craftbookon(p,e.getClickedInventory().getItem(slot1), getEnchantofItem(e.getClickedInventory().getItem(slot2)),stringToInt(preis[1]), e.getClickedInventory());
                     }else {
                         p.sendMessage(MessageManager.PREFIX + "§7Du hast §cnicht §7genug §6Geld §7oder §6Level§7.");
                         p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                         p.closeInventory();
                     }
                 }else {
                     p.sendMessage(MessageManager.PREFIX + "§7Das ist so nicht möglich. Schaue auf unserer Website §8(§fDemonMC.eu§8) §7wie du es richtig machst!");
                     p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                     p.closeInventory();
                 }
             }
        }
    }

    public static void registerEnchants(){
        armor.add(EnchantManager.Tank);
        armor.add(EnchantManager.Heilzauber);
        armor.add(EnchantManager.Magieschild);
        armor.add(EnchantManager.Stacheln);
        armor.add(EnchantManager.ObsidianSchild);
        armor.add(EnchantManager.Eis);
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
            inv.setItem(i,glasblack);
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
        int levelofbooks = stringToInt(levelofbooksarray[1]);

        ItemStack books = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(enchant + intToString(levelofbooks+1)).build();


        clickedInv.setItem(slot1, new ItemBuilder(Material.AIR).build());
        clickedInv.setItem(slot2, new ItemBuilder(Material.AIR).build());

        MoneyManager.updateMoney(p.getUniqueId(),getPrice(intToString(levelofbooks +1)),true,false);
        p.setLevel(p.getLevel()-(levelofbooks*10));
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

    private boolean shouldCraftOn(ItemStack is1, ItemStack is2){
        if(is2.getType() == Material.ENCHANTED_BOOK) {
            if(isItemForEnchant(is1)) {
                return true;
            }
        }
        return false;
    }

    public static void onClose(final InventoryCloseEvent e){
        if(e.getInventory().getName().equalsIgnoreCase(guiname)){
            if(!dontgiveItem.contains(e.getPlayer())){
                Player p = (Player)e.getPlayer();
                if(e.getInventory().getItem(slot1) != null) {
                    p.getInventory().addItem(e.getInventory().getItem(slot1));
                    e.getInventory().setItem(slot1, new ItemBuilder(Material.AIR).build());
                    TTA_Methods.sendActionBar(p,"§7» §aDeine Items wurden in dein Inventar gelegt.",20*5);
                }
                if(e.getInventory().getItem(slot2) != null) {
                    p.getInventory().addItem(e.getInventory().getItem(slot2));
                    e.getInventory().setItem(slot2, new ItemBuilder(Material.AIR).build());
                    TTA_Methods.sendActionBar(p,"§7» §aDeine Items wurden in dein Inventar gelegt.",20*5);
                }
            }
        }
    }

    private void craftbookon(Player p, ItemStack item, String enchant, int enchantlevel,Inventory clickedInv){
        if(hasItemEnchant(item,enchant)){
            if(isEnchantForItem(item, enchant)) {
                ItemMeta im = item.getItemMeta();
                List<String> liste = im.getLore();
                liste.remove(enchant + intToString(enchantlevel));
                liste.add(enchant + intToString(enchantlevel + 1));
                im.setLore(liste);
                item.setItemMeta(im);
                dontgiveItem.add(p);
                p.getInventory().addItem(item);
                clickedInv.setItem(slot1, new ItemBuilder(Material.AIR).build());
                clickedInv.setItem(slot2, new ItemBuilder(Material.AIR).build());
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L, 1L);
                MoneyManager.updateMoney(p.getUniqueId(),getPrice(intToString(enchantlevel +1)),true,false);
                p.setLevel(p.getLevel()-(enchantlevel*10));
            }else {
                p.closeInventory();
                p.sendMessage(MessageManager.PREFIX + "§7Du kannst dieses Enchant nicht auf dieses Item machen!");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else {
            if(isEnchantForItem(item, enchant)) {
                Bukkit.broadcastMessage("LEL");
                ItemMeta im = item.getItemMeta();
                List<String> liste = im.getLore();
                if(liste != null) {
                    liste.add(enchant + intToString(enchantlevel));
                    im.setLore(liste);
                }else {
                    im.setLore(Arrays.asList(enchant + intToString(enchantlevel)));
                }
                item.setItemMeta(im);
                dontgiveItem.add(p);
                p.getInventory().addItem(item);
                clickedInv.setItem(slot1, new ItemBuilder(Material.AIR).build());
                clickedInv.setItem(slot2, new ItemBuilder(Material.AIR).build());
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L, 1L);
                MoneyManager.updateMoney(p.getUniqueId(),getPrice(intToString(enchantlevel)),true,false);
                p.setLevel(p.getLevel()-(enchantlevel*10));
            }else {
                p.closeInventory();
                p.sendMessage(MessageManager.PREFIX + "§7Du kannst dieses Enchant nicht auf dieses Item machen!");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }
    }

    private boolean isEnchantForItem(ItemStack item, String enchant){
        if(enchant.startsWith("§6§l")){
            if(item.getType() == Material.DIAMOND_PICKAXE ||item.getType() == Material.FISHING_ROD || item.getType() == Material.IRON_PICKAXE ){
                return true;
            }
        }else if(enchant.startsWith("§a§l")){
            if(item.getType() == Material.DIAMOND_HELMET ||item.getType() == Material.DIAMOND_CHESTPLATE ||item.getType() == Material.DIAMOND_LEGGINGS ||item.getType() == Material.DIAMOND_BOOTS ||item.getType() == Material.IRON_HELMET ||item.getType() == Material.IRON_CHESTPLATE ||item.getType() == Material.IRON_LEGGINGS ||item.getType() == Material.IRON_BOOTS || item.getType() == Material.CHAINMAIL_CHESTPLATE ||item.getType() == Material.CHAINMAIL_HELMET ||item.getType() == Material.CHAINMAIL_LEGGINGS ||item.getType() == Material.CHAINMAIL_BOOTS ||item.getType() == Material.LEATHER_CHESTPLATE){
                return true;
            }
        }else if(enchant.startsWith("§9§l")){
            if(item.getType() == Material.BOW){
                return true;
            }
        }else if(enchant.startsWith("§c§l")){
            if(item.getType() == Material.DIAMOND_SWORD ||item.getType() == Material.IRON_SWORD){
                return true;
            }
        }
        return false;
    }

    private boolean isItemForEnchant(ItemStack is){
        if(is.getType() == Material.DIAMOND_HELMET || is.getType() == Material.DIAMOND_CHESTPLATE || is.getType() == Material.DIAMOND_LEGGINGS || is.getType() == Material.DIAMOND_BOOTS || is.getType() == Material.IRON_HELMET ||is.getType() == Material.IRON_CHESTPLATE ||is.getType() == Material.IRON_LEGGINGS ||is.getType() == Material.IRON_BOOTS ||is.getType() == Material.CHAINMAIL_BOOTS ||is.getType() == Material.CHAINMAIL_HELMET ||is.getType() == Material.CHAINMAIL_CHESTPLATE ||is.getType() == Material.CHAINMAIL_LEGGINGS ||is.getType() == Material.CHAINMAIL_HELMET ||is.getType() == Material.DIAMOND_SWORD ||is.getType() == Material.BOW ||is.getType() == Material.IRON_SWORD ||is.getType() == Material.DIAMOND_PICKAXE ||is.getType() == Material.FISHING_ROD ||is.getType() == Material.IRON_PICKAXE){
            return true;
        }
        return false;
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
                for (int i = 0; i <= item.getItemMeta().getLore().size()-1; i++) {
                    if(item.getItemMeta().getLore().get(i)!= null) {
                        if (item.getItemMeta().getLore().get(i).startsWith(enchant)) {
                            line = i;
                        }
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

    public static float getPrice(String s){
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

    public static int getLevel(String s){
        int standard = 10;
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

    private String getEnchantofItem(ItemStack i){
        if(i.getItemMeta() != null){
            if(i.getItemMeta().getLore() != null){
                if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Tank)){
                    return EnchantManager.Tank;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Heilzauber)){
                    return EnchantManager.Heilzauber;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Magieschild)){
                    return EnchantManager.Magieschild;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Widerstand)){
                    return EnchantManager.Widerstand;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Stacheln)){
                    return EnchantManager.Stacheln;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Überladung)){
                    return EnchantManager.Überladung;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.ObsidianSchild)){
                    return EnchantManager.ObsidianSchild;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Eis)){
                    return EnchantManager.Eis;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Fluch)){
                    return EnchantManager.Fluch;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Kopfgeld)){
                    return EnchantManager.Kopfgeld;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Assassine)){
                    return EnchantManager.Assassine;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Vampir)){
                    return EnchantManager.Vampir;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Kobra)){
                    return EnchantManager.Kobra;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Energieentzug)){
                    return EnchantManager.Energieentzug;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.AntiVenom)){
                    return EnchantManager.AntiVenom;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Wilderei)){
                    return EnchantManager.Wilderei;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Jäger)){
                    return EnchantManager.Jäger;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Entdecker)){
                    return EnchantManager.Entdecker;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.schatzmeister)){
                    return EnchantManager.schatzmeister;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Blackout)){
                    return EnchantManager.Blackout;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Dynamite)){
                    return EnchantManager.Dynamite;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Tod)){
                    return EnchantManager.Tod;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Fesseln)){
                    return EnchantManager.Fesseln;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Elektrisiert)){
                    return EnchantManager.Elektrisiert;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Feuerwerk)){
                    return EnchantManager.Feuerwerk;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Rausch)){
                    return EnchantManager.Rausch;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Zorn)){
                    return EnchantManager.Zorn;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Laser)){
                    return EnchantManager.Laser;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Duplizierung)){
                    return EnchantManager.Duplizierung;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Erfahrung)){
                    return EnchantManager.Erfahrung;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Ausgrabung)){
                    return EnchantManager.Ausgrabung;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Großerfang)){
                    return EnchantManager.Großerfang;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Fischerglück)){
                    return EnchantManager.Fischerglück;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Goldhaken)){
                    return EnchantManager.Goldhaken;
                }
            }
        }
        return null;
    }

}
