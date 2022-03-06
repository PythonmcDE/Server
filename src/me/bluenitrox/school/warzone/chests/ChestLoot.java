package me.bluenitrox.school.warzone.chests;

import me.bluenitrox.school.features.CaseAPI;
import me.bluenitrox.school.managers.EnchantManager;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChestLoot {

    private LinkedList<ItemStack> books = new LinkedList<>();
    private LinkedList<ItemStack> cases = new LinkedList<>();
    private LinkedList<ItemStack> schoolxp = new LinkedList<>();
    private LinkedList<ItemStack> potions = new LinkedList<>();
    private LinkedList<ItemStack> erze = new LinkedList<>();
    private LinkedList<ItemStack> extra = new LinkedList<>();
    private LinkedList<ItemStack> food = new LinkedList<>();

    public LinkedList<ItemStack> getBooks() {
        return books;
    }
    public LinkedList<ItemStack> getCases() {
        return cases;
    }
    public LinkedList<ItemStack> getSchoolxp() {
        return schoolxp;
    }
    public LinkedList<ItemStack> getPotions() {
        return potions;
    }
    public LinkedList<ItemStack> getErze() {
        return erze;
    }
    public LinkedList<ItemStack> getExtra() {
        return extra;
    }
    public LinkedList<ItemStack> getFood() {
        return food;
    }

    void registerBooks() {
        /**
         * create all books for the chests
         * {@link me.bluenitrox.school.enchants.EnchantAPI}
         */

        /**
         * green books: {@rüstung}
         */
        ItemStack tank = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Tank + "I").build();
        ItemStack heilzauber = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Heilzauber + "I").build();
        ItemStack magieshield = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Magieschild + "I").build();
        ItemStack widerstand = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Widerstand + "I").build();
        ItemStack stacheln = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Stacheln + "I").build();
        ItemStack überladung = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Überladung + "I").build();
        ItemStack obsidianschild = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.ObsidianSchild + "I").build();
        ItemStack eis = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Eis + "I").build();

        /**
         * red books: {@sword}
         */
        ItemStack fluch = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Fluch + "I").build();
        ItemStack kopfgeld = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Kopfgeld + "I").build();
        ItemStack assasine = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Assassine + "I").build();
        ItemStack vampir = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Vampir + "I").build();
        ItemStack kobra = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Kobra + "I").build();
        ItemStack energieentzug = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Energieentzug + "I").build();
        ItemStack antivenom = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.AntiVenom + "I").build();
        ItemStack wilderei = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Wilderei + "I").build();
        ItemStack jäger = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Jäger + "I").build();
        ItemStack entdecker = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Entdecker + "I").build();
        ItemStack schatzmeister = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.schatzmeister + "I").build();

        /**
         * blue books: {@bow}
         */
        ItemStack blackout = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Blackout + "I").build();
        ItemStack dynamite = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Dynamite + "I").build();
        ItemStack tod = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Tod + "I").build();
        ItemStack fesseln = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Fesseln + "I").build();
        ItemStack elektrisiert = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Elektrisiert + "I").build();
        ItemStack strahlen = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Strahlen + "I").build();
        ItemStack feuerwerk = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Feuerwerk + "I").build();
        ItemStack kaefig = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Käfig + "I").build();

        /**
         * orange books: {@pickaxe}
         */
        ItemStack rausch = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Rausch + "I").build();
        ItemStack zorn = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Zorn + "I").build();
        ItemStack laser = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Laser + "I").build();
        ItemStack duplizierung = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Duplizierung + "I").build();
        ItemStack erfahrung = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Erfahrung + "I").build();
        ItemStack ausgrabung = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Ausgrabung + "I").build();

        /**
         * orange books: {@rod}
         */
        ItemStack fischerglück = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Fischerglück + "I").build();
        ItemStack goldhaken = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Goldhaken + "I").build();
        ItemStack großerfang = new ItemBuilder(Material.ENCHANTED_BOOK).setDisplayname("§8» §6§lMagisches Buch").setLore(EnchantManager.Großerfang + "I").build();

        /**
         * @this.books set ItemStacks in the LinkedList
         */

        //green books:
        books.add(tank);
        books.add(heilzauber);
        books.add(magieshield);
        books.add(widerstand);
        books.add(stacheln);
        books.add(überladung);
        books.add(obsidianschild);
        books.add(eis);

        //red books:
        books.add(fluch);
        books.add(kopfgeld);
        books.add(assasine);
        books.add(vampir);
        books.add(kobra);
        books.add(energieentzug);
        books.add(antivenom);
        books.add(wilderei);
        books.add(entdecker);
        books.add(jäger);
        books.add(schatzmeister);

        //blue books:
        books.add(blackout);
        books.add(dynamite);
        books.add(tod);
        books.add(fesseln);
        books.add(elektrisiert);
        books.add(strahlen);
        books.add(feuerwerk);
        books.add(kaefig);

        //orange books (Pickaxe)
        books.add(rausch);
        books.add(zorn);
        books.add(laser);
        books.add(duplizierung);
        books.add(erfahrung);
        books.add(ausgrabung);

        //orange books (Rod)
        books.add(fischerglück);
        books.add(goldhaken);
        books.add(großerfang);
    }
    public ItemStack daily = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.daily).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
    public ItemStack gewoenlich = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.gewöhnlich).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
    public ItemStack selten = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.selten).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
    public ItemStack episch = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.episch).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
    public ItemStack legendär = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.legendär).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
    public ItemStack mythisch = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.mysthische).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
    public ItemStack tier = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.tier).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();

    void registerCases() {
        /**
         * register all cases {@link CaseAPI} {@link me.bluenitrox.school.features.GetCases}
         */
        ItemStack daily = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.daily).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack gewoenlich = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.gewöhnlich).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack selten = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.selten).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack episch = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.episch).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack legendär = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.legendär).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack mythisch = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.mysthische).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack tier = new ItemBuilder(Material.DRAGON_EGG).setDisplayname(CaseAPI.tier).setLore("§8» §7Dieser §6§lFund §7verspricht dir", "§8» §5§lbesondere §6Belohnungen§7.").setAmount(1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();

        /**
         * @this.cases set Items in LinkedList
         */
        cases.add(daily);
        cases.add(gewoenlich);
        cases.add(selten);
        cases.add(episch);
        cases.add(legendär);
        cases.add(mythisch);
        cases.add(tier);
    }

    void registerSchoolXP() {

        /**
         * register SchoolXP Items {@link giveSchoolXP}
         */
        for(int i = 1; i < 4; i++) {
            ItemStack schoolXP250 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setAmount(i).setLore("§8» §7Beinhaltet:§6§l 250 XP").build();
            ItemStack schoolXP500 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setAmount(i).setLore("§8» §7Beinhaltet:§6§l 500 XP").build();
            ItemStack schoolXP750 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setAmount(i).setLore("§8» §7Beinhaltet:§6§l 750 XP").build();
            ItemStack schoolXP1000 = new ItemBuilder(Material.EXP_BOTTLE).setDisplayname("§6§lSchool XP").setAmount(i).setLore("§8» §7Beinhaltet:§6§l 1000 XP").build();

            /**
             * @this.schoolxp set Items in LinkedList
             */
            schoolxp.add(schoolXP250);
            schoolxp.add(schoolXP500);
            schoolxp.add(schoolXP750);
            schoolxp.add(schoolXP1000);
        }
    }

    void registerPotions() {
        /**
         * register all Potions {@link org.bukkit.potion.Potion}
         */

        /**
         * @normal Potions
         */
        ItemStack speed = new ItemStack(Material.POTION, (short) 8194);
        ItemStack strenght = new ItemStack(Material.POTION, (short) 8201);
        ItemStack fireresistance = new ItemStack(Material.POTION, (short) 8227);
        ItemStack heal = new ItemStack(Material.POTION, (short) 8261);
        ItemStack jumpboost = new ItemStack(Material.POTION, (short) 8203);
        ItemStack regeneration = new ItemStack(Material.POTION, (short) 8193);
        ItemStack invisibility = new ItemStack(Material.POTION, (short) 8238);

        /**
         * @splash Potions
         */
        ItemStack damage = new ItemStack(Material.POTION, (short) 16428);
        ItemStack poison = new ItemStack(Material.POTION, (short) 16388);
        ItemStack schwaeche = new ItemStack(Material.POTION, (short) 16424);
        ItemStack slowness = new ItemStack(Material.POTION, (short) 16426);

        /**
         * @this.potions add Potions in LinkedList
         */
        //normal Potions
        potions.add(speed);
        potions.add(strenght);
        potions.add(fireresistance);
        potions.add(heal);
        potions.add(jumpboost);
        potions.add(regeneration);
        potions.add(invisibility);

        //Splash Potions
        potions.add(damage);
        potions.add(poison);
        potions.add(schwaeche);
        potions.add(slowness);
    }

    void registerErze() {
        /**
         * register all Potions {@link Material}
         */
        for (int i = 6; i < 48; i++) {
            ItemStack iron = new ItemBuilder(Material.IRON_INGOT).setAmount(i).build();
            ItemStack redstone = new ItemBuilder(Material.REDSTONE).setAmount(i).build();
            ItemStack gold = new ItemBuilder(Material.GOLD_INGOT).setAmount(i).build();
            ItemStack diamond = new ItemBuilder(Material.DIAMOND).setAmount(i).build();
            ItemStack emerald = new ItemBuilder(Material.EMERALD).setAmount(i).build();

            /**
             * @this.erze set Items in LinkedList
             */
            erze.add(iron);
            erze.add(redstone);
            erze.add(gold);
            erze.add(diamond);
            erze.add(diamond);
            erze.add(emerald);
        }
    }

    void registerExtra() {

        /**
         * register all Potions {@link Material}
         */
        ItemStack goldApple = new ItemBuilder(Material.GOLDEN_APPLE).build();
        ItemStack enderPearl = new ItemBuilder(Material.ENDER_PEARL).build();

        /**
         * @this.extra add Items into LinkedList
         */
    }

    void registerFood() {

        /**
         * register all Potions {@link Material}
         */
        for (int i = 5; i < 24; i++) {
            ItemStack steak = new ItemBuilder(Material.COOKED_BEEF).setAmount(i).build();
            ItemStack cookedPig = new ItemBuilder(Material.GRILLED_PORK).setAmount(i).build();
            ItemStack carrot = new ItemBuilder(Material.CARROT).setAmount(i).build();
            ItemStack backedPotato = new ItemBuilder(Material.BAKED_POTATO).setAmount(i).build();
            ItemStack goldenCarrot = new ItemBuilder(Material.GOLDEN_CARROT).setAmount(i).build();
            ItemStack pumpkinPie = new ItemBuilder(Material.PUMPKIN_PIE).setAmount(i).build();

            /**
             * @this.food set Items in LinkedList
             */
            food.add(steak);
            food.add(cookedPig);
            food.add(carrot);
            food.add(backedPotato);
            food.add(goldenCarrot);
            food.add(pumpkinPie);
        }

    }

}
