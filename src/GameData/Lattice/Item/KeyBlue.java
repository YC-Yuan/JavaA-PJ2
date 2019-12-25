package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class KeyBlue extends Lattice {
    public void affectWith(Game game,Player player) {
        player.changeKeyBlueNum(1);
    }

    public String getCode() {return "t";}
    public String getGraphic() {return "file:pic/Lattice/Item/KeyBlue.png";}
    public String getAudio() {return "file:Audio/捡到钥匙.mp3";}
}
