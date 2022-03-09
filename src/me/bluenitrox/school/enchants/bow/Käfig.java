package me.bluenitrox.school.enchants.bow;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.enchants.EnchantManager;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Käfig extends EnchantAPI {

    public static boolean activateKäfig(Player player, Player target){
        if(player.getItemInHand() != null){
            if(player.getItemInHand().getItemMeta() != null){
                if(player.getItemInHand().getItemMeta().getLore() != null){
                    if(hasEnchant(player.getItemInHand(), EnchantManager.Käfig)){
                        if(makeOrNot50(stringToNumber(player.getItemInHand(), EnchantManager.Käfig))){
                            CombatAPI.fight.put(target, 30);
                            Bukkit.broadcastMessage("put target 30");
                        }
                    }
                }
            }
        }
        return false;
    }

}
