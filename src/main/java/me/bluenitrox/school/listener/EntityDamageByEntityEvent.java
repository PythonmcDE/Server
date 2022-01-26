package me.bluenitrox.school.listener;

import me.bluenitrox.school.enchants.armor.*;
import me.bluenitrox.school.enchants.bow.*;
import me.bluenitrox.school.enchants.sword.*;
import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.utils.ArmorUtil;
import me.bluenitrox.school.utils.EntityHitDelay;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.projectiles.ProjectileSource;

public class EntityDamageByEntityEvent implements Listener {

    @EventHandler
    public void onDamage(final org.bukkit.event.entity.EntityDamageByEntityEvent e){
        Pet pet = new Pet();
        EntityHitDelay ehd = new EntityHitDelay();
        pet.damagePetEvent(e);
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(WorldManager.warzone)){
            CombatAPI combat = new CombatAPI();
            combat.onhitCombat(e);
        }
        if(e.getEntity().getWorld().getName().equalsIgnoreCase(WorldManager.plotworld)){
            ehd.onEntityHit(e);
        }
        if(e.getEntity() instanceof Player && e.getDamager() instanceof Player){
            /*

            SCHWERT ENCHANTS

             */
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

            /*

            ARMOR ENCHANTS

             */
            ArmorUtil util = new ArmorUtil();

            ItemStack helm = entity.getInventory().getHelmet();
            ItemStack chestplate = entity.getInventory().getChestplate();
            ItemStack leggins = entity.getInventory().getLeggings();
            ItemStack boots = entity.getInventory().getBoots();

            if(util.hasHelmetWithEnchant(entity)){
                Heilzauber.heilzauberAuslösen(entity,helm);
                Magieschild.magieschildAuslösen(entity,helm);
                Widerstand.widerstandAuslösen(entity,helm);
                Stacheln.stachelnAuslösen(entity,damager,helm);
                Überladung.überladungAuslösen(entity,helm);
                Eis.eisAuslösen(entity,damager,helm);
                ObsidianSchild.obischildAuslösen(entity,helm);
            }
            if(util.hasChestplateWithEnchant(entity)){
                Heilzauber.heilzauberAuslösen(entity,chestplate);
                Magieschild.magieschildAuslösen(entity,chestplate);
                Widerstand.widerstandAuslösen(entity,chestplate);
                Stacheln.stachelnAuslösen(entity,damager,chestplate);
                Überladung.überladungAuslösen(entity,chestplate);
                Eis.eisAuslösen(entity,damager,chestplate);
                ObsidianSchild.obischildAuslösen(entity,chestplate);
            }
            if(util.hasLegginsWithEnchant(entity)){
                Heilzauber.heilzauberAuslösen(entity,leggins);
                Magieschild.magieschildAuslösen(entity,leggins);
                Widerstand.widerstandAuslösen(entity,leggins);
                Stacheln.stachelnAuslösen(entity,damager,leggins);
                Überladung.überladungAuslösen(entity,leggins);
                Eis.eisAuslösen(entity,damager,leggins);
                ObsidianSchild.obischildAuslösen(entity,leggins);
            }
            if(util.hasBootsWithEnchant(entity)){
                Heilzauber.heilzauberAuslösen(entity,boots);
                Magieschild.magieschildAuslösen(entity,boots);
                Widerstand.widerstandAuslösen(entity,boots);
                Stacheln.stachelnAuslösen(entity,damager,boots);
                Überladung.überladungAuslösen(entity,boots);
                Eis.eisAuslösen(entity,damager,boots);
                ObsidianSchild.obischildAuslösen(entity,boots);
            }
        }else if(e.getDamager() instanceof Player){
            /*

            SCHWERT ENCHANT

             */
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
        if(e.getDamager() instanceof Projectile && e.getEntity() instanceof Player){
            /*

            BOW ENCHANT

             */
            Projectile projectile = (Projectile) e.getDamager();
            Blackout.blackoutAuslösen((Player) projectile.getShooter(),(Player)e.getEntity());
            Dynamite.dynamiteAuslösen((Player) projectile.getShooter(),(Player)e.getEntity());
            Fesseln.fesselnAuslösen((Player) projectile.getShooter(),(Player)e.getEntity());
            Tod.todAuslösen((Player) projectile.getShooter(),(Player)e.getEntity());
            Strahlen.strahlenAuslösen((Player) projectile.getShooter(),(Player)e.getEntity());
        }
    }

}
