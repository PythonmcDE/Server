package me.bluenitrox.school.warzone.chests;

import me.bluenitrox.school.utils.RandomGen;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedList;
import java.util.Random;

public class ChestsFuctions {

    public void onInterAct(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if(event.getClickedBlock() == null) return;
        if(event.getClickedBlock().getType() != Material.CHEST) return;

        CombatAPI combatAPI = new CombatAPI();
        if(combatAPI.getWarzoneByLocation(player.getLocation()) != null) {
            if(!(event.getClickedBlock().getType() == Material.CHEST)) return;
            Chest chest = (Chest) event.getClickedBlock().getState();
            /*
            set Books into the chest
             */
            //TODO set Item here
            this.registerAllLoot();

            while (this.registerChestLoot().size() != 0) {
                Random random = new Random();
                for (int i = 0; i < this.registerChestLoot().size(); i++) {
                    if(chest.getInventory().getItem(random.nextInt(chest.getInventory().getSize())) != null) {
                        chest.getInventory().setItem(random.nextInt(chest.getInventory().getSize()), this.registerChestLoot().get(i));
                    }
                }
            }
        }
    }

    private void registerAllLoot() {
        ChestLoot chestLoot = new ChestLoot();
        chestLoot.registerBooks();
        chestLoot.registerCases();
        chestLoot.registerErze();
        chestLoot.registerPotions();
        chestLoot.registerExtra();
        chestLoot.registerFood();
        chestLoot.registerSchoolXP();
    }

    private LinkedList<ItemStack> registerChestLoot() {
        LinkedList<ItemStack> chestLoot = new LinkedList<>();

        ChestLoot loot = new ChestLoot();
        loot.registerBooks();
        loot.registerCases();
        loot.registerErze();
        loot.registerPotions();
        loot.registerExtra();
        loot.registerFood();
        loot.registerSchoolXP();

        //add Cases
        if(this.getRandomInt(0,5) == 5) {
            chestLoot.add(loot.gewoenlich);
        }
        if(this.getRandomInt(0,7) == 7) {
            chestLoot.add(loot.selten);
        }
        if(this.getRandomInt(0,9) == 9) {
            chestLoot.add(loot.episch);
        }
        if(this.getRandomInt(0,12) == 12) {
            chestLoot.add(loot.legendär);
        }
        if(this.getRandomInt(0,10) == 10) {
            chestLoot.add(loot.tier);
        }
        if(this.getRandomInt(0,100) == 100) {
            chestLoot.add(loot.mythisch);
        }
        //add books to the chestloot List
        for(int i = 0; i< this.getRandomInt(1,7); i++) {
            chestLoot.add(loot.getBooks().get(new Random().nextInt(loot.getBooks().size())));
        }

        //add potions
        for (int i = 0; i < this.getRandomInt(1,3); i++) {
            chestLoot.add(loot.getPotions().get(new Random().nextInt(loot.getPotions().size())));
        }
        //add food
        for (int i = 0; i < this.getRandomInt(1,2); i++) {
            chestLoot.add(loot.getFood().get(new Random().nextInt(loot.getFood().size())));
        }

        //add SchoolXP
        for (int i = 0; i < this.getRandomInt(1,4); i++) {
            chestLoot.add(loot.getSchoolxp().get(new Random().nextInt(loot.getSchoolxp().size())));
        }
        //add erze
        for (int i = 0; i < this.getRandomInt(1,3); i++) {
            chestLoot.add(loot.getErze().get(new Random().nextInt(loot.getErze().size())));
        }
        return chestLoot;
    }

    private int getRandomInt(int min, int max) {

        RandomGen randomGen = new RandomGen(min, max);
        return randomGen.nextInt();

    }

}
