package me.bluenitrox.school.boost;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Bukkit;

public class Xpbooster extends Boost{

    public Xpbooster() {
        setName("§bXp-Booster");
        setLenth(45);
    }

    @Override
    public void onStart() {
        startTicking();
    }
    @Override
    public void onEnd() {
        Bukkit.getOnlinePlayers().forEach(players ->{
            players.sendMessage(MessageManager.PREFIX + "§cDer" + getName() + " §cist nun vorbei");
            BoosterAPI.xp1 = false;
        });
        SchoolMode.getInstance().getBoostermanager().getAktivboost().remove(this);
    }
}
