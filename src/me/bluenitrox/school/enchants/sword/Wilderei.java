package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import org.bukkit.entity.Player;

public class Wilderei extends EnchantAPI {

    public static float getEXPMultipyer(Player player){
        if(player.getItemInHand() != null){
            if(player.getItemInHand().getItemMeta() != null){
                if(player.getItemInHand().getItemMeta().getLore() != null){
                    if(hasEnchant(player.getItemInHand(), EnchantManager.Wilderei)){
                        if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 1){
                            return 1.1F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 2){
                            return 1.2F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 3){
                            return 1.3F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 4){
                            return 1.4F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 5){
                            return 1.5F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 6){
                            return 1.6F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 7){
                            return 1.7F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 8){
                            return 1.8F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 9){
                            return 1.9F;
                        }else if(stringToNumber(player.getItemInHand(), EnchantManager.Wilderei) == 10){
                            return 2.0F;
                        }
                    }
                }
            }
        }
        return 1.0F;
    }

}
