package me.bluenitrox.school.boost.booster;

import me.bluenitrox.school.SchoolMode;
import me.bluenitrox.school.boost.Boost;
import me.bluenitrox.school.boost.BoosterAPI;
import me.bluenitrox.school.managers.MessageManager;
import org.bukkit.Bukkit;

public class Dungeonbooster extends Boost {

    public Dungeonbooster() {
        setName("§bDungeon-Booster");
        setLenth(60);
    }

    int time = BoosterAPI.boost.get("dungeon");
    @Override
    public void onStart() {
        startTicking(time*20);
    }

    @Override
    public void onEnd() {
        Bukkit.getOnlinePlayers().forEach(players ->{
            players.sendMessage(MessageManager.PREFIX + "§cDer " + getName() + " §cist nun vorbei");
            BoosterAPI.dungeon1 = false;
        });
        SchoolMode.getInstance().getBoostermanager().getAktivboost().remove(this);
    }
}
