package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PathController
{
    @RequestMapping(value = "/")
    public String indexPage()
    {
        return "index";
    }

    @RequestMapping("/header")
    public String header(){
        return "header";
    }

    @RequestMapping(value = "/admin/admin-page")
    public String adminPage()
    {
        return "admin/admin-page";
    }

    @RequestMapping(value = "/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/about")
    public String aboutPage(){
        return "about";
    }

    @RequestMapping("/contact")
    public String contactPage(){
        return "contact";
    }

    @RequestMapping("/promotions")
    public  String promotionsPage()
    {
        return "promotions";
    }

    @RequestMapping("/insert")
    public String insertPage()
    {
        return "admin/insert";
    }

    @RequestMapping("/category-body")
    public  String categoryBodyPage()
    {
        return "category-body";
    }

    @RequestMapping("/filter-product")
    public String filterGoods()
    {
        return "filter-product";
    }

    @RequestMapping("/list-goods")
    public String listGoods()
    {
        return "list-goods";
    }

    @RequestMapping(value = "/product-full-description")
    public String productFullDescription()
    {
        return "product-full-description";
    }

    @RequestMapping(value = "/upload")
    public String productFullDescription1()
    {
        return "upload";
    }

    @RequestMapping("/list-category")
    public String listCategory()
    {
        return "list-category";
    }

    @RequestMapping("/order")
    public String orderPage()
    {
        return "admin/order";
    }

    @RequestMapping("/update")
    public String updatePage()
    {
        return "admin/update";
    }

    @RequestMapping("/historySales")
    public String historySalesPage()
    {
        return "admin/historySales";
    }

    @RequestMapping("/list-goodsSearchAtName")
    public String listGoodsSearchAtName()
    {
        return "list-goodsSearchAtName";
    }

}
