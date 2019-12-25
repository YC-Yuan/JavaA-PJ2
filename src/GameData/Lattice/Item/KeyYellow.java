package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class KeyYellow extends Lattice {
    public void affectWith(Game game,Player player) {
        player.changeKeyYellowNum(1);
    }

    public String getCode() {return "r";}
    public String getGraphic() {return "file:pic/Lattice/Item/KeyYellow.png";}
    public String getAudio() {return "file:Audio/捡到钥匙.mp3";}
}
