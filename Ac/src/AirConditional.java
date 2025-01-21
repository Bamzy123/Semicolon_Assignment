public class AirConditional {

    private boolean power;
    private int initialAircondition = 16;

    public boolean power() {
        return power;
    }

    public void isOn() {
        power = true;
    }

    public void isOff() {
        power = false;
    }

    public int initial() {
        return initialAircondition;
    }

    public void increase() {
        if (this.initialAircondition < 30) this.initialAircondition++;
        else this.initialAircondition = 30;
    }

    public void decrease() {
        initialAircondition--;
    }
}