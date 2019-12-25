package GameData.Lattice.Item;

import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class GemDef extends Lattice {
    public void affectWith(Player player) {
        player.changeDefence(2);
    }

    public String getCode() {return "n";}
    public String getGraphic() {return "file:pic/Lattice/Item/GemDef.png";}
    public String getAudio() {return "file:Audio/捡到宝石.mp3";}
}
