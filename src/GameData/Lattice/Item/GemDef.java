package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class GemDef extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeDefence(2);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        game.setGamePopup(this,"捡到防御宝石,防御+2");
    }

    public String getCode() {return "n";}
    public String getGraphic() {return "file:pic/Lattice/Item/GemDef.png";}
    public String getAudio() {return "Audio/捡到宝石.mp3";}
}
