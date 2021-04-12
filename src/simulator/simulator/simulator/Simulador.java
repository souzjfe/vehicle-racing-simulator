//Trabalho dos alunos Jefeson Souza e Luiz Henrique Vicari

package simulator;

import java.util.Scanner;

public class Simulador {
  private static Scanner scan = new Scanner(System.in);
  private static VehiclesList vehicles = new VehiclesList();
  private static IdList vehiclesIds = new IdList();



  /**
   * This function request the user a Vehicle's Id and validate if the array
   * contains it or not.
   * A função pede para o usuário um id de vaículo e valida se o array possui ele ou não 
   * 
   * @return Id scanned by user (id informado pelo usuário)
   */
  public int requestVehicleId() {
    int Id;
    //Valida até que o id informado pelo usuário esteja no array
    do {
      System.out.println("Informe o id do veículo:");
      Id = scan.nextInt();
      //Procura o id no array de ids
      if (!vehiclesIds.contains(Id)) {
        //Se não encontrar, informa o erro
        System.out.printf("O id %d não existe. ", Id);
      }
    } while (!vehiclesIds.contains(Id));
    return Id;
  }

  /**
   * This function includes a vehicle in the array of vehicles
   * A função insere um veículo no array de veículos
   */
  public void includeVehicle() {
    int tankCapacity;
    int amountVehicles;
    //Por if ternário, informa a quantidade de veículos no array
    int vechiclesLength = vehicles.getVehicles() != null ? vehicles.getVehicles().length : 0;
    do {
      //Recebe a quantidade de vaículos a serem criados
      System.out.println("Informe quantos veículos deseja incluir");
      amountVehicles = scan.nextInt();
      //Verifica se cabe a quantidade de veículos no array (não pode ultrapassar 20)
      if (amountVehicles + vechiclesLength > 20) {
        char option;
        do {
          //Pergunta se o usuário deseja incluir a quantidade de veículos restante no array
          System.out.printf("A quantidade ultrapassa o limite permitido (20)\nDeseja incluir %d veículos? s/N",
              20 - vechiclesLength);
          option = scan.next().toLowerCase().charAt(0);
          //Se o usuário escolher preencher o array, coloca n veículos no vetor, se não, informa que não foi incluído nenhum veículo, se a opção for inválida, informa o usuário
          if (option == 's') {
            amountVehicles = 20 - vechiclesLength;
          } else if (option == 'n') {
            System.out.println("Nenhum veículo incluido.");
          } else {
            System.out.println("Informe uma opção valida! (N para não ou S para sim)");
          }
        } while (option != 's' && option != 'n');
      }
      //Se a quantidade informada for negativa, informa o usuário para informar de novo
      else if (amountVehicles < 0) {
        System.out.println("Informe uma quantidade positiva!");
      }
    } while (amountVehicles < 0 || amountVehicles + vechiclesLength > 20);
    if (amountVehicles + vechiclesLength <= 20) {
      do {
        //Recebe a capacidade do tanque de combustível
        System.out.println("Informe a capacidade em litros no tanque:");
        tankCapacity = scan.nextInt();
        if (tankCapacity > 0) {
          //Informa o usuário se os veículos foram incluidos ou se houve um erro
          if (amountVehicles > 1) {
            System.out
                .println(vehicles.add(tankCapacity, vehiclesIds, amountVehicles) ? "Veículos adicionados com sucesso"
                    : "Occoreu um erro ao incluir");
          } else {
            System.out.println(vehicles.add(tankCapacity, vehiclesIds) ? "Veículo adicionado com sucesso"
                : "Occoreu um erro ao incluir");
          }
        }
        //Avisa o usário se for informada uma capacidade do tanque negativa 
        else {
          System.out.println("Informe uma capacidade positiva!");
        }
      } while (tankCapacity <= 0);
    }
  }

  /**
   * Removes a vehicle from the array
   */
  public void removeVehicle() {
    //Recebe o Id desejado
    int Id = requestVehicleId();
    //Remove o Id e informa se a remoção funcionou ou não
    if (vehiclesIds.remove(Id)) {
      System.out.println(vehicles.remove(Id) ? "Veículo removido com sucesso." : "Ocorreu um erro ao remover.");
    } else {
      System.out.println("ocorreu um erro ao remover o Id. Veículo não foi removido.");
    }

  }

  /**
   * Fuels the tank of the vehicle
   * Enche o tanque de combustível
   */
  public void fuelVechicle() {
    System.out.println("Bem vindo ao Auto-posto dois alunos!");
    //Recebe o Id do veículo
    int Id = requestVehicleId();
    //A variável recebe o veículo procurado
    PopularCar vehicle = vehicles.searchById(Id);
    double currentGasAmout = vehicle.getGasAmount();
    double tankCapacity = vehicle.getTankCapacity();
    
    //Encontra qual das opções de abastecimento o usuário deseja utilizar
    char fuelOption;
    do {
      System.out.printf(
          "Há %.2f litros no tanque. Informe a forma de abastecimento:\n C para completo\n P para informar em porcentagem\n L para informar em litros \n:",
          currentGasAmout);
      fuelOption = scan.next().toLowerCase().charAt(0);
      //Chama por sobrecarga o método para completar o combustível no tanque
      if (fuelOption == 'c') {
        System.out.println(vehicle.fuel() ? "Veículo abastecido com sucesso"
            : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
      } 
      //Chama por sobrecarga o método para abastecer uma certa porcentagem do tanque
      else if (fuelOption == 'p') {
        int gasPercent;
        //Valida para uma porcentagem válida (0 < p <= 100)
        do {
          System.out.println("Informe a porcentagem do tanque que deve ser abastecida:");
          gasPercent = scan.nextInt();
          if (gasPercent < 0) {
            System.out.println("Porcentagem deve ser positiva!");
          } else if (gasPercent > 100) {
            System.out.println("Não eh possivel abastecer mais que 100%");
          } else {
            //Verfica para não abastecer mais do que cabe no tanque
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
            //Informa se o veículo foi abastecido com sucesso ou não
            else{
              System.out.println(vehicle.fuel(gasPercent)? "Veículo abastecido com sucesso"
              : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
            }
          }

        } while (gasPercent < 0 || gasPercent > 100);
      }
      //Abastece uma quantidade x no tanque 
      else if (fuelOption == 'l') {
        //Recebe a quantidade a ser abastecida
        System.out.println("Informe a quantia em litros do tanque que deve ser abastecida:");
        double gasAmount = scan.nextDouble();
        //Verifica se ultrapassa a capacidade do tanque
        if (gasAmount + currentGasAmout > tankCapacity) {
          char option;
          do {
            System.out.printf(
                "A quantidade informada excede a capacidade no tanque. Deseja completar com %.2f litros? (s/N)",
                tankCapacity - currentGasAmout);
            option = scan.next().toLowerCase().charAt(0);
            if (option == 's') {
              //Abastece o veículo e informa se foi bem sucessedido ou não
              System.out.println(vehicle.fuel() ? "Veículo abastecido com sucesso"
                  : "Occoreu um erro durante o abastecimento. Tente novamente mais tarde.");
            } else if (option == 'n') {
              System.out.println("O véiculo não foi abastecido!");
            } else {
              //Informa o usuário que não foi informada uma opção válida
              System.out.println("Informe uma opção valida! (N para não ou S para sim)");
            }
          } while (option != 's' && option != 'n');

        } else {
          //Abastece o vaículo e informa o usuário que foi abastecido com sucesso
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

  /**
   * Makes a certain vehicle run
   * Faz um determinado veículo correr
   */
  public void runVehicle() {
    //Recebe o id do veículo
    int Id = requestVehicleId();
    //Recebe o vaículo com o id informado
    PopularCar vehicle = vehicles.searchById(Id);
    //Move o carro e informa o usuário se funcionou ou não
    System.out.println(vehicle.run() ? "O veículo foi movido com sucesso" : "Occoreu um erro durante a movimentação");
  }

  /**
   * Moves all vehicles
   * Move todos os veículos
   */
  public void runVehicles() {
    //Recebe todos os veículos no arranjo e faz eles se moverem
    for (PopularCar vehicle : vehicles.getVehicles()) {
      //Verifica se o veículo existe
      if (vehicle != null) {
        //Move o veículo e informa o usuário caso algo dê errado
        if (!vehicle.run()) {
          System.out.printf("Occoreu um erro durante a movimentação do veículo com id %d\n", vehicle.getId());
        }
      }
    }
    //Informa que o processo terminou
    System.out.println("Os veículos foram movidos");
  }

  /**
   * Decalibrates a wheel
   * Descalibra uma roda
   */
  public void decalibrateWheel() {
    //Recebe o id do veículo
    int Id = requestVehicleId();
    //Recebe o veículo com o id infomrado
    PopularCar vehicle = vehicles.searchById(Id);
    //Recebe a roda a ser calibrada
    System.out.println(
        "Qual das rodas deseja descalibrar\n0 para dianteira direita\n1 pra dianteira esquerda\n2 para traseira direita\n3 para traseira esquerda\n4 para todas");
    int wheelIndex = scan.nextInt();
    //Chama o método para descalibrar a roda e informa o usuário se deu certo ou não
    System.out.println(
        vehicle.decalibrateWheel(wheelIndex) ? "Roda descalibrada com successo" : "Houve uma falha ao descalibrar!");

  }

  /**
   * Calibrates a wheel
   * Calibra uma roda
   */
  public void calibrateWheel() {
    //Faz o mesmo processo do método anterior, mas chama o método de calibrar a roda no final
    int Id = requestVehicleId();
    PopularCar vehicle = vehicles.searchById(Id);
    System.out.println(
        "Qual das rodas deseja calibrar\n0 para dianteira direita\n1 pra dianteira esquerda\n2 para traseira direita\n3 para traseira esquerda\n4 para todas");
    int wheelIndex = scan.nextInt();
    System.out.println(vehicle.calibrateWheel(wheelIndex <= 3 ? wheelIndex : null) ? "Roda calibrada com successo"
        : "Houve uma falha ao calibrar!");

  }

  /**
   * Calibrates all wheels of all the vehicles
   * Calibra todas as rodas de todos os veículos
   */
  public void calibrateAllVeihiclesWheels() {
    //Percorre o array de veículos
    for (PopularCar vehicle : vehicles.getVehicles()) {
      //Calibra a roda de todos os veículos e infomra o usuário caso ocorra algum erro
      if (!vehicle.calibrateWheel()) {
        System.out.printf("Occoreu um erro ao calibar o carro com id %d", vehicle.getId());
      }
    }
    //Informa que o processo terminou
    System.out.println("Efetuado a calibragem de todos os veículos");

  }

  /**
   * Lists all the informations about all the vehicles
   * Lista todas as informações de todos os veículos 
   */
  public void listVehicles() {
    //Recebe o arraqy de veículos
    PopularCar[] vehiclesArray = vehicles.getVehicles();
    //Verifica se existem veículos no array
    if (vehiclesArray.length > 0) {
      //Percorre o array chamando o método toString dos veículos
      for (PopularCar vehicle : vehiclesArray) {
        System.out.printf("\n\nApresentando veículo de id %d\n", vehicle.getId());
        System.out.println(vehicle.toString());
      }
    } else {
      //Informa que o array está vazio
      System.out.println("Nenhum veículo existente para ser exibido.");
    }
  }

  /**
   * Shows all the vehicles
   * Mostra todos os veículos
   * 
   */
  public void showVehicles() {
    //Faz o mesmo processo da função anterior, mas chama a função de imprimir os veículos na tela
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