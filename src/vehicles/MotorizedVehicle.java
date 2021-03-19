package vehicles;

public abstract class MotorizedVehicle extends Vehicle{
    //Var to control if the IPVA (tax) is paid
    boolean paidIPVA;
    //The max capacity of the tank
    double maxTank;
    //The amount of gas in the tank
    double gasAmount;

    public MotorizedVehicle(int wheels, int id, boolean paidIPVA, double maxTank, double gasAmount) {
        super(wheels, id);
        this.paidIPVA = paidIPVA;
        this.maxTank = maxTank;
        this.gasAmount = gasAmount;
    }
}
