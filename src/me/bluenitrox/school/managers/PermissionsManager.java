package me.bluenitrox.school.managers;

public class PermissionsManager {

    /**
     * Only Admins permissions
     */
    public static final String ALLPERMS = "System.*";
    public static final String GAMEMODE = "System.Gamemode";
    public static final String GAMEMODE_OTHER = "System.Gamemode.other";
    public static final String HEAL = "System.Heal";
    public static final String HEAL_OTHER = "System.Heal.other";
    public static final String FEED = "System.Feed";
    public static final String FEED_OTHER = "System.Feed.other";
    public static final String FLY = "System.Fly";
    public static final String FLY_OTHER = "System.Fly.other";
    public static final String SETLOCATION = "System.location.set";
    public static final String CHANGEMONEY = "System.Money.Change";
    public static final String GETMONEYOTHER = "System.money.other";
    public static final String UPDATE_MINE = "System.Mine.Update";
    public static final String SET_MINE = "System.Mine.Set";
    public static final String MINE_HELP = "System.Mine.Help";
    public static final String BUILD = "System.Build";
    public static final String AHOFF = "System.ah.offline";
    public static final String ADDBOOSTER = "System.booster.add";
    public static final String COMMANDBLOCK = "System.send.all";
    public static final String INVSEE = "System.invsee";
    public static final String CLEAR = "System.clear";
    public static final String VANISH = "System.vanish";
    public static final String TP = "System.tp";
    public static final String NPCS = "System.npc.use";
    
    /**
     * Use vip, python, king/queen for User permissions
     * Use team for all team members
     * Use  mods for all Sups and Mods
     */

    public static final String vip = "pythonmc.vip";
    public static final String python = "pythonmc.python";
    public static final String kingqueen = "pythonmc.king/queen";

    public static final String team = "pythonmc.team";
    public static final String mod = "pythonmc.mod";

}
