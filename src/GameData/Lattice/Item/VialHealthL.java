package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class VialHealthL extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeHealth(300);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        game.setGamePopup(this,"捡到大血瓶,恢复300生命");
        Game.addDisplayText("使用大血瓶，回血三百");
    }

    public String getCode() {return "q";}
    public String getGraphic() {return "file:pic/Lattice/Item/VialHealthL.png";}
    public String getAudio() {return "Audio/捡到血瓶.mp3";}
}
