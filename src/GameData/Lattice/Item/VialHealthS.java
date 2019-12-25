package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class VialHealthS extends Lattice {
    public void affectWith(Game game,Player player) {
        player.changeHealth(50);
    }

    public String getCode() {return "o";}
    public String getGraphic() {return "file:pic/Lattice/Item/VialHealthS.png";}
    public String getAudio() {return "file:Audio/捡到血瓶.mp3";}
}
