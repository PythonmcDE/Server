package me.bluenitrox.school.boost.booster;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.Boost;
import me.bluenitrox.school.boost.BoosterAPI;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Bukkit;

public class Xpbooster extends Boost {

    public Xpbooster() {
        setName("§bXp-Booster");
        setLenth(60);
    }

    int time = BoosterAPI.boost.get("xp");
    @Override
    public void onStart() {
        startTicking(time*20);
    }
    @Override
    public void onEnd() {
        Bukkit.getOnlinePlayers().forEach(players ->{
            players.sendMessage(MessageManager.PREFIX + "§cDer " + getName() + " §cist nun vorbei");
            BoosterAPI.xp1 = false;
        });
        SchoolMode.getInstance().getBoostermanager().getAktivboost().remove(this);
    }
}
