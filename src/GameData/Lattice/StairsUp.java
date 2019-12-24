package GameData.Lattice;

public class StairsUp extends Lattice{
    public void affectWith(Player player) {
        player.changeFloor(1);
    }

    public String getCode() {
        return "i";}
    public String getGraphic() {
        return "file:pic/Lattice/StairsUp.png";}
    public String getAudio() {
        return "file:audio/脚步声.mp3";}
}
