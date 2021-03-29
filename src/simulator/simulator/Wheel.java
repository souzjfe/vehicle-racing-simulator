package simulator;
import java.util.Random;

public class Wheel {
    private boolean calibrated;

     /**
     * This method calibrates the wheel (sets calibrated true)
     * Esse método calibra a roda (define calibrated como true)
     */
    public void calibrate() {
        this.calibrated = true;
    }

    /**
     * This method decalibrates the wheel (sets calibrated false)
     * Esse método descalibra a roda (define calibrated como false)
     */
    public void decalibrate () {
        this.calibrated = false;
    }

    //Métodos bases (construtor, getters e  setters)
    //Construtor de Wheel
    public Wheel() {
        //Cria um objeto de classe Random
        Random rand = new Random();
        //Escolhe aleatóriamente se a roda estará ou não calibrada
        this.calibrated= rand.nextBoolean();
    }

    //Getter de calibrated
    public boolean isCalibrated() {
        return calibrated;
    }

    //Setter de calibrated
    public void setCalibrated(boolean calibrated) {
        this.calibrated = calibrated;
    }
    public String toString() {
        
        return (this.calibrated? "Calibrada": "Descalibrada");
    }
}
