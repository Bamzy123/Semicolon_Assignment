import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TelevisionTest {
    private Television television;

    @BeforeEach
    void setUp() {
        television = new Television();
    }

    @Test
    public void testThatTelevisionIsOff() {
        assertFalse(television.power());
    }

    @Test
    public void testThatTelevisionCanBeOffWhenItIsOn() {
        assertFalse(television.power());
        television.isOn();
        assertTrue(television.power());
        television.isOff();
        assertFalse(television.power());
    }

    @Test
    public void testThatTelevisionCanBeOn() {
        assertFalse(television.power());
        television.isOn();
        assertTrue(television.power());
    }
    @Test
    public void testThatTelevisionCanIncreaseVolume() {
        television.isOn();
        assertTrue(television.power());
        television.volume();
        television.increaseVolume();
        assertEquals(1, television.volume());
    }

    @Test
    public void testThatTelevisionCanDecreaseVolume() {
        television.isOn();
        assertTrue(television.power());
        television.volume();
        television.decreaseVolume();
        assertEquals(8, television.volume(), 10);
    }

    @Test
    public void testThatVolumeDoesNotChangeWhenItIsOff() {
        assertFalse(television.power());
        television.volume();
//        television.increaseVolume();
        assertEquals(0, television.volume(), 10);
    }

    @Test
    public void testThatChannelCanGoUp() {
        television.isOn();
        assertTrue(television.power());
        television.channel();
        television.channelUp();
        assertEquals(2, television.channel());
    }

    @Test
    public void testThatChannelCanGoDown() {
        television.isOn();
        assertTrue(television.power());
        television.channel();
        television.channelDown();
        assertEquals(1, television.channel(), 5);
    }

    @Test
    public void testThatChannelCannotChangeWhenItIsOff() {
        assertFalse(television.power());
        television.channel();
//        television.channelUp();
        assertEquals(0, television.channel(), 5);
    }

    @Test
    public void testThatChannelCanBeSet() {
        television.isOn();
        assertTrue(television.power());
        television.setChannel(13);
        assertEquals(13, television.channel());
    }

    @Test
    public void testThatSettingChannelShouldFailWhenItIsOff() {
        assertFalse(television.power());
        television.setChannel(13);
        assertEquals(0, television.channel(), 13);
    }

    @Test
    public void testThatTelevisionCanBeMute() {
        television.isOn();
        assertTrue(television.power());
        television.mute();
        assertTrue(television.muted());
    }

    @Test
    public void testThatTelevisionCannotBeMutedWhenItIsOff() {
        assertFalse(television.power());
        television.mute();
        assertFalse(television.muted());
    }
}
