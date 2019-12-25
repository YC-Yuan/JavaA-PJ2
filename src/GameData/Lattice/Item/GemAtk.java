package GameData.Lattice.Item;

import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class GemAtk extends Lattice {
    public void affectWith(Player player) {
        player.changeAttack(2);
    }

    public String getCode() {return "m";}
    public String getGraphic() {return "file:pic/Lattice/Item/GemAtk.png";}
    public String getAudio() {return "file:Audio/捡到宝石.mp3";}
}
