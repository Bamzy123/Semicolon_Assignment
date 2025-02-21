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
//        television.increaseVolume();
        assertEquals(1, television.increaseVolume());
    }
}
