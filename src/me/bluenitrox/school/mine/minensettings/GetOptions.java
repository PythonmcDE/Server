package me.bluenitrox.school.mine.minensettings;

import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class GetOptions {

    /*
    Set the database data in HashMaps on Player join
     */

    public GetOptions() {
        miningSettings = this;
    }
    private static HashMap<UUID, HashMap<Material, Boolean>> map = new HashMap<>();
    private static HashMap<Material, Boolean> blocks;
    private static GetOptions miningSettings;

    public static GetOptions getMiningSettings() {
        return miningSettings;
    }

    public HashMap<UUID, HashMap<Material, Boolean>> getMinenSettings() {
        return map;
    }

    public void setInHashMap(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        blocks = new HashMap<>();
        Random r = new Random(10);
        /*
        create booleans for all mining items
         */
            boolean stone;
            boolean gravil;
            boolean coal;
            boolean brick;
            boolean iron;
            boolean quarz;
            boolean redstone;
            boolean lapis;
            boolean prismarin;
            boolean gold;
            boolean diamond;
            boolean netherbrick;
            boolean emerald;
            boolean coalblock;
            boolean sandstone;
            boolean quarzblock;
            boolean ice;
            boolean netherrack;
            boolean ironblock;
            boolean packedice;
            boolean sealatern;
            boolean endstone;
            boolean redstoneblock;
            boolean lapisblock;
            boolean goldblock;
            boolean diamondblock;
            boolean emeraldblock;

        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM miningblocksettings WHERE spieleruuid = ?")) {
            preparedStatement.setString(1, uuid.toString());
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    stone = resultSet.getBoolean("stone");
                    gravil = resultSet.getBoolean("gravil");
                     coal = resultSet.getBoolean("coal");
                     brick = resultSet.getBoolean("brick");
                     iron = resultSet.getBoolean("iron");
                     quarz = resultSet.getBoolean("quarz");
                     redstone = resultSet.getBoolean("redstone");
                     lapis = resultSet.getBoolean("lapis");
                     prismarin = resultSet.getBoolean("prismarin");
                     gold = resultSet.getBoolean("gold");
                     diamond = resultSet.getBoolean("diamond");
                     netherbrick = resultSet.getBoolean("netherbrick");
                     emerald = resultSet.getBoolean("emerald");
                     coalblock = resultSet.getBoolean("coalblock");
                     sandstone = resultSet.getBoolean("redsandstone");
                     quarzblock = resultSet.getBoolean("quarzblock");
                     ice = resultSet.getBoolean("ice");
                     netherrack = resultSet.getBoolean("netherrack");
                     ironblock = resultSet.getBoolean("ironblock");
                     packedice = resultSet.getBoolean("packedice");
                     sealatern = resultSet.getBoolean("sealatern");
                     endstone = resultSet.getBoolean("endstone");
                     redstoneblock = resultSet.getBoolean("redstoneblock");
                     lapisblock = resultSet.getBoolean("lapisblock");
                     goldblock = resultSet.getBoolean("goldblock");
                     diamondblock = resultSet.getBoolean("diamondblock");
                     emeraldblock = resultSet.getBoolean("emeraldblock");

                     blocks.put(Material.STONE, stone);
                     blocks.put(Material.GRAVEL, gravil);
                     blocks.put(Material.COAL_ORE, coal);
                     blocks.put(Material.BRICK, brick);
                     blocks.put(Material.IRON_ORE, iron);
                     blocks.put(Material.QUARTZ_ORE, quarz);
                     blocks.put(Material.REDSTONE_ORE, redstone);
                     blocks.put(Material.LAPIS_ORE, lapis);
                     blocks.put(Material.PRISMARINE, prismarin);
                     blocks.put(Material.GOLD_ORE, gold);
                     blocks.put(Material.DIAMOND_ORE, diamond);
                     blocks.put(Material.NETHER_BRICK, netherbrick);
                     blocks.put(Material.EMERALD_ORE, emerald);
                     blocks.put(Material.COAL_BLOCK, coalblock);
                     blocks.put(Material.RED_SANDSTONE, sandstone);
                     blocks.put(Material.QUARTZ_BLOCK, quarzblock);
                     blocks.put(Material.ICE, ice);
                     blocks.put(Material.NETHERRACK, netherrack);
                     blocks.put(Material.IRON_BLOCK, ironblock);
                     blocks.put(Material.PACKED_ICE, packedice);
                     blocks.put(Material.SEA_LANTERN, sealatern);
                     blocks.put(Material.ENDER_STONE, endstone);
                     blocks.put(Material.REDSTONE_BLOCK, redstoneblock);
                     blocks.put(Material.LAPIS_BLOCK, lapisblock);
                     blocks.put(Material.GOLD_BLOCK, goldblock);
                     blocks.put(Material.DIAMOND_BLOCK, diamondblock);
                     blocks.put(Material.EMERALD_BLOCK, emeraldblock);

                     map.put(uuid, blocks);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        /*
        Select something from Database
        */
    }

    /*
    Set User Data into the database and remove them out of the hashmaps
     */
    public void savePlayer(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        HashMap<Material, Boolean> blockMap = GetOptions.getMiningSettings().getMinenSettings().get(uuid);

        boolean stone = blockMap.get(Material.STONE);
        boolean gravil = blockMap.get(Material.GRAVEL);
        boolean coal = blockMap.get(Material.COAL_ORE);
        boolean brick = blockMap.get(Material.BRICK);
        boolean iron = blockMap.get(Material.IRON_ORE);
        boolean quarz = blockMap.get(Material.QUARTZ_ORE);
        boolean redstone = blockMap.get(Material.REDSTONE_ORE);
        boolean lapis = blockMap.get(Material.LAPIS_ORE);
        boolean prismarin = blockMap.get(Material.PRISMARINE);
        boolean gold = blockMap.get(Material.GOLD_ORE);
        boolean diamond = blockMap.get(Material.DIAMOND_ORE);
        boolean netherbrick = blockMap.get(Material.NETHER_BRICK);
        boolean emerald = blockMap.get(Material.EMERALD_ORE);
        boolean coalblock = blockMap.get(Material.COAL_BLOCK);
        boolean sandstone = blockMap.get(Material.RED_SANDSTONE);
        boolean quarzblock = blockMap.get(Material.QUARTZ_BLOCK);
        boolean ice = blockMap.get(Material.ICE);
        boolean netherrack = blockMap.get(Material.NETHERRACK);
        boolean ironblock = blockMap.get(Material.IRON_BLOCK);
        boolean packedice = blockMap.get(Material.PACKED_ICE);
        boolean sealatern = blockMap.get(Material.SEA_LANTERN);
        boolean endstone = blockMap.get(Material.ENDER_STONE);
        boolean redstoneblock = blockMap.get(Material.REDSTONE_BLOCK);
        boolean lapisblock = blockMap.get(Material.LAPIS_BLOCK);
        boolean goldblock = blockMap.get(Material.GOLD_BLOCK);
        boolean diamondblock = blockMap.get(Material.DIAMOND_BLOCK);
        boolean emeraldblock = blockMap.get(Material.EMERALD_BLOCK);

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET stone = ?, gravil = ?, coal = ?, brick = ?, iron = ?, quarz = ?, redstone = ?, lapis = ?, prismarin = ?, gold = ?, diamond = ?, netherbrick = ?, emerald = ?, coalblock = ?, redsandstone = ?, quarzblock = ?, ice = ?, netherrack = ?, ironblock = ?, packedice = ?, sealatern = ?, endstone = ?, redstoneblock = ?, lapisblock = ?, goldblock = ?, diamondblock = ?, emeraldblock = ? WHERE spieleruuid = ?")) {
            preparedStatement.setBoolean(1, stone);
            preparedStatement.setBoolean(2, gravil);
            preparedStatement.setBoolean(3, coal);
            preparedStatement.setBoolean(4, brick);
            preparedStatement.setBoolean(5, iron);
            preparedStatement.setBoolean(6, quarz);
            preparedStatement.setBoolean(7, redstone);
            preparedStatement.setBoolean(8, lapis);
            preparedStatement.setBoolean(9, prismarin);
            preparedStatement.setBoolean(10, gold);
            preparedStatement.setBoolean(11, diamond);
            preparedStatement.setBoolean(12, netherbrick);
            preparedStatement.setBoolean(13, emerald);
            preparedStatement.setBoolean(14, coalblock);
            preparedStatement.setBoolean(15, sandstone);
            preparedStatement.setBoolean(16, quarzblock);
            preparedStatement.setBoolean(17, ice);
            preparedStatement.setBoolean(18, netherrack);
            preparedStatement.setBoolean(19, ironblock);
            preparedStatement.setBoolean(20, packedice);
            preparedStatement.setBoolean(21, sealatern);
            preparedStatement.setBoolean(22, endstone);
            preparedStatement.setBoolean(23, redstoneblock);
            preparedStatement.setBoolean(24, lapisblock);
            preparedStatement.setBoolean(25, goldblock);
            preparedStatement.setBoolean(26, diamondblock);
            preparedStatement.setBoolean(27, emeraldblock);
            preparedStatement.setString(28, uuid.toString());

            preparedStatement.executeUpdate();

            map.remove(uuid);
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    /*
    create the Player in the database
     */
    public void createPlayer(UUID uuid) {
        if(isUserExists(uuid)) return;
        try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO miningblocksettings (spieleruuid, stone, gravil, coal, brick, iron, quarz, redstone, lapis, prismarin, gold, diamond, netherbrick, emerald, coalblock, redsandstone, quarzblock, ice, netherrack, ironblock, packedice, sealatern, endstone, redstoneblock, lapisblock, goldblock, diamondblock, emeraldblock) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, uuid.toString());
            preparedStatement.setBoolean(2, true);
            preparedStatement.setBoolean(3, true);
            preparedStatement.setBoolean(4, true);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setBoolean(6, true);
            preparedStatement.setBoolean(7, true);
            preparedStatement.setBoolean(8, true);
            preparedStatement.setBoolean(9, true);
            preparedStatement.setBoolean(10, true);
            preparedStatement.setBoolean(11, true);
            preparedStatement.setBoolean(12, true);
            preparedStatement.setBoolean(13, true);
            preparedStatement.setBoolean(14, true);
            preparedStatement.setBoolean(15, true);
            preparedStatement.setBoolean(16, true);
            preparedStatement.setBoolean(17, true);
            preparedStatement.setBoolean(18, true);
            preparedStatement.setBoolean(19, true);
            preparedStatement.setBoolean(20, true);
            preparedStatement.setBoolean(21, true);
            preparedStatement.setBoolean(22, true);
            preparedStatement.setBoolean(23, true);
            preparedStatement.setBoolean(24, true);
            preparedStatement.setBoolean(25, true);
            preparedStatement.setBoolean(26, true);
            preparedStatement.setBoolean(27, true);
            preparedStatement.setBoolean(28, true);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    check if the user is already in database
     */
    private boolean isUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT spieleruuid FROM miningblocksettings WHERE spieleruuid = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
