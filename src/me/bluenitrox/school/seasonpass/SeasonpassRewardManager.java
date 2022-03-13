package me.bluenitrox.school.seasonpass;

import java.util.HashMap;

public class SeasonpassRewardManager {

    private HashMap<Integer, String> normalRewards = new HashMap<>();
    private HashMap<Integer, String> goldRewards = new HashMap<>();


    /**
     * @param reward the Seasonpasslevel for the xp requested XP
     * @return the normal Reward for the requestes task
     */
    public String getNormalSeason1Reward(int reward) {
        return normalRewards.get(reward);
    }

    /**
     * @param reward the Seasonpasslevel for the xp requested XP
     * @return the gold Reward for the requestes task
     */
    public String getGoldSeason1Reward(int reward) {
        return goldRewards.get(reward);
    }

    /**
     * @param reward the Seasonpasslevel for the xp requested XP
     * @return the needed Xp for the task
     */
    public int getNeededXp(int reward) {
        return defaultXP * reward;
    }

    private final int defaultXP = 50;

    public void registerSeasonpassRewards() {
        normalRewards.put(1, season1normal1);
        normalRewards.put(2, season1normal2);
        normalRewards.put(3, season1normal3);
        normalRewards.put(4, season1normal4);
        normalRewards.put(5, season1normal5);
        normalRewards.put(6, season1normal6);
        normalRewards.put(7, season1normal7);
        normalRewards.put(8, season1normal8);
        normalRewards.put(9, season1normal9);
        normalRewards.put(10, season1normal10);

        normalRewards.put(11, season1normal11);
        normalRewards.put(12, season1normal12);
        normalRewards.put(13, season1normal13);
        normalRewards.put(14, season1normal14);
        normalRewards.put(15, season1normal15);
        normalRewards.put(16, season1normal16);
        normalRewards.put(17, season1normal17);
        normalRewards.put(18, season1normal18);
        normalRewards.put(19, season1normal19);
        normalRewards.put(20, season1normal20);

        normalRewards.put(21, season1normal21);
        normalRewards.put(22, season1normal22);
        normalRewards.put(23, season1normal23);
        normalRewards.put(24, season1normal24);
        normalRewards.put(25, season1normal25);
        normalRewards.put(26, season1normal26);
        normalRewards.put(27, season1normal27);
        normalRewards.put(28, season1normal28);
        normalRewards.put(29, season1normal29);
        normalRewards.put(30, season1normal30);

        normalRewards.put(31, season1normal31);
        normalRewards.put(32, season1normal32);
        normalRewards.put(33, season1normal33);
        normalRewards.put(34, season1normal34);
        normalRewards.put(35, season1normal35);
        normalRewards.put(36, season1normal36);
        normalRewards.put(37, season1normal37);
        normalRewards.put(38, season1normal38);
        normalRewards.put(39, season1normal39);
        normalRewards.put(40, season1normal40);

        normalRewards.put(41, season1normal41);
        normalRewards.put(42, season1normal42);
        normalRewards.put(43, season1normal43);
        normalRewards.put(44, season1normal44);
        normalRewards.put(45, season1normal45);

        goldRewards.put(1, season1gold1);
        goldRewards.put(2, season1gold2);
        goldRewards.put(3, season1gold3);
        goldRewards.put(4, season1gold4);
        goldRewards.put(5, season1gold5);
        goldRewards.put(6, season1gold6);
        goldRewards.put(7, season1gold7);
        goldRewards.put(8, season1gold8);
        goldRewards.put(9, season1gold9);
        goldRewards.put(10, season1gold10);

        goldRewards.put(11, season1gold11);
        goldRewards.put(12, season1gold12);
        goldRewards.put(13, season1gold13);
        goldRewards.put(14, season1gold14);
        goldRewards.put(15, season1gold15);
        goldRewards.put(16, season1gold16);
        goldRewards.put(17, season1gold17);
        goldRewards.put(18, season1gold18);
        goldRewards.put(19, season1gold19);
        goldRewards.put(20, season1gold20);

        goldRewards.put(21, season1gold21);
        goldRewards.put(22, season1gold22);
        goldRewards.put(23, season1gold23);
        goldRewards.put(24, season1gold24);
        goldRewards.put(25, season1gold25);
        goldRewards.put(26, season1gold26);
        goldRewards.put(27, season1gold27);
        goldRewards.put(28, season1gold28);
        goldRewards.put(29, season1gold29);
        goldRewards.put(30, season1gold30);

        goldRewards.put(31, season1gold31);
        goldRewards.put(32, season1gold32);
        goldRewards.put(33, season1gold33);
        goldRewards.put(34, season1gold34);
        goldRewards.put(35, season1gold35);
        goldRewards.put(36, season1gold36);
        goldRewards.put(37, season1gold37);
        goldRewards.put(38, season1gold38);
        goldRewards.put(39, season1gold39);
        goldRewards.put(40, season1gold40);

        goldRewards.put(41, season1gold41);
        goldRewards.put(42, season1gold42);
        goldRewards.put(43, season1gold43);
        goldRewards.put(44, season1gold44);
        goldRewards.put(45, season1gold45);
    }


    /*
    Normal-Rewards:
     */
    String season1normal1 = "";
    String season1normal2 = "";
    String season1normal3 = "";
    String season1normal4 = "";
    String season1normal5 = "";
    String season1normal6 = "";
    String season1normal7 = "";
    String season1normal8 = "";
    String season1normal9 = "";
    String season1normal10 = "";
    String season1normal11 = "";
    String season1normal12 = "";
    String season1normal13 = "";
    String season1normal14 = "";
    String season1normal15 = "";
    String season1normal16 = "";
    String season1normal17 = "";
    String season1normal18 = "";
    String season1normal19 = "";
    String season1normal20 = "";
    String season1normal21 = "";
    String season1normal22 = "";
    String season1normal23 = "";
    String season1normal24 = "";
    String season1normal25 = "";
    String season1normal26 = "";
    String season1normal27 = "";
    String season1normal28 = "";
    String season1normal29 = "";
    String season1normal30 = "";
    String season1normal31 = "";
    String season1normal32 = "";
    String season1normal33 = "";
    String season1normal34 = "";
    String season1normal35 = "";
    String season1normal36 = "";
    String season1normal37 = "";
    String season1normal38 = "";
    String season1normal39 = "";
    String season1normal40 = "";
    String season1normal41 = "";
    String season1normal42 = "";
    String season1normal43 = "";
    String season1normal44 = "";
    String season1normal45 = "";

    /*
    Gold-Rewards:
     */
    String season1gold1 = "";
    String season1gold2 = "";
    String season1gold3 = "";
    String season1gold4 = "";
    String season1gold5 = "";
    String season1gold6 = "";
    String season1gold7 = "";
    String season1gold8 = "";
    String season1gold9 = "";
    String season1gold10 = "";
    String season1gold11 = "";
    String season1gold12 = "";
    String season1gold13 = "";
    String season1gold14 = "";
    String season1gold15 = "";
    String season1gold16 = "";
    String season1gold17 = "";
    String season1gold18 = "";
    String season1gold19 = "";
    String season1gold20 = "";
    String season1gold21 = "";
    String season1gold22 = "";
    String season1gold23 = "";
    String season1gold24 = "";
    String season1gold25 = "";
    String season1gold26 = "";
    String season1gold27 = "";
    String season1gold28 = "";
    String season1gold29 = "";
    String season1gold30 = "";
    String season1gold31 = "";
    String season1gold32 = "";
    String season1gold33 = "";
    String season1gold34 = "";
    String season1gold35 = "";
    String season1gold36 = "";
    String season1gold37 = "";
    String season1gold38 = "";
    String season1gold39 = "";
    String season1gold40 = "";
    String season1gold41 = "";
    String season1gold42 = "";
    String season1gold43 = "";
    String season1gold44 = "";
    String season1gold45 = "";

}
