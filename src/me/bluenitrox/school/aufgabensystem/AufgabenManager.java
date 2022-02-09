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
        SchoolMode.setPlayertoggleTask(uuid, amount);
    }

    public static void onComplete(UUID uuid, int task){
        Player p = Bukkit.getPlayer(uuid);
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
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_2);
                p.sendMessage(MessageManager.PREFIX + "§7Der §6§lSchool Command");
                p.sendMessage("§b» §7Hier werden dir die §6wichtigsten Befehle §7angezeigt.");
                break;
            case 2:
                ExpManager.updateXP(p.getUniqueId(), 1500, false);
                setTask(p.getUniqueId(), 3);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_3);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lXp-System");
                p.sendMessage("§b» §7Hier siehst du dein §6Level§7, dein §6Prestige Level §7und deine §6benötigten Xp §7für ein Level-UP.");
                p.sendMessage("§b» §7Du kannst dich mit §6/prestige §7prestigen, dabei wirst du auf Level 1 zurückgesetzt.");
                p.sendMessage("§b» §7Damit schaltest du ein §6neues Dungeon §7frei und deine §6Level Farbe §7ändern sich.");
                break;
            case 3:
                ExpManager.updateXP(p.getUniqueId(), 2000, false);
                setTask(p.getUniqueId(), 4);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_4);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lKit-System");
                p.sendMessage("§b» §7Wie du siehst haben wir sehr viele Kits, zurzeit hast du nur §6eins§7.");
                p.sendMessage("§b» §7Doch dies §6ändert §7sich mit der Zeit, du schaltest mit §6Abholungen §7neue Kits frei.");
                p.sendMessage("§b» §7Wie viel für ein §6neues Kit fehlt§7, siehst du auf dem Kit nach deinem aktuellen.");
                break;
            case 4:
                ExpManager.updateXP(p.getUniqueId(), 2500, false);
                setTask(p.getUniqueId(), 5);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_5);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lMinen-System");
                p.sendMessage("§b» §7Dies sind die §6Minen§7, hier wirst du noch viel Zeit verbringen.");
                p.sendMessage("§b» §7In den Minen kannst du §6XP und Gems §7verdienen.");
                p.sendMessage("§b» §7Zusätzlich hast du die §6Chance§7 auf §5epische Items§7.");
                break;
            case 5:
                ExpManager.updateXP(p.getUniqueId(), 3000, false);
                setTask(p.getUniqueId(), 6);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_6);
                p.sendMessage(MessageManager.PREFIX + "§7Die ersten §6§lXP");
                p.sendMessage("§b» §7Für jeden §6Block§7, den du abbaust bekommst du §6ein Xp§7, insofern deine Spitzhacke nicht das Enchant §6§lErfahrung §7besitzt.");
                break;
            case 6:
                ExpManager.updateXP(p.getUniqueId(), 3500, false);
                setTask(p.getUniqueId(), 7);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_7);
                p.sendMessage(MessageManager.PREFIX + "§7Das erste §6§lGeld");
                p.sendMessage("§b» §7Wie du siehst hast §6Gems dazubekommen§7, diese kannst du immer im §6Scoreboard §7oder über §6/Gems §7ansehen.");
                p.sendMessage("§b» §6Gems §7sind die Währung auf dem Server, mit denen du deine §6Items Leveln §7kannst, im §6Auktionshaus Items kaufen §7kannst und bei den §6Händlern einkaufen §7kannst.");
                p.sendMessage("§b» §7Natürlich kannst du auch §6neue Minen §7kaufen, in denen du dann §6mehr Gems §7mit der Zeit verdienst.");
                break;
            case 7:
                ExpManager.updateXP(p.getUniqueId(), 4000, false);
                setTask(p.getUniqueId(), 8);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_7);
                p.sendMessage(MessageManager.PREFIX + "§7Das erste §6§lGeld");
                p.sendMessage("§b» §7Wie du siehst hast §6Gems dazubekommen§7, diese kannst du immer im §6Scoreboard §7oder über §6/Gems §7ansehen.");
                p.sendMessage("§b» §6Gems §7sind die Währung auf dem Server, mit denen du deine §6Items Leveln §7kannst, im §6Auktionshaus Items kaufen §7kannst und bei den §6Händlern einkaufen §7kannst.");
                p.sendMessage("§b» §7Natürlich kannst du auch §6neue Minen §7kaufen, in denen du dann §6mehr Gems §7mit der Zeit verdienst.");
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
