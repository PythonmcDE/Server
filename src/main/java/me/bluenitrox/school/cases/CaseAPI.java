package me.bluenitrox.school.cases;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.Firework;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.NBTTags;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Random;

public class CaseAPI {


    public void openCase(Player p, int cases) {
        ItemStack[] caseInhalt = CaseItems.casepot.toArray(new ItemStack[0]);
        CaseItems.casepot.clear();
        clearAllArrays();
        getCasePot(cases);

        Inventory inv = Bukkit.createInventory(null, 9 * 3, toCase(cases));

        ItemStack hopper = new ItemBuilder(Material.HOPPER).setDisplayname("§e§lDein Gewinn").setLore("§b» §7Wenn die Case zum Stillstand kommt, bekommst", "§b» §7du das Item auf diesem Slot.").addEnchant(Enchantment.ARROW_DAMAGE, 10, false).build();

        inv.setItem(4, hopper);
        for(int i = 9; i<= 17;i++){
            inv.setItem(i,getCasePot(cases).get(i));
        }

        p.openInventory(inv);
        new BukkitRunnable(){
            @Override
            public void run() {
                startAnimation(p, inv, cases);
            }
        }.runTaskLaterAsynchronously(SchoolMode.getInstance(),10);
    }

    private int rounds = 0;

    private void startAnimation(Player p, Inventory inv, int cases) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if(rounds >= 40){
                    this.cancel();
                    p.playSound(p.getLocation(), Sound.LEVEL_UP , 1L, 1L);
                    ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE,(short) 15).setDisplayname(" ").build();
                    for(int i = 0; i <= 12; i++){
                        inv.setItem(i, glas);
                    }
                    for(int i = 15; i <= 26; i++){
                        inv.setItem(i, glas);
                    }
                    inv.setItem(14, Antidupe.addID(inv.getItem(14)));

                    Firework.Firework(p);

                    p.openInventory(inv);
                }

                for (int i1 = 9; i1 <= 17; i1++) {
                    if (i1 <= 16) {
                        p.sendMessage("1");
                        inv.setItem(i1, inv.getItem(i1 + 1));
                    } else {
                        p.sendMessage("2");
                        inv.setItem(i1, getCasePot(cases).get(new Random().nextInt(CaseItems.casepot.size())));
                    }
                }
                p.openInventory(inv);
                p.playSound(p.getLocation(), Sound.NOTE_STICKS, 1L , 1L);
                rounds++;
            }
        }.runTaskTimer(SchoolMode.getInstance(), 5,5);

    }

    public ArrayList<ItemStack> getCasePot(int cases) {
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
        registerAllCases(caseitems);


        if (cases == 0) {
            for (int i = 0; i <= 128; i++) {
                CaseItems.casepot.add(CaseItems.daily.get(new Random().nextInt(CaseItems.daily.size())));
            }
        } else if (cases == 1) {
            allCasesGet(80, 30, 10, 5);
        } else if (cases == 2) {
            allCasesGet(75, 40, 12, 7);
        } else if (cases == 3) {
            allCasesGet(60, 40, 25, 10);
        } else if (cases == 4) {
            allCasesGet(60, 40, 40, 20);
        } else if (cases == 5) {
            for (int i = 0; i <= 60; i++) {
                CaseItems.casepot.add(CaseItems.mysthische.get(new Random().nextInt(CaseItems.mysthische.size())));
            }
        } else if (cases == 6) {
            for (int i = 0; i <= 60; i++) {
                CaseItems.casepot.add(CaseItems.tier.get(new Random().nextInt(CaseItems.tier.size())));
            }
        }

        clearAllArrays();



        return caseitems.casepot;
    }

    private void allCasesGet(int i1, int x, int y, int z) {
        for (int i = 0; i <= i1; i++) {
            CaseItems.casepot.add(CaseItems.gewöhnlich.get(new Random().nextInt(CaseItems.gewöhnlich.size())));
        }
        for (int i = 0; i <= x; i++) {
            CaseItems.casepot.add(CaseItems.selten.get(new Random().nextInt(CaseItems.selten.size())));
        }
        for (int i = 0; i <= y; i++) {
            CaseItems.casepot.add(CaseItems.episch.get(new Random().nextInt(CaseItems.episch.size())));
        }
        for (int i = 0; i <= z; i++) {
            CaseItems.casepot.add(CaseItems.legendär.get(new Random().nextInt(CaseItems.legendär.size())));
        }
    }

    private void registerAllCases(CaseItems caseitems) {
        caseitems.registerDaily();
        caseitems.registerLegendär();
        caseitems.registerGewöhnlich();
        caseitems.registerEpisch();
        caseitems.registerSelten();
        caseitems.registerMysthische();
        caseitems.registerTier();
    }

    private void clearAllArrays(){
        CaseItems.daily.clear();
        CaseItems.gewöhnlich.clear();
        CaseItems.selten.clear();
        CaseItems.episch.clear();
        CaseItems.legendär.clear();
        CaseItems.mysthische.clear();
        CaseItems.tier.clear();
    }

    private String toCase(int cases) {
        if (cases == 0) {
            return "§e§lDaily Case";
        } else if (cases == 1) {
            return "§7§lGewöhnliche Case";
        } else if (cases == 2) {
            return "§b§lSeltene Case";
        } else if (cases == 3) {
            return "§5§lEpische Case";
        } else if (cases == 4) {
            return "§c§lLegendäre Case";
        } else if (cases == 5) {
            return "§6§lMysthische Case";
        } else if (cases == 6) {
            return "§c§lTier Case";
        }
        return null;
    }
}
