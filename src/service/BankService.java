package service;

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
        System.out.println("ACCOUNT CREATED SUCCESSFULLY!");
    }

    // In danh sách khách hàng
    public void listCustomers() {
        int order = 0;
        System.out.format("%-5s |%-20s |%-13s |%-12s |%-14s |%-10s\n",
                "Order",
                "Name",
                "Date of birth",
                "Phone number",
                "Account number",
                "Balance");
        for (Customer customer : listOfCustomers) {
            System.out.format("%-5s |%-20s |%-13s |%-12s |%-14s |%-10s\n",
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
        listOfCustomers.remove(delCustomer);
        System.out.println("ACCOUNT DELETED SUCCESSFULLY!");
    }
    
    public void transfer(double amount, Customer senderCustomer, Customer receiverCustomer) {
        senderCustomer.getAccount().setBalance(senderCustomer.getAccount().getBalance() - amount);
        receiverCustomer.getAccount().setBalance(receiverCustomer.getAccount().getBalance() + amount);
        System.out.println("TRANSFERED SUCCESSFULLY!");
    }
}
