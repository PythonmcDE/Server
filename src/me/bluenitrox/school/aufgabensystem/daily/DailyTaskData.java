package me.bluenitrox.school.aufgabensystem.daily;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.HashMap;

public class DailyTaskData {

    private final HashMap<Integer, String> dailytasks = new HashMap<>();

    /*
    1 = Pvp Task
    2 = Mining Task
    3 = Angel Task
    4 = Dungeon Task
    5 = Crafting Task
     */

    /**
     * Set the tasks in the HashMap
     * @param id from the task category
     * @param string the task
     */
    @Setter
    public void setDailytasks(int id, String string) {
        dailytasks.put(id, string);
    }

    /**
     * Select the task from the HashMap
     * @param id from the task Category
     * @return the task
     */
    @Getter
    public String getDailyTask(int id) {
        return dailytasks.get(id);
    }
}
