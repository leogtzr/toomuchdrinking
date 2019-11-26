package toomuchdrinking.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ahorro")
public class Ahorro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private Date date;
    private double amount;

    public Ahorro() {
    }

    public Ahorro(Long id, Date date, double amount) {
        this.id = id;
        this.date = date;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Ahorro{" +
                "date=" + date +
                ", amount=" + amount +
                '}';
    }
}
