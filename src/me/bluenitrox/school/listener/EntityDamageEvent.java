package me.bluenitrox.school.listener;

import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityDamageEvent implements Listener {

    @EventHandler
    public void onDamage(final org.bukkit.event.entity.EntityDamageEvent e){
        Pet pet = new Pet();
        pet.damagepet(e);
        WorldManager.turnDamageOff(e);
        AngelminenManager.onDamage(e);
    }

}
