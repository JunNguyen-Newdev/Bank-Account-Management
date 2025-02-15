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
                    System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM [OPEN ACCOUNT]====");
                    System.out.print("Enter your name: ");
                    String customerName = sc.nextLine();

                    // Nếu hệ thống chưa có tên khách hàng thì bắt khách hàng phải đăng ký
                    if (service.findCustomerByName(customerName) == null) {
                        System.out.println("NOT FOUND. YOU NEED TO REGISTER!");
                        System.out.print("Enter your name again: ");
                        customerName = sc.nextLine();
                        System.out.print("Enter your phone number: ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("Enter your date of birth (DD/MM/YYYY): ");
                        String dob = sc.nextLine();
                        service.addCustomer(customerName, phoneNumber, dob);
                    } else {
                        // Khách đã đăng ký (hệ thống đã có tên khách hàng)
                        // Yêu cầu khách hàng nhập thông tin để tìm kiếm
                        System.out.print("Enter your phone number: ");
                        String phoneNumber = sc.nextLine();
                        System.out.print("Enter your date of birth (DD/MM/YYYY): ");
                        String dob = sc.nextLine();
                        Customer existedCustomer = service.findCustomer(customerName, phoneNumber, dob);

                        // Yêu cầu khách nhập số tài khoản muốn tạo
                        String accountNumber;
                        double initialBalance;
                        
                        // Nếu số tài khoản đã tồn tại thì nhập lại
                        do {
                            System.out.print("Enter your account number: ");
                            accountNumber = sc.nextLine();
                            if (existedCustomer.findAccountByAccountNumber(accountNumber) != null) {
                                System.out.println("THIS ACCOUNT NUMBER IS EXISTED. TRY AGAIN!");
                            }
                        } while (existedCustomer.findAccountByAccountNumber(accountNumber) != null);
                        
                        // Nếu số tiền < 0 thì nhập lại
                        do {
                            System.out.print("Enter your initial balance (>= 0): ");
                            initialBalance = sc.nextDouble();
                            sc.nextLine();
                            if (initialBalance < 0) {
                                System.out.println("THE BALANCE MUST BE GREATER THAN OR EQUAL TO 0!");
                            }
                        } while (initialBalance < 0);
                        
                        // Tài khoản chưa tồn tại và balance lớn hơn hoặc bằng 0 thì tạo tài khoản thành công
                        service.openAccount(customerName, phoneNumber, dob, accountNumber, initialBalance);
                    }
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
        sc.close();
    }

}
