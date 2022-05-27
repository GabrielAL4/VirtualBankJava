package com.company;
import java.util.*;
import java.lang.Math;

public class ContaPoupanca {
    public int agency;
    public int number;
    public double balance;
    Scanner sc1 = new Scanner(System.in);

    public void withdraw(double value){

        double withdrawLimit;
        System.out.println("Insira o valor do saque: ");
        value = sc1.nextDouble();

        withdrawLimit = balance-(balance * 0.20);
        if(balance <= 20){
            System.out.println("Não é possível fazer um saque devido a saldo insuficiente em conta" + balance);
        }
        else if(value >= withdrawLimit){
            if(value == withdrawLimit){
                System.out.println("Não foi possível fazer o saque pois o valor: " + value + " é igual a 80% do valor em conta de: "+ balance);
            }
            else {
                System.out.println("Não foi possível fazer o saque pois o valor: " + value + " é maior que 80% do valor em conta de: " + balance);
            }
        }
        else if(value>= 10000){
            System.out.println("Não foi possível fazer o saque pois o valor é acima do valor permitido por saque único de (R$ 10.000,00)");
        }
        else{
            System.out.println("Aguarde para o recebimento do saque");
            balance = balance - value;
        }
    }

    public void deposit(int depositType){
        System.out.println("Insira a forma de depósito desejada: ");
        System.out.println(" 1- Boleto\n 2- Gerar chave Pix\n 3- Dados Bancários");
        depositType = sc1.nextInt();
        int randomFor;
        ArrayList<String> DepositHash = new ArrayList<>();

        if((depositType >= 1) && (depositType < 4)){
            switch (depositType) {
                case 1 -> {
                    for (int i = 0; i < 12; i++) {
                        randomFor = (int) (Math.random() * 10);
                        DepositHash.add(Integer.toString(randomFor));
                    }
                    System.out.println("A númeração do boleto é: " + DepositHash);
                }
                case 2 -> {
                    for (int i = 0; i < 6; i++) {
                        randomFor = (int) (Math.random() * 10);
                        DepositHash.add(Integer.toString(randomFor));
                    }
                    System.out.println("O código de depósito via PIX é: " + DepositHash);
                }
                case 3 -> {
                    System.out.println("Seus dados bancários são: ");
                    System.out.println("Agência: " + agency + "\nConta: " + number);
                }
            }
        }
    }
    public void transfer(int transferType, double transferValue){
        System.out.println("Insira a forma de transferência desejada: ");
        System.out.println(" 1- Área PIX\n 2- Utilizar Contatos\n 3- Inserir Dados Bancários");
        transferType = sc1.nextInt();
        int cont = 0;
        int numberBank, agencyC, accountNumber;

        if((transferType >= 1) && (transferType < 4)){
            switch (transferType) {
                case 1 -> {
                    System.out.println("Área PIX");
                    System.out.println("1 - Inserir chave PIX\n2 - Utilizar a lista de contatos");
                    int pixSelection = sc1.nextInt();
                    do {
                        if (pixSelection == 1) {
                            String pixKey = sc1.next();
                            cont++;
                        }
                        else if (pixSelection == 2) {
                            System.out.println("");
                            cont++;
                        }
                        else {
                            System.out.println("Valor inválido  ");
                        }
                    }while (cont<1);
                }
                case 2 -> {
                    int selectContact;
                    System.out.println("Lista de contatos: ");
                    selectContact = sc1.nextInt();
                }
                case 3 -> {
                    System.out.println("Inserir dados bancários: ");
                    System.out.println("Banco: ");
                    numberBank = sc1.nextInt();
                    System.out.println("Agência: ");
                    agencyC = sc1.nextInt();
                    System.out.println("Número da conta: ");
                    accountNumber = sc1.nextInt();

                    System.out.println("Insira o valor da tranferência");
                    transferValue = sc1.nextDouble();

                    if(transferValue >= (balance-(balance*0.20))){
                        System.out.println("Transferência não realizada por saldo insuficiente");
                    }
                    else{
                        System.out.println("Transferência realizada!");
                    }
                }
            }
        }
    }
}
