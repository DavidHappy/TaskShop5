package com.example.database.request.getUser;

import com.example.database.request.HibernateUtil;
import com.example.database.user.BuyUserEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class OrderUser
{
    public static List<BuyUserEntity> getAllOrderUser(String sold)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<BuyUserEntity> userEntityList = session.createCriteria(BuyUserEntity.class).add(Restrictions.eq("sold", sold)).list();
        session.close();

        return userEntityList;
    }

    public static BuyUserEntity getOrderUser(String idOrder)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long idOrderLong = Long.parseLong(idOrder);
        List<BuyUserEntity> userEntityList = session.createCriteria(BuyUserEntity.class).add(Restrictions.eq("idUser", idOrderLong)).list();
        session.close();
        if(userEntityList.size()>0) {
            return userEntityList.get(0);
        }
        return null;
    }
}
