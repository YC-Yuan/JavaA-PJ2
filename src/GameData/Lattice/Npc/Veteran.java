package GameData.Lattice.Npc;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class Veteran extends Lattice {

    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.moveCancel();
        int level;
        level = player.getLevel();
        player.checkLevel();
        if (level == player.getLevel()) game.setGamePopup(this,"年轻人，经验不够呀……\n再打些怪积累吧！");
        else {
            Game.addDisplayText("勇者升到了" + player.getLevel() + "级！");
            Game.addDisplayText("生命上限+100,恢复50%血量,攻击防御+2");
            game.setGamePopup(this,"老人悉心指导\n勇者更懂得如何运用他的力量了");
        }
        game.gameSaveForUndo();
    }

    public String getCode() {return "l";}
    public String getGraphic() {return "file:pic/Lattice/Npc/Veteran.png";}
}