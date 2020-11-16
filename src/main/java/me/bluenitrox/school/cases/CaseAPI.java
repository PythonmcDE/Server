package me.bluenitrox.school.cases;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class CaseAPI {

    public ArrayList<ItemStack> getCasePot(int cases){
        CaseItems caseitems = new CaseItems();
        /*
        0 = Daily
        1 = Gewöhnlich
        2 = Ungewöhnlich
        3 = Selten
        4 = Legendäre
        5 = Mysthische
        6 = Tier
        7 = Magische
         */
        registerAllCases(caseitems);

        /*

        BEISPIEL ZUM GETTEN // HIER LEGI ITEMS

        for(int i = 0; i <= 5; i++){
            caseitems.casepot.add(caseitems.legendär.get(new Random().nextInt(7)));
        }

        */

        return caseitems.casepot;
    }

    private void registerAllCases(CaseItems caseitems){
        caseitems.registerDaily();
        caseitems.registerLegendär();
        caseitems.registerGewöhnlich();
        caseitems.registerUngewöhnlich();
        caseitems.registerSelten();
        caseitems.registerMagisch();
        caseitems.registerMysthische();
        caseitems.registerTier();
    }

}
