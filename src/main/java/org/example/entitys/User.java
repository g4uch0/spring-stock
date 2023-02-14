package org.example.entitys;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.example.entitys.enums.TypeUser;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userName;

    @Column
    private String userEmail;

    @Column
    @JsonIgnore
    private String password;

    @Column
    private Long phone;

    @Column
    private String name;


    private TypeUser typeUser;


    @OneToMany(mappedBy = "user",
            fetch = FetchType.LAZY
    )
    private List<CommercialInvoice> commercialInvoice;


    public User() {
        commercialInvoice = new ArrayList<>();
    }

    public User(Long id, String userName, String userEmail,
                String password, Long phone, String name, TypeUser typeUser) {
        this.id = id;
        this.userName = userName;
        this.userEmail = userEmail;
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


    public String getUserEmail() {
        return userEmail;
    }



    public String getPassword() {
        return password;
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
}
