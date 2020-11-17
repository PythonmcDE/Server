package me.bluenitrox.school;

import me.bluenitrox.school.commands.*;
import me.bluenitrox.school.listener.PlayerJoinListener;
import me.bluenitrox.school.listener.PlayerQuitListener;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.mysql.MySQL_File;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sun.awt.SunHints;

import javax.print.attribute.standard.MediaSize;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class SchoolMode extends JavaPlugin {

    /*

    ANTIDUPE
    beim Item aufsammeln / aus kiste nehmen / joinen / kiste öffnen / ofen etc. durchsyncen

     */

    public static SchoolMode instance;
    public static HashMap<UUID, Float> playerMoney = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§4----------------------------------");
        Bukkit.getConsoleSender().sendMessage("§4Plugin §4aktivieren... §4(0/4)");
        register(Bukkit.getPluginManager());
        startMySQL();
        getCurrentDupeID();
        Bukkit.getConsoleSender().sendMessage("§4----------------------------------");
    }

    @Override
    public void onDisable() {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE datatable SET dupeid = ?")) {
            ps.setInt(1,Antidupe.nextItemID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MySQL.disconnect();
    }

    public void register(PluginManager pm){
        Bukkit.getConsoleSender().sendMessage("§4Lade §4Commands...");
        //Command register


        getCommand("gm").setExecutor(new Gamemode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("set").setExecutor(new SetLocations());
        getCommand("money").setExecutor(new Money());
        getCommand("test").setExecutor(new NBTTagtest());
        getCommand("testzwei").setExecutor(new OtherTest());


        //
        Bukkit.getConsoleSender().sendMessage("§4Commands §4Aktiviert! (1/4)");
        Bukkit.getConsoleSender().sendMessage("§4Lade §4Events...");
        //Event register


        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);


        //
        Bukkit.getConsoleSender().sendMessage("§4Events §4Registriert! (2/4)");
    }

    private void getCurrentDupeID(){
        if(isDupeIDExists()) {
            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT dupeid FROM datatable")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Antidupe.nextItemID = rs.getInt("dupeid") + 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try (PreparedStatement ps1 = MySQL.getConnection().prepareStatement("INSERT INTO datatable (dupeid) VALUES (?)")) {
                ps1.setInt(1,1);
                ps1.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    private static boolean isDupeIDExists() {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT dupeid FROM datatable");
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private void startMySQL() {
        Bukkit.getConsoleSender().sendMessage("§4Verbinde zu §4MySQL...");
        //MySQL Verbindung
        MySQL_File file = new MySQL_File();
        file.setdefault();
        file.readData();

        MySQL.connect();
        Bukkit.getConsoleSender().sendMessage("§4Erstelle §4Tabellen...");
        //Tabellen Erstellung
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `spielerdaten` ( `spieleruuid` CHAR(36) NOT NULL , `money` BIGINT(11) NOT NULL , `dungeon` INT(11) NOT NULL ,`exp` FLOAT NOT NULL , `mine` INT(11) NOT NULL , `prestige` INT(11) NOT NULL , `kills` INT(11) NOT NULL , `deaths` INT(11) NOT NULL , `cases` INT(11) NOT NULL , `bloecke` INT(11) NOT NULL , `mob` INT(11) NOT NULL ,`chests` INT(11) NOT NULL , PRIMARY KEY (`spieleruuid`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `locations` ( `name` VARCHAR(30) NOT NULL , `world` VARCHAR(30) NOT NULL , `x` DOUBLE NOT NULL , `y` DOUBLE NOT NULL , `z` DOUBLE NOT NULL , `yaw` FLOAT NOT NULL , `pitch` FLOAT NOT NULL , PRIMARY KEY (`name`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `datatable` ( `dupeid` INT(11) NOT NULL , PRIMARY KEY (`dupeid`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage("§4Tabellen §4erstellt! (4/4)");
    }

    public static SchoolMode getInstance() {
        return instance;
    }


    /*

    Money System

     */


    public static float getPlayerMoney(UUID uuid) {
        return playerMoney.get(uuid);
    }

    public static String getPlayerMoneyString(UUID uuid) {
        float money = playerMoney.get(uuid);
        return ValuetoString.valueToString(money);
    }

    public static void setPlayerMoney(UUID uuid, float amount) {
        playerMoney.put(uuid, amount);
    }

    /*

    Money System

     */

}
