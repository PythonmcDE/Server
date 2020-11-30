package me.bluenitrox.school.enchants;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class EnchantAPI {

    protected static String numberToString(int i){
        if(i == 2){
            return "II";
        }else if(i == 3){
            return "III";
        }else if(i == 4){
            return "IV";
        }else if(i == 5){
            return "V";
        }else if(i == 6){
            return "VI";
        }else if(i == 7){
            return "VII";
        }else if(i == 8){
            return "VIII";
        }else if(i == 9){
            return "IX";
        }else if(i == 10){
            return "X";
        }else {
            return "I";
        }
    }

    protected static int stringToNumber(ItemStack i, String enchant){
        int line = 0;
        for(int wert = 0; wert<= i.getItemMeta().getLore().size()-1; wert++){
            if(i.getItemMeta().getLore().get(wert) != null) {
                if (i.getItemMeta().getLore().get(wert).startsWith(enchant)) {
                    line = wert;
                }
            }
        }

        String[] lore = i.getItemMeta().getLore().get(line).split(" ");
        return stringToNumber(lore[lore.length-1]);
    }

    private static int stringToNumber(String s){
        if(s.equalsIgnoreCase("X")){
            return 10;
        }else if(s.equalsIgnoreCase("IX")){
            return 9;
        }else if(s.equalsIgnoreCase("VIII")){
            return 8;
        }else if(s.equalsIgnoreCase("VII")){
            return 7;
        }else if(s.equalsIgnoreCase("VI")){
            return 6;
        }else if(s.equalsIgnoreCase("V")){
            return 5;
        }else if(s.equalsIgnoreCase("IV")){
            return 4;
        }else if(s.equalsIgnoreCase("III")){
            return 3;
        }else if(s.equalsIgnoreCase("II")){
            return 2;
        }else{
            return 1;
        }
    }

    protected static boolean hasEnchant(Player p,String enchant){
        int hasenchant = 0;
        for(int i = 0; i <= 10; i++) {
            if (p.getItemInHand().getItemMeta().getLore().contains(enchant + numberToString(i))) {
                hasenchant = 1;
            }
        }
        if(hasenchant == 1) {
            return true;
        }else {
            return false;
        }
    }

    protected static boolean makeOrNot50(int i){
        int r = new Random().nextInt(17);

        switch (r){
            case 1:
                if(i == 1){
                    return true;
                }
            case 2:
                for(int wert = 1;  wert <= 2; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 3:
                for(int wert = 1;  wert <= 3; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 4:
                for(int wert = 1;  wert <= 4; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 5:
                for(int wert = 1;  wert <= 5; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 6:
                for(int wert = 1;  wert <= 6; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 7:
                for(int wert = 1;  wert <= 7; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 8:
                for(int wert = 1;  wert <= 8; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 9:
                for(int wert = 1;  wert <= 9; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 10:
                for(int wert = 1;  wert <= 10; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            default:
                return false;
        }
    }

    protected static boolean makeOrNot80(int i){
        int r = new Random().nextInt(15);

        switch (r){
            case 1:
                if(i == 1){
                    return true;
                }
            case 2:
                for(int wert = 1;  wert <= 2; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 3:
                for(int wert = 1;  wert <= 3; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 4:
                for(int wert = 1;  wert <= 4; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 5:
                for(int wert = 1;  wert <= 5; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 6:
                for(int wert = 1;  wert <= 6; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 7:
                for(int wert = 1;  wert <= 7; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 8:
                for(int wert = 1;  wert <= 8; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 9:
                for(int wert = 1;  wert <= 9; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 10:
                for(int wert = 1;  wert <= 10; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            default:
                return false;
        }
    }

    protected static boolean makeOrNot100(int i){
        int r = new Random().nextInt(10);

        switch (r){
            case 1:
                if(i == 1){
                    return true;
                }
            case 2:
                for(int wert = 1;  wert <= 2; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 3:
                for(int wert = 1;  wert <= 3; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 4:
                for(int wert = 1;  wert <= 4; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 5:
                for(int wert = 1;  wert <= 5; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 6:
                for(int wert = 1;  wert <= 6; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 7:
                for(int wert = 1;  wert <= 7; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 8:
                for(int wert = 1;  wert <= 8; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 9:
                for(int wert = 1;  wert <= 9; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            case 10:
                for(int wert = 1;  wert <= 10; wert++) {
                    if (i == wert) {
                        return true;
                    }
                }
            default:
                return false;
        }
    }
}
