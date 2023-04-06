package com.company.bank;


import java.util.Scanner;

public class TestBank {

    private static Scanner input;

    public static void main(String[] args) {
        input = new Scanner(System.in);
        Bank b1 = new Bank(5);
        Bank b2 = new Bank(2);
        b2.addClient("Mike",1000);
        b2.addClient("Joe",3000);
        boolean RunMenu = true;
        while(RunMenu){
            System.out.print("************************************\n" +
                             "* 1- Add a client                  *\n" +
                             "* 2- Close a clint account         *\n" +
                             "* 3- Deposit                       *\n" +
                             "* 4- Withdraw                      *\n" +
                             "* 5- Transfer                      *\n" +
                             "* 6- Transfer to another Bank      *\n" +
                             "* 7- Display balance               *\n" +
                             "* 8- Find the richest client       *\n" +
                             "* 9- Exit                          *\n" +
                             "************************************\n" +
                             "=> ");
            int chose = input.nextInt();
            switch (chose){
                case 1:
                    System.out.print("Enter name and balance: ");
                    if (b1.addClient(input.next(),input.nextDouble()))System.out.println("DONE");
                    else System.out.println("ERROR");
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    if (b1.deleteClient(input.next())) System.out.println("DONE");
                    else System.out.println("ERROR");
                    break;
                case 3:
                    System.out.print("Enter name and balance: ");
                    if (b1.deposit(input.next(),input.nextDouble())) System.out.println("DONE");
                    else System.out.println("ERROR");
                    break;
                case 4:
                    System.out.print("Enter name and balance: ");
                    if (b1.withdraw(input.next(),input.nextDouble())) System.out.println("DONE");
                    else System.out.println("ERROR");
                    break;
                case 5:
                    System.out.print("Enter from name, to name, and amount:");
                    if (b1.transfer(input.next(),input.next(),input.nextDouble())) System.out.println("DONE");
                    else System.out.println("ERROR");
                    break;
                case 6:
                    System.out.print("Enter from name (this bank), to name (other bank), and amount:");
                    if (b1.transferToBank(input.next(),b2,input.next(),input.nextDouble())) System.out.println("DONE");
                    else System.out.println("ERROR");
                    break;
                case 7:
                    System.out.print("Enter name: ");
                    b1.display(input.next());
                    break;
                case 8:
                    System.out.println(b1.findMax());
                    break;
                case 9:
                    System.out.println("Goodbye");
                    RunMenu = false;
                    break;
                default:
                    System.out.println("Error Entry");
            }
        }
    }

}
