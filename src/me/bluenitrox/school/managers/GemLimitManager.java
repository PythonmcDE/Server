package me.bluenitrox.school.managers;

import me.bluenitrox.school.managers.ExpManager;
import me.bluenitrox.school.managers.MoneyManager;
import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

public class GemLimitManager {

    private int prestige;
    private int level;
    private UUID uuid;
    private float money;

    public GemLimitManager(UUID uuid) {
        this.uuid = uuid;
       this.prestige = ExpManager.getPrestige(uuid);
       this.level = ExpManager.getLevel(uuid);
       this.money = MoneyManager.getMoney(uuid);
    }

    private final HashMap<Integer, Float> gl = new HashMap<>();

    private void registerGemLimit() {

        gl.put(0, 0F);
        gl.put(1, 500000F);
        gl.put(2, 700000F);
        gl.put(3, 980000F);
        gl.put(4, 1372000F);
        gl.put(5, 1920000F);

        gl.put(6, 2689000F);
        gl.put(7, 3764000F);
        gl.put(8, 4328000F);
        gl.put(9, 4977000F);
        gl.put(10, 5724000F);

        gl.put(11, 6583000F);
        gl.put(12, 7570000F);
        gl.put(13, 8706000F);
        gl.put(14, 10012000F);
        gl.put(15, 11514000F);

        gl.put(16, 13241000F);
        gl.put(17, 15227000F);
        gl.put(18, 17511000F);
        gl.put(19, 20138000F);
        gl.put(20, 23159000F);

        gl.put(21, 26632000F);
        gl.put(22, 30627000F);
        gl.put(23, 35222000F);
        gl.put(24, 40505000F);
        gl.put(25, 46581000F);

        gl.put(26, 51230000F);
        gl.put(27, 56363000F);
        gl.put(28, 61990000F);
        gl.put(29, 68199000F);
        gl.put(30, 75019000F);

        gl.put(31, 81021000F);
        gl.put(32, 87502000F);
        gl.put(33, 94502000F);
        gl.put(34, 102063000F);
        gl.put(35, 110228000F);

        gl.put(36, 116841000F);
        gl.put(37, 122684000F);
        gl.put(38, 128818000F);
        gl.put(39, 135259000F);
        gl.put(40, 142022000F);

        gl.put(41, 149123000F);
        gl.put(42, 156579000F);
        gl.put(43, 164408000F);
        gl.put(44, 172628000F);
        gl.put(45, 181260000F);

        gl.put(46, 186698000F);
        gl.put(47, 192290000F);
        gl.put(48, 198067000F);
        gl.put(49, 204009000F);
        gl.put(50, 210130000F);

        gl.put(51, 216434000F);
        gl.put(52, 222927000F);
        gl.put(53, 232705000F);
        gl.put(54, 239686000F);
        gl.put(55, 251670000F);

        gl.put(56, 264254000F);
        gl.put(57, 272181000F);
        gl.put(58, 277625000F);
        gl.put(59, 283177000F);
        gl.put(60, 288841000F);

        gl.put(61, 294618000F);
        gl.put(62, 300510000F);
        gl.put(63, 306520000F);
        gl.put(64, 312650000F);
        gl.put(65, 318904000F);

        gl.put(66, 325282000F);
        gl.put(67, 331787000F);
        gl.put(68, 338423000F);
        gl.put(69, 345192000F);
        gl.put(70, 252095000F);

        gl.put(71, 359137000F);
        gl.put(72, 366320000F);
        gl.put(73, 373647000F);
        gl.put(74, 381119000F);
        gl.put(75, 388742000F);

        gl.put(76, 396517000F);
        gl.put(77, 404447000F);
        gl.put(78, 412536000F);
        gl.put(79, 420787000F);
        gl.put(80, 429203000F);

        gl.put(81, 450663000F);
        gl.put(82, 473196000F);
        gl.put(83, 496856000F);
        gl.put(84, 575173000F);
        gl.put(85, 634128000F);

        gl.put(86, 699126000F);
        gl.put(87, 770786000F);
        gl.put(88, 849792000F);
        gl.put(89, 936896000F);
        gl.put(90, 1084574000F);

        gl.put(91, 1200993000F);
        gl.put(92, 1360095000F);
        gl.put(93, 1459815000F);
        gl.put(94, 1532805000F);
        gl.put(95, 1609446000F);

        gl.put(96, 1689918000F);
        gl.put(97, 1774414000F);
        gl.put(98, 1863135000F);
        gl.put(99, 1956291000F);
        gl.put(100, 2054106000F);
    }

    public float getGemLimit() {
        this.registerGemLimit();

        float lvlGemLimit = gl.get(level);
        if(Bukkit.getPlayer(uuid).hasPermission(PermissionsManager.ALLPERMS)){
            return 1000000000000000000F;
        }
        if(prestige == 3) {
            return (lvlGemLimit+40000000) / 100 * 140;
        } else if(prestige == 2) {
            return (lvlGemLimit+15000000) / 100 * 125;
        } else if(prestige == 1) {
            return (lvlGemLimit+5000000) / 100 * 110;
        } else {
            return lvlGemLimit;
        }
    }

    public float getRestGemLimit() {

        float maxGemLimit = this.getGemLimit();

        return maxGemLimit - money;

    }

}
