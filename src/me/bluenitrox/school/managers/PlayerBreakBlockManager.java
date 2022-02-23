package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.Build;
import me.bluenitrox.school.enchants.pickaxe.Zorn;
import me.bluenitrox.school.mine.manager.MinenManager;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PlayerBreakBlockManager {

    static MinenManager manager = new MinenManager();

    public static int getBlocks(UUID uuid) {
        return SchoolMode.getPlayerBlocks(uuid);
    }

    public static int getBlocksDatabase(UUID uuid) {
        int blocks = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT bloecke FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                blocks = rs.getInt("bloecke");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return blocks;
    }

    public static boolean updateBlocks(UUID uuid, boolean remove) {
        int blocks = getBlocks(uuid);
        if(remove) {
            if(blocks <= 1) {
                blocks = blocks - 1;
            }else {
                return false;
            }
        }else {
            blocks = blocks + 1;
        }
        SchoolMode.setPlayerBlocks(uuid, blocks);
        return true;
    }

    public static boolean updateBlocksDatabase(UUID uuid, boolean remove) {
        int blocks = getBlocks(uuid);
        if(remove) {
            if(blocks <= 1) {
                blocks = blocks - 1;
            }else {
                return false;
            }
        }else {
            blocks = blocks + 1;
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE spielerdaten SET bloecke = ? WHERE spieleruuid = ?")) {
            ps.setFloat(1, blocks);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean breakBlock(Player p, Location loc) {
        if (!manager.updateMinenMap(p, loc)) {
            return false;
        }

        Zorn.ZornAuslöser(p);


        return true;
    }


    private static void itemdestroyed(Player p){
        if(p.getInventory().getItemInHand() != null){
            Bukkit.broadcastMessage(""+p.getInventory().getItemInHand().getData().getItemType().getMaxDurability());
            int id = p.getInventory().getItemInHand().getData().getItemType().getMaxDurability();
            if(p.getInventory().getItemInHand().getItemMeta() != null) {

            }
        }
    }

}