package com.qualidade.ecommerce.model;

import java.io.IOException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.qualidade.ecommerce.utils.Address;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int identification;
    private String type;
    private String login;
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "user_order", joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "id") }, inverseJoinColumns = {
                    @JoinColumn(name = "order_id", referencedColumnName = "id") })
    private Order order;

    public User(String name, int identification, String type, String login,
            int cep, int number, String complement) throws IOException {
        this.name = name;
        this.identification = identification;
        this.type = type;
        this.login = login;
        this.password = this.name + this.identification;
        this.address = new Address(cep, number, complement);
    }

    public User(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public User() {
        this.name = "";
        this.login = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdentification() {
        return identification;
    }

    public void setIdentification(int identification) {
        this.identification = identification;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", login=" + login + " , pwd=" + password + ", rua="
                + address.getStreet() + '}';
    }

    public Order getOrder() {
        return this.order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}