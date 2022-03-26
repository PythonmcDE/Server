package me.bluenitrox.school.crafting.anvil;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;
import java.util.List;

public class Anvil {

    private final ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§cUngültige Verzauberung").setLore("§b» §7Bitte überprüfe deine Items").build();

    //TODO Check in the {check} Method For Tracker
    //TODO add custom Dura to an item on enchant

    /**
     * Craft a special Item to an item and set the item to the player inv
     * @param inventory the inventory which is requested the crafting
     * @param player the player who get the item
     */
    public void craftSpecialOnItem(Inventory inventory, Player player) {

        /*
        Get the items
        */

        ItemStack item1 = inventory.getItem(11); //Item 1 is on slot 11
        ItemStack item2 = inventory.getItem(13); //Item 1 is on slot 13

        ItemStack craftItem = inventory.getItem(15); //The clicked slimeball is on slot 15

        /*
        Check if item 1 has a lore
         */
        if(item1.getItemMeta() == null || item1.getItemMeta().getLore() == null) {

            /*
            the item has no enchant. So we can easy add it
             */
            ItemMeta meta2 = item1.getItemMeta();
            List<String> loreitem1 = new LinkedList<>();

            loreitem1.add(item2.getItemMeta().getLore().get(0));

            meta2.setLore(loreitem1);
            item1.setItemMeta(meta2);

        } else {
            /*
            The Item already have an Itemmeta.
            We checked before that if the item has the enchant they have the same level.
             */
            ItemMeta meta1 = item1.getItemMeta();
            List<String> loreitem1 = meta1.getLore();
            List<String> item2enchants = getEnchants(item2); //CAREFULL use only get(0)!!!!

            List<String> done = new LinkedList<>();

            for (String s : loreitem1) {
                if(s.equalsIgnoreCase(item2.getItemMeta().getLore().get(0))) {
                    loreitem1.remove(s);
                    String newenchant = item2enchants.get(0) + " " + numberToString(getLevel(item2, item2enchants.get(0)) + 1);
                    loreitem1.add(newenchant);
                    done.add(s);
                }
            }

            if(done.size() == 0) {
                String newenchant = item2.getItemMeta().getLore().get(0);
                loreitem1.add(newenchant);
            }

            meta1.setLore(loreitem1);
            item1.setItemMeta(meta1);

        }

        //Get the level from the lore.
        String levelstring = craftItem.getItemMeta().getLore().get(3).replace("§b", "").replace(" §7Vanilla-XP", "");

        //Get the price from the lore. Carefull we used ValueToString for it. So we need to replace Tsd, Mio to the numbers.
        String priceasstring = craftItem.getItemMeta().getLore().get(2).replace("§b", "").replace(" §7Gems", "").replace(",", "");
        String finalprice;
        float price;

        if(priceasstring.contains("Tsd") || priceasstring.contains("Mio")) {
                /*
                Our Price includes Tsd or Mio from Valuetostring.
                Replace Tsd with 3 zeros or Mio with 6 zeros.
                 */
            if(priceasstring.contains("Tsd")) {
                finalprice = priceasstring.replace(" Tsd", "");
                price = Float.parseFloat(finalprice) * 10;
            } else {
                finalprice = priceasstring.replace(" Mio", "");
                price = Float.parseFloat(finalprice) * 10000;
            }
        } else {
                /*
                the price is the default price without mio or thausend
                 */
            finalprice = priceasstring;
            price = Float.parseFloat(finalprice);
        }

        int level = Integer.parseInt(levelstring); //Get the level as int to remove them from the player
        int newlevel = player.getLevel() - level;

        MoneyManager.updateMoney(player.getUniqueId(), price, true, false);
        Bukkit.broadcastMessage(String.valueOf(price));
        player.setLevel(newlevel);

            /*
            Add Item to the player and remove the other from the inventory
             */
        inventory.setItem(11, null);
        inventory.setItem(13, null);

        int freeslots = 0;

            /*
            check for free inventory slots
             */
        for(int i = 0; i < player.getInventory().getSize(); i++) {
            if(player.getInventory().getItem(i) == null) {
                freeslots += 1;
            }
        }

        if(freeslots != 0) {
            player.getInventory().addItem(item1);
        } else {
            player.getWorld().dropItem(player.getLocation(), item1);
        }

        player.playSound(player.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);
    }

    /**
     * Craft two books together and add the finished book in the player inventory
     * @param inventory the inventory which is requested the crafting
     * @param player the player who get the item
     */
    public void craftBooksTogether(Inventory inventory, Player player){

        /*
        Get the items
         */
        ItemStack item1 = inventory.getItem(11); //Item 1 is on slot 11
        ItemStack item2 = inventory.getItem(13); //Item 1 is on slot 13

        ItemStack craftItem = inventory.getItem(15); //The clicked slimeball is on slot 15

        /*
        craft together
         */
        ItemMeta meta1 = item1.getItemMeta();
        ItemMeta meta2 = item2.getItemMeta();

        List<String> item1enchants = meta1.getLore();
        List<String> item2enchants = meta2.getLore();

        List<String> done = new LinkedList<>();

        for (int i = 0; i < item1enchants.size(); i++) {
            if(item2enchants.size() != 0) {
                for (String item2ench : item2enchants) {
                    if (item1enchants.get(i).contains(item2ench)) {
                    /*
                    the enchants which Item 1 contains are now updated
                     */
                        if(!done.contains(item2ench)) {
                            item1enchants.add(item1enchants.get(i) + numberToString(getLevel(item1, item1enchants.get(i))));
                            item1enchants.remove(i);
                            done.add(item2ench);
                        }
                    } else {
                        if(!done.contains(item2ench)) {
                            item1enchants.add(item2ench);
                            done.add(item2ench);
                        }
                    }
                }
            }
        }
            /*
            We updated all enchants on the book.
            Now set the new item and get the player the item
             */

            meta1.setLore(item1enchants);
            item1.setItemMeta(meta1);

            //Get the level from the lore.
            String levelstring = craftItem.getItemMeta().getLore().get(3).replace("§b", "").replace(" §7Vanilla-XP", "");

            //Get the price from the lore. Carefull we used ValueToString for it. So we need to replace Tsd, Mio to the numbers.
            String priceasstring = craftItem.getItemMeta().getLore().get(2).replace("§b", "").replace(" §7Gems", "").replace(",", "");
            String finalprice;
            float price;

            if(priceasstring.contains("Tsd") || priceasstring.contains("Mio")) {
                /*
                Our Price includes Tsd or Mio from Valuetostring.
                Replace Tsd with 3 zeros or Mio with 6 zeros.
                 */
                if(priceasstring.contains("Tsd")) {
                    finalprice = priceasstring.replace(" Tsd", "");
                    price = Float.parseFloat(finalprice) * 10;
                } else {
                    finalprice = priceasstring.replace(" Mio", "");
                    price = Float.parseFloat(finalprice) * 10000;
                }
            } else {
                /*
                the price is the default price without mio or thausend
                 */
                finalprice = priceasstring;
                price = Float.parseFloat(finalprice);
            }

            //price = Float.parseFloat(finalprice); //Get it as float to remove the money from the player
            int level = Integer.parseInt(levelstring); //Get the level as int to remove them from the player
            int newlevel = player.getLevel() - level;

            MoneyManager.updateMoney(player.getUniqueId(), price, true, false);
            player.setLevel(newlevel);

            /*
            Add Item to the player and remove the other from the inventory
             */
            inventory.setItem(11, null);
            inventory.setItem(13, null);

            int freeslots = 0;

            /*
            check for free inventory slots
             */
            for(int i = 0; i < player.getInventory().getSize(); i++) {
                if(player.getInventory().getItem(i) == null) {
                    freeslots += 1;
                }
            }

            if(freeslots != 0) {
                player.getInventory().addItem(item1);
            } else {
                player.getWorld().dropItem(player.getLocation(), item1);
            }

            player.playSound(player.getLocation(), Sound.ANVIL_USE, 1.0F, 1.0F);

    }

    /**
     * Update the barrier to a slimeball if the items can be craftet together
     * @param inventory the inventory which get updated
     * @param player the player who is in the inventory
     */
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
                            int vanillaxp = getLevel(numberToString(enchantlevel));
                            float price = getPrice(numberToString(enchantlevel));

                            //all done the Items can now craftet together
                            if(stringToNumber(item1, getEnchant(item1)) < 10) {
                                //set slimeball
                                if(player.getLevel() < vanillaxp && MoneyManager.getMoney(player.getUniqueId()) < price) {
                                    inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, vanillaxp));
                                }
                                else if(player.getLevel() < vanillaxp) {
                                    inventory.setItem(15, getSlimeBallNoXP(price, vanillaxp));
                                }
                                else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                                    inventory.setItem(15, getSlimeBallNoMoney(price, vanillaxp));
                                } else {
                                    inventory.setItem(15, getSlimeBall(price, vanillaxp));
                                }
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
                        int vanillaxp;

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
                        vanillaxp = getLevel(numberToString(level));

                        if(player.getLevel() < vanillaxp && MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, vanillaxp));
                        }
                        else if(player.getLevel() < vanillaxp) {
                            inventory.setItem(15, getSlimeBallNoXP(price, vanillaxp));
                        }
                        else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoMoney(price, vanillaxp));
                        } else {
                            inventory.setItem(15, getSlimeBall(price, vanillaxp));
                        }
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

                    int vanillaxp = 0;
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
                            vanillaxp += levelitem2;
                            price += priceItem2;
                        } else if(levelitem1 < levelitem2){
                            vanillaxp += levelitem1;
                            price += priceItem1;
                        } else {
                            vanillaxp += levelitem1;
                            price += priceItem1;
                        }

                    /*
                    set Slimeball to the inventory
                     */
                    if(player.getLevel() < vanillaxp && MoneyManager.getMoney(player.getUniqueId()) < price) {
                        inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, vanillaxp));
                    }
                    else if(player.getLevel() < vanillaxp) {
                        inventory.setItem(15, getSlimeBallNoXP(price, vanillaxp));
                    }
                    else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                        inventory.setItem(15, getSlimeBallNoMoney(price, vanillaxp));
                    } else {
                        inventory.setItem(15, getSlimeBall(price, vanillaxp));
                    }

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
                            Enchantment en = getVanillaEnchant(getEnchant(item1));
                            if(stringToNumber(item1, getEnchant(item1)) < getMaxLevelVanillaEnchants(en)) {
                                float price = getPrice(numberToString(enchantlevel));
                                int vanillaxp = getLevel(numberToString(enchantlevel));

                                if(player.getLevel() < vanillaxp && MoneyManager.getMoney(player.getUniqueId()) < price) {
                                    inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, vanillaxp));
                                }
                                else if(player.getLevel() < vanillaxp) {
                                    inventory.setItem(15, getSlimeBallNoXP(price, vanillaxp));
                                }
                                else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                                    inventory.setItem(15, getSlimeBallNoMoney(price, vanillaxp));
                                } else {
                                    inventory.setItem(15, getSlimeBall(price, vanillaxp));
                                }
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

                        if(player.getLevel() < enchantlevel && MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, enchantlevel));
                        }
                        else if(player.getLevel() < enchantlevel) {
                            inventory.setItem(15, getSlimeBallNoXP(price, enchantlevel));
                        }
                        else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoMoney(price, enchantlevel));
                        } else {
                            inventory.setItem(15, getSlimeBall(price, enchantlevel));
                        }
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
                                Enchantment en = getVanillaEnchant(s);
                                if (getLevel(item1, s) != getLevel(item2, value) || getLevel(item1, s) == getMaxLevelVanillaEnchants(en) || getLevel(item2, s) == getMaxLevelVanillaEnchants(en)) {
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
                    if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                        inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                    }
                    else if(player.getLevel() < level) {
                        inventory.setItem(15, getSlimeBallNoXP(price, level));
                    }
                    else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                        inventory.setItem(15, getSlimeBallNoMoney(price, level));
                    } else {
                        inventory.setItem(15, getSlimeBall(price, level));
                    }
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

            //Check item 2, return if has no lore
            if(item2.getItemMeta() == null) return;
            if(item2.getItemMeta().getLore() == null) return;

            List<String> booklore = item2.getItemMeta().getLore();

            if(isSpezialEnchant(item2)) {
                /*
                the book is a special enchant book
                 */

                if(item1.getItemMeta() == null || item1.getItemMeta().getLore() == null) {
                    /*
                    the Lore to check enchants is null.
                    We need to make two methods to catch the NullPointerException.
                    But we don't need to check if the Item has the same Enchant as our book.
                     */
                    if(booklore.size() == 1) {
                        /*
                        Our book has only one enchant on it
                         */
                        if(isItemForEnchant(item1, getEnchant(item2))) {
                            /*
                            Our enchant is compatible with our item.
                             */
                            int enchantlevel = stringToNumber(item2, getEnchant(item2));

                            //We are on the end, the items can be crafted together
                            float price = getPriceForItem(numberToString(enchantlevel));
                            int level = getLevel(numberToString(enchantlevel)) - 10;

                            if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                                inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                            }
                            else if(player.getLevel() < level) {
                                inventory.setItem(15, getSlimeBallNoXP(price, level));
                            }
                            else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                                inventory.setItem(15, getSlimeBallNoMoney(price, level));
                            } else {
                                inventory.setItem(15, getSlimeBall(price, level));
                            }
                        }
                    } else {
                        /*
                        our book has more than one enchants on it.
                        But this is no problem, we only need to loop every enchant on the book and check compatibility.
                         */
                        List<String> bookenchants = getEnchants(item2);

                        //loop all enchants from the book
                        for(String enchants : bookenchants) {
                            if(!isItemForEnchant(item1, enchants)) return;
                        }

                        /*
                        Okay good, the enchants passed the check.
                        Now calculate the level and the price for this enchantment.
                         */

                        int level = 0;
                        float price = 0;

                        /*
                        set the lower level price from both Items
                        */

                        for (String s : bookenchants) {
                            level += getLevel(numberToString(getLevel(item2, s))) - 10;
                            price += getPriceForItem(numberToString(getLevel(item2, s)));
                        }


                        /*
                        set Slimeball to the inventory
                        */
                        if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                        }
                        else if(player.getLevel() < level) {
                            inventory.setItem(15, getSlimeBallNoXP(price, level));
                        }
                        else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoMoney(price, level));
                        } else {
                            inventory.setItem(15, getSlimeBall(price, level));
                        }
                    }
                } else {

                    /*
                    Our Item have already Enchants.
                     */
                    if(booklore.size() == 1) {
                        /*
                        The book has only one enchant on it.
                         */
                        if(isItemForEnchant(item1, getEnchant(item2))) {
                            /*
                            Our enchant can be placed generally to the item.
                            Now we need to check if the item has the enchant already.
                             */
                            if(hasEnchant(item1, getEnchant(item2))) {
                                /*
                                The Item has the enchant already.
                                Now check if the enchant has the same level as the enchant from our book.
                                But carefull we need to loop all Items from the Main Item
                                 */
                                for(String itemenchants : getEnchants(item1)) {
                                    if(itemenchants.equalsIgnoreCase(getEnchant(item2))) {
                                        /*
                                        We have the line where our enchant is the same.
                                         */
                                        if(getLevel(item1, itemenchants) != getLevel(item2, getEnchant(item2))) return; //finally return if the level enchant is not the same
                                    }
                                }
                            }
                            /*
                            If our Item has the same enchant we passed the check.
                            Now we can calculate the level and gems.
                             */
                            int enchantlevel = stringToNumber(item2, getEnchant(item2));
                            float price = getPriceForItem(numberToString(enchantlevel));
                            int level = getLevel(numberToString(enchantlevel)) - 10;

                            if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                                inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                            }
                            else if(player.getLevel() < level) {
                                inventory.setItem(15, getSlimeBallNoXP(price, level));
                            }
                            else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                                inventory.setItem(15, getSlimeBallNoMoney(price, level));
                            } else {
                                inventory.setItem(15, getSlimeBall(price, level));
                            }
                        }
                    } else {
                        /*
                        Our book has multiple enchants
                         */
                        List<String> bookenchants = getEnchants(item2);

                        for(String s : bookenchants) {
                            if(!isItemForEnchant(item1, s)) return; //return if the enchant is not for the item

                            if(hasEnchant(item1, s)) {
                                for(String itemenchants : getEnchants(item1)) {
                                    if(itemenchants.equalsIgnoreCase(s)) {
                                        /*
                                        We have the line where our enchant is the same.
                                         */
                                        if(getLevel(item1, itemenchants) != getLevel(item2, s)) return; //finally return if the level enchant is not the same
                                    }
                                }
                            }
                        }

                        /*
                        Okay good, the enchants passed the check.
                        Now calculate the level and the price for this enchantment.
                         */

                        int level = 0;
                        float price = 0;

                        /*
                        set the lower level price from both Items
                        */

                        for (String s : bookenchants) {
                            level += getLevel(numberToString(getLevel(item2, s))) - 10;
                            price += getPriceForItem(numberToString(getLevel(item2, s)));
                        }


                        /*
                        set Slimeball to the inventory
                        */
                        if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                        }
                        else if(player.getLevel() < level) {
                            inventory.setItem(15, getSlimeBallNoXP(price, level));
                        }
                        else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                            inventory.setItem(15, getSlimeBallNoMoney(price, level));
                        } else {
                            inventory.setItem(15, getSlimeBall(price, level));
                        }

                    }
                }

            } else if(isVanillaEnchant(item2)) {
                /*
                the books is a vanilla enchant book
                 */

                if (booklore.size() == 1) {
                    /*
                    the book has only one enchant
                     */
                    Enchantment en = getVanillaEnchant(getEnchant(item2));
                    if(en == null) return; //the Enchantment from the book is not an allowed enchant

                    if (item1.getEnchantments().get(en) == null) {
                        /*
                        the item has no enchant on it
                        */

                        if(en.canEnchantItem(item1)) {
                            /*
                            the enchantment from the Book can enchanted for the item
                             */
                            if(getLevel(item2, getEnchant(item2)) <= getMaxLevelVanillaEnchants(en)) {
                                /*
                                the level is lower than the level of an item
                                 */
                                int enchantlevel = stringToNumber(item2, getEnchant(item2));
                                float price = getPriceForItem(numberToString(enchantlevel));
                                int level = getLevel(numberToString(enchantlevel)) - 10;

                                if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                                    inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                                }
                                else if(player.getLevel() < level) {
                                    inventory.setItem(15, getSlimeBallNoXP(price, level));
                                }
                                else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                                    inventory.setItem(15, getSlimeBallNoMoney(price, level));
                                } else {
                                    inventory.setItem(15, getSlimeBall(price, level));
                                }
                            }
                        }

                    } else {
                        /*
                        the item has already enchants
                         */

                        if(en.canEnchantItem(item1)) {
                            /*
                            the enchantment from the Book can enchanted for the item
                             */
                            if(getLevel(item2, getEnchant(item2)) <= getMaxLevelVanillaEnchants(en)) {
                                /*
                                the level is lower than the maximum level
                                 */
                                if(item1.getEnchantments().get(en) != null) {
                                    /*
                                    the item has the enchant already
                                     */
                                    if(item1.getEnchantments().get(en) == getLevel(item2, getEnchant(item2))) {
                                        /*
                                        the enchant on the item has the same level
                                         */
                                        int enchantlevel = stringToNumber(item2, getEnchant(item2));
                                        float price = getPriceForItem(numberToString(enchantlevel));
                                        int level = getLevel(numberToString(enchantlevel)) - 10;

                                        if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                                            inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                                        }
                                        else if(player.getLevel() < level) {
                                            inventory.setItem(15, getSlimeBallNoXP(price, level));
                                        }
                                        else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                                            inventory.setItem(15, getSlimeBallNoMoney(price, level));
                                        } else {
                                            inventory.setItem(15, getSlimeBall(price, level));
                                        }
                                    }
                                }
                            }
                        }

                    }
                } else {
                    /*
                    book has more than one enchant on it
                     */
                    Enchantment en;
                    List<String> bookenchants = getEnchants(item2);

                    for (String s : bookenchants) {
                        en = getVanillaEnchant(s); //get the Vanilla Enchant from all lore lines
                        if(en == null) return; //the enchant is not allowed
                        if (!en.canEnchantItem(item1)) return; //the enchant is not for the item
                        if(item1.getEnchantments().get(en) != null) {
                            if(item1.getEnchantments().get(en) != getLevel(item2, s))return; //the enchantment on the item has not the same level as the book -> discontinue
                        }
                    }

                    int level = 0;
                    float price = 0;

                    /*
                    set the lower level price from both Items
                     */

                    for (String s : bookenchants) {
                        level += getLevel(numberToString(getLevel(item2, s))) - 10;
                        price += getPriceForItem(numberToString(getLevel(item2, s)));
                    }


                    /*
                    set Slimeball to the inventory
                     */
                    if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                        inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                    }
                    else if(player.getLevel() < level) {
                        inventory.setItem(15, getSlimeBallNoXP(price, level));
                    }
                    else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                        inventory.setItem(15, getSlimeBallNoMoney(price, level));
                    } else {
                        inventory.setItem(15, getSlimeBall(price, level));
                    }
                }
            }

        }
        else if(item2.getType() == Material.NETHER_STAR || item2.getType() == Material.PRISMARINE_CRYSTALS && item1.getType() != Material.ENCHANTED_BOOK || item1.getType() != Material.PRISMARINE_CRYSTALS || item1.getType() != Material.NETHER_STAR) {
            /*
            Check now if the item2 is Erhalt or Verhärtung
             */
            if(item2.getItemMeta() == null || item2.getItemMeta().getDisplayName() == null || item2.getItemMeta().getLore() == null) return;

            if(item2.getItemMeta().getDisplayName().contains("§8» §3§lItem-Erhalt") || item2.getItemMeta().getDisplayName().contains("§8» §c§lItem-Verhärtung")) {
                /*
                Item2 is Erhalt or Verhärtung
                 */

                String erhaltname = "§f§lErhalt";
                String verhaertungname = "§f§lVerhärtung";

                if(item1.getItemMeta() != null && item1.getItemMeta().getLore() != null) {
                    for (String s : getEnchants(item1)) {
                        if (s.equalsIgnoreCase(erhaltname)) {
                            if (getLevel(item1, s) != getLevel(item2, erhaltname) || getLevel(item1, s) == 10 || getLevel(item2, erhaltname) == 10)
                                return; //the item has not the same level as the erhalt item level
                            if (!isItemForSpecial(item1, erhaltname)) return; //the Item is not compatible with Erhalt
                        } else
                        if (s.equalsIgnoreCase(verhaertungname)) {
                            if (getLevel(item1, s) != getLevel(item2, verhaertungname) || getLevel(item1, s) == 10 || getLevel(item2, verhaertungname) == 10)
                                return; //the item has not the same level as the verhärtung item level
                            if (!isItemForSpecial(item1, verhaertungname))
                                return; //the item is not compatible with Verhärtung
                        } else {
                            if(!isItemForSpecial(item1, erhaltname) || !isItemForSpecial(item1, verhaertungname)) return;
                        }
                    }
                }

                /*
                calculate the price and the vanilla level
                 */
                float price = getPriceForItem(getErhaltOrVerhaertungNumberAsString(item2));
                int level = getLevel(getErhaltOrVerhaertungNumberAsString(item2)) - 10;

                /*
                Set slimeball to the inventory
                 */
                if(player.getLevel() < level && MoneyManager.getMoney(player.getUniqueId()) < price) {
                    inventory.setItem(15, getSlimeBallNoXPAndNoMoney(price, level));
                }
                else if(player.getLevel() < level) {
                    inventory.setItem(15, getSlimeBallNoXP(price, level));
                }
                else if(MoneyManager.getMoney(player.getUniqueId()) < price) {
                    inventory.setItem(15, getSlimeBallNoMoney(price, level));
                } else {
                    inventory.setItem(15, getSlimeBall(price, level));
                }

            }
        }

    }

    /**
     * Check if an Item is compatible with Erhalt or Verhärtung
     * @param item1 the item which get checked
     * @param special the type of special enchant
     * @return true if the item is compatible
     */
    private boolean isItemForSpecial(ItemStack item1, String special) {

        boolean isforitem = false;

        if(special.contains("Erhalt") || special.contains("Verhärtung")) {

            switch (item1.getType()) {

                /*
                Diamond Items
                 */
                case DIAMOND_HELMET:
                case DIAMOND_CHESTPLATE:
                case DIAMOND_LEGGINGS:
                case DIAMOND_BOOTS:
                case DIAMOND_SWORD:
                case DIAMOND_PICKAXE:
                case DIAMOND_AXE:

                /*
                Iron Items
                 */
                case IRON_HELMET:
                case IRON_CHESTPLATE:
                case IRON_LEGGINGS:
                case IRON_BOOTS:
                case IRON_SWORD:
                case IRON_PICKAXE:
                case IRON_AXE:

                /*
                Gold Items
                 */
                case GOLD_HELMET:
                case GOLD_CHESTPLATE:
                case GOLD_LEGGINGS:
                case GOLD_BOOTS:
                case GOLD_SWORD:
                case GOLD_PICKAXE:
                case GOLD_AXE:

                /*
                Chainmal and Stone Items
                 */
                case CHAINMAIL_HELMET:
                case CHAINMAIL_CHESTPLATE:
                case CHAINMAIL_LEGGINGS:
                case CHAINMAIL_BOOTS:
                case STONE_SWORD:
                case STONE_PICKAXE:
                case STONE_AXE:

                /*
                Leather and Wood Items
                 */
                case LEATHER_HELMET:
                case LEATHER_CHESTPLATE:
                case LEATHER_LEGGINGS:
                case LEATHER_BOOTS:
                case WOOD_SWORD:
                case WOOD_PICKAXE:
                case WOOD_AXE:

                /*
                other Items
                 */
                case BOW:
                case FISHING_ROD:
                    isforitem = true;
                    break;
            }

        }
        return isforitem;
    }

    /**
     * Get the enchant level from an Erhalt or a Verhärtung item
     * @param item the Erhalt or Verhärtung Item
     * @return the level as String
     */
    private String getErhaltOrVerhaertungNumberAsString(ItemStack item) {

        List<String> lore = item.getItemMeta().getLore();

        //replace Erhalt and Verhärtung, so we don't need to create two methods
        return lore.get(0).replace("§f§lErhalt ", "");
    }

    /**
     * Get the enchant level from an Erhalt or a Verhärtung item
     * @param item the Erhalt or Verhärtung Item
     * @return the level as Int
     */
    private int getErhaltOrVerhaertungNumberAsInt(ItemStack item) {

        List<String> lore = item.getItemMeta().getLore();

        //replace Erhalt and Verhärtung, so we don't need to create two methods.
        //set the getted String to a number via a other method
        return stringToNumber(lore.get(0).replace("§f§lErhalt ", ""));
    }

    /**
     * Check here if a Enchant can be Enchanted to this type of item
     * @param item1 is the item on the first slot
     * @param enchant is the name of the enchant
     * @return true if the enchant craftet on this Type of Material
     * @Warn use enchant without the level
     * {@linkplain me.bluenitrox.school.enchants.EnchantManager}
     */
    private boolean isItemForEnchant(ItemStack item1, String enchant) {

        boolean isenchantforitem = false; //return this boolean at the end

        if(enchant.startsWith("§a§l")) {
            /*
            This book is an armor only book.
            So register all Armors in the Game.
             */
            switch (item1.getType()) {

                /*
                Diamond armor
                 */

                case DIAMOND_HELMET:
                case DIAMOND_CHESTPLATE:
                case DIAMOND_LEGGINGS:
                case DIAMOND_BOOTS:

                /*
                Iron Armor
                 */

                case IRON_HELMET:
                case IRON_CHESTPLATE:
                case IRON_LEGGINGS:
                case IRON_BOOTS:

                /*
                Gold Armor
                 */

                case GOLD_HELMET:
                case GOLD_CHESTPLATE:
                case GOLD_LEGGINGS:
                case GOLD_BOOTS:

                /*
                Chain armor
                 */

                case CHAINMAIL_HELMET:
                case CHAINMAIL_CHESTPLATE:
                case CHAINMAIL_LEGGINGS:
                case CHAINMAIL_BOOTS:

                /*
                Leather Armor
                 */

                case LEATHER_HELMET:
                case LEATHER_CHESTPLATE:
                case LEATHER_LEGGINGS:
                case LEATHER_BOOTS:

                    isenchantforitem = true; //the enchant is for this item
                    break; //cancel the other parts
            }
        }

        else if(enchant.startsWith("§9§l")) {
            /*
            This book is an bow only book.
            So register the bow and set the boolean to true.
             */
            if(item1.getType() == Material.BOW) {
                isenchantforitem = true; //the enchant is for the item
            }
        }

        else if(enchant.startsWith("§6§l")) {

            /*
            This book is a pickaxe and rod only book.
            First we must check if a book is for an Pickaxe or an Rod.
             */
            switch (enchant) {

                /*
                First register all books for the Pickaxe
                 */
                case "§6§lRausch":
                case "§6§lZorn":
                case "§6§lLaser":
                case "§6§lDuplizierung":
                case "§6§lErfahrung":
                case "§6§lAusgrabung":
                case "§6§lBlock-Counter":
                    /*
                    So if we are here our book is for an Pickaxe.
                    Let's check if our item is a Pickaxe too.
                     */
                    switch (item1.getType()) {
                        case DIAMOND_PICKAXE:
                        case IRON_PICKAXE:
                        case GOLD_PICKAXE:
                        case STONE_PICKAXE:
                        case WOOD_PICKAXE:
                            isenchantforitem = true; //Congrulation the item is for the enchant
                    }
                    break;

                /*
                To secure that nothing goes wrong we list all Rod Enchants here too.
                 */
                case "§6§lGroßer Fang":
                case "§6§lFischerglück":
                case "§6§lGoldhaken":
                    /*
                    So we are here, finally.
                    Now Check if our item is a Rod.
                     */
                    if(item1.getType() == Material.FISHING_ROD) {
                        isenchantforitem = true; //The enchant is for our item
                    }

            }
        }

        else if(enchant.startsWith("§c§l")) {
            /*
            This book is an sword only book.
            So register all swords in the Game.
             */
            switch (item1.getType()) {
                case DIAMOND_SWORD:
                case IRON_SWORD:
                case GOLD_SWORD:
                case STONE_SWORD:
                case WOOD_SWORD:
                    isenchantforitem = true; //The enchant is for our item
                    break;
            }
        }

        return isenchantforitem;
    }

    /**
     * Get the Enchantment Type from lore enchant
     * @param lore enchant from item lore
     * @return Enchament to enchant and check max level
     */
    private Enchantment getVanillaEnchant(String lore) {

        switch (lore) {
            case "§7Verbrennung":
                return Enchantment.FIRE_ASPECT;
            case "§7Schärfe":
                return Enchantment.DAMAGE_ALL;
            case "§7Schutz":
                return Enchantment.PROTECTION_ENVIRONMENTAL;
            case "§7Stärke":
                return Enchantment.ARROW_DAMAGE;
            case "§7Effizienz":
                return Enchantment.DIG_SPEED;
            case "§7Haltbarkeit":
                return Enchantment.DURABILITY;
            case "§7Explosionsschutz":
                return Enchantment.PROTECTION_EXPLOSIONS;
            case "§7Schusssicher":
                return Enchantment.PROTECTION_PROJECTILE;
            case "§7Feuerschutz":
                return Enchantment.PROTECTION_FIRE;
            case "§7Bann":
                return Enchantment.DAMAGE_ARTHROPODS;
            case "§7Nemesis der Gliederfüßler":
                return Enchantment.DAMAGE_UNDEAD;
            case "§7Wasserläufer":
                return Enchantment.DEPTH_STRIDER;
            case "§7Rückstoß":
                return Enchantment.KNOCKBACK;
            case "§7Wasseraffinität":
                return Enchantment.WATER_WORKER;
            case "§7Atmung":
                return Enchantment.OXYGEN;
            case "§7Dornen":
                return Enchantment.THORNS;
            default:
                return null;
        }

    }

    /**
     * Vanilla Enchantments has maximum enchant levels. Get them here.
     * @param enchant the Enchantment {@link org.bukkit.enchantments.Enchantment}
     * @return the maximum enchantmentlevel as int
     */
    private int getMaxLevelVanillaEnchants(Enchantment enchant) {
        if(enchant == Enchantment.FIRE_ASPECT) {
            return Enchantment.FIRE_ASPECT.getMaxLevel();
        } else if(enchant == Enchantment.DAMAGE_ALL) {
            return Enchantment.DAMAGE_ALL.getMaxLevel();
        } else if(enchant == Enchantment.ARROW_DAMAGE) {
            return Enchantment.ARROW_DAMAGE.getMaxLevel();
        } else if(enchant == Enchantment.PROTECTION_ENVIRONMENTAL) {
            return Enchantment.PROTECTION_ENVIRONMENTAL.getMaxLevel();
        } else if(enchant == Enchantment.DIG_SPEED) {
            return Enchantment.DIG_SPEED.getMaxLevel();
        } else if(enchant == Enchantment.DURABILITY) {
            return Enchantment.DURABILITY.getMaxLevel();
        } else if(enchant == Enchantment.PROTECTION_EXPLOSIONS) {
            return Enchantment.PROTECTION_EXPLOSIONS.getMaxLevel();
        } else if(enchant == Enchantment.PROTECTION_PROJECTILE) {
            return Enchantment.PROTECTION_PROJECTILE.getMaxLevel();
        } else if(enchant == Enchantment.PROTECTION_FIRE) {
            return Enchantment.PROTECTION_FIRE.getMaxLevel();
        } else if(enchant == Enchantment.DAMAGE_ARTHROPODS) {
            return Enchantment.DAMAGE_ARTHROPODS.getMaxLevel();
        } else if(enchant == Enchantment.DAMAGE_UNDEAD) {
            return Enchantment.DAMAGE_UNDEAD.getMaxLevel();
        } else if(enchant == Enchantment.DEPTH_STRIDER) {
            return Enchantment.DEPTH_STRIDER.getMaxLevel();
        } else if(enchant == Enchantment.KNOCKBACK) {
            return Enchantment.KNOCKBACK.getMaxLevel();
        } else if(enchant == Enchantment.WATER_WORKER) {
            return Enchantment.WATER_WORKER.getMaxLevel();
        } else if(enchant == Enchantment.OXYGEN) {
            return Enchantment.OXYGEN.getMaxLevel();
        } else if(enchant == Enchantment.THORNS) {
            return Enchantment.THORNS.getMaxLevel();
        } else {
            return 0;
        }
    }

    /**
     * Get the price for craft a book to an item
     * @param s the Level from the enchant as String
     * @return the price as float
     */
    protected float getPriceForItem(String s){
        int standard = 600000;
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

    /**
     * Get the price for craft books together
     * @param s the Level from the enchant as String
     * @return the price as float
     */
    protected float getPrice(String s){
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

    /**
     * Get the needed level to craft books together
     * @param s the Level from the enchant as String
     * @return the vanillalevel as int
     */
    protected int getLevel(String s){
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

    /**
     * Get the Level from a enchant of an item
     * @param item the item
     * @param enchant the enchant for the get level
     * @return level from an enchant as int
     */
    protected int getLevel(ItemStack item, String enchant) {

        List<String> lore = item.getItemMeta().getLore();

        for (String s : lore) {
            if (s.contains(enchant)) {
                return stringToNumber(s.replace(enchant + " ", ""));
            }
        }
        return 0;
    }

    /**
     * Get the enchant from a lore from an item.
     * This Method is only for an item with one lore line
     * @param item the item for the lore
     * @return the Enchant name {@link me.bluenitrox.school.enchants.EnchantManager}
     */
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

    /**
     * Get the enchant from a specified lore line from an item.
     * This Method is not for an item with one lore line.
     * @param item the item for the lore
     * @return the Enchant name {@link me.bluenitrox.school.enchants.EnchantManager}
     */
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

    /**
     * Get All Enchants from an item without Enchant Level
     * @param item the item for the lore
     * @return a List<String> with all Enchant Names
     * {@link me.bluenitrox.school.enchants.EnchantManager}
     */
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

    /**
     * Get the Enchant Level from an int
     * @param i the Enchant Level as int
     * @return the String Enchant Level
     */
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

    /**
     * Check if an item has an specified enchant
     * @param item the item for the lore
     * @param enchant the enchant which get checked
     * @return true if the item has the enchant
     */
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

    /**
     * Get the Enchant Level from an specified enchant
     * @param i the item for the lore
     * @param enchant the enchant for the enchant level
     * @return enchant level from enchant
     */
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

    /**
     * Get the Enchant Level as int
     * @param s the enchant name
     * @return the enchant level as int
     */
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

    /**
     * Return the Item which get set if all checks are done
     * @param price the price for an lore. Get it Later to remove Money after crafting
     * @param level the Vanilla Level for a lore. Get it Later to remove the Vanilla Level after crafting.
     * @return the item which get set
     */
    private ItemStack getSlimeBall(float price, int level) {
        String endprice = ValuetoString.valueToString(price);
        return new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §5§lItem Verzaubern").setLore("§8● §7Verzauberungskosten: ", " ", "§b" + endprice + " §7Gems", "§b" + level + " §7Vanilla-XP").build();
    }

    /**
     * Return item if the user has not enough Money
     * @param price the price for an lore. Get it Later to remove Money after crafting
     * @param level the Vanilla Level for a lore. Get it Later to remove the Vanilla Level after crafting.
     * @return the item which get set
     */
    private ItemStack getSlimeBallNoMoney(float price, int level) {
        String endprice = ValuetoString.valueToString(price);
        return new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §5§lItem Verzaubern").setLore("§8● §7Verzauberungskosten: ", " ", "§c" + endprice + " §7Gems", "§b" + level + " §7Vanilla-XP").build();
    }

    /**
     * Return item if the user has not enough Vanilla-XP
     * @param price the price for an lore. Get it Later to remove Money after crafting
     * @param level the Vanilla Level for a lore. Get it Later to remove the Vanilla Level after crafting.
     * @return the item which get set
     */
    private ItemStack getSlimeBallNoXP(float price, int level) {
        String endprice = ValuetoString.valueToString(price);
        return new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §5§lItem Verzaubern").setLore("§8● §7Verzauberungskosten: ", " ", "§b" + endprice + " §7Gems", "§c" + level + " §7Vanilla-XP").build();
    }

    /**
     * Return item if the user has not enough Vanilla-XP and Gems
     * @param price the price for an lore. Get it Later to remove Money after crafting
     * @param level the Vanilla Level for a lore. Get it Later to remove the Vanilla Level after crafting.
     * @return the item which get set
     */
    private ItemStack getSlimeBallNoXPAndNoMoney(float price, int level) {
        String endprice = ValuetoString.valueToString(price);
        return new ItemBuilder(Material.SLIME_BALL).setDisplayname("§8» §5§lItem Verzaubern").setLore("§8● §7Verzauberungskosten: ", " ", "§c" + endprice + " §7Gems", "§c" + level + " §7Vanilla-XP").build();
    }

    /**
     * Check if a book is a Special Enchantment book
     * @param item the item which get checked
     * @return true if it is a SpecialEnchantment
     */
    private boolean isSpezialEnchant(ItemStack item) {
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6§lMagisches Buch")) return true;
        else return false;
    }

    /**
     * Check if a book is a Vanilla Enchantment book
     * @param item the item which get checked
     * @return true if it is a Vanilla Enchantment
     */
    private boolean isVanillaEnchant(ItemStack item) {
        if(item.getItemMeta().getDisplayName().equalsIgnoreCase("§5Verzaubertes Buch")) return true;
        else return false;
    }

    /**
     * Run this Method on an anvil inventory item change
     * @param inventory the inventory from the anvil from an specified User.
     * @param player the specified Player.
     */
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
