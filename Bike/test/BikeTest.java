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
    @Test
    public void testThatBikeCanDecelerateInGearOne() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        bike.accelerate();
        bike.accelerate();
        assertEquals(2, bike.getCurrentSpeed(), "Speed should be 2 after accelerating twice in gear 1.");
        bike.decelerate();
        assertEquals(1, bike.getCurrentSpeed(), "Speed should decrease to 1 after decelerating in gear 1.");
    }

    @Test
    public void testThatBikeCannotGoBelowZeroSpeed() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        bike.decelerate();
        assertEquals(0, bike.getCurrentSpeed(), "Speed should not go below 0 when decelerating.");
    }

    @Test
    public void testThatBikeAutomaticallyChangesToGearTwoWhenDeceleratingBelowGearTwoThreshold() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for (int index = 0; index < 20; index++) {
            bike.accelerate();
        }
        assertEquals(20, bike.getCurrentSpeed(), "Speed should be 20 before decelerating.");
        assertEquals(2, bike.currentGear(), "Gear should be 2 at speed 20.");

        bike.decelerate();
        bike.decelerate();
        assertEquals(18, bike.getCurrentSpeed(), "Speed should decrease to 18 after two decelerations.");
        assertEquals(2, bike.currentGear(), "Gear should remain 2 at speed 18.");

        for (int index = 0; index < 10; index++) {
            bike.decelerate();
        }
        assertEquals(8, bike.getCurrentSpeed(), "Speed should be 8 after multiple decelerations.");
        assertEquals(1, bike.currentGear(), "Gear should automatically change to 1 when speed falls below 10.");
    }

    @Test
    public void testThatBikeAutomaticallyChangesToGearThreeWhenDeceleratingBelowGearThreeThreshold() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear(); // Switch to gear 1
        for (int index = 0; index < 20; index++) {
            bike.accelerate(); // Reach gear 2
        }
        for (int index = 0; index < 5; index++) {
            bike.accelerate(); // Reach gear 3
        }
        assertEquals(30, bike.getCurrentSpeed(), "Speed should be 30 in gear 3.");

        for (int index = 0; index < 10; index++) {
            bike.decelerate();
        }
        assertEquals(20, bike.getCurrentSpeed(), "Speed should decrease to 20 after decelerating.");
        assertEquals(2, bike.currentGear(), "Gear should automatically change to 2 when speed falls below 30.");
    }

    @Test
    public void testThatBikeAutomaticallyChangesToGearFourWhenDeceleratingBelowGearFourThreshold() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear(); // Switch to gear 1
        for (int index = 0; index < 20; index++) {
            bike.accelerate(); // Reach gear 2
        }
        for (int index = 0; index < 5; index++) {
            bike.accelerate(); // Reach gear 3
        }
        for (int index = 0; index < 4; index++) {
            bike.accelerate(); // Reach gear 4
        }
        assertEquals(42, bike.getCurrentSpeed(), "Speed should be 42 in gear 4.")es;

        for (int index = 0; index < 10; index++) {
            bike.decelerate();
        }
        assertEquals(32, bike.getCurrentSpeed(), "Speed should decrease to 32 after decelerating.");
        assertEquals(3, bike.currentGear(), "Gear should automatically change to 3 when speed falls below 40.");
    }

    @Test
    public void testThatBikeStopsCompletelyWhenDeceleratingFromHighSpeed() {
        bike = new Bike();
        bike.isOn();
        bike.changeGear(); // Switch to gear 1
        for (int index = 0; index < 20; index++) {
            bike.accelerate(); // Reach gear 2
        }
        for (int index = 0; index < 5; index++) {
            bike.accelerate(); // Reach gear 3
        }
        for (int index = 0; index < 4; index++) {
            bike.accelerate(); // Reach gear 4
        }
        assertEquals(42, bike.getCurrentSpeed(), "Speed should be 42 before decelerating.");

        for (int index = 0; index < 50; index++) {
            bike.decelerate(); // Decrease speed to 0
        }
        assertEquals(0, bike.getCurrentSpeed(), "Speed should be 0 after multiple decelerations.");
        assertEquals(1, bike.currentGear(), "Gear should reset to 1 when speed is 0.");
    }
}