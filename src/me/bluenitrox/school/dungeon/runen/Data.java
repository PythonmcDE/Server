package me.bluenitrox.school.dungeon.runen;

import java.util.LinkedList;
import java.util.UUID;

public class Data {


    private LinkedList<UUID> runejagd = new LinkedList<>();
    private LinkedList<UUID> runebeschleunigung = new LinkedList<>();
    private LinkedList<UUID> runeweisheit = new LinkedList<>();

    public void setRuneJagd(UUID uuid) {
        runejagd.add(uuid);
    }

    public boolean isInRuneJagd(UUID uuid) {
        return runejagd.contains(uuid);
    }

    public void removeRuneJagd(UUID uuid) {
        runejagd.remove(uuid);
    }



}
