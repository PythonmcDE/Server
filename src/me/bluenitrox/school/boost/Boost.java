package me.bluenitrox.school.boost;

import me.bluenitrox.school.SchoolMode;
import org.bukkit.Bukkit;

public class Boost{

    private String name;
    private int lenth;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getLenth() {
        return lenth;
    }
    public void setLenth(int lenth) {
        this.lenth = lenth;
    }

    public void onStart() { }

    public void onEnd() { }

    public void startTicking(int time) {
        SchoolMode.getInstance().getBoostermanager().getAktivboost().add(this);
        Bukkit.getScheduler().runTaskLaterAsynchronously(SchoolMode.getInstance(), this::onEnd, time);
    }

}
