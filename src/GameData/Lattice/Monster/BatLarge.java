package GameData.Lattice.Monster;

public class BatLarge extends Bat{
    public BatLarge() {
        super(200,60,25,8,150,0.02,10,"大蝙蝠");
    }


    public String getCode(){return "F";}
    public String getGraphic(){return "file:pic/Lattice/Monster/BatLarge.png";}
    public String getAudio(){return "audio/蝙蝠.mp3";}
}
