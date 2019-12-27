package GameData.Lattice.Roadblock;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class DoorBlue extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        if (player.getKeyBlueNum() == 0) {
            player.moveCancel();
            game.setGamePopup(this,"没有蓝钥匙了！");
        }
        else {player.changeKeyBlueNum(-1);}
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    public String getCode() {return "u";}
    public String getGraphic() {return "file:pic/Lattice/Roadblock/DoorBlue.png";}
    public String getAudio() {return "audio/开门.mp3";}
}