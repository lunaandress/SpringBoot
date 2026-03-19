package com.andres.springboot.jpa.springboot_jpa_relationship.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String name;
    private String lastname;

    //@JoinColumn(name="client_id")
    @OneToMany(cascade = CascadeType.ALL)// se insewrta o borra en cascada osea en conjunto
    @JoinTable(name="tbl_clientes_to_direcciones", joinColumns = @JoinColumn(name="id_cliente"),
    inverseJoinColumns = @JoinColumn(name="id_direcciones"),
    uniqueConstraints = @UniqueConstraint(columnNames = {"id_direcciones"}))
    private List<Address> addressList; //lista de direcciones

    public Client(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
    }

    public Client() {
        addressList= new ArrayList<>();
    }


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Address> getAddressList() {
        return addressList;
    }
    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }


    @Override
    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", lastname=" + lastname + ", addressList=" + addressList + "]";
    }


    
    



    

}
