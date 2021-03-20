package vehicles;

import java.util.Scanner;

public class Menu {
  private static Scanner input = new Scanner(System.in);
  private static PopularCar[] vehicles = new PopularCar[20];
  private static IdList vehiclesIds = new IdList();

  public static int requestId() {
    System.out.print("\nInforme o id do carro: ");
    int id = input.nextInt();

    return id;
  }

  public static void menu() {

    int opcao = 0;

    do {
      System.out.println("1) Incluir veículo");
      System.out.println("2) Remover veículo");
      System.out.println("3) Abastecer veículo");
      System.out.println("4) Movimentar veículo");
      System.out.println("5) Movimentar todos os veículos");
      System.out.println("6) Imprimir todos os dados de todos os veículos");
      System.out.println("7) Esvaziar pneu de veiculo");
      System.out.println("8) Calibrar pneu de veiculo");
      System.out.println("9) Calibrar todos os pneus dos veiculos");
      System.out.println("10) Imprimir pista");
      System.out.println("11) Sair");
      System.out.print("Opção: ");

      opcao = input.nextInt();

      switch (opcao) {
        case 1: {
          includeVehicle();
          break;
        }
        case 2: {

          break;
        }
        case 3: {

          break;
        }
        case 4: {

          break;
        }
        case 5: {

          break;
        }
        case 6: {

          break;
        }
        case 7: {

          break;
        }
        case 8: {

          break;
        }
        case 9: {

          break;
        }
        case 10: {

          break;
        }
        case 11: {
          System.exit(1);
          break;
        }
        default: {
          System.out.println("Informe uma opção válida!");

        }
      }

      System.out.flush();
    } while (opcao != 11);
  }

  private static void includeVehicle() {
    System.out.println("Informe a quantidade de litros no tanque:");
    int tankCapacity = input.nextInt();
    vehicles[vehicles.length] = new PopularCar(vehiclesIds, tankCapacity);
  }
}
