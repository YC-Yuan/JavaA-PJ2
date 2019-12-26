package GameData.Lattice.Monster;

public class SlimeRed extends Slime{
    public SlimeRed() {
        super(80,30,1,2,20,25,"红史莱姆");
    }

    public String getCode() { return "d"; }
    public String getGraphic() { return "file:pic/Lattice/Monster/SlimeRed.png"; }
    public String getAudio() { return "audio/史莱姆.mp3"; }
}
