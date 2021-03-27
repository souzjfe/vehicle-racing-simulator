package simulator;

public class VehiclesList {
  private PopularCar[] vehicles = new PopularCar[20];
  public PopularCar[] getVehicles() {
    return vehicles;
  }
  public void setVehicles(PopularCar[] vehicles) {
    this.vehicles = vehicles;
  }
  public boolean add(int tankCapacity, IdList vehiclesIds) {
    int i;
    for (i = 0; i < this.vehicles.length && this.vehicles[i] != null; i++)
      ;
    if (i < this.vehicles.length) {
      vehicles[i] = new PopularCar(vehiclesIds, tankCapacity);
      return true;
    } else
      return false;
  }

  public int indexOfId(int Id) {
    for (int i = 0; i < this.vehicles.length && this.vehicles[i] != null; i++)
      if (this.vehicles[i].getId() == Id)
        return i;
    return -1;
  }

  public boolean remove(int Id) {
    int index = indexOfId(Id);
    if (index <= 0) {
      this.vehicles[index] = null;
      return true;
    } else {
      return false;
    }

  }

  public PopularCar searchById(int Id) {
    for (int i = 0; i < this.vehicles.length && this.vehicles[i] != null; i++)
      if (this.vehicles[i].getId() == Id)
        return this.vehicles[i];
    System.out.println("Veículo não encontrado.");
    return null;
  }
}
