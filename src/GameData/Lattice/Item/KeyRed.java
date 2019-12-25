package GameData.Lattice.Item;

import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class KeyRed extends Lattice {
    public void affectWith(Player player) {
        player.changeKeyRedNum(1);
    }

    public String getCode() {return "v";}
    public String getGraphic() {return "file:pic/Lattice/Item/KeyRed.png";}
    public String getAudio() {return "file:Audio/捡到钥匙.mp3";}
}
