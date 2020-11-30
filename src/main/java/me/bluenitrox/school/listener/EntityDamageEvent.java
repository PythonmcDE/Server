package me.bluenitrox.school.listener;

import me.bluenitrox.school.features.Pet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityDamageEvent implements Listener {

    @EventHandler
    public void onDamage(final org.bukkit.event.entity.EntityDamageEvent e){
        Pet pet = new Pet();
        pet.damagepet(e);
    }

}
