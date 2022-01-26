package me.bluenitrox.school.ah;

import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AhListener implements Listener {

    public static String GUI_NAME = "§6§lAuktionen";
    public static String GUI_NAME1 = "§6§lAuktion §7kaufen";

    public static void onClickAuctionhouse(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if(e.getCurrentItem() != null) {
            if (e.getClickedInventory().getName().equalsIgnoreCase(GUI_NAME1)) {

                e.setCancelled(true);
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§lKaufen")) {
                    int line = e.getClickedInventory().getItem(3).getItemMeta().getLore().size() - 2;
                    String[] stringregex = e.getClickedInventory().getItem(3).getItemMeta().getLore().get(line).split(" ");
                    int id = Integer.parseInt(stringregex[2]);
                    AhManager.buyItem(id, p);
                    p.closeInventory();
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lAbbrechen")) {
                    Inventory invah = Bukkit.createInventory(null, 9 * 6, Ah_CMD.GUI_NAME);
                    AhManager.openAh(invah, 1, p);

                }
            } else if (e.getClickedInventory().getName().equals(GUI_NAME)) {

                e.setCancelled(true);
                if (e.getCurrentItem() == null) return;
                if (e.getCurrentItem().getType() == Material.SIGN) return;
                if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) return;
                if (e.getCurrentItem().getType() == Material.CHEST) {
                    Inventory invah = Bukkit.createInventory(null, 9 * 5, Ah_CMD.GUI_NAME);
                    AhManager.openAh(invah, 1, p);
                    return;
                } else if (e.getCurrentItem().getType() == Material.PAPER) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§7Nächste Seite")) {
                        String[] stringregex = e.getClickedInventory().getItem(4).getItemMeta().getLore().get(2).split(" ");
                        int currPage = Integer.parseInt(stringregex[3]);
                        int newPage = currPage + 1;

                        Inventory invah = Bukkit.createInventory(null, 9 * 6, GUI_NAME);

                        p.closeInventory();
                        AhManager.openabgelaufeneundgekaufteAuktionen(p, newPage, invah);

                        return;
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§7Vorherige Seite")) {
                        String[] stringregex = e.getClickedInventory().getItem(4).getItemMeta().getLore().get(2).split(" ");
                        int currPage = Integer.parseInt(stringregex[3]);
                        int newPage = currPage - 1;

                        Inventory invah = Bukkit.createInventory(null, 9 * 6, GUI_NAME);

                        p.closeInventory();
                        AhManager.openabgelaufeneundgekaufteAuktionen(p, newPage, invah);
                        return;

                    }
                } else {
                    int line = e.getCurrentItem().getItemMeta().getLore().size() - 2;
                    String[] stringregex = e.getCurrentItem().getItemMeta().getLore().get(line).split(" ");
                    int id = Integer.parseInt(stringregex[2]);
                    try (PreparedStatement ps1 = MySQL.getConnection().prepareStatement("SELECT * FROM AhItemsAbgelaufen WHERE id = ?")) {
                        ps1.setInt(1, id);
                        ResultSet rs = ps1.executeQuery();

                        while (rs.next()) {
                            ItemStack item = AhManager.decodeItem(rs.getString(3));
                            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM AhItemsAbgelaufen WHERE id = ?")) {
                                ps.setInt(1, id);
                                ps.execute();
                                Inventory invah = Bukkit.createInventory(null, 9 * 6, GUI_NAME);
                                AhManager.openabgelaufeneundgekaufteAuktionen(p, 1, invah);

                                p.sendMessage("§7Du hast dein Item ins Inventar bekommen!");
                                if (item.getType() != Material.DRAGON_EGG) {
                                    p.getInventory().addItem(item);
                                    p.closeInventory();
                                } else {
                                    ItemStack im = new ItemBuilder(Material.DRAGON_EGG).addEnchant(Enchantment.SILK_TOUCH, 10, false).setDisplayname(item.getItemMeta().getDisplayName()).setLore(item.getItemMeta().getLore()).build();
                                    p.getInventory().addItem(im);
                                }

                            } catch (SQLException exc) {
                                exc.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } else if (e.getClickedInventory().getName().equalsIgnoreCase(Ah_CMD.GUI_NAME) && e.getCurrentItem() != null) {

                e.setCancelled(true);
                if (e.getCurrentItem() == null) return;
                if (e.getCurrentItem().getItemMeta() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Abgelaufene §6Auktionen§7/§6Gekaufte §7Auktionen")) {
                            Inventory invah = Bukkit.createInventory(null, 9 * 6, GUI_NAME);
                            AhManager.openabgelaufeneundgekaufteAuktionen(p, 1, invah);
                            return;
                        }
                    }
                }
                if (e.getCurrentItem() == null) return;
                if (e.getCurrentItem().getType() == Material.SIGN) return;
                if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) return;
                if (e.getCurrentItem().getType() == Material.PAPER) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§7Nächste Seite")) {
                        String[] stringregex = e.getClickedInventory().getItem(4).getItemMeta().getLore().get(2).split(" ");
                        int currPage = Integer.parseInt(stringregex[3]);
                        int newPage = currPage + 1;

                        Inventory invah = Bukkit.createInventory(null, 9 * 6, Ah_CMD.GUI_NAME);

                        p.closeInventory();
                        AhManager.openAh(invah, newPage, p);

                        return;
                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§7Vorherige Seite")) {
                        String[] stringregex = e.getClickedInventory().getItem(4).getItemMeta().getLore().get(2).split(" ");
                        int currPage = Integer.parseInt(stringregex[3]);
                        int newPage = currPage - 1;

                        Inventory invah = Bukkit.createInventory(null, 9 * 6, Ah_CMD.GUI_NAME);

                        p.closeInventory();
                        AhManager.openAh(invah, newPage, p);
                        return;
                    }
                } else {
                    if(e.getCurrentItem().getItemMeta() != null) {
                        if (e.getCurrentItem().getItemMeta().getLore() != null) {
                            int line = e.getCurrentItem().getItemMeta().getLore().size() - 2;
                            String[] stringregex = e.getCurrentItem().getItemMeta().getLore().get(line).split(" ");
                            int id = Integer.parseInt(stringregex[2]);
                            Inventory buyinv = Bukkit.createInventory(null, InventoryType.BREWING, GUI_NAME1);
                            AhManager.openBuyInv(id, buyinv, p);
                        }
                    }
                }
            }
        }
    }
}