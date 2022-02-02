package me.bluenitrox.school.managers;

import de.pythonmc.clansystem.api.ClanAPI;
import de.pythonmc.clansystem.listener.PlayerJoinListener;
import de.pythonmc.clansystem.mysql.NickManager;
import de.pythonmc.clansystem.systemmanager.SystemManager;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.Skill;
import me.bluenitrox.school.features.SkillAPI;
import me.bluenitrox.school.features.StatsAPI;
import me.bluenitrox.school.mine.angelmine.AngelminenManager;
import me.bluenitrox.school.mine.manager.MinenManager;
import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.UUID;

public class PlayerJoinManager {

    public static int language = 0;

    public static Scoreboard getBoard() {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        return board;
    }


    public static void cachPlayerData(UUID uuid) {
        StatsAPI api = new StatsAPI();
        SkillAPI sapi = new SkillAPI();
        if(!isUserExists(uuid)) {
            configuratePlayer(uuid);
            configurateKitPlayer(uuid);
            configuratePetPlayer(uuid);
            configurateSkillPlayer(uuid);
        }
        float money = MoneyManager.getMoneyDatabase(uuid);
        float exp = ExpManager.getExpDatabase(uuid);
        int mine = MinenManager.getMineDatabase(uuid);
        int angelmine = AngelminenManager.getAngelmineDatabase(uuid);
        int blocks = PlayerBreakBlockManager.getBlocksDatabase(uuid);
        int mobs = StatsAPI.getMobDatabase(uuid);
        SchoolMode.setPlayerMoney(uuid, money);
        SchoolMode.playerlevel.put(uuid,ExpManager.getLevelDatabase(uuid));
        SchoolMode.setPlayerExp(uuid, exp);
        SchoolMode.setPlayerMine(uuid, mine);
        SchoolMode.setPlayerAngelmine(uuid,angelmine);
        SchoolMode.setPlayerBlocks(uuid, blocks);
        SchoolMode.setPlayerCase(uuid,api.getCasesDatabase(uuid));
        SchoolMode.setPlayerChest(uuid, api.getChestsDatabase(uuid));
        SchoolMode.setPlayerMob(uuid,mobs);
        SchoolMode.setPrestige(uuid, ExpManager.getPrestigeDatabase(uuid));
        KopfgeldManager.onTartgetJoin(uuid);
        Skill.cantopenSkill.add(Bukkit.getPlayer(uuid));
        new BukkitRunnable(){

            @Override
            public void run() {
                SchoolMode.playerskillpunkte.put(uuid, sapi.getSkillpunkteDatabase(uuid));
                SchoolMode.playerangriff.put(uuid, sapi.getDatabase(uuid, "angriff"));
                SchoolMode.playerverteidigung.put(uuid, sapi.getDatabase(uuid, "verteidigung"));
                SchoolMode.playerextraenergie.put(uuid, sapi.getDatabase(uuid, "extraenergie"));
                SchoolMode.playerscharfschütze.put(uuid, sapi.getDatabase(uuid, "scharfschütze"));
                SchoolMode.playermining.put(uuid, sapi.getDatabase(uuid, "mining"));
                SchoolMode.playerhandler.put(uuid, sapi.getDatabase(uuid, "handler"));
                SchoolMode.playeralchemist.put(uuid, sapi.getDatabase(uuid, "alchemist"));
                SchoolMode.playerbonusloot.put(uuid, sapi.getDatabase(uuid, "bonusloot"));
                SchoolMode.playergluckspilz.put(uuid, sapi.getDatabase(uuid, "gluckspilz"));
                Skill.cantopenSkill.remove(Bukkit.getPlayer(uuid));
            }
        }.runTaskLater(SchoolMode.getInstance(), 20*10);
        if(!isRewardUserExists(uuid)){
            configurateRewardPlayer(uuid);
        }
        SchoolMode.setGemLimit(uuid, (int) MoneyManager.getGemLimitdata(uuid));
    }

    public static void configuratePlayer(UUID uuid) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO spielerdaten (spieleruuid, money, dungeon, exp, mine, prestige, kills, deaths, cases, bloecke, mob, chests, level, angelmine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)")) {
            ps.setString(1, uuid.toString());
            ps.setFloat(2, 1000);
            ps.setInt(3, 1);
            ps.setFloat(4, 0);
            ps.setInt(5, 1);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setInt(10, 0);
            ps.setInt(11, 0);
            ps.setInt(12, 0);
            ps.setInt(13, 1);
            ps.setInt(14, 1);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateKitPlayer(UUID uuid) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO KitSystem (UUID, Holz, Stein, Eisen, Warzone, Diamant, Bergarbeiter, Goldfinger, Juwelier, Banker, Ninja, Sensei, Meister) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 35);
            ps.setInt(4, 50);
            ps.setInt(5, 50);
            ps.setInt(6, 50);
            ps.setInt(7, 50);
            ps.setInt(8, 35);
            ps.setInt(9, 50);
            ps.setInt(10, 50);
            ps.setInt(11, 50);
            ps.setInt(12, 35);
            ps.setInt(13, 50);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configuratePetPlayer(UUID uuid) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO PetSystem (UUID, Benjamin, Merlin, Eddy, Anton, Helgar, Farid, Peter) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateRewardPlayer(UUID uuid) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO DailyReward (UUID, Belohnung, Erfahrung, Cases, GemLimit) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, (int) MoneyManager.berechnungGemlimit(uuid));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void configurateSkillPlayer(UUID uuid) {
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO skills (UUID, skillpunkte, angriff, verteidigung, extraenergie,scharfschütze,mining,handler,alchemist,bonusloot,gluckspilz) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?)")) {
            ps.setString(1, uuid.toString());
            ps.setInt(2, 0);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 0);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setInt(10, 0);
            ps.setInt(11, 0);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT spieleruuid FROM spielerdaten WHERE spieleruuid = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isKitUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM KitSystem WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isPetUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM PetSystem WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isRewardUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM DailyReward WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean isSkillUserExists(UUID uuid) {
        try {
            PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT UUID FROM skills WHERE UUID = ?");
            ps.setString(1, uuid.toString());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateBelowName(Player p){

    }
}
