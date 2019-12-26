package GameData.Lattice.Monster;

import GUI.Game;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class Slime extends Monster {
    //构造函数
    Slime(int hp,int atk,int def,int mon,int exp,int criticalChance,String name) {
        this.hp = hp; this.atk = atk; this.def = def;
        this.criticalChance = criticalChance; this.name = name;
    }

    private int criticalTimes = 0, dodgeTimes = 0, criticalChance;

    public void affectWith(Game game,Player player) throws FileNotFoundException {
        fightWith(player);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    private void fightWith(Player player) {
        while (hp > 0 & player.getHealth() > 0) {
            if (chanceGenerate(criticalChance)) {//勇者攻击怪物被闪避
                dodgeTimes++;
                //(name + "发动了闪避，无视勇者攻击！" + name + "还剩" + hp + "点生命值");
            }
            else {//勇者正常攻击怪物
                hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
                //("勇者对" + name + "造成" + Math.max(0,player.getAttackPoint() - def) + "点伤害！" +name + "还剩" + hp + "点生命值");
            }
            if (chanceGenerate(criticalChance)) {//怪物攻击勇者造成暴击
                criticalTimes++;
                player.changeHealth(-Math.max(0,2 * (atk - player.getDefence())));
                //FxFunction.addDisplayText(name + "发动暴击，对勇者造成" + Math.max(0,2 * (atk - player.getDefencePoint())) + "点伤害！" +
                //"勇者还剩" + player.getHealthPoint() + "点生命值");
            }
            else {//怪物正常攻击勇者
                player.changeHealth(-Math.max(0,atk - player.getDefence()));
                //FxFunction.addDisplayText(name + "对勇者造成" + Math.max(0,atk - player.getDefencePoint()) + "点伤害！" +
                //"勇者还剩" + player.getHealthPoint() + "点生命值");
            }
        }
        //FxFunction.addDisplayText(name + "共触发了" + criticalTimes + "次暴击和" + dodgeTimes + "次闪避");
        fightEnd(player);
    }

    public String[] fightPlan(Player player) {
        String[] strings = new String[9];
        int originalHealthPoint = player.getHealth();
        boolean isFightHappen = true;
        strings[0] = getGraphic();
        strings[1] = name;
        strings[2] = String.valueOf(hp);
        strings[3] = String.valueOf(atk);
        strings[4] = String.valueOf(def);
        strings[5] = String.valueOf(mon);
        strings[6] = String.valueOf(exp);
        if (atk <= player.getDefence() & def >= player.getAttack()) {
            isFightHappen = false;
        }
        else {
            while (hp > 0 & player.getHealth() > 0) {
                if (chanceGenerate(criticalChance)) {//勇者攻击怪物被闪避
                    dodgeTimes++;
                }
                else {//勇者正常攻击怪物
                    hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
                }
                if (chanceGenerate(criticalChance)) {//怪物攻击勇者造成暴击
                    criticalTimes++;
                    player.changeHealth(-Math.max(0,2 * (atk - player.getDefence())));
                }
                else {//怪物正常攻击勇者
                    player.changeHealth(-Math.max(0,atk - player.getDefence()));
                }
            }
        }
        if (!isFightHappen) strings[6] = "互不破防\n无法战斗";
        else if (player.getHealth() > 0)
            strings[7] = String.valueOf(originalHealthPoint - player.getHealth());//预计损血
        else strings[7] = "无法击败";
        strings[8] = "暴击概率:" + criticalChance + "% 闪避概率:" + criticalChance + "\n" +
                "模拟战斗中暴击" + criticalTimes + "次，闪避" + dodgeTimes + "次\n" +
                "暴击造成两倍伤害\n闪避免受伤害";
        return strings;
    }
}
