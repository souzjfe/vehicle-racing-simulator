package simulator;

import java.util.Scanner;

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
    int amountVehicles;
    int vechiclesLength = vehicles.getVehicles() != null ? vehicles.getVehicles().length : 0;
    do {
      System.out.println("Informe quantos veículos deseja incluir");
      amountVehicles = scan.nextInt();
      if (amountVehicles + vechiclesLength > 20) {
        char option;
        do {
          System.out.printf("A quantidade ultrapassa o limite permitido (20)\nDeseja incluir %d veículos? s/N",
              20 - vechiclesLength);
          option = scan.next().toLowerCase().charAt(0);
          if (option == 's') {
            amountVehicles = 20 - vechiclesLength;
          } else if (option == 'n') {
            System.out.println("Nenhum veículo incluido.");
          } else {
            System.out.println("Informe uma opção valida! (N para não ou S para sim)");
          }
        } while (option != 's' && option != 'n');
      } else if (amountVehicles < 0) {
        System.out.println("Informe uma quantidade positiva!");
      }
    } while (amountVehicles < 0 || amountVehicles + vechiclesLength > 20);
    if (amountVehicles + vechiclesLength <= 20) {
      do {
        System.out.println("Informe a capacidade em litros no tanque:");
        tankCapacity = scan.nextInt();
        if (tankCapacity > 0) {
          if (amountVehicles > 1) {
            System.out
                .println(vehicles.add(tankCapacity, vehiclesIds, amountVehicles) ? "Veículos adicionados com sucesso"
                    : "Occoreu um erro ao incluir");
          } else {
            System.out.println(vehicles.add(tankCapacity, vehiclesIds) ? "Veículo adicionado com sucesso"
                : "Occoreu um erro ao incluir");
          }
        } else {
          System.out.println("Informe uma capacidade positiva!");
        }
      } while (tankCapacity <= 0);
    }
  }

  public void removeVehicle() {
    int Id = requestVehicleId();
    if (vehiclesIds.remove(Id)) {
      System.out.println(vehicles.remove(Id) ? "Veículo removido com sucesso." : "Ocorreu um erro ao remover.");
    } else {
      System.out.println("ocorreu um erro ao remover o Id. Veículo não foi removido.");
    }

  }

  public void fuelVechicle() {
    System.out.println("Bem vindo ao Auto-posto dois alunos!");
    int Id = requestVehicleId();
    PopularCar vehicle = vehicles.searchById(Id);
    double currentGasAmout = vehicle.getGasAmount();
    double tankCapacity = vehicle.getTankCapacity();
    
    char fuelOption;
    do {
      System.out.printf(
          "Há %.2f litros no tanque. Informe a forma de abastecimento:\n C para completo\n P para informar em porcentagem\n L para informar em litros \n:",
          currentGasAmout);
      fuelOption = scan.next().toLowerCase().charAt(0);
      if (fuelOption == 'c') {
        System.out.println(vehicle.fuel() ? "Veículo abastecido com sucesso"
            : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
      } else if (fuelOption == 'p') {
        int gasPercent;
        do {
          System.out.println("Informe a porcentagem do tanque que deve ser abastecida:");
          gasPercent = scan.nextInt();
          if (gasPercent < 0) {
            System.out.println("Porcentagem deve ser positiva!");
          } else if (gasPercent > 100) {
            System.out.println("Não eh possivel abastecer mais que 100%");
          } else {
            if(gasPercent / 100 * tankCapacity + currentGasAmout > tankCapacity){
              char option;
              do {
                System.out.printf(
                    "A quantidade informada excede a capacidade no tanque. Deseja completar com %.2f litros? (s/N)",
                    tankCapacity - currentGasAmout);
                option = scan.next().toLowerCase().charAt(0);
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
            else{
              System.out.println(vehicle.fuel(gasPercent)? "Veículo abastecido com sucesso"
              : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
            }
          }

        } while (gasPercent < 0 || gasPercent > 100);

      } else if (fuelOption == 'l') {
        System.out.println("Informe a quantia em litros do tanque que deve ser abastecida:");
        double gasAmount = scan.nextDouble();
        if (gasAmount + currentGasAmout > tankCapacity) {
          char option;
          do {
            System.out.printf(
                "A quantidade informada excede a capacidade no tanque. Deseja completar com %.2f litros? (s/N)",
                tankCapacity - currentGasAmout);
            option = scan.next().toLowerCase().charAt(0);
            if (option == 's') {
              System.out.println(vehicle.fuel() ? "Veículo abastecido com sucesso"
                  : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
            } else if (option == 'n') {
              System.out.println("O véiculo não foi abastecido!");
            } else {
              System.out.println("Informe uma opção valida! (N para não ou S para sim)");
            }
          } while (option != 's' && option != 'n');

        } else {
          System.out.println(vehicle.fuel(gasAmount)? "Veículo abastecido com sucesso"
          : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
          
        }
        System.out.println("Volte sempre!");
      }

      else {
        System.out.println("Informe uma opção valida!");
      }
    } while (fuelOption != 'c' && fuelOption != 'p' && fuelOption != 'l');

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
        "Qual das rodas deseja descalibrar\n0 para dianteira direita\n1 pra dianteira esquerda\n2 para traseira direita\n3 para traseira esquerda\n4 para todas");
    int wheelIndex = scan.nextInt();
    System.out.println(
        vehicle.decalibrateWheel(wheelIndex) ? "Roda descalibrada com successo" : "Houve uma falha ao descalibrar!");

  }

  public void calibrateWheel() {
    int Id = requestVehicleId();
    PopularCar vehicle = vehicles.searchById(Id);
    System.out.println(
        "Qual das rodas deseja calibrar\n0 para dianteira direita\n1 pra dianteira esquerda\n2 para traseira direita\n3 para traseira esquerda\n4 para todas");
    int wheelIndex = scan.nextInt();
    System.out.println(vehicle.calibrateWheel(wheelIndex <= 3 ? wheelIndex : null) ? "Roda calibrada com successo"
        : "Houve uma falha ao calibrar!");

  }

  public void calibrateAllVeihiclesWheels() {
    for (PopularCar vehicle : vehicles.getVehicles()) {
      if (!vehicle.calibrateWheel()) {
        System.out.printf("Occoreu um erro ao calibar o carro com id %d", vehicle.getId());
      }
    }
    System.out.println("Efetuado a calibragem de todos os veículos");

  }

  /**
   * This function lists all vehicle information
   */
  public void listVehicles() {
    PopularCar[] vehiclesArray = vehicles.getVehicles();
    if (vehiclesArray.length > 0) {
      for (PopularCar vehicle : vehiclesArray) {
        System.out.printf("\n\nApresentando veículo de id %d\n", vehicle.getId());
        System.out.println(vehicle.toString());
      }
    } else {
      System.out.println("Nenhum veículo existente para ser exibido.");
    }
  }

  public void showVehicles() {
    PopularCar[] vehiclesArray = vehicles.getVehicles();
    if (vehiclesArray.length > 0) {
      for (int i = 0; i < vehiclesArray.length; i++) {
        vehiclesArray[i].printVehicle(i);
      }
    } else {
      System.out.println("Nenhum veículo existente para ser exibido.");
    }
  }
}
