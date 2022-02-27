package me.bluenitrox.school.listener;

import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.features.PetAPI;
import me.bluenitrox.school.haendler.NPCAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteractEntityEvent implements Listener {


    @EventHandler
    public void onInteract(final PlayerInteractAtEntityEvent e){
        Player p = e.getPlayer();

        interactPetEXP(p,e);
    }

    private void interactPetEXP(Player p, PlayerInteractAtEntityEvent e){
        if(e.getRightClicked() != null) {
            if(e.getPlayer().getItemInHand() != null) {
                if(e.getPlayer().getItemInHand().getItemMeta() != null) {
                    if (e.getPlayer().getItemInHand().getItemMeta().getDisplayName() != null) {
                        if (e.getPlayer().getItemInHand().getItemMeta().getLore() != null) {
                            String[] display = e.getPlayer().getItemInHand().getItemMeta().getDisplayName().split(" ");
                            if (display[1].equalsIgnoreCase("Packung")) {
                                if (e.getRightClicked().getName().startsWith("§8[§6")) {

                                    String[] entityownerarray = e.getRightClicked().getName().split(" ");
                                    String entityowner = entityownerarray[1];

                                    if (entityowner.equalsIgnoreCase(e.getPlayer().getName())) {
                                        String[] lore = e.getPlayer().getItemInHand().getItemMeta().getLore().get(0).split(" ");
                                        int petxp = Integer.parseInt(lore[2]);

                                        Pet pet = new Pet();
                                        String haustier = pet.petTypeToEntity(pet.entityToPetType(e.getRightClicked().getType()));


                                        PetAPI api = new PetAPI();

                                        if(p.getItemInHand().getAmount() > 1) {
                                            p.getItemInHand().setAmount(p.getItemInHand().getAmount() -1);
                                        }else if(p.getItemInHand().getAmount() == 1) {
                                            ItemStack air = new ItemStack(Material.AIR);
                                            p.setItemInHand(air);
                                        }
                                        p.playSound(p.getLocation(), Sound.EAT, 1L , 1L);
                                        api.updatePet(e.getPlayer().getUniqueId(), petxp, false, haustier);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}
