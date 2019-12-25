package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class GemWin extends Lattice {
    public void affectWith(Game game,Player player) {
        //游戏胜利
    }

    public String getCode() {return "n";}
    public String getGraphic() {return "file:pic/Lattice/Item/GemDef.png";}
    public String getAudio() {return "file:Audio/捡到宝石.mp3";}
}
