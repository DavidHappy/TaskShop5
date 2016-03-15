package com.example.database.request.getProduct;

import com.example.database.category.CategoryName;
import com.example.database.request.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 25.01.16.
 */
public class GetCategory
{
    public static List<String> getCategoryList()
    {
        List<String> categoryListString = new ArrayList<>();
        try
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<CategoryName> categoryNameList = session.createCriteria(CategoryName.class).list();

            for (int i = 0; i<categoryNameList.size(); i++)
            {
                categoryListString.add(categoryNameList.get(i).getName());
            }
            session.close();
        }
        catch (NullPointerException e)
        {}

        return categoryListString;
    }
}
