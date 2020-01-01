package GameData.Lattice.Npc;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Monster.Monster;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class Merchant extends Lattice {
    private static int price_1 = 20, times_1 = 0;
    private static int price_2 = 20, times_2 = 0;
    private static int price_3 = 10, times_3 = 0;
    private static int price_4;
    private static int yellowKeyRate = 50, blueKeyRate = 35, redKeyRate = 15;

    public String getGood_1(int num) {
        String[] info = {"攻击药水","勇者喝下后可\n增加攻击力3点",String.valueOf((int) (price_1 * Math.pow(2,times_1)))};
        return info[num];
    }

    public void buyGood_1(Game game,Player player) {
        int price = (int) (price_1 * Math.pow(2,times_1));
        if (player.getMoney() >= price) {
            player.changeAttack(3);
            player.changeMoney(-price);
            times_1++;
            Game.addDisplayText("购买了攻击药水！攻击力+3");
        }
        else {
            Game.addDisplayText("钱不够，买不了这个");
        }
        game.merchantTalk(this,player);
        game.updateDisplay();
        game.updateStatus(player);
        game.musicAudioPlay("audio/购买.mp3");
    }

    public String getGood_2(int num) {
        String[] info = {"防御药水","勇者喝下后可\n增加防御力3点",String.valueOf((int) (price_2 * Math.pow(2,times_2)))};
        return info[num];
    }

    public void buyGood_2(Game game,Player player) {
        int price = (int) (price_2 * Math.pow(2,times_2));
        if (player.getMoney() >= price) {
            player.changeDefence(3);
            player.changeMoney(-price);
            times_2++;
            Game.addDisplayText("购买了防御药水！攻击力+3");
        }
        else {
            Game.addDisplayText("钱不够，买不了这个");
        }
        game.merchantTalk(this,player);
        game.updateDisplay();
        game.updateStatus(player);
        game.musicAudioPlay("audio/购买.mp3");
    }

    public String getGood_3(int num) {
        String[] info = {"钥匙抽奖","随机获得一种钥匙\n" +
                yellowKeyRate + "%黄钥匙\n" + blueKeyRate + "%蓝钥匙\n" + redKeyRate + "%红钥匙",String.valueOf((int) (price_3 * Math.pow(2,times_3)))};
        return info[num];
    }

    public void buyGood_3(Game game,Player player) {
        int price = (int) (price_3 * Math.pow(2,times_3));
        if (player.getMoney() >= price) {
            int seed = (int) (Math.random() * 100);
            if (seed < yellowKeyRate) {
                player.changeKeyYellowNum(1);
                Game.addDisplayText("抽到了黄钥匙~");
            }
            else if (seed < (yellowKeyRate + blueKeyRate)) {
                player.changeKeyBlueNum(1);
                Game.addDisplayText("抽到了蓝钥匙~");
            }
            else if (seed < yellowKeyRate + blueKeyRate + redKeyRate) {
                player.changeKeyRedNum(1);
                Game.addDisplayText("抽到了红钥匙~");
            }
            player.changeMoney(-price);
            times_3++;
        }
        else {
            Game.addDisplayText("钱不够，买不了这个");
        }
        game.merchantTalk(this,player);
        game.updateDisplay();
        game.updateStatus(player);
        game.musicAudioPlay("audio/购买.mp3");
    }

    public String getGood_4(int num) {
        price_4 = (int) (Math.random() * 29+1);
        String[] info = {"金钱赌博","50%赚一倍50%赔光\n搏一搏,单车变摩托\n买一买,别墅能靠海",String.valueOf(price_4)};
        return info[num];
    }

    public void buyGood_4(Game game,Player player) {
        if (player.getMoney() >= price_4) {
            if ((int) (Math.random() * 100) < 50) {
                player.changeMoney(price_4);
                Game.addDisplayText("运气不错！勇士心情大好,还想试试");
            }
            else {
                player.changeMoney(-price_4);
                Game.addDisplayText("外面的阳光好刺眼啊……");
            }
        }
        else {
            Game.addDisplayText("钱不够，买不了这个");
        }
        game.merchantTalk(this,player);
        game.updateDisplay();
        game.updateStatus(player);
        game.musicAudioPlay("audio/购买.mp3");
    }

    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.moveCancel();
        game.merchantTalk(this,player);
        game.gameSaveForUndo();
    }

    public String getCode() {return "k";}
    public String getGraphic() {return "file:pic/Lattice/Npc/Merchant.png";}
}