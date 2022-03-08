package me.bluenitrox.school.haendler;

import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class HändlerAPI {


    public void onClickHändler(final InventoryClickEvent e) {
        if (e.getClickedInventory().getName().startsWith("§e§lHändler §8: §7§l")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                Player p = (Player) e.getWhoClicked();
                UUID uuid = p.getUniqueId();
                if (e.getClick().isLeftClick()) {
                    if (e.getClick().isShiftClick()) {
                        Material clickeditem = e.getCurrentItem().getType();
                        short dura = e.getCurrentItem().getDurability();
                        String diplayname = e.getCurrentItem().getItemMeta().getDisplayName();

                        String[] moneybuy = e.getCurrentItem().getItemMeta().getLore().get(0).split(" ");

                        int betrag = Integer.parseInt(moneybuy[2]);

                        if (MoneyManager.getMoney(uuid) >= betrag * 64) {
                            MoneyManager.updateMoney(uuid, betrag * 64, true, false);
                            p.getInventory().addItem(new ItemBuilder(clickeditem, dura).setDisplayname(diplayname).setAmount(64).build());
                            if(AufgabenManager.getTask(uuid) == 10) {
                                AufgabenManager.onComplete(uuid, 10);
                            }
                            p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                        } else {
                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                            p.closeInventory();
                        }
                    } else {
                        if (e.getCurrentItem().getItemMeta() != null) {
                            if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                                if (e.getCurrentItem().getItemMeta().getLore() != null) {
                                    Material clickeditem = e.getCurrentItem().getType();
                                    short dura = e.getCurrentItem().getDurability();
                                    String diplayname = e.getCurrentItem().getItemMeta().getDisplayName();

                                    String[] moneybuy = e.getCurrentItem().getItemMeta().getLore().get(0).split(" ");

                                    int betrag = Integer.parseInt(moneybuy[2]);

                                    if (MoneyManager.getMoney(uuid) >= betrag) {
                                        MoneyManager.updateMoney(uuid, betrag, true, false);
                                        p.getInventory().addItem(new ItemBuilder(clickeditem, dura).setDisplayname(diplayname).setAmount(1).build());
                                        if(AufgabenManager.getTask(uuid) == 10) {
                                            AufgabenManager.onComplete(uuid, 10);
                                        }
                                        p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                                    } else {
                                        p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                        p.closeInventory();
                                    }
                                }
                            }
                        }
                    }
                } else if (e.getClick().isRightClick()) {
                    if (e.getCurrentItem().getItemMeta() != null) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                            if (e.getCurrentItem().getItemMeta().getLore() != null) {
                                if (e.getCurrentItem().getItemMeta().getLore().size() > 1) {
                                    Material clickeditem = e.getCurrentItem().getType();
                                    short dura = e.getCurrentItem().getDurability();

                                    String[] moneysell = e.getCurrentItem().getItemMeta().getLore().get(1).split(" ");

                                    if(!e.getCurrentItem().getItemMeta().getLore().get(1).startsWith("§8» §7Verkaufen:§6")){
                                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                        p.sendMessage(MessageManager.PREFIX + "§7Das Item kannst du §cnicht §7verkaufen!");
                                        return;
                                    }

                                    int betrag = Integer.parseInt(moneysell[2]);

                                    for (int i = 0; i <= 35; i++) {
                                        if (p.getInventory().getItem(i) != null) {
                                            if (p.getInventory().getItem(i).getType() == clickeditem) {
                                                if (p.getInventory().getItem(i).getDurability() == dura) {
                                                    if (p.getInventory().getItem(i).getAmount() > 1) {
                                                        p.getInventory().getItem(i).setAmount(p.getInventory().getItem(i).getAmount() - 1);
                                                    } else if (p.getInventory().getItem(i).getAmount() == 1) {
                                                        ItemStack air = new ItemStack(Material.AIR);
                                                        p.getInventory().setItem(i, air);
                                                    }
                                                    MoneyManager.updateMoney(uuid, betrag, false, true);
                                                    p.playSound(p.getLocation(), Sound.VILLAGER_YES, 1L, 1L);
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    p.sendMessage(MessageManager.PREFIX + "§7Du hast §ckeins §7dieser Items.");
                                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
