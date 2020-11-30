package me.bluenitrox.school.managers;

import me.bluenitrox.school.mysql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class LocationManager {

    private String name;

    public LocationManager(String name) {
        this.name = name;
    }

    public static HashMap<String, Location> locations = new HashMap<>();

    public boolean isLocationExists(){
        try(PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM locations WHERE name = ?")){
            ps.setString(1, this.name);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public void setLocation(Player p) {
        Location loc = p.getLocation();
        String weltname = loc.getWorld().getName();
        double  x = loc.getX(),
                y = loc.getY(),
                z = loc.getZ();
        float   yaw = loc.getYaw(),
                pitch = loc.getPitch();

        if(isLocationExists()) {
            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("UPDATE locations SET world = ?, x = ?, y = ?, z = ?, yaw = ?, pitch = ? WHERE name = ?")) {
                ps.setString(1, weltname);
                ps.setDouble(2, x);
                ps.setDouble(3, y);
                ps.setDouble(4, z);
                ps.setFloat(5, yaw);
                ps.setFloat(6, pitch);
                ps.setString(7, this.name);
                ps.executeUpdate();
                p.sendMessage(MessageManager.PREFIX + "§7Die Location wurde §aerfolgriech §7upgedatet");
            } catch (SQLException e) {
                e.printStackTrace();
                p.sendMessage(MessageManager.PREFIX + "§7Die Location konnte §cnicht §7geupdatet werden");
            }
        }else {
            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("INSERT INTO locations (name, world, x, y, z, yaw, pitch) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
                ps.setString(1, this.name);
                ps.setString(2, weltname);
                ps.setDouble(3, x);
                ps.setDouble(4, y);
                ps.setDouble(5, z);
                ps.setFloat(6, yaw);
                ps.setFloat(7, pitch);
                ps.executeUpdate();
                p.sendMessage(MessageManager.PREFIX + "§7Die Location wurde §aerfolgriech §7gesetzt");
            } catch (SQLException e) {
                e.printStackTrace();
                p.sendMessage(MessageManager.PREFIX + "§7Die Location konnte §cnicht §7gesetzt werden");
            }
        }
    }

    public void setLocsHashmap(String name){
        locations.put(name,getLocationDatabase());
    }

    public Location getLocation(){
        if(locations.containsKey(name)) {
            return locations.get(name);
        }else {
            locations.put(name, getLocationDatabase());
            return locations.get(name);
        }
    }

    public Location getLocationDatabase(){
        if(isLocationExists()){
            try (PreparedStatement ps = MySQL.getConnection().prepareStatement("SELECT * FROM locations WHERE name = ?")) {
                ps.setString(1, this.name);
                ResultSet rs = ps.executeQuery();
                while (rs.next()){
                    String weltname = rs.getString("world");
                    double x = rs.getDouble("x");
                    double y = rs.getDouble("y");
                    double z = rs.getDouble("z");
                    float yaw = rs.getFloat("yaw");
                    float pitch = rs.getFloat("pitch");

                    return new Location(Bukkit.getWorld(weltname), x, y, z, yaw, pitch);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

