package me.bluenitrox.school.aufgabensystem.daily;

import jdk.nashorn.internal.objects.annotations.Getter;

public class Tasks {

    /*
    create Tasks
     */
    //Pvp tasks
    private String pvp1 = "Töte 3 Spieler";
    //Mining tasks
    private String mining1 = "Baue 5000 Blöcke ab";
    //angel tasks
    private String angel1 = "Angel 50 Items";
    //dungeon tasks
    private String dungeon1 = "Töte 100 Monster im Dungeon";
    //crafting tasks1
    private String crafting1 = "Stelle Item-Verhärtung her";

    /*
    create Getter
     */
    @Getter
    public String getPvpTask(int zahl) {

        switch (zahl) {

            case 1:
                return pvp1;
        }
        return "";
    }

    @Getter
    public String getMiningTask(int zahl) {

        switch (zahl) {

            case 1:
                return mining1;
        }
        return "";
    }

    @Getter
    public String getAngelTask(int zahl) {

        switch (zahl) {

            case 1:
                return angel1;
        }
        return "";
    }

    @Getter
    public String getDungeonTask(int zahl) {

        switch (zahl) {

            case 1:
                return dungeon1;
        }
        return "";
    }

    @Getter
    public String getCraftingTask(int zahl) {

        switch (zahl) {

            case 1:
                return crafting1;
        }
        return "";
    }




}
