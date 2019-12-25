package GameData.Lattice;

import GUI.Game;

public class StairsDown extends Lattice{
    public void affectWith(Game game,Player player) {
        player.changeFloor(-1);
    }

    public String getCode() {return "j";}

    public String getGraphic() {return "file:pic/Lattice/StairsDown.png";}
}
