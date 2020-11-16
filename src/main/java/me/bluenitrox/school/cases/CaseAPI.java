package me.bluenitrox.school.cases;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class CaseAPI {


    public void openCaseAnimation(Player p, int cases) {
        CaseItems.casepot.clear();
        clearAllArrays();
        getCasePot(cases);

        Inventory inv = Bukkit.createInventory(null, 9 * 3, toCase(cases));

        for(int i = 9; i<= 17;i++){
            inv.setItem(i,getCasePot(cases).get(i));
        }

        p.openInventory(inv);
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
