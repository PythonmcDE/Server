package me.bluenitrox.school.boost.booster;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.Boost;
import me.bluenitrox.school.boost.BoosterAPI;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Bukkit;

public class Angelbooster extends Boost {

    public Angelbooster() {
        setName("§bAngel-Booster");
        setLenth(60);
    }

    int time = BoosterAPI.boost.get("angel");
    @Override
    public void onStart() {
        startTicking(time*20);
    }

    @Override
    public void onEnd() {
        Bukkit.getOnlinePlayers().forEach(players ->{
            players.sendMessage(MessageManager.PREFIX + "§cDer " + getName() + " §cist nun vorbei");
            BoosterAPI.angel1 = false;
        });
        SchoolMode.getInstance().getBoostermanager().getAktivboost().remove(this);
    }
}
