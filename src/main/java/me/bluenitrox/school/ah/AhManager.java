package me.bluenitrox.school.ah;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

public class AhManager {
    public static int ahtaskid;

    public static void openAh(Inventory inv, int page, Player p){
        setAhContent(inv, page, p);
        p.openInventory(inv);
    }

    public static void setAhContent(Inventory inv, int page, Player p){
        ItemTimeManager itm = new ItemTimeManager();
        ItemStack is = new ItemBuilder(Material.STAINED_GLASS_PANE, (short)0).setDisplayname(" ").build();
        ItemStack chest = new ItemBuilder(Material.CHEST).setDisplayname("§7Abgelaufene §6Auktionen§7/§6Gekaufte §7Auktionen").setLore("§b» §7Klicke um deine §6Abgelaufenen/Gekauften Auktionen §7zu bekommen!").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§6§lAuktionshaus").setLore("§b» §7Hier kannst du Items §akaufen ","§b» §7oder auch selber §cverkaufen§7!","§b» §7Deine Seite:§a " + page).build();

        for(int i= 0; i != 9; i++){
            inv.setItem(i , is);
        }
        for(int i= 36; i != 45; i++){
            inv.setItem(i , is);
        }
        inv.setItem(40, chest);
        inv.setItem(4, sign);
        if(getAllItems() != 0) {
            int offset = (page - 1) * 27;
            int i = 9;
            int maxpage = getMaxPage();
            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM AhItems LIMIT 27 OFFSET ?")) {
                ps.setInt(1, offset);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    ItemStack item = decodeItem(rs.getString(3));

                    ItemMeta imn = item.getItemMeta();
                    List<String> imnn = imn.getLore();
                    ArrayList<String> lore = new ArrayList<>();
                    if (imn.getLore() != null) {
                        lore.addAll(imnn);
                    }
                    lore.add("§b=====================");
                    lore.add("§6» §7Verkäufer: §a" + Bukkit.getOfflinePlayer(UUID.fromString(rs.getString(2))).getName());
                    lore.add("§6» §7Preis: " + enCode(rs.getInt(4)));
                    lore.add("§6» §7Verbleibende Zeit: " + itm.getTimeFromItem(rs.getInt(1)));
                    lore.add("§6» §7Auktionsid: " + rs.getInt(1));
                    lore.add("§b=====================");
                    imn.setLore(lore);
                    item.setItemMeta(imn);

                    inv.setItem(i, item);

                    i++;
                }
                if (maxpage != 0) {
                    if (!(page >= maxpage))
                        inv.setItem(44, new ItemBuilder(Material.PAPER).setDisplayname("§7Nächste Seite").setLore("§b» §7Klicke um auf die Nächste Seite zu kommen!").build());

                    if (!(page <= 1))
                        inv.setItem(36, new ItemBuilder(Material.PAPER).setDisplayname("§7Vorherige Seite").setLore("§b» §7Klicke um auf die Vorherige Seite zu kommen!").build());

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else
            for(int i = 9; i <= 27; i++)
                inv.setItem(i, new ItemBuilder(Material.AIR).build());

        //scheduler speichern / starten / und bei Inventory close Event canceln



    }

    //  [name: superitem, material: stone, durability: 1423, amount: 1, short: 64, enchants: [fireaspect, sharpness, knockback], lore: [zeile 1, zeile 2, zeile 3, zeile 4]]

    public static String enCode(Integer i){
        String[] price = i.toString().split("");
        if(i >= 1000000 && i < 10000000){
            return price[0] +"," + price[1] + price[2] +" Mio";
        }else if(i >= 10000000 && i < 100000000){
            return price[0] + price[1] +"," + price[2] + price[3] +" Mio";
        }else if(i >= 100000000){
            return price[0] + price[1] + price[2] +"," + price[3] + price[4] + " Mio";
        }else if(i >= 1000000000){
            return price[0] + "," + price[1] + price[2] +" Mrd";
        }else {
            return i + "";
        }
    }

    public static String enCodeLong(Long i){
        String[] price = i.toString().split("");
        if(i >= 1000000 && i < 10000000){
            return price[0] +"," + price[1] + price[2] +" Mio";
        }else if(i >= 10000000 && i < 100000000){
            return price[0] + price[1] +"," + price[2] + price[3] +" Mio";
        }else if(i >= 100000000){
            return price[0] + price[1] + price[2] +"," + price[3] + price[4] + " Mio";
        }else if(i >= 1000000000){
            return price[0] + "," + price[1] + price[2] +" Mrd";
        }else {
            return i + "";
        }
    }

    public static void sellItem(ItemStack is, Player p, int preis, Inventory inv){

        Timestamp einstelldatum = new Timestamp(System.currentTimeMillis());

        int min = 3;

        Timestamp jetzt = new Timestamp(System.currentTimeMillis());
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
        cal.setTimeInMillis(jetzt.getTime());
        cal.add(Calendar.MINUTE, min);
        Timestamp ablaufdatum = new Timestamp(cal.getTime().getTime());

        if(is.getType() == Material.CHEST || is.getType() == Material.SIGN || is.getType() == Material.STAINED_GLASS_PANE || is.getType() == Material.PAPER){
            p.sendMessage("§7Dieses Item kannst du §cnicht §7ins ah stellen!"+ "ENGLISH!!!");
            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L, 1L);
            return;
        }
        if(is.getItemMeta().getDisplayName() == null){
            ItemMeta im = is.getItemMeta();
            im.setDisplayName("§7" + is.getType().toString().toLowerCase());
            is.setItemMeta(im);
        }
        String item = encodeItem(is);

        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO AhItems (spieleruuid, item, preis, einstelldatum, ablaufdatum) VALUES (?, ?, ?, ?, ?)")){
            ps.setString(1, p.getUniqueId().toString());
            ps.setString(2, item);
            ps.setInt(3, preis);
            ps.setTimestamp(4, einstelldatum);
            ps.setTimestamp(5, ablaufdatum);
            ps.executeUpdate();
            p.sendMessage("§7Dein Item wurde erfolgreich ins ah gestellt!"+ "ENGLISH!!!");
            p.setItemInHand(new ItemBuilder(Material.AIR).build());

            try(PreparedStatement ps2 = MySQL.getConnection().prepareStatement("SELECT id FROM AhItems WHERE spieleruuid = ? ORDER BY id DESC LIMIT 1")){
                ps2.setString(1, p.getUniqueId().toString());
                ResultSet rs = ps2.executeQuery();
                while (rs.next()){
                    ItemTimeManager itm = new ItemTimeManager();
                    itm.setValues(rs.getInt(1), 300);
                }

            }catch (SQLException e){
                e.printStackTrace();
            }
        }catch (SQLException e) {
            e.printStackTrace();
            p.sendMessage(MessageManager.ERROR);
        }
    }

    public static void openabgelaufeneundgekaufteAuktionen(Player p, int page, Inventory inv) {

        ItemStack is = new ItemBuilder(Material.STAINED_GLASS_PANE, (short) 0).setDisplayname(" ").build();
        ItemStack chest = new ItemBuilder(Material.CHEST).setDisplayname("§7Abgelaufene §6Auktionen§7/§6Gekaufte §7Auktionen").setLore("§b» §7Klicke um deine §6Abgelaufenen/Gekauften Auktionen §7zu bekommen!").build();
        ItemStack sign = new ItemBuilder(Material.SIGN).setDisplayname("§6§lAuktionshaus").setLore("§b» §7Hier kannst du Items §akaufen ","§b» §7oder auch selber §cverkaufen§7!","§b» §7Deine Seite:§a " + page).build();

        for (int i = 0; i != 9; i++) {
            inv.setItem(i, is);
        }
        for (int i = 36; i != 45; i++) {
            inv.setItem(i, is);
        }
        inv.setItem(40, chest);
        inv.setItem(4, sign);

        int offset = (page - 1) * 27;
        int i = 9;
        int maxpage = getMaxPageofPlayer(p);
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM AhItemsAbgelaufen WHERE spieleruuid = ? LIMIT 27 OFFSET ?")) {
            ps.setString(1, p.getUniqueId().toString());
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ItemStack item = decodeItem(rs.getString(3));

                ItemMeta imn = item.getItemMeta();
                List<String> imnn = imn.getLore();
                ArrayList<String> lore = new ArrayList<>();
                if (imn.getLore() != null){
                    lore.addAll(imnn);
                }
                lore.add("§b=====================");
                lore.add("§6» §7Auktionsid: " + rs.getInt(1));
                lore.add("§b=====================");
                imn.setLore(lore);
                item.setItemMeta(imn);

                inv.setItem(i, item);

                i++;
            }
            if(maxpage != 0) {
                if (!(page >= maxpage))
                    inv.setItem(44, new ItemBuilder(Material.PAPER).setDisplayname("§7Nächste Seite").setLore("§b» §7Klicke um auf die Nächste Seite zu kommen!").build());

                if (!(page <= 1))
                    inv.setItem(36, new ItemBuilder(Material.PAPER).setDisplayname("§7Vorherige Seite").setLore("§b» §7Klicke um auf die Vorherige Seite zu kommen!").build());

            }

            p.openInventory(inv);
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static void openBuyInv(int id, Inventory inv, Player p){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM AhItems WHERE id = ?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                ItemStack item = decodeItem(rs.getString(3));

                ItemMeta imn = item.getItemMeta();
                List<String> imnn = imn.getLore();
                ArrayList<String> lore = new ArrayList<>();
                if (imn.getLore() != null){
                    lore.addAll(imnn);
                }
                lore.add("§b=====================");
                lore.add("§6» §7Verkäufer: §a" + Bukkit.getOfflinePlayer(UUID.fromString(rs.getString(2))).getName());
                lore.add("§6» §7Preis: " + enCode(rs.getInt(4)));
                lore.add("§6» §7Auktionsid: " + rs.getInt(1));
                lore.add("§b=====================");
                imn.setLore(lore);
                item.setItemMeta(imn);

                inv.setItem(3, item);

                inv.setItem(2, new ItemBuilder(Material.INK_SACK, (short)1).setDisplayname("§c§lAbbrechen").build());
                inv.setItem(0, new ItemBuilder(Material.INK_SACK, (short)10).setDisplayname("§a§lKaufen").build());

                p.openInventory(inv);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void buyItem(int id, Player buyer){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM AhItems WHERE id = ?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                if(!(MoneyManager.getMoney(buyer.getUniqueId()) >= rs.getInt(4))) {
                    buyer.sendMessage("§cDazu hast du nicht genug Geld!" + "ENGLISH!!!");
                    buyer.closeInventory();
                    buyer.playSound(buyer.getLocation(), Sound.VILLAGER_NO, 1L , 1L);
                    return;
                }
                if(buyer == Bukkit.getPlayer(UUID.fromString(rs.getString(2)))){
                    buyer.sendMessage("§cDu kannst deine eigenen Items nicht kaufen!"+ "ENGLISH!!!");
                    buyer.closeInventory();
                    buyer.playSound(buyer.getLocation(), Sound.VILLAGER_NO, 1L , 1L);
                    return;
                }
                try(PreparedStatement ps2 = MySQL.getConnection().prepareStatement("INSERT INTO AhItemsAbgelaufen (spieleruuid, item) VALUES (?,?)")){
                    ps2.setString(1, buyer.getUniqueId().toString());
                    ps2.setString(2, rs.getString(3));
                    ps2.executeUpdate();
                    try(PreparedStatement ps3 = MySQL.getConnection().prepareStatement("DELETE FROM AhItems WHERE id = ?")){
                        ps3.setInt(1, id);
                        ps3.execute();
                        buyer.sendMessage("§7Dein Kauf war §aerfolgreich §7du findest dein Item unter abgelaufenen Auktionen im §c/ah §7!"+ "ENGLISH!!!");
                        MoneyManager.updateMoney(buyer.getUniqueId(), rs.getInt(4), true,false);
                        MoneyManager.updateMoney(UUID.fromString(rs.getString(2)),rs.getInt(4), true, false);
                        if(Bukkit.getPlayer(UUID.fromString(rs.getString(2))).isOnline()) {
                            Player t = Bukkit.getPlayer(UUID.fromString(rs.getString(2)));
                            t.sendMessage("§7Deine §6Auktion §7wurde von " + buyer.getName() + "§a gekauft!"+ "ENGLISH!!!");
                            t.playSound(t.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                        }
                        buyer.playSound(buyer.getLocation(), Sound.NOTE_BASS, 1L , 1L);
                    }catch (SQLException ex){
                        ex.printStackTrace();
                    }

                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("DELETE * FROM AhItems WHERE id = ?")){
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static int getAllItems(){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT COUNT(id) AS total FROM AhItems")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }

    private static int getAllItemsofPlayer(Player p){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT COUNT(id) AS total FROM AhItemsAbgelaufen WHERE spieleruuid = ?")) {
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int getMaxPageofPlayer(Player p){
        int zeilen = 27;
        int items = getAllItems();

        return (getAllItemsofPlayer(p) + zeilen - 1) / zeilen;
    }

    private static int getMaxPage(){
        int zeilen = 27;
        int items = getAllItems();

        return (getAllItems() + zeilen - 1) / zeilen;
    }

    public static int getAhItems(Player p){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT COUNT(id) AS total FROM AhItems WHERE spieleruuid = ?")){
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt("total");
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        return 0;
    }

    public static String encodeItem(ItemStack itemStack) { //String aus ItemStack
        YamlConfiguration config = new YamlConfiguration();
        config.set("i", itemStack);
        return config.saveToString();
    }

    public static ItemStack decodeItem(String string) { //ItemsStack aus String
        YamlConfiguration config = new YamlConfiguration();
        try {
            config.loadFromString(string);
        } catch (IllegalArgumentException | InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }
        return config.getItemStack("i", null);
    }

    public static void removeItem(int id){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM AhItems WHERE id = ?")){
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                try(PreparedStatement ps2 = MySQL.getConnection().prepareStatement("INSERT INTO AhItemsAbgelaufen (spieleruuid, item) VALUES (?,?)")){
                    ps2.setString(1, rs.getString(2));
                    ps2.setString(2, rs.getString(3));
                    ps2.executeUpdate();
                    try(PreparedStatement ps3 = MySQL.getConnection().prepareStatement("DELETE FROM AhItems WHERE id = ?")){
                        ps3.setInt(1, id);
                        ps3.execute();
                        for(Player curr : Bukkit.getOnlinePlayers())
                            if(curr.getOpenInventory().getTopInventory().getTitle().equals(Ah_CMD.GUI_NAME)) {
                                String[] stringregex = curr.getOpenInventory().getTopInventory().getItem(4).getItemMeta().getLore().get(2).split(" ");
                                int currPage = Integer.parseInt(stringregex[3]);
                                Inventory invah = curr.getOpenInventory().getTopInventory();
                                invah.clear();
                                setAhContent(invah, currPage, curr);
                                if(Bukkit.getPlayer(UUID.fromString(rs.getString(2))) != null){
                                    Bukkit.getPlayer(UUID.fromString(rs.getString(2))).sendMessage("§7Deine Auktion konnte §cnicht §7verkauft werden. Du kannst sie unter §6Abgelaufenen Auktionen §7im §6/ah §7wieder abholen!" + "ENGLISH!!!!!");
                                }
                            }
                    }catch (SQLException ex){
                        ex.printStackTrace();
                    }

                }catch (SQLException e){
                    e.printStackTrace();
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}