package me.bluenitrox.school.features;

import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class PetAPI {

    public int getPet(UUID uuid,String pet) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT " + pet +" FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt(pet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public int getBenjamin(UUID uuid) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Benjamin FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Benjamin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public int getMerlin(UUID uuid) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Merlin FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Merlin");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public int getEddy(UUID uuid) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Eddy FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Eddy");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public int getAnton(UUID uuid) {
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Anton FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Anton");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public int getHelgar(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Helgar FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Helgar");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public int getFarid(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Farid FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Farid");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public int getPeter(UUID uuid){
        int xp = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT Peter FROM PetSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Peter");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public void updatePet(UUID uuid, float amount, boolean remove, String pet) {
        float currMoney = getPet(uuid,pet);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET " + pet +" = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateBenjamin(UUID uuid, float amount, boolean remove) {
        float currMoney = getBenjamin(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET Benjamin = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMerlin(UUID uuid, float amount, boolean remove) {
        float currMoney = getMerlin(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET Merlin = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEddy(UUID uuid, float amount, boolean remove) {
        float currMoney = getEddy(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET Eddy = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAnton(UUID uuid, float amount, boolean remove) {
        float currMoney = getAnton(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET Anton = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHelgar(UUID uuid, float amount, boolean remove) {
        float currMoney = getHelgar(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET Helgar = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFarid(UUID uuid, float amount, boolean remove) {
        float currMoney = getFarid(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET Farid = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePeter(UUID uuid, float amount, boolean remove) {
        float currMoney = getPeter(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE PetSystem SET Peter = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public EntityType itemToEntity(ItemStack item){
        if(item != null){
            if(item.getDurability() == 67){
                return EntityType.ENDERMITE;
            }else if(item.getDurability() == 65){
                return EntityType.BAT;
            }else if(item.getDurability() == 62){
                return EntityType.MAGMA_CUBE;
            }else if(item.getDurability() == 98){
                return EntityType.OCELOT;
            }else if(item.getDurability() == 93){
                return EntityType.CHICKEN;
            }else if(item.getDurability() == 95){
                return EntityType.WOLF;
            }else if(item.getDurability() == 101){
                return EntityType.RABBIT;
            }
        }
        return null;
    }

}
