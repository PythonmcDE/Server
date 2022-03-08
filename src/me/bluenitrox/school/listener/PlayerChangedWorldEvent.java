package me.bluenitrox.school.listener;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.features.pets.Pet;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerChangedWorldEvent implements Listener {

    @EventHandler
    public void onChange(final org.bukkit.event.player.PlayerChangedWorldEvent e){
        Player p = e.getPlayer();
        if(SchoolMode.Pets.containsKey(p.getName())){
            SchoolMode.Pets.get(p.getName()).remove();
            Pet.petremoved.add(p);
        }
    }

}
