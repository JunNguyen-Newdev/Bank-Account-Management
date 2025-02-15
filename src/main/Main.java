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
            System.out.println("6. List Customers");
            System.out.println("7. Update Customer Info");
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
                    System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM [OPEN ACCOUNT] ====");
                    // Nhập tên, số điện thoại, ngày sinh
                    System.out.print("Enter your name: "); //Max 20 kí tự
                    String customerName = sc.nextLine();
                    System.out.print("Enter your date of birth (DD/MM/YYYY): "); //Max 10 kí tự
                    String dob = sc.nextLine();
                    System.out.print("Enter your phone number: "); //Max 10 kí tự
                    String phoneNumber = sc.nextLine();

                    String accountNumber;
                    double initialBalance;

                    // Yêu cầu khách hàng nhập số tài khoản
                    while (true) {
                        System.out.print("Enter your account number (10 digits): "); //Max 10 kí tự
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
                        System.out.print("Enter your initial balance (>= 0): ");    //Max 10 kí tự
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
                case 5: // Check balance
                    System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM [CHECK BALANCE] ====");
                    // Nhập số tài khoản người dùng muốn kiểm tra
                    System.out.print("Enter the account number: ");
                    String checkAccountNumber = sc.nextLine();

                    // Tài khoản không tồn tại
                    if (service.findCustomerbyAccountNumber(checkAccountNumber) == null) {
                        System.out.println("ACCOUNT DOES NOT EXIST!");
                    } else {
                        // In thong tin
                        Customer checkCustomer = service.findCustomerbyAccountNumber(checkAccountNumber);
                        System.out.println(checkCustomer.getAccount().toString());
                    }
                    break;
                case 6: //List customers 
                    System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM [LIST CUSTOMERS] ====");
                    service.listCustomers();
                    break;
                case 7: //Update customer info
                    System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM [UPDATE CUSTOMER INFO] ====");
                    System.out.println("The system only supports changing the phone number. Other information cannot be modified");

                    // Nhập số tài khoản người dùng muốn thay doi thong tin
                    System.out.print("Enter the account number: ");
                    String updateAccountNumber = sc.nextLine();

                    // Tài khoản không tồn tại
                    if (service.findCustomerbyAccountNumber(updateAccountNumber) == null) {
                        System.out.println("ACCOUNT DOES NOT EXIST!");
                    } else {
                        // Tai khoan ton tai thi in ra thong tin tai khoan
                        Customer updateCustomer = service.findCustomerbyAccountNumber(updateAccountNumber);
                        System.out.println(updateCustomer.toString());

                        //Nhap so dien thoai moi
                        System.out.print("Enter your new phone number: ");
                        String newPhoneNumber = sc.nextLine();

                        updateCustomer.setPhone(newPhoneNumber);
                        System.out.println("UPDATED SUCCESSFULLY!");
                    }
                    break;
                case 8: //Delete account
                    System.out.println("==== BANK ACCOUNT MANAGEMENT SYSTEM [DELETE ACCOUNT] ====");
                    // Nhập số tài khoản người dùng muốn xóa
                    System.out.print("Enter the account number: ");
                    String delAccountNumber = sc.nextLine();

                    // Tài khoản không tồn tại
                    if (service.findCustomerbyAccountNumber(delAccountNumber) == null) {
                        System.out.println("ACCOUNT DOES NOT EXIST!");
                    } else {
                        // Tài khoản tồn tại thì in ra thông tin tài khoản
                        Customer delCustomer = service.findCustomerbyAccountNumber(delAccountNumber);
                        delCustomer.toString();

                        // Xác nhận việc xóa tài khoản của người dùng
                        System.out.print("Do you want to delete this account(Y/N)? ");
                        String delChoice = sc.nextLine();
                        if (delChoice.equalsIgnoreCase("Y")) {
                            System.out.println("DELETED SUCCESSFULLY!");
                        } else {
                            System.out.println("DELETION FAILED!");
                        }
                    }
                    break;
                case 9:
                    System.out.println("THANKS FOR USING OUR SERVICE!");
                    System.out.println("SEE YOU AGAIN!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice!= 9);
        sc.close();
    }

}
