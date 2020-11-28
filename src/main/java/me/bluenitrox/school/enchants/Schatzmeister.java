package me.bluenitrox.school.enchants;

import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.ByteArrayInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Random;

public class Schatzmeister {

    public static void giveInventorySchatzmeister(Player p, Inventory inv, Player inventoryowner, PlayerDeathEvent e){
        if(p.getItemInHand() != null) {
            if (p.getItemInHand().getItemMeta() != null) {
                if(p.getItemInHand().getItemMeta().getLore() != null) {
                    if (p.getItemInHand().getItemMeta().getLore().contains(EnchantManager.schatzmeister)) {
                        ItemStack chest = new ItemBuilder(Material.CHEST).setDisplayname("§cInventar von §b" + inventoryowner.getDisplayName()).setLore("§8§l» §7Rechtsklicke die Kiste um die Items", "§8§l» §7deines §cGegners §7zu bekommen!").build();

                        NBTTags nbt = new NBTTags(chest);
                        nbt.setNBTTag("itemsiddata", putInDatabase(inv) +" ID");

                        p.getInventory().addItem(Antidupe.addID(chest));
                        e.setDroppedExp(0);
                        e.setKeepInventory(true);
                        inventoryowner.getInventory().clear();
                    }
                }
            }
        }
    }

    public static void openInventory(Player p, PlayerInteractEvent e){
        if(p.getItemInHand().getType() == Material.CHEST){
            if(p.getItemInHand().getItemMeta().getDisplayName().startsWith("§cInventar von §b")){
                NBTTags nbt = new NBTTags(p.getItemInHand());
                String[] idarray = nbt.getNBTTag("itemsiddata").toString().split(" ");
                String[] idarrayend = idarray[0].split("\"");
                Inventory inv = Schatzmeister.stringToInventory(Schatzmeister.getItems(Integer.parseInt(idarrayend[1])));

                Inventory invend = Bukkit.createInventory(null, 9*3, "§cInventar");

                for(int i = 0; i < 27; i++){
                    invend.setItem(i, inv.getItem(i));
                }

                p.openInventory(invend);
                p.setItemInHand(new ItemBuilder(Material.AIR).build());
                deleteItems(Integer.parseInt(idarrayend[1]));
                return;
            }
        }
        e.setCancelled(true);
    }

    private static int putInDatabase(Inventory inv){
        boolean check = false;
        int id = 0;
        while(!check) {
            id = new Random().nextInt(1000000);
            if (!isIDExists(id)) {
                check = true;
            }
        }
        update(id, inventoryToString(inv));
        return id;
    }

    public static String inventoryToString(Inventory inventory) {
        try {
            ByteArrayOutputStream str = new ByteArrayOutputStream();
            BukkitObjectOutputStream data = new BukkitObjectOutputStream(str);
            data.writeInt(inventory.getSize());
            data.writeObject(inventory.getName());
            for (int i = 0; i < inventory.getSize(); i++) {
                data.writeObject(inventory.getItem(i));
            }
            data.close();
            return Base64.getEncoder().encodeToString(str.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Inventory stringToInventory(String inventoryData) {
        try {
            ByteArrayInputStream stream = new ByteArrayInputStream(Base64.getDecoder().decode(inventoryData));
            BukkitObjectInputStream data = new BukkitObjectInputStream(stream);
            Inventory inventory = Bukkit.createInventory(null, data.readInt(), data.readObject().toString());
            for (int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, (ItemStack) data.readObject());
            }
            data.close();
            return inventory;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getItems(int id){
        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Items FROM schatzmeister WHERE ID = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getString("Items");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void update(int id, String s) {
        if(!isIDExists(id)) {
            try {
                PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO schatzmeister (ID, Items) VALUES (?,?)");
                ps.setInt(1, id);
                ps.setString(2, s);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE schatzmeister SET Items = ? WHERE ID = ?");
                ps.setInt(1, id);
                ps.setString(2, s);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteItems(int id) {
        if(isIDExists(id)) {
            try {
                PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE Items FROM schatzmeister WHERE ID = ?");
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean isIDExists(int id){
        try(PreparedStatement ps1 = MySQL.getConnection().prepareStatement("SELECT Items FROM schatzmeister WHERE ID = ?")){
            ps1.setInt(1, id);
            ResultSet rs = ps1.executeQuery();
            return rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}
