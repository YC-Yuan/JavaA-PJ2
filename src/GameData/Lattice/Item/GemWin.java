package GameData.Lattice.Item;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class GemWin extends Lattice {
    public void affectWith(Game game,Player player) {
        game.musicAudioPlay(getAudio());
        game.setGamePopup(this,"游戏胜利！\n可以继续探索这个世界\n也可以选择重新开始");
    }

    public String getCode() {return "n";}
    public String getGraphic() {return "file:pic/Lattice/Item/GemWin.png";}
    public String getAudio() {return "Audio/捡到宝石.mp3";}
}
