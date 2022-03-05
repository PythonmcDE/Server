package me.bluenitrox.school.dungeon.runen;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class RunenFuctions {

    public void onInterAct(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem() == null) return;
            if(event.getItem().getItemMeta() == null) return;
            if(event.getItem().getType() != Material.SKULL_ITEM) return;

            switch (event.getItem().getItemMeta().getDisplayName()) {
                case "§cRune der Jagd":
                    //TODO
                    break;
                case "§fRune der Beschleunigung":
                    //TODO
                    break;
                case "§6Engelsrune":
                    player.setMaxHealth(player.getMaxHealth());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*20, 4));
                    break;
                case "§eRune der Eile":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20*60*5, 2));
                    break;
                case "§2Rune der Weisheit":
                    //TODO
                    break;
                case "§6Rune der Stärke":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20*60*5, 1));
                    break;
                case "§fRune der Geschwindigkeit":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20*60, 1));
                    break;
                case "§8Rune der Todesaura":
                    //TODO
                    break;
                case "§aRune der Regeneration":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*60*5, 1));
                    break;
            }
            player.getInventory().remove(event.getItem());
        }
    }

}
