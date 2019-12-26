package GameData;

import GUI.Game;
import GameData.Lattice.Lattice;
import GameData.Lattice.Player;

import java.io.FileNotFoundException;

public class MotaGame {
    private Lattice[][][] map;
    private Player player;

    public Lattice[][][] getMap() {return map;}
    public Player getPlayer() {return player;}

    MotaGame(Lattice[][][] map,Player player) {this.map = map; this.player = player;}

    public void move(Game game,int[] move) throws FileNotFoundException {
        player.move(move);//改变勇者位置
        //如果勇者原本的位置不是楼梯，就变成空地
        String oldPositionCode = map[player.getOldFloor()][player.getOldPosition()[0]][player.getOldPosition()[1]].getCode();
        if (!(oldPositionCode.equals("i") | oldPositionCode.equals("j")))
            map[player.getOldFloor()][player.getOldPosition()[0]][player.getOldPosition()[1]] = new Lattice();
        //新位置处的对象与勇者交互
        map[player.getFloor()][player.getPosition()[0]][player.getPosition()[1]].affectWith(game,player);
        game.setGamePlayground(this);
    }
}
