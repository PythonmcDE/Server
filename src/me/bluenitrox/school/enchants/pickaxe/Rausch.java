package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.gemlimit.GemLimit;
import me.bluenitrox.school.mine.manager.SellManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Rausch extends EnchantAPI {

    public static void rausch(Player p, Material material){
        if(p.getItemInHand() != null){
            if(p.getItemInHand().getItemMeta() != null){
                if(p.getItemInHand().getItemMeta().getLore() != null){
                    if(hasEnchant(p.getItemInHand(), EnchantManager.Rausch)){
                        if(makeOrNot10(stringToNumber(p.getItemInHand(), EnchantManager.Rausch))) {
                            float money = SellManager.getPriceByMaterial(material.toString());
                            GemLimit gemLimit = new GemLimit(p.getUniqueId());
                            if(gemLimit.getRestGemLimit() < money) return;
                            MoneyManager.updateMoney(p.getUniqueId(), money, false, true, false);
                        }
                    }
                }
            }
        }
    }

}
