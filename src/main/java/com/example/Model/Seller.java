package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.envers.Audited;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sellers")
@Audited
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "inn")
    private String INN;

    @Enumerated(EnumType.STRING)
    @Column(name = "seller_type", nullable = false)
    private SellerType sellerType;

    public Seller(Seller seller) {
        this.INN = seller.getINN();
        this.name= seller.getName();
        this.lastName=seller.getLastName();
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", INN='" + INN + '\'' +
                '}';
    }

    @OneToMany(mappedBy = "seller", orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Requisition> requisitions;

    public SellerType getSellerType() {
        return sellerType;
    }

    public void setSellerType(SellerType sellerType) {
        this.sellerType = sellerType;
    }

    public List<Requisition> getRequisitions() {
        return requisitions;
    }

    public void setRequisitions(List<Requisition> requisitions) {
        this.requisitions = requisitions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public Seller(String name, String lastName, String sellerType, String INN) {
        this.name = name;
        this.lastName = lastName;
        this.INN = INN;
    }

    public Seller() {
    }
}
