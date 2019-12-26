package GameData.Lattice.Monster;

public class SlimeGreen extends Slime {
    public SlimeGreen() {
        super(50,20,1,1,10,20,"绿史莱姆");
    }

    public String getCode() { return "c"; }
    public String getGraphic() { return "file:pic/Lattice/Monster/SlimeGreen.png"; }
    public String getAudio() { return "audio/史莱姆.mp3"; }
}
