package vehicles;
import java.util.Random;

public final class PopularCar{
    private double gasAmount;
    private double tankCapacity;
    private boolean paidIPVA;
    private Wheel[] wheels = new Wheel[4];
    private int id;
    private int runned;

    //Método para encher o tanque
    public void fuel() {
        //Atualiza a quantidade de gás no tanque
        this.setGasAmount(this.getTankCapacity());
        System.out.println("Tanque abastecido, combustível atual: " + this.getGasAmount() + "L");
    }

    //Método para colocar uma certa porcentagem do tanque
    public void fuel(int percentage) {
        this.setGasAmount(this.getTankCapacity() * percentage / 100);
        System.out.println("Tanque abastecido, combustível atual: " + this.getGasAmount() + "L");
    }

    //Método para colocar uma quantidade definida de gasolina no tanque
    public void fuel(double gasAmount) {
        if(gasAmount > tankCapacity)
            System.out.println("Não é possível abastecer mais que a capacidade do tanque.");

        else {
            this.setGasAmount(gasAmount);
            System.out.println("Tanque abastecido, combustível atual: " + this.getGasAmount() + "L");
        }
    }

    //Método para desabastecer a gasolina do carro
    public void runOut(double consumption) {
        this.setGasAmount(this.getGasAmount() - consumption);
    }

    //Método para pagar o IPVA
    public void payIPVA() {
        this.setPaidIPVA(true);
    }

    //Método para calibrar todos os pneus
    public void calibrateWheel() {
        for(Wheel wheel : this.wheels) {
            wheel.calibrate();
        }
    }

    //Método para calibrar um pneu específico
    public void calibrateWheel(int number) {
        if(number < 0 || number > 3)
            System.out.println("Não é possível calibrar o pneu");

        else
            this.wheels[number].calibrate();
    }

    //Função para descalibrar um pneu
    public void decalibrateWheel(int number) {
        if(number < 0 || number > 3)
            System.out.println("Não é possível descalibrar o pneu");

        else
            this.wheels[number].calibrate();
    }

    //Função para imprimir o carro na tela
    public boolean isAbleToRun() {
        //Verifica se há alguma roda descalibrada
        for(Wheel i : this.wheels)
            //Se encontrar alguma roda descalibrata, retorna falso
            if(!i.isCalibrated())
                return false;

        //Se o IPVA não estiver pago, retorna falso
        if(!this.isPaidIPVA())
            return false;

        //Se o carro não tiver combustivel, retorna falso
        if(this.getGasAmount() == 0)
            return false;

        return true;
    }

    //Função para printar o carro na tela (formato sugerido pela professora)
    public void printVehicle() {
        System.out.println("    ____          ");
        System.out.println(" __/  |_ \\_      ");
        System.out.println("|  _     _``-.    ");
        System.out.println("'-(_)---(_)--'\n\n");
    }

    //Método para execuar quando o carro correr
    public void run() {
        if(this.isAbleToRun()) {
        //Aumenta a quantidade de blocos percorridos
        this.setRunned(this.getRunned() + 5);
        //Consome a gasolina
        this.runOut(0.55); 
        }
    }

    //Métodos base como construtor, getters e setters
    //Contrutor para o carro
    public PopularCar(IdList idList, double tankCapacity) {
        this.setId(idList);
        this.fuel(3.5);
        this.runned = 0;
        this.tankCapacity = tankCapacity;
        this.setPaidIPVA();
        for (int i = 0; i < 4; i++) {
            this.wheels[i] = new Wheel();
        }
    }

    //Getter para o ID
    public int getId() {
        return id;
    }

    //Setter para o id do carro
    private void setId (IdList idList){
        //Inicia um laço para validar um ID único 
        do {
            //Cria um objeto do tipo Random
            Random rand = new Random();
            //Recebe aleatóriamente um valor e o transforma em um id de 5 dígitos
            this.id = 10000 + rand.nextInt(90000);
        } while (idList.contains(this.getId())); //Verificar se o valor já está na lista de IDs

        //Adiciona o id dentro da lista de IDs
        idList.add(this.getId());
    }

    //Getter para as rodas do carro
    public Wheel[] getWheels() {
        return wheels;
    }

    //Setter para as rodas
    public void setWheels(Wheel[]wheels) {
        this.wheels = wheels;
    }

    //Getter para a quantidade de gasolina
    public double getGasAmount() {
        return gasAmount;
    }

    //Setter para a quantidade de gasolina no carro
    private void setGasAmount(double gasAmount) {
        this.gasAmount = gasAmount;
    }

    //Getter da capacidade do tanque
    public double getTankCapacity() {
        return tankCapacity;
    }

    //Getter para dizer se o IPVA está pago ou não
    public boolean isPaidIPVA() {
        return paidIPVA;
    }

    //Setter para definir aleatóriamente se o IPVA está pago ou não
    private void setPaidIPVA() {
        Random rand = new Random();
        this.paidIPVA = rand.nextBoolean();
    }

    //Setter para definir se o IPVA do carro está pago ou não 
    private void setPaidIPVA(boolean paidIPVA) {
        this.paidIPVA = paidIPVA;
    }

    //Getter para a variável runned
    private int getRunned() {
        return this.runned;
    }

    //Setter para a variável runned
    private void setRunned(int runned) {
        this.runned = runned;
    }

    //Método para passar todos os dados do objeto da classe Popularcar para string
    public String toString() {
        return "Id: " + this.getId() + "\n" + "Calibragem das rodas: " + this.getWheels() + "\n" + "O IPVA está pago?" + this.isPaidIPVA() + "\n" + "Quantidade de gasolina no tanque: " + this.getGasAmount() + "L\n" + "Capacidade do tanque: " + this.getTankCapacity() +"L\n" + "Blocos de texto andados: " + runned;
    }
}