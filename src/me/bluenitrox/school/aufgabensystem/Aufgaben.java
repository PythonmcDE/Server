package me.bluenitrox.school.aufgabensystem;

import me.bluenitrox.school.SchoolMode;
import org.bukkit.entity.Player;

public class Aufgaben {

    public static String TASK_1 = "§8» §aFühre den Befehl /school aus.";
    public static String TASK_2 = "§8» §aFühre den Befehl /xp aus.";
    public static String TASK_3 = "§8» §aHole ein Kit mit /kit ab.";


    public static String getTask(Player player) {
        switch (SchoolMode.getPlayerTask(player.getUniqueId())) {
            case 1:
                return TASK_1;
            case 2:
                return TASK_2;
            case 3:
                return TASK_3;
        }
        return "Fehler";
    }

}
