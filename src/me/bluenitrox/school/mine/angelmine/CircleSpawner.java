package me.bluenitrox.school.mine.angelmine;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.LocationManager;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class CircleSpawner {

    /*
    DOCUMENTATION:

    If you want to set a new circle spawn point you have to run the following command in Minecraft:
    /set spawn[1-15]mine[1-10]
    for ex.
    /set spawn1mine1

    every fishingmine need to have 15 spots!!
     */

    public void setCircle() {
        PartikelManager pm = new PartikelManager();

        for (int a = 1; a <= 10; a++) {
            if (AngelminenManager.angelminen.get(a + "") != null) {
                if(AngelminenManager.angelminen.get(a+"") <= 15) {
                    for (int times = 0; times < AngelminenManager.angelminen.get(a + ""); times++) {
                        Random r2 = new Random();
                        int b = r2.nextInt(15) + 1;
                        if (new LocationManager("spawn" + b + "mine" + a).getLocation() != null) {
                            PartikelManager.locations.add(new LocationManager("spawn" + b + "mine" + a).getLocation());
                            int finalA = a;
                            new BukkitRunnable() {
                                int i = 0;

                                @Override
                                public void run() {
                                    if (PartikelManager.locations != null) {
                                        if (PartikelManager.locations.contains(new LocationManager("spawn" + b + "mine" + finalA).getLocation())) {
                                            if (i <= 40) {
                                                pm.summonCircle(new LocationManager("spawn" + b + "mine" + finalA).getLocation(), 1, finalA);
                                                i++;
                                            } else {
                                                this.cancel();
                                            }
                                        } else {
                                            this.cancel();
                                        }
                                    }
                                }
                            }.runTaskTimer(SchoolMode.getInstance(), 10, 10);
                        }
                    }
                }else {
                    for (int times = 0; times < 15; times++) {
                        Random r2 = new Random();
                        int b = r2.nextInt(15) + 1;
                        if (new LocationManager("spawn" + b + "mine" + a).getLocation() != null) {
                            PartikelManager.locations.add(new LocationManager("spawn" + b + "mine" + a).getLocation());
                            int finalA = a;
                            new BukkitRunnable() {
                                int i = 0;

                                @Override
                                public void run() {
                                    if (PartikelManager.locations != null) {
                                        if (PartikelManager.locations.contains(new LocationManager("spawn" + b + "mine" + finalA).getLocation())) {
                                            if (i <= 40) {
                                                pm.summonCircle(new LocationManager("spawn" + b + "mine" + finalA).getLocation(), 1, finalA);
                                                i++;
                                            } else {
                                                this.cancel();
                                            }
                                        } else {
                                            this.cancel();
                                        }
                                    }
                                }
                            }.runTaskTimer(SchoolMode.getInstance(), 10, 10);
                        }
                    }
                }
            }
        }
    }

}
