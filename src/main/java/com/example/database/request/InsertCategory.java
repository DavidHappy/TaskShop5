package com.example.database.request;

import com.example.database.category.CategoryName;
import com.example.database.request.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Dev on 22.01.2016.
 */
public class InsertCategory
{
    public static String insertNewNameCategory(String category)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<CategoryName>nameList = session.createCriteria(CategoryName.class).add(Restrictions.eq("name", category)).list();
        if(nameList.size() == 0)
        {
            session.beginTransaction();
            CategoryName categoryNameEntity = new CategoryName(category);
            session.save(categoryNameEntity);
            session.getTransaction().commit();
            session.close();
            return "Insert success";
        }
        return "Category already exists";
    }
}
