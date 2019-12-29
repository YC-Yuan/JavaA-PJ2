package GameData.Lattice.Monster;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class Monster extends Lattice {
    int hp, atk, def, mon, exp;
    String name;
    boolean isBeaten=false;

    //构造函数
    Monster() {}

    void fightEnd(Player player) {
        if (player.getHealth() == 0) {
            this.isBeaten=false;
            Game.addDisplayText(name+"打败了勇者，请重新来过");
        }
        else {
            //击败怪物
            player.changeMoney(mon);
            player.changeExperience(exp);
            this.isBeaten=true;
        }
    }

    public String[] fightPlan(Player player) {return new String[9];}

    static boolean chanceGenerate(int chance) {//chance为0~100的整数
        double getChance = Math.random() * 100;//[0,100)的小数
        return (getChance < chance);
    }
}
