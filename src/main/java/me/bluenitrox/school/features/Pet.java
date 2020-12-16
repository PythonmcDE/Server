package me.bluenitrox.school.features;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftCreature;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class Pet {

    public String guiname = "§6§lHaustiere";
    public static ArrayList<Player> openCooldown = new ArrayList<>();
    public static ArrayList<Player> petremoved = new ArrayList<>();

    public Pet(){
    }

    public void openPetInventory(Player p){
        if(!openCooldown.contains(p)) {
            Inventory inv = Bukkit.createInventory(null, 9 * 6, guiname);

            setPetContent(inv, p);

            p.openInventory(inv);
            openCooldown.add(p);
        }else {
            p.sendMessage(MessageManager.PREFIX + "§7Warte einen Augenblick bis du das §aPet-Menü §7wieder öffnen kannst.");
        }
    }

    public void petClickEventInventory(final InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null){
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.MONSTER_EGG){
                PetAPI api = new PetAPI();
                createPet((Player) e.getWhoClicked(), api.itemToEntity(e.getCurrentItem()));
                e.getWhoClicked().closeInventory();
                startRunnable(p, entityToPetType(api.itemToEntity(e.getCurrentItem())));
            }else if(e.getCurrentItem().getType() == Material.BARRIER){
                if(SchoolMode.Pets.containsKey(p.getName())){
                    SchoolMode.Pets.get(p.getName()).remove();
                    petremoved.add(p);
                }
            }
        }
    }

    public void startRunnable(Player p, PetType pet){
        PetAPI api = new PetAPI();
        if(pet == PetType.FARID) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(p == null){
                        this.cancel();
                    }
                    if(petremoved.contains(p)){
                        petremoved.remove(p);
                        this.cancel();
                    }
                    if(makeOrNot80(expToLevel(api.getFarid(p.getUniqueId())))){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1, 20*3));
                    }
                }
            }.runTaskTimerAsynchronously(SchoolMode.getInstance(), 20*10, 20*10);
        }else if(pet == PetType.EDDY) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(p == null){
                        this.cancel();
                    }
                    if(petremoved.contains(p)){
                        petremoved.remove(p);
                        this.cancel();
                    }
                    if(makeOrNot80(expToLevel(api.getEddy(p.getUniqueId())))){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1, 20*3));
                    }
                }
            }.runTaskTimerAsynchronously(SchoolMode.getInstance(), 20*10, 20*10);
        }else if(pet == PetType.HELGAR) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(p == null){
                        this.cancel();
                    }
                    if(petremoved.contains(p)){
                        petremoved.remove(p);
                        this.cancel();
                    }
                    if(makeOrNot80(expToLevel(api.getHelgar(p.getUniqueId())))){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 20*3));
                    }
                }
            }.runTaskTimerAsynchronously(SchoolMode.getInstance(), 20*10, 20*10);
        }else if(pet == PetType.MERLIN) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if(p == null){
                        this.cancel();
                    }
                    if(petremoved.contains(p)){
                        petremoved.remove(p);
                        this.cancel();
                    }
                    if(makeOrNot80(expToLevel(api.getMerlin(p.getUniqueId())))){
                        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1, 20*3));
                        p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1, 20*3));
                    }
                }
            }.runTaskTimerAsynchronously(SchoolMode.getInstance(), 20*10, 20*10);

        }
    }

    private boolean makeOrNot80(int i){
        int r = new Random().nextInt(15);

        switch (r){
            case 1:
                if(i == 10 || i == 9|| i == 8|| i == 7|| i == 6|| i == 5|| i == 4|| i == 3|| i == 2|| i == 1){
                    return true;
                }else {
                    return false;
                }
            case 2:
                if(i == 10 || i == 9|| i == 8|| i == 7|| i == 6|| i == 5|| i == 4|| i == 3|| i == 2){
                    return true;
                }else {
                    return false;
                }
            case 3:
                if(i == 10 || i == 9|| i == 8|| i == 7|| i == 6|| i == 5|| i == 4|| i == 3){
                    return true;
                }else {
                    return false;
                }
            case 4:
                if(i == 10 || i == 9|| i == 8|| i == 7|| i == 6|| i == 5|| i == 4){
                    return true;
                }else {
                    return false;
                }
            case 5:
                if(i == 10 || i == 9|| i == 8|| i == 7|| i == 6|| i == 5){
                    return true;
                }else {
                    return false;
                }
            case 6:
                if(i == 10 || i == 9|| i == 8|| i == 7|| i == 6){
                    return true;
                }else {
                    return false;
                }
            case 7:
                if(i == 10 || i == 9|| i == 8|| i == 7){
                    return true;
                }else {
                    return false;
                }
            case 8:
                if(i == 10 || i == 9|| i == 8){
                    return true;
                }else {
                    return false;
                }
            case 9:
                if(i == 10 || i == 9){
                    return true;
                }else {
                    return false;
                }
            case 10:
                if(i == 10){
                    return true;
                }else {
                    return false;
                }
            default:
                return false;
        }
    }

    public void petEinlösen(Player p, PlayerInteractEvent e){
        PetAPI api = new PetAPI();
        UUID uuid = p.getUniqueId();

        if(p.getItemInHand().getItemMeta().getDisplayName().startsWith("§6Haustier")) {
            e.setCancelled(true);

            if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haustier : Benjamin")) {
                if (api.getBenjamin(uuid) == 0) {
                    api.updateBenjamin(uuid, 1, false);
                    p.sendMessage(MessageManager.PETUSED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                } else {
                    p.sendMessage(MessageManager.PETALREADYHAS);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return;
                }
            } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haustier : Merlin")) {
                if (api.getMerlin(uuid) == 0) {
                    api.updateMerlin(uuid, 1, false);
                    p.sendMessage(MessageManager.PETUSED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                } else {
                    p.sendMessage(MessageManager.PETALREADYHAS);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return;
                }
            } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haustier : Eddy")) {
                if (api.getEddy(uuid) == 0) {
                    api.updateEddy(uuid, 1, false);
                    p.sendMessage(MessageManager.PETUSED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                } else {
                    p.sendMessage(MessageManager.PETALREADYHAS);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return;
                }
            } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haustier : Anton")) {
                if (api.getAnton(uuid) == 0) {
                    api.updateAnton(uuid, 1, false);
                    p.sendMessage(MessageManager.PETUSED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                } else {
                    p.sendMessage(MessageManager.PETALREADYHAS);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return;
                }
            } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haustier : Helgar")) {
                if (api.getHelgar(uuid) == 0) {
                    api.updateHelgar(uuid, 1, false);
                    p.sendMessage(MessageManager.PETUSED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                } else {
                    p.sendMessage(MessageManager.PETALREADYHAS);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return;
                }
            } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haustier : Farid")) {
                if (api.getFarid(uuid) == 0) {
                    api.updateFarid(uuid, 1, false);
                    p.sendMessage(MessageManager.PETUSED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                } else {
                    p.sendMessage(MessageManager.PETALREADYHAS);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return;
                }
            } else if (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6Haustier : Peter")) {
                if (api.getPeter(uuid) == 0) {
                    api.updatePeter(uuid, 1, false);
                    p.sendMessage(MessageManager.PETUSED);
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                } else {
                    p.sendMessage(MessageManager.PETALREADYHAS);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    return;
                }
            }
            if (p.getItemInHand().getAmount() > 1) {
                p.getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
            } else if (p.getItemInHand().getAmount() == 1) {
                ItemStack air = new ItemStack(Material.AIR);
                p.setItemInHand(air);
            }
        }
    }

    private void setPetContent(Inventory inv, Player p){
        UUID uuid = p.getUniqueId();
        PetAPI api = new PetAPI();

        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack glasblack = new ItemBuilder(Material.STAINED_GLASS_PANE,(short)15).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lTiere").setLore("§6§l▶ §7Werte deine Tiere hier auf, um ihre", "§6§l▶ §6Fähigkeiten §7zu §averbessern§7.", " ", "§cInfo:", "§8● §6Tiere §7bekommt man aus §c§lTiercases§7,", "§8● §7diese findest du in der Warzone.").build();
        ItemStack barrier = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §7Aktuelles Tier despawnen").build();
        ItemStack barrier2 = new ItemBuilder(Material.BARRIER).setDisplayname("§8» §cDu besitzt dieses Haustier noch nicht.").build();


        for(int i = 0; i<= 8; i++){
            inv.setItem(i,glas);
        }
        inv.setItem(4,sign);

        for(int i = 36; i<=44; i++){
            inv.setItem(i,glas);
        }
        for(int i = 45; i<= 53; i++){
            inv.setItem(i,glasblack);
        }
        inv.setItem(49,barrier);

        if(api.getBenjamin(uuid) > 0){
            ItemStack tie1 = new ItemBuilder(Material.MONSTER_EGG, (short) 67).setDisplayname("§6Haustier : Benjamin").setLore("§7Statistiken:","§8● §7Aktuelles Level:§6 " + getLevel(p,PetType.BENJAMIN),"§8● §7Akuelles XP:§6 " + api.getBenjamin(p.getUniqueId())," ","§8» §aKlicke hier§7, um dieses §6Haustier §7zu §aspawnen§7.").build();
            inv.setItem(9,tie1);
        }else {
            inv.setItem(9,barrier2);
        }

        if(api.getMerlin(uuid) > 0){
            ItemStack tie2 = new ItemBuilder(Material.MONSTER_EGG, (short) 65).setDisplayname("§6Haustier : Merlin").setLore("§7Statistiken:","§8● §7Aktuelles Level:§6 " + getLevel(p,PetType.MERLIN),"§8● §7Akuelles XP:§6 " + api.getMerlin(p.getUniqueId())," ","§8» §aKlicke hier§7, um dieses §6Haustier §7zu §aspawnen§7.").build();
            inv.setItem(10,tie2);
        }else {
            inv.setItem(10,barrier2);
        }

        if(api.getEddy(uuid) > 0){
            ItemStack tie3 = new ItemBuilder(Material.MONSTER_EGG, (short) 62).setDisplayname("§6Haustier : Eddy").setLore("§7Statistiken:","§8● §7Aktuelles Level:§6 " + getLevel(p,PetType.EDDY),"§8● §7Akuelles XP:§6 " + api.getEddy(p.getUniqueId())," ","§8» §aKlicke hier§7, um dieses §6Haustier §7zu §aspawnen§7.").build();
            inv.setItem(11,tie3);
        }else {
            inv.setItem(11,barrier2);
        }

        if(api.getAnton(uuid) > 0){
            ItemStack tie4 = new ItemBuilder(Material.MONSTER_EGG, (short) 98).setDisplayname("§6Haustier : Anton").setLore("§7Statistiken:","§8● §7Aktuelles Level:§6 " + getLevel(p,PetType.ANTON),"§8● §7Akuelles XP:§6 " + api.getAnton(p.getUniqueId())," ","§8» §aKlicke hier§7, um dieses §6Haustier §7zu §aspawnen§7.").build();
            inv.setItem(12,tie4);
        }else {
            inv.setItem(12,barrier2);
        }

        if(api.getHelgar(uuid) > 0){
            ItemStack tie5 = new ItemBuilder(Material.MONSTER_EGG, (short) 93).setDisplayname("§6Haustier : Helgar").setLore("§7Statistiken:","§8● §7Aktuelles Level:§6 " + getLevel(p,PetType.HELGAR),"§8● §7Akuelles XP:§6 " + api.getHelgar(p.getUniqueId())," ","§8» §aKlicke hier§7, um dieses §6Haustier §7zu §aspawnen§7.").build();
            inv.setItem(13,tie5);
        }else {
            inv.setItem(13,barrier2);
        }

        if(api.getFarid(uuid) > 0){
            ItemStack tie6 = new ItemBuilder(Material.MONSTER_EGG, (short) 95).setDisplayname("§6Haustier : Farid").setLore("§7Statistiken:","§8● §7Aktuelles Level:§6 " + getLevel(p,PetType.FARID),"§8● §7Akuelles XP:§6 " + api.getFarid(p.getUniqueId())," ","§8» §aKlicke hier§7, um dieses §6Haustier §7zu §aspawnen§7.").build();
            inv.setItem(14,tie6);
        }else {
            inv.setItem(14,barrier2);
        }

        if(api.getPeter(uuid) > 0){
            ItemStack tie7 = new ItemBuilder(Material.MONSTER_EGG, (short) 101).setDisplayname("§6Haustier : Peter").setLore("§7Statistiken:","§8● §7Aktuelles Level:§6 " + getLevel(p,PetType.PETER),"§8● §7Akuelles XP:§6 " + api.getPeter(p.getUniqueId())," ","§8» §aKlicke hier§7, um dieses §6Haustier §7zu §aspawnen§7.").build();
            inv.setItem(15,tie7);
        }else {
            inv.setItem(15,barrier2);
        }
    }

    public void movePetEvent(Player player){
        if(SchoolMode.Pets.containsKey(player.getName())){
            new Pet().followPlayer((Creature)SchoolMode.Pets.get(player.getName()), player, 1.4);
        }
    }

    public void damagePetEvent(EntityDamageByEntityEvent event){
        if(SchoolMode.Pets.containsValue(event.getEntity())){
            event.setCancelled(true);
        }
        if(event.getDamager() != null){
            Entity damager = (Entity)event.getDamager();
            if(SchoolMode.Pets.containsValue(damager)){
                event.setCancelled(true);
            }
        }
    }

    public void damagepet(EntityDamageEvent e){
        if(SchoolMode.Pets.containsValue(e.getEntity())){
            e.setCancelled(true);
        }
    }

    public PetType entityToPetType(EntityType type){
        if(type == EntityType.WOLF){
            return PetType.FARID;
        }else if(type == EntityType.ENDERMITE){
            return PetType.BENJAMIN;
        }else if(type == EntityType.MAGMA_CUBE){
            return PetType.EDDY;
        }else if(type == EntityType.BAT){
            return PetType.MERLIN;
        }else if(type == EntityType.OCELOT){
            return PetType.ANTON;
        }else if(type == EntityType.CHICKEN){
            return PetType.HELGAR;
        }else if(type == EntityType.RABBIT){
            return PetType.PETER;
        }else {
            return null;
        }
    }

    public String petTypeToEntity(PetType type){
        if(type == PetType.FARID){
            return "Farid";
        }else if(type == PetType.BENJAMIN){
            return "Benjamin";
        }else if(type == PetType.EDDY){
            return "Eddy";
        }else if(type == PetType.MERLIN){
            return "Merlin";
        }else if(type == PetType.ANTON){
            return "Anton";
        }else if(type == PetType.HELGAR){
            return "Helgar";
        }else if(type == PetType.PETER){
            return "Peter";
        }else {
            return null;
        }
    }

    private int expToLevel(int petxp){
        if(petxp >= 40900){
            return 10;
        }else if(petxp >= 31700){
            return 9;
        }else if(petxp >= 24200){
            return 8;
        }else if(petxp >= 18100){
            return 7;
        }else if(petxp >= 12000){
            return 6;
        }else if(petxp >= 7200){
            return 5;
        }else if(petxp >= 3700){
            return 4;
        }else if(petxp >= 1500){
            return 3;
        }else if(petxp >= 500){
            return 2;
        }else {
            return 1;
        }
    }

    public void createPet(Player player, EntityType type){
        if(SchoolMode.Pets != null) {
            if (SchoolMode.Pets.containsKey(player.getName())) {
                for (Entity all : player.getWorld().getEntities()) {
                    if (all.getName().equalsIgnoreCase("§8[§6" + getLevel(player,entityToPetType(type)) + "§8] " + player.getDisplayName() + " 's §6§lTier")) {
                        all.remove();
                    }
                }
                SchoolMode.Pets.get(player.getName()).remove();
            }
        }
        Entity entity = (Entity) player.getWorld().spawnEntity(player.getLocation(), type);
        entity.setCustomName("§8[§6" + getLevel(player,entityToPetType(type)) + "§8] " + player.getDisplayName() + " 's §6§lTier");
        entity.setCustomNameVisible(true);
        SchoolMode.Pets.put(player.getName(), entity);
        player.playSound(player.getLocation(), Sound.BAT_DEATH, 1L, 1L);
    }

    private void followPlayer(Creature creature, Player player, double Speed){
        Location location = player.getLocation();
        Random rnd = new Random();
        int zufall = rnd.nextInt(6);
        switch(zufall){
            case 0:
                location.add(1.5,0,1.5);
                break;
            case 1:
                location.add(0,0,1.5);
                break;
            case 2:
                location.add(1.5,0,0);
                break;
            case 3:
                location.subtract(1.5,0,1.5);
                break;
            case 4:
                location.subtract(0,0,1.5);
                break;
            case 5:
                location.subtract(1.5,0,0);
                break;
        }


        if(location.distanceSquared(creature.getLocation()) > 200){
            if(!player.isOnGround()){
                return;
            }
            creature.teleport(location);
        }else{
            ((CraftCreature)creature).getHandle().getNavigation().a(location.getX(),location.getY(),location.getZ(),Speed);
        }
    }

    private int getLevel(Player p, PetType type){
        int level = 1;
        PetAPI api = new PetAPI();

        int petxp = api.getPet(p.getUniqueId(),petTypeToEntity(type));

        level = expToLevel(petxp);

        return level;
    }

}
