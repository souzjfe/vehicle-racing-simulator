package vehicles;
import java.util.Random;

public class Wheel {
    private boolean calibrated;

    public Wheel() {
        Random rand = new Random();
        this.calibrated= rand.nextBoolean();
    }

    public boolean isCalibrated() {
        return calibrated;
    }

    public void setCalibrated(boolean calibrated) {
        this.calibrated = calibrated;
    }

    public void calibrate() {
        this.calibrated = true;
    }

    public void decalibrate () {
        this.calibrated = false;
    }
}
