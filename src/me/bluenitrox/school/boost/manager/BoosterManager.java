package me.bluenitrox.school.boost.manager;

import me.bluenitrox.school.boost.Boost;

import java.util.ArrayList;

public class BoosterManager{

    private ArrayList<Boost> aktivboost = new ArrayList<Boost>();

    public boolean isAktiv(Boost boost) {
        return aktivboost.contains(boost);

    }

    public ArrayList<Boost> getAktivboost() {
        return aktivboost;
    }

    public void startBoost(Boost boost) {
        if(isAktiv((boost))) return;



        boost.onStart();
    }
}