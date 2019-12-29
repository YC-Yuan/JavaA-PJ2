package GameData.Lattice.Monster;

public class SkeletonSoldier extends Skeleton {
    public SkeletonSoldier() {super(200,100,15,8,120,25,"骷髅士兵");}

    public String getCode() {return "h";}
    public String getGraphic() {return "file:pic/Lattice/Monster/SkeletonSoldier.png";}
    public String getAudio() {return "audio/骷髅.mp3";}
}
