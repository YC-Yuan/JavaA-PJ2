package GameData.Lattice.Npc;

import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class Merchant extends Lattice {
    public void affectWith(Player player) {
        player.moveCancel();
    }

    public String getCode() {return "k";}
    public String getGraphic() {return "file:pic/Lattice/Npc/Merchant.png";}
}