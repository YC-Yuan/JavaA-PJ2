package GameData.Lattice.Monster;

public class SlimeGreen extends Slime {
    SlimeGreen() {
        super(50,20,1,1,10,20,"绿史莱姆");
    }

    public String getCode() { return "c"; }
    public String getGraphic() { return "file:pic/Monster.SlimeGreen"; }
    public String getAudio() { return "file:audio/史莱姆.mp3"; }
}
