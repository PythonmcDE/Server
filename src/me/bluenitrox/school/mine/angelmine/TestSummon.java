package me.bluenitrox.school.mine.angelmine;

import com.sun.xml.internal.ws.wsdl.writer.document.Part;
import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import me.bluenitrox.school.managers.PermissionsManager;
import me.bluenitrox.school.managers.PlayerJoinManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TestSummon implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        Player p = (Player)cs;
        PartikelManager pm = new PartikelManager();
        Location loc = p.getLocation();
        PartikelManager.locations.add(loc);

        if(!p.hasPermission(PermissionsManager.ALLPERMS)){
            p.sendMessage(MessageManager.NOPERMISSIONS(PlayerJoinManager.language));
            return true;
        }
        int partikel = Integer.parseInt(args[0]);
        new BukkitRunnable() {
            int i = 0;
            @Override
            public void run() {
                if(PartikelManager.locations != null) {
                    if (PartikelManager.locations.contains(loc)) {
                        if (i <= 40) {
                            pm.summonCircle(loc, 1,partikel);
                            i++;
                        } else {
                            this.cancel();
                        }
                    }else {
                        this.cancel();
                    }
                }
            }
        }.runTaskTimer(SchoolMode.getInstance(), 10, 10);
        return false;
    }
}
