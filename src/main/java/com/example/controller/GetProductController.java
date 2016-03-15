package com.example.controller;

import com.example.database.parent.SubcategoryParent;
import com.example.database.request.getProduct.GetCategory;
import com.example.database.request.getProduct.GetProduct;
import com.example.database.request.getProduct.GetSubcategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;

/**
 * Created by user on 25.01.16.
 */

@RestController
public class GetProductController
{
    @RequestMapping(value = "getCategoryList")
    public List<String> getCategoryList()
    {
        return GetCategory.getCategoryList();
    }

    @RequestMapping(value = "getFieldProduct", params = {"subcategory"})
    public Object getFieldProduct(@RequestParam(value = "subcategory")String subcategory)
    {
        Object object = GetProduct.getListFieldProduct(subcategory);

        return object;
    }

    @RequestMapping(value = "getSubCategoryList", params = {"category"})
    public List<String> getSubcategory(@RequestParam(value = "category")String category)
    {
        return GetSubcategory.getSubcategory(category);
    }


    @RequestMapping(value = "getFieldNameProduct", params = {"subcategory"})
    public Object getFieldNameProduct(@RequestParam(value = "subcategory")String subcategory)
    {
        Object object = GetProduct.getListNameProduct(subcategory);
        return object;
    }

    @RequestMapping(value = "getListSubcategory")
    public HashSet<String> getListSubcategory()
    {
        return GetSubcategory.getListSubcategory();
    }

    @RequestMapping(value = "getProductAtId", params = {"idProduct", "subcategory"})
    public Object getProductAtId(@RequestParam(value = "idProduct")String idProduct, @RequestParam(value = "subcategory")String subcategory)
    {
        return GetProduct.getProductAtId(idProduct, subcategory);
    }

    @RequestMapping(value = "getProductAtSubcategory", params = "subcategory")
    public List<? extends SubcategoryParent> getProductAtSubcategory(@RequestParam(value = "subcategory")String subcategory)
    {
        return GetSubcategory.getListGoods(subcategory);
    }

    @RequestMapping(value = "getProductAtName", params = {"search"})
    public List<? extends SubcategoryParent> getProductAtName(@RequestParam(value = "search")String search)
    {
        return GetProduct.searchProduct(search);
    }
}
