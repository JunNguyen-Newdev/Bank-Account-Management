package model;

/**
 *
 * @author Nguyen Tan Trung - CE200064
 */
public class Customer {

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

    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }

    public String getDob() {
        return dob;
    }

    public BankAccount getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return String.format("%s |%s |%s |%s |%.3f", name, dob, phone, account.getAccountNumber(), account.getBalance());
    }

}
