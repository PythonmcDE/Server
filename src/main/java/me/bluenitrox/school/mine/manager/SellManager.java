package me.bluenitrox.school.mine.manager;

import org.bukkit.entity.Player;

import java.util.Arrays;

public class SellManager {
    public enum Preise {
        STONE("STONE", 10),
        IRON_ORE("IRON_ORE", 100);


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

