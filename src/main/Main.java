package main;

import java.util.Scanner;
import service.BankService;
import model.*;

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
        BankService service = new BankService();
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
                case 0: //Print info
                    System.out.println("=== WELCOME TO GROUP 2 ===");
                    System.out.println("Member:");
                    System.out.println("1. Phan Tuan Thanh (L)");
                    System.out.println("2. Pham Nguyen Huy Tung");
                    System.out.println("3. Le Quang Nhat");
                    System.out.println("4. Do Nguyen Hao");
                    System.out.println("5. Doan Minh Duy");
                    System.out.println("6. Nguyen Tan Trung");
                    break;
                case 1: //Open account
                    System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM [OPEN ACCOUNT]====");

                    // Nhập tên, số điện thoại, ngày sinh
                    System.out.print("Enter your name: ");
                    String customerName = sc.nextLine();
                    System.out.print("Enter your phone number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter your date of birth (DD/MM/YYYY): ");
                    String dob = sc.nextLine();

                    String accountNumber;
                    double initialBalance;

                    // Yêu cầu khách hàng nhập số tài khoản
                    while (true) {
                        System.out.print("Enter your account number: ");
                        accountNumber = sc.nextLine();
                        // Nếu số tài khoản đã tồn tại thì nhập lại
                        if (service.findCustomerbyAccountNumber(accountNumber) != null) {
                            System.out.println("THIS ACCOUNT NUMBER ALREADY EXISTED. TRY AGAIN!");
                        } else {
                            // Số tài khoản hợp lệ thì break
                            break;
                        }
                    }

                    // Yêu cầu khách hàng nhập số tiền
                    while (true) {
                        System.out.print("Enter your initial balance (>= 0): ");
                        initialBalance = sc.nextDouble();
                        sc.nextLine();
                        // Nếu số tiền là số âm thì nhập lại
                        if (initialBalance < 0) {
                            System.out.println("THE BALANCE MUST BE GREATER OR EQUAL TO 0!");
                        } else {
                        // Nhập số tiền hợp lệ thì break
                            break;
                        }
                    }
                    // Tạo tài khoản thành công
                    service.openAccount(customerName, phoneNumber, dob, accountNumber, initialBalance);
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

        } while (choice
                != 9);
        sc.close();
    }

}
