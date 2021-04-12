//Trabalho dos alunos Jefeson Souza e Luiz Henrique Vicari

package simulator;

import java.util.Random;

public final class PopularCar {
    //Quantidade de gasolina no carro
    private double gasAmount;
    //Capacidade de gasolina no tanque do carro
    private double tankCapacity;
    //IPVA pago ou não
    private boolean paidIPVA;
    //Vetor com as rodas do carro
    private Wheel[] wheels = new Wheel[4];
    //Identificação do carro
    private int id;
    //Quantidade de blocos que o carro andou
    private int runned;

    /**
     * This method sets the gasAount in th e vehicle object to the maximum
     * (tankCapacity) Esse método define o gasAmount no objeto veículo para o máximo
     * (tankCapacity)
     * @return returns true is the vehicle was succesfully fueled (retorna verdadeiro se o carro foi abastecido com sucesso)
     */
    public boolean fuel() {
        // Atualiza a quantidade de gás no tanque
        this.gasAmount = this.tankCapacity;
        return true;
    }

    // Método para colocar uma certa porcentagem do tanque
    /**
     * This method sets the gasAmount in the vehicle object to a defined percentage
     * Esse método define o gasAmount no objeto veículo para uma porcentragem
     * definida
     * 
     * @param percentage the percentage of gas that the user wants the tank to have (a porcentagem de gasolina no tanque que o usuário deseja)
     * @return returns true is the vehicle was succesfully fueled, returns false if it can't be fueled (retorna true se o veículo foi abastecido, retorna false se ele não pode ser abastecido)
     */
    public boolean fuel(int percentage) {
        // Se a porcentagem for maior que 100, informa o erro e não abastece
        if (percentage > 100)
            return false;
        // Se a quantidade que será colocada for menor que a capacidade atual do tanque,
        // informa que não é possível deixar o carro com menos
        // gasolina do que ele já tem
        else if (percentage * this.tankCapacity < this.gasAmount)
            return false;
        // Se a porcentagem for negativa, informa que não é possível abastecer com
        // quantidade negativa
        else if (percentage < 0) {
            return false;
        }
        // Se passar em todos os testes, abastece o carro
        else {
            this.gasAmount = this.tankCapacity * percentage / 100;
            return true;
        }
    }

    // Método para colocar uma quantidade definida de gasolina no tanque
    /**
     * This method sets the gasAmount in the vehicle object to the current amount
     * plus the informed amount Esse método define o gasAmount no objeto veículo
     * para a quantidade atual mais a quantidade informada
     * 
     * @param gasAmount the amount of gas that will be added to the current one (a quantidade de gasolina que será adicionada)
     * @return returns true is the vehicle was succesfully fueled, returns false if it can't be fueled (retorna true se o veículo foi abastecido, retorna false se ele não pode ser abastecido)
     */
    public boolean fuel(double gasAmount) {
        // Verifica se a capacidade do tanque é menor que a quantidade desejada de
        // gasolina e avisa o erro
        if (gasAmount + this.gasAmount > this.tankCapacity)
            return false;
        // Verifica se a quantidade de gasolina informada é menor que 0 e avisa do erro
        else if (gasAmount < 0) {
            return false;
        }
        // Se for possível colocar a gasolina, ele abastece o carro
        else {
            this.gasAmount = gasAmount + this.gasAmount;
           return true;
        }
    }

    // Método para consumir a gasolina do carro
    /**
     * This method decreases the gasAmount according to the consumption
     * Esse método diminui o gasAMount de acordo com o consumo
     * @param consumptiom the amount of gas that will be consumed (a quantidade de gasolina que será consumida)
     */
    public void runOut(double consumption) {
        // Se a gasolina chegar a 0, como não é possível ter uma quantidade de gasolina
        // negativa, ele para de consumir e avisa que o carro está
        // sem combustível
        if (this.gasAmount - consumption <= 0) {
            this.gasAmount = 0;
        }
        // Se o carro ainda tiver gasolina o suficiente, ele consome o informado
        else this.gasAmount = this.gasAmount - consumption;
    }

    // Método para pagar o IPVA
    /**
     * This method defines the paidIPVA as true
     * Esse método define o paidIPVA como ture
     */
    public void payIPVA() {
        // Informa para o método getter que o IPVA foi pago (coloca o valor da variável
        // como true)
        this.paidIPVA = true;
    }

    // Método para calibrar todos os pneus
    /**
     * This method calibrates all the wheels (defines the wheel.calibrated as true)
     * Esse método calibra todas as rodas (define wheel.calibrated como true)
     * @return true quando chega ao fim
     */
    public boolean calibrateWheel() {
        // Percorre o vetor das rodas calibradas e calibra todas elas
        for (Wheel wheel : this.wheels) {
            // Chama a função calibrate da classe Wheel
            wheel.calibrate();
        }
        return true;
    }

    // Método para calibrar um pneu específico
    /**
     * This method calibrates an especified wheel (sets the wheel.calibrated true)
     * Esse método calibra uma roda específica (define wheel.calibrated true)
     * @param number the wheel number in the array (o número da roda no vetor)
     * @return true if the wheel was sucefully found, false if it wasn't found (true se a roda for encontrada, false se ela não foi)
     */
    public boolean calibrateWheel(int number) {
        // Verifica se a roda existe, se não existir, retorna false
        if (number < 0 || number > 3) {
            return false;
        }
        // Se o pneu existe, calibra ele e retorna true
        this.wheels[number].calibrate();
        return true;
    }

    // Função para descalibrar um pneu
    /**
     * This method decalibrates an especified wheel (sets the wheel.calibrated false)
     * Esse método descalibra uma roda específica (define wheel.calibrated false)
     * @param number the wheel number in the array (o número da roda no vetor)
     * @return true if the wheel was sucefully found, false if it wasn't found (true se a roda for encontrada, false se ela não foi)
     */
    public boolean decalibrateWheel(int indexWheel) {
        // Se a roda existir, calibra ela e retorna true
        if(!(indexWheel >= 0 && indexWheel <= 3)){
            return false;
        }
        this.wheels[indexWheel].decalibrate() ;
        return true;
    }
// Função para descalibrar um pneu
    /**
     * This method decalibrates all wheels (sets the wheel.calibrated false)
     * Esse método descalibra todas as rodas (define wheel.calibrated false)
     * @return true if the wheel was sucefully decalibrated (true se a roda for descalibrada)
     */
    public boolean decalibrateWheel() {
        
        // Percorre o vetor das rodas descalibradas e descalibra todas elas
        for (Wheel wheel : this.wheels) {
            // Chama a função descalibrate da classe Wheel
            wheel.decalibrate();
        }
        return true;
    }
    // Função para imprimir o carro na tela
    /**
     * This method verifies if the vehicle is able or isn't able to run
     * Esse método verifica se o veículo está pronto ou não para correr
     * @return true if it's able, false if it isn't able to run (true se está pronto, false se não estiver)
     */
    public boolean isAbleToRun() {
        // Verifica se há alguma roda descalibrada{}
        for (Wheel i : this.wheels)
            // Se encontrar alguma roda descalibrata, retorna falso
            if (!i.isCalibrated())
                return false;
        // Se o IPVA não estiver pago, retorna falso
        if (!this.paidIPVA)
            return false;
        // Se o carro não tiver combustivel, retorna falso
        if (this.gasAmount == 0)
            return false;
        // Se o carro estiver pronto para correr, retorna true
        return true;
    }

    // Função para printar o carro na tela (formato sugerido pela professora e
    // adaptado pelos alunos)
    public void printVehicle(int number) {
        for (int i = 0; i < this.runned; i++)
            System.out.print(" ");
        System.out.println("    ____          ");
        for (int i = 0; i < this.runned; i++)
            System.out.print(" ");
        System.out.println(" __/  |_ \\_      ");
        for (int i = 0; i < this.runned; i++)
            System.out.print(" ");
        System.out.printf("|  _  %d  _``-.    \n",number);
        for (int i = 0; i < this.runned; i++)
            System.out.print(" ");
        System.out.println("'-(_)---(_)--'\n\n");
    }

    // Método para executar quando o carro correr
    /**
     * Verifies if the vehicle can run, if it can, moves it and consumes gasoline
     * Verifica se o veículo pode ou não correr, se ele pode, move ele e consome sua gasolina
     * @return true if the vehicle is able to run, false if it can't run (true se o carro pode correr, false se não pode)
     */
    public boolean run() {
        // Verifica se o carro pode correr
        if (this.isAbleToRun()) {
            // Aumenta a quantidade de blocos percorridos
            this.runned = this.runned + 5;
            // Consome a gasolina
            this.runOut(0.55);
            return true;
        }
        else {
            return false;
        }
    }

    // Métodos base como construtor, getters e setters
    // Contrutor para o carro
    public PopularCar(IdList idList, double tankCapacity) {
        //Chama o método setter para o id do carro
        this.setId(idList);
        //Define a capacidade máxima do tanque
        this.tankCapacity = tankCapacity;
        //Coloca a quantidade inicial do carro como 3,5L
        this.fuel(3.5);
        //Define a quantidade inicial de blocos percorridos como 0
        this.runned = 0;
        //Escolhe aleatóriamente se o IPVA está pago ou não
        this.setPaidIPVA();
        //Cria as novas rodas do carro
        for (int i = 0; i < 4; i++) {
            this.wheels[i] = new Wheel();
        }
    }

    // Getter para o ID
    public int getId() {
        return id;
    }

    // Setter para o id do carro
    private void setId(IdList idList) {
        // Inicia um laço para validar um ID único
        do {
            // Cria um objeto do tipo Random
            Random rand = new Random();
            // Recebe aleatóriamente um valor e o transforma em um id de 5 dígitos
            this.id = 10000 + rand.nextInt(90000);
        } while (idList.contains(this.id)); // Verificar se o valor já está na lista de IDs
        // Adiciona o id dentro da lista de IDs
        idList.add(this.id);
    }

    // Getter para as rodas do carro
    public Wheel[] getWheels() {
        return wheels;
    }

    // Setter para as rodas
    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    // Getter para a quantidade de gasolina
    public double getGasAmount() {
        return gasAmount;
    }

    // Setter para a quantidade de gasolina no carro
    public void setGasAmount(double gasAmount) {
        this.gasAmount = gasAmount;
    }

    // Getter da capacidade do tanque
    public double getTankCapacity() {
        return tankCapacity;
    }

    // Getter para dizer se o IPVA está pago ou não
    public boolean isPaidIPVA() {
        return paidIPVA;
    }

    // Setter para definir aleatóriamente se o IPVA está pago ou não
    public void setPaidIPVA() {
        Random rand = new Random();
        this.paidIPVA = rand.nextBoolean();
    }

    // Setter para definir se o IPVA do carro está pago ou não
    public void setPaidIPVA(boolean paidIPVA) {
        this.paidIPVA = paidIPVA;
    }

    // Getter para a variável runned
    public int getRunned() {
        return this.runned;
    }

    // Setter para a variável runned
    public void setRunned(int runned) {
        this.runned = runned;
    }

    // Método para passar todos os dados do objeto da classe Popularcar para string
    public String toString() {
        return "Id: " + this.id + "\n" + "Calibragem das rodas: 0: " + this.wheels[0].toString() + " 1: "
                + this.wheels[1].toString() + " 2: " + this.wheels[2].toString() + " 3: "
                + this.wheels[3].toString() + "\n" + "O IPVA está pago? " + (this.paidIPVA ? "Sim" : "Não")
                + "\n" + "Quantidade de gasolina no tanque: " + this.gasAmount + "L\n" + "Capacidade do tanque: "
                + this.tankCapacity + "L\n" + "Blocos de texto andados: " + runned;
    }
}
