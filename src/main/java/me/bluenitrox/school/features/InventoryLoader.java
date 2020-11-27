package me.bluenitrox.school.features;


import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.mysql.MySQL;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class InventoryLoader {

    public static boolean isUserExists(UUID uuid){
        try(PreparedStatement ps1 = MySQL.getConnection().prepareStatement("SELECT Inv FROM datatable WHERE UUID = ?")){
            ps1.setString(1, uuid.toString());
            ResultSet rs = ps1.executeQuery();
            return rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static void update(UUID uuid, String s) {
        if(!isUserExists(uuid)) {
            try {
                PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO datatable (UUID, Inv) VALUES (?,?)");
                ps.setString(1, uuid.toString());
                ps.setString(2, s);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE datatable SET Inv = ? WHERE UUID = ?");
                ps.setString(1, uuid.toString());
                ps.setString(2, s);
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getInv(UUID uuid){
        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Inv FROM datatable WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                return rs.getString("Inv");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadInv(Player p){
        TTA_Methods.sendActionBar(p, "§8» §7Inventar Sync §aabgeschlossen§7!", 20*3);
        new BukkitRunnable(){
            @Override
            public void run() {
                ItemStack[] list = new ItemStack[0];
                try {
                    list = decodeItem(getInv(p.getUniqueId())).getContents();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                //p.getInventory().setContents(list);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*3);
    }

    public static void deleteInv(UUID uuid) {
        if(isUserExists(uuid)) {
            try {
                PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE Inv FROM datatable WHERE UUID = ?");
                ps.setString(1, uuid.toString());
                ps.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String encodeItem(Inventory inventory) throws IllegalStateException {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);

            // Write the size of the inventory
            dataOutput.writeInt(inventory.getSize());

            // Save every element in the list
            for (int i = 0; i < inventory.getSize(); i++) {
                if(inventory.getItem(i) != null) {
                    dataOutput.writeObject(inventory.getItem(i));
                }
            }

            // Serialize that array
            dataOutput.close();
            return Base64Coder.encodeLines(outputStream.toByteArray());
        } catch (Exception e) {
            throw new IllegalStateException("Unable to save item stacks.", e);
        }
    }

    public static Inventory decodeItem(String data) throws IOException {
        try {
            ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
            BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
            Inventory inventory = Bukkit.getServer().createInventory(null, dataInput.readInt());

            // Read the serialized inventory
            for (int i = 0; i < inventory.getSize(); i++) {
                inventory.setItem(i, (ItemStack) dataInput.readObject());
            }

            dataInput.close();
            return inventory;
        } catch (ClassNotFoundException e) {
            throw new IOException("Unable to decode class type.", e);
        }
    }
}
