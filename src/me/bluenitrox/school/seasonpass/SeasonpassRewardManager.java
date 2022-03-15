package me.bluenitrox.school.seasonpass;

import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class SeasonpassRewardManager {

    /**
     * Set all Displaynames from the Reward Items from the Default Pass in this HashMap
     * @param Integer the reward number
     * @return the Displayname from the Item which the user got as Reward
     */
    private HashMap<Integer, String> normalRewards = new HashMap<>();

    /**
     * Set all Displaynames from the Reward Items from the Goldpass in this HashMap
     * @param Integer the reward number
     * @return the Displayname from the Item which the user got as Reward
     */
    private HashMap<Integer, String> goldRewards = new HashMap<>();


    /**
     * @param reward the Seasonpasslevel for the xp requested XP
     * @return the normal Reward for the requestes task
     */
    public String getNormalSeason1Reward(int reward) {
        return normalRewards.get(reward);
    }

    /**
     * @param reward the Seasonpasslevel for the xp requested XP
     * @return the gold Reward for the requestes task
     */
    public String getGoldSeason1Reward(int reward) {
        return goldRewards.get(reward);
    }

    /**
     * @param reward the Seasonpasslevel for the xp requested XP
     * @return the needed Xp for the task
     */
    public int getNeededXp(int reward) {
        return defaultXP * reward;
    }

    private final int defaultXP = 50;

    /**
     * Use this to get the reward for an Seasonpass Lvl Up
     * @param itemid is the Seasonpass Task
     * @return the item which the player gets
     */
    public ItemStack getItem(int itemid) {

        ItemStack itemStack = null;
        switch (itemid) {

            case 1:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("1").build();
                break;
            case 2:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("2").build();
                break;
            case 3:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("3").build();
                break;
            case 4:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("4").build();
                break;
            case 5:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("5").build();
                break;
            case 6:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("6").build();
                break;
            case 7:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("7").build();
                break;
            case 8:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 9:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 10:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 11:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 12:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 13:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 14:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 15:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 16:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 17:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 18:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 19:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 20:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 21:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 22:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 23:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 24:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 25:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 26:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 27:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 28:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 29:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 30:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 31:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 32:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 33:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 34:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 35:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 36:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 37:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 38:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 39:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 40:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 41:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 42:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 43:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 44:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 45:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
        }
        return itemStack;
    }

    /**
     * Use this to get the Goldpass reward for an Seasonpass Lvl Up
     * @param itemid is the Seasonpass Task
     * @return the item which the player gets
     */
    public ItemStack getGoldPassItem(int itemid) {

        ItemStack itemStack = null;
        switch (itemid) {

            case 1:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 2:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 3:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 4:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 5:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 6:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 7:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 8:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 9:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 10:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 11:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 12:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 13:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 14:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 15:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 16:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 17:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 18:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 19:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 20:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 21:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 22:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 23:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 24:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 25:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 26:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 27:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 28:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 29:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 30:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 31:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 32:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 33:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 34:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 35:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 36:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 37:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 38:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 39:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 40:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 41:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 42:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 43:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 44:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
            case 45:
                itemStack = new ItemBuilder(Material.DIAMOND_SWORD).build();
                break;
        }
        return itemStack;
    }


    /**
     * Delete all int Arrays with the items (use only if the player has 1 item yet)
     * @param uuid from the player who get the items removed
     */
    public void resetItems(UUID uuid) {

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET items = ? WHERE UUID = ?")) {
            ps.setString(1, new LinkedList<>().toString());
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Remove a specified number of rewards
     * @param uuid from the player who get the items removed
     * @param itemids LinkedList<Integer> which has the amount how much Items should be removed
     */
    public void removeItems(UUID uuid, String itemids) {
        LinkedList<Integer> items = this.getItems(uuid);

        if(items.toString().equalsIgnoreCase(itemids)) {
            items.clear();
        } else {
            for(String string : itemids.replace("[", "").replace("]", "").split(", ")) {
                items.remove(0);
            }
        }

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET items = ? WHERE UUID = ?")) {
            ps.setString(1, items.toString());
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Remove a specified number of rewards from the Goldpass Items
     * @param uuid from the player who get the items removed
     * @param itemids LinkedList<Integer> which has the amount how much Items should be removed
     */
    public void removeGoldPassItems(UUID uuid, String itemids) {
        LinkedList<Integer> items = this.getItems(uuid);

        if(items.toString().equalsIgnoreCase(itemids)) {
            items.clear();
        } else {
            for(String string : itemids.replace("[", "").replace("]", "").split(", ")) {
                items.remove(0);
            }
        }

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET goldpassitems = ? WHERE UUID = ?")) {
            ps.setString(1, items.toString());
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete all int Arrays with the items from the Goldpass (use only if the player has 1 item yet)
     * @param uuid from the player who get the items removed
     */
    public void resetGoldPassItems(UUID uuid) {

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET goldpassitems = ? WHERE UUID = ?")) {
            ps.setString(1, new LinkedList<>().toString());
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Give the user his reward from the normal Seasonpass for a Level Up
     * @param uuid from the player who gets the item
     * @param itemid this is the old "Fortschritt" int from the player
     */
    public void addItem(UUID uuid, int itemid) {

        LinkedList<Integer> items = this.getItems(uuid);
        items.add(itemid);

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET items = ? WHERE UUID = ?")) {
            ps.setString(1, items.toString());
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Give the user his reward from the Gold Seasonpass for a Level Up
     * @param uuid from the player who gets the item
     * @param itemid this is the old "Fortschritt" int from the player
     */
    public void addGoldPassItem(UUID uuid, int itemid) {

        LinkedList<Integer> items = this.getGoldPassItems(uuid);
        items.add(itemid);

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE seasonpass SET goldpassitems = ? WHERE UUID = ?")) {
            ps.setString(1, items.toString());
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Select all item ids for reward from the nomal pass
     * @param uuid from the player who gets the rewards later
     * @return an LinkedList with ids for this.getItem
     */
    public LinkedList<Integer> getItems(UUID uuid) {
        LinkedList<Integer> items = new LinkedList<>();

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT items FROM seasonpass WHERE UUID = ?");) {
            ps.setString(1, uuid.toString());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                String s = resultSet.getString("items");
                if(s != null && !s.equalsIgnoreCase("[]")) {
                    for (String string : s.replace("[", "").replace("]", "").split(", ")) {
                        items.add(Integer.parseInt(string.trim()));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    /**
     * Select all item ids for reward from the Goldpass
     * @param uuid from the player who gets the rewards later
     * @return an LinkedList with ids for this.getGoldPassItem
     */
    public LinkedList<Integer> getGoldPassItems(UUID uuid) {
        LinkedList<Integer> items = new LinkedList<>();

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT goldpassitems FROM seasonpass WHERE UUID = ?");) {
            ps.setString(1, uuid.toString());
            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()) {
                String s = resultSet.getString("goldpassitems");
                if(s != null && !s.equalsIgnoreCase("[]")) {
                    for (String string : s.replace("[", "").replace("]", "").split(", ")) {
                        items.add(Integer.parseInt(string.trim()));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;

    }

    /**
     * register all Season Rewards
     */
    public void registerSeasonpassRewards() {
        normalRewards.put(1, season1normal1);
        normalRewards.put(2, season1normal2);
        normalRewards.put(3, season1normal3);
        normalRewards.put(4, season1normal4);
        normalRewards.put(5, season1normal5);
        normalRewards.put(6, season1normal6);
        normalRewards.put(7, season1normal7);
        normalRewards.put(8, season1normal8);
        normalRewards.put(9, season1normal9);
        normalRewards.put(10, season1normal10);

        normalRewards.put(11, season1normal11);
        normalRewards.put(12, season1normal12);
        normalRewards.put(13, season1normal13);
        normalRewards.put(14, season1normal14);
        normalRewards.put(15, season1normal15);
        normalRewards.put(16, season1normal16);
        normalRewards.put(17, season1normal17);
        normalRewards.put(18, season1normal18);
        normalRewards.put(19, season1normal19);
        normalRewards.put(20, season1normal20);

        normalRewards.put(21, season1normal21);
        normalRewards.put(22, season1normal22);
        normalRewards.put(23, season1normal23);
        normalRewards.put(24, season1normal24);
        normalRewards.put(25, season1normal25);
        normalRewards.put(26, season1normal26);
        normalRewards.put(27, season1normal27);
        normalRewards.put(28, season1normal28);
        normalRewards.put(29, season1normal29);
        normalRewards.put(30, season1normal30);

        normalRewards.put(31, season1normal31);
        normalRewards.put(32, season1normal32);
        normalRewards.put(33, season1normal33);
        normalRewards.put(34, season1normal34);
        normalRewards.put(35, season1normal35);
        normalRewards.put(36, season1normal36);
        normalRewards.put(37, season1normal37);
        normalRewards.put(38, season1normal38);
        normalRewards.put(39, season1normal39);
        normalRewards.put(40, season1normal40);

        normalRewards.put(41, season1normal41);
        normalRewards.put(42, season1normal42);
        normalRewards.put(43, season1normal43);
        normalRewards.put(44, season1normal44);
        normalRewards.put(45, season1normal45);

        goldRewards.put(1, season1gold1);
        goldRewards.put(2, season1gold2);
        goldRewards.put(3, season1gold3);
        goldRewards.put(4, season1gold4);
        goldRewards.put(5, season1gold5);
        goldRewards.put(6, season1gold6);
        goldRewards.put(7, season1gold7);
        goldRewards.put(8, season1gold8);
        goldRewards.put(9, season1gold9);
        goldRewards.put(10, season1gold10);

        goldRewards.put(11, season1gold11);
        goldRewards.put(12, season1gold12);
        goldRewards.put(13, season1gold13);
        goldRewards.put(14, season1gold14);
        goldRewards.put(15, season1gold15);
        goldRewards.put(16, season1gold16);
        goldRewards.put(17, season1gold17);
        goldRewards.put(18, season1gold18);
        goldRewards.put(19, season1gold19);
        goldRewards.put(20, season1gold20);

        goldRewards.put(21, season1gold21);
        goldRewards.put(22, season1gold22);
        goldRewards.put(23, season1gold23);
        goldRewards.put(24, season1gold24);
        goldRewards.put(25, season1gold25);
        goldRewards.put(26, season1gold26);
        goldRewards.put(27, season1gold27);
        goldRewards.put(28, season1gold28);
        goldRewards.put(29, season1gold29);
        goldRewards.put(30, season1gold30);

        goldRewards.put(31, season1gold31);
        goldRewards.put(32, season1gold32);
        goldRewards.put(33, season1gold33);
        goldRewards.put(34, season1gold34);
        goldRewards.put(35, season1gold35);
        goldRewards.put(36, season1gold36);
        goldRewards.put(37, season1gold37);
        goldRewards.put(38, season1gold38);
        goldRewards.put(39, season1gold39);
        goldRewards.put(40, season1gold40);

        goldRewards.put(41, season1gold41);
        goldRewards.put(42, season1gold42);
        goldRewards.put(43, season1gold43);
        goldRewards.put(44, season1gold44);
        goldRewards.put(45, season1gold45);
    }


    /**
     * the Strings return the Displayname of the reward which the user got
     */

    /*
    Normal-Rewards:
     */
    String season1normal1 = "";
    String season1normal2 = "";
    String season1normal3 = "";
    String season1normal4 = "";
    String season1normal5 = "";
    String season1normal6 = "";
    String season1normal7 = "";
    String season1normal8 = "";
    String season1normal9 = "";
    String season1normal10 = "";
    String season1normal11 = "";
    String season1normal12 = "";
    String season1normal13 = "";
    String season1normal14 = "";
    String season1normal15 = "";
    String season1normal16 = "";
    String season1normal17 = "";
    String season1normal18 = "";
    String season1normal19 = "";
    String season1normal20 = "";
    String season1normal21 = "";
    String season1normal22 = "";
    String season1normal23 = "";
    String season1normal24 = "";
    String season1normal25 = "";
    String season1normal26 = "";
    String season1normal27 = "";
    String season1normal28 = "";
    String season1normal29 = "";
    String season1normal30 = "";
    String season1normal31 = "";
    String season1normal32 = "";
    String season1normal33 = "";
    String season1normal34 = "";
    String season1normal35 = "";
    String season1normal36 = "";
    String season1normal37 = "";
    String season1normal38 = "";
    String season1normal39 = "";
    String season1normal40 = "";
    String season1normal41 = "";
    String season1normal42 = "";
    String season1normal43 = "";
    String season1normal44 = "";
    String season1normal45 = "";

    /*
    Gold-Rewards:
     */
    String season1gold1 = "";
    String season1gold2 = "";
    String season1gold3 = "";
    String season1gold4 = "";
    String season1gold5 = "";
    String season1gold6 = "";
    String season1gold7 = "";
    String season1gold8 = "";
    String season1gold9 = "";
    String season1gold10 = "";
    String season1gold11 = "";
    String season1gold12 = "";
    String season1gold13 = "";
    String season1gold14 = "";
    String season1gold15 = "";
    String season1gold16 = "";
    String season1gold17 = "";
    String season1gold18 = "";
    String season1gold19 = "";
    String season1gold20 = "";
    String season1gold21 = "";
    String season1gold22 = "";
    String season1gold23 = "";
    String season1gold24 = "";
    String season1gold25 = "";
    String season1gold26 = "";
    String season1gold27 = "";
    String season1gold28 = "";
    String season1gold29 = "";
    String season1gold30 = "";
    String season1gold31 = "";
    String season1gold32 = "";
    String season1gold33 = "";
    String season1gold34 = "";
    String season1gold35 = "";
    String season1gold36 = "";
    String season1gold37 = "";
    String season1gold38 = "";
    String season1gold39 = "";
    String season1gold40 = "";
    String season1gold41 = "";
    String season1gold42 = "";
    String season1gold43 = "";
    String season1gold44 = "";
    String season1gold45 = "";

}
