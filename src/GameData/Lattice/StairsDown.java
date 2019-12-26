package GameData.Lattice;

import GUI.Game;

import java.io.FileNotFoundException;

public class StairsDown extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeFloor(-1);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    public String getCode() {return "j";}
    public String getGraphic() {return "file:pic/Lattice/StairsDown.png";}
    public String getAudio() {
        return "audio/脚步声.mp3";
    }
}
