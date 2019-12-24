package GameData.Lattice.Monster;

public class BatSmall extends Bat{
    public BatSmall() {
        super(100,35,5,3,30,0.01,5,"蝙蝠");
    }

    public String getCode(){return "f";}
    public String getGraphic(){return "file:pic/Lattice/Monster/BatSmall.png";}
    public String getAudio(){return "file:audio/蝙蝠.mp3";}
}
