package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.EnchantAPI;
import me.bluenitrox.school.managers.EnchantManager;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class Laser extends EnchantAPI {

    private static LinkedList<Player> shoot = new LinkedList<>();

    public static void shootLaser(Player player){
        if(player.getItemInHand() == null) return;
        if(player.getItemInHand().getItemMeta() == null) return;
        if(player.getItemInHand().getItemMeta().getLore() == null) return;

        if(hasEnchant(player.getItemInHand(), EnchantManager.Laser)){
            if(shoot.contains(player)){
                return;
            }
            if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 1){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(30, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 2){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(27, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 3){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(24, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 4){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(21, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 5){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(18, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 6){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(15, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 7){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(12, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 8){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(9, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 9){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(6, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 10){
                player.launchProjectile(Snowball.class);
                shoot.add(player);
                timer(3, player);
            }
        }
    }

    private static void timer(int time, Player player){
        new BukkitRunnable() {
            @Override
            public void run() {
                shoot.remove(player);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), time);
    }

}
