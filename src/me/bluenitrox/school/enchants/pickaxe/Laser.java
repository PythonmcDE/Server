package me.bluenitrox.school.enchants.pickaxe;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.enchants.function.EnchantAPI;
import me.bluenitrox.school.enchants.function.EnchantManager;
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
            shoot.add(player);
            player.launchProjectile(Snowball.class);
            if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 1){
                timer(25, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 2){
                timer(22, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 3){
                timer(19, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 4){
                timer(16, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 5){
                timer(13, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 6){
                timer(10, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 7){
                timer(7, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 8){
                timer(5, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 9){
                timer(3, player);
            }else if(stringToNumber(player.getItemInHand(), EnchantManager.Laser) == 10){
                timer(1, player);
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
