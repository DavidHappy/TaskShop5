package com.example.database.request;

import com.example.database.category.CategoryName;
import com.example.database.parent.SubcategoryParent;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by user on 25.01.16.
 */

public class InsertSubcategory
{
    public static String insertSubcategory(String nameSub, String category)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SubcategoryParent> parentList = session.createCriteria(SubcategoryParent.class).add(Restrictions.eq("nameSubcategory", nameSub)).list();
        if(category.equals("Введите категорию") || category.equals(""))
        {
            return "Sing in category";
        }
        else if(parentList.size()==0)
        {
            SubcategoryParent subcategory = new SubcategoryParent();
            subcategory.setNameSubcategory(nameSub);

            List<CategoryName>categoryName = session.createCriteria(CategoryName.class).
                        add(Restrictions.eq("name", category)).list();
            subcategory.setIdName(categoryName.get(0));

            session.beginTransaction();
            session.save(subcategory);
            session.getTransaction().commit();
            session.close();
            return "insert success";
        }
        session.close();
        return "already exists subcategory";
    }
}
