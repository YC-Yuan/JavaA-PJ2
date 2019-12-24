package GameData.Lattice.Monster;

public class SlimeRed extends Slime{
    SlimeRed() {
        super(80,30,1,2,20,25,"红史莱姆");
    }

    public String getCode() { return "d"; }
    public String getGraphic() { return "file:pic/Monster.SlimeRed"; }
    public String getAudio() { return "file:audio/史莱姆.mp3"; }
}
