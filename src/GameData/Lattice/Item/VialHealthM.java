package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class VialHealthM extends Lattice {
    public void affectWith(Game game,Player player) {
        player.changeHealth(100);
    }

    public String getCode() {return "p";}
    public String getGraphic() {return "file:pic/Lattice/Item/VialHealthM.png";}
    public String getAudio() {return "file:Audio/捡到血瓶.mp3";}
}
