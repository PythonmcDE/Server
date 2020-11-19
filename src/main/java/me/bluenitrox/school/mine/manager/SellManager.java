package me.bluenitrox.school.mine.manager;

import org.bukkit.entity.Player;

import java.util.Arrays;

public class SellManager {
    public enum Preise {
        CLAY("CLAY", 1L),
        IRON_ORE("IRON_ORE", 1L),
        COAL_ORE("COAL_ORE", 1L),
        STONE("STONE", 1L),
        WOOD("WOOD", 1L),
        GOLD_ORE("GOLD_ORE", 1L),
        GLOWSTONE_DUST("GLOWSTONE_DUST", 1L),
        QUARTZ_BLOCK("QUARTZ_BLOCK", 10L),
        DIAMOND("DIAMOND", 100L),
        EMERALD("EMERALD", 100L),
        DIAMOND_BLOCK("DIAMOND_BLOCK", 100L),
        EMERALD_BLOCK("EMERALD_BLOCK", 100L),
        GOLD_BLOCK("GOLD_BLOCK", 100L);


        String type;
        float price;

        Preise(String type, float price) {
            this.type = type;
            this.price = price;
        }

        public static Preise getByName(String type) {
            return Arrays.stream(values()).filter(rank -> rank.type.equals(type)).findFirst().orElse(null);
        }
    }

    public static float getPriceByMaterial(String material, Player p) {
        material = material.toUpperCase();

        //if(BOOSTER AKTIV -> ) {
        // float preis =  Preise.getByName(material).price * MessageManager.MONEY_BOOSTER_BOOST;
        //}else {
        float preis = Preise.getByName(material).price;
        //}

        return preis;
    }
}

