package com.company;
import java.util.*;
public class Cliente {
    public String clientName;
    public String CPF;
    public String adress;
    Scanner sc = new Scanner(System.in);
    ArrayList<String> fakeAnonimization = new ArrayList<>();
    public void insertData(String n, String c, String e){
        this.clientName = n;
        System.out.println("Nome: " + clientName);
        this.CPF = c;
        for (int i= 0; i < CPF.length();i++){
            if(i>=9) {
                fakeAnonimization.add(CPF);
            }
        }
        System.out.println("CPF: *********"+fakeAnonimization);
        this.adress = e;
        System.out.println("Endereço: " + adress);
    }
}