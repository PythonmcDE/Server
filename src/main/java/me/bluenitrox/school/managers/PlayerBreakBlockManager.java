package me.bluenitrox.school.managers;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mine.manager.MinenManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT bloecke FROM spielerdaten WHERE spieleruuid = ?")) {
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
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE spielerdaten SET bloecke = ? WHERE spieleruuid = ?")) {
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

        if(p.getItemInHand() != null && p.getItemInHand().getType() != Material.AIR){
            if(!p.getItemInHand().getItemMeta().spigot().isUnbreakable()) {
                if (EnchantmentTarget.TOOL.includes(p.getItemInHand()) || EnchantmentTarget.WEAPON.includes(p.getItemInHand())) {
                    int damge = p.getItemInHand().getType().getMaxDurability();
                    if (damge - p.getItemInHand().getDurability() == 0) {
                        p.setItemInHand(new ItemStack(Material.AIR));
                        p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1L, 1L);
                    } else {
                        if (p.getItemInHand().containsEnchantment(Enchantment.DURABILITY)) {
                            int zufall = SchoolMode.getRandomInt(SchoolMode.getLevel(p.getItemInHand(), Enchantment.DURABILITY));
                            if (zufall <= 5) {
                                p.getItemInHand().setDurability((short) (p.getItemInHand().getDurability() + 1));
                            }
                        } else
                            p.getItemInHand().setDurability((short) (p.getItemInHand().getDurability() + 1));
                    }
                }
            }

        }

        return true;

        //Schauen ob der Spieler abbauen darf
        //Blöcke updaten
        //Rewards und Luckyblocks
        //SpecialEnchants aktivieren
    }



}