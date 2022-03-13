package me.bluenitrox.school.seasonpass;

import me.bluenitrox.school.mine.reward.Reward;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Warning;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.UUID;

public class SeasonpassManager {


    public void checkFortschrittUP(UUID uuid, int xp) {

        SeasonpassRewardManager rewardManager = new SeasonpassRewardManager();
        int fortschritt = this.getFortschritt(uuid);
        int neededXP = rewardManager.getNeededXp(fortschritt);
        if(xp >= neededXP) {
            //TODO add Item to the Inv
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

    public void configuratePlayer(UUID uuid) {
        if(isExist(uuid)) return;
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO seasonpass (UUID, goldpass, fortschritt, items, xp) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setBoolean(2, false);
            ps.setInt(3, 1);
            ps.setString(4, new LinkedList<>().toString());
            ps.setInt(5, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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
