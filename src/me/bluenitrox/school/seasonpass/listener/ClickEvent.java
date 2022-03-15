package me.bluenitrox.school.seasonpass.listener;

import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.seasonpass.SeasonpassInventorys;
import me.bluenitrox.school.seasonpass.SeasonpassManager;
import me.bluenitrox.school.seasonpass.SeasonpassRewardManager;
import me.bluenitrox.school.utils.Antidupe;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.LinkedList;

public class ClickEvent implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if(event.getClickedInventory() == null) return;
        if(event.getClickedInventory().getName().equalsIgnoreCase("§b» §6Seasonpass §8(§7Season 1§8)")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;

            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            SeasonpassInventorys inventorys = new SeasonpassInventorys(player);
            if (event.getCurrentItem().getType() == Material.CHEST) {

                SeasonpassManager seasonpassManager = new SeasonpassManager();
                SeasonpassRewardManager seasonpassRewardManager = new SeasonpassRewardManager();
                int items; //items is the number for the open rewards from a User
                if(seasonpassManager.hasGoldPass(player.getUniqueId())) {
                    //Do this if the User has the GoldPass
                    items = seasonpassRewardManager.getItems(player.getUniqueId()).size() + seasonpassRewardManager.getGoldPassItems(player.getUniqueId()).size();
                } else {
                    //Do this if the User don't has the GoldPass
                    items = seasonpassRewardManager.getItems(player.getUniqueId()).size();
                }

                if(items == 0) {
                    //check if a Reward is open. If not return
                    player.closeInventory();
                    player.sendMessage(MessageManager.PREFIX + "§7Du hast keine §6§loffenen Belohnungen§7.");
                    player.playSound(player.getLocation(), Sound.VILLAGER_NO, 1.0F, 1.0F);
                } else if(items == 1) {
                    //check if there is only one Reward open. If true, we clear all Rewards later
                    if(seasonpassRewardManager.getItems(player.getUniqueId()).size() == 1) { //check if there is a Reward open for the Defaultpass
                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            //Check if there is a free inventory Slot
                            if(player.getInventory().getItem(i) == null) {
                                //add Item to inventory
                                player.getInventory().addItem(Antidupe.addID(seasonpassRewardManager.getItem(seasonpassRewardManager.getItems(player.getUniqueId()).get(0))));
                                seasonpassRewardManager.resetItems(player.getUniqueId()); //reset all Items. Carefull! Every Item will be removed from the database
                                return; //return after this to get no issues with other methods
                            }
                        }
                    } else {
                        if(!seasonpassManager.hasGoldPass(player.getUniqueId())) return; //Check for Security. If the User has the Goldpass he can get this Reward
                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            //Check if there is a free inventory Slot
                            if(player.getInventory().getItem(i) == null) {
                                //add Item to inventory
                                player.getInventory().addItem(Antidupe.addID(seasonpassRewardManager.getItem(seasonpassRewardManager.getGoldPassItems(player.getUniqueId()).get(0))));
                                seasonpassRewardManager.resetGoldPassItems(player.getUniqueId()); //reset all Items. Carefull! Every Item will be removed from the database
                                return; //return after this to get no issues with other methods
                            }
                        }
                    }
                } else {
                    /*
                    set normal pass items to the inventory
                     */
                    //Get all inventory Slots with no Item on
                    if (seasonpassRewardManager.getItems(player.getUniqueId()).size() > 0) {
                        LinkedList<Integer> freeslots = new LinkedList<>();
                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            if (player.getInventory().getItem(i) == null) {
                                //add these free Slots in a List, get them later to check how much inventory slots are null
                                freeslots.add(i);
                            }
                        }
                        LinkedList<Integer> usedItemIds = new LinkedList<>(); //create a List, send it later to remove the itemids from the database
                        if (freeslots.size() <= seasonpassRewardManager.getItems(player.getUniqueId()).size()) { //check if the reward items List is bigger than the free inventory Slots
                            for (int i = 0; i < freeslots.size(); i++) {
                                //Get the itemid for the Item, to get the Item from Seasonpassrewardmanager
                                int itemID = seasonpassRewardManager.getItems(player.getUniqueId()).get(i);
                                player.getInventory().addItem(Antidupe.addID(seasonpassRewardManager.getItem(itemID))); //add Item to inventory
                                usedItemIds.add(i+1); //the i+1 is random and "useless"
                            }
                            seasonpassRewardManager.removeItems(player.getUniqueId(), usedItemIds.toString()); //say that the ids should be removed from the database
                        } else {
                            for (int i = 0; i < seasonpassRewardManager.getItems(player.getUniqueId()).size(); i++) {
                                //Get the itemid for the Item, to get the Item from Seasonpassrewardmanager
                                int itemID = seasonpassRewardManager.getItems(player.getUniqueId()).get(i);
                                player.getInventory().addItem(Antidupe.addID(seasonpassRewardManager.getItem(itemID))); //add Item to inventory
                                usedItemIds.add(i+1); //the i+1 is random and "useless"
                            }
                            seasonpassRewardManager.removeItems(player.getUniqueId(), usedItemIds.toString()); //say that the ids should be removed from the database
                        }
                    }
                    /*
                    set Gold Pass Items to the inventory
                     */
                    if(!seasonpassManager.hasGoldPass(player.getUniqueId())) return; //These Rewards are only for people which buyed the Goldpass. Return if they have no Goldpass

                    //Get all inventory Slots with no Item on
                    if(seasonpassRewardManager.getGoldPassItems(player.getUniqueId()).size() > 0) { //Check if there are Items to add, otherwise return
                        LinkedList<Integer> freeslots = new LinkedList<>();
                        for (int i = 0; i < player.getInventory().getSize(); i++) {
                            if (player.getInventory().getItem(i) == null) {
                                //add these free Slots in a List, get them later to check how much inventory slots are null
                                freeslots.add(i);
                            }
                        }
                        LinkedList<Integer> usedItemIds = new LinkedList<>(); //create a List, send it later to remove the itemids from the database
                        if (freeslots.size() <= seasonpassRewardManager.getGoldPassItems(player.getUniqueId()).size()) { //check if the reward items List is bigger than the free inventory Slots
                            for (int i = 0; i < freeslots.size(); i++) {
                                //Get the itemid for the Item, to get the Item from Seasonpassrewardmanager
                                int itemID = seasonpassRewardManager.getGoldPassItems(player.getUniqueId()).get(i);
                                player.getInventory().addItem(Antidupe.addID(seasonpassRewardManager.getGoldPassItem(itemID))); //add Item to inventory
                                usedItemIds.add(i+1); //the i+1 is random and "useless"
                            }
                            seasonpassRewardManager.removeGoldPassItems(player.getUniqueId(), usedItemIds.toString()); //say that the ids should be removed from the database
                        } else {
                            for (int i = 0; i < seasonpassRewardManager.getGoldPassItems(player.getUniqueId()).size(); i++) {
                                //Get the itemid for the Item, to get the Item from Seasonpassrewardmanager
                                int itemID = seasonpassRewardManager.getGoldPassItems(player.getUniqueId()).get(i);
                                player.getInventory().addItem(Antidupe.addID(seasonpassRewardManager.getGoldPassItem(itemID))); //add Item to inventory
                                usedItemIds.add(i+1); //the i+1 is not used later and "useless"
                            }
                            seasonpassRewardManager.removeItems(player.getUniqueId(), usedItemIds.toString()); //say that the ids should be removed from the database
                        }
                    }
                }

            } else if (event.getCurrentItem().getType() == Material.ENDER_CHEST) {
                SeasonpassManager seasonpassManager = new SeasonpassManager();
                if (seasonpassManager.hasGoldPass(player.getUniqueId())) {
                    player.openInventory(inventorys.bonusBank());
                }
            }
        } else if(event.getClickedInventory().getName().equalsIgnoreCase("§b» §6Seasonpass Bonusbank")) {
            if (event.getCurrentItem() == null) return;
            if (event.getCurrentItem().getItemMeta() == null) return;
            if (event.getCurrentItem().getItemMeta().getDisplayName() == null) return;
            event.setCancelled(true);
            if(event.getCurrentItem().getType() == Material.REDSTONE) {
                //open the default Page from the Seasonpass Inventory
                Player player = (Player) event.getWhoClicked();
                SeasonpassInventorys seasonpassInventorys = new SeasonpassInventorys(player);
                player.openInventory(seasonpassInventorys.normalPage());
            }
        }
    }

}
