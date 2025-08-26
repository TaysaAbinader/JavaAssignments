package Chapter_2_1;

public class Television {
    private boolean isOn = false;
    private int channel = 0;

    public Television () {}

    public boolean isOn() {
        return this.isOn;
    }

    public void pressOnOff() {
        this.isOn = !this.isOn;
    }

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
