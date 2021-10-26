package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customers")
@Audited
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name="last_name")
    private String lastName;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Customer(String name, String lastName, String phoneNumber, List<Requisition> requisitions) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.requisitions = requisitions;
    }

    @Column(name="phone_number")
    private String phoneNumber;

    public Customer(Customer customer) {
        this.name = customer.getName();
        this.lastName = customer.getLastName();
        this.phoneNumber = customer.getPhoneNumber();
    }

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Requisition> requisitions;

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

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Customer() {
    }
}