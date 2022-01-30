package me.bluenitrox.school.mine.angelmine;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;

import java.util.LinkedList;

public class PartikelManager {

    public static LinkedList<Location> locations = new LinkedList<>();
    private Location loc1;
    private Location loc2;

    public void summonCircle(Location location, int size) {
        for (int d = 0; d <= 90; d += 1) {
            Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
            particleLoc.setX(location.getX() + Math.cos(d) * size);
            particleLoc.setZ(location.getZ() + Math.sin(d) * size);
            Bukkit.getWorld(location.getWorld().getName()).playEffect(particleLoc, Effect.COLOURED_DUST, Integer.MAX_VALUE);
            if(d == 45){
                loc1 = particleLoc;
            }else if(d == 90){
                loc2 = particleLoc;
            }
        }
    }


}
