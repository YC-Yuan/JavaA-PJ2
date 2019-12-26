package GameData.Lattice;

import GUI.Game;

import java.io.FileNotFoundException;

public class Lattice {
    public Lattice() {
    }

    public void affectWith(Game game,Player player) throws FileNotFoundException {
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    public String getCode() {
        return "a";}
    public String getGraphic() {
        return "file:pic/Lattice/Lattice.png";}
    public String getAudio() {
        return "audio/脚步声.mp3";}
}
