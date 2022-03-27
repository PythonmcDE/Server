package me.bluenitrox.school.crafting.anvil;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class AnvilListener implements Listener {

    Anvil anvil = new Anvil(); //Main Anvil System

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {

        if(event.getView().getTitle().equalsIgnoreCase("§5Verzauberungen")) {
            Inventory inventory = event.getInventory();
            Player player = (Player) event.getPlayer();

            //Put Items back to Player Inventory
            if(inventory.getItem(11) != null) {
                player.getInventory().addItem(inventory.getItem(11));
            }
            if(inventory.getItem(13) != null) {
                player.getInventory().addItem(inventory.getItem(13));
            }
        }
    }

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent event) {
        if(event.getView().getTitle().equalsIgnoreCase("§5Verzauberungen")) {
            for (int i : event.getRawSlots()) {
                if(i != 11 && i != 13 && i < 27) {
                    event.setCancelled(true);
                } else if(i == 11 || i == 13) {
                    //Update Inventory
                    anvil.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
                }
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        if(event.getView().getTitle().equalsIgnoreCase("§5Verzauberungen")) {
            InventoryAction action = event.getAction();
            if(event.getClickedInventory() != null) {
                if(event.getClickedInventory().getHolder() == null) {
                    //Main Amboss inv
                    if(event.getSlot() == 11 || event.getSlot() == 13) {
                        if(action == InventoryAction.PLACE_ALL) {
                            anvil.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else if(action == InventoryAction.PLACE_ONE) {
                            anvil.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else if(action == InventoryAction.PLACE_SOME) {
                            anvil.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else if(action == InventoryAction.SWAP_WITH_CURSOR) {
                            anvil.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else {
                            anvil.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
                        }
                    } else if(event.getSlot() == 15) {
                        Material Slimeball = Material.SLIME_BALL;
                        if(event.getCurrentItem() != null) {
                            if(event.getCurrentItem().getType() == Slimeball) {
                                if (action == InventoryAction.HOTBAR_SWAP || action == InventoryAction.HOTBAR_MOVE_AND_READD || action == InventoryAction.SWAP_WITH_CURSOR) {
                                    event.setCancelled(true);
                                } else {
                                    ItemStack craftitem = event.getClickedInventory().getItem(15);
                                    if(craftitem.getItemMeta().getLore().get(2).startsWith("§c") || craftitem.getItemMeta().getLore().get(3).startsWith("§c")) {
                                        event.setCancelled(true);
                                    } else {
                                        event.setCancelled(true);
                                        ItemStack item1 = event.getClickedInventory().getItem(11);
                                        ItemStack item2 = event.getClickedInventory().getItem(13);

                                        if(item1.getType() == Material.ENCHANTED_BOOK && item2.getType() == Material.ENCHANTED_BOOK) {
                                            /*
                                            both Items are books
                                             */
                                            anvil.craftBooksTogether(event.getClickedInventory(), (Player) event.getWhoClicked());
                                        } else if(item1.getType() != Material.ENCHANTED_BOOK && item2.getType() == Material.ENCHANTED_BOOK) {
                                            /*
                                            craft an book on an item
                                             */
                                            anvil.craftBookOnItem(event.getClickedInventory(), (Player) event.getWhoClicked());
                                        } else {
                                            /*
                                            we craft erhalt or Verhärtung together
                                             */
                                            anvil.craftSpecialOnItem(event.getClickedInventory(), (Player) event.getWhoClicked());
                                        }
                                        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§cUngültige Verzauberung").setLore("§b» §7Bitte überprüfe deine Items").build();
                                        event.getClickedInventory().setItem(15, barrier);
                                    }
                                }
                            } else {
                                event.setCancelled(true);
                            }
                        } else {
                            event.setCancelled(true);
                        }
                    } else {
                        // Shift-Click
                        if (action == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                            if (event.getCurrentItem() != null) {
                                Material BSG = Material.STAINED_GLASS_PANE;
                                Material ItemType = event.getCurrentItem().getType();
                                if (ItemType == BSG) {
                                    event.setCancelled(true);
                                }else {
                                    anvil.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
                                }
                            }else {
                                event.setCancelled(true);
                            }
                        }else {
                            event.setCancelled(true);
                        }

                    }
                } else {
                    if (action == InventoryAction.MOVE_TO_OTHER_INVENTORY) {
                        if (event.getCurrentItem() != null) {
                            Material BSG = Material.STAINED_GLASS_PANE;
                            Material ItemType = event.getCurrentItem().getType();
                            if (ItemType == BSG) {
                                event.setCancelled(true);
                            }else {
                                Boolean needUpdate = true;
                                if (event.getView().getTopInventory().getItem(15) != null) {
                                    if (event.getCurrentItem() != null) {
                                        if (event.getView().getTopInventory().getItem(15).isSimilar(event.getCurrentItem())) {
                                            needUpdate = false;
                                            event.setCancelled(true);
                                        }
                                    }

                                }
                                if (needUpdate) {
                                    anvil.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public Inventory anvilInv() {

        Inventory inventory = Bukkit.createInventory(null, 9*3, "§5Verzauberungen");
        ItemStack glass = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 15).setDisplayname(" ").build();
        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§cUngültige Verzauberung").setLore("§b» §7Bitte überprüfe deine Items").build();

        for(int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, glass);
        }

        inventory.setItem(11, null);
        inventory.setItem(13, null);
        inventory.setItem(15, barrier);

        return inventory;
    }

}
