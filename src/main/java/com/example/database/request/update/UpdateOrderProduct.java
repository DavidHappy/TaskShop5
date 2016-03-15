package com.example.database.request.update;

import com.example.database.request.HibernateUtil;
import com.example.database.request.getUser.OrderUser;
import com.example.database.user.BuyUserEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Dev on 29.02.2016.
 */
public class UpdateOrderProduct
{
    public static String updateSold(String idOrder)
    {
        BuyUserEntity buyUserEntity = OrderUser.getOrderUser(idOrder);
        Session session = HibernateUtil.getSessionFactory().openSession();

        buyUserEntity.setSold("true");

        session.update(buyUserEntity);

        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
        return "confirmed";
    }
}
