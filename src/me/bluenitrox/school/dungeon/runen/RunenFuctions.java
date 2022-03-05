package me.bluenitrox.school.dungeon.runen;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Member;
import java.util.LinkedList;
import java.util.UUID;

public class RunenFuctions {

    public static LinkedList<UUID> runejagd = new LinkedList<>();
    public static LinkedList<UUID> runebeschleunigung = new LinkedList<>();
    public static LinkedList<UUID> runeweisheit = new LinkedList<>();


    public void onInterAct(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem() == null) return;
            if(event.getItem().getItemMeta() == null) return;
            if(event.getItem().getType() != Material.SKULL_ITEM) return;

            switch (event.getItem().getItemMeta().getDisplayName()) {
                case "§cRune der Jagd":
                    runejagd.add(player.getUniqueId());
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            runejagd.remove(player.getUniqueId());
                            player.sendMessage(MessageManager.PREFIX + "§7Deine Rune ist nun §cabgelaufen§7!");
                        }
                    }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*60*10);
                    break;
                case "§fRune der Beschleunigung":
                    runebeschleunigung.add(player.getUniqueId());
                    break;
                case "§6Engelsrune":
                    player.setMaxHealth(player.getMaxHealth());
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*20, 4));
                    break;
                case "§eRune der Eile":
                    player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20*60*5, 9));
                    break;
                case "§2Rune der Weisheit":
                    runeweisheit.add(player.getUniqueId());
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            runeweisheit.remove(player.getUniqueId());
                            player.sendMessage(MessageManager.PREFIX + "§7Deine Rune ist nun §cabgelaufen§7!");
                        }
                    }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 20*60*15);
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
            player.playSound(player.getLocation(), Sound.NOTE_PLING, 1L, 1L);
            player.sendMessage(MessageManager.PREFIX + "§7Du hast " + event.getItem().getItemMeta().getDisplayName() + "§7 aktiviert!");
            player.getInventory().remove(event.getItem());
        }
    }

    public static boolean speedUpRune(UUID uuid){
        if(runebeschleunigung != null) {
            if (runebeschleunigung.contains(uuid)) {
                return true;
            }
        }
        return false;
    }

}
