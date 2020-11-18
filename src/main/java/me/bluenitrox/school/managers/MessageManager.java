package me.bluenitrox.school.managers;

public class MessageManager {

    public static String PREFIX = "Hier der Prefix...";
    public static String ERROR = PREFIX + "§7Es ist ein §cFehler §7aufgetreten! Bitte Versuche es erneut";
    public static String NOPLAYER = PREFIX + "§7Dazu musst du ein §cSpieler §7sein";
    public static String KONTOSTANDOFOTHER = PREFIX + "§7Der Kontostand des Spielers §e";
    public static String UPDATE_KONTOSTAND_OTHER = PREFIX + "§7Der Kontostand wurde §aaktualisiert§7.";
    public static String SETOWNHEALTH = PREFIX + "§7Du hast dich §ageheilt§7.";
    public static String PLAYERHEAL = PREFIX + "§7Du hast den Spieler §ageheilt§7.";
    public static String SETOWNGAMEMODE = PREFIX + "§7Du hast dich in den §5Gamemode §7gesetzt!";
    public static String SETOWNFEED = PREFIX + "§7Du hast deinen Hunger §agestillt§7.";
    public static String SETOWNFLYTRUE = PREFIX + "§7Du bist nun im §aFlugmodus§7 und kannst §afliegen§7.";
    public static String SETOWNFLYFALSE = PREFIX + "§7Du bist nun nichtmehr im §cFlugmodus§7 und kannst nichtmehr §cfliegen§7.";
    public static String SETFLYOTHERTRUE = PREFIX + "§7Du hast den Spieler in den §aFlugmodus §7gesetzt.";
    public static String SETFLYOTHERFALSE = PREFIX + "§7Du hast den Spieler aus dem §cFlugmodus §7gesetzt.";
    public static String PLAYERSETGAMEMODE = PREFIX + "§7Du hast den Spieler in den §5Gamemode §7gesetzt!";
    public static String PLAYERFEED = PREFIX + "§7Der Hunger des Spielers wurde gestillt.";

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

    public static int MONEY_BOOSTER_BOOST = 2;

}
