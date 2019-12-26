package GameData.Lattice.Roadblock;

import GUI.Game;
import GameData.Lattice.*;

import java.io.FileNotFoundException;

public class DoorYellow extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        if (player.getKeyYellowNum() == 0) { player.moveCancel();}//没钥匙不能动
        else {player.changeKeyYellowNum(-1);}
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
    }

    public String getCode() {return "s";}
    public String getGraphic() {return "file:pic/Lattice/Roadblock/DoorYellow.png";}
    public String getAudio() {return "audio/开门.mp3";}
}