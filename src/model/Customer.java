package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Tan Trung - CE200064
 */
public class Customer {

    private String id;  //  Id khach hang
    private String name; // Ten khach hang
    private String phone; // So dien thoai
    private String dob; // Ngay sinh
    private BankAccount account; // Tai khoan cua khach hang

    // Phuong thuc khoi tao (constructor)
    public Customer() {
    }

    public Customer(String name, String phone, String dob, String accountNumber, double initialBalance) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.account = new BankAccount(accountNumber, name, initialBalance);  
    }
    
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getDob() {
        return dob;
    }
    public BankAccount getAccout() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer: " + name + "| Phone: " + phone + "| Date of Birth: " + dob;
    }

}
