package me.bluenitrox.school.boost;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Bukkit;

public class Gembooster extends Boost {

    public Gembooster() {
        setName("§bGem-Booster");
        setLenth(60);
    }

    int time = BoosterAPI.boost.get("gem");
    @Override
    public void onStart() {
        startTicking(time*20);
    }

    @Override
    public void onEnd() {
        Bukkit.getOnlinePlayers().forEach(players ->{
            players.sendMessage(MessageManager.PREFIX + "§cDer" + getName() + " §cist nun vorbei");
            BoosterAPI.money1 = false;
        });
        SchoolMode.getInstance().getBoostermanager().getAktivboost().remove(this);
    }
}
