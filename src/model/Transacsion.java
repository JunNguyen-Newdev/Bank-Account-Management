package model;

import java.time.LocalDateTime;

/**
 *
 * @author Nguyen Tan Trung - CE200064
 */
public class Transacsion {

    private String type; // Loai giao dich (deposit, withdraw, transfer)
    private double amount; // So tien giao dich
    private LocalDateTime timestamp; // Thoi gian giao dich

    // Phuong thuc khoi tao (constructor)
    public Transacsion() {
    }

    public Transacsion(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.timestamp = LocalDateTime.now(); // Lay thoi gian khi giao dich xay ra
    }

    @Override
    public String toString() {
        return "Transacsion: " + type + "| Amount: " + amount + "| Date: " + timestamp;
    }

}
