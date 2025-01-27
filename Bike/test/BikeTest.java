import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private Bike bike;

    @Test
    public void testThatBikeIsOffAtInitialState() {
        bike = new Bike();
        assertFalse(bike.isPower(), "Bike should be off at the initial state.");
    }

    @Test
    public void testThatBikeCanBeTurnedOn() {
        bike = new Bike();
        bike.isOn();
        assertTrue(bike.isPower(), "Bike should be on after calling isOn().");
    }

    @Test
    public void testThatBikeCanBeTurnedOffWhenOn() {
        bike = new Bike();
        bike.isOn();
        assertTrue(bike.isPower(), "Bike should be on.");
        bike.isOff();
        assertFalse(bike.isPower(), "Bike should be off after calling isOff().");
        assertEquals(0, bike.currentGear(), "Gear should reset to 0 when the bike is turned off.");
        assertEquals(0, bike.getCurrentSpeed(), "Speed should reset to 0 when the bike is turned off.");
    }

    @Test
    public void testThatGearIsZeroWhenBikeIsTurnedOn() {
        bike = new Bike();
        bike.isOn();
        assertEquals(0, bike.currentGear(), "Gear should be 0 when the bike is turned on.");
    }

    @Test
    public void testThatGearCanChangeFromZeroToOne() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        assertEquals(1, bike.currentGear(), "Gear should change to 1 after calling changeGear().");
    }

    @Test
    public void testThatSpeedIncreasesByOneInGearOne() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        bike.accelerate();
        assertEquals(1, bike.getCurrentSpeed(), "Speed should increase by 1 in gear 1.");
    }

    @Test
    public void testThatGearAutomaticallyChangesToTwoAtSpeedTwenty() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for (int index = 0; index < 20; index++) {
            bike.accelerate();
        }
        assertEquals(20, bike.getCurrentSpeed(), "Speed should be 20 in gear 1.");
        assertEquals(2, bike.currentGear(), "Gear should automatically change to 2 at speed 20.");
    }

    @Test
    public void testThatGearAutomaticallyChangesToThreeAtSpeedThirty() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for (int index = 0; index < 20; index++) {
            bike.accelerate();
        }
        for (int index = 0; index < 5; index++) {
            bike.accelerate();
        }
        assertEquals(30, bike.getCurrentSpeed(), "Speed should be 30 in gear 2.");
        assertEquals(3, bike.currentGear(), "Gear should automatically change to 3 at speed 30.");
    }

    @Test
    public void testThatGearAutomaticallyChangesToFourAtSpeedForty() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for (int index = 0; index < 20; index++) {
            bike.accelerate();
        }
        for (int index = 0; index < 5; index++) {
            bike.accelerate();
        }
        for (int index = 0; index < 4; index++) {
            bike.accelerate();
        }
        assertEquals(42, bike.getCurrentSpeed(), "Speed should be 42 in gear 4.");
        assertEquals(4, bike.currentGear(), "Gear should automatically change to 4 at speed 40.");
    }

    @Test
    public void testThatBikeCanExceedSpeedOfFortyAtGearFour() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for (int index = 0; index < 20; index++) {
            bike.accelerate();
        }
        for (int index = 0; index < 5; index++) {
            bike.accelerate();
        }
        for (int index = 0; index < 4; index++) {
            bike.accelerate();
        }
        for (int index = 0; index < 10; index++) {
            bike.accelerate();
        }
        assertEquals(92, bike.getCurrentSpeed(), "Speed should exceed 40 in gear 4.");
        assertEquals(4, bike.currentGear(), "Bike should remain in gear 4 after speed exceeds 40.");
    }

    @Test
    public void testThatBikeResetsSpeedAndGearWhenTurnedOff() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for (int index = 0; index < 20; index++) {
            bike.accelerate();
        }
        assertEquals(20, bike.getCurrentSpeed(), "Speed should be 20 before turning off.");
        assertEquals(2, bike.currentGear(), "Gear should be 2 before turning off.");

        bike.isOff();
        assertEquals(0, bike.getCurrentSpeed(), "Speed should reset to 0 when the bike is turned off.");
        assertEquals(0, bike.currentGear(), "Gear should reset to 0 when the bike is turned off.");
    }
}