package me.bluenitrox.school.mine.manager;

import org.bukkit.entity.Player;

import java.util.Arrays;

public class SellManager {
    public enum Preise {
        STONE("STONE", 6),
        COAL("COAL",80),
        IRON_INGOT("IRON_INGOT", 160),
        GOLD_INGOT("GOLD_INGOT",500),
        REDSTONE("REDSTONE",350),
        DIAMOND("DIAMOND",800),
        EMERALD("EMERALD",1200),
        GRAVEL("GRAVEL", 20),
        COAL_BLOCK("COAL_BLOCK",720),
        GOLD_BLOCK("GOLD_BLOCK",4500),
        IRON_BLOCK("IRON_BLOCK",1440),
        REDSTONE_BLOCK("REDSTONE_BLOCK",3150),
        LAPIS_BLOCK("LAPIS_BLOCK",2520),
        DIAMOND_BLOCK("DIAMOND_BLOCK",7200),
        EMERALD_BLOCK("EMERALD_BLOCK",10800);


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

        float preis = Preise.getByName(material).price;

        return preis;
    }
}

