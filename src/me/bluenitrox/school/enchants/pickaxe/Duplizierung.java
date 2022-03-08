package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.entity.Player;

public class Duplizierung extends EnchantAPI {

    public static int Dupliauslöser(Player p){
        if(p.getItemInHand() != null){
            if(p.getItemInHand().getItemMeta() != null){
                if(p.getItemInHand().getItemMeta().getLore() != null){
                    if(hasEnchant(p.getItemInHand(), EnchantManager.Duplizierung)){
                        if(makeOrNot80(stringToNumber(p.getItemInHand(), EnchantManager.Duplizierung))){
                            return 2;
                        }
                    }
                }
            }
        }
        return 1;
    }

}
