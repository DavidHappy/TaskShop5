package com.example.database.request;

import com.example.database.user.RegUserEntity;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;

/**
 * Created by Dev on 22.02.2016.
 */
public class InsertRegistrationUser
{
    public static String registrationUser(Map<String, String> arrayData)
    {
        RegUserEntity userEntity = new RegUserEntity();
        Class tableProduct = userEntity.getClass();
        Field arrayFieldClass[]= tableProduct.getDeclaredFields();

        for (Map.Entry entry: arrayData.entrySet())
        {
            Object key = entry.getKey();

            for(int i = 0; i<arrayFieldClass.length; i++)
            {
                if(key.equals(arrayFieldClass[i].getName()))
                {
                    try
                    {
                        arrayFieldClass[i]=RegUserEntity.class.getDeclaredField(key.toString());
                        arrayFieldClass[i].setAccessible(true);
                        if(arrayFieldClass[i].getName().equals("age"))
                        {
                            arrayFieldClass[i].set(userEntity, Integer.parseInt(arrayData.get(key)));
                        }
                        else
                        {
                            arrayFieldClass[i].set(userEntity, arrayData.get(key));
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
        return insertValueUser(userEntity);
    }

    private static String insertValueUser(RegUserEntity userEntity)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<RegUserEntity>regUserEntityList = session.createCriteria(RegUserEntity.class).add(Restrictions.eq("login", userEntity.getLogin())).list();
        if(regUserEntityList.size()>0)
        {
            session.close();
            return "Login busy";
        }
        else
        {
            session.beginTransaction();
            session.save(userEntity);
            session.getTransaction().commit();
            session.close();
            return "The user is successfully registered";
        }
    }
}
