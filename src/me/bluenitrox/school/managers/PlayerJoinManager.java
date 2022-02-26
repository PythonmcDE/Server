package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.boost.BoosterAPI;
import me.bluenitrox.school.commands.Skill;
import me.bluenitrox.school.features.SkillAPI;
import me.bluenitrox.school.features.StatsAPI;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.mine.manager.MinenManager;
import me.bluenitrox.school.mine.manager.MinenSettings;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;

public class PlayerJoinManager {

    public static int language = 0;

    public static Scoreboard getBoard() {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        return board;
    }


    public static void cachPlayerData(UUID uuid) {
        MinenSettings minenSettings = new MinenSettings();
        minenSettings.createPlayer(uuid);
        if(!isTaskUserExists(uuid)) {
            configuratePlayer(uuid);
            configurateKitPlayer(uuid);
            configuratePetPlayer(uuid);
            configurateSkillPlayer(uuid);
            configurateTaskPlayer(uuid);
        }
        if(!isBoostUserExists(uuid)) {
            configurateBoosterPlayer(uuid);
        }
        /*
        important values money etc.
         */

        float money = 0;
        float exp = 0;
        int level = 0;
        int mine = 0;
        int angelmine = 0;
        int blocks = 0;
        int mobs = 0;
        int cases = 0;
        int chests = 0;
        int prestige = 0;
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT * FROM spielerdaten WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                money = rs.getFloat("money");
                exp = rs.getFloat("exp");
                level = rs.getInt("level");
                mine = rs.getInt("mine");
                angelmine = rs.getInt("angelmine");
                blocks = rs.getInt("bloecke");
                mobs = rs.getInt("mob");
                cases = rs.getInt("cases");
                chests = rs.getInt("chests");
                prestige = rs.getInt("prestige");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SchoolMode.setPlayerMoney(uuid, money);
        SchoolMode.playerlevel.put(uuid,level);
        SchoolMode.setPlayerExp(uuid, exp);
        SchoolMode.setPlayerMine(uuid, mine);
        SchoolMode.setPlayerAngelmine(uuid,angelmine);
        SchoolMode.setPlayerBlocks(uuid, blocks);
        SchoolMode.setPlayerCase(uuid,cases);
        SchoolMode.setPlayerChest(uuid, chests);
        SchoolMode.setPlayerMob(uuid,mobs);
        SchoolMode.setPrestige(uuid, prestige);
        KopfgeldManager.onTartgetJoin(uuid);

        /*
        booster system
         */

        int chestBooster = 0;
        int gemBooster = 0;
        int xpBooster = 0;
        int angelBooster = 0;
        int dungeonBooster = 0;
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT * FROM booster WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                chestBooster = rs.getInt("chest");
                gemBooster = rs.getInt("gem");
                xpBooster = rs.getInt("xp");
                angelBooster = rs.getInt("angel");
                dungeonBooster = rs.getInt("dungeon");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SchoolMode.setPlayerChestBooster(uuid, chestBooster);
        SchoolMode.setPlayerGemBooster(uuid, gemBooster);
        SchoolMode.setPlayerXPBooster(uuid, xpBooster);
        SchoolMode.setPlayerAngelBooster(uuid, angelBooster);
        SchoolMode.setPlayerDungeonBooster(uuid, dungeonBooster);

        /*
        task system
         */

        int task = 0;
        int toggletask = 0;
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT * FROM aufgaben WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                task = rs.getInt("aufgabenfortschritt");
                toggletask = rs.getInt("toggle");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SchoolMode.setPlayerTask(uuid, task);
        SchoolMode.setPlayertoggleTask(uuid, toggletask);

        /*
        Skill system
         */

        int skillpunkte = 0;
        int angriff = 0;
        int verteidigung = 0;
        int extraenergie = 0;
        int scharfschütze = 0;
        int mining = 0;
        int handler = 0;
        int alchemist = 0;
        int bonusloot = 0;
        int gluckspilz = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT * FROM skills WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                skillpunkte = rs.getInt("skillpunkte");
                angriff = rs.getInt("angriff");
                verteidigung = rs.getInt("verteidigung");
                extraenergie = rs.getInt("extraenergie");
                scharfschütze = rs.getInt("scharfschütze");
                mining = rs.getInt("mining");
                handler = rs.getInt("handler");
                alchemist = rs.getInt("alchemist");
                bonusloot = rs.getInt("bonusloot");
                gluckspilz = rs.getInt("gluckspilz");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        SchoolMode.playerskillpunkte.put(uuid, skillpunkte);
        SchoolMode.playerangriff.put(uuid, angriff);
        SchoolMode.playerverteidigung.put(uuid, verteidigung);
        SchoolMode.playerextraenergie.put(uuid, extraenergie);
        SchoolMode.playerscharfschütze.put(uuid, scharfschütze);
        SchoolMode.playermining.put(uuid, mining);
        SchoolMode.playerhandler.put(uuid, handler);
        SchoolMode.playeralchemist.put(uuid, alchemist);
        SchoolMode.playerbonusloot.put(uuid, bonusloot);
        SchoolMode.playergluckspilz.put(uuid, gluckspilz);



        if(!isRewardUserExists(uuid)){
            configurateRewardPlayer(uuid);
        }
        SchoolMode.setGemLimit(uuid, (int) MoneyManager.getGemLimitdata(uuid));
    }

    public static void configuratePlayer(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO spielerdaten (spieleruuid, money, dungeon, exp, mine, prestige, kills, deaths, cases, bloecke, mob, chests, level, angelmine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)")) {
            ps.setString(1, uuid.toString());
            ps.setFloat(2, 1000);
            ps.setInt(3, 1);
            ps.setFloat(4, 0);
            ps.setInt(5, 1);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setInt(10, 0);
            ps.setInt(11, 0);
            ps.setInt(12, 0);
            ps.setInt(13, 1);
            ps.setInt(14, 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateKitPlayer(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO KitSystem (UUID, Holz, Stein, Eisen, Warzone, Diamant, Bergarbeiter, Goldfinger, Juwelier, Banker, Ninja, Sensei, Meister) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 35);
            ps.setInt(4, 50);
            ps.setInt(5, 50);
            ps.setInt(6, 50);
            ps.setInt(7, 50);
            ps.setInt(8, 35);
            ps.setInt(9, 50);
            ps.setInt(10, 50);
            ps.setInt(11, 50);
            ps.setInt(12, 35);
            ps.setInt(13, 50);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configuratePetPlayer(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO PetSystem (UUID, Benjamin, Merlin, Eddy, Anton, Helgar, Farid, Peter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateRewardPlayer(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO DailyReward (UUID, Belohnung, Erfahrung, Cases, GemLimit) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, (int) MoneyManager.berechnungGemlimit(uuid));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateTaskPlayer(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO aufgaben (spieleruuid, aufgabenfortschritt, toggle) VALUES (?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 1);
            ps.setInt(3, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateBoosterPlayer(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO booster (spieleruuid, xp, gem, dungeon, angel, chest) VALUES (?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateSkillPlayer(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("INSERT INTO skills (UUID, skillpunkte, angriff, verteidigung, extraenergie,scharfschütze,mining,handler,alchemist,bonusloot,gluckspilz) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setInt(10, 0);
            ps.setInt(11, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBoostUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT spieleruuid FROM booster WHERE spieleruuid = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT spieleruuid FROM spielerdaten WHERE spieleruuid = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isTaskUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT spieleruuid FROM aufgaben WHERE spieleruuid = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private static boolean isKitUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT UUID FROM KitSystem WHERE UUID = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isPetUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT UUID FROM PetSystem WHERE UUID = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isRewardUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT UUID FROM DailyReward WHERE UUID = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isSkillUserExists(UUID uuid) {
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT UUID FROM skills WHERE UUID = ?");){
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
