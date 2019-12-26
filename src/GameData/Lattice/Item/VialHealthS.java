package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class VialHealthS extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeHealth(50);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    public String getCode() {return "o";}
    public String getGraphic() {return "file:pic/Lattice/Item/VialHealthS.png";}
    public String getAudio() {return "Audio/捡到血瓶.mp3";}
}
