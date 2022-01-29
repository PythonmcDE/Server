package me.bluenitrox.school.haendler;

import me.bluenitrox.school.features.DailyReward;
import me.bluenitrox.school.haendler.commands.*;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class HändlerAPI implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player) cs;
        DailyReward dr = new DailyReward();

        if(CombatAPI.fight != null) {
            if (CombatAPI.fight.containsKey(p)) {
                p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                p.sendMessage(MessageManager.CANTDOINFIGHT);
                return true;
            }
        }

        if (args.length == 1) {
            if (p.hasPermission(PermissionsManager.NPCS)) {
                if (args[0].equalsIgnoreCase("schmied")) {
                    Schmied.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("koch")) {
                    Koch.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("abenteurer")) {
                    Abenteurer.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("bauarbeiter")) {
                    Bauarbeiter.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("bergmann")) {
                    Bergmann.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("Förster")) {
                    Förster.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("Gärtner")) {
                    Gärtner.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("Landwirt")) {
                    Landwirt.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("künstlerin")) {
                    Künstlerin.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("Magier")) {
                    Magier.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("techniker")) {
                    Techniker.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("Jäger")) {
                    Jäger.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("dailyreward")) {
                    dr.onCommand(cs, cmd, s, args);
                } else if (args[0].equalsIgnoreCase("taxi")) {
                    Taxi.onCommand(cs, cmd, s, args);
                }
            }
        }

        return false;
    }

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
                                    p.closeInventory();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
