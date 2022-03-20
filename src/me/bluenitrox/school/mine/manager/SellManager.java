package me.bluenitrox.school.mine.manager;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class SellManager {
    public static int pricelapis = 500;
    public static int priceredstone = 450;
    public enum Preise {
        STONE("STONE", 30),
        GRAVEL("GRAVEL", 60),
        COAL("COAL",120),
        BRICK("BRICK",200),
        IRON_INGOT("IRON_INGOT", 250),
        QUARTZ("QUARTZ", 350),
        REDSTONE("REDSTONE", 450),
        PRISMARINE("PRISMARINE",600),
        GOLD_INGOT("GOLD_INGOT", 600),
        DIAMOND("DIAMOND",800),
        NETHER_BRICK("NETHER_BRICK",800),
        EMERALD("EMERALD",1000),
        COAL_BLOCK("COAL_BLOCK",1080),
        RED_SANDSTONE("RED_SANDSTONE",1200),
        QUARTZ_BLOCK("QUARTZ_BLOCK",1400),
        ICE("ICE",1500),
        NETHERRACK("NETHERRACK", 2000),
        IRON_BLOCK("IRON_BLOCK",2250),
        PACKED_ICE("PACKED_ICE",2800),
        SEA_LANTERN("SEA_LANTERN",3200),
        ENDER_STONE("ENDER_STONE",3800),
        REDSTONE_BLOCK("REDSTONE_BLOCK",4050),
        LAPIS_BLOCK("LAPIS_BLOCK",4500),
        GOLD_BLOCK("GOLD_BLOCK",5400),
        DIAMOND_BLOCK("DIAMOND_BLOCK",7200),
        EMERALD_BLOCK("EMERALD_BLOCK",9000);


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

    public static float getPriceByMaterial(String material) {
        material = material.toUpperCase();
        if(material.equalsIgnoreCase("ink_sack")) return 0F;
        float preis = Preise.getByName(material).price;

        return preis;
    }
}

