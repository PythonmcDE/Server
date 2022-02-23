package me.bluenitrox.school.mine.manager;

import me.bluenitrox.school.mine.manager.data.MinenSettingData;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class MinenSettings {

    /*
    Set the database data in HashMaps on Player join
     */
    public void setInHashMap(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
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

        /*
        Select something from Database
        */
        try {
            /*
            Select stone Items from database
            */
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT stone FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    stone = resultSet.getBoolean("stone");
                    MinenSettingData.getInstance().setStoneSettings(uuid, stone);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT gravil FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    gravil = resultSet.getBoolean("gravil");
                    MinenSettingData.getInstance().setGravelSettings(uuid, gravil);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT coal FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    coal = resultSet.getBoolean("coal");
                    MinenSettingData.getInstance().setCoalSettings(uuid, coal);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT brick FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    brick = resultSet.getBoolean("brick");
                    MinenSettingData.getInstance().setBrickSettings(uuid, brick);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT iron FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    iron = resultSet.getBoolean("iron");
                    MinenSettingData.getInstance().setIronSettings(uuid, iron);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT quarz FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    quarz = resultSet.getBoolean("quarz");
                    MinenSettingData.getInstance().setQuarzSettings(uuid, quarz);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT redstone FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    redstone = resultSet.getBoolean("redstone");
                    MinenSettingData.getInstance().setRedstoneSettings(uuid, redstone);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT lapis FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    lapis = resultSet.getBoolean("lapis");
                    MinenSettingData.getInstance().setLapisSettings(uuid, lapis);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT prismarin FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    prismarin = resultSet.getBoolean("prismarin");
                    MinenSettingData.getInstance().setPrismarinSettings(uuid, prismarin);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT gold FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    gold = resultSet.getBoolean("gold");
                    MinenSettingData.getInstance().setGoldSettings(uuid, gold);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT diamond FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    diamond = resultSet.getBoolean("diamond");
                    MinenSettingData.getInstance().setDiamondSettings(uuid, diamond);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT netherbrick FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    netherbrick = resultSet.getBoolean("netherbrick");
                    MinenSettingData.getInstance().setNetherBrickSettings(uuid, netherbrick);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT emerald FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    emerald = resultSet.getBoolean("emerald");
                    MinenSettingData.getInstance().setEmeraldSettings(uuid, emerald);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT coalblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    coalblock = resultSet.getBoolean("coalblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, coalblock);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT redsandstone FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    sandstone = resultSet.getBoolean("redsandstone");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, sandstone);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT quarzblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    quarzblock = resultSet.getBoolean("quarzblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, quarzblock);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT ice FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    ice = resultSet.getBoolean("ice");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, ice);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT netherrack FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    netherrack = resultSet.getBoolean("netherrack");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, netherrack);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT ironblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    ironblock = resultSet.getBoolean("ironblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, ironblock);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT packedice FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    packedice = resultSet.getBoolean("packedice");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, packedice);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT sealatern FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    sealatern = resultSet.getBoolean("sealatern");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, sealatern);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT endstone FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    endstone = resultSet.getBoolean("endstone");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, endstone);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT redstoneblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    redstoneblock = resultSet.getBoolean("redstoneblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, redstoneblock);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT lapisblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    lapisblock = resultSet.getBoolean("lapisblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, lapisblock);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT goldblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    goldblock = resultSet.getBoolean("goldblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, goldblock);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT diamondblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    diamondblock = resultSet.getBoolean("diamondblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, diamondblock);
                }
            }
            try(Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("SELECT emeraldblock FROM miningblocksettings WHERE spieleruuid = ?")) {
                preparedStatement.setString(1, uuid.toString());
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) {
                    emeraldblock = resultSet.getBoolean("emeraldblock");
                    MinenSettingData.getInstance().setCoalBlockSettings(uuid, emeraldblock);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    Set User Data into the database and remove them out of the hashmaps
     */
    public void savePlayer(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        MinenSettingData api = MinenSettingData.getInstance();
            try {
                if(MinenSettingData.getInstance().stoneSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET stone = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getStoneSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().stoneSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().gravelSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET gravil = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getGravelSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().gravelSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().coalSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET coal = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getCoalSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().coalSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().brickSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET brick = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getBrickSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().brickSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().ironSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET iron = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getIronSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().ironSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().quarzSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET quarz = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getQuarzSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().quarzSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().redstoneSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET redstone = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getRedstoneSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().redstoneSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().lapisSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET lapis = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getLapisSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().lapisSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().prismarinSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET prismarin = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getPrismarinSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().prismarinSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().goldSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET gold = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getGoldSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().goldSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().diamondSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET diamond = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getDiamondSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().diamondSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().netherBrickSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET netherbrick = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getNetherBrickSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().netherBrickSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().emeraldSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET emerald = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getEmeraldeSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().emeraldSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().coalBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET coalblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getCoalBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().coalBlockSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().redSandstoneSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET redsandstone = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getRedSandStoneSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().redSandstoneSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().quarzBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET quarzblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getQuarzBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().quarzBlockSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().iceSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET ice = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getIceSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().iceSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().netherRackSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET netherrack = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getNetherRackSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().netherRackSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().ironBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET ironblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getIronBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().ironBlockSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().packedIceSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET packedice = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getPackedIceSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().packedIceSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().seaLaternSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET sealatern = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getSeaLaternSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().seaLaternSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().endStoneSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET endstone = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getEndStoneSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().endStoneSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().redstoneBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET redstoneblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getRedstoneBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().redstoneBlockSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().lapisBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET lapisblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getLapisBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().lapisBlockSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().goldBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET goldblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getGoldBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().goldBlockSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().diamondBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET diamondblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getDiamondBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().diamondBlockSettings.remove(uuid);
                    }
                } else if(MinenSettingData.getInstance().emeraldBlockSettings.containsKey(uuid)) {
                    try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement("UPDATE miningblocksettings SET emeraldblock = ? WHERE spieleruuid = ?")) {
                        preparedStatement.setBoolean(1, api.getEmeraldBlockSettings(uuid));
                        preparedStatement.setString(2, uuid.toString());
                        preparedStatement.executeUpdate();
                        MinenSettingData.getInstance().emeraldBlockSettings.remove(uuid);
                    }
                }
            } catch (SQLException e) {
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
