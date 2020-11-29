package me.bluenitrox.school.features;

import me.bluenitrox.school.SchoolMode;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftCreature;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Random;

public class Pet {

    public Pet(){
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

    public void createPet(Player player, EntityType type){
        Entity entity = (Entity)player.getWorld().spawnEntity(player.getLocation(), type);
        entity.setCustomName(player.getName());
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


        if(location.distanceSquared(creature.getLocation()) > 100){
            if(!player.isOnGround()){
                return;
            }
            creature.teleport(location);
        }else{
            ((CraftCreature)creature).getHandle().getNavigation().a(location.getX(),location.getY(),location.getZ(),Speed);
        }
    }

}
