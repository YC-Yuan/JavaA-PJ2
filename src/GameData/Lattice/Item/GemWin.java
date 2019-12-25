package GameData.Lattice.Item;

import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class GemWin extends Lattice {
    public void affectWith(Player player) {
        //游戏胜利
    }

    public String getCode() {return "n";}
    public String getGraphic() {return "file:pic/Lattice/Item/GemDef.png";}
    public String getAudio() {return "file:Audio/捡到宝石.mp3";}
}
