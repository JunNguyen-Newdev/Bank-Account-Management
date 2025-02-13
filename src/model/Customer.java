package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Tan Trung - CE200064
 */
public class Customer {

    private String name; // Ten khach hang
    private String phone; // So dien thoai
    private String dob; // Ngay sinh
    // Khoi tao kieu List giup code linh hoat (co nhieu cach trien khai: ArrayList, LinkList ...), de dang thay doi
    private List<BankAccount> accounts; // Danh sach tai khoan cua khach hang

    // Phuong thuc khoi tao (constructor)
    public Customer() {
    }

    public Customer(String name, String phone, String dob) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.accounts = new ArrayList<>();  // ArrayList: 1 trong nhieu cach trien khai cua List (ngoai ra con co LinkList ...)
    }

    public void addAccount(BankAccount account) {
        this.accounts.add(account);
    }

    public BankAccount findAccountByAccountNumber(String fAccountNumber) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber().equals(fAccountNumber)) {
                return acc;
            }
        }
        return null;    // Not found
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
    public List<BankAccount> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Customer: " + name + "| Phone: " + phone + "| Date of Birth: " + dob;
    }

}
