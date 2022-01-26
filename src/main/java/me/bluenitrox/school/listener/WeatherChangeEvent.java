package me.bluenitrox.school.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class WeatherChangeEvent implements Listener {

    @EventHandler
    public void onWeatherChange(final org.bukkit.event.weather.WeatherChangeEvent e){
        e.setCancelled(true);
    }

}
