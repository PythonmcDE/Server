package me.bluenitrox.school.utils;

import me.bluenitrox.school.crafting.Enchanter;
import me.bluenitrox.school.enchants.CraftAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class UpdateUtils extends CraftAPI {

    public static void updateEnchanter(Player all){
        if(all.getOpenInventory().getItem(22).getType() == Material.BOOK){
            all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §aVerzaubere das Item").setLore("§6§l▶ §7Klicke hier um ein Random Buch zu verzaubern,", "§6§l▶ §7dies kostet dich §6" + Enchanter.levelneeded +" Level §7und §615 Tsd §7Gems.").build("isInInv"));
        }else {
            all.getOpenInventory().setItem(25,new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cUngültige Verzauberung").setLore("§8● §7Entweder liegt kein Item auf dem freien Slot,", "§8● §7oder dieses kann nicht verzaubert werden.").build("isInInv"));
        }
        all.updateInventory();
    }

    public static void updateCraft(Player all) {
        if (all.getOpenInventory().getItem(CraftAPI.slot1) != null && all.getOpenInventory().getItem(CraftAPI.slot2) != null) {
            if (all.getOpenInventory().getItem(CraftAPI.slot1).getItemMeta() != null && all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta() != null) {
                if (all.getOpenInventory().getItem(CraftAPI.slot1).getItemMeta().getDisplayName() != null && all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta().getDisplayName() != null) {
                    if (all.getOpenInventory().getItem(CraftAPI.slot1).getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch") &&
                            all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch")) {
                        String[] preis = all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta().getLore().get(0).split(" ");
                        float price = CraftAPI.getPrice(preis[1]);
                        int level = CraftAPI.getLevel(preis[1]);
                        all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §7Kosten:§6§l " + level + " Vanilla Level", "§8● §7Gem-Kosten:§6§l " + price + " Gems").build());
                    } else {
                        if (all.getOpenInventory().getItem(CraftAPI.slot1).getType() == Material.ENCHANTED_BOOK &&
                                all.getOpenInventory().getItem(CraftAPI.slot2).getType() == Material.ENCHANTED_BOOK) {
                            if (all.getOpenInventory().getItem(CraftAPI.slot1).getItemMeta().getDisplayName().equalsIgnoreCase("§5Verzaubertes Buch") &&
                                    all.getOpenInventory().getItem(CraftAPI.slot2).getItemMeta().getDisplayName().equalsIgnoreCase("§5Verzaubertes Buch")) {
                                /*
                                special book ON special book
                                 */

                                ItemStack is1 = all.getOpenInventory().getItem(CraftAPI.slot1);
                                ItemStack is2 = all.getOpenInventory().getItem(CraftAPI.slot2);

                                if (is1.getItemMeta().getLore().equals(is2.getItemMeta().getLore())){
                                    String[] preis = is2.getItemMeta().getLore().get(0).split(" ");
                                    float price = CraftAPI.getPrice(preis[1]);
                                    int level = CraftAPI.getLevel(preis[1]);
                                    all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §7Kosten:§6§l " + level + " Vanilla Level", "§8● §7Gem-Kosten:§6§l " + price + " Gems").build());
                                }
                            }else {
                                /*
                                normal book on normal book
                                 */
                            }
                        }else if(isItemForEnchant(all.getOpenInventory().getItem(slot1)) && all.getOpenInventory().getItem(slot2).getType() == Material.ENCHANTED_BOOK){
                            if(all.getOpenInventory().getItem(slot2).getType() != null) {
                                if(all.getOpenInventory().getItem(slot2).getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch")){
                                    if(isEnchantForItem(all.getOpenInventory().getItem(slot1), all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0))) {
                                    /*
                                    special book on armor
                                     */

                                        String[] preis = all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                                        float price = CraftAPI.getPrice(preis[1]);
                                        int level = CraftAPI.getLevel(preis[1]);
                                        all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §7Kosten:§6§l " + level + " Vanilla Level", "§8● §7Gem-Kosten:§6§l " + price + " Gems").build());
                                        return;
                                    }
                                }
                            }
                            /*
                            normal book on armor
                             */
                        }
                    }
                }else if(isItemForEnchant(all.getOpenInventory().getItem(slot1)) && all.getOpenInventory().getItem(slot2).getType() == Material.ENCHANTED_BOOK){
                    if(all.getOpenInventory().getItem(slot2).getType() != null) {
                        if(all.getOpenInventory().getItem(slot2).getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch")){
                            if(isEnchantForItem(all.getOpenInventory().getItem(slot1), all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0))) {
                                    /*
                                    special book on armor
                                     */

                                String[] preis = all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                                float price = CraftAPI.getPrice(preis[1]);
                                int level = CraftAPI.getLevel(preis[1]);
                                all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §7Kosten:§6§l " + level + " Vanilla Level", "§8● §7Gem-Kosten:§6§l " + price + " Gems").build());
                                return;
                            }
                        }
                    }
                            /*
                            normal book on armor
                             */
                }
            }
            else if(isItemForEnchant(all.getOpenInventory().getItem(slot1)) && all.getOpenInventory().getItem(slot2).getType() == Material.ENCHANTED_BOOK){
                if(all.getOpenInventory().getItem(slot2).getType() != null) {
                    if(all.getOpenInventory().getItem(slot2).getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch")){
                        if(isEnchantForItem(all.getOpenInventory().getItem(slot1), all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0))) {
                                    /*
                                    special book on armor
                                     */

                            String[] preis = all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                            float price = CraftAPI.getPrice(preis[1]);
                            int level = CraftAPI.getLevel(preis[1]);
                            all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §7Kosten:§6§l " + level + " Vanilla Level", "§8● §7Gem-Kosten:§6§l " + price + " Gems").build());
                            return;
                        }
                    }
                }
                            /*
                            normal book on armor
                             */
            }
            else if(isItemForEnchant(all.getOpenInventory().getItem(slot1)) && all.getOpenInventory().getItem(slot2).getType() == Material.NETHER_STAR){
                if(all.getOpenInventory().getItem(slot2).getType() != null) {
                    Bukkit.broadcastMessage("1");
                    if(all.getOpenInventory().getItem(slot2).getItemMeta().getDisplayName().contains("Item-Erhalt")){
                        Bukkit.broadcastMessage("2");
                        if(isEnchantForItem(all.getOpenInventory().getItem(slot1), all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0))) {
                            Bukkit.broadcastMessage("3");
                                    /*
                                    special book on armor
                                     */

                            String[] preis = all.getOpenInventory().getItem(slot2).getItemMeta().getLore().get(0).split(" ");
                            float price = CraftAPI.getPrice(preis[1]);
                            int level = CraftAPI.getLevel(preis[1]);
                            all.getOpenInventory().setItem(25, new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §7Item Verzaubern").setLore("§8● §7Kosten:§6§l " + level + " Vanilla Level", "§8● §7Gem-Kosten:§6§l " + price + " Gems").build());
                            return;
                        }
                    }
                }
                            /*
                            normal book on armor
                             */
            }
        }
        else {
            all.getOpenInventory().setItem(25, new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cUngültige Kombination").setLore("§8● §7Diese Verzauberung ist leider nicht möglich.").build());
        }
        all.updateInventory();
    }

    /*private static Enchantment getEnchant(Map<Enchantment,Integer>){
        Enchantment enchantment = null;
        return enchantment;
    }*/
}
