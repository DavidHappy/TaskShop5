package com.example.database.parent;

import com.example.database.category.CategoryName;

import javax.persistence.*;

@Entity
@Table(name = "parentSubcategory")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SubcategoryParent
{
    @Id
    @GeneratedValue
    @Column(name = "id_parent")
    private Long id;

    @Column(name = "nameSubcategory")
    private String nameSubcategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idName")
    private CategoryName categoryName;

    public CategoryName getIdName() {
        return categoryName;
    }

    public void setIdName(CategoryName categoryName) {
        this.categoryName = categoryName;
    }

    public String getNameSubcategory() {
        return nameSubcategory;
    }

    public void setNameSubcategory(String nameSubcategory) {
        this.nameSubcategory = nameSubcategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
