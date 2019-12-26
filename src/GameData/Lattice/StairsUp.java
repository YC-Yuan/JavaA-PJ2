package GameData.Lattice;

import GUI.Game;

import java.io.FileNotFoundException;

public class StairsUp extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeFloor(1);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    public String getCode() {
        return "i";
    }
    public String getGraphic() {
        return "file:pic/Lattice/StairsUp.png";
    }
    public String getAudio() {
        return "audio/脚步声.mp3";
    }
}
