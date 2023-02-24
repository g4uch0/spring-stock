package org.example.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.entities.enums.TypeUser;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_stock")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String email;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private Long phone;

    @Column
    private String name;


    @Column
    private TypeUser typeUser;


    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<CommercialInvoice> commercialInvoice;


    public User() {
        commercialInvoice = new ArrayList<>();
    }

    public User(Long id, String userName, String email,
                String password, Long phone, String name, TypeUser typeUser) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.typeUser = typeUser;
    }


    public Long getId() {
        return id;
    }



    public String getUserName() {
        return userName;
    }


    public String getEmail() {
        return email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhone() {
        return phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public List<CommercialInvoice> getCommercialInvoice() {
        return commercialInvoice;
    }
}
