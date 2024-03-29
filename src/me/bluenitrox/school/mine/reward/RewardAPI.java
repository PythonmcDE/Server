package me.bluenitrox.school.mine.reward;

import me.bluenitrox.school.enchants.pickaxe.Ausgrabung;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.Firework;
import me.bluenitrox.school.utils.InventoryUtil;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RewardAPI {

    public void checkToAddReward(Player p){
        if(Ausgrabung.ausgrabung(p)){
            int chance = 1000;
            int randomnumber = new Random().nextInt(chance);

            int chancehundert = 5000;
            int randomnumberhundert = new Random().nextInt(chancehundert);

            if(randomnumber == 10){
                addReward(p, Reward.REDSTONE);
            }else if(randomnumber == 11){
                addReward(p, Reward.EMERALD);
            }else if(randomnumber == 12){
                addReward(p, Reward.FLUGPULVER);
            }else if(randomnumberhundert == 10){
                addReward(p,Reward.REDSTONEBARREN);
            }
        }
        int chance = 20000;
        int randomnumber = new Random().nextInt(chance);

        int chancehundert = 100000;
        int randomnumberhundert = new Random().nextInt(chancehundert);

        if(randomnumber == 10){
            addReward(p, Reward.REDSTONE);
        }else if(randomnumber == 11){
            addReward(p, Reward.EMERALD);
        }else if(randomnumber == 12){
            addReward(p, Reward.FLUGPULVER);
        }else if(randomnumberhundert == 10){
            addReward(p,Reward.REDSTONEBARREN);
        }
    }

    public void addReward(Player p, Reward reward) {
        ItemStack item;
        if (reward.equals(Reward.REDSTONE)){
            item = new ItemBuilder(Material.REDSTONE).setDisplayname("§cRedstone Staub").setLore("§6§l▶ §7Dieser §6Staub §7kann §fverwendet werden§7, um","§6§l▶ §7einen §6mächtigen Apfel §fherzustellen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        }else if (reward.equals(Reward.EMERALD)){
            item = new ItemBuilder(Material.GLOWSTONE_DUST).setDisplayname("§aSmaragd Staub").setLore("§6§l▶ §7Dieser §6Staub §7kann §fverwendet werden§7, um","§6§l▶ §7einen §6mächtigen Apfel §fherzustellen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        }else if (reward.equals(Reward.FLUGPULVER)){
            item = new ItemBuilder(Material.SUGAR_CANE).setDisplayname("§7Flugpulver").setLore("§6§l▶ §7Dieses Pulver §6verleiht dir Flügel§7!","§6§l▶ §7Verwende es um für §62 Minuten §7zu §6§lfliegen§7,", "§6§l▶ §7oder stelle einen mächtigen §9§lFlugtrank §7her.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        }else if (reward.equals(Reward.REDSTONEBARREN)){
            item = new ItemBuilder(Material.NETHER_BRICK_ITEM).setDisplayname("§4Gepresster Redstonebarren").setLore("§6§l▶ §7Dieser §6Barren §7erscheint §5überaus selten§7.","§6§l▶ §7Verwende ihn, um den §6mächtigsten Apfel", "§6§l▶ §7von allen §fherzustellen.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        }else {
            item = new ItemBuilder(Material.AIR).build();
        }
        if(item != null){
            if(!InventoryUtil.isInvFull(p)){
                p.getInventory().addItem(item);
            }else {
                p.getWorld().dropItem(p.getLocation(), item);
            }
        }
        p.sendMessage(MessageManager.PREFIX + "§6Glückwunsch!! §7Du hast gerade ein §asehr seltenes §7Item bekommen!");
        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
        Firework.Firework(p);
    }

}
