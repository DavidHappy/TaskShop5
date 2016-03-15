package com.example.database.request.getUser;

import com.example.database.request.HibernateUtil;
import com.example.database.user.RegUserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by user on 23.02.16.
 */
public class GetUser
{
    public static Object getValueUser(String login, String password)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<RegUserEntity> regUserEntities = session.createCriteria(RegUserEntity.class).add(Restrictions.eq("login", login))
                                                                                         .add(Restrictions.eq("password", password))
                                                                                         .list();
        if(regUserEntities.size()>0)
        {
            return regUserEntities.get(0);
        }
        return null;
    }
}
