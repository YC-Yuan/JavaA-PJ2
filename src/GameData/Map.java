package GameData;

import GameData.Lattice.*;
import GameData.Lattice.Item.*;
import GameData.Lattice.Monster.*;
import GameData.Lattice.Npc.Merchant;
import GameData.Lattice.Npc.Veteran;
import GameData.Lattice.Roadblock.DoorBlue;
import GameData.Lattice.Roadblock.DoorRed;
import GameData.Lattice.Roadblock.DoorYellow;
import GameData.Lattice.Roadblock.Wall;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Map {
    public static MotaGame mapLoad(String function,int turn) throws FileNotFoundException {
        Lattice[][][] map = new Lattice[5][13][13];
        Player player = new Player();
        String tempString, tempLine;
        //将文件中的信息读取为Lattice数组并返回
        for (int i = 0; i < 5; i++) {
            Scanner scanner = new Scanner(new File("map/" + function + turn + i + ".txt"));
            for (int j = 0; j < 13; j++) {
                tempLine = scanner.nextLine() + "\n";
                for (int k = 0; k < 13; k++) {
                    tempString = tempLine.substring(k,k + 1);
                    switch (tempString) {
                        case "a":
                            map[i][j][k] = new Lattice();
                            break;
                        case "b":
                            map[i][j][k] = new Wall();
                            break;
                        case "c":
                            map[i][j][k] = new SlimeGreen();
                            break;
                        case "d":
                            map[i][j][k] = new SlimeRed();
                            break;
                        case "e":
                            map[i][j][k] = new SlimeBlack();
                            break;
                        case "f":
                            map[i][j][k] = new BatSmall();
                            break;
                        case "F":
                            map[i][j][k] = new BatLarge();
                            break;
                        case "g":
                            map[i][j][k] = new SkeletonMan();
                            break;
                        case "h":
                            map[i][j][k] = new SkeletonSoldier();
                            break;
                        case "i":
                            map[i][j][k] = new StairsUp();
                            break;
                        case "j":
                            map[i][j][k] = new StairsDown();
                            break;
                        case "k":
                            map[i][j][k] = new Merchant();
                            break;
                        case "l":
                            map[i][j][k] = new Veteran();
                            break;
                        case "m":
                            map[i][j][k] = new GemAtk();
                            break;
                        case "n":
                            map[i][j][k] = new GemDef();
                            break;
                        case "q":
                            map[i][j][k] = new VialHealthL();
                            break;
                        case "p":
                            map[i][j][k] = new VialHealthM();
                            break;
                        case "o":
                            map[i][j][k] = new VialHealthS();
                            break;
                        case "r":
                            map[i][j][k] = new KeyYellow();
                            break;
                        case "s":
                            map[i][j][k] = new DoorYellow();
                            break;
                        case "t":
                            map[i][j][k] = new KeyBlue();
                            break;
                        case "u":
                            map[i][j][k] = new DoorBlue();
                            break;
                        case "v":
                            map[i][j][k] = new KeyRed();
                            break;
                        case "w":
                            map[i][j][k] = new DoorRed();
                            break;
                        case "x":
                            map[i][j][k] = new SkeletonBoss();
                            break;
                        case "y":
                            map[i][j][k] = new GemWin();
                            break;
                        case "z":
                            map[i][j][k] = new StoneMan();
                            break;
                        default:
                    }
                }
            }
            player.setPlayer(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
            scanner.close();
        }
        return new MotaGame(map,player);
    }

    public static void mapSave(String function,MotaGame motaGame,int turn) throws FileNotFoundException {
        Lattice[][][] map = motaGame.getMap();
        Player player = motaGame.getPlayer();
        for (int i = 0; i <= 4; i++) {
            // 创建一个 File 实例
            File mapSave = new File("map/" + function + turn + i + ".txt");
            if (function.equals("redo")) mapSave.deleteOnExit();
            // 创建一个文件
            PrintWriter output = new PrintWriter(mapSave);
            //储存地图数据
            for (int j = 0; j <= 12; j++) {
                for (int k = 0; k <= 12; k++) {
                    output.print(map[i][j][k].getCode());
                }
                output.println();
            }
            //储存勇者位置信息
            output.println(player.getFloor() + " " + player.getPosition()[0] + " " + player.getPosition()[1]);//楼层与位置
            output.println(player.getLevel() + " " + player.getExperience());//等级经验
            output.println(player.getHealth() + " " + player.getHealthMax() + " " + player.getAttack() + " " + player.getDefence() + " " + player.getMoney());//血攻防钱
            output.println(player.getKeyYellowNum() + " " + player.getKeyBlueNum() + " " + player.getKeyRedNum());//三种钥匙
            // 关闭文件
            output.close();
        }
    }
}
