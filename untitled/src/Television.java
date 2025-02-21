public class Television {
    private boolean power;
    int increaseVolume = 0;

    public boolean power() {
        return power;
    }

    public void isOn() {
        power = true;
    }

    public void isOff() {
        power = false;
    }

    public int increaseVolume() {
        if (power) increaseVolume++;
        return increaseVolume;
    }
}