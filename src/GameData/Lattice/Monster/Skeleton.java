package GameData.Lattice.Monster;

import GameData.Lattice.Player;

public class Skeleton extends Monster {
    Skeleton(int hp,int atk,int def,int mon,int exp,int criticalChance,String name) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.mon = mon;
        this.exp = exp;
        this.criticalChance = criticalChance;
        this.name = name;
    }

    private int criticalChance, criticalTime = 0;

    public void affectWith(Player player) {
        fightWith(player);
    }

    private void fightWith(Player player) {
        int criticalDamage = (int) Math.max(0,Math.ceil(atk * 1.2) - Math.ceil(player.getDefence() * 0.8));
        while (hp > 0 & player.getHealth() > 0) {
            //勇士攻击怪物
            hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
            //("勇者对" + name + "造成" + Math.max(0,player.getAttackPoint() - def) + "点伤害！" +name + "还剩" + hp + "点生命值");
            //怪物攻击勇者特殊攻击
            if (chanceGenerate(criticalChance)) {
                criticalTime++;
                player.changeHealth(-criticalDamage);
                //(name + "发动特殊攻击，对勇者造成" + criticalDamage + "点伤害！" +"勇者还剩" + player.getHealthPoint() + "点生命值");
            }
            //怪物正常攻击勇者
            player.changeHealth(-Math.max(0,atk - player.getDefence()));
            //(name + "对勇者造成" + Math.max(0,atk - player.getDefencePoint()) + "点伤害！" +"勇者还剩" + player.getHealthPoint() + "点生命值");
        }
        //(name + "共触发了" + criticalTime + "次特殊攻击");
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
        int criticalDamage = (int) Math.max(0,Math.ceil(atk * 1.2) - Math.ceil(player.getDefence() * 0.8));
        while (hp > 0 & player.getHealth() > 0) {
            //勇士攻击怪物
            hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
            //怪物攻击勇者特殊攻击
            if (chanceGenerate(criticalChance)) {
                criticalTime++;
                player.changeHealth(-criticalDamage);
            }
            //怪物正常攻击勇者
            player.changeHealth(-Math.max(0,atk - player.getDefence()));
        }
        if (player.getHealth() > 0)
            strings[7] = String.valueOf(originalHealthPoint - player.getHealth());//预计损血
        else strings[7] = "无法击败";
        strings[8] = "特殊攻击概率:" + criticalChance + "% \n" +
                "模拟战斗中特殊攻击" + criticalTime + "次\n" +
                "特殊攻击提升20%攻击力\n无视20%防御";
        return strings;
    }
}
