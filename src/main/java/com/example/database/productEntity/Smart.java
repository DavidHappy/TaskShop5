package com.example.database.productEntity;

import com.example.database.parent.SubcategoryParent;

import javax.persistence.*;

/**
 * Created by Dev on 22.01.2016.
 */

@Entity
@Table(name = "smart_product")
public class Smart extends SubcategoryParent
{
    public Smart(){}

    public Smart(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    @PrimaryKeyJoinColumn(name="ID")
    private Long id;

    @Override
    public Long getId()
    {
        return id;
    }

    @Override
    public void setId(Long id)
    {
        this.id = id;
    }

    @Column(name = "image")
    public String image;

    @Column(name = "name")
    public String name;

    @Column(name = "price")
    public int price;

    @Column(name = "brand")
    public String brand;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
