package me.bluenitrox.school.warzone.chests;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.WorldManager;
import me.bluenitrox.school.mine.angelmine.PartikelManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.RandomGen;
import me.bluenitrox.school.warzone.CombatAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

public class ChestsFuctions {

    private int maxchestwz1 = 1;
    private int maxchestwz2 = 0;
    private int maxchestwz3 = 0;

    public void spawnChest(int warzone, int amount){
        for(int i = 1; i <= amount; i++){
            getRandomChestLocation(warzone).getBlock().setType(Material.CHEST);
            Block block = getRandomChestLocation(warzone).getBlock();
            Chest chest = (Chest) block.getState();
            addItems(chest);
        }
    }

    private void addItems(Chest chest){
        LinkedList<Integer> slot = new LinkedList<>();
        LinkedList<ItemStack> items = registerChestLoot();
        for(int i = 0; i< items.size(); i++) {
            if(items.get(i) != null) {
                Random r = new Random();
                int z = r.nextInt(chest.getBlockInventory().getSize());
                while (slot.contains(z)){
                    z = r.nextInt(chest.getBlockInventory().getSize());
                }
                slot.add(z);
                chest.getBlockInventory().setItem(z, items.get(i));
            }
        }
    }

    private Location getRandomChestLocation(int warzone){
        Random r = new Random();
        int z = r.nextInt(getMaxChest(warzone) +1);
        while (z == 0){
            z =  r.nextInt(getMaxChest(warzone) +1);
        }
        return new LocationManager("Chest" +z+ "Warzone" + warzone).getLocation();
    }

    private int getMaxChest(int warzone){
        if(warzone == 1){
            return maxchestwz1;
        }else if(warzone == 2){
            return maxchestwz2;
        }else if(warzone == 3){
            return maxchestwz3;
        }
        return 0;
    }

    public void closeChest(InventoryCloseEvent event){
        CombatAPI api = new CombatAPI();
        if(api.getWarzoneByLocation(event.getPlayer().getLocation()) != null){
            if(event.getInventory().getHolder() instanceof Chest){
                Chest chest = (Chest) event.getInventory().getHolder();
                chest.getBlockInventory().clear();
                chest.getBlock().breakNaturally();
                Player player = (Player)event.getPlayer();
                player.playSound(player.getLocation(), Sound.BAT_DEATH, 1L, 1L);
            }
        }
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
