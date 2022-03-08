package me.bluenitrox.school.listener;

import me.bluenitrox.school.enchants.armor.Tank;
import me.bluenitrox.school.features.pets.Pet;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerMoveEvent implements Listener {

    @EventHandler
    public void onMove(final org.bukkit.event.player.PlayerMoveEvent e){
        Pet pet = new Pet();
        pet.movePetEvent(e.getPlayer());
        CombatAPI api = new CombatAPI();
        Tank.setTankForAll(e.getPlayer());
        api.joinwarzone(e);
    }

}
