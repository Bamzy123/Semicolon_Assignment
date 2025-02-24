public class Television {
    private boolean power;
    private int volume = 0;
    private int channel = 1;
    private boolean muted = true;

    public boolean power() {
        return power;
    }

    public void isOn() {
        power = true;
    }

    public void isOff() {
        power = false;
    }

    public int volume() {
        return volume;
    }

    public void increaseVolume() {
        if (power) if (volume < 100)
                volume++;
    }

    public void decreaseVolume() {
        if (power) if (volume > 0)
            volume--;
    }

    public int channel() {
        return channel;
    }

    public void channelUp() {
        if (power) if (channel <= 100)
            channel++;
    }

    public void channelDown() {
        if (power) if (channel > 1)
            channel--;
    }

    public void setChannel(int number) {
        if (power) if (number <= 100)
            channel = number;
    }

    public void mute() {
        muted = power;
    }

    public boolean muted() {
        return muted;
    }
}