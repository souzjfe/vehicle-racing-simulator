//Trabalho dos alunos Jefeson Souza e Luiz Henrique Vicari

package simulator;

public class VehiclesList {
  private PopularCar[] vehicles;

  public PopularCar[] getVehicles() {
    return vehicles;
  }

  public void setVehicles(PopularCar[] vehicles) {
    this.vehicles = vehicles;
  }

  /**
   * This function add a vehicle in the array
   * 
   * @param tankCapacity is the maximum fuel capacity of the vehicle
   * @param vehiclesIds  is the list of Vehicle's id, used for verify the
   *                     existence of id
   * @return true or false according to the success of the function
   */
  public boolean add(int tankCapacity, IdList vehiclesIds) {
    // verifica se o vetor ainda nao foi criado e entao cria
    if (this.vehicles == null) {
      this.vehicles = new PopularCar[1];
      //cira o novo veiculo e passa pro vetor
      this.vehicles[0] = new PopularCar(vehiclesIds, tankCapacity);
      //retorna o sucesso da funcao
      return true;
    } else {
      //criar um novo vetor auxiliar e informar o novo tamanho dele
      PopularCar[] newVehiclesList = new PopularCar[this.vehicles.length + 1];
      int i;
      //percorrer o vetor antigo atualizando o novo
      for (i = 0; i < this.vehicles.length; i++) {
        newVehiclesList[i] = this.vehicles[i];
      }
      //verifico se excede a capacidade
      if (i < 20) {
        //crio o novo veiculo e passo para o novo vetor
        newVehiclesList[i] = new PopularCar(vehiclesIds, tankCapacity);
        //atualizo o vetor da classe com o vetor criado
        this.vehicles = newVehiclesList;
        return true;
      } else
        return false;
    }
  }

  /**
   * This function add a vehicle in the array
   * 
   * @param tankCapacity is the maximum fuel capacity of the vehicle
   * @param vehiclesIds  is the list of Vehicle's id, used for verify the
   *                     existence of id
   * @param amount it's the amount of vehicles to be created  
   * @return true or false according to the success of the function
   */
  public boolean add(int tankCapacity, IdList vehiclesIds, int amount) {

    // verifica se o vetor ainda nao foi criado e entao cria
    if (this.vehicles == null) {
      //crio o novo veiculo
      this.vehicles = new PopularCar[amount];
      //percorro a quantidade a ser criada e passo para o vetor
      for (int i = 0; i < amount; i++) {
        this.vehicles[i] = new PopularCar(vehiclesIds, tankCapacity);
      }
      return true;
      //verifico se excede a capacidade
    } else if (amount + this.vehicles.length <= 20) {
      // crio o novo vetor de veiculos auxiliar com tamanho antigo mais a quantidade a ser inserida
      PopularCar[] newVehiclesList = new PopularCar[this.vehicles.length + amount];
      int i;
      //percorro o voetor antigo e atualizo
      for (i = 0; i < this.vehicles.length; i++) {
        newVehiclesList[i] = this.vehicles[i];
      }
      // populo o novo vetor de acordo com a quantidade a ser inserida
      for (; i < this.vehicles.length + amount; i++) {
        newVehiclesList[i] = new PopularCar(vehiclesIds, tankCapacity);
      }
      //atualizo o vetor da classe
      this.vehicles = newVehiclesList;
      return true;
    } else
      return false;
  }

  /**
   * This function find a vehicle according the informed id and return your index
   * 
   * @param Id is the Vehicle's identification for search
   * @return the index of Vehicle's Id informed or -1 if id not found
   */
  public int indexOfId(int Id) {
    for (int i = 0; i < this.vehicles.length; i++)
      if (this.vehicles[i].getId() == Id)
        return i;
    return -1;
  }

  /**
   * This function removes the vehicle from the given id
   * 
   * @param Id is the Vehicle's identification for remove
   * @return true or false according to the success of the function
   */
  public boolean remove(int Id) {
    // verifica se o vetor ainda nao existe
    if (this.vehicles == null) {
      return false;
    } else {
      //procura o indice do veiculo informado
      int index = indexOfId(Id);
      //vericica se o indice eh valido
      if (index >= 0) {
        //crio o novo vetor com tamanho do vetor menos 1
        PopularCar[] newVehiclesList = new PopularCar[this.vehicles.length - 1];
        int i;
        //percorro o vetor ate chegar no indice a ser excluido
        for (i = 0; i < index; i++) {
          newVehiclesList[i] = this.vehicles[i];
        }
        // sobreponho o indice do vetor com o proximo e assim por diante
        for (; index < this.vehicles.length - 1; index++) {
          newVehiclesList[index] = this.vehicles[index + 1];
        }
        //atualizo o vetor da classe
        this.vehicles = newVehiclesList;
        return true;
      } else
        return false;
    }

  }

  /**
   * This function find the vehicle with informed id.
   * 
   * @param Id Identification number of vehicle.
   * @return The vehicle found.
   */
  public PopularCar searchById(int Id) {
    for (PopularCar vehicle : this.vehicles)
      if (vehicle.getId() == Id)
        return vehicle;
    System.out.println("Veículo não encontrado.");
    return null;
  }
}
