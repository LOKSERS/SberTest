package com.example.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.envers.Audited;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "requisition")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Audited
public class Requisition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public Requisition() {

    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    @Override
    public String toString() {
        return "Requisition{" +
                "Id=" + Id +
                ", creditAmount='" + creditAmount + '\'' +
                ", date=" + date +
                ", purchaseCost='" + purchaseCost + '\'' +
                ", seller=" + seller +
                ", customer=" + customer +
                ", buyingObj=" + buyingObj +
                '}';
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPurchaseCost() {
        return purchaseCost;
    }

    public void setPurchaseCost(String purchaseCost) {
        this.purchaseCost = purchaseCost;
    }

    @Column(name = "credit_amount")
    private String creditAmount; //сумма кредита

    @Column(name = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    @Column(name = "purchase_cost")
    private String purchaseCost;//стоимость покупки

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "person_seller_id")
    private Seller seller;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "buying_obj_id")
    private BuyingObj buyingObj;

    public BuyingObj getBuyingObj() {
        return buyingObj;
    }

    public void setBuyingObj(BuyingObj buyingObj) {
        this.buyingObj = buyingObj;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
