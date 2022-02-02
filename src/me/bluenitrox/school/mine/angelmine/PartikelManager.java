package me.bluenitrox.school.mine.angelmine;

import com.github.fierioziy.particlenativeapi.api.ParticleNativeAPI;
import com.github.fierioziy.particlenativeapi.api.Particles_1_8;
import com.github.fierioziy.particlenativeapi.plugin.ParticleNativePlugin;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.LinkedList;

public class PartikelManager {

    public static LinkedList<Location> locations = new LinkedList<>();
    private Location loc1;
    private Location loc2;

    public void summonCircle(Location location, int size, int partikel) {
        ParticleNativeAPI api = ParticleNativePlugin.getAPI();
        Particles_1_8 particles = api.getParticles_1_8();
        if(partikel == 1) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.AQUA);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 2) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.BLUE);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 3) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.YELLOW);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 4) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.ORANGE);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 5) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.GREEN);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 6) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.BLACK);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 7) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.LIME);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 8) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.PURPLE);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 9) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                Object packet = particles.REDSTONE().packetColored(true, particleLoc, Color.RED);
                for (Player all : Bukkit.getOnlinePlayers()) {
                    particles.sendPacket(all, packet);
                }
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }else if(partikel == 10) {
            for (int d = 0; d <= 90; d += 1) {
                Location particleLoc = new Location(location.getWorld(), location.getX(), location.getY(), location.getZ());
                particleLoc.setX(location.getX() + Math.cos(d) * size);
                particleLoc.setZ(location.getZ() + Math.sin(d) * size);

                particleLoc.getWorld().playEffect(particleLoc, Effect.COLOURED_DUST, Integer.MAX_VALUE);
                if (d == 45) {
                    loc1 = particleLoc;
                } else if (d == 90) {
                    loc2 = particleLoc;
                }
            }
        }
    }


}
