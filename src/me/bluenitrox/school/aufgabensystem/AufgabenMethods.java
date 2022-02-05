package me.bluenitrox.school.aufgabensystem;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class AufgabenMethods {

    public static void onTaskCommand(PlayerCommandPreprocessEvent event) {
        String msg = event.getMessage();

        if(msg.equalsIgnoreCase("/school") && AufgabenManager.getTask(event.getPlayer().getUniqueId()) == 1) {
            AufgabenManager.onComplete(event.getPlayer().getUniqueId(), 1);
        }
    }

}
