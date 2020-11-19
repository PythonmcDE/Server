package me.bluenitrox.school.mine.manager;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.ValuetoString;

import java.util.Arrays;
import java.util.UUID;

public class MinenPreisManager {

    public enum Ranks {
        MINE1("MINE1", MessageManager.MINE_1_PREIS),
        MINE2("MINE2", MessageManager.MINE_2_PREIS),
        MINE3("MINE3", MessageManager.MINE_3_PREIS),
        MINE4("MINE4", MessageManager.MINE_4_PREIS),
        MINE5("MINE5", MessageManager.MINE_5_PREIS),
        MINE6("MINE6", MessageManager.MINE_6_PREIS),
        MINE7("MINE7", MessageManager.MINE_7_PREIS),
        MINE8("MINE8", MessageManager.MINE_8_PREIS),
        MINE9("MINE9", MessageManager.MINE_9_PREIS),
        MINE10("MINE10", MessageManager.MINE_10_PREIS),
        MINE11("MINE11", MessageManager.MINE_11_PREIS),
        MINE12("MINE12", MessageManager.MINE_12_PREIS),
        MINE13("MINE13", MessageManager.MINE_13_PREIS),
        MINE14("MINE14", MessageManager.MINE_14_PREIS),
        MINE15("MINE15", MessageManager.MINE_15_PREIS);

        String name;
        float price;

        Ranks(String name, float price) {
            this.name = name;
            this.price = price;
        }

        public static Ranks getByName(String name) {
            return Arrays.stream(values()).filter(rank -> rank.name.equals(name)).findFirst().orElse(null);
        }
    }

    public static String getMineCostString(UUID uuid) {
        float cost = getMineCost(uuid);
        if(cost == 0) {
            return "Maxed";
        }
        return ValuetoString.valueToString(cost);
    }

    public static float getMineCost(UUID uuid){
        String mine = "mine";
        String nextMine = mine + (SchoolMode.getPlayerMine(uuid) + 1);
        if(Ranks.getByName(nextMine) == null){
            return 0;
        }
        float price;
        if(SchoolMode.getPlayerMine(uuid) >= MessageManager.MAX_MINE) {
            return 0;
        }else {
            price = Ranks.getByName(nextMine).price;
        }

        return price;
    }
}

