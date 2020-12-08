package me.bluenitrox.school.mine.reward;

import org.bukkit.entity.Player;

import java.util.Random;

public class RewardAPI {

    public void checkToAddReward(Player p){
        int tausend = new Random().nextInt(1000);

        if(tausend == 1){
            addReward(p, Reward.STANDARD);
        }
    }

    public void addReward(Player p, Reward reward){

    }

}
