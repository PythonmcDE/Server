package me.bluenitrox.school.features;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.aufgabensystem.AufgabenManager;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.Firework;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CaseAPI {

    public static String gewöhnlich = "§8§lGewöhnliche Case";
    public static String selten = "§b§lSeltene Case";
    public static String episch = "§5§lEpische Case";
    public static String legendär = "§c§lLegendäre Case";
    public static String mysthische = "§6§lMysthische Case";
    public static String daily = "§e§lDaily Case";
    public static String tier = "§6§lTier Case";
    private int rounds = 0;
    public static HashMap<Player, ArrayList<ItemStack>> caseitemshash = new HashMap<>();
    public static ArrayList<ItemStack> casepot;

    public static ArrayList<Player> caseöffnen = new ArrayList<>();

    public void openCase(Player p, int cases) {
        if(AufgabenManager.getTask(p.getUniqueId()) == 17) {
            AufgabenManager.onComplete(p.getUniqueId(), 17);
        }
        caseöffnen.add(p);
        clearAllArrays();
        getCasePot(cases, p);

        StatsAPI api = new StatsAPI();
        api.updateCase(p.getUniqueId(), 1, false);


        Inventory inv = Bukkit.getServer().createInventory(null, 9 * 3, toCase(cases));

        ItemStack hopper = new ItemBuilder(Material.HOPPER).setDisplayname("§e§lDein Gewinn").setLore("§b» §7Wenn die Case zum Stillstand kommt, bekommst", "§b» §7du das Item auf diesem Slot.").addEnchant(Enchantment.ARROW_DAMAGE, 10, false).build();

        for (int i = 9; i <= 17; i++) {
            inv.setItem(i, caseitemshash.get(p).get(i));
            inv.setItem(i - 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))
                    .setDisplayname(rareFromShort(rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))).build());
            inv.setItem(i + 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))
                    .setDisplayname(rareFromShort(rareFromColor(caseitemshash.get(p).get(i).getItemMeta().getDisplayName()))).build());
        }

        inv.setItem(4, hopper);
        p.openInventory(inv);
        new BukkitRunnable() {
            @Override
            public void run() {
                startAnimation(p, inv, cases);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(), 5);
    }

    private void startAnimation(Player p, Inventory inv, int cases) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(rounds >= 40){
                    this.cancel();
                    Inventory wininv = Bukkit.getServer().createInventory(null, 9*3, "§e§lCase Gewinn");
                    p.playSound(p.getLocation(), Sound.LEVEL_UP , 1L, 1L);
                    ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE,(short) 15).setDisplayname(" ").build();
                    ItemStack hopper = new ItemBuilder(Material.HOPPER).setDisplayname("§e§lDein Gewinn").setLore("§b» §7Wenn die Case zum Stillstand kommt, bekommst", "§b» §7du das Item auf diesem Slot.").addEnchant(Enchantment.ARROW_DAMAGE, 10, false).build();

                    for(int i = 0; i <= 12; i++){
                        if(i != 4) {
                            wininv.setItem(i, new ItemBuilder(Material.AIR).build());
                            wininv.setItem(i, glas);
                        }
                    }
                    for(int i = 14; i <= 26; i++){
                        wininv.setItem(i, new ItemBuilder(Material.AIR).build());
                        wininv.setItem(i, glas);
                    }
                    wininv.setItem(4, hopper);


                    if(addItemIDBool(inv) == false) {
                        wininv.setItem(13, Antidupe.addID(inv.getItem(13)));
                    }else {
                        wininv.setItem(13, inv.getItem(13));
                    }

                    Firework.Firework(p);

                    p.openInventory(wininv);
                    caseöffnen.remove(p);
                    caseitemshash.remove(p);
                    rounds = 0;
                    return;
                }

                for (int i1 = 9; i1 <= 17; i1++) {
                    if (i1 <= 16) {
                        if(i1 == 13){
                            inv.setItem(i1, inv.getItem(i1 + 1));
                            inv.setItem(i1+9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(inv.getItem(i1+1).getItemMeta().getDisplayName()))
                                    .setDisplayname(rareFromShort(rareFromColor(inv.getItem(i1+1).getItemMeta().getDisplayName()))).build());
                        }else {
                            inv.setItem(i1, inv.getItem(i1 + 1));
                            inv.setItem(i1 + 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))
                                    .setDisplayname(rareFromShort(rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))).build());
                            inv.setItem(i1 - 9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))
                                    .setDisplayname(rareFromShort(rareFromColor(inv.getItem(i1 + 1).getItemMeta().getDisplayName()))).build());
                        }
                    } else {
                        ItemStack is = caseitemshash.get(p).get(new Random().nextInt(caseitemshash.get(p).size()));
                        inv.setItem(i1, is);
                        inv.setItem(i1-9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(is.getItemMeta().getDisplayName()))
                                .setDisplayname(rareFromShort(rareFromColor(is.getItemMeta().getDisplayName()))).build());
                        inv.setItem(i1+9, new ItemBuilder(Material.STAINED_GLASS_PANE, rareFromColor(is.getItemMeta().getDisplayName()))
                                .setDisplayname(rareFromShort(rareFromColor(is.getItemMeta().getDisplayName()))).build());

                    }
                }
                ItemStack hopper = new ItemBuilder(Material.HOPPER).setDisplayname("§e§lDein Gewinn").setLore("§b» §7Wenn die Case zum Stillstand kommt, bekommst", "§b» §7du das Item auf diesem Slot.").addEnchant(Enchantment.ARROW_DAMAGE, 10, false).build();
                inv.setItem(4,hopper);
                p.updateInventory();
                p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1L , 1L);
                rounds++;
            }
        }.runTaskTimer(SchoolMode.getInstance(), 5,5);

    }

    public void getCasePot(int cases, Player p) {
        casepot = new ArrayList<>();
        CaseItems caseitems = new CaseItems();
        /*
        0 = Daily
        1 = Gewöhnlich
        2 = Selten
        3 = Episch
        4 = Legendäre
        5 = Mysthische
        6 = Tier
         */

        registerAllInRightOrder(cases, caseitems);


        caseitemshash.put(p, casepot);

    }

    private boolean addItemIDBool(Inventory inv){
        if(inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§7Eisenblöcke") ||
                inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§7Goldblöcke")||
                inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§7Enderperlen")||
                inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§7Goldene Äpfel")||
                inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§7Pfeile")||
                inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§7Diamantblöcke")||
                inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§6§lSchool XP") ||
                inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§7Smaragdblöcke")){
            return true;
        }
        return false;
    }

    private void registerAllInRightOrder(int cases, CaseItems caseitems){
        registerAllCases(caseitems);


        if (cases == 0) {
            for (int i = 0; i <= 128; i++) {
                casepot.add(CaseItems.daily.get(new Random().nextInt(CaseItems.daily.size())));
            }
        } else if (cases == 1) {
            allCasesGet(80, 30, 10, 5);
        } else if (cases == 2) {
            allCasesGet(60, 50, 16, 7);
        } else if (cases == 3) {
            allCasesGet(60, 50, 30, 10);
        } else if (cases == 4) {
            allCasesGet(60, 50, 40, 20);
        } else if (cases == 5) {
            for (int i = 0; i <= 60; i++) {
                casepot.add(CaseItems.mysthische.get(new Random().nextInt(CaseItems.mysthische.size())));
            }
        } else if (cases == 6) {
            for (int i = 0; i <= 60; i++) {
                casepot.add(CaseItems.tier.get(new Random().nextInt(CaseItems.tier.size())));
            }
        }

        clearAllArrays();
    }

    private void allCasesGet(int i1, int x, int y, int z) {
        for (int i = 0; i <= i1; i++) {
            casepot.add(CaseItems.gewöhnlich.get(new Random().nextInt(CaseItems.gewöhnlich.size())));
        }
        for (int i = 0; i <= x; i++) {
            casepot.add(CaseItems.selten.get(new Random().nextInt(CaseItems.selten.size())));
        }
        for (int i = 0; i <= y; i++) {
            casepot.add(CaseItems.episch.get(new Random().nextInt(CaseItems.episch.size())));
        }
        for (int i = 0; i <= z; i++) {
            casepot.add(CaseItems.legendär.get(new Random().nextInt(CaseItems.legendär.size())));
        }
    }

    private void registerAllCases(CaseItems caseitems) {
        caseitems.registerDaily();
        caseitems.registerLegendär();
        caseitems.registerGewöhnlich();
        caseitems.registerEpisch();
        caseitems.registerSelten();
        caseitems.registerMythisch();
        caseitems.registerTier();
    }

    private void clearAllArrays(){
        if(CaseItems.daily != null) {
            CaseItems.daily.clear();
        }
        if(CaseItems.gewöhnlich != null) {
            CaseItems.gewöhnlich.clear();
        }
        if(CaseItems.selten != null) {
            CaseItems.selten.clear();
        }
        if(CaseItems.episch != null) {
            CaseItems.episch.clear();
        }
        if(CaseItems.legendär != null) {
            CaseItems.legendär.clear();
        }
        if(CaseItems.mysthische != null) {
            CaseItems.mysthische.clear();
        }
        if(CaseItems.tier != null) {
            CaseItems.tier.clear();
        }
    }

    private short rareFromColor(String name){
        if(name.startsWith("§6§l")){
            return 10;
        }else if(name.startsWith("§6")){
            return 1;
        }else if(name.startsWith("§8")){
            return 1;
        }else if(name.startsWith("§5")){
            return 10;
        }else if(name.startsWith("§9")){
            return 3;
        }else {
            return 8;
        }
    }

    private String rareFromShort(short rare){
        if(rare == 1){
            return "§6§lLegendär";
        }else if(rare == 10){
            return "§5§lEpisch";
        }else if(rare == 3){
            return "§b§lSelten";
        }else if(rare == 8){
            return "§7§lGewöhnlich";
        }else {
            return null;
        }
    }

    private String toCase(int cases) {
        if (cases == 0) {
            return daily;
        } else if (cases == 1) {
            return gewöhnlich;
        } else if (cases == 2) {
            return selten;
        } else if (cases == 3) {
            return episch;
        } else if (cases == 4) {
            return legendär;
        } else if (cases == 5) {
            return mysthische;
        } else if (cases == 6) {
            return tier;
        }
        return null;
    }

    public int fromCase(String cases){
        if(cases.equalsIgnoreCase(daily)){
            return 0;
        }else if(cases.equalsIgnoreCase(gewöhnlich)){
            return 1;
        }else if(cases.equalsIgnoreCase(selten)){
            return 2;
        }else if(cases.equalsIgnoreCase(episch)){
            return 3;
        }else if(cases.equalsIgnoreCase(legendär)){
            return 4;
        }else if(cases.equalsIgnoreCase(mysthische)){
            return 5;
        }else if(cases.equalsIgnoreCase(tier)){
            return 6;
        }
        return 0;
    }
}
