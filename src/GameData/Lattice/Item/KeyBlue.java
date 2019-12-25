package GameData.Lattice.Item;

import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class KeyBlue extends Lattice {
    public void affectWith(Player player) {
        player.changeKeyBlueNum(1);
    }

    public String getCode() {return "t";}
    public String getGraphic() {return "file:pic/Lattice/Item/KeyBlue.png";}
    public String getAudio() {return "file:Audio/捡到钥匙.mp3";}
}
