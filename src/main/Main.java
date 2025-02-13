package main;

import java.util.Scanner;

/**
 *
 * @author Nguyen Tan Trung - CE200064
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM ====");
            System.out.println("0. Print Info");
            System.out.println("1. Open Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. List Accounts");
            System.out.println("7. Update Account");
            System.out.println("8. Delete Account");
            System.out.println("9. Exit");
            System.out.print("Your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); //Bo ki tu \n

            switch (choice) {
                case 0:
                    System.out.println("=== WELCOME TO GROUP 2 ===");
                    System.out.println("Member:");
                    System.out.println("1. Phan Tuan Thanh (L)");
                    System.out.println("2. Pham Nguyen Huy Tung");
                    System.out.println("3. Le Quang Nhat");
                    System.out.println("4. Do Nguyen Hao");
                    System.out.println("5. Doan Minh Duy");
                    System.out.println("6. Nguyen Tan Trung");
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("THANKS FOR USING OUR SERVICE!");
                    System.out.println("SEE YOU AGAIN!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 9);

    }

}
