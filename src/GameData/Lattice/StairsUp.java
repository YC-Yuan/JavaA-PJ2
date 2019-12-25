package GameData.Lattice;

import GUI.Game;

public class StairsUp extends Lattice{
    public void affectWith(Game game,Player player) {
        player.changeFloor(1);
    }

    public String getCode() {
        return "i";}
    public String getGraphic() {
        return "file:pic/Lattice/StairsUp.png";}
    public String getAudio() {
        return "file:audio/脚步声.mp3";}
}
