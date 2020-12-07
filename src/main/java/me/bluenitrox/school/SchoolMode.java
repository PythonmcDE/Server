package me.bluenitrox.school;

import me.bluenitrox.school.ah.AhListener;
import me.bluenitrox.school.ah.AhManager;
import me.bluenitrox.school.ah.Ah_CMD;
import me.bluenitrox.school.boost.BoostInv;
import me.bluenitrox.school.boost.BoosterAPI;
import me.bluenitrox.school.boost.BoosterManager;
import me.bluenitrox.school.enchants.CraftAPI;
import me.bluenitrox.school.features.GetCases;
import me.bluenitrox.school.commands.*;
import me.bluenitrox.school.features.KitAPI;
import me.bluenitrox.school.features.Pet;
import me.bluenitrox.school.haendler.HändlerAPI;
import me.bluenitrox.school.listener.*;
import me.bluenitrox.school.managers.LevelManager;
import me.bluenitrox.school.managers.ScoreboardManager;
import me.bluenitrox.school.mine.commands.Sell;
import me.bluenitrox.school.listener.BreakBlockEvent;
import me.bluenitrox.school.mine.manager.Minenreset;
import me.bluenitrox.school.mysql.MySQL;
import me.bluenitrox.school.mysql.MySQL_File;
import me.bluenitrox.school.utils.Antidupe;
import me.bluenitrox.school.utils.TimeManager;
import me.bluenitrox.school.utils.UUIDFetcher;
import me.bluenitrox.school.utils.ValuetoString;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;

public class SchoolMode extends JavaPlugin {

    public static SchoolMode instance;
    public static HashMap<UUID, Float> playerMoney = new HashMap<>();
    public static HashMap<UUID, Float> playerExp = new HashMap<>();
    public static HashMap<UUID, Integer> playerBlocks = new HashMap<>();
    public static HashMap<UUID, Integer> playerMine = new HashMap<>();
    public static HashMap<UUID, Integer> playerlevel = new HashMap<>();
    public static HashMap<UUID, Integer> playercase = new HashMap<>();
    public static HashMap<UUID, Integer> playerchest = new HashMap<>();
    public static HashMap<UUID, Integer> playergemlimit = new HashMap<>();
    public static ArrayList<UUID> playerwason = new ArrayList<>();
    public static HashMap<String,Entity> Pets = new HashMap<String, Entity>();
    private static final Random r = new Random();
    private BoosterManager boostermanager;
    public BoosterManager getBoostermanager() {
        return boostermanager;
    }
    public void setBoostermanager(BoosterManager boostermanager) {
        this.boostermanager = boostermanager;
    }



    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§4----------------------------------");
        Bukkit.getConsoleSender().sendMessage("§4Plugin §4aktivieren... §4(0/8)");
        register(Bukkit.getPluginManager());
        startMySQL();
        getCurrentDupeID();
        Bukkit.getConsoleSender().sendMessage("§4AntiDupe §4aktivieren... §4(5/8)");
        startAntiDupe();
        Bukkit.getConsoleSender().sendMessage("§4AhUpdate §4aktivieren... §4(6/8)");
        startAhUpdate();
        Bukkit.getConsoleSender().sendMessage("§4AhAnticrash §4aktivieren... §4(7/8)");
        startAhAnticrash();
        setBoostermanager(new BoosterManager());
        LevelManager.registerLevel();
        setGameRules();
        startKitSystem();
        Bukkit.getConsoleSender().sendMessage("§4Befülle alle Minen... §4(8/8)");
        Minenreset.fillMineServerStart();
        Bukkit.getConsoleSender().sendMessage("§4----------------------------------");
    }

    @Override
    public void onDisable() {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE antidupe SET dupeid = ?")) {
            ps.setInt(1,Antidupe.nextItemID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ahDisable();
        disablePets();
        MySQL.disconnect();
    }

    private void register(PluginManager pm){
        Bukkit.getConsoleSender().sendMessage("§4Lade §4Commands...");
        //Command register


        getCommand("gm").setExecutor(new Gamemode());
        getCommand("heal").setExecutor(new Heal());
        getCommand("feed").setExecutor(new Feed());
        getCommand("fly").setExecutor(new Fly());
        getCommand("set").setExecutor(new SetLocations());
        getCommand("money").setExecutor(new Money());
        getCommand("test").setExecutor(new NBTTagtest());
        getCommand("testzwei").setExecutor(new OtherTest());
        getCommand("getcases").setExecutor(new GetCases());
        getCommand("mine").setExecutor(new Mine());
        getCommand("sell").setExecutor(new Sell());
        getCommand("build").setExecutor(new Build());
        getCommand("ah").setExecutor(new Ah_CMD());
        getCommand("exp").setExecutor(new Exp());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("booster").setExecutor(new BoosterAPI());
        getCommand("kit").setExecutor(new Kit());
        getCommand("pet").setExecutor(new PetCommand());
        getCommand("stop").setExecutor(new StopCommand());
        getCommand("invsee").setExecutor(new Invsee());
        getCommand("clear").setExecutor(new Clear());
        getCommand("tk").setExecutor(new TK());
        getCommand("vanish").setExecutor(new Vanish());
        getCommand("händler").setExecutor(new HändlerAPI());
        getCommand("tp").setExecutor(new Tp());
        getCommand("tphere").setExecutor(new Tphere());


        //
        Bukkit.getConsoleSender().sendMessage("§4Commands §4Aktiviert! (1/8)");
        Bukkit.getConsoleSender().sendMessage("§4Lade §4Events...");
        //Event register


        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerQuitListener(), this);
        pm.registerEvents(new InventoryClickEvent(), this);
        pm.registerEvents(new PlayerInteractEvent(), this);
        pm.registerEvents(new InventoryOpenEvent(), this);
        pm.registerEvents(new InventoryCloseEvent(), this);
        pm.registerEvents(new PreCraftEvent(), this);
        pm.registerEvents(new BreakBlockEvent(), this);
        pm.registerEvents(new PlayerCommandPreprocessEvent(), this);
        pm.registerEvents(new AhListener(), this);
        pm.registerEvents(new PlayerExpChangeEvent(), this);
        pm.registerEvents(new PlayerAchievementAwardedEvent(), this);
        pm.registerEvents(new EntityCreatePortalEvent(), this);
        pm.registerEvents(new WeatherChangeEvent(), this);
        pm.registerEvents(new AsyncPlayerChatEvent(), this);
        pm.registerEvents(new PlayerDeathEvent(), this);
        pm.registerEvents(new PlayerRespawnEvent(), this);
        pm.registerEvents(new PlayerMoveEvent(), this);
        pm.registerEvents(new EntityDamageByEntityEvent(), this);
        pm.registerEvents(new EntityDamageEvent(), this);
        pm.registerEvents(new PlayerDropItemEvent(), this);
        pm.registerEvents(new ProjectileLaunchEvent(), this);
        pm.registerEvents(new CreatureSpawnEvent(), this);
        pm.registerEvents(new PlayerInteractEntityEvent(), this);

        //
        Bukkit.getConsoleSender().sendMessage("§4Events §4Registriert! (2/8)");

        CraftAPI.registerEnchants();
    }
    private void startAhAnticrash(){
        new BukkitRunnable(){
            @Override
            public void run() {
               AhManager.openedAH.clear();
                Pet.openCooldown.clear();
            }
        }.runTaskTimerAsynchronously(SchoolMode.getInstance(), 20*10, 20*10);
    }
    private void startMySQL() {
        Bukkit.getConsoleSender().sendMessage("§4Verbinde zu §4MySQL...");
        //MySQL Verbindung
        MySQL_File file = new MySQL_File();
        file.setdefault();
        file.readData();

        MySQL.connect();
        Bukkit.getConsoleSender().sendMessage("§4Erstelle §4Tabellen...");
        //Tabellen Erstellung
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `spielerdaten` ( `spieleruuid` CHAR(36) NOT NULL , `money` BIGINT(11) NOT NULL , `dungeon` INT(11) NOT NULL ,`exp` FLOAT NOT NULL , `mine` INT(11) NOT NULL , `prestige` INT(11) NOT NULL , `kills` INT(11) NOT NULL , `deaths` INT(11) NOT NULL , `cases` INT(11) NOT NULL , `bloecke` INT(11) NOT NULL , `mob` INT(11) NOT NULL ,`chests` INT(11) NOT NULL ,`level` INT(11) NOT NULL , PRIMARY KEY (`spieleruuid`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `locations` ( `name` VARCHAR(30) NOT NULL , `world` VARCHAR(30) NOT NULL , `x` DOUBLE NOT NULL , `y` DOUBLE NOT NULL , `z` DOUBLE NOT NULL , `yaw` FLOAT NOT NULL , `pitch` FLOAT NOT NULL , PRIMARY KEY (`name`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `schatzmeister` (`ID` INT(11) NOT NULL, Items Text , PRIMARY KEY (`ID`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `antidupe` ( `dupeid` INT(11) NOT NULL, PRIMARY KEY (`dupeid`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `minen` ( `id` INT(11) NOT NULL AUTO_INCREMENT , `name` VARCHAR(6) NOT NULL , `eckpoint1` VARCHAR(30) NOT NULL , `eckpoint2` VARCHAR(30) NOT NULL , `blocksforreset` INT(11) NOT NULL , PRIMARY KEY (`id`))");
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS AhItems ( `id` INT(11) NOT NULL AUTO_INCREMENT , `spieleruuid` CHAR(36) NOT NULL , `item` TEXT NOT NULL , `preis` INT(11) NOT NULL , `einstelldatum` TIMESTAMP(6) NOT NULL , `ablaufdatum` TIMESTAMP(6) NOT NULL , PRIMARY KEY (`id`))");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `AhItemsAbgelaufen` ( `id` INT(11) NOT NULL AUTO_INCREMENT, `spieleruuid` CHAR(36) NOT NULL , `item` TEXT NOT NULL,  PRIMARY KEY (`id`))");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `KitSystem` ( `UUID` CHAR(36) NOT NULL , `Holz` INT(11) NOT NULL , `Stein` INT(11) NOT NULL , `Eisen` INT(11) NOT NULL , `Warzone` INT(11) NOT NULL , `Diamant` INT(11) NOT NULL , `Bergarbeiter` INT(11) NOT NULL , `Goldfinger` INT(11) NOT NULL , `Juwelier` INT NOT NULL , `Banker` INT NOT NULL , `Ninja` INT NOT NULL , `Sensei` INT NOT NULL , `Meister` INT NOT NULL )");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `PetSystem` ( `UUID` CHAR(36) NOT NULL , `Benjamin` INT(11) NOT NULL , `Merlin` INT(11) NOT NULL , `Eddy` INT(11) NOT NULL , `Anton` INT(11) NOT NULL , `Helgar` INT(11) NOT NULL , `Farid` INT(11) NOT NULL , `Peter` INT(11) NOT NULL )");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        try{
            PreparedStatement ps = MySQL.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS `DailyReward` ( `UUID` CHAR(36) NOT NULL , `Belohnung` INT(11) NOT NULL , `Erfahrung` INT(11) NOT NULL , `Cases` INT(11) NOT NULL  , `GemLimit` INT(11) NOT NULL )");
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage("§4Tabellen §4erstellt! (4/8)");
    }
    private void startAntiDupe() {
        new BukkitRunnable() {

            @Override
            public void run() {
                if(!StopCommand.alreadystarted) {
                    if (TimeManager.restartServer()) {
                        StopCommand.restartServer();
                    }
                }
                Antidupe.ids = new ArrayList<>();
                for (Player all : Bukkit.getOnlinePlayers()) {
                    playerlevel.get(all.getUniqueId());
                    ScoreboardManager.setBoard(Bukkit.getPlayer(all.getUniqueId()));
                    Antidupe.checkAllInventorys(all.getInventory(), all);
                    return;
                }
                Antidupe.ids.clear();
            }
        }.runTaskTimerAsynchronously(this, 20 * 3, 20 * 3);
    }
    private void startAhUpdate(){
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(all -> {
                    if (all.getOpenInventory() != null) {
                        if (all.getOpenInventory().getTitle().equals(Ah_CMD.GUI_NAME)) {
                            String[] stringregex = all.getOpenInventory().getItem(4).getItemMeta().getLore().get(2).split(" ");
                            int currPage = Integer.parseInt(stringregex[3]);

                            AhManager.setAhContent(all.getOpenInventory().getTopInventory(), currPage, all);
                            all.updateInventory();
                        }
                    }
                });
            }
        }.runTaskTimerAsynchronously(this,20,20);
    }
    private void getCurrentDupeID(){
        if(isDupeIDExists()) {
            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT dupeid FROM antidupe")) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Antidupe.nextItemID = rs.getInt("dupeid") + 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try (PreparedStatement ps1 = MySQL.getConnection().prepareStatement("INSERT INTO antidupe (dupeid) VALUES (?)")) {
                ps1.setInt(1,1);
                ps1.executeUpdate();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
    private void setGameRules(){
        Bukkit.setWhitelist(false);
        for(World world : Bukkit.getWorlds()){
            world.setGameRuleValue("doTileDrops", "false");
            world.setDifficulty(Difficulty.EASY);
        }

    }
    private void startKitSystem(){
        new BukkitRunnable() {
            @Override
            public void run() {
                for(UUID uuid : playerwason){
                    if(KitAPI.holz.containsKey(uuid)){
                        if(KitAPI.holz.get(uuid) > 1){
                            KitAPI.holz.put(uuid,KitAPI.holz.get(uuid)-1);
                        }else {
                            KitAPI.holz.remove(uuid);
                        }
                    }
                    if(KitAPI.stein.containsKey(uuid)){
                        if(KitAPI.stein.get(uuid) > 1){
                            KitAPI.stein.put(uuid,KitAPI.stein.get(uuid)-1);
                        }else {
                            KitAPI.stein.remove(uuid);
                        }
                    }
                    if(KitAPI.eisen.containsKey(uuid)){
                        if(KitAPI.eisen.get(uuid) > 1){
                            KitAPI.eisen.put(uuid,KitAPI.eisen.get(uuid)-1);
                        }else {
                            KitAPI.eisen.remove(uuid);
                        }
                    }
                    if(KitAPI.warzone.containsKey(uuid)){
                        if(KitAPI.warzone.get(uuid) > 1){
                            KitAPI.warzone.put(uuid,KitAPI.warzone.get(uuid)-1);
                        }else {
                            KitAPI.warzone.remove(uuid);
                        }
                    }
                    if(KitAPI.diamant.containsKey(uuid)){
                        if(KitAPI.diamant.get(uuid) > 1){
                            KitAPI.diamant.put(uuid,KitAPI.diamant.get(uuid)-1);
                        }else {
                            KitAPI.diamant.remove(uuid);
                        }
                    }
                    if(KitAPI.bergarbeiter.containsKey(uuid)){
                        if(KitAPI.bergarbeiter.get(uuid) > 1){
                            KitAPI.bergarbeiter.put(uuid,KitAPI.bergarbeiter.get(uuid)-1);
                        }else {
                            KitAPI.bergarbeiter.remove(uuid);
                        }
                    }
                    if(KitAPI.goldfinger.containsKey(uuid)){
                        if(KitAPI.goldfinger.get(uuid) > 1){
                            KitAPI.goldfinger.put(uuid,KitAPI.goldfinger.get(uuid)-1);
                        }else {
                            KitAPI.goldfinger.remove(uuid);
                        }
                    }
                    if(KitAPI.juwelier.containsKey(uuid)){
                        if(KitAPI.juwelier.get(uuid) > 1){
                            KitAPI.juwelier.put(uuid,KitAPI.juwelier.get(uuid)-1);
                        }else {
                            KitAPI.juwelier.remove(uuid);
                        }
                    }
                    if(KitAPI.banker.containsKey(uuid)){
                        if(KitAPI.banker.get(uuid) > 1){
                            KitAPI.banker.put(uuid,KitAPI.banker.get(uuid)-1);
                        }else {
                            KitAPI.banker.remove(uuid);
                        }
                    }
                    if(KitAPI.ninja.containsKey(uuid)){
                        if(KitAPI.ninja.get(uuid) > 1){
                            KitAPI.ninja.put(uuid,KitAPI.ninja.get(uuid)-1);
                        }else {
                            KitAPI.ninja.remove(uuid);
                        }
                    }
                    if(KitAPI.sensei.containsKey(uuid)){
                        if(KitAPI.sensei.get(uuid) > 1){
                            KitAPI.sensei.put(uuid,KitAPI.sensei.get(uuid)-1);
                        }else {
                            KitAPI.sensei.remove(uuid);
                        }
                    }
                    if(KitAPI.meister.containsKey(uuid)){
                        if(KitAPI.meister.get(uuid) > 1){
                            KitAPI.meister.put(uuid,KitAPI.meister.get(uuid)-1);
                        }else {
                            KitAPI.meister.remove(uuid);
                        }
                    }
                }
            }
        }.runTaskTimerAsynchronously(this, 20, 20);

    }

    private void disablePets(){
        for(String name : Pets.keySet()){
            Pets.get(name).remove();
        }
    }
    private void ahDisable(){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM AhItems")){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String spieleruuid = rs.getString(2);
                String item = rs.getString(3);
                try (PreparedStatement ps2 = MySQL.getConnection().prepareStatement("INSERT INTO AhItemsAbgelaufen (spieleruuid, item) VALUES (?, ?)")) {
                    ps2.setString(1, spieleruuid);
                    ps2.setString(2, item);
                    ps2.execute();
                    try(PreparedStatement ps3 = MySQL.getConnection().prepareStatement("DELETE FROM AhItems WHERE spieleruuid = ?")){
                        ps3.setString(1, spieleruuid);
                        ps3.execute();
                    }catch (SQLException e){
                        e.printStackTrace();
                    }

                } catch (SQLException e) {

                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    private static boolean isDupeIDExists() {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT dupeid FROM antidupe");
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static SchoolMode getInstance() {
        return instance;
    }

    public static int getPlayerBlocks(UUID uuid) {
        return playerBlocks.get(uuid);
    }
    public static int getPlayerCases(UUID uuid) {
        return playercase.get(uuid);
    }
    public static int getPlayerMine(UUID uuid) {
        return playerMine.get(uuid);
    }
    public static int getGemLimit(UUID uuid) {
        return playergemlimit.get(uuid);
    }
    public static void setPlayerMine(UUID uuid, int amount) {
        playerMine.put(uuid, amount);
    }
    public static void setPlayerChest(UUID uuid, int amount) {
        playerchest.put(uuid, amount);
    }
    public static void setGemLimit(UUID uuid, int amount) {
        playergemlimit.put(uuid, amount);
    }
    public static float getPlayerExp(UUID uuid) {
        return playerExp.get(uuid);
    }
    public static float getPlayerChest(UUID uuid) {
        return playerchest.get(uuid);
    }
    public static String getPlayerExpString(UUID uuid) {
        float exp = playerExp.get(uuid);
        return ValuetoString.valueToString(exp);
    }
    public static void setPlayerExp(UUID uuid, float amount) {
        playerExp.put(uuid, amount);
    }
    public static void setPlayerCase(UUID uuid, int amount) {
        playercase.put(uuid, amount);
    }
    public static float getPlayerMoney(UUID uuid) {
        return playerMoney.get(uuid);
    }
    public static String getPlayerMoneyString(UUID uuid) {
        float money = playerMoney.get(uuid);
        return ValuetoString.valueToString(money);
    }
    public static void setPlayerBlocks(UUID uuid, int amount) {
        playerBlocks.put(uuid, amount);
    }
    public static void setPlayerMoney(UUID uuid, float amount) {
        playerMoney.put(uuid, amount);
    }
    public static int getRandomInt(int bound){
        Random r = SchoolMode.r;

        return r.nextInt(bound) + 1;
    }
    public static int getLevel(ItemStack item, Enchantment ench){
        if(item.containsEnchantment(ench)){
            return item.getEnchantmentLevel(ench);
        }
        return 0;
    }

}
