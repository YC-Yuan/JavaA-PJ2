package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class KeyBlue extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeKeyBlueNum(1);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        Game.addDisplayText("捡到蓝钥匙一把~");
    }

    public String getCode() {return "t";}
    public String getGraphic() {return "file:pic/Lattice/Item/KeyBlue.png";}
    public String getAudio() {return "Audio/捡到钥匙.mp3";}
}
