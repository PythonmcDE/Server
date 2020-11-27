package me.bluenitrox.school.boost;

import de.Herbystar.TTA.TTA_Methods;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import me.bluenitrox.school.utils.Firework;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

public class BoosterAPI implements CommandExecutor {

    public static HashMap<String, Integer> boost = new HashMap<>();
    public static boolean xp1;
    public static boolean money1;


    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
        Player p = (Player) cs;
        if(args.length == 0) {
            p.sendMessage(MessageManager.PREFIX + "§7Hier sind deine Booster:");
            p.sendMessage(MessageManager.PREFIX + "§d§lXp-Booster: §7" + getXpBooster(p.getUniqueId()));
            p.sendMessage(MessageManager.PREFIX + "§d§lMoney-Booster: §7" + getMoneyBooster(p.getUniqueId()));
            p.sendMessage(MessageManager.PREFIX + "§d§lChest-Booster: §7" + getChestBooster(p.getUniqueId()));
        }else if(args.length == 1) {

            if(args[0].equalsIgnoreCase("help")) {
                p.sendMessage(MessageManager.PREFIX + "§6[]-----------Booster-----------[]");
                p.sendMessage("§6/booster ->§f Hiermit kannst du sehen welche booster du besitzt");
                p.sendMessage("§6/booster <Boostername> -> §fHiermit aktivierst du einen booster");
                p.sendMessage("§6/booster info -> §fHier mit siehst du welche booster aktiv sind");
                if(p.hasPermission(PermissionsManager.ADDBOOSTER)) {
                    p.sendMessage("§6/booster <add/remove> <Spieler> <Boostername> <anzahl> -> §7Hier mit kannst du Spielern booster geben und wieder wegnehmen!");
                }
                p.sendMessage(MessageManager.PREFIX + "§6[]-----------Booster-----------[]");
            }else if(args[0].equalsIgnoreCase("xp")) {
                Xpbooster xp = new Xpbooster();
                if(hasEnoughXpBooster(p.getUniqueId(), 1)) {
                    if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xp.getName())))) {

                        Bukkit.broadcastMessage(MessageManager.PREFIX + p.getDisplayName() + "§7 hat einen: " + xp.getName() + "§7 für " + xp.getLenth() + " §7Minuten gezündet");
                        for(Player all : Bukkit.getOnlinePlayers()) {
                            TTA_Methods.sendTitle(all,"§6XP-Booster",20,20,20 ,"§7von " + p.getDisplayName(),20,20,20);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        }

                        SchoolMode.getInstance().getBoostermanager().startBoost(new Xpbooster());

                        Firework.Firework(p);

                        boost.put("xp", 3600);
                        xp1 = true;

                        removeXpBooster(p.getUniqueId(), 1);
                        return true;
                    }else {
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst keinen §d" + xp.getName() + " §7da bereits einer aktiv ist!");
                    }
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Xp-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("money")) {
                Moneybooster money = new Moneybooster();
                if(hasEnoughMoneyBooster(p.getUniqueId(), 1)) {
                    if(!SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {

                        Bukkit.broadcastMessage(MessageManager.PREFIX + p.getDisplayName() + "§7 hat einen: " + money.getName() + "§7 für " + money.getLenth() + " §7Minuten gezündet");

                        for(Player all : Bukkit.getOnlinePlayers()) {
                            TTA_Methods.sendTitle(all,"§6Money-Booster",20,20,20 ,"§7von " + p.getDisplayName(),20,20,20);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                            all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        }

                        SchoolMode.getInstance().getBoostermanager().startBoost(new Moneybooster());

                        Firework.Firework(p);

                        boost.put("money", 3600);
                        money1 = true;

                        removeMoneyBooster(p.getUniqueId(), 1);
                        return true;
                    }else {
                        p.sendMessage(MessageManager.PREFIX + "§7Du kannst keinen §d" + money.getName() + " §7da bereits einer aktiv ist!");
                    }
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Money-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("chest")) {
                if(hasEnoughChestBooster(p.getUniqueId(), 1)) {
                    Chestbooster chest = new Chestbooster();
                    Bukkit.broadcastMessage(MessageManager.PREFIX + p.getDisplayName() + "§7 hat einen: " + chest.getName() + "§7 mit " + chest.getLenth() + " §7Kisten gezündet");
                    for(Player all : Bukkit.getOnlinePlayers()) {
                        TTA_Methods.sendTitle(all,"§6Chest-Booster",20,20,20 ,"§7von " + p.getDisplayName(),20,20,20);
                        all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                        all.playSound(all.getLocation(), Sound.AMBIENCE_THUNDER, 1L , 1L);
                    }

                    Firework.Firework(p);

                    removeChestBooster(p.getUniqueId(), 1);

                }else {
                    p.sendMessage(MessageManager.PREFIX + "§7Du besitzt keinen Chest-Booster.");
                }
            }else if(args[0].equalsIgnoreCase("info")) {
                p.sendMessage(MessageManager.PREFIX + "§7Hier siehst du die derzeit Aktiven Booster:");

                Xpbooster xp = new Xpbooster();
                if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(xp.getName())))) {
                    p.sendMessage(MessageManager.PREFIX + "§bXp-Booster: §aan");
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§bXp-Booster §4aus");
                }
                Moneybooster money = new Moneybooster();
                if(SchoolMode.getInstance().getBoostermanager().getAktivboost().stream().anyMatch((b -> b.getName().equals(money.getName())))) {
                    p.sendMessage(MessageManager.PREFIX + "§bMoney-Booster: §aan");
                }else {
                    p.sendMessage(MessageManager.PREFIX + "§bMoney-Booster: §4aus");
                }
            }else {
                p.sendMessage(MessageManager.PREFIX + "§cFalsche Eingabe des Commands. Bitte benutze §6/booster help §c");
            }
        }else if (args.length == 4) {
            if (p.hasPermission(PermissionsManager.ADDBOOSTER)) {
                if (args[0].equalsIgnoreCase("add")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    String name = args[2];
                    Integer amount = Integer.valueOf(args[3]);
                    if (name.equalsIgnoreCase("xp")) {
                        addXpBooster(target.getUniqueId(), amount);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bXp-Booster §7bekommen");
                    } else if (name.equalsIgnoreCase("money")) {
                        addMoneyBooster(target.getUniqueId(), amount);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bMoney-Booster §7bekommen");
                    }else if (name.equalsIgnoreCase("chest")) {
                        addChestBooster(target.getUniqueId(), amount);
                        p.sendMessage(MessageManager.PREFIX + "§7" + target.getPlayer().getName() + " §7hat §a" + amount + "x §bChest-Booster §7bekommen");
                    } else {
                        p.sendMessage(MessageManager.FALSECOMMAND(PlayerJoinManager.language));
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    Player target = Bukkit.getPlayer(args[1]);
                    String name = args[2];
                    Integer amount = Integer.valueOf(args[3]);
                    if (name.equalsIgnoreCase("xp")) {
                        removeXpBooster(target.getUniqueId(), amount);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bXp-Booster §7removt");
                    } else if (name.equalsIgnoreCase("money")) {
                        removeMoneyBooster(target.getUniqueId(), amount);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bMoney-Booster §7removt");
                    } else if (name.equalsIgnoreCase("chest")) {
                        removeChestBooster(target.getUniqueId(), amount);
                        p.sendMessage(MessageManager.PREFIX + "§7Du hast §e" + target.getPlayer().getName() + "§a " + amount + "x §bChest-Booster §7removt");
                    }
                }

            } else {
                p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            }
        } else {
            p.sendMessage(MessageManager.BOOSTERARGS);
            return true;
        }
        return false;

    }


    public static Integer getXpBooster(UUID uuid) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int xp = cfg.getInt(uuid + ".xpbooster");
        return xp;

    }

    public static Integer getMoneyBooster(UUID uuid) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".moneybooster");
        return money;

    }

    public static Integer getChestBooster(UUID uuid) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".chestbooster");
        return money;

    }

    public static void addXpBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int xp = cfg.getInt(uuid + ".xpbooster");
        xp = xp + amount;
        cfg.set(uuid + ".xpbooster", xp);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void addMoneyBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".moneybooster");
        money = money + amount;
        cfg.set(uuid + ".moneybooster", money);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public static void addChestBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".chestbooster");
        money = money + amount;
        cfg.set(uuid + ".chestbooster", money);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();

        }

    }

    public void removeXpBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int xp = cfg.getInt(uuid + ".xpbooster");
        xp = xp - amount;
        cfg.set(uuid + ".xpbooster", xp);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeMoneyBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".moneybooster");
        money = money - amount;
        cfg.set(uuid + ".moneybooster", money);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void removeChestBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".chestbooster");
        money = money - amount;
        cfg.set(uuid + ".chestbooster", money);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean hasEnoughXpBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int xp = cfg.getInt(uuid + ".xpbooster");
        if (xp >= amount) {
            return true;
        } else
            return false;

    }

    public boolean hasEnoughMoneyBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".moneybooster");
        if (money >= amount) {
            return true;
        } else
            return false;

    }

    public boolean hasEnoughChestBooster(UUID uuid, int amount) {
        File file = new File("plugins//DemonMC", "booster.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        int money = cfg.getInt(uuid + ".chestbooster");
        if (money >= amount) {
            return true;
        } else
            return false;

    }
}