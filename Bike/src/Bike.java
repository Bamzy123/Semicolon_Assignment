public class Bike {
     private boolean power;
    private int currentGear = 0;
    private int currentSpeed = 0;

    public boolean isPower() {
         return power;
     }
    public void isOff() {
         power = false;
         currentGear = 0;
         currentSpeed = 0;
    }

    public void isOn() {
         power = true;
    }


    public int currentGear() {
         return currentGear;
    }

    public void changeGear() {
        currentGear++;
    }

    public void accelerate() {
        if(currentGear==1) {
            currentSpeed++;
            if(currentSpeed==20) currentGear++;
        }

        else if(currentGear==2) {
            currentSpeed +=2;
            if(currentSpeed==30) currentGear++;
        }

        else if(currentGear==3) {
            currentSpeed +=3;
            if(currentSpeed>=40) currentGear++;
        }

        else if(currentGear==4) {
            currentSpeed +=4;
             currentSpeed++;
        }
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }
}