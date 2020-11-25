package me.bluenitrox.school.managers;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.commands.Exp;
import org.apache.logging.log4j.core.pattern.LevelPatternConverter;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IScoreboardCriteria;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardDisplayObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardObjective;
import net.minecraft.server.v1_8_R3.PacketPlayOutScoreboardScore;
import net.minecraft.server.v1_8_R3.Scoreboard;
import net.minecraft.server.v1_8_R3.ScoreboardObjective;
import net.minecraft.server.v1_8_R3.ScoreboardScore;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;

import java.util.UUID;

public class ScoreboardManager {

    public static void setBoard(Player p) {
        //p.setDisplayName("§8[§6" + exp.getLevel(p.getUniqueId()) + "§8]§r " + p.getName());
        Scoreboard scoreboard = new Scoreboard();
        ScoreboardObjective obj = scoreboard.registerObjective("TEST", IScoreboardCriteria.b);
        obj.setDisplayName("§8« §c§lSCHOOL §8»");
        PacketPlayOutScoreboardObjective createPacket = new PacketPlayOutScoreboardObjective(obj, 0);
        PacketPlayOutScoreboardDisplayObjective display = new PacketPlayOutScoreboardDisplayObjective(1, obj);

        ScoreboardScore a1 = new ScoreboardScore(scoreboard, obj, " ");
        ScoreboardScore a2 = new ScoreboardScore(scoreboard, obj, "§8● §7Level");
        ScoreboardScore a11 = new ScoreboardScore(scoreboard, obj, "   §6" + ExpManager.getLevel(p.getUniqueId()));
        ScoreboardScore a4 = new ScoreboardScore(scoreboard, obj, "           ");
        ScoreboardScore a5 = new ScoreboardScore(scoreboard, obj, "§8● §7Nächstes Level");
        ScoreboardScore a12 = new ScoreboardScore(scoreboard, obj, umrechnungToString(p.getUniqueId()));
        ScoreboardScore a6 = new ScoreboardScore(scoreboard, obj, "  ");
        ScoreboardScore a30 = new ScoreboardScore(scoreboard, obj, "§8● §7Money");
        ScoreboardScore a40 = new ScoreboardScore(scoreboard, obj, "   §6" + SchoolMode.getPlayerMoney(p.getUniqueId()));
        ScoreboardScore a41 = new ScoreboardScore(scoreboard, obj, "    ");
        ScoreboardScore a7 = new ScoreboardScore(scoreboard, obj, "§8§m-------------");
        ScoreboardScore a8 = new ScoreboardScore(scoreboard, obj, "§8» §7IP: §c§lDemonMC.eu");
        //ScoreboardScore a3 = new ScoreboardScore(scoreboard, obj, "§9      ");
        a1.setScore(12);
        a2.setScore(11);
        a11.setScore(10);
        a4.setScore(9);
        a5.setScore(8);
        a12.setScore(7);
        a6.setScore(6);
        a30.setScore(5);
        a40.setScore(4);
        a41.setScore(3);
        a7.setScore(2);
        a8.setScore(1);
        //a3.setScore(0);
        PacketPlayOutScoreboardObjective removePacket = new PacketPlayOutScoreboardObjective(obj, 1);
        PacketPlayOutScoreboardScore pa1 = new PacketPlayOutScoreboardScore(a1);
        PacketPlayOutScoreboardScore pa2 = new PacketPlayOutScoreboardScore(a2);
        //PacketPlayOutScoreboardScore pa3 = new PacketPlayOutScoreboardScore(a3);
        PacketPlayOutScoreboardScore pa4 = new PacketPlayOutScoreboardScore(a4);
        PacketPlayOutScoreboardScore pa5 = new PacketPlayOutScoreboardScore(a5);
        PacketPlayOutScoreboardScore pa6 = new PacketPlayOutScoreboardScore(a6);
        PacketPlayOutScoreboardScore pa7 = new PacketPlayOutScoreboardScore(a7);
        PacketPlayOutScoreboardScore pa8 = new PacketPlayOutScoreboardScore(a8);
        PacketPlayOutScoreboardScore pa11 = new PacketPlayOutScoreboardScore(a11);
        PacketPlayOutScoreboardScore pa12 = new PacketPlayOutScoreboardScore(a12);
        PacketPlayOutScoreboardScore pa15 = new PacketPlayOutScoreboardScore(a30);
        PacketPlayOutScoreboardScore pa16 = new PacketPlayOutScoreboardScore(a40);
        PacketPlayOutScoreboardScore pa17 = new PacketPlayOutScoreboardScore(a41);
        sendPacket(removePacket, p);
        sendPacket(createPacket, p);
        sendPacket(display, p);
        sendPacket(pa1, p);
        sendPacket(pa2, p);
        //sendPacket(pa3,p);
        sendPacket(pa4, p);
        sendPacket(pa5, p);
        sendPacket(pa6, p);
        sendPacket(pa7, p);
        sendPacket(pa8, p);
        sendPacket(pa11, p);
        sendPacket(pa12, p);
        sendPacket(pa15, p);
        sendPacket(pa16, p);
        sendPacket(pa17, p);

    }

    private static String umrechnungToString(UUID uuid){
        float playerexpbefor = LevelManager.level.get(ExpManager.getLevel(uuid)-1);
        float sechstel = (LevelManager.level.get(ExpManager.getLevel(uuid)) - playerexpbefor) / 7;
        float current = ExpManager.getExp(uuid);
        float differenz = current - playerexpbefor;

        if(differenz >= sechstel*6){
            return "   §a▊▊▊▊▊▊";
        }else if(differenz >= sechstel*5){
            return "   §a▊▊▊▊▊§7▊";
        }else if(differenz >= sechstel*4){
            return "   §a▊▊▊▊§7▊▊";
        }else if(differenz >= sechstel*3){
            return "   §a▊▊▊§7▊▊▊";
        }else if(differenz >= sechstel*2){
            return "   §a▊▊§7▊▊▊▊";
        }else if(differenz >= sechstel*1){
            return "   §a▊§7▊▊▊▊▊";
        }else {
            return "   §7▊▊▊▊▊▊";
        }
    }

    private static void sendPacket(Packet packet, Player p) {
        ((CraftPlayer)p).getHandle().playerConnection.sendPacket(packet);
    }

}
