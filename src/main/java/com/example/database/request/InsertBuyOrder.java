package com.example.database.request;

import com.example.database.user.BuyUserEntity;
import com.example.database.user.RegUserEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by user on 26.02.16.
 */
public class InsertBuyOrder
{
    public static String orderProduct(long phone, long count, long price, String sold, String idProduct, String subcategory, long idUser)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<RegUserEntity>regUserEntityList = session.createCriteria(RegUserEntity.class).add(Restrictions.eq("id", idUser)).list();


        BuyUserEntity buyUserEntity = new BuyUserEntity();
        buyUserEntity.setPhone(phone);
        buyUserEntity.setCount(count);
        buyUserEntity.setPrice(price);
        buyUserEntity.setSold(sold);
        buyUserEntity.setNameProduct(idProduct);
        buyUserEntity.setSubcategory(subcategory);
        buyUserEntity.setReg_user_entity(regUserEntityList.get(0));

        session.beginTransaction();
        session.save(buyUserEntity);
        session.getTransaction().commit();
        session.close();

        return "Our administrator with You shortly will contact";
    }
}
