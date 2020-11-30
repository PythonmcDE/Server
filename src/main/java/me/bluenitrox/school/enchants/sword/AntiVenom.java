package me.bluenitrox.school.enchants.sword;

import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

public class AntiVenom extends EnchantAPI {

    public static void antiVenomAuslösen(Player damager) {
        if (hasEnchant(damager, EnchantManager.AntiVenom)) {
            if (makeOrNot50(stringToNumber(damager.getItemInHand(), EnchantManager.AntiVenom))) {
                damager.playSound(damager.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                removeEffects(damager);
            }
        }
    }

    private static void removeEffects(Player p){
        if(p.hasPotionEffect(PotionEffectType.BLINDNESS)){
            p.removePotionEffect(PotionEffectType.BLINDNESS);
        }else if(p.hasPotionEffect(PotionEffectType.POISON)){
            p.removePotionEffect(PotionEffectType.POISON);
        }else if(p.hasPotionEffect(PotionEffectType.WEAKNESS)){
            p.removePotionEffect(PotionEffectType.WEAKNESS);
        }else if(p.hasPotionEffect(PotionEffectType.SLOW)){
            p.removePotionEffect(PotionEffectType.SLOW);
        }else if(p.hasPotionEffect(PotionEffectType.SLOW_DIGGING)){
            p.removePotionEffect(PotionEffectType.SLOW_DIGGING);
        }else if(p.hasPotionEffect(PotionEffectType.CONFUSION)){
            p.removePotionEffect(PotionEffectType.CONFUSION);
        }else if(p.hasPotionEffect(PotionEffectType.HARM)){
            p.removePotionEffect(PotionEffectType.HARM);
        }else if(p.hasPotionEffect(PotionEffectType.HUNGER)){
            p.removePotionEffect(PotionEffectType.HUNGER);
        }else if(p.hasPotionEffect(PotionEffectType.WITHER)){
            p.removePotionEffect(PotionEffectType.WITHER);
        }
    }

}
