package vehicles;

public final class PopularCar extends MotorizedVehicle{

    public void print() {
        System.out.print("    ____\n");
        System.out.print(" __/  |_ \\_\n"); // \_\n");
        System.out.print("|  _     _``-.       Carro popular\n");
        System.out.print("'-(_)---(_)--'\n\n\n");
    }

    public PopularCar(int wheels, int id, boolean paidIPVA, double maxTank, double gasAmount) {
        super(4, id, paidIPVA, maxTank, gasAmount);
    }
}
