package com.packt.webstore.domain.entity2;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_order;

    private int customerId;

    //@NotNull
    private String street;

    private String city;

    //@NotNull
    private String house;

    //@NotNull
    private String code;

    private BigDecimal price;

    ////////////////////
    public Order() { }

    public Order(Long id_order) {
        this.id_order = id_order;
    }

    public Order(String city, String street, String house, String code, BigDecimal price) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.code = code;
        this.price = price;
    }
    //////////////////////

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long value) {
        this.id_order = value;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String value) {
        this.street = value;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}