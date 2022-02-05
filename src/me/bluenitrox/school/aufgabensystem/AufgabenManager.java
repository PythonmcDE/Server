package me.bluenitrox.school.aufgabensystem;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.Firework;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AufgabenManager {

    public static int getTask(UUID uuid){
        return SchoolMode.getPlayerTask(uuid);
    }
    public static int getToggle(UUID uuid){
        return SchoolMode.getPlayerToggleTask(uuid);
    }

    public static void setTask(UUID uuid, int amount){
        SchoolMode.setPlayerTask(uuid, amount);
    }
    public static void setToggle(UUID uuid, int amount){
        SchoolMode.setPlayerTask(uuid, amount);
    }

    public static void onComplete(UUID uuid, int task){
        Player p = Bukkit.getPlayer(uuid);
        TTA_Methods.sendTitle(p, "1", 20, 20, 20, "2", 20, 20, 20);
        Firework.Firework(p);
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
        getPrice(p, task);
    }

    public static void getPrice(Player p, int task){
        switch (task) {
            case 1:
                ExpManager.updateXP(p.getUniqueId(), 1000, false);
                setTask(p.getUniqueId(), 2);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                TTA_Methods.sendActionBar(p, "§aGebe den Befehl /xp in den Chat ein", -1);
                p.sendMessage("§8» §7Hier kannst du dein Level sehen");
                p.sendMessage("§8» §7und siehst zusätzlich wie viele Xp für ein Level-Up fehlen.");
                p.sendMessage("§8» §7Auch siehst du dein Prestige Level, wobei dein Level eine andere Farbe erhält,");
                p.sendMessage("§8» §7und du ein neues Dungeon freischaltest.");
                p.sendMessage("§8» §7Du kannst dich mit dem Befehl /prestige prestigen,");
                p.sendMessage("§8» §7dabei wird dein Level auf 1 zurückgesetzt.");
                break;
            case 2:
                ExpManager.updateXP(p.getUniqueId(), 1500, false);
                setTask(p.getUniqueId(), 3);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 20,20,20, "§7Neue Aufgabe freigeschaltet.", 20, 20, 20);
                TTA_Methods.sendActionBar(p, "§7Neue Aufgabe freigeschaltet", -1);
                break;
        }
    }

    public static int getTaskDatabase(UUID uuid) {
        int task = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT aufgabenfortschritt FROM aufgaben WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                task = rs.getInt("aufgabenfortschritt");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return task;
    }

    public static int getToggleDatabase(UUID uuid) {
        int toggle = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT toggle FROM aufgaben WHERE spieleruuid = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                toggle = rs.getInt("toggle");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toggle;
    }



}
