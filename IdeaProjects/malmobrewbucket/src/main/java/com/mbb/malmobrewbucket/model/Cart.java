package com.mbb.malmobrewbucket.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Cart implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(name = "date", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date date;
    @Column(name = "total_sum")
    private double totalSum;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    public Cart() {
    }

    public Cart(Long id, Date date, double totalSum, Customer customer) {
        this.id = id;
        this.date = date;
        this.totalSum = totalSum;
        this.customer = customer;
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


    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalsum) {
        this.totalSum = totalsum;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
