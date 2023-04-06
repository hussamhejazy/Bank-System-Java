package com.company.bank;

public class Bank {
    private String names[];
    private double balances[];
    private int nClients = 50;

    public Bank() {
    }
    public Bank(int Size) {
        names = new String[Size];
        balances = new double[Size];
        nClients = 0;
    }

    public int findIndexByName(String name){
        int index = -1;
        for(int i = 0 ; i < names.length ; i++){
            if (name.equals(names[i])){
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean addClient(String name , double balance){
        boolean addedStatus = false;
        if (nClients == names.length){
            addedStatus = false;
        }else  if (nClients <= names.length) {
            if (findIndexByName(name) != -1) {
                addedStatus = false;
            } else {
                this.names[nClients] = name;
                this.balances[nClients] = balance;
                nClients++;
                addedStatus = true;
            }
        }
        return addedStatus;
    }

    public boolean deleteClient(String name){
        boolean deleteStatus = false;
        int indexClient = findIndexByName(name);
        if (indexClient != -1) {
            names[indexClient] = names[nClients-1];
            balances[indexClient] = balances[nClients-1];
            nClients--;
            deleteStatus = true;
        }
        return deleteStatus;
    }
    public boolean deposit(String name , double amount){
        boolean depositStatus = false;
        int indexClient = findIndexByName(name);
        if (indexClient != -1) {
            double PreBalance = balances[indexClient];
            balances[indexClient] +=amount;
            System.out.println(name +" was "+PreBalance+", now "+balances[indexClient]);
            depositStatus = true;
        }
        return depositStatus;
    }
    public boolean withdraw(String name , double amount){
        boolean withdrawStatus = false;
        int indexClient = findIndexByName(name);
        if (indexClient != -1 && amount <= balances[indexClient]) {
            double PreBalance = balances[indexClient];
            balances[indexClient] -=amount;
            System.out.println(name +" was "+PreBalance+", now "+balances[indexClient]);
            withdrawStatus = true;
        }else if (indexClient != -1 && amount > balances[indexClient]){
            System.out.println(name +" was "+balances[indexClient]+", now "+balances[indexClient]);
        }
        return withdrawStatus;
    }
    public boolean transfer(String fName ,String tName, double amount){
        boolean transferStatus = false;
        int fNameIndex = findIndexByName(fName);
        int tNameIndex = findIndexByName(tName);
        if (fNameIndex != -1 && tNameIndex!=-1 && amount <= balances[fNameIndex]){
            double fNamePreBalance = balances[fNameIndex];
            double tNamePreBalance = balances[tNameIndex];
            balances[fNameIndex] -= amount;
            balances[tNameIndex] += amount;
            System.out.println(fName +" was "+fNamePreBalance+", now "+balances[fNameIndex]);
            System.out.println(tName +" was "+tNamePreBalance+", now "+balances[tNameIndex]);
            transferStatus = true;
        }else if (fNameIndex != -1 && amount > balances[fNameIndex]){
            System.out.println(fName +" was "+balances[fNameIndex]+", now "+balances[fNameIndex]);
            System.out.println(tName +" was "+balances[tNameIndex]+", now "+balances[tNameIndex]);
        }
        return transferStatus;
    }
    public boolean transferToBank(String fName, Bank toBank ,String tName, double amount){
        boolean transferStatus = false;
        int fNameIndex = findIndexByName(fName);
        int tNameIndex = toBank.findIndexByName(tName);
        if (fNameIndex != -1 && tNameIndex!=-1 && amount <= balances[fNameIndex]){
            double fNamePreBalance = balances[fNameIndex];
            double tNamePreBalance = toBank.balances[tNameIndex];
            balances[fNameIndex] -= amount;
            toBank.balances[tNameIndex] += amount;
            System.out.println(fName +" was "+fNamePreBalance+", now "+balances[fNameIndex]);
            System.out.println(tName +" was "+tNamePreBalance+", now "+toBank.balances[tNameIndex]);
            transferStatus = true;
        }
        return transferStatus;
    }
    public void display(String name){
        int indexClient =findIndexByName(name);
        if (indexClient != -1) System.out.println(name + " " + balances[indexClient]+" SR");
        else System.out.println("Not found");
    }
    public String findMax(){
        String richestClient = null;
        if (nClients != 0){
            int indexClient = 0;
            double maxBalance = balances[indexClient];
            for (int i = 0 ; i < names.length;i++){
                if (balances[i] > maxBalance){
                    maxBalance = balances[i];
                    indexClient = i;
                }
            }
            richestClient = names[indexClient] + " "+ balances[indexClient]+" SR";
        }
        return richestClient;
    }
}

