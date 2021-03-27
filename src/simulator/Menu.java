package simulator;

import java.util.Scanner;

/**
 * 
 */
public class Menu {
  private static Scanner scan = new Scanner(System.in);
  private static VehiclesList vehicles = new VehiclesList();
  private static IdList vehiclesIds = new IdList();

  /**
   * This function request the user a Vehicle's Id and validate if the array
   * contains it or not.
   * 
   * @return Id scanned by user
   */
  public int requestVehicleId() {
    int Id;
    do {
      System.out.println("Informe o id do veículo:");
      Id = scan.nextInt();
      if (!vehiclesIds.contains(Id)) {
        System.out.printf("O id %d não existe. ", Id);
      }
    } while (!vehiclesIds.contains(Id));
    return Id;
  }

  public void includeVehicle() {
    int tankCapacity;
    do {
      System.out.println("Informe a capacidade em litros no tanque:");
      tankCapacity = scan.nextInt();
      if (tankCapacity > 0) {
        System.out.println(vehicles.add(tankCapacity, vehiclesIds) ? "Veículo adicionado com sucesso"
            : "Já foi inserido 20 veículos, infelizmente não há mais espaço.");
      } else {
        System.out.println("Informe uma capacidade positiva!");
      }
    } while (tankCapacity <= 0);
  }

  public void removeVehicle() {
    int Id = requestVehicleId();
    if (vehiclesIds.remove(Id)) {
      System.out.println(vehicles.remove(Id) ? "Veículo removido com sucesso." : "Ocorreu um erro ao remover.");
    }

  }

  public void fuelVechicle() {
    System.out.println("Bem vindo ao Auto-posto dois alunos!");
    int Id = requestVehicleId();
    PopularCar vehicle = vehicles.searchById(Id);
    double currentGasAmout = vehicle.getGasAmount();
    double tankCapacity = vehicle.getTankCapacity();
    System.out.printf("Há %.2f litros no tanque. Informa a quantia de combustível para abastecer: ", currentGasAmout);
    double loaderGasAmount = scan.nextDouble();
    if (loaderGasAmount + currentGasAmout > tankCapacity) {
      char option;
      do {
        System.out.printf(
            "A quantidade informada excede a capacidade no tanque. Deseja completar com %.2f litros? (s/N)",
            tankCapacity - currentGasAmout);
        option = scan.next().charAt(0);
        System.out.println(option);
        if (option == 's') {
          System.out.println(vehicle.fuel() ? "Veículo abastecido com sucesso"
              : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
        } else if (option == 'n') {
          System.out.println("O véiculo não foi abastecido!");
        } else {
          System.out.println("Informe uma opção valida! (N para não ou S para sim)");
        }
      } while (option != 's' && option != 'n');

    }
    vehicle.fuel(loaderGasAmount + currentGasAmout > tankCapacity ? tankCapacity - currentGasAmout : loaderGasAmount);
    System.out.println("Volte sempre!");
  }

  public void runVehicle() {
    int Id = requestVehicleId();
    PopularCar vehicle = vehicles.searchById(Id);
    System.out.println(vehicle.run() ? "O veículo foi movido com sucesso" : "Occoreu um erro durante a movimentação");
  }

  public void runVehicles() {
    for (PopularCar vehicle : vehicles.getVehicles()) {
      if (vehicle != null) {
        if (!vehicle.run()) {
          System.out.printf("Occoreu um erro durante a movimentação do veículo com id %d\n", vehicle.getId());
        }
      }
    }
    System.out.println("Os veículos foram movidos");
  }

  public void decalibrateWheel() {
    int Id = requestVehicleId();
    PopularCar vehicle = vehicles.searchById(Id);
    System.out.println(
        "Qual das rodas deseja descalibrar\n0 para dianteira direita\n1 pra dianteira esquerda\n2 para traseira direita\n3 para traseira esquerda\n");
    int wheelIndex = scan.nextInt();
    System.out.println(
        vehicle.decalibrateWheel(wheelIndex) ? "Roda descalibrada com successo" : "Houve uma falha ao descalibrar!");

  }

  public void calibrateWheel() {
    int Id = requestVehicleId();
    PopularCar vehicle = vehicles.searchById(Id);
    System.out.println(
        "Qual das rodas deseja calibrar\n0 para dianteira direita\n1 pra dianteira esquerda\n2 para traseira direita\n3 para traseira esquerda\n");
    int wheelIndex = scan.nextInt();
    System.out
        .println(vehicle.calibrateWheel(wheelIndex) ? "Roda calibrada com successo" : "Houve uma falha ao calibrar!");

  }

  public void calibrateAllVeihiclesWheels() {
    for (PopularCar vehicle : vehicles.getVehicles()) {
      if (vehicle != null) {
        for (int wheelIndex = 0; wheelIndex <= 3; wheelIndex++) {
          if (!vehicle.calibrateWheel(wheelIndex)) {
            System.out.printf("Occoreu um erro ao calibar a roda %d do carro com id %d", wheelIndex, vehicle.getId());
          }
        }
      }
    }
    System.out.println("Efetuado a calibragem de todos os veículos");

  }

  /**
   * This function lists all vehicle information
   */
  public void listVehicles() {

    for (PopularCar vehicle : vehicles.getVehicles()) {
      if (vehicle != null) {
        System.out.printf("\n\nApresentando veículo de id %d\n", vehicle.getId());
        System.out.println(vehicle.toString());
      }
    }
  }

  public void showVehicles() {
    PopularCar[] veihiclesArray = vehicles.getVehicles();
    for (int i = 0; i < veihiclesArray.length && veihiclesArray[i] != null; i++) {
      veihiclesArray[i].printVehicle(i);
    }
  }
}
