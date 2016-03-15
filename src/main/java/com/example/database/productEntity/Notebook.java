package com.example.database.productEntity;


import com.example.database.parent.SubcategoryParent;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Dev on 24.01.2016.
 */

@Entity
@Table(name = "notebook_product")
public class Notebook extends SubcategoryParent
{
    public Notebook(){}

    @PrimaryKeyJoinColumn(name="ID")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String name;

    @Column(name = "price")
    public int price;

    @Column(name = "brand")
    public String brand;

    @Column(name = "color")
    public String color;

    @Column(name = "image")
    public String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
