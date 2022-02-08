package me.bluenitrox.school.aufgabensystem;

import me.bluenitrox.school.SchoolMode;
import org.bukkit.entity.Player;

public class Aufgaben {

    public static String TASK_1 = "§8» §aFühre den Befehl /school aus.";
    public static String TASK_2 = "§8» §aFühre den Befehl /xp aus.";
    public static String TASK_3 = "§8» §aHole ein Kit mit /kit ab.";
    public static String TASK_4 = "§8» §aTeleportiere dich beim Minenhändler in die erste Mine";
    public static String TASK_5 = "§8» §aBaue 50 Blöcke in der Mine ab";
    public static String TASK_6 = "§8» §aVerkaufe 50 Steine beim Minenhändler";
    public static String TASK_7 = "§8» §aFühre den Befehl /clan aus.";
    public static String TASK_8 = "§8» §Kaufe ein Item im /ah";
    public static String TASK_9 = "§8» §aVerkaufe ein Item im /ah";
    public static String TASK_10 = "§8» §aKaufe ein Item bei einem Händler";
    public static String TASK_11 = "§8» §aBesuche die /Plotworld";
    public static String TASK_12 = "§8» §aKaufe dir ein Plot mit /plot";
    public static String TASK_13 = "§8» §aFühre erneut den Befehl /Plot aus";
    public static String TASK_14 = "§8» §aSuche das Taxi";
    public static String TASK_15 = "§8» §aTöte einen Spieler in der Warzone";
    public static String TASK_16 = "§8» §aÖffne eine Kiste in der Warzone";
    public static String TASK_17 = "§8» §aÖffne eine Case";
    public static String TASK_18 = "§8» §aTeleportiere dich beim Angler in die erste Angelmine";
    public static String TASK_19 = "§8» §aAngel ein Item";
    public static String TASK_20 = "§8» §aFühre den Befehl /stats aus";
    public static String TASK_21 = "§8» §aTöte 10 Monster im Dungeon";


    public static String getTask(Player player) {
        switch (SchoolMode.getPlayerTask(player.getUniqueId())) {
            case 1:
                return TASK_1;
            case 2:
                return TASK_2;
            case 3:
                return TASK_3;
            case 4:
                return TASK_4;
            case 5:
                return TASK_5;
            case 6:
                return TASK_6;
            case 7:
                return TASK_7;
            case 8:
                return TASK_8;
            case 9:
                return TASK_9;
            case 10:
                return TASK_10;
            case 11:
                return TASK_11;
            case 12:
                return TASK_12;
            case 13:
                return TASK_13;
            case 14:
                return TASK_14;
            case 15:
                return TASK_15;
            case 16:
                return TASK_16;
            case 17:
                return TASK_17;
            case 18:
                return TASK_18;
            case 19:
                return TASK_19;
            case 20:
                return TASK_20;
            case 21:
                return TASK_21;
        }
        return "§aDu hast alle Aufgaben abgeschlossen!";
    }

}
