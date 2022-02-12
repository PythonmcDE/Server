package me.bluenitrox.school.boost;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Bukkit;

public class Dungeonbooster extends Boost {

    public Dungeonbooster() {
        setName("§bDungeon-Booster");
        setLenth(60);
    }

    @Override
    public void onStart() {
        startTicking();
    }

    @Override
    public void onEnd() {
        Bukkit.getOnlinePlayers().forEach(players ->{
            players.sendMessage(MessageManager.PREFIX + "§cDer" + getName() + " §cist nun vorbei");
            BoosterAPI.dungeon1 = false;
        });
        SchoolMode.getInstance().getBoostermanager().getAktivboost().remove(this);
    }
}
