package GameData.Lattice.Monster;

import GUI.Game;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class Bat extends Monster {
    private double poisonRate;
    private int poisonDamage, rateDamageSum = 0, poisonDamageSum = 0;

    Bat(int hp,int atk,int def,int mon,int exp,double poisonRate,int poisonDamage,String name) {
        this.hp = hp; this.atk = atk; this.def = def; this.mon = mon; this.exp = exp;
        this.poisonRate = poisonRate; this.poisonDamage = poisonDamage; this.name = name;
    }

    public void affectWith(Game game,Player player) throws FileNotFoundException {
        fightWith(player);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        if (isBeaten) game.setGamePopup(this,name + "被打败了！");
        else {
            game.musicAudioPlay("audio/被砍中.mp3");
            game.setGamePopup(this,"胜败乃兵家常事，大侠请重新来过");
            game.gameRestart();
        }
    }

    private void fightWith(Player player) {
        boolean isPoisoned = false;
        while (hp > 0 & player.getHealth() > 0) {
            if (isPoisoned) {
                Game.addDisplayText("勇者中毒，受到百分比伤害" + (int) Math.ceil(player.getHealth() * poisonRate) + "点！");
                rateDamageSum += (int) Math.ceil(player.getHealth() * poisonRate);
                player.changeHealth(-(int) Math.ceil(player.getHealth() * poisonRate));
            }
            //勇者攻击怪物
            hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
            Game.addDisplayText("勇者对" + name + "造成" + Math.max(0,player.getAttack() - def) + "点伤害！" +name + "还剩" + hp + "点生命值");
            //怪物攻击勇者
            player.changeHealth(-Math.max(0,atk - player.getDefence() + poisonDamage));
            Game.addDisplayText(name + "对勇者造成" + Math.max(0,atk - player.getDefence() + poisonDamage) + "点伤害！" + "勇者还剩" + player.getHealth() + "点生命值");
            poisonDamageSum += poisonDamage;
            //进入中毒状态并提示
            if (!isPoisoned) {
                isPoisoned = true; //(name + "的攻击使勇者中毒，每回合都受到额外伤害");}
            }
            Game.addDisplayText(name + "共造成了" + rateDamageSum + "点百分比毒伤" + poisonDamageSum + "点毒素额外伤害");
        }
        fightEnd(player);
    }

    public String[] fightPlan(Player player) {
        String[] strings = new String[9];
        int originalHealthPoint = player.getHealth();
        strings[0] = getGraphic();
        strings[1] = name;
        strings[2] = String.valueOf(hp);
        strings[3] = String.valueOf(atk);
        strings[4] = String.valueOf(def);
        strings[5] = String.valueOf(mon);
        strings[6] = String.valueOf(exp);
        boolean isPoisoned = false;
        while (hp > 0 & player.getHealth() > 0) {
            if (isPoisoned) {
                rateDamageSum += (int) Math.ceil(player.getHealth() * poisonRate);
                player.changeHealth(-(int) Math.ceil(player.getHealth() * poisonRate));
            }
            //勇者攻击怪物
            hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
            //怪物攻击勇者
            player.changeHealth(-Math.max(0,atk - player.getDefence() + poisonDamage));
            poisonDamageSum += poisonDamage;
            if (!isPoisoned) {
                isPoisoned = true; //(name + "的攻击使勇者中毒，每回合都受到额外伤害");
            }
        }
        if (player.getHealth() > 0)
            strings[7] = String.valueOf(originalHealthPoint - player.getHealth());//预计损血
        else strings[7] = "无法击败";
        strings[8] = "百分比毒伤:" + (int)(poisonRate * 100) + "% 毒素额外伤害:" + poisonDamage + "\n" +
                "共造成百分比毒伤" + rateDamageSum + ",额外伤害" + poisonDamageSum + "\n" +
                "攻击后使勇者中毒\n每回合造成额外伤害";
        return strings;
    }
}
