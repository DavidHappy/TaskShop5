package com.example.controller;

import com.example.database.request.InsertBuyOrder;
import com.example.database.request.InsertRegistrationUser;
import com.example.database.request.getUser.GetUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by Dev on 22.02.2016.
 */
@RestController
public class UserController
{
    @RequestMapping(value = "registration_user")
    public String insertUser(@RequestParam Map<String, String> arrayDataOfUser)
    {
        return InsertRegistrationUser.registrationUser(arrayDataOfUser);
    }

    @RequestMapping(value = "search_user", params = {"login", "password"})
    public Object getUser(@RequestParam(value = "login")String login, @RequestParam(value = "password")String password)
    {

        return GetUser.getValueUser(login, password);
    }


    @RequestMapping(value = "order", params = {"phone", "count", "price", "sold", "idProduct", "user"})
    public String orderUser(@RequestParam(value = "phone", defaultValue = "0")long phone,
                            @RequestParam(value = "count", defaultValue = "1")long count,
                            @RequestParam(value = "price", defaultValue = "0")long price,
                            @RequestParam(value = "sold", defaultValue = "false")String sold,
                            @RequestParam(value = "idProduct", defaultValue = "false")String idProduct,
                            @RequestParam(value = "subcategory")String subcategory,
                            @RequestParam(value = "user")String userId)
    {

        Long idUserLong = Long.parseLong(userId);
        return InsertBuyOrder.orderProduct(phone, count, price,sold,idProduct,subcategory, idUserLong);
    }
}
