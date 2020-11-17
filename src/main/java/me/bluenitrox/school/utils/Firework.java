package me.bluenitrox.school.utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

public class Firework {

    public static void Firework(Player p){
        org.bukkit.entity.Firework firework = p.getWorld().spawn(p.getLocation(), org.bukkit.entity.Firework.class);
        FireworkEffect effect = FireworkEffect.builder()
                .withColor(Color.RED)
                .flicker(true)
                .trail(true)
                .withFade(Color.AQUA)
                .with(FireworkEffect.Type.BALL_LARGE)
                .build();

        FireworkMeta meta = firework.getFireworkMeta();
        meta.addEffect(effect);
        meta.setPower(1);

        firework.setFireworkMeta(meta);
    }

}
