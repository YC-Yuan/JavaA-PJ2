package GameData.Lattice;

public class Player extends Lattice {
    public String getCode() {return "B";}

    public String getGraphic() {return "file:pic/Lattice/Player.png";}

    //变量声明
    private int floor, health, healthMax, experience, level, attack, defence, money, keyYellowNum, keyBlueNum, keyRedNum;
    private int[] position, oldPosition;

    //基本方法
    public int getFloor() { return floor; }
    public void changeFloor(int change) { floor += change; }

    public int getHealth() {return health;}
    public void changeHealth(int change) {health = Math.min(healthMax,Math.min(0,health += change));}

    public int getHealthMax() {return healthMax;}
    public void changeHealthMax(int change) {healthMax += change;}

    public int getAttack() {return attack;}
    public void changeAttack(int change) {attack += change;}

    public int getDefence() {return defence;}
    public void changeDefence(int change) {defence += change;}

    public int getMoney() {return money;}
    public void changeMoney(int change) {money += change;}

    public int getKeyYellowNum() {return keyYellowNum;}
    public void changeKeyYellowNum(int change) {keyYellowNum -= change;}

    public int getKeyBlueNum() {return keyBlueNum;}
    public void changeKeyBlueNum(int change) {keyBlueNum -= change;}

    public int getKeyRedNum() {return keyRedNum;}
    public void changeKeyRedNum(int change) {keyRedNum -= change;}

    //等级经验相关
    public int getExperience() {return experience;}
    public void changeExperience(int change) {experience += change;}

    public int getLevel() {return level;}
    public void checkLevel() {
        int initialExpNeed = 100; double growthRateExp = 1.6;
        while ((int) (initialExpNeed * Math.pow(growthRateExp,level - 1)) <= experience) {
            experience -= (int) (initialExpNeed * Math.pow(growthRateExp,level - 1));
            levelUp();
        }
    }
    private void levelUp() { level++; healthMax += 100; health = healthMax; attack += 2; defence += 2; }

    //位置相关
    public int[] getPosition() {return position;}
    public void moveTo(int[] move) {oldPosition = position; position[0] += move[0]; position[1] += move[1];}
    public void moveCancel() {position = oldPosition;}

    //位置检查
    public boolean isHere(int row,int column) {return position[0] == row & position[1] == column;}
}
