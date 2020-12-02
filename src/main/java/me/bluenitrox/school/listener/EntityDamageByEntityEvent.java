package me.bluenitrox.school.listener;

import me.bluenitrox.school.enchants.sword.*;
import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.utils.ArmorUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityDamageByEntityEvent implements Listener {

    @EventHandler
    public void onDamage(final org.bukkit.event.entity.EntityDamageByEntityEvent e){
        Pet pet = new Pet();
        pet.damagePetEvent(e);
        if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            Player damager = (Player) e.getDamager();
            Player entity = (Player)e.getEntity();
            if(damager.getItemInHand() != null){
                if(damager.getItemInHand().getItemMeta() != null){
                    if(damager.getItemInHand().getItemMeta().getLore() != null){
                        Fluch.fluchAuslösen(damager, entity);
                        Assassine.assassineAuslösen(damager, entity, e);
                        Vampir.vampirAuslösen(damager, entity, e);
                        Kobra.kobraAuslösen(damager, entity);
                        Energieentzug.energieentzugAuslösen(damager, entity);
                        AntiVenom.antiVenomAuslösen(damager);
                    }
                }
            }
            ArmorUtil util = new ArmorUtil();
            if(util.hasHelmetWithEnchant(entity)){

            }
            if(util.hasChestplateWithEnchant(entity)){

            }
            if(util.hasLegginsWithEnchant(entity)){

            }
            if(util.hasBootsWithEnchant(entity)){

            }
        }else if(e.getDamager() instanceof Player){
            Player damager = (Player) e.getDamager();
            Entity entity = e.getEntity();
            if(damager.getItemInHand() != null) {
                if (damager.getItemInHand().getItemMeta() != null) {
                    if (damager.getItemInHand().getItemMeta().getLore() != null) {
                        Jäger.jägerAuslösen(damager, e);
                    }
                }
            }
        }
    }

}
