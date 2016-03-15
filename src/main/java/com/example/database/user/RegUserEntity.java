package com.example.database.user;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reg_table")
public class RegUserEntity
{
    private long id;
    private String login;
    private String password;
    private String name;
    private String subname;
    private String email;
    private int age;
    private String ip;

    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "login")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "subname")
    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

//    private List<BuyUserEntity> buyUserEntityList;
//
//    public void setBuyUserEntityList(List<BuyUserEntity> buyUserEntityList) {
//        this.buyUserEntityList = buyUserEntityList;
//    }

//    @OneToMany(mappedBy = "reg_user_entity")
//    public List<BuyUserEntity> getBuyUserEntityList()
//    {
//        return buyUserEntityList;
//    }
}
