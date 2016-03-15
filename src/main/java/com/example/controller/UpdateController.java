package com.example.controller;

import com.example.database.request.update.UpdateOrderProduct;
import com.example.database.request.update.UpdateValuesGoods;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dev on 29.02.2016.
 */

@RestController
public class UpdateController
{
    @RequestMapping(value = "updateSold", params={"idOrder"})
    public String updateSold(@RequestParam(value = "idOrder")String idOrder)
    {

        return UpdateOrderProduct.updateSold(idOrder);
    }

    @RequestMapping(value = "updateValues", params = {"subcategory", "nameParam", "value"})
    public String updateValues(@RequestParam(value = "subcategory")String sabcategory, @RequestParam(value = "nameParam")String nameParam,
                               @RequestParam(value = "value")String value, @RequestParam(value = "id")long id)
    {
        return UpdateValuesGoods.updateValues(sabcategory, nameParam, value, id);
    }
}
