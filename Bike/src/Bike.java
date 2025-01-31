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

    public void decelerate() {
            if (currentGear == 1) {
                currentSpeed -= 1;
            } else if (currentGear == 2) {
                currentSpeed -= 2;
            } else if (currentGear == 3) {
                currentSpeed -= 3;
            } else if (currentGear == 4) {
                currentSpeed -= 4;
            }
            currentSpeed = Math.max(currentSpeed, 0);
            updateGear();
    }

    private void updateGear() {
        if (currentSpeed > 40) {
            currentGear = 4;
        } else if (currentSpeed > 30) {
            currentGear = 3;
        } else if (currentSpeed > 20) {
            currentGear = 2;
        } else if (currentSpeed > 0) {
            currentGear = 1;
        } else {
            currentGear = 1;
        }
    }
}