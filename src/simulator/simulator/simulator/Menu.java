
//Trabalho dos alunos Jefeson Souza e Luiz Henrique Vicari

package simulator;

import java.util.Scanner;


public class Menu {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Simulador simulador = new Simulador();
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

            opcao = scan.nextInt();

            switch (opcao) {
            case 1: {
                simulador.includeVehicle();
                break;
            }
            case 2: {
                simulador.removeVehicle();
                break;
            }
            case 3: {
                simulador.fuelVechicle();
                break;
            }
            case 4: {
                simulador.runVehicle();
                break;
            }
            case 5: {
                simulador.runVehicles();
                break;
            }
            case 6: {
                simulador.listVehicles();
                break;
            }
            case 7: {
                simulador.decalibrateWheel();
                break;
            }
            case 8: {
                simulador.calibrateWheel();
                break;
            }
            case 9: {
                simulador.calibrateAllVeihiclesWheels();
                break;
            }
            case 10: {
                simulador.showVehicles();
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
            // System.out.print("\033[H\033[2J");
            System.out.flush();
        } while (opcao != 11);
    }
}

