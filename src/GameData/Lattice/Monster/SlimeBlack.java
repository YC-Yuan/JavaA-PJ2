package GameData.Lattice.Monster;

public class SlimeBlack extends Slime {
    SlimeBlack() {
        super(200,45,15,5,50,33,"黑史莱姆");
    }

    public String getCode() { return "e"; }
    public String getGraphic() { return "file:pic/Monster.SlimeBlack"; }
    public String getAudio() { return "file:audio/史莱姆.mp3"; }
}
