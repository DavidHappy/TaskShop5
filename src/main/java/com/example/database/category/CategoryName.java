package com.example.database.category;

import com.example.database.parent.SubcategoryParent;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Dev on 22.01.2016.
 */
@Entity
@Table(name = "category_name")
public class CategoryName
{
    public CategoryName(){}

    public CategoryName(String name)
    {
        this.name = name;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryName")
    private List<SubcategoryParent> categoryEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubcategoryParent> getCategoryEntityList() {
        return categoryEntityList;
    }

    public void setCategoryEntityList(List<SubcategoryParent> categoryEntityList) {
        this.categoryEntityList = categoryEntityList;
    }
}
