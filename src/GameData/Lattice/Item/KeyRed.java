package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class KeyRed extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeKeyRedNum(1);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    public String getCode() {return "v";}
    public String getGraphic() {return "file:pic/Lattice/Item/KeyRed.png";}
    public String getAudio() {return "Audio/捡到钥匙.mp3";}
}
