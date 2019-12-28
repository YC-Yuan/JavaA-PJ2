package GameData.Lattice.Roadblock;

import GUI.Game;
import GameData.Lattice.*;

import java.io.FileNotFoundException;

public class DoorYellow extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        if (player.getKeyYellowNum() == 0) {
            player.moveCancel();
            game.setGamePopup(this,"没有黄钥匙了！");
            Game.addDisplayText("没有黄钥匙，开不了门");
        }
        else {player.changeKeyYellowNum(-1);}
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        Game.addDisplayText("黄门开了，快走吧~");
    }

    public String getCode() {return "s";}
    public String getGraphic() {return "file:pic/Lattice/Roadblock/DoorYellow.png";}
    public String getAudio() {return "audio/开门.mp3";}
}