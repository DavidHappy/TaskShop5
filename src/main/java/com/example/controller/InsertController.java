package com.example.controller;

import com.example.database.productEntity.Smart;
import com.example.database.request.InsertCategory;
import com.example.database.request.InsertProduct;
import com.example.database.request.InsertSubcategory;
import jdk.nashorn.api.scripting.JSObject;
import org.springframework.web.bind.annotation.*;
import sun.reflect.ReflectionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 25.01.16.
 */
@RestController
public class InsertController
{
    @RequestMapping(value = "insertCategory", params = "newCategory")
    public String insertCategory(@RequestParam(value = "newCategory")String newCategory)
    {
        String answer = InsertCategory.insertNewNameCategory(newCategory);
        return answer;
    }

    @RequestMapping(value = "insertSubCategory", params = {"newSubCategory", "categoryName"})
    public String insertSubcategory(@RequestParam(value = "newSubCategory")String newSubCategory, @RequestParam(value = "categoryName", defaultValue = "Отсутствует")String category)
    {
        String answer = InsertSubcategory.insertSubcategory(newSubCategory, category);
        return answer;
    }

    @RequestMapping(value = "insertNewProduct")
    public String logs(@RequestParam Map<String, String> arrayData)
    {
        InsertProduct.insertNewProduct(arrayData);
        return "insert success";
    }


}
