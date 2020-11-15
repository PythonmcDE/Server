package me.bluenitrox.school;

import me.bluenitrox.school.commands.*;
import me.bluenitrox.school.listener.PlayerJoinListener;
import me.bluenitrox.school.listener.PlayerQuitListener;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.mysql.MySQL_File;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import sun.awt.SunHints;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class SchoolMode extends JavaPlugin {

    public static SchoolMode instance;
    public static HashMap<UUID, Float> playerMoney = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("----------------------------------");
        Bukkit.getConsoleSender().sendMessage("§7Plugin §aaktivieren... §7(0/4)");
        register(Bukkit.getPluginManager());
        startMySQL();
        Bukkit.getConsoleSender().sendMessage("----------------------------------");
    }

    @Override
    public void onDisable() {
        MySQL.disconnect();
    }

    public void register(PluginManager pm){
        Bukkit.getConsoleSender().sendMessage("§7Lade §9Commands...");
        //Command register


        getCommand("gm").setExecutor(new Gamemode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("set").setExecutor(new SetLocations());
        getCommand("money").setExecutor(new Money());


        //
        Bukkit.getConsoleSender().sendMessage("§9Commands §aAktiviert! (1/4)");
        Bukkit.getConsoleSender().sendMessage("§7Lade §dEvents...");
        //Event register


        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);


        //
        Bukkit.getConsoleSender().sendMessage("§dEvents §aRegistriert! (2/4)");
    }

    private void startMySQL() {
        Bukkit.getConsoleSender().sendMessage("§7Verbinde zu §eMySQL...");
        //MySQL Verbindung
        MySQL_File file = new MySQL_File();
        file.setdefault();
        file.readData();

        MySQL.connect();
        Bukkit.getConsoleSender().sendMessage("§aErstelle §bTabellen...");
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

        Bukkit.getConsoleSender().sendMessage("§bTabellen §7erstellt! (4/4)");
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
