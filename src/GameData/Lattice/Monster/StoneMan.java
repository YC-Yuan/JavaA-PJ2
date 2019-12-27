package GameData.Lattice.Monster;

import GUI.Game;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class StoneMan extends Monster {
    public StoneMan() { this.hp = 70; this.atk = 60; this.def = 50; this.mon = 8; this.exp = 200; this.name = "石头人"; }

    public void affectWith(Game game,Player player) throws FileNotFoundException {
        fightWith(player);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        game.setGamePopup(this,name+"被打败了！");
    }

    private void fightWith(Player player) {
        while (hp > 0 & player.getHealth() > 0) {
            //勇者攻击怪物
            hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
            //("勇者对" + name + "造成" + Math.max(0,player.getAttackPoint() - def) + "点伤害！" +name + "还剩" + hp + "点生命值");
            //石头人受到攻击，攻击防御+2
            atk += 2; def += 2;
            //("石头人受到攻击，攻击防御+2，攻击力为" + atk + "，防御力为" + def);
            //怪物攻击勇者
            player.changeHealth(-Math.max(0,atk - player.getDefence()));
            //(name + "对勇者造成" + Math.max(0,atk - player.getDefencePoint()) + "点伤害！" +"勇者还剩" + player.getHealthPoint() + "点生命值");
        }
        //(name + "的最终攻击力为:" + atk + "，防御力为:" + def);
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
        while (hp > 0 & player.getHealth() > 0) {
            //勇者攻击怪物
            hp = Math.max(0,hp - Math.max(0,player.getAttack() - def));
            //石头人受到攻击，攻击防御+2
            atk += 2; def += 2;
            //怪物攻击勇者
            player.changeHealth(-Math.max(0,atk - player.getDefence()));
        }
        if (player.getHealth() > 0)
            strings[7] = String.valueOf(originalHealthPoint - player.getHealth());//预计损血
        else strings[7] = "无法击败";
        strings[8] = "最终攻击力:" + atk + " 最终防御力:" + def + "\n"
                + "每次被攻击增加2点攻击防御";
        return strings;
    }

    public String getCode() {return "z";}
    public String getGraphic() {return "file:pic/Lattice/Monster/StoneMan.png";}
    public String getAudio() {return "audio/石头人.mp3";}
}
