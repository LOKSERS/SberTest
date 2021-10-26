package com.example.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.envers.Audited;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "buying_objects")
@JsonIgnoreProperties
@Audited
public class BuyingObj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public BuyingObj(BuyingObj buyingObj) {
        this.name = buyingObj.getName();
        this.description = buyingObj.getDescription();
    }

    @OneToOne(mappedBy = "buyingObj",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Requisition requisition;

    public Requisition getRequisition() {
        return requisition;
    }

    public void setRequisition(Requisition requisition) {
        this.requisition = requisition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BuyingObj)) return false;
        BuyingObj buyingObj = (BuyingObj) o;
        return getName().equals(buyingObj.getName()) && getDescription().equals(buyingObj.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription());
    }

    @Override
    public String toString() {
        return "BuyingObj{" +
                "name='" + name + '\'' +" !"+id+"! "+
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BuyingObj(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public BuyingObj() {
    }
}
