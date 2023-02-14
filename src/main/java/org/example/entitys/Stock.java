package org.example.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stock")
public class Stock {

    @Column
    private Product product;

    @Column
    private Integer productQuantity;

}
