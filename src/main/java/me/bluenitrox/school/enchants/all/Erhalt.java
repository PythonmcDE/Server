package me.bluenitrox.school.enchants.all;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ItemBuilder;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.security.acl.Owner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class Erhalt extends EnchantAPI {

    public static HashMap<UUID, ItemStack> items = new HashMap<>();


    public static void giveItem(Player owner, ArrayList<ItemStack> itemsinv){
        Inventory inv = vrInventory(itemsinv);
        for(int i = 0; i< owner.getInventory().getSize();i++) {
            if (inv.getItem(i) != null) {
                if (inv.getItem(i).getItemMeta() != null) {
                    if (inv.getItem(i).getItemMeta().getLore() != null) {
                        if (hasEnchant(inv.getItem(i), EnchantManager.Erhalt)) {
                            if (makeOrNot80(stringToNumber(inv.getItem(i), EnchantManager.Erhalt))) {

                                ItemStack is = inv.getItem(i);
                                ItemMeta im = is.getItemMeta();
                                List<String> imn = im.getLore();
                                ArrayList<String> lore = new ArrayList<String>();
                                lore.addAll(imn);
                                lore.remove("§f§lErhalt ");
                                im.setLore(lore);
                                is.setItemMeta(im);

                                itemStackinDatabase(owner.getUniqueId(), encodeItem(is));
                                inv.setItem(i, new ItemBuilder(Material.AIR).build());
                            }
                        }
                    }
                }
            }
        }
        for(int in = 0; in < inv.getSize(); in++){
            if (inv.getItem(in) != null) {
                Bukkit.getWorld(owner.getWorld().getName()).dropItem(owner.getLocation(), inv.getItem(in));
            }
        }
    }

    /*private static String getErhaltLevel(ItemStack is){
        String[] level = is.getItemMeta().getLore().get();
        return level;
    }*/

    private static Inventory vrInventory(ArrayList<ItemStack> items){
        Inventory returninv = Bukkit.createInventory(null, 9*5, "Name");

        for(int i = 0; i < items.size(); i++){
            returninv.setItem(i, items.get(i));
        }

        return returninv;
    }

    private static void itemStackinDatabase(UUID uuid, String item){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO erhaltitems (UUID, item) VALUES (?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setString(2, item);
            ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM erhaltitems WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static int isUserExistsFetch(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM erhaltitems WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            int size = 0;
            while (rs.next()){
                size++;
            }
            return size;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static boolean deleteItem(String item) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE FROM erhaltitems WHERE item = ?");
            ps.setString(1, item);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getItemErhalt(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT item FROM erhaltitems WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("item");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encodeItem(ItemStack itemStack) { //String aus ItemStack
        YamlConfiguration config = new YamlConfiguration();
        config.set("i", itemStack);
        return config.saveToString();
    }

    public static ItemStack decodeItem(String string) { //ItemsStack aus String
        YamlConfiguration config = new YamlConfiguration();
        try {
            config.loadFromString(string);
        } catch (IllegalArgumentException | InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        return config.getItemStack("i", null);
    }

}
