package GameData.Lattice.Roadblock;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class Wall extends Lattice {
    public void affectWith(Game game,Player player) {
        player.moveCancel();
    }

    public String getCode() {return "b";}
    public String getGraphic() {return "file:pic/Lattice/Roadblock/Wall.png";}
    public String getAudio(){return "file:audio/撞墙.mp3";}
}
