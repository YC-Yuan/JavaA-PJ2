package GameData.Lattice.Roadblock;

import GUI.Game;
import GameData.Lattice.*;

public class DoorRed extends Lattice {
    public void affectWith(Game game,Player player) {
        if(player.getKeyRedNum()==0){ player.moveCancel();}//没钥匙不能动
        else{player.changeKeyRedNum(-1);}
    }

    public String getCode() {return "w";}

    public String getGraphic() {return "file:pic/Lattice/Roadblock/DoorRed.png";}
}