package me.bluenitrox.school.dungeon.manager;

import me.bluenitrox.school.SchoolMode;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.LinkedList;

public class DungeonManager {

    public static LinkedList<Player> playerindungeon = new LinkedList<>();
    public boolean shouldMonsterSpawn = false;
    private int Maxpoints = 1;
    private int Maxdungeon = 1;

    public void onJoinDungeon(Player p){
        playerindungeon.add(p);
        p.sendMessage(MessageManager.PREFIX + "§7Du wurdest in die §6Dungeonwelt §7teleportiert.");
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
        shouldMonsterSpawn = true;
        startMonsterSpawn();
        p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60*60, 1));
    }

    public void onQuitDungeon(Player p){
        if(playerindungeon != null){
            playerindungeon.remove(p);
        }
        if(playerindungeon == null){
            shouldMonsterSpawn = false;
        }
        p.removePotionEffect(PotionEffectType.NIGHT_VISION);
    }

    public void startMonsterSpawn(){
        /*
        Example Point: spawn1dungeon2
         */
        new BukkitRunnable() {
            @Override
            public void run() {
                if(shouldMonsterSpawn){
                    if(new LocationManager("spawn1dungeon1").getLocation() != null) {
                        for (int i2 = 1; i2 <= Maxpoints; i2++) {
                            for (int i = 1; i <= Maxdungeon; i++) {
                                spawnMonster(new LocationManager("spawn" + i2 + "dungeon" + i).getLocation(), i);
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(SchoolMode.getInstance(), 20*25, 20*25);
    }

    private void spawnMonster(Location loc, int dungeon) {
        if(loc == null){
            return;
        }
        if (dungeon == 1) {
            LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            entity.setCustomName("§fZombie §8(§7Level §61§8)");
            entity.setCustomNameVisible(true);
            if (entity.getEquipment() != null) {
                entity.getEquipment().clear();
            }
            entity.getEquipment().setItemInHand(new ItemBuilder(Material.IRON_SWORD).build());

            LivingEntity entity2 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
            entity2.setCustomName("§fSkelett §8(§7Level §61§8)");
            entity2.setCustomNameVisible(true);
            if (entity2.getEquipment() != null) {
                entity2.getEquipment().clear();
            }
            entity2.getEquipment().setItemInHand(new ItemBuilder(Material.IRON_SWORD).build());

            LivingEntity entity3 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
            entity3.setCustomName("§fSpinne §8(§7Level §61§8)");
            entity3.setCustomNameVisible(true);
        } else if (dungeon == 2) {
            //Zombie
            LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
            entity.setCustomName("§fZombie §8(§7Level §65§8)");
            entity.setCustomNameVisible(true);
            if (entity.getEquipment() != null) {
                entity.getEquipment().clear();
            }
            entity.getEquipment().setItemInHand(new ItemBuilder(Material.IRON_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 4, false).build());
            entity.getEquipment().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());
            entity.getEquipment().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, false).build());

            //Skelett
            LivingEntity entity2 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
            entity2.setCustomName("§fSkelett §8(§7Level §65§8)");
            entity2.setCustomNameVisible(true);
            if (entity2.getEquipment() != null) {
                entity2.getEquipment().clear();
            }
            entity2.getEquipment().setItemInHand(new ItemBuilder(Material.BOW).addEnchant(Enchantment.ARROW_DAMAGE, 5, false).build());

            //Hexe
            LivingEntity entity3 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.WITCH);
            entity3.setCustomName("§fHexe §8(§7Level §65§8)");
            entity3.setCustomNameVisible(true);
        } else if (dungeon == 3) {
            //Blaze
            LivingEntity entity = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.BLAZE);
            entity.setCustomName("§fLohe §8(§7Level §610§8)");
            entity.setCustomNameVisible(true);


            //Zombiepig
            LivingEntity entity2 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.PIG_ZOMBIE);
            entity2.setCustomName("§fZombie-Pigman §8(§7Level §610§8)");
            entity2.setCustomNameVisible(true);
            if (entity2.getEquipment() != null) {
                entity2.getEquipment().clear();
            }
            entity2.getEquipment().setItemInHand(new ItemBuilder(Material.GOLD_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 6, true).build());
            entity2.getEquipment().setChestplate(new ItemBuilder(Material.GOLD_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).build());
            entity2.getEquipment().setLeggings(new ItemBuilder(Material.GOLD_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false).build());


            //Skelett
            LivingEntity entity3 = (LivingEntity) loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
            entity3.setCustomName("§fSkelett §8(§7Level §610§8)");
            entity3.setCustomNameVisible(true);
            if (entity3.getEquipment() != null) {
                entity3.getEquipment().clear();
            }
            entity3.getEquipment().setItemInHand(new ItemBuilder(Material.STONE_SWORD).addEnchant(Enchantment.DAMAGE_ALL, 6, true).build());
            entity3.getEquipment().setChestplate(new ItemBuilder(Material.CHAINMAIL_CHESTPLATE).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).build());
            entity3.getEquipment().setLeggings(new ItemBuilder(Material.CHAINMAIL_LEGGINGS).addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, false).build());

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
        }
    }

}
