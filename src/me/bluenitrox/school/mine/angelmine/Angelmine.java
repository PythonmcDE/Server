package me.bluenitrox.school.mine.angelmine;

import me.bluenitrox.school.managers.LocationManager;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.MoneyManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.ItemBuilder;
import me.bluenitrox.school.utils.KopfUtil;
import me.bluenitrox.school.utils.NBTTags;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.UUID;

public class Angelmine implements CommandExecutor {

    private String guiname = "§6§lAngelminen";

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        if(!(cs instanceof Player)){
            cs.sendMessage(MessageManager.NOPLAYER);
            return true;
        }
        if(args.length == 0) {
            Inventory inv = Bukkit.createInventory(null, 9*6, guiname);
            setInventoryContent(inv, p);
        }else {
            p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
        }
        return false;
    }

    private void setInventoryContent(Inventory inv, Player p){
        UUID uuid = p.getUniqueId();
        ItemStack glas = new ItemBuilder(Material.STAINED_GLASS_PANE).setDisplayname(" ").build();
        ItemStack angel = new ItemBuilder(Material.FISHING_ROD).setDisplayname("§8§l» §c§lAngelminen").setLore("§6§l▶ §7Schalte hier neue §6§lAngelminen §7frei, um bessere",
                "§6§l▶ Items §7angeln zu können.e").build();

        ItemStack gfish = KopfUtil.createSkull("AgentPerry1337", "§8§l» §6§lAngelmine 9");
        ItemMeta meta = gfish.getItemMeta();
        meta.addEnchant(Enchantment.ARROW_INFINITE, 10, false);
        meta.setLore(Arrays.asList("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7."));
        gfish.setItemMeta(meta);

        ItemStack gfish2 = KopfUtil.createSkull("AgentPerry1337", "§8§l» §6§lAngelmine 9");
        ItemMeta meta2 = gfish2.getItemMeta();
        meta2.setLore(Arrays.asList("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: §bGroßer Fisch","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_9_PREIS)+ " §7Gems"));
        gfish2.setItemMeta(meta2);

        ItemStack gfish3 = KopfUtil.createSkull("AgentPerry1337", "§8§l» §6§lAngelmine 9");
        ItemMeta meta3 = gfish3.getItemMeta();
        meta3.setLore(Arrays.asList("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: §bGroßer Fisch"));
        gfish3.setItemMeta(meta3);

        ItemStack angelmine1 = new ItemBuilder(Material.RAW_FISH).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 1").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine2 = new ItemBuilder(Material.RAW_FISH, (short) 1).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 2").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine3 = new ItemBuilder(Material.RAW_FISH, (short) 3).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 3").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine4 = new ItemBuilder(Material.RAW_FISH, (short) 2).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 4").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine5 = new ItemBuilder(Material.VINE).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 5").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine6 = new ItemBuilder(Material.INK_SACK).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 6").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine7 = new ItemBuilder(Material.WATER_LILY).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 7").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine8 = new ItemBuilder(Material.EYE_OF_ENDER).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 8").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();
        ItemStack angelmine9 = gfish;
        ItemStack angelmine10 = new ItemBuilder(Material.ENDER_CHEST).addEnchant(Enchantment.ARROW_INFINITE, 10, false).setDisplayname("§8§l» §6§lAngelmine 10").setLore("§6§l▶ §7Du besitzt diese §6§lAngelmine§7, klicke", "§6§l▶ §7hier zum §6§lTeleportieren§7.").build();

        ItemStack angelmine22 = new ItemBuilder(Material.RAW_FISH, (short) 1).setDisplayname("§8§l» §6§lAngelmine 2").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Roher Lachs","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_2_PREIS)+ " §7Gems").build();
        ItemStack angelmine32 = new ItemBuilder(Material.RAW_FISH, (short) 3).setDisplayname("§8§l» §6§lAngelmine 3").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Kugelfisch","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_3_PREIS)+ " §7Gems").build();
        ItemStack angelmine42 = new ItemBuilder(Material.RAW_FISH, (short) 2).setDisplayname("§8§l» §6§lAngelmine 4").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Clownfisch","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_4_PREIS)+ " §7Gems").build();
        ItemStack angelmine52 = new ItemBuilder(Material.VINE).setDisplayname("§8§l» §6§lAngelmine 5").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Alge","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_5_PREIS)+ " §7Gems").build();
        ItemStack angelmine62 = new ItemBuilder(Material.INK_SACK).setDisplayname("§8§l» §6§lAngelmine 6").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Tintenbeuteul","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_6_PREIS)+ " §7Gems").build();
        ItemStack angelmine72 = new ItemBuilder(Material.WATER_LILY).setDisplayname("§8§l» §6§lAngelmine 7").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Seerose","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_7_PREIS)+ " §7Gems").build();
        ItemStack angelmine82 = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§8§l» §6§lAngelmine 8").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: Wächterauge","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_8_PREIS)+ " §7Gems").build();
        ItemStack angelmine92 = gfish2;
        ItemStack angelmine102 = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§8§l» §6§lAngelmine 10").setLore("§6§l▶ §aKlicke hier§7, um die Angelmine zu §6kaufen§7.", "", "§8§l● §7Neues: §bSchatzkiste","  ", "§6§l▶ §7Kaufspreis: §6" + ValuetoString.valueToString(MessageManager.ANGELMINE_10_PREIS)+ " §7Gems").build();

        ItemStack angelmine33 = new ItemBuilder(Material.RAW_FISH, (short) 3).setDisplayname("§8§l» §6§lAngelmine 3").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Kugelfisch").build();
        ItemStack angelmine43 = new ItemBuilder(Material.RAW_FISH, (short) 2).setDisplayname("§8§l» §6§lAngelmine 4").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Clownfisch").build();
        ItemStack angelmine53 = new ItemBuilder(Material.VINE).setDisplayname("§8§l» §6§lAngelmine 5").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Alge").build();
        ItemStack angelmine63 = new ItemBuilder(Material.INK_SACK).setDisplayname("§8§l» §6§lAngelmine 6").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Tintenbeuteul").build();
        ItemStack angelmine73 = new ItemBuilder(Material.WATER_LILY).setDisplayname("§8§l» §6§lAngelmine 7").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Seerose").build();
        ItemStack angelmine83 = new ItemBuilder(Material.EYE_OF_ENDER).setDisplayname("§8§l» §6§lAngelmine 8").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: Wächterauge").build();
        ItemStack angelmine93 = gfish3;
        ItemStack angelmine103 = new ItemBuilder(Material.ENDER_CHEST).setDisplayname("§8§l» §6§lAngelmine 10").setLore("§6§l▶ §7Bevor du diese §6§lAngelmine §7kaufen kannst,", "§6§l▶ §7musst du §6§lalle anderen §7davor freischalten.", " ", "§8§l● §7Neues: §bSchatzkiste").build();

        for(int i = 0; i <= 8; i++) {
            if (i != 4) {
                inv.setItem(i, glas);
            }
        }
        for(int i = 45; i <= 53; i++){
            inv.setItem(i,glas);
        }

        inv.setItem(4, angel);

        if(AngelminenManager.getAngelmine(uuid) >= 1){
            inv.setItem(9, angelmine1);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 2){
            inv.setItem(10, angelmine2);
        }else {
            inv.setItem(10, angelmine22);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 3){
            inv.setItem(11, angelmine3);
        }else if(AngelminenManager.getAngelmine(uuid) == 2){
            inv.setItem(11, angelmine32);
        }else {
            inv.setItem(11, angelmine33);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 4){
            inv.setItem(12, angelmine4);
        }else if(AngelminenManager.getAngelmine(uuid) == 3){
            inv.setItem(12, angelmine42);
        }else {
            inv.setItem(12, angelmine43);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 5){
            inv.setItem(13, angelmine5);
        }else if(AngelminenManager.getAngelmine(uuid) == 4){
            inv.setItem(13, angelmine52);
        }else {
            inv.setItem(13, angelmine53);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 6){
            inv.setItem(14, angelmine6);
        }else if(AngelminenManager.getAngelmine(uuid) == 5){
            inv.setItem(14, angelmine62);
        }else {
            inv.setItem(14, angelmine63);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 7){
            inv.setItem(15, angelmine7);
        }else if(AngelminenManager.getAngelmine(uuid) == 6){
            inv.setItem(15, angelmine72);
        }else {
            inv.setItem(15, angelmine73);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 8){
            inv.setItem(16, angelmine8);
        }else if(AngelminenManager.getAngelmine(uuid) == 7){
            inv.setItem(16, angelmine82);
        }else {
            inv.setItem(16, angelmine83);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 9){
            inv.setItem(17, angelmine9);
        }else if(AngelminenManager.getAngelmine(uuid) == 8){
            inv.setItem(17, angelmine92);
        }else {
            inv.setItem(17, angelmine93);
        }
        if(AngelminenManager.getAngelmine(uuid) >= 10){
            inv.setItem(18, angelmine10);
        }else if(AngelminenManager.getAngelmine(uuid) == 9){
            inv.setItem(18, angelmine102);
        }else {
            inv.setItem(18, angelmine103);
        }

        p.openInventory(inv);
    }

    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getClickedInventory().getName().equalsIgnoreCase(guiname)) {
            if(e.getCurrentItem() != null){
                e.setCancelled(true);
                if(e.getCurrentItem().getItemMeta() != null){
                    if(e.getCurrentItem().getItemMeta().getDisplayName() != null){
                        if(e.getCurrentItem().getItemMeta().getDisplayName().startsWith("§8§l» §6§lAngelmine")){
                            String[] angeldisplay = e.getCurrentItem().getItemMeta().getDisplayName().split(" ");
                            int angelmine = Integer.parseInt(angeldisplay[2]);
                            Player p = (Player)e.getWhoClicked();
                            if(e.getCurrentItem().getItemMeta().getLore() != null) {
                                if (e.getCurrentItem().getItemMeta().getLore().get(0).startsWith("§6§l▶ §aKlicke hier§7")) {
                                    if(angelmine == 2){
                                        int preis = MessageManager.ANGELMINE_2_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 3){
                                        int preis = MessageManager.ANGELMINE_3_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 4){
                                        int preis = MessageManager.ANGELMINE_4_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 5){
                                        int preis = MessageManager.ANGELMINE_5_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 6){
                                        int preis = MessageManager.ANGELMINE_6_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 7){
                                        int preis = MessageManager.ANGELMINE_7_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 8){
                                        int preis = MessageManager.ANGELMINE_8_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 9){
                                        int preis = MessageManager.ANGELMINE_9_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }else if(angelmine == 10){
                                        int preis = MessageManager.ANGELMINE_10_PREIS;
                                        if(MoneyManager.getMoney(p.getUniqueId()) >= preis){
                                            MoneyManager.updateMoney(p.getUniqueId(), preis , true, false, false);
                                            AngelminenManager.updateMine(p.getUniqueId(), false);
                                            p.sendMessage(MessageManager.PREFIX + "§7Du hast dir Angelmine §a" + angelmine + "§7 gekauft!");
                                            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1L, 1L);
                                            p.closeInventory();
                                        }else {
                                            p.sendMessage(MessageManager.NOTMONEY(PlayerJoinManager.language));
                                            p.closeInventory();
                                            p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L ,1L);
                                        }
                                    }
                                }else if(e.getCurrentItem().getItemMeta().getLore().get(0).startsWith("§6§l▶ §7Bevor du diese")){
                                    p.closeInventory();
                                    p.playSound(p.getLocation(), Sound.VILLAGER_NO, 1L , 1L);
                                }else if(e.getCurrentItem().getItemMeta().getLore().get(0).startsWith("§6§l▶ §7Du besitzt diese")){
                                    if(new LocationManager("Angelmine" + angelmine).getLocation() != null) {
                                        p.teleport(new LocationManager("Angelmine" + angelmine).getLocation());
                                        AngelminenManager.joinAngelmine(p, angelmine);
                                    }
                                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 1L, 1L);
                                    p.sendMessage(MessageManager.PREFIX + "§7Du wurdest in Angelmine §a" + angelmine + "§7 teleportiert!");
                                    p.closeInventory();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
