package GameData.Lattice.Roadblock;

import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

public class DoorBlue extends Lattice {
    public void affectWith(Player player) {
        if(player.getKeyBlueNum()==0){ player.moveCancel();}//没钥匙不能动
        else{player.changeKeyBlueNum(-1);}
    }

    public String getCode() {return "u";}

    public String getGraphic() {return "file:pic/Lattice/Roadblock/DoorBlue.png";}
}