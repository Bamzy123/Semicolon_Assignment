import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BikeTest {

    private   Bike bike;


    @Test
    public  void testThatBikeIsOffAtInitialState() {
      bike = new Bike();
       assertFalse(bike.isPower());
    }

    @Test
    public  void testThatBikeCanBeOn(){
        bike = new Bike();
        assertFalse(bike.isPower());
        bike.isOn();
        assertTrue(bike.isPower());
    }
    @Test
    public void testThatBikeCanBeOffWhenOn(){
        bike = new Bike();
        assertFalse(bike.isPower());
        bike.isOn();
        assertTrue(bike.isPower());
        bike.isOff();
        assertFalse(bike.isPower());
    }
    @Test
    public void testThatBikeCanBeOnWhenOff(){
        bike = new Bike();
        assertFalse(bike.isPower());
        bike.isOn();
        assertTrue(bike.isPower());
        bike.isOff();
        assertFalse(bike.isPower());
        bike.isOn();
        assertTrue(bike.isPower());
    }

    @Test
    public void testThatWhenBikesOnGearIsOnZer0(){
        bike = new Bike();
        bike.isOn();
        assertTrue(bike.isPower());
        assertEquals(0, bike.currentGear());
    }

    @Test
    public void testToChangeGearFromZeroToOne(){
        bike = new Bike();
        bike.isOn();
        assertTrue(bike.isPower());
        bike.changeGear();
        assertEquals(1, bike.currentGear());
    }

    @Test
    public void testThatGearOneIncrementIsOne(){
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        bike.accelerate();
        assertEquals(1, bike.getCurrentSpeed());
    }

    @Test
    public void testThatWhenBikeIsOnGearOneIfCurrentSpeedExceedsTwentyAutomaticallyChangeToGearTwo(){
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for(int index = 0; index < 20; index++){
            bike.accelerate();
        }
        assertEquals(20, bike.getCurrentSpeed());
        assertEquals(2, bike.currentGear());

    }

    @Test
    public void testThatWhenGearTwoSpeedReach30GearAutomaticallyChangeToGearThree(){
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for(int index = 1; index <= 20; index++){
            bike.accelerate();
        }
        assertEquals(2, bike.currentGear());

        for(int index = 2; index <=  10; index+=2){
                bike.accelerate();
        }
        assertEquals(30, bike.getCurrentSpeed());
        assertEquals(3, bike.currentGear());
    }

    @Test
    public void testThatWhenGearThreeSpeedReach40GearAutomaticallyChangeToGearFour(){
        bike = new Bike();
        bike.isOn();
        bike.changeGear();
        for(int index = 1; index <= 20; index++){
            bike.accelerate();
        }
        assertEquals(2, bike.currentGear());

        for(int index = 2; index <=  10; index+=2){
            bike.accelerate();
        }
        assertEquals(3, bike.currentGear());

        for(int index = 3; index <=  12; index+=3){
            bike.accelerate();
        }
        assertEquals(42, bike.getCurrentSpeed());
        assertEquals(4, bike.currentGear());
    }
}