package GameData.Lattice.Roadblock;

import GUI.Game;
import GameData.Lattice.*;

public class DoorYellow extends Lattice {
    public void affectWith(Game game,Player player) {
        if(player.getKeyYellowNum()==0){ player.moveCancel();}//没钥匙不能动
        else{player.changeKeyYellowNum(-1);}
    }

    public String getCode() {return "s";}

    public String getGraphic() {return "file:pic/Lattice/Roadblock/DoorYellow.png";}
}