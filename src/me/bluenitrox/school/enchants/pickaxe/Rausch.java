package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.mine.commands.Sell;
import me.bluenitrox.school.mine.manager.SellManager;
import org.bukkit.Bukkit;
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
                            MoneyManager.updateMoney(p.getUniqueId(), money, false, true, false);
                        }
                    }
                }
            }
        }
    }

}
