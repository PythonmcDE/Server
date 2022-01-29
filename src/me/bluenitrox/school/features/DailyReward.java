package me.bluenitrox.school.features;

import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class DailyReward {

    public String guiname = "§8» §6Daily-Reward";

    public void onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        UUID uuid = p.getUniqueId();
        Inventory inv = Bukkit.createInventory(null,9*6,guiname);

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lDaily Reward").setLore("§6§l▶ §7Hier kannst du §6jeden Tag §7eine","§6§l▶ §7kostenlose §6Belohnung §7abholen","§cInfos: ","§8● §7Hole den Reward jeden Tag ab, um", "§8● §7täglich Belohnungen zu bekommen.").build();
        ItemStack glowdust = new ItemBuilder(Material.GLOWSTONE_DUST).setDisplayname("§8» §6Tägliche Belohnung").setLore("§8● §7Belohnung: §61000 Gems"," ", "§8● §aKlicke hier§7, zum §aAbholen§7.").build();
        ItemStack exp = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§8» §6Tägliche Erfahrung").setLore("§8● §7Belohnung: §61000 School XP"," ", "§8● §aKlicke hier§7, zum §aAbholen§7.").build();
        ItemStack minecraft = new ItemBuilder(Material.STORAGE_MINECART).setDisplayname("§8» §6Tägliche Case").setLore("§8● §7Belohnung: §61x Daily-Case"," ", "§8● §aKlicke hier§7, zum §aAbholen§7.").build();
        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§cDiesen Reward hast du heute schon abgeholt!").setLore("§8● §7Du hast deine Belohnung §7bereits abgeholt§7.").build();

        for(int i = 0; i<=8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i <=44; i++){
            inv.setItem(i,glas);
        }
        for(int i =45; i<= 53; i++){
            inv.setItem(i,glasblack);
        }
        inv.setItem(49,sign);
        if(getBelohnung(uuid) == 0) {
            inv.setItem(20, glowdust);
        }else {
            inv.setItem(20,barrier);
        }
        if(getErfahrung(uuid) == 0) {
            inv.setItem(22, exp);
        }else {
            inv.setItem(22,barrier);
        }
        if(getCase(uuid) == 0) {
            inv.setItem(24, minecraft);
        }else {
            inv.setItem(24,barrier);
        }

        p.openInventory(inv);
        return;
    }

    public void dailyRewardClick(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname)) {
            e.setCancelled(true);
            UUID uuid = e.getWhoClicked().getUniqueId();
            Player p = (Player) e.getWhoClicked();
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().getItemMeta() != null) {
                    if (e.getCurrentItem().getItemMeta().getDisplayName() != null) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Tägliche Belohnung")) {
                            updateBelohnung(uuid, 1, false);
                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            MoneyManager.updateMoney(uuid, 1000, false, true, false);
                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Tägliche Erfahrung")) {
                            updateErfahrung(uuid, 1, false);
                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            ExpManager.updateXP(uuid, 1000, false);
                        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §6Tägliche Case")) {
                            updateCase(uuid, 1, false);
                            p.closeInventory();
                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                            p.getInventory().addItem(Antidupe.addID(new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.daily).setLore("§8» §7Dieser §6§lFund §7verspricht dir",
                                    "§8» §5§lbesondere §6Belohnungen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build()));
                        }
                    }
                }
            }
        }
    }

    private int getBelohnung(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Belohnung FROM DailyReward WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Belohnung");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    private int getErfahrung(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Erfahrung FROM DailyReward WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Erfahrung");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    private int getCase(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Cases FROM DailyReward WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Cases");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    private void updateBelohnung(UUID uuid, float amount, boolean remove) {
        float currMoney = getBelohnung(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE DailyReward SET Belohnung = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateErfahrung(UUID uuid, float amount, boolean remove) {
        float currMoney = getErfahrung(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE DailyReward SET Erfahrung = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateCase(UUID uuid, float amount, boolean remove) {
        float currMoney = getCase(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE DailyReward SET Cases = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
