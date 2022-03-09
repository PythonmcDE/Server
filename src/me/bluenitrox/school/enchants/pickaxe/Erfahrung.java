package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import org.bukkit.entity.Player;

public class Erfahrung extends EnchantAPI {

    public static int getErfahrungMultiplyer(Player p){
        if(p.getItemInHand() != null){
            if(p.getItemInHand().getItemMeta() != null) {
                if (p.getItemInHand().getItemMeta().getLore() != null) {
                    if(hasEnchant(p.getItemInHand(), EnchantManager.Erfahrung)){
                        int level = stringToNumber(p.getItemInHand(), EnchantManager.Erfahrung);
                        int multiplyer = 0;
                        if(level == 1){
                            multiplyer = 1;
                        }else if(level == 2){
                            multiplyer = 1;
                        }else if(level == 3){
                            multiplyer = 2;
                        }else if(level == 4){
                            multiplyer = 2;
                        }else if(level == 5){
                            multiplyer = 2;
                        }else if(level == 6){
                            multiplyer = 2;
                        }else if(level == 7){
                            multiplyer = 3;
                        }else if(level == 8){
                            multiplyer = 3;
                        }else if(level == 9){
                            multiplyer = 3;
                        }else if(level == 10){
                            multiplyer = 4;
                        }
                        return multiplyer;
                    }
                }
            }
        }
        return 1;
    }

}
