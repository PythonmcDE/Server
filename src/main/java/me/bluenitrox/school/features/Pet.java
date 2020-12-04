package me.bluenitrox.school.features;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftCreature;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Pet {

    public String guiname = "§6§lHaustiere";

    public Pet(){
    }

    public void openPetInventory(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*4, guiname);

        setPetContent(inv, p);

        p.openInventory(inv);
    }

    public void setPetContent(Inventory inv, Player p){
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§8» §6§lTiere").setLore("§6§l▶ §7Werte deine Tiere hier auf, um ihre", "§6§l▶ §6Fähigkeiten §7zu §averbessern§7.", " ", "§cInfo:", "§8● §6Tiere §7bekommt man aus §c§lTiercases§7,", "§8● §7diese findest du in der Warzone.").build();

        for(int i = 0; i<= 8; i++){
            inv.setItem(i,glas);
        }
        inv.setItem(4,sign);

        for(int i = 36; i<=44; i++){
            inv.setItem(i,glas);
        }
    }

    public void movePetEvent(Player player){
        if(SchoolMode.Pets.containsKey(player.getName())){
            new Pet().followPlayer((Creature)SchoolMode.Pets.get(player.getName()), player, 1.6);
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

    public void createPet(Player player, EntityType type){
        if(SchoolMode.Pets.containsKey(player.getName())) {
            for(Entity all: player.getWorld().getEntities()){
                if(all.getName().equalsIgnoreCase("§c" + player.getName() + "'s Haustier")){
                    all.remove();
                }
            }
            SchoolMode.Pets.get(player.getName()).remove();
        }
        Entity entity = (Entity) player.getWorld().spawnEntity(player.getLocation(), type);
        entity.setCustomName("§c" + player.getName() + "'s Haustier");
        entity.setCustomNameVisible(true);
        SchoolMode.Pets.put(player.getName(), entity);
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

}
