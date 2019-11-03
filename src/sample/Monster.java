package sample;

public abstract class Monster {
    private int health;
    private int speed;
    private int Defense;

    public int getDefense() {
        return this.health;
    }

    public int getSpeed() {
        return this.speed;
    }

}

class Cersie extends Monster {

}

class Danaeris extends Monster {

}

class NightKing extends Monster {

}
