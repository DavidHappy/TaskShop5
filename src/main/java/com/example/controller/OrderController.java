package com.example.controller;

import com.example.database.request.getUser.OrderUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OrderController
{
    @RequestMapping(value = "orders")
    public Object orderAllUser()
    {
        return OrderUser.getAllOrderUser("false");
    }

    @RequestMapping(value = "getHistorySales")
    public Object salesAll()
    {
        return OrderUser.getAllOrderUser("true");
    }
}
