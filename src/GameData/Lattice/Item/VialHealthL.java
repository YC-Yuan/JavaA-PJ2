package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class VialHealthL extends Lattice {
    public void affectWith(Game game,Player player) {
        player.changeHealth(250);
    }

    public String getCode() {return "q";}
    public String getGraphic() {return "file:pic/Lattice/Item/VialHealthL.png";}
    public String getAudio() {return "file:Audio/捡到血瓶.mp3";}
}
