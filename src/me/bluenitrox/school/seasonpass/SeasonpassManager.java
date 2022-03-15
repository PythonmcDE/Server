package me.bluenitrox.school.seasonpass;

import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Warning;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.UUID;

public class SeasonpassManager {


    /**
     * Check if a User get a Seasonpass Level up
     * @param uuid from the player
     * @param xp the xp which should be added to the player
     */
    public void checkFortschrittUP(UUID uuid, int xp) {

        SeasonpassRewardManager rewardManager = new SeasonpassRewardManager();
        SeasonpassManager seasonpassManager = new SeasonpassManager();
        int fortschritt = this.getFortschritt(uuid);
        int neededXP = rewardManager.getNeededXp(fortschritt);
        if(xp >= neededXP) {
            //TODO add Item to the Inv
            rewardManager.addItem(uuid, fortschritt);
            rewardManager.addGoldPassItem(uuid, fortschritt);
            this.updateFortschritt(uuid, fortschritt+1);
        }

    }

    /**
     * Set the Fortschritt for a player into the database
     * @param uuid uuid from the player
     * @param fortschritt the new Fortschritt
     */
    public void updateFortschritt(UUID uuid, int fortschritt) {

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET fortschritt = ? WHERE UUID = ?");) {
            ps.setInt(1, fortschritt);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the xp that should be added in the database
     * @param uuid uuid from the player
     * @param xp the xp that should be edit
     */
    @Warning //You can add max 49 one time!!!
    public void addXP(UUID uuid, int xp) {

        int newXP = this.getXP(uuid) + xp;
        this.checkFortschrittUP(uuid, newXP);

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET xp = ? WHERE UUID = ?");) {
            ps.setInt(1, newXP);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Activate the Gold-Pass for a User
     * @param uuid from the player who get the Gold Pass
     */
    public void setGoldpass(UUID uuid) {

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET goldpass = ? WHERE UUID = ?");) {
            ps.setBoolean(1, true);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get the Seasonpass-XP from a player
     * @param uuid uuid from the player
     * @return the Seasonpass-XP from the player
     */
    public int getXP(UUID uuid) {

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT xp FROM seasonpass WHERE UUID = ?");) {
            ps.setString(1, uuid.toString());
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("xp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Get the
     * @param uuid
     * @return
     */
    public int getFortschritt(UUID uuid) {

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT fortschritt FROM seasonpass WHERE UUID = ?");) {
            ps.setString(1, uuid.toString());
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("fortschritt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Check if the User has the Gold Pass
     * @param uuid from the player
     * @return true if the user has the Gold Seasonpass
     */
    public boolean hasGoldPass(UUID uuid) {

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT goldpass FROM seasonpass WHERE UUID = ?");) {
            ps.setString(1, uuid.toString());
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                return resultSet.getBoolean("goldpass");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Set the User in the database if he is not existing
     * @param uuid from the User who get configuratet
     */
    public void configuratePlayer(UUID uuid) {
        if(isExist(uuid)) return;
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO seasonpass (UUID, goldpass, fortschritt, items, goldpassitems, xp) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setBoolean(2, false);
            ps.setInt(3, 1);
            ps.setString(4, new LinkedList<>().toString());
            ps.setString(5, new LinkedList<>().toString());
            ps.setInt(6, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Check if a User is already in the database. Otherwise configurate him
     * @param uuid from the User who got checked
     * @return true if he is existing. Otherwise return false
     */
    private boolean isExist(UUID uuid) {

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT UUID FROM seasonpass WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
