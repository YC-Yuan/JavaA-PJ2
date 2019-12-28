package GameData.Lattice.Roadblock;

import GUI.Game;
import GameData.Lattice.*;

import java.io.FileNotFoundException;

public class DoorRed extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        if (player.getKeyRedNum() == 0) {
            player.moveCancel();
            game.setGamePopup(this,"没有红钥匙了！");
            Game.addDisplayText("没有红钥匙，开不了门");
        }
        else {player.changeKeyRedNum(-1);}
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        Game.addDisplayText("红门发出享受的声音，允许你通过");
    }

    public String getCode() {return "w";}
    public String getGraphic() {return "file:pic/Lattice/Roadblock/DoorRed.png";}
    public String getAudio() {return "audio/开门.mp3";}
}