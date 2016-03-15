package com.example.database.user;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 04.01.16.
 */

@Entity
@Table(name = "buy_user")
public class BuyUserEntity
{
    @Id
    @GeneratedValue
    @Column(name = "id_buy_user")
    private Long idUser;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "sold")
    private String sold;

    @Column(name = "subcategory")
    private String subcategory;

    @Column(name = "phone")
    private Long phone;

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    public String isSold() {
        return sold;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Column(name = "price")
    private long price;

    @Column(name = "count")
    private long count;

    @Column(name = "date_buy")
    private Date date_buy;

    @ManyToOne
    @JoinColumn(name = "id_buy")
    private RegUserEntity reg_user_entity;

    public RegUserEntity getReg_user_entity() {
        return reg_user_entity;
    }

    public void setReg_user_entity(RegUserEntity reg_user_entity) {
        this.reg_user_entity = reg_user_entity;
    }

    public BuyUserEntity(String nameProduct, long price, long count){
        this.nameProduct = nameProduct;
        this.price = price;
        this.count = count;
        this.date_buy =  new Date(System.currentTimeMillis());
    }

    public BuyUserEntity(){
        this.date_buy =  new Date(System.currentTimeMillis());
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Date getDate_buy() {
        return date_buy;
    }

    public void setDate_buy(Date date_buy) {
        this.date_buy = date_buy;
    }

    public RegUserEntity getRegUserEntity() {
        return reg_user_entity;
    }

    public void setRegUserEntity(RegUserEntity reg_user_entity) {
        this.reg_user_entity = reg_user_entity;
    }
}
