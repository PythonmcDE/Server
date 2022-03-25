package me.bluenitrox.school.listener;

import me.bluenitrox.school.event.AnvilOpenEvent;
import me.bluenitrox.school.haendler.npc.OutPut;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.checkerframework.checker.units.qual.A;

public class AnvilListener implements Listener {

    OutPut outPut = new OutPut();

    @EventHandler
    public void onAnvil(AnvilOpenEvent event) {

        Player player = event.getPlayer();
        ItemStack item1 = event.getItem1();
        ItemStack item2 = event.getItem2();
        Inventory inventory = event.getInventory();

        Bukkit.broadcastMessage("1");
        if(item1 == null || item2 == null) return;
        Bukkit.broadcastMessage("Ja");

    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {

        if(event.getView().getTitle().equalsIgnoreCase("§5Verzauberungen")) {
            Inventory inventory = event.getInventory();
            Player player = (Player) event.getPlayer();

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
                    outPut.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
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
                            outPut.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else if(action == InventoryAction.PLACE_ONE) {
                            outPut.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else if(action == InventoryAction.PLACE_SOME) {
                            outPut.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else if(action == InventoryAction.SWAP_WITH_CURSOR) {
                            outPut.update(event.getClickedInventory(), (Player) event.getWhoClicked());
                        } else {
                            outPut.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
                        }
                    } else if(event.getSlot() == 15) {
                        Material Slimeball = Material.SLIME_BALL;
                        if(event.getCurrentItem() != null) {
                            if(event.getCurrentItem().getType() == Slimeball) {
                                if (action == InventoryAction.HOTBAR_SWAP || action == InventoryAction.HOTBAR_MOVE_AND_READD || action == InventoryAction.SWAP_WITH_CURSOR) {
                                    event.setCancelled(true);
                                } else {
                                    //TODO
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
                                    //TODO
                                    outPut.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
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
                                    outPut.update(event.getView().getTopInventory(), (Player) event.getWhoClicked());
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
