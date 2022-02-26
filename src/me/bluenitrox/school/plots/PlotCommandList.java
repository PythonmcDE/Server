package me.bluenitrox.school.plots;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlotCommandList {

    public static boolean replaceCommand(PlayerCommandPreprocessEvent e){
        if(e.getMessage().equalsIgnoreCase("/plot home")){
            return true;
        }else if(e.getMessage().equalsIgnoreCase("/plot info")){
            return true;
        }else if(e.getMessage().equalsIgnoreCase("/plot add")){
            return true;
        }else if(e.getMessage().equalsIgnoreCase("/plot remove")){
            return true;
        }else if(e.getMessage().equalsIgnoreCase("/plot")){
            return true;
        }
        return false;
    }

}
