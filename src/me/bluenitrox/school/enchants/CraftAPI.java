package me.bluenitrox.school.enchants;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class CraftAPI {

    private static LinkedList<String> armor = new LinkedList<>();
    private static LinkedList<String> sword = new LinkedList<>();
    private static LinkedList<String> pickaxe = new LinkedList<>();
    private static LinkedList<String> bow = new LinkedList<>();
    private static LinkedList<String> rod = new LinkedList<>();

    private static LinkedList<Player> dontgiveItem = new LinkedList<>();

    public static final String guiname = "§8» §5Amboss";


    public static final int slot1 = 19;
    public static final int slot2 = 22;

    public void onClick(final InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        UUID uuid = p.getUniqueId();
        if (e.getClickedInventory().getName() != null) {
            if (e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null) {
                if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE || e.getCurrentItem().getType() == Material.SLIME_BALL || e.getCurrentItem().getType() == Material.BARRIER) {
                    e.setCancelled(true);
                }

                if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
                    if (e.getClickedInventory().getItem(slot1).getType() == Material.ENCHANTED_BOOK && e.getClickedInventory().getItem(slot2).getType() == Material.ENCHANTED_BOOK) {
                        if(e.getClickedInventory().getItem(slot1).getItemMeta() != null && e.getClickedInventory().getItem(slot2).getItemMeta() != null ) {
                            if (e.getClickedInventory().getItem(slot1).getItemMeta().getDisplayName() != null && e.getClickedInventory().getItem(slot2).getItemMeta().getDisplayName() != null) {
                                if(e.getClickedInventory().getItem(slot1).getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch") && e.getClickedInventory().getItem(slot2).getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch")) {
                                    if (craftBooks(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))) {
                                        String[] preis = e.getClickedInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                                        float price = getPrice(preis[1]);
                                        int level = getLevel(preis[1]);
                                        if (MoneyManager.getMoney(uuid) >= price && p.getLevel() >= level) {
                                            if(checkTracker(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))) {
                                                craftBooksTogether(p, e.getClickedInventory().getItem(slot1), getEnchantofItem(e.getClickedInventory().getItem(slot1)), e.getClickedInventory());
                                            } else {
                                                p.sendMessage(MessageManager.PREFIX + "§7Du kannst keine Counter Bücher zusammencraften.");
                                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                                p.closeInventory();
                                            }
                                        } else {
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast §cnicht §7genug §6Geld §7oder §6Level§7.");
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                            p.closeInventory();
                                        }
                                    } else {
                                        p.sendMessage(MessageManager.PREFIX + "§7Das ist so §cnicht §7möglich. Schaue auf unserer Website §8(§fPythonMC.de§8) §7wie du es richtig machst!");
                                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                        p.closeInventory();
                                    }
                                }else {
                                    if(e.getClickedInventory().getItem(slot1).getItemMeta().getDisplayName().equalsIgnoreCase("§5Verzaubertes Buch") && e.getClickedInventory().getItem(slot2).getItemMeta().getDisplayName().equalsIgnoreCase("§5Verzaubertes Buch")){
                                        if(craftVanillaBooks(e.getClickedInventory().getItem(slot1))) {
                                            String[] preis = e.getClickedInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                                            float price = getPrice(preis[1]);
                                            int level = getLevel(preis[1]);
                                            if (MoneyManager.getMoney(uuid) >= price && p.getLevel() >= level) {
                                                craftVanillaBooksTogether(p, e.getClickedInventory().getItem(slot1), getVanillaEnchantofItem(e.getClickedInventory().getItem(slot1)), e.getClickedInventory());
                                            } else {
                                                p.sendMessage(MessageManager.PREFIX + "§7Du hast §cnicht §7genug §6Geld §7oder §6Level§7.");
                                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                                p.closeInventory();
                                            }
                                        }else {
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast das §chöchste Level §7dieser Verzauberung erreicht.");
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                            p.closeInventory();
                                        }
                                    }
                                }
                            }
                        }
                    }
                    else if (shouldCraftOn(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))) {
                        String[] preis = e.getClickedInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                        float price = getPrice(preis[1]);
                        int level = getLevel(preis[1]);
                        if (MoneyManager.getMoney(uuid) >= price && p.getLevel() >= level) {
                            if(checkTrackerForItem(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))) {
                                craftbookon(p, e.getClickedInventory().getItem(slot1), getEnchantofItem(e.getClickedInventory().getItem(slot2)), stringToInt(preis[1]), e.getClickedInventory());
                            } else {
                                p.sendMessage(MessageManager.PREFIX + "§7Dein Item besitzt bereits Counter.");
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                            }
                        } else {
                            p.sendMessage(MessageManager.PREFIX + "§7Du hast §cnicht §7genug §6Geld §7oder §6Level§7.");
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            p.closeInventory();
                        }
                    }
                    else if(isSpecial(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))) {
                        String[] preis = e.getClickedInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                        float price = getPrice(preis[1]);
                        int level = getLevel(preis[1]);
                        if (MoneyManager.getMoney(uuid) >= price && p.getLevel() >= level) {
                            if(checkTrackerForItem(e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2))) {
                                craftSpecialOn(p, e.getClickedInventory().getItem(slot1), e.getClickedInventory().getItem(slot2), stringToInt(preis[1]), e.getClickedInventory());
                            } else {
                                p.sendMessage(MessageManager.PREFIX + "§7Dein Item besitzt bereits Counter.");
                                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                p.closeInventory();
                            }
                        } else {
                            p.sendMessage(MessageManager.PREFIX + "§7Du hast §cnicht §7genug §6Geld §7oder §6Level§7.");
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            p.closeInventory();
                        }
                    }
                    else {
                        p.sendMessage(MessageManager.PREFIX + "§7Das ist so nicht möglich. Schaue auf unserer Website §8(§fPythonMC.de§8) §7wie du es richtig machst!");
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                    }
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
        sword.add(EnchantManager.KILL_COUNTER);
        sword.add(EnchantManager.Mob_Counter);

        bow.add(EnchantManager.Blackout);
        bow.add(EnchantManager.Dynamite);
        bow.add(EnchantManager.Tod);
        bow.add(EnchantManager.Strahlen);
        bow.add(EnchantManager.Feuerwerk);
        bow.add(EnchantManager.Käfig);
        bow.add(EnchantManager.BowCounter);

        pickaxe.add(EnchantManager.Rausch);
        pickaxe.add(EnchantManager.Laser);
        pickaxe.add(EnchantManager.Zorn);
        pickaxe.add(EnchantManager.Duplizierung);
        pickaxe.add(EnchantManager.Erfahrung);
        pickaxe.add(EnchantManager.Ausgrabung);
        pickaxe.add(EnchantManager.BlockCounter);

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
        p.setLevel(p.getLevel()-(levelofbooks*20));
        p.getInventory().addItem(Antidupe.addID(books));
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L, 1L);

    }

    private void craftVanillaBooksTogether(Player p, ItemStack item, String enchant, Inventory clickedInv){
        String[] levelofbooksarray = item.getItemMeta().getLore().get(0).split(" ");
        int levelofbooks = stringToInt(levelofbooksarray[1]);

        ItemStack books = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§5Verzaubertes Buch").setLore(enchant + intToString(levelofbooks+1)).build();


        clickedInv.setItem(slot1, new ItemBuilder(Material.AIR).build());
        clickedInv.setItem(slot2, new ItemBuilder(Material.AIR).build());

        MoneyManager.updateMoney(p.getUniqueId(),getPrice(intToString(levelofbooks +1)),true,false);
        p.setLevel(p.getLevel()-(levelofbooks*20));
        p.getInventory().addItem(Antidupe.addID(books));
        p.closeInventory();
        p.playSound(p.getLocation(), Sound.ANVIL_USE, 1L, 1L);
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

    private boolean checkTracker(ItemStack is1, ItemStack is2) {

        if(is2.getType() == Material.ENCHANTED_BOOK && is1.getType() == Material.ENCHANTED_BOOK) {
            if(is2.getItemMeta() == null) return false;
            if(is2.getItemMeta().getLore() == null) return false;
            ItemMeta itemMeta1 = is1.getItemMeta();
            ItemMeta itemMeta2 = is2.getItemMeta();

            List<String> lore1 = itemMeta1.getLore();
            List<String> lore2 = itemMeta2.getLore();

            if(lore1.contains(EnchantManager.KILL_COUNTER + "I") && lore2.contains(EnchantManager.KILL_COUNTER + "I")) return false;
            if(lore1.contains(EnchantManager.Mob_Counter + "I") && lore2.contains(EnchantManager.Mob_Counter + "I")) return false;
            if(lore1.contains(EnchantManager.BowCounter + "I") && lore2.contains(EnchantManager.BowCounter + "I")) return false;
            if(lore1.contains(EnchantManager.BlockCounter + "I") && lore2.contains(EnchantManager.BlockCounter + "I")) return false;

        }
        return true;
    }

    private boolean checkTrackerForItem(ItemStack is1, ItemStack is2) {

        if(is2.getType() == Material.ENCHANTED_BOOK) {
            if(is1.getItemMeta() == null) return true;
            if(is1.getItemMeta().getLore() == null) return true;
            ItemMeta itemMeta1 = is1.getItemMeta();
            ItemMeta itemMeta2 = is2.getItemMeta();

            List<String> lore1 = itemMeta1.getLore();
            List<String> lore2 = itemMeta2.getLore();

            if(lore1.contains(EnchantManager.KILL_COUNTER + "I") && lore2.contains(EnchantManager.KILL_COUNTER + "I")){
                return false;
            }
            if(lore1.contains(EnchantManager.Mob_Counter + "I") && lore2.contains(EnchantManager.Mob_Counter + "I")) {
                return false;
            }
            if(lore1.contains(EnchantManager.BowCounter + "I") && lore2.contains(EnchantManager.BowCounter + "I")) {
                return false;
            }
            if(lore1.contains(EnchantManager.BlockCounter + "I") && lore2.contains(EnchantManager.BlockCounter + "I")) {
                return false;
            }

        }
        return true;
    }

    private boolean shouldCraftOn(ItemStack is1, ItemStack is2){

        if(is2.getType() == Material.ENCHANTED_BOOK) {
            if(isItemForEnchant(is1)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSpecial(ItemStack is1, ItemStack is2){

        if(is2.getType() == Material.PRISMARINE_CRYSTALS || is2.getType() == Material.NETHER_STAR) {
            if(is2.getItemMeta() != null) {
                if(is2.getItemMeta().getDisplayName() != null) {
                    if(is2.getItemMeta().getDisplayName().contains("Item-Verhärtung") || is2.getItemMeta().getDisplayName().contains("Item-Erhalt")) {
                        return isItemForEnchant(is1);
                    }
                }
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
            }else {
                dontgiveItem.remove(e.getPlayer());
            }
        }
    }

    private void craftSpecialOn(Player player, ItemStack item, ItemStack special, int enchantlevel, Inventory clicked) {
        if(hasSpezial(item, special.getItemMeta().getDisplayName())) {
            if (item.getItemMeta().getLore().contains(special + intToString(enchantlevel))) {
                if (isEnchantForItem(item, special.getItemMeta().getDisplayName())) {
                    ItemMeta meta = item.getItemMeta();
                    List<String> lore = meta.getLore();

                    lore.remove(special.getItemMeta().getDisplayName() + intToString(enchantlevel));
                    lore.add(special.getItemMeta().getDisplayName() + intToString(enchantlevel + 1));

                    meta.setLore(lore);
                    item.setItemMeta(meta);

                    dontgiveItem.add(player);
                    player.getInventory().addItem(item);

                    clicked.setItem(slot1, new ItemBuilder(Material.AIR).build());
                    clicked.setItem(slot2, new ItemBuilder(Material.AIR).build());
                    player.closeInventory();
                    player.playSound(player.getLocation(), Sound.ANVIL_USE, 1L, 1L);
                    MoneyManager.updateMoney(player.getUniqueId(), getPrice(intToString(enchantlevel + 1)), true, false);
                    player.setLevel(player.getLevel() - (enchantlevel * 20));
                }
            } else {
                player.closeInventory();
                player.sendMessage(MessageManager.PREFIX + "§7Du musst die selbe Stufe des Enchants draufmachen!");
                player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }


    }

    private void craftbookon(Player p, ItemStack item, String enchant, int enchantlevel,Inventory clickedInv){
        if(hasItemEnchant(item,enchant)){
            if(item.getItemMeta().getLore().contains(enchant + intToString(enchantlevel))) {
                if (isEnchantForItem(item, enchant)) {
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
                    MoneyManager.updateMoney(p.getUniqueId(), getPrice(intToString(enchantlevel + 1)), true, false);
                    p.setLevel(p.getLevel() - (enchantlevel * 20));
                } else {
                    p.closeInventory();
                    p.sendMessage(MessageManager.PREFIX + "§7Du kannst dieses Enchant §cnicht §7auf dieses Item machen!");
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                }
            }else {
                p.closeInventory();
                p.sendMessage(MessageManager.PREFIX + "§7Du kannst dieses Enchant §cnicht §7auf dieses Item machen!");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }else {
            if(isEnchantForItem(item, enchant)) {
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
                p.setLevel(p.getLevel()-(enchantlevel*20));
            }else {
                p.closeInventory();
                p.sendMessage(MessageManager.PREFIX + "§7Du kannst dieses Enchant §cnicht §7auf dieses Item machen!");
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            }
        }
    }

    public static boolean isEnchantForItem(ItemStack item, String enchant){
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
        }else if(enchant.startsWith("§f§l")){
            if(item.getType() == Material.DIAMOND_PICKAXE ||item.getType() == Material.FISHING_ROD || item.getType() == Material.IRON_PICKAXE||item.getType() == Material.BOW || item.getType() == Material.DIAMOND_SWORD ||item.getType() == Material.IRON_SWORD ||item.getType() == Material.DIAMOND_HELMET ||item.getType() == Material.DIAMOND_CHESTPLATE ||item.getType() == Material.DIAMOND_LEGGINGS ||item.getType() == Material.DIAMOND_BOOTS ||item.getType() == Material.IRON_HELMET ||item.getType() == Material.IRON_CHESTPLATE ||item.getType() == Material.IRON_LEGGINGS ||item.getType() == Material.IRON_BOOTS || item.getType() == Material.CHAINMAIL_CHESTPLATE ||item.getType() == Material.CHAINMAIL_HELMET ||item.getType() == Material.CHAINMAIL_LEGGINGS ||item.getType() == Material.CHAINMAIL_BOOTS ||item.getType() == Material.LEATHER_CHESTPLATE){
                return true;
            }
        }
        return false;
    }

    public static boolean isItemForEnchant(ItemStack is){
        if(is.getType() == Material.DIAMOND_HELMET
                ||is.getType() == Material.DIAMOND_CHESTPLATE
                ||is.getType() == Material.DIAMOND_LEGGINGS
                ||is.getType() == Material.DIAMOND_BOOTS
                ||is.getType() == Material.IRON_HELMET
                ||is.getType() == Material.IRON_CHESTPLATE
                ||is.getType() == Material.IRON_LEGGINGS
                ||is.getType() == Material.IRON_BOOTS
                ||is.getType() == Material.CHAINMAIL_BOOTS
                ||is.getType() == Material.CHAINMAIL_HELMET
                ||is.getType() == Material.CHAINMAIL_CHESTPLATE
                ||is.getType() == Material.CHAINMAIL_LEGGINGS
                ||is.getType() == Material.CHAINMAIL_HELMET
                ||is.getType() == Material.DIAMOND_SWORD
                ||is.getType() == Material.BOW
                ||is.getType() == Material.IRON_SWORD
                ||is.getType() == Material.STONE_SWORD
                ||is.getType() == Material.WOOD_SWORD
                ||is.getType() == Material.DIAMOND_PICKAXE
                ||is.getType() == Material.STONE_PICKAXE
                ||is.getType() == Material.WOOD_PICKAXE
                ||is.getType() == Material.FISHING_ROD
                ||is.getType() == Material.IRON_PICKAXE){
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
    private boolean craftVanillaBooks(ItemStack i){
        String[] leveltomatestring = i.getItemMeta().getLore().get(0).split(" ");
        int maxlevel = 0;
        int leveltomate = stringToInt(leveltomatestring[1])+1;
        if(i.getItemMeta() != null){
            if(i.getItemMeta().getLore() != null){
                if(i.getItemMeta().getLore().get(0).startsWith("§7Verbrennung")){
                    maxlevel = 2;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Schärfe")){
                    maxlevel = 5;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Stärke")){
                    maxlevel = 5;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Schutz")){
                    maxlevel = 4;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Effizienz")){
                    maxlevel = 5;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Haltbarkeit")){
                    maxlevel = 5;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Explosionsschutz")){
                    maxlevel = 4;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Schusssicher")){
                    maxlevel = 4;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Feuerschutz")){
                    maxlevel = 4;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Bann")){
                    maxlevel = 5;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Nemesis der Gliederfüßler")){
                    maxlevel = 5;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Wasserläufer")){
                    maxlevel = 3;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Rückstoß")){
                    maxlevel = 2;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Wasseraffinität")){
                    maxlevel = 3;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Atmung")){
                    maxlevel = 3;
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Dornen")){
                    maxlevel = 3;
                }
            }
        }
        if(leveltomate <= maxlevel){
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

    private boolean hasSpezial(ItemStack item, String enchant){

        List<String> lore = item.getItemMeta().getLore();

        if(enchant.contains("Erhalt")) {
            if(lore.contains("Erhalt")) {
                return true;
            }
        } else if(enchant.contains("Verhärtung")) {
            if(lore.contains("Verhärtung")) {
                return true;
            }
        }
        return false;
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
        int standard = 20;
        if(s.equalsIgnoreCase("I")){
            return standard;
        }else if(s.equalsIgnoreCase("II")){
            return standard+10;
        }else if(s.equalsIgnoreCase("III")){
            return standard+20;
        }else if(s.equalsIgnoreCase("IV")){
            return standard+30;
        }else if(s.equalsIgnoreCase("V")){
            return standard+40;
        }else if(s.equalsIgnoreCase("VI")){
            return standard+50;
        }else if(s.equalsIgnoreCase("VII")){
            return standard+60;
        }else if(s.equalsIgnoreCase("VIII")){
            return standard+70;
        }else if(s.equalsIgnoreCase("IX")){
            return standard+80;
        }else if(s.equalsIgnoreCase("X")){
            return standard+90;
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
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.KILL_COUNTER)){
                    return EnchantManager.KILL_COUNTER;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Mob_Counter)){
                    return EnchantManager.Mob_Counter;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.BowCounter)){
                    return EnchantManager.BowCounter;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.BlockCounter)){
                    return EnchantManager.BlockCounter;
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
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Erhalt)){
                    return EnchantManager.Erhalt;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Rune)){
                    return EnchantManager.Rune;
                }else if(i.getItemMeta().getLore().get(0).startsWith(EnchantManager.Käfig)){
                    return EnchantManager.Käfig;
                }
            }
        }
        return null;
    }
    private String getVanillaEnchantofItem(ItemStack i){
        if(i.getItemMeta() != null){
            if(i.getItemMeta().getLore() != null){
                if(i.getItemMeta().getLore().get(0).startsWith("§7Verbrennung")){
                    return "§7Verbrennung ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Schärfe")){
                    return "§7Schärfe ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Stärke")){
                    return "§7Stärke ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Schutz")){
                    return "§7Schutz ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Effizienz")){
                    return "§7Effizienz ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Haltbarkeit")){
                    return "§7Haltbarkeit ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Explosionsschutz")){
                    return "§7Explosionsschutz ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Schusssicher")){
                    return "§7Schusssicher ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Feuerschutz")){
                    return "§7Feuerschutz ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Bann")){
                    return "§7Bann ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Nemesis der Gliederfüßler")){
                    return "§7Nemesis der Gliederfüßler ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Wasserläufer")){
                    return "§7Wasserläufer ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Rückstoß")){
                    return "§7Rückstoß ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Wasseraffinität")){
                    return "§7Wasseraffinität ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Atmung")){
                    return "§7Atmung ";
                }else if(i.getItemMeta().getLore().get(0).startsWith("§7Dornen")){
                    return "§7Dornen ";
                }
            }
        }
        return null;
    }

}
