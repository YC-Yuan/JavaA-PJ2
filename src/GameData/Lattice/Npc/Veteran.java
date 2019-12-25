package GameData.Lattice.Npc;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class Veteran extends Lattice {
    public void affectWith(Game game,Player player) {
        player.moveCancel();
    }

    public String getCode() {return "l";}

    public String getGraphic() {return "file:pic/Lattice/Npc/Veteran.png";}
}