package service;

import model.*;
import java.util.*;

/**
 *
 * @author Nguyen Tan Trung - CE200064
 */
public class BankService {
    private List<Customer> customers = new ArrayList<>();
    
    public void addCustomer(String name, String phone, String dob) {
        customers.add(new Customer(name, phone, dob));
        System.out.println("Customer added: " + name);
    }
    
    public Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null; // Not found
    }
    
    public void openAccount(String customerName, String accountNumber, double initialBalance) {
        Customer customer = findCustomerByName(customerName);
        if (customer != null) {
            BankAccount newAccount = new BankAccount(accountNumber, customerName, initialBalance);
            customer.addAccount(newAccount);
            System.out.println("Account created: " + accountNumber);
        } else {
            System.out.println("Customer not found.");  // Neu chua co ten thi can dang ky
        }
    }
}
