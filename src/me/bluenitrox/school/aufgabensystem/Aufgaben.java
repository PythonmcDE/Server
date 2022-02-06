package me.bluenitrox.school.aufgabensystem;

import me.bluenitrox.school.SchoolMode;
import org.bukkit.entity.Player;

public class Aufgaben {

    public static String TASK_1 = "§aFühre den Befehl /school aus.";
    public static String TASK_2 = "§aFühre den Befehl /xp aus.";
    public static String TASK_3 = "§aHole ein Kit mit /kit ab.";


    public static String getTask(Player player) {
        switch (SchoolMode.getPlayerTask(player.getUniqueId())) {
            case 1:
                return "§aFühre den Befehl /school aus.";
            case 2:
                return "§aFühre den Befehl /xp aus.";
            case 3:
                return "§aHole ein Kit mit /kit ab.";
        }
        return "Fehler";
    }

}
