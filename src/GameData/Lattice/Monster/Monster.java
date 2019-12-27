package GameData.Lattice.Monster;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class Monster extends Lattice {
    int hp, atk, def, mon, exp;
    String name;

    //构造函数
    Monster() {}

    void fightEnd(Player player) {
        if (player.getHealth() == 0) {//生命不足，游戏结束
            //游戏结束的代码
        }
        else {
            //击败怪物
            player.changeMoney(mon);
            player.changeExperience(exp);
        }
    }

    static boolean chanceGenerate(int chance) {//chance为0~100的整数
        double getChance = Math.random() * 100;//[0,100)的小数
        return (getChance < chance);
    }
}
