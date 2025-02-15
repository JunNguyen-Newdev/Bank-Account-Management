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
            if (customer.getAccout().getAccountNumber().equalsIgnoreCase(accountNumber)) {
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
}
