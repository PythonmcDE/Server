package me.bluenitrox.school.seasonpass;

import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;

public class SeasonpassInventorys {

    private final UUID uuid;
    private final ItemStack glass;

    public SeasonpassInventorys(Player player) {
        this.uuid = player.getUniqueId();
        glass = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 15).setDisplayname(" ").build();
    }

    /**
     * Main Inventory from Seasonpass
     * {@link SeasonpassCMD} {@link SeasonpassManager}
     * @return the main inventory
     */
    public Inventory normalPage() {

        String guiname = "§b» §6Seasonpass §8(§7Season 1§8)";
        Inventory inventory = Bukkit.createInventory(null, 9*5, guiname);

        SeasonpassManager seasonpassManager = new SeasonpassManager();
        SeasonpassRewardManager seasonpassRewardManager = new SeasonpassRewardManager();
        /*
        register ItemStacks
         */
        int item;
        if(seasonpassManager.hasGoldPass(uuid)) {
            item = seasonpassRewardManager.getItems(uuid).size() + seasonpassRewardManager.getGoldPassItems(uuid).size();
        } else {
            item = seasonpassRewardManager.getItems(uuid).size();
        }

        ItemStack belohnungen = new ItemBuilder(Material.CHEST).setDisplayname("§8» §6§lVerfügbare Belohnungen").setLore("§8» §7Klicke hier, um alle §6Belohnungen §7abzuholen", "§7Du hast §b§l"+ item + " §7nicht abgeholte Belohnungen.").build();
        ItemStack bonusbank = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§8» §6§lBonusbank").setLore("§8» §7Die überschüssigen §6§lSeasonpass XP §7werden", "§8» §7am Ende der Season in §6§lSchoolXP §aumgewandelt§7!").build();
        ItemStack bonusbankWithoutGoldPass = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§8» §6§lBonusbank").setLore("§8» §7Die überschüssigen §6§lSeasonpass XP §7werden", "§8» §7am Ende der Season in §6§lSchoolXP §aumgewandelt§7!", " ", "§8» §7Dieses Feature ist nur mit dem", "§8» §6§lGoldpass §averfügbar§7!", " ", "§7Du kannst ihn hier erwerben:", "§bpythonmc.de/go/shop").build();
        ItemStack goldpass = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§8» §6§lGoldpass").setLore("§7Erhalte zusätzliche Belohnungen" , "§7durch den §6§lGoldpass!", " ", "§7Du kannst ihn hier erwerben:", "§bpythonmc.de/go/shop").build();

        for(int i = 30;i < 9*5-1; i++) {
            inventory.setItem(i, glass);
        }
        inventory.setItem(9*4, belohnungen);


        if(!seasonpassManager.hasGoldPass(uuid)) {
            inventory.setItem(9*4+4, goldpass);
            inventory.setItem(9*5-1, bonusbankWithoutGoldPass);
        } else {
            inventory.setItem(9*5-1, bonusbank);
        }

        for(int i = 0; i < 30; i++) {
            inventory.setItem(i, this.getItem(i+1, seasonpassManager.getFortschritt(uuid), seasonpassRewardManager.getNormalSeason1Reward(i+1), seasonpassRewardManager.getGoldSeason1Reward(i+1), seasonpassManager.getXP(uuid), seasonpassRewardManager.getNeededXp(i+1)));
        }

        return inventory;
    }

    /**
     * Inventory which equals all rewards after the main rewards
     * @return inventory
     */
    public Inventory bonusBank() {

        String guiname = "§b» §6Seasonpass Bonusbank";
        Inventory inventory = Bukkit.createInventory(null, 9*4, guiname);

        SeasonpassManager seasonpassManager = new SeasonpassManager();
        SeasonpassRewardManager seasonpassRewardManager = new SeasonpassRewardManager();
        int overXP = seasonpassManager.getXP(uuid) - seasonpassRewardManager.getNeededXp(45);

        if(overXP < 0) {
            overXP = 0;
        }

        ItemStack xpBottle = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§b» §6§lBonus XP").setLore("§8» §7Deine zusätzlich gesammelten XP: §6§l" + overXP, " ", "§8» §7Diese §6§lXP §7werden nach der ", "§8» §7Season in §6§lSchool XP §aumgewandelt§7!").build();
        ItemStack backToMainMenu = new ItemBuilder(Material.REDSTONE).setDisplayname("§b» §6§lZurück").setLore("§8» §7Klicke hier, um zum Hauptmenu zurückzukehren.").build();

        for(int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, glass);
        }
        inventory.setItem(13, xpBottle);
        inventory.setItem(31, backToMainMenu);

        return inventory;
    }

    /**
     *
     * @param zahl Aufgabenzahl
     * @param fortschritt der aktuelle Task des Spielers
     * @param defaultPassTask the reward for the lore
     * @param goldPassTask the premium reward for the lore
     * @return the final ItemStack
     */
    private ItemStack getItem(int zahl, int fortschritt, String defaultPassTask, String goldPassTask, int xp, int neededxp) {

        ItemStack itemStack = null;
        if(zahl > fortschritt) {
            itemStack = new ItemBuilder(Material.SULPHUR).setDisplayname("§6Level " + zahl).setLore("§8» §7Schließe zuerst das vorherige Level ab").build();
        }
        if(zahl == fortschritt) {
            itemStack = new ItemBuilder(Material.GOLD_NUGGET).setDisplayname("§6Level " + zahl).setLore("§8» §7Fortschritt: §a" + xp + "§8/§6" + neededxp + " XP").build();
        }
        if(zahl < fortschritt) {
            itemStack = new ItemBuilder(Material.GLOWSTONE_DUST).setDisplayname("§6Level " + zahl).setLore("§aBereits abgeschlossen ✔", " ", "§7Erhaltene Belohnung:", "§8» " + defaultPassTask + " §8(§7Freepass§8)", "§8» " + goldPassTask + " §8(§6Goldpass§7)").build();
        }

        return itemStack;
    }


}
