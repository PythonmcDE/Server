package me.bluenitrox.school.managers;

import me.bluenitrox.school.mysql.MySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class MessageManager {

    public static final String PREFIX = "§c§lDemonMC §8» ";
    public static final String ERROR = PREFIX + "§7Es ist ein §cFehler §7aufgetreten! Bitte Versuche es erneut";
    public static final String NOPLAYER = PREFIX + "§7Dazu musst du ein §cSpieler §7sein";
    public static final String KONTOSTANDOFOTHER = PREFIX + "§7Der Kontostand des Spielers §e";
    public static final String UPDATE_KONTOSTAND_OTHER = PREFIX + "§7Der Kontostand wurde §aaktualisiert§7.";
    public static final String SETOWNHEALTH = PREFIX + "§7Du hast dich §ageheilt§7.";
    public static final String PLAYERHEAL = PREFIX + "§7Du hast den Spieler §ageheilt§7.";
    public static final String SETOWNGAMEMODE = PREFIX + "§7Du hast dich in den §5Gamemode §7gesetzt!";
    public static final String SETOWNFEED = PREFIX + "§7Du hast deinen Hunger §agestillt§7.";
    public static final String SETOWNFLYTRUE = PREFIX + "§7Du bist nun im §aFlugmodus§7 und kannst §afliegen§7.";
    public static final String SETOWNFLYFALSE = PREFIX + "§7Du bist nun nichtmehr im §cFlugmodus§7 und kannst nichtmehr §cfliegen§7.";
    public static final String SETFLYOTHERTRUE = PREFIX + "§7Du hast den Spieler in den §aFlugmodus §7gesetzt.";
    public static final String SETFLYOTHERFALSE = PREFIX + "§7Du hast den Spieler aus dem §cFlugmodus §7gesetzt.";
    public static final String PLAYERSETGAMEMODE = PREFIX + "§7Du hast den Spieler in den §5Gamemode §7gesetzt!";
    public static final String PLAYERFEED = PREFIX + "§7Der Hunger des Spielers wurde gestillt.";
    public static final String SUCCESS_MINE_CHANGE = PREFIX + "§7Die Mine von dem Spieler wurde §cerfolgreich §7geupdatet";
    public static final String SUCCESS_MINE_CHANGE_OTHER = PREFIX + "§7Deine Mine wurde geupdatet";
    public static final String ERROR_MINE_CHANGE = PREFIX + "§7Die Mine von dem Spieler konnte §cnicht §7geupdatet werden";
    public static final String QUIT_BUILD = PREFIX + "§7Du bist nun §cnicht mehr §7im §6Buildmodus";
    public static final String JOIN_BUILD = PREFIX + "§7Du bist §anun §7im §6Buildmodus";
    public static final String MINE_HELP_DESCRIPTION = PREFIX + "§7Anleitung zum §aeinrichten §7einer neuen Mine: \n 1. " +
            "Die Beiden Eckpunkte der neuen Mine setzten mit folgendem Namen: eckpoint + (1 oder 2) + mine + (Nummer der neuen Mine). " +
            "Die Klammern musst du mit deinen Werten füllen. Am Ende sollte es ein Name sein, der diesem hier ähnelt §6eckpoint1mine1 §7 \n 2. " +
            "Jetzt benutz du den Command: §6/mine create <Name> <Eckpunkt 1> <Eckpunkt 2> <Blocksforreset>. §7Im Namen gibst du der neuen Mine " +
            "ihren Name. Dieser sollte folgendermaßen aussehen: §6mine<Nummer>§7. Also z.B. mine1 die Nummer sollte selbst erklärend sein. Bei " +
            "Eckpunkt 1 und 2 trägst du deine eben erstellten Eckpunkte §6in Richtiger Reihenfolge§7 ein. Also der Eckpunkt 1 im Command ist dein " +
            "Erstellter Eckpunkt der mit dem Name §6eckpoint1.. §7anfangen sollte. Zum Schluss gibst du noch eine Anzahl ein, nach wie vielen abgebauten " +
            "Blöcke dich die Mine auffüllen soll. \n 3. Command absenden!";
    public static final String BOOSTERARGS = PREFIX + "§7Bitte benutze: §b/booster add/remove <Spieler> <Boostername> <Anzahl>";

    public static String PLAYERWASSETGAMEMODE(int i){
        if(i == 0){
            return PREFIX + "§7Du wurdest von einem §4Admin §7in den §5Gamemode §7gesetzt!";
        }else {
            return PREFIX + "§7You were set in the §5Gamemode §7by an §4Admin§7.";
        }
    }

    public static String WASSETFLYFALSE(int i){
        if(i == 0){
            return PREFIX + "§7Ein §4Admin §7hat dich aus dem §cFlugmodus §7gesetzt.";
        }else {
            return PREFIX + "§7An admin put you out of §cairplane mode§7.";
        }
    }

    public static String WASSETFLYTRUE(int i){
        if(i == 0){
            return PREFIX + "§7Ein §4Admin §7hat dich in dem §aFlugmodus §7gesetzt.";
        }else {
            return PREFIX + "§7An admin put you in the §aairplane mode§7.";
        }
    }

    public static String FALSECOMMAND(int i){
        if(i == 0){
            return PREFIX + "§7Dieser Command exestiert §cnicht §7oder ist §cfalsch§7!";
        }else{
            return PREFIX + "§7This command does not §cexist§7 or is §cfalse§7!";
        }
    }

    public static String NOPERMISSIONS(int i){
        if(i == 0){
            return PREFIX + "§7Dazu hast du leider §ckeine §7Rechte!";
        }else{
            return PREFIX + "§7Unfortunately you have §cno rights §7to do this.";
        }
    }

    public static String KONTOSTAND(int i){
        if(i == 0){
            return PREFIX + "§7Dein Kontostand beträgt: §6§l";
        }else{
            return PREFIX + "§7Your balance: §6§l";
        }
    }

    public static String UPDATE_KONTOSTAND(int i){
        if(i == 0){
            return PREFIX + "§7Dein Kontostand wurde §aaktualisiert§7.";
        }else {
            return PREFIX + "§7Your balance was §aupdated§7.";
        }
    }

    public static String PLAYERISOFFLINE(int i){
        if(i == 0){
            return PREFIX + "§7Dieser Spieler ist derzeit §cnicht §7online!";
        }else {
            return PREFIX + "§7This player is §cnot §7online.";
        }
    }

    public static String PLAYERWASHEAL(int i){
        if(i == 0){
            return PREFIX + "§7Du wurdest von einem §4Admin §ageheilt.";
        }else{
            return PREFIX + "§7You were §ahealed §7by an §4Admin§7.";
        }
    }

    public static String PLAYERWASFEEDED(int i){
        if(i == 0){
            return PREFIX + "§7Du wurdest von einem §4Admin §agefüttert.";
        }else{
            return PREFIX + "§7You were §afeeded §7by an &4Admin§7.";
        }
    }

    public static String CANTCRAFTTHIS(int i){
        if(i == 0){
            return PREFIX + "§7Dieses Item kannst du §cnicht §7herstellen.";
        }else {
            return PREFIX + "§7You §ccan't §7craft this Item.";
        }
    }

    public static String SCHOOLXP(int i){
        if(i == 0){
            return PREFIX + "§7Folgender School XP Wert wurde dir gutgeschrieben: §6";
        }else {
            return PREFIX + "§7You have been credited with the following School XP value: §6";
        }
    }

    public static String CURRENTLEVEL(int i){
        if(i == 0){
            return PREFIX + "§7Dein Level: §6§l";
        }else {
            return PREFIX + "§7Your Level: §6§l";
        }
    }

    public static String TOTALEXP(int i){
        if(i == 0){
            return PREFIX + "§7Dein Insgesamten EXP: §6";
        }else {
            return PREFIX + "§7Your total EXP: §6";
        }
    }

    public static String NEEDEDEXP(int i){
        if(i == 0){
            return PREFIX + "§7Benötigte EXP bis zum Levelaufstieg: §6";
        }else {
            return PREFIX + "§7Needed EXP for Levelup: §6";
        }
    }


    public static boolean ah = true;
    public static int MONEY_BOOSTER_BOOST = 2;
    public static int MAX_MINE = getMaxMine();

    private static int getMaxMine() {
        int mine = 0;

        try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT id FROM minen ORDER BY id DESC LIMIT 1")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mine = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mine;
    }

    public static int MINE_1_PREIS = 1200000;
    public static int MINE_2_PREIS = 1200000;
    public static int MINE_3_PREIS = 1200000;
    public static int MINE_4_PREIS = 1200000;
    public static int MINE_5_PREIS = 1200000;
    public static int MINE_6_PREIS = 1200000;
    public static int MINE_7_PREIS = 1200000;
    public static int MINE_8_PREIS = 1200000;
    public static int MINE_9_PREIS = 1200000;
    public static int MINE_10_PREIS = 1200000;
    public static int MINE_11_PREIS = 1200000;
    public static int MINE_12_PREIS = 1200000;
    public static int MINE_13_PREIS = 1200000;
    public static int MINE_14_PREIS = 1200000;
    public static int MINE_15_PREIS = 1200000;

    public static final HashMap<String, Integer> blocksforreset = fillMap();


    private static HashMap<String, Integer> fillMap() {
        HashMap<String, Integer> blocksforreset = new HashMap<>();
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM minen")) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                String name = rs.getString("name");
                Integer blocks = rs.getInt("blocksforreset");
                blocksforreset.put(name, blocks);
            }
            return blocksforreset;
        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}

