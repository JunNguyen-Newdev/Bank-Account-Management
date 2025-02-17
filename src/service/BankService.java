package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import model.*;
import java.util.*;

/**
 *
 * @author Nguyen Tan Trung - CE200064
 */
public class BankService {

    // Khoi tao kieu List giup code linh hoat (co nhieu cach trien khai: ArrayList, LinkList ...), de dang thay doi
    // ArrayList: 1 trong nhieu cach trien khai cua List (ngoai ra con co LinkList ...)
    private List<Customer> listOfCustomers = new ArrayList<>();

    // Phương thức khởi tạo
    public BankService() {
        loadCustomersFromFile();
    }
    
    // Phương thức lưu dữ liệu khách hàng vào file
    private void saveCustomerToFile(Customer customer) {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ListOfCustomers.txt", true))) {   // true: cho phép append
            pw.println(customer.toString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            System.out.println("Error saving customer to file: " + e.getMessage());
        }
    }
    
    // Phương thức đọc dữ liệu khách hàng từ file
    private void loadCustomersFromFile() {
        File file = new File("ListOfCustomers.txt");

        try {
            // Kiểm tra nếy file không tồn tại thì tạo file
            if (!file.exists()) {
                file.createNewFile();
                return; // Tạo xong thì kết thúc
            }

            // Nếu file không có dữ liệu
            if (file.length() == 0) {
                return; // Thì không làm gì cả
            }

            // Đọc dữ liệu khách hàng từ file
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(" \\|");
                    if (parts.length == 5) {
                        String name = parts[0].trim();
                        String dob = parts[1].trim();
                        String phone = parts[2].trim();
                        String accountNumber = parts[3].trim();
                        double balance = Double.parseDouble(parts[4].trim());

                        // Thêm khách hàng và List<>
                        Customer customer = new Customer(name, phone, dob, accountNumber, balance);
                        listOfCustomers.add(customer);
                    }
                }
                br.close();
            }
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }
    
    // Phương thức cập nhật file dùng cho chức năng: update, transfer, deposit, withdraw, delete
    private void updateFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("ListOfCustomers.txt", false))) {  // false: ghi đè
            for (Customer customer : listOfCustomers) {
                pw.println(customer.toString());
                pw.flush();
                if (customer == null) {
                    pw.close();
                }
            }
        } catch (IOException e) {
            System.out.println("Error updating file: " + e.getMessage());
        }
    }

    // Tìm khách hàng bằng số tài khoản
    public Customer findCustomerbyAccountNumber(String accountNumber) {
        for (Customer customer : listOfCustomers) {
            if (customer.getAccount().getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return customer;
            }
        }
        return null; // Khách hàng không tồn tại
    }

    // Tạo tài khoản
    public void openAccount(String name, String phone, String dob, String accountNumber, double initialBalance) {
        Customer newCustomer = new Customer(name, phone, dob, accountNumber, initialBalance);
        listOfCustomers.add(newCustomer);
        saveCustomerToFile(newCustomer);
    }

    // In danh sách khách hàng
    public void listCustomers() {
        if (listOfCustomers.isEmpty()) {
            System.out.println("No customers available.");
            return;
        }
        
        // Sắp xếp tên theo thứ tự
        listOfCustomers.sort(Comparator.comparing(Customer::getName));
        
        int order = 0;
        System.out.format("%-5s |%-20s |%-13s |%-12s |%-14s |%-10s\n",
                "Order",
                "Name",
                "Date of birth",
                "Phone number",
                "Account number",
                "Balance");
        for (Customer customer : listOfCustomers) {
            System.out.format("%-5s |%-20s |%-13s |%-12s |%-14s |%-10.3f\n",
                    ++order,
                    customer.getName(),
                    customer.getDob(),
                    customer.getPhone(),
                    customer.getAccount().getAccountNumber(),
                    customer.getAccount().getBalance());
        }
    }

    // Xóa tài khoản
    public void deleteCustomer(String accountNumber) {
        Customer delCustomer = findCustomerbyAccountNumber(accountNumber);
        listOfCustomers.remove(delCustomer); // Xóa khách hàng
        updateFile(); // Cập nhập danh sach những khách hàng còn lại vào file
        System.out.println("ACCOUNT DELETED SUCCESSFULLY!");
    }
    
    // Phương thức gửi tiền
    public void deposit(Customer depositeCustomer, double amount){
        depositeCustomer.getAccount().deposit(amount);
        updateFile();
    }
    
    // Phương thức rút tiền
    public void withdraw(Customer withdrawCustomer, double amount) {
        withdrawCustomer.getAccount().withdraw(amount);
        updateFile();
    }
    
    // Phương thức chuyển tiền
    public void transfer(double amount, Customer senderCustomer, Customer receiverCustomer) {
        senderCustomer.getAccount().setBalance(senderCustomer.getAccount().getBalance() - amount);
        receiverCustomer.getAccount().setBalance(receiverCustomer.getAccount().getBalance() + amount);
        updateFile();
        System.out.println("TRANSFERED SUCCESSFULLY!");
    }
}
