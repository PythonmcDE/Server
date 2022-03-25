package me.bluenitrox.school.haendler.npc;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;
import java.util.List;

public class OutPut {

    private final ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§cUngültige Verzauberung").setLore("§b» §7Bitte überprüfe deine Items").build();

    public void check(Inventory inventory, Player player) {

        //items
        ItemStack item1 = inventory.getItem(11);
        ItemStack item2 = inventory.getItem(13);

        if(item1.getType() == Material.ENCHANTED_BOOK && item2.getType() == Material.ENCHANTED_BOOK) {

            /*
            Now check if this books are spezial enchants or vanilla enchants
             */

            if(item1.getItemMeta() == null || item2.getItemMeta() == null) return;
            if(item1.getItemMeta().getDisplayName() == null || item2.getItemMeta().getDisplayName() == null) return;
            if(item1.getItemMeta().getLore() == null || item2.getItemMeta().getLore() == null) return;

            List<String> loreItem1 = item1.getItemMeta().getLore();
            List<String> loreItem2 = item2.getItemMeta().getLore();

            if(isSpezialEnchant(item1) && isSpezialEnchant(item2)) {
                /*
                both books are spezial enchant books
                 */
                if(loreItem1.size() == 1 && loreItem2.size() == 1) {
                    /*
                    both books has only one enchant
                     */
                    if(getEnchant(item1).equalsIgnoreCase(getEnchant(item2))) {
                        /*
                        both books have the same enchant
                         */
                        if(stringToNumber(item1, getEnchant(item1)) == stringToNumber(item2, getEnchant(item2))) {
                            /*
                            books are on the same level
                             */
                            int enchantlevel = stringToNumber(item1, getEnchant(item1));

                            //all done the Items can now craftet together
                            if(stringToNumber(item1, getEnchant(item1)) < 10) {
                                inventory.setItem(15, getSlimeBall(getPrice(numberToString(enchantlevel)), getLevel(numberToString(enchantlevel))));
                            }
                        }
                    } else {
                        /*
                        books has not the same enchant
                         */
                        float price;
                        int levelItem1 = getLevel(item1, getEnchant(item1));
                        int levelItem2 = getLevel(item2, getEnchant(item2));
                        int level;
                        int enchantlevel;

                        /*
                        set the lower price for the items
                         */
                        if(levelItem1 >= levelItem2) {
                            price = getPrice(numberToString(levelItem2));
                            level = stringToNumber(item2, getEnchant(item2));
                        } else {
                            price = getPrice(numberToString(levelItem1));
                            level = stringToNumber(item1, getEnchant(item1));
                        }
                        enchantlevel = getLevel(numberToString(level));
                        inventory.setItem(15, getSlimeBall(price, enchantlevel));
                    }
                } else {
                    /*
                    put all enchants from the items in Lists
                     */
                    List<String> enchantsItem1 = getEnchants(item1);
                    List<String> enchantsItem2 = getEnchants(item2);

                    for (String s : enchantsItem1) {
                        for (String value : enchantsItem2) {
                            if (s.contains(value)) {
                                if (getLevel(item1, s) != getLevel(item2, value) || getLevel(item1, s) == 10 || getLevel(item2, s) == 10) {
                                    return;
                                }
                            }
                        }
                    }

                    int level = 0;
                    float price = 0;
                    /*
                    set the lower level price from both Items
                     */
                        int priceItem1 = 0;
                        int priceItem2 = 0;
                        int levelitem1 = 0;
                        int levelitem2 = 0;

                        for (String s : enchantsItem1) {
                            levelitem1 += getLevel(numberToString(getLevel(item1, s)));
                            priceItem1 += getPrice(numberToString(getLevel(item1, s)));
                        }

                        for (String s : enchantsItem2) {
                            levelitem2 += getLevel(numberToString(getLevel(item2, s)));
                            priceItem2 += getPrice(numberToString(getLevel(item2, s)));
                        }

                        /*
                        get the lowest value for a level
                         */
                        if(levelitem1 > levelitem2) {
                            level += levelitem2;
                            price += priceItem2;
                        } else if(levelitem1 < levelitem2){
                            level += levelitem1;
                            price += priceItem1;
                        } else {
                            level += levelitem1;
                            price += priceItem1;
                        }

                    /*
                    set Slimeball to the inventory
                     */
                    inventory.setItem(15, getSlimeBall(price, level));
                }

            } else if(isVanillaEnchant(item1) && isVanillaEnchant(item2)) {
                /*
                both books are vanilla enchant books
                 */
                if(loreItem1.size() == 1 && loreItem2.size() == 2) {
                    /*
                    the books has only one enchant on it
                     */
                    if(getEnchant(item1).equalsIgnoreCase(getEnchant(item2))) {
                        /*
                        the Items has the same enchant
                         */
                        if(stringToNumber(item1, getEnchant(item1)) == stringToNumber(item2, getEnchant(item2))) {
                            /*
                            books are on the same level
                             */
                            int enchantlevel = stringToNumber(item1, getEnchant(item1));

                            //all done the Items can now craftet together
                            if(stringToNumber(item1, getEnchant(item1)) <= getMaxLevelVanillaEnchants(getEnchant(item1))) {
                                inventory.setItem(15, getSlimeBall(getPrice(numberToString(enchantlevel)), getLevel(numberToString(enchantlevel))));
                            }
                        }
                    } else {
                        /*
                        books has not the same enchant
                         */
                        float price;
                        int levelItem1 = getLevel(item1, getEnchant(item1));
                        int levelItem2 = getLevel(item2, getEnchant(item2));
                        int level;
                        int enchantlevel;

                        /*
                        set the lower price for the items
                         */
                        if(levelItem1 >= levelItem2) {
                            price = getPrice(numberToString(levelItem2));
                            level = stringToNumber(item2, getEnchant(item2));
                        } else {
                            price = getPrice(numberToString(levelItem1));
                            level = stringToNumber(item1, getEnchant(item1));
                        }
                        enchantlevel = getLevel(numberToString(level));
                        inventory.setItem(15, getSlimeBall(price, enchantlevel));
                    }
                } else {
                    /*
                    put all enchants from the items in Lists
                     */
                    List<String> enchantsItem1 = getEnchants(item1);
                    List<String> enchantsItem2 = getEnchants(item2);

                    for (String s : enchantsItem1) {
                        for (String value : enchantsItem2) {
                            if (s.contains(value)) {
                                if (getLevel(item1, s) != getLevel(item2, value) || getLevel(item1, s) == getMaxLevelVanillaEnchants(s) || getLevel(item2, s) == getMaxLevelVanillaEnchants(s)) {
                                    return;
                                }
                            }
                        }
                    }

                    int level = 0;
                    float price = 0;
                    /*
                    set the lower level price from both Items
                     */
                    int priceItem1 = 0;
                    int priceItem2 = 0;
                    int levelitem1 = 0;
                    int levelitem2 = 0;

                    for (String s : enchantsItem1) {
                        levelitem1 += getLevel(numberToString(getLevel(item1, s)));
                        priceItem1 += getPrice(numberToString(getLevel(item1, s)));
                    }

                    for (String s : enchantsItem2) {
                        levelitem2 += getLevel(numberToString(getLevel(item2, s)));
                        priceItem2 += getPrice(numberToString(getLevel(item2, s)));
                    }

                        /*
                        get the lowest value for a level
                         */
                    if(levelitem1 > levelitem2) {
                        level += levelitem2;
                        price += priceItem2;
                    } else if(levelitem1 < levelitem2){
                        level += levelitem1;
                        price += priceItem1;
                    } else {
                        level += levelitem1;
                        price += priceItem1;
                    }

                    /*
                    set Slimeball to the inventory
                     */
                    inventory.setItem(15, getSlimeBall(price, level));
                }
            } else {
                /*
                one books is a spezial enchant book and the other is a vanilla enchant book
                 */
            }



        }
        else if(item2.getType() == Material.ENCHANTED_BOOK && item1.getType() != Material.ENCHANTED_BOOK) {

            /*
            Now check if the second book is a vanilla book or special book
            Then check if this enchant is combinate with this Item
             */

            if(isSpezialEnchant(item2)) {
                /*
                the book is a special enchant book
                 */
            } else if(isVanillaEnchant(item2)) {
                /*
                the books is a vanilla enchant book
                 */
            }

        }
        else if(item2.getType() == Material.NETHER_STAR || item2.getType() == Material.PRISMARINE_CRYSTALS && item1.getType() != Material.ENCHANTED_BOOK || item1.getType() != Material.PRISMARINE_CRYSTALS || item1.getType() != Material.NETHER_STAR) {
            /*
            Check now if the item2 is Erhalt or Verhärtung
             */
        }

    }

    private int getMaxLevelVanillaEnchants(String enchant) {
        switch (enchant) {
            case "§7Verbrennung": return 2;
            case "§7Schärfe": return 5;
            case "§7Stärke": return 5;
            case "§7Schutz": return 4;
            case "§7Effizienz": return 5;
            case "§7Haltbarkeit": return 3;
            case "§7Explosionsschutz": return 4;
            case "§7Schusssicher": return 4;
            case "§7Feuerschutz": return 4;
            case "§7Bann": return 5;
            case "§7Nemesis der Gliederfüßler": return 5;
            case "§7Wasserläufer": return 3;
            case "§7Rückstoß": return 2;
            case "§7Wasseraffinität": return 3;
            case "§7Atmung": return 3;
            case "§7Dornen": return 3;
        }
        return 0;
    }

    public float getPrice(String s){
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

    public int getLevel(String s){
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

    public int getLevel(ItemStack item, String enchant) {

        List<String> lore = item.getItemMeta().getLore();

        for (String s : lore) {
            if (s.contains(enchant)) {
                return stringToNumber(s.replace(enchant + " ", ""));
            }
        }
        return 0;
    }

    protected String getEnchant(ItemStack item){
        List<String> lore = item.getItemMeta().getLore();

        if(lore.isEmpty()) return "";
        return lore.get(0)
                .replace(" X", "")
                .replace(" IX", "")
                .replace(" VIII", "")
                .replace(" VII", "")
                .replace(" VI", "")
                .replace(" V", "")
                .replace(" IV", "")
                .replace(" III", "")
                .replace(" II", "")
                .replace(" I", "");
    }

    protected String getEnchant(ItemStack item, int loreline){
        List<String> lore = item.getItemMeta().getLore();

        if(lore.isEmpty()) return "";
        return lore.get(loreline)
                .replace(" X", "")
                .replace(" IX", "")
                .replace(" VIII", "")
                .replace(" VII", "")
                .replace(" VI", "")
                .replace(" V", "")
                .replace(" IV", "")
                .replace(" III", "")
                .replace(" II", "")
                .replace(" I", "");
    }

    protected List<String> getEnchants(ItemStack item){

        List<String> lore = item.getItemMeta().getLore();
        List<String> newlore = new LinkedList<>();

        for (String s : lore) {
            newlore.add(s.replace(" X", "")
                    .replace(" IX", "")
                    .replace(" VIII", "")
                    .replace(" VII", "")
                    .replace(" VI", "")
                    .replace(" V", "")
                    .replace(" IV", "")
                    .replace(" III", "")
                    .replace(" II", "")
                    .replace(" I", ""));
        }

        return newlore;
    }

    protected String numberToString(int i){
        if(i == 2){
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

    protected boolean hasEnchant(ItemStack item,String enchant){
        int hasenchant = 0;
        if(item.getItemMeta() == null) return false;
        if(item.getItemMeta().getLore() == null) return false;
        for(int i = 0; i < 10; i++) {
            if (item.getItemMeta().getLore().contains(enchant + numberToString(i))) {
                hasenchant = 1;
            }
        }
        if(hasenchant == 1) {
            return true;
        }else {
            return false;
        }
    }

    protected int stringToNumber(ItemStack i, String enchant){
        int line = 0;
        for(int wert = 0; wert<= i.getItemMeta().getLore().size()-1; wert++){
            if(i.getItemMeta().getLore().get(wert) != null) {
                if (i.getItemMeta().getLore().get(wert).startsWith(enchant)) {
                    line = wert;
                }
            }
        }

        String[] lore = i.getItemMeta().getLore().get(line).split(" ");
        return stringToNumber(lore[lore.length-1]);
    }

    private int stringToNumber(String s){
        if(s.equalsIgnoreCase("X")){
            return 10;
        }else if(s.equalsIgnoreCase("IX")){
            return 9;
        }else if(s.equalsIgnoreCase("VIII")){
            return 8;
        }else if(s.equalsIgnoreCase("VII")){
            return 7;
        }else if(s.equalsIgnoreCase("VI")){
            return 6;
        }else if(s.equalsIgnoreCase("V")){
            return 5;
        }else if(s.equalsIgnoreCase("IV")){
            return 4;
        }else if(s.equalsIgnoreCase("III")){
            return 3;
        }else if(s.equalsIgnoreCase("II")){
            return 2;
        }else{
            return 1;
        }
    }

    private ItemStack getSlimeBall(float price, int level) {
        return new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §6§l-" + level + " §7Vanilla XP", "§8● §6§l-" + price + " §7Gems").build();
    }

    private boolean isSpezialEnchant(ItemStack item) {
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch")) return true;
        else return false;
    }

    private boolean isVanillaEnchant(ItemStack item) {
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§5Verzaubertes Buch")) return true;
        else return false;
    }

    public void update(Inventory inventory, Player player) {
        //Check Slot 11 & 13 have Items
        new BukkitRunnable() {
            @Override
            public void run() {
                if(inventory.getItem(11) != null && inventory.getItem(13) != null) {
                    if(inventory.getItem(11).getType() != Material.AIR && inventory.getItem(13).getType() != Material.AIR) {
                        Bukkit.broadcastMessage("check now");
                        check(inventory, player);
                    } else {
                        inventory.setItem(15, barrier);
                    }
                } else {
                    inventory.setItem(15, barrier);
                }
            }
        }.runTaskLater(SchoolMode.getInstance(), 1);
    }

}
