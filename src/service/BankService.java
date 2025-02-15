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

    public Customer findCustomer(String name, String phone, String dob) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name) && customer.getPhone().equalsIgnoreCase(phone) && customer.getDob().equalsIgnoreCase(dob)) {
                return customer;
            }
        }
        return null;
    }

    public void openAccount(String customerName,String phone, String dob, String accountNumber, double initialBalance) {
        Customer customer = findCustomer(customerName, phone, dob);
        BankAccount newAccount = new BankAccount(accountNumber, customerName, initialBalance);
        customer.addAccount(newAccount);
        System.out.println("Account created: " + accountNumber);
    }
}
