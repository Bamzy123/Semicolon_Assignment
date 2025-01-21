import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AirConditionalTest {

    @Test
    public void testThatAirConditionIsOff() {
        AirConditional airCondition = new AirConditional();
        assertFalse(airCondition.power());
    }


    @Test
    public void testThatAirConditionCanBeOn() {
        AirConditional airCondition = new AirConditional();
        assertFalse(airCondition.power());
        airCondition.isOn();
        assertTrue(airCondition.power());
    }

    @Test
    public void testThatAirConditionCabBeTurnOffWhenItIsOn(){
        AirConditional airCondition = new AirConditional();
        assertFalse(airCondition.power());
        airCondition.isOn();
        assertTrue(airCondition.power());
        airCondition.isOff();
        assertFalse(airCondition.power());
    }

    @Test
    public void testThatAirConditionAtInitialMustBe16(){
        AirConditional airCondition = new AirConditional();
        assertFalse(airCondition.power());
        airCondition.isOn();
        airCondition.initial();
    }

    @Test
    public void testThatAirConditionCanIncrease(){
        AirConditional airCondition = new AirConditional();
        assertFalse(airCondition.power());
        airCondition.isOn();
        airCondition.increase();
    }

    @Test
    public void testThatAirConditionCanDecrease(){
        AirConditional airCondition = new AirConditional();
        assertFalse(airCondition.power());
        airCondition.isOn();
        airCondition.decrease();
    }

//    @Test
//    public void testThatWhenIncreaseBeyond30TemperatureIsStill30(){
//        AirConditional airCondition = new AirConditional();
//        assertFalse(airCondition.power());
//        airCondition.isOn();
//        for (int index = 0; index <= 30; index++) {
//            airCondition.increase();
//        }
//    }
}