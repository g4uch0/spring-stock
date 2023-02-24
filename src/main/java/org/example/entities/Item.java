package org.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item_commercial_invoice")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToMany(mappedBy = "item",
            fetch = FetchType.LAZY)
    private List<Product> product;

    @Column
    private Double price;
    @Column
    private Double finalPrice;
    @Column
    private Integer quantity;


    @ManyToOne(optional = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "items")
    private CommercialInvoice commercialInvoice;


    public Item() {
        this.product = new ArrayList<>();
    }

    public Item(Long id, Product product, Double price, Integer quantity) {
        this.id = id;
        this.product.add(product);
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product.add(product);
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getFinalPrice() {
        Double total = this.price * quantity;
        return total;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
