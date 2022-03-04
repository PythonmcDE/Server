package me.bluenitrox.school.dungeon.manager;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;

public class DungeonManager {

    public static HashMap<Player, Integer> playerdungeon = new HashMap<>();
    private static int Maxpoints = 40;

    public void onJoinDungeon(Player p){
        p.sendMessage(MessageManager.PREFIX + "§7Du wurdest in die §6Dungeonwelt §7teleportiert.");
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60*60, 1));
    }

    public void onQuitDungeon(Player p){
        playerdungeon.remove(p);
    }

    public static void startMonsterSpawn(int dungeon, Player player){
        /*
        Example Point: spawn1dungeon2
         */
        playerdungeon.put(player, dungeon);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (playerdungeon.containsKey(player)) {
                    if (new LocationManager("spawn1dungeon1").getLocation() != null) {
                        for (int i2 = 1; i2 <= 5; i2++) {
                            Random r = new Random();
                            int z = r.nextInt(Maxpoints +1);
                            if(z != 0) {
                                spawnMonster(new LocationManager("spawn" + z + "dungeon" + dungeon).getLocation(), dungeon);
                            }
                        }
                    }
                } else {
                    this.cancel();
                }
            }
        }.runTaskTimer(SchoolMode.getInstance(), 20*20, 20*20);
    }

    private static void spawnMonster(Location loc, int dungeon) {
        if(loc == null){
            return;
        }
        Random r = new Random();
        int z = r.nextInt(3);
        if (dungeon == 1) {
            switch (z){
                case 0:
                    LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                    entity.setCustomName("§fZombie §8(§7Level §61§8)");
                    entity.setCustomNameVisible(true);
                    entity.getEquipment().setHelmet(new ItemBuilder(Material.AIR).build());
                    entity.getEquipment().setChestplate(new ItemBuilder(Material.AIR).build());
                    entity.getEquipment().setLeggings(new ItemBuilder(Material.AIR).build());
                    entity.getEquipment().setBoots(new ItemBuilder(Material.AIR).build());
                    entity.getEquipment().setItemInHand(new ItemBuilder(Material.IRON_SWORD).build());
                    break;
                case 1:
                    LivingEntity entity2 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
                    entity2.setCustomName("§fSkelett §8(§7Level §61§8)");
                    entity2.setCustomNameVisible(true);
                    entity2.getEquipment().setHelmet(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setChestplate(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setLeggings(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setBoots(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setItemInHand(new ItemBuilder(Material.IRON_SWORD).build());
                    break;
                case 2:
                    LivingEntity entity3 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
                    entity3.setCustomName("§fSpinne §8(§7Level §61§8)");
                    entity3.setCustomNameVisible(true);
                    break;
            }
        }else if (dungeon == 2) {
            switch (z){
                case 0:
                    //Zombie
                    LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                    entity.setCustomName("§fZombie §8(§7Level §65§8)");
                    entity.getEquipment().setHelmet(new ItemBuilder(Material.AIR).build());
                    entity.getEquipment().setBoots(new ItemBuilder(Material.AIR).build());
                    entity.getEquipment().setItemInHand(new ItemBuilder(Material.IRON_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 4, false).build());
                    entity.getEquipment().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());
                    entity.getEquipment().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());

                    break;
                case 1:
                    //Skelett
                    LivingEntity entity2 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
                    entity2.setCustomName("§fSkelett §8(§7Level §65§8)");
                    entity2.setCustomNameVisible(true);
                    entity2.getEquipment().setHelmet(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setChestplate(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setLeggings(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setBoots(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setItemInHand(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 5, false).build());

                    break;
                case 2:
                    //Hexe
                    LivingEntity entity3 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.WITCH);
                    entity3.setCustomName("§fHexe §8(§7Level §65§8)");
                    entity3.setCustomNameVisible(true);
                    break;
            }
        } else if (dungeon == 3) {
            switch (z){
                case 1:
                    //Skelett
                    //TODO am besten zu Witherskelett ändern
                    LivingEntity entity3 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
                    entity3.setCustomName("§fSkelett §8(§7Level §610§8)");
                    entity3.setCustomNameVisible(true);
                    entity3.getEquipment().setHelmet(new ItemBuilder(Material.AIR).build());
                    entity3.getEquipment().setBoots(new ItemBuilder(Material.AIR).build());
                    entity3.getEquipment().setItemInHand(new ItemBuilder(Material.STONE_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 6, true).build());
                    entity3.getEquipment().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).build());
                    entity3.getEquipment().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).build());
                    break;
                case 2:
                    //Zombiepig
                    LivingEntity entity2 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.PIG_ZOMBIE);
                    entity2.setCustomName("§fZombie-Pigman §8(§7Level §610§8)");
                    entity2.setCustomNameVisible(true);
                    entity2.getEquipment().setHelmet(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setBoots(new ItemBuilder(Material.AIR).build());
                    entity2.getEquipment().setItemInHand(new ItemBuilder(Material.GOLD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 6, true).build());
                    entity2.getEquipment().setChestplate(new ItemBuilder(Material.GOLD_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).build());
                    entity2.getEquipment().setLeggings(new ItemBuilder(Material.GOLD_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).build());
                    break;
                case 0:
                    //Blaze
                    LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.BLAZE);
                    entity.setCustomName("§fLohe §8(§7Level §610§8)");
                    entity.setCustomNameVisible(true);
                    break;
            }
        }
    }

    public static void entityDeathItemAdd(EntityDeathEvent e){
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(WorldManager.dungeon)){
            if(e.getEntity() instanceof Zombie){
                if(e.getEntity().getName() != null) {
                    if (e.getEntity().getName().equalsIgnoreCase("§fZombie §8(§7Level §61§8)")) {
                        if(e.getDrops() != null) {
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.ROTTEN_FLESH).setDisplayname("§aZombie Haut").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }else if (e.getEntity().getName().equalsIgnoreCase("§fZombie §8(§7Level §65§8)")) {
                        if(e.getDrops() != null) {
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.SKULL_ITEM,(short) 2).setDisplayname("§aGammeliger Zombiekopf").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }
                }
            }else if(e.getEntity() instanceof Skeleton){
                if(e.getEntity().getName() != null) {
                    if (e.getEntity().getName().equalsIgnoreCase("§fSkelett §8(§7Level §61§8)")) {
                        if(e.getDrops() != null) {
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.FLINT).setDisplayname("§aAbgebroche Pfeilspitze").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }else if (e.getEntity().getName().equalsIgnoreCase("§fSkelett §8(§7Level §65§8)")) {
                        if(e.getDrops() != null) {
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.SKULL_ITEM).setDisplayname("§aZerbrechlicher Skelettschädel").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }else if (e.getEntity().getName().equalsIgnoreCase("§fSkelett §8(§7Level §610§8)")) {
                        if(e.getDrops() != null) {
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.SKULL_ITEM,(short)1).setDisplayname("§aVerkohlter Skelettschädel").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }
                }
            }else if(e.getEntity() instanceof Spider){
                if(e.getEntity().getName() != null) {
                    if (e.getEntity().getName().equalsIgnoreCase("§fSpinne §8(§7Level §61§8)")) {
                        if(e.getDrops() != null) {
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.SPIDER_EYE).setDisplayname("§aSpinnenfuß").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }
                }
            }else if(e.getEntity() instanceof Witch){
                if(e.getEntity().getName() != null){
                    if(e.getEntity().getName().equalsIgnoreCase("§fHexe §8(§7Level §65§8)")){
                        if(e.getDrops() != null){
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.INK_SACK,(short)7).setDisplayname("§aWollfetzen eines Hexenhuts").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }
                }
            }else if(e.getEntity() instanceof PigZombie){
                if(e.getEntity().getName() != null){
                    if(e.getEntity().getName().equalsIgnoreCase("§fZombie-Pigman §8(§7Level §610§8)")){
                        if(e.getDrops() != null){
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.GOLD_NUGGET).setDisplayname("§aGoldener Klumpen").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }
                }
            }else if(e.getEntity() instanceof Blaze){
                if(e.getEntity().getName() != null){
                    if(e.getEntity().getName().equalsIgnoreCase("§fLohe §8(§7Level §610§8)")){
                        if(e.getDrops() != null){
                            e.getDrops().clear();
                        }
                        e.getDrops().add(new ItemBuilder(Material.BLAZE_POWDER).setDisplayname("§aHeiße Lohenglut").setLore("§8» §7Dieses §6§lItem §7wurde von einem §c§lMonster §7aus", "§8» §7dem §c§lDungeon §7fallengelassen, verwende es", "§8» §7für ein §6mächtiges §lCrafting-Rezept§7.").build());
                    }
                }
            }
            if(e.getEntity().getKiller() != null) {
                if(e.getEntity().getKiller() instanceof Player) {
                    UUID uuid = e.getEntity().getKiller().getUniqueId();
                    if (AufgabenManager.getTask(uuid) == 21) {
                        AufgabenManager.onComplete(uuid,21);
                    }
                }
            }
        }

           }

}
