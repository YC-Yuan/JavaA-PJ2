package GameData.Lattice.Monster;

public class SkeletonMan extends Skeleton{
    public SkeletonMan(){super(120,70,0,5,80,20,"骷髅人");}

    public String getCode(){return "g";}
    public String getGraphic(){return "file:pic/Lattice/Monster/SkeletonMan.png";}
    public String getAudio(){return "file:audio/骷髅.mp3";}
}
