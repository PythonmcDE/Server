package me.bluenitrox.school.features;

import me.bluenitrox.school.dungeon.runen.RunenFuctions;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.UUID;

public class KitAPI {

    public static final String guiname = "§6§lDeine Kits";
    public static HashMap<UUID, Long> holz = new HashMap<>();
    public static HashMap<UUID, Long> stein = new HashMap<>();
    public static HashMap<UUID, Long> eisen = new HashMap<>();
    public static HashMap<UUID, Long> warzone = new HashMap<>();
    public static HashMap<UUID, Long> diamant = new HashMap<>();
    public static HashMap<UUID, Long> bergarbeiter = new HashMap<>();
    public static HashMap<UUID, Long> goldfinger = new HashMap<>();
    public static HashMap<UUID, Long> juwelier = new HashMap<>();
    public static HashMap<UUID, Long> banker = new HashMap<>();
    public static HashMap<UUID, Long> ninja = new HashMap<>();
    public static HashMap<UUID, Long> sensei = new HashMap<>();
    public static HashMap<UUID, Long> meister = new HashMap<>();

    public void openKitMenu(Player p){
        Inventory inv = Bukkit.createInventory(null, 9*6,guiname);

        setKitContent(inv, p);

        p.openInventory(inv);
    }

    private void setKitContent(Inventory inv, Player p){
        UUID uuid = p.getUniqueId();
        //Freigeschaltete Items
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack blackglass = new ItemBuilder(Material.STAINED_GLASS_PANE,  (short)15).setDisplayname(" ").build();

        ItemStack fs0 = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§6§lHolz").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs = new ItemBuilder(Material.STONE_SWORD).setDisplayname("§6§lStein").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs1 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§6§lEisen").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs2 = new ItemBuilder(Material.BOW).setDisplayname("§6§lWarzone").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs3 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§6§lDiamant").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs4 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§6§lBergarbeiter").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs5 = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§6§lGoldfinger").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs6 = new ItemBuilder(Material.DIAMOND).setDisplayname("§6§lJuwelier").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs7 = new ItemBuilder(Material.EMERALD).setDisplayname("§6§lBänker").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs8 = new ItemBuilder(Material.MELON).setDisplayname("§6§lNinja").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs9 = new ItemBuilder(Material.SUGAR_CANE).setDisplayname("§6§lSensei").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();
        ItemStack fs10 = new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§6§lMeister").setLore("§8» §7Du besitzt dieses Kit, klicke", "§8» §7hier, um es §a§labzuholen§7.").addEnchant(Enchantment.ARROW_INFINITE, 10, false).build();

        //Items mit Cooldown

        ItemStack cd = new ItemBuilder(Material.WOOD_SWORD).setDisplayname("§c§o§lHolz").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l1 Minute§7.").build();
        ItemStack cd1 = new ItemBuilder(Material.STONE_SWORD).setDisplayname("§c§o§lStein").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l2 Minuten§7.").build();
        ItemStack cd2 = new ItemBuilder(Material.IRON_SWORD).setDisplayname("§c§o§lEisen").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l3 Minuten§7.").build();
        ItemStack cd3 = new ItemBuilder(Material.BOW).setDisplayname("§c§o§lWarzone").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l15 Minuten§7.").build();
        ItemStack cd4 = new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§c§o§lDiamant").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l30 Minuten§7.").build();
        ItemStack cd5 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§c§o§lBergarbeiter").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l2 Stunden§7.").build();
        ItemStack cd6 = new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§c§o§lGoldfinger").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l5 Stunden§7.").build();
        ItemStack cd7 = new ItemBuilder(Material.DIAMOND).setDisplayname("§c§o§lJuwelier").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l10 Stunden§7.").build();
        ItemStack cd8 = new ItemBuilder(Material.EMERALD).setDisplayname("§c§o§lBänker").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l15 Stunden§7.").build();
        ItemStack cd9 = new ItemBuilder(Material.MELON).setDisplayname("§c§o§lNinja").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l3 Stunden§7.").build();
        ItemStack cd10 = new ItemBuilder(Material.SUGAR_CANE).setDisplayname("§c§o§lSensei").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l6 Stunden§7.").build();
        ItemStack cd11 = new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§c§o§lMeister").setLore("§8» §7Du kannst dieses Kit gerade §cnicht abholen§7!", "§8» §7Wartezeit insgesamt: §6§l12 Stunden§7.").build();

        //ITEM MIT "KIT ABHOLEN"

        ItemStack ka1 =new ItemBuilder(Material.STONE_SWORD).setDisplayname("§c§o§lStein").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getStein(uuid) +" mal §7ab!").build();
        ItemStack ka2 =new ItemBuilder(Material.IRON_SWORD).setDisplayname("§c§o§lEisen").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getEisen(uuid) +" mal §7ab!").build();
        ItemStack ka3 =new ItemBuilder(Material.BOW).setDisplayname("§c§o§lWarzone").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getWarzone(uuid) + " mal §7ab!").build();
        ItemStack ka4 =new ItemBuilder(Material.DIAMOND_SWORD).setDisplayname("§c§o§lDiamant").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getDiamant(uuid) +" mal §7ab!").build();
        ItemStack ka5 = new ItemBuilder(Material.DIAMOND_PICKAXE).setDisplayname("§c§o§lBergarbeiter").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Kaufpreis: §61 Mio Gems").build();
        ItemStack ka6 =new ItemBuilder(Material.GOLD_INGOT).setDisplayname("§c§o§lGoldfinger").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getGoldfinger(uuid) +" mal §7ab!").build();
        ItemStack ka7 = new ItemBuilder(Material.DIAMOND).setDisplayname("§c§o§lJuwelier").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getJuwelier(uuid) +" mal §7ab!").build();
        ItemStack ka8 = new ItemBuilder(Material.EMERALD).setDisplayname("§c§o§lBänker").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getBanker(uuid) +" mal §7ab!").build();
        ItemStack ka9 = new ItemBuilder(Material.MELON).setDisplayname("§c§o§lNinja").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Kaufpreis: §65 Mio Gems").build();
        ItemStack ka10 = new ItemBuilder(Material.SUGAR_CANE).setDisplayname("§c§o§lSensei").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getSensei(uuid) + " mal §7ab!").build();
        ItemStack ka11 = new ItemBuilder(Material.GOLD_CHESTPLATE).setDisplayname("§c§o§lMeister").setLore("§8» §7Noch §cnicht freigeschaltet§7!", "§8» §7Hole das §6vorherige Kit §7noch §6§l" + getMeister(uuid) +" mal §7ab!").build();

        for(int i = 0; i<=8; i++){
            inv.setItem(i,glas);
        }
        for(int i = 36; i<=44; i++){
            inv.setItem(i, glas);
        }
        for(int i = 45; i<=53; i++){
            inv.setItem(i, blackglass);
        }
        inv.setItem(49, new ItemBuilder(Material.PAPER).setDisplayname("§8» §6§lKit Menu").setLore("§6▶ §7Hole dir §6deine Kits §7ab!", "", "§7Kits können durch", "§8● §6das Erwerben des gewünschten Kits §7 oder", "§8● §6wiederholtes Abholen der vorherigen Kits", "§7freigeschaltet werden!").build());


        if(holz.containsKey(uuid)){
            inv.setItem(9,cd);
        }else {
            inv.setItem(9,fs0);
        }

        if(getStein(uuid) == 0) {
            if (stein.containsKey(uuid)) {
                inv.setItem(10, cd1);
            } else {
                inv.setItem(10, fs);
            }
        }else {
            inv.setItem(10,ka1);
        }

        if(getEisen(uuid) == 0) {
            if (eisen.containsKey(uuid)) {
                inv.setItem(11, cd2);
            } else {
                inv.setItem(11, fs1);
            }
        }else {
            inv.setItem(11,ka2);
        }

        if(getWarzone(uuid) == 0) {
            if (warzone.containsKey(uuid)) {
                inv.setItem(12, cd3);
            } else {
                inv.setItem(12, fs2);
            }
        }else {
            inv.setItem(12,ka3);
        }

        if(getDiamant(uuid) == 0) {
            if (diamant.containsKey(uuid)) {
                inv.setItem(13, cd4);
            } else {
                inv.setItem(13, fs3);
            }
        }else {
            inv.setItem(13,ka4);
        }

        if(getBergarbeiter(uuid) == 0) {
            if (bergarbeiter.containsKey(uuid)) {
                inv.setItem(18, cd5);
            } else {
                inv.setItem(18, fs4);
            }
        }else {
            inv.setItem(18,ka5);
        }

        if(getGoldfinger(uuid) == 0) {
            if (goldfinger.containsKey(uuid)) {
                inv.setItem(19, cd6);
            } else {
                inv.setItem(19, fs5);
            }
        }else {
            inv.setItem(19,ka6);
        }

        if(getJuwelier(uuid) == 0) {
            if (juwelier.containsKey(uuid)) {
                inv.setItem(20, cd7);
            } else {
                inv.setItem(20, fs6);
            }
        }else {
            inv.setItem(20,ka7);
        }

        if(getBanker(uuid) == 0) {
            if (banker.containsKey(uuid)) {
                inv.setItem(21, cd8);
            } else {
                inv.setItem(21, fs7);
            }
        }else {
            inv.setItem(21,ka8);
        }

        if(getNinja(uuid) == 0) {
            if (ninja.containsKey(uuid)) {
                inv.setItem(27, cd9);
            } else {
                inv.setItem(27, fs8);
            }
        }else {
            inv.setItem(27,ka9);
        }

        if(getSensei(uuid) == 0) {
            if (sensei.containsKey(uuid)) {
                inv.setItem(28, cd10);
            } else {
                inv.setItem(28, fs9);
            }
        }else {
            inv.setItem(28,ka10);
        }

        if(getMeister(uuid) == 0) {
            if (meister.containsKey(uuid)) {
                inv.setItem(29, cd11);
            } else {
                inv.setItem(29, fs10);
            }
        }else {
            inv.setItem(29,ka11);
        }

    }

    public static void kitApiClickEvent(InventoryClickEvent e){
        if(e.getClickedInventory().getName().equalsIgnoreCase(guiname) && e.getCurrentItem() != null){
            UUID uuid = e.getWhoClicked().getUniqueId();
            Player p = (Player)e.getWhoClicked();
            KitItems items = new KitItems();
            e.setCancelled(true);
            if(e.getCurrentItem().getType() == Material.WOOD_SWORD){
                if(holz.containsKey(uuid)){
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.KITNOTREADY);
                    return;
                }else {
                    p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                    p.closeInventory();
                    items.addHolzItems(p);
                    if(getStein(uuid) > 0) {
                        updateStein(uuid, 1, true);
                    }
                    if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                        holz.put(uuid, 30L);
                    }else {
                        holz.put(uuid, 60L);
                    }
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.STONE_SWORD){
                if(getStein(uuid) == 0) {
                    if (stein.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        items.addSteinItems(p);
                        if(getEisen(uuid) > 0) {
                            updateEisen(uuid, 1, true);
                        }
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            stein.put(uuid, 60L);
                        }else {
                            stein.put(uuid, 120L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.IRON_SWORD){
                if(getEisen(uuid) == 0) {
                    if (eisen.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        items.addEisenItems(p);
                        if(getWarzone(uuid) > 0) {
                            updateWarzone(uuid, 1, true);
                        }
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            eisen.put(uuid, (180L)/2);
                        }else {
                            eisen.put(uuid, 180L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.BOW){
                if(getWarzone(uuid) == 0) {
                    if (warzone.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        items.addWarzoneItems(p);
                        if(getDiamant(uuid) > 0) {
                            updateDiamant(uuid, 1, true);
                        }
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            warzone.put(uuid, (15 * 60L)/2);
                        }else {
                            warzone.put(uuid, 15 * 60L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.DIAMOND_SWORD){
                if(getDiamant(uuid) == 0) {
                    if (diamant.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        items.addDiamantItems(p);
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            diamant.put(uuid, (60 * 30L)/2);
                        }else {
                            diamant.put(uuid, 60*30L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE){
                if(getBergarbeiter(uuid) == 0) {
                    if (bergarbeiter.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        if(getGoldfinger(uuid) > 0) {
                            updateGoldfinger(uuid, 1, true);
                        }
                        items.addBergarbeiterItems(p);
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            bergarbeiter.put(uuid, (60 * 60 * 1L)/2);
                        }else {
                            bergarbeiter.put(uuid, 60*60L);
                        }
                        return;
                    }
                }else if(MoneyManager.getMoney(uuid) >= 1000000) {
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast das Kit §aerfolgreich §7gekauft!");
                    MoneyManager.updateMoney(uuid, 1000000, true, false);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    if(getBergarbeiter(uuid) > 0) {
                        updateBergarbeiter(uuid, 50, true);
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.GOLD_INGOT){
                if(getGoldfinger(uuid) == 0) {
                    if (goldfinger.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        items.addGoldfingerItems(p);
                        if(getJuwelier(uuid) > 0) {
                            updateJuwelier(uuid, 1, true);
                        }
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            goldfinger.put(uuid, 60 * 60 * 1L);
                        }else {
                            goldfinger.put(uuid,60*60*2L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.DIAMOND){
                if(getJuwelier(uuid) == 0) {
                    if (juwelier.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        items.addJuwelierItems(p);
                        if(getBanker(uuid) > 0) {
                            updateBanker(uuid, 1, true);
                        }
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            juwelier.put(uuid, (60 * 60 * 3L)/2);
                        }else {
                            juwelier.put(uuid, 60*60*3L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.EMERALD){
                if(getBanker(uuid) == 0) {
                    if (banker.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        items.addBänkerItems(p);
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            banker.put(uuid, 60 * 60 * 3L);
                        }else {
                            banker.put(uuid, 60*60*6L);
                        }

                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.MELON){
                if(getNinja(uuid) == 0) {
                    if (ninja.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        if(getNinja(uuid) > 0) {
                            updateNinja(uuid, 1, true);
                        }
                        items.addNinjaItems(p);
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            ninja.put(uuid, (60 * 60 * 1L)/2);
                        }else {
                            ninja.put(uuid, 60*60L);
                        }
                        return;
                    }
                }else if(MoneyManager.getMoney(uuid) >= 5000000) {
                    p.sendMessage(MessageManager.PREFIX + "§7Du hast das Kit §aerfolgreich §7gekauft!");
                    MoneyManager.updateMoney(uuid, 5000000, true, false);
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    if(getBergarbeiter(uuid) > 0) {
                        updateBergarbeiter(uuid, 50, true);
                    }
                    p.closeInventory();
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.SUGAR_CANE){
                if(getSensei(uuid) == 0) {
                    if (sensei.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        if(getSensei(uuid) > 0) {
                            updateSensei(uuid, 1, true);
                        }
                        items.addSenseiItems(p);
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            sensei.put(uuid, (60 * 60 * 3L)/2);
                        }else {
                            sensei.put(uuid, 60*60*3L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }else if(e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE){
                if(getMeister(uuid) == 0) {
                    if (meister.containsKey(uuid)) {
                        p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                        p.closeInventory();
                        p.sendMessage(MessageManager.KITNOTREADY);
                        return;
                    } else {
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        p.closeInventory();
                        if(getMeister(uuid) > 0) {
                            updateMeister(uuid, 1, true);
                        }
                        items.addMeisterItems(p);
                        if(RunenFuctions.speedUpRune(p.getUniqueId())) {
                            meister.put(uuid, 60 * 60 * 3L);
                        }else {
                            meister.put(uuid, 60 * 60 * 6L);
                        }
                        return;
                    }
                }else {
                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
                    p.closeInventory();
                    p.sendMessage(MessageManager.DONTHAVEKIT);
                    return;
                }
            }
        }
    }

    public static int getHolz(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Holz FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Holz");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getStein(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Stein FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Stein");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getEisen(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Eisen FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Eisen");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getWarzone(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Warzone FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Warzone");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getDiamant(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Diamant FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Diamant");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getBergarbeiter(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Bergarbeiter FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Bergarbeiter");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getGoldfinger(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Goldfinger FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Goldfinger");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getJuwelier(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Juwelier FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Juwelier");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getBanker(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Banker FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Banker");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getNinja(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Ninja FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Ninja");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getSensei(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Sensei FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Sensei");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }
    public static int getMeister(UUID uuid) {
        int xp = 0;

        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("SELECT Meister FROM KitSystem WHERE UUID = ?")) {
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                xp = rs.getInt("Meister");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return xp;
    }

    public static void updateHolz(UUID uuid, float amount, boolean remove) {
        float currMoney = getHolz(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Holz = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateStein(UUID uuid, float amount, boolean remove) {
        float currMoney = getStein(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Stein = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateEisen(UUID uuid, float amount, boolean remove) {
        float currMoney = getEisen(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Eisen = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateWarzone(UUID uuid, float amount, boolean remove) {
        float currMoney = getWarzone(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Warzone = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateDiamant(UUID uuid, float amount, boolean remove) {
        float currMoney = getDiamant(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Diamant = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateBergarbeiter(UUID uuid, float amount, boolean remove) {
        float currMoney = getBergarbeiter(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Bergarbeiter = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateGoldfinger(UUID uuid, float amount, boolean remove) {
        float currMoney = getGoldfinger(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Goldfinger = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateJuwelier(UUID uuid, float amount, boolean remove) {
        float currMoney = getJuwelier(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Juwelier = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateBanker(UUID uuid, float amount, boolean remove) {
        float currMoney = getBanker(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Banker = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateNinja(UUID uuid, float amount, boolean remove) {
        float currMoney = getNinja(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Ninja = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateSensei(UUID uuid, float amount, boolean remove) {
        float currMoney = getSensei(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Sensei = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateMeister(UUID uuid, float amount, boolean remove) {
        float currMoney = getMeister(uuid);
        float newAmount;
        if (remove) {
            newAmount = currMoney - amount;
        } else {
            newAmount = (currMoney + amount);
        }
        try (Connection connection = MySQL.getHikariDataSource().getConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE KitSystem SET Meister = ? WHERE UUID = ?")) {
            ps.setFloat(1, newAmount);
            ps.setString(2, uuid.toString());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}