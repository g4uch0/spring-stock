package org.example.entitys;

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
@Table(name = "commercial_invoice")
public class CommercialInvoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double total;

    @ManyToOne(
            optional = true,
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "user_commercial_invoice")
    private User user;

    @OneToMany(mappedBy = "commercialInvoice",
            fetch = FetchType.LAZY)
    private List<Item> items;

    public CommercialInvoice() {
        items = new ArrayList<>();
    }

    public CommercialInvoice(Long id, User user) {
        this.id = id;
        this.user = user;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items.add((Item) items);
    }

    public Double getTotal(){
        items.forEach(item -> total+= item.getFinalPrice());
        return  total;
    }





}
