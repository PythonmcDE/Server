package me.bluenitrox.school.managers;

import de.pythonmc.clansystem.api.ClanAPI;
import de.pythonmc.clansystem.listener.PlayerJoinListener;
import de.pythonmc.clansystem.mysql.NickManager;
import de.pythonmc.clansystem.systemmanager.SystemManager;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.Skill;
import me.bluenitrox.school.features.SkillAPI;
import me.bluenitrox.school.features.StatsAPI;
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
        if(!isPetUserExists(uuid)) {
            configuratePlayer(uuid);
            configurateKitPlayer(uuid);
            configuratePetPlayer(uuid);
            configurateSkillPlayer(uuid);
        }
        float money = MoneyManager.getMoneyDatabase(uuid);
        float exp = ExpManager.getExpDatabase(uuid);
        int mine = MinenManager.getMineDatabase(uuid);
        int blocks = PlayerBreakBlockManager.getBlocksDatabase(uuid);
        int mobs = StatsAPI.getMobDatabase(uuid);
        SchoolMode.setPlayerMoney(uuid, money);
        SchoolMode.playerlevel.put(uuid,ExpManager.getLevelDatabase(uuid));
        SchoolMode.setPlayerExp(uuid, exp);
        SchoolMode.setPlayerMine(uuid, mine);
        SchoolMode.setPlayerBlocks(uuid, blocks);
        SchoolMode.setPlayerCase(uuid,api.getCasesDatabase(uuid));
        SchoolMode.setPlayerChest(uuid, api.getChestsDatabase(uuid));
        SchoolMode.setPlayerMob(uuid,mobs);
        SchoolMode.setPrestige(uuid, ExpManager.getPrestigeDatabase(uuid));
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
        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO spielerdaten (spieleruuid, money, dungeon, exp, mine, prestige, kills, deaths, cases, bloecke, mob, chests, level) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
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
        Scoreboard board = getBoard();
        Team admin = board.registerNewTeam("aaa");
        Team dev = board.registerNewTeam("bbb");
        Team mod = board.registerNewTeam("ccc");
        Team sup = board.registerNewTeam("ddd");
        Team yt = board.registerNewTeam("eee");
        Team premium = board.registerNewTeam("fff");
        Team spieler = board.registerNewTeam("ggg");
        Iterator var11 = Bukkit.getOnlinePlayers().iterator();


        while(var11.hasNext()) {
            Player onlineplayers = (Player)var11.next();
            if(NickManager.isNicked(onlineplayers.getUniqueId())) {
                PlayerJoinListener.loadTeam(p, board, spieler, "ggg", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("spieler")));
            } else {
                if (onlineplayers.hasPermission("prefix.admin")) {
                    loadTeam(onlineplayers, board, admin, "aaa", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("admin")));
                } else if (onlineplayers.hasPermission("prefix.dev")) {
                    loadTeam(onlineplayers, board, dev, "bbb", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("dev")));
                } else if (onlineplayers.hasPermission("prefix.mod")) {
                    loadTeam(onlineplayers, board, mod, "ccc", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("mod")));
                } else if (onlineplayers.hasPermission("prefix.sup")) {
                    loadTeam(onlineplayers, board, sup, "ddd", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("sup")));
                } else if (onlineplayers.hasPermission("prefix.yt")) {
                    loadTeam(onlineplayers, board, yt, "eee", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("yt")));
                } else if (onlineplayers.hasPermission("prefix.premium")) {
                    loadTeam(onlineplayers, board, premium, "fff", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("premium")));
                } else if (onlineplayers.hasPermission("prefix.spieler")) {
                    loadTeam(onlineplayers, board, spieler, "ggg", ChatColor.translateAlternateColorCodes('&', SystemManager.getPlayerTag("spieler")));
                }
            }
        }
        Objective objective = board.registerNewObjective("showkill", "player_kills");
        objective.setDisplaySlot(DisplaySlot.BELOW_NAME);
        objective.setDisplayName(" §6§lLevel");
        for(Player online : Bukkit.getOnlinePlayers()){
            online.setScoreboard(board);
            final Score score = objective.getScore(online);
            score.setScore(ExpManager.getLevel(online.getUniqueId()));
        }
    }

    public static void loadTeam(Player player, Scoreboard board, Team team, String teamname, String prefix) {
        team = board.getTeam(teamname);
        if (team == null) {
            team = board.registerNewTeam(teamname);
        }

        if (team.hasEntry(player.getName())) {
        }

        team.removeEntry(player.getName());
        team.setPrefix(prefix);
        if (ClanAPI.isPlayerInClan(player.getUniqueId())) {
            String clanTag = ClanAPI.getClanTag(player.getUniqueId());
            player.setCustomName(team.getPrefix() + player.getName());
            player.setPlayerListName(team.getPrefix() + player.getName() + " §7[§e" + clanTag + "§7]");
            team.addPlayer(player);
        } else {
            player.setCustomName(team.getPrefix() + player.getPlayerListName());
            player.setPlayerListName(team.getPrefix() + player.getName());
            team.addPlayer(player);
        }
        player.setScoreboard(board);
    }
}
