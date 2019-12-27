package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class GemAtk extends Lattice {
    public void affectWith(Game game,Player player) throws FileNotFoundException {
        player.changeAttack(2);
        game.musicAudioPlay(getAudio());
        game.gameSaveForUndo();
        game.setGamePopup(this,"捡到攻击宝石,攻击+2");
    }

    public String getCode() {return "m";}
    public String getGraphic() {return "file:pic/Lattice/Item/GemAtk.png";}
    public String getAudio() {return "Audio/捡到宝石.mp3";}
}
