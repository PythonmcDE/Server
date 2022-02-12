package me.bluenitrox.school.aufgabensystem;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.listener.ActionBarMessageEvent;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.Firework;
import me.bluenitrox.school.utils.UUIDFetcher;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class AufgabenManager {

    public static LinkedList<Player> shouldcancle = new LinkedList<>();

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
        shouldcancle.add(Bukkit.getPlayer(uuid));
        Bukkit.broadcastMessage("oncomple added");
        getPrice(p, task);
    }

    public String getCurrentCompleteTaskMessage(UUID uuid){
        int task = getTask(uuid);
        switch (task){
            case 1:
                return Aufgaben.TASK_1;
            case 2:
                return Aufgaben.TASK_2;
        }
        return "";
        /*
        returning the message which should get blocked after a task complete
         */
    }

    public static void getPrice(Player p, int task){
        switch (task) {
            case 1:
                ExpManager.updateXP(p.getUniqueId(), 1000, false);
                setTask(p.getUniqueId(), 2);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_2, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Der §6§lSchool Command");
                p.sendMessage("§b» §7Hier werden dir die §6wichtigsten Befehle §7angezeigt.");
                break;
            case 2:
                ExpManager.updateXP(p.getUniqueId(), 2000, false);
                setTask(p.getUniqueId(), 3);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_3, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lXp-System");
                p.sendMessage("§b» §7Hier siehst du dein §6Level§7, dein §6Prestige Level §7und deine §6benötigten Xp §7für ein Level-UP.");
                p.sendMessage("§b» §7Du kannst dich mit §6/prestige §7prestigen, dabei wirst du auf Level 1 zurückgesetzt.");
                p.sendMessage("§b» §7Damit schaltest du ein §6neues Dungeon §7frei und deine §6Level Farbe §7ändern sich.");
                break;
            case 3:
                ExpManager.updateXP(p.getUniqueId(), 3000, false);
                setTask(p.getUniqueId(), 4);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_4, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lKit-System");
                p.sendMessage("§b» §7Wie du siehst haben wir sehr viele Kits, zurzeit hast du nur §6eins§7.");
                p.sendMessage("§b» §7Doch dies §6ändert §7sich mit der Zeit, du schaltest mit §6Abholungen §7neue Kits frei.");
                p.sendMessage("§b» §7Wie viel für ein §6neues Kit fehlt§7, siehst du auf dem Kit nach deinem aktuellen.");
                break;
            case 4:
                ExpManager.updateXP(p.getUniqueId(), 4000, false);
                setTask(p.getUniqueId(), 5);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_5, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lMinen-System");
                p.sendMessage("§b» §7Dies sind die §6Minen§7, hier wirst du noch viel Zeit verbringen.");
                p.sendMessage("§b» §7In den Minen kannst du §6XP und Gems §7verdienen.");
                p.sendMessage("§b» §7Zusätzlich hast du die §6Chance§7 auf §5epische Items§7.");
                break;
            case 5:
                ExpManager.updateXP(p.getUniqueId(), 5000, false);
                setTask(p.getUniqueId(), 6);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_6, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die ersten §6§lXP");
                p.sendMessage("§b» §7Für jeden §6Block§7, den du abbaust bekommst du §6ein Xp§7, insofern deine Spitzhacke nicht das Enchant §6§lErfahrung §7besitzt.");
                break;
            case 6:
                ExpManager.updateXP(p.getUniqueId(), 6000, false);
                setTask(p.getUniqueId(), 7);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_7, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Das erste §6§lGeld");
                p.sendMessage("§b» §7Wie du siehst hast §6Gems dazubekommen§7, diese kannst du immer im §6Scoreboard §7oder über §6/Gems §7ansehen.");
                p.sendMessage("§b» §6Gems §7sind die Währung auf dem Server, mit denen du deine §6Items Leveln §7kannst, im §6Auktionshaus Items kaufen §7kannst und bei den §6Händlern einkaufen §7kannst.");
                p.sendMessage("§b» §7Natürlich kannst du auch §6neue Minen §7kaufen, in denen du dann §6mehr Gems §7mit der Zeit verdienst.");
                break;
            case 7:
                ExpManager.updateXP(p.getUniqueId(), 7000, false);
                setTask(p.getUniqueId(), 8);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_8, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Der §6§lClan");
                p.sendMessage("§b» §7In einem §6Clan §7kannst du mit §6deinen Freunden §7ein mächtiges Team gründen und zu den besten in der Warzone werden.");
                p.sendMessage("§b» §7Auf der §6Clanbank §7können alle Clanmitglieder Steuerfrei §6Geld §7einzahlen und auszahlen.");
                break;
            case 8:
                ExpManager.updateXP(p.getUniqueId(), 8000, false);
                setTask(p.getUniqueId(), 9);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_9, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lAuktionshaus");
                p.sendMessage("§b» §7Im §6Auktionshaus §7kannst du Items kaufen und verkaufen.");
                p.sendMessage("§b» §7Bei einer §6Transaktion §7erhält der Verkäufer §695% §7des Preises, §65% §7gehen mit den Steuern verloren.");
                break;
            case 9:
                ExpManager.updateXP(p.getUniqueId(), 9000, false);
                setTask(p.getUniqueId(), 10);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_10, 20*60*10);
                break;
            case 10:
                ExpManager.updateXP(p.getUniqueId(), 10000, false);
                setTask(p.getUniqueId(), 11);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_11, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lHändler");
                p.sendMessage("§b» §7Bei §6Händlern §7kannst du §6Blöcke kaufen§7, deine §6Items §7reparieren, oder auch §6Spawner kaufen§7, womit du in der §6Plotworld Monster §7spawnen kannst.");
                break;
            case 11:
                ExpManager.updateXP(p.getUniqueId(), 11000, false);
                setTask(p.getUniqueId(), 12);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_12, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lPlotworld");
                p.sendMessage("§b» §7Dies ist die §6Plotworld§7, hier kannst du §6deine Items lagern§7, damit sie nicht verloren gehen.");
                p.sendMessage("§b» §7Du kannst natürlich auch nur ein §6schönes Plot §7bauen.");
                break;
            case 12:
                ExpManager.updateXP(p.getUniqueId(), 12000, false);
                setTask(p.getUniqueId(), 13);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_13, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Dein §6§lPlot");
                p.sendMessage("§b» §7Dies ist nun §6dein Plot§7, bei /plot kannst du §6dein Plot erweitern§7.");
                break;
            case 13:
                ExpManager.updateXP(p.getUniqueId(), 13000, false);
                setTask(p.getUniqueId(), 14);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_14, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lPlotmenu");
                p.sendMessage("§b» §7In diesem §6Menu §7kannst sehen, wer auf deinem §6Plot bauen §7und §6Kisten öffnen §7kann.");
                p.sendMessage("§b» §7Außerdem kannst du dein §6Plot §7hier erweitern.");
                break;
            case 14:
                ExpManager.updateXP(p.getUniqueId(), 14000, false);
                setTask(p.getUniqueId(), 15);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_15, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Das §6§lTaxi");
                p.sendMessage("§b» §7Dies ist das §6Taxi§7, hiermit kannst du dich in die §6Warzone §7teleportieren.");
                break;
            case 15:
                ExpManager.updateXP(p.getUniqueId(), 15000, false);
                setTask(p.getUniqueId(), 16);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_16, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lWarzone");
                p.sendMessage("§b» §7Perfekt §6du hast es geschafft§7, nun bist du fast ein §6richtiger PVP Gott§7.");
                p.sendMessage("§b» §7Wenn du einen §6Spieler tötest§7, bekommst du §6seine Items§7 und erhältst zusätzlich 2 Prozent seines Geldes und 1000 Xp.");
                break;
            case 16:
                ExpManager.updateXP(p.getUniqueId(), 16000, false);
                setTask(p.getUniqueId(), 17);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_17, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lKisten");
                p.sendMessage("§b» §7Dies sind die §6Kisten§7, alle 15 Minuten spawnen 10 neue, aus diesen §6Kisten §7erhältst du §6„School Xp“§7, §6Cases§7, §6Bücher §7und noch mehr.");
                p.sendMessage("§b» §7Welche Funktion §6Bücher §7haben, kannst du hier sehen:");
                p.sendMessage("§b» §7https://pythonmc.de/schoolbücher");
                break;
            case 17:
                ExpManager.updateXP(p.getUniqueId(), 17000, false);
                setTask(p.getUniqueId(), 18);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_18, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lCases");
                p.sendMessage("§b» §7Es gibt §6mehrere Arten von Cases§7, die §8Gewöhnlichen§7, die §bSeltenen§7, die §5Epischen§7, die §cLegendären§7, die §6Tier Cases §7und die §6Mythischen §7Cases.");
                p.sendMessage("§b» §7Die Items aus den Cases enthalten eine §6bestimmte Seltenheit§7, welches den §6Wert §7des Items wiederspiegelt.");
                p.sendMessage("§b» §7Somit sind §cLegendäre Items §7besser als §8Gewöhnliche Items§7.");
                break;
            case 18:
                ExpManager.updateXP(p.getUniqueId(), 18000, false);
                setTask(p.getUniqueId(), 19);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_19, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lStats");
                p.sendMessage("§b» §7Dies sind die §6Stats§7, hier wird alles gespeichert, was du tust und noch tun wirst.");
                break;
            case 19:
                ExpManager.updateXP(p.getUniqueId(), 19000, false);
                setTask(p.getUniqueId(), 20);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_20, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lAngelminen");
                p.sendMessage("§b» §7Dies sind die §6Angelminen§7, mit den Items, die hier geangelt werden, können §6mächtige Items §7gecraftet werden, die die §6Haltbarkeit deiner Items §7erhöhen.");
                p.sendMessage("§b» §7Die geangelten §6Items §7können auch zu einem §6guten Preis §7verkauft werden.");
                break;
            case 20:
                ExpManager.updateXP(p.getUniqueId(), 20000, false);
                setTask(p.getUniqueId(), 21);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
                AufgabenMethods.sendActionBar(p, Aufgaben.TASK_21, 20*60*10);
                break;
            case 21:
                ExpManager.updateXP(p.getUniqueId(), 21000, false);
                setTask(p.getUniqueId(), 22);
                TTA_Methods.sendTitle(p, "§6Aufgabe §aabgeschlossen", 50,50,50, "§7Neue Aufgabe freigeschaltet.", 50, 50, 50);
               AufgabenMethods.sendActionBar(p, Aufgaben.ALL_DONE, 20*60*10);
                p.sendMessage(MessageManager.PREFIX + "§7Die §6§lDungeons");
                p.sendMessage("§b» §7Dies ist das §6Dungeon§7, von ihnen gibt es drei Stück.");
                p.sendMessage("§b» §7Wenn du hier sterben solltest, behälst du deine §6Items§7.");
                p.sendMessage("§b» §7Du schaltest weitere §6Dungeons §7frei, indem du dich prestiged.");
                p.sendMessage("§b» §7Mit den §6Drops §7von den Monster, kannst du mächtige §6Runen §7craften oder §6Item-Erhalt §7craften, womit du deine Items im §6Todesfall schützen §7kannst.");
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
