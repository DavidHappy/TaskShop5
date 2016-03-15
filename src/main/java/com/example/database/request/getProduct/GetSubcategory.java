package com.example.database.request.getProduct;

import com.example.database.category.CategoryName;
import com.example.database.parent.SubcategoryParent;
import com.example.database.productEntity.Notebook;
import com.example.database.productEntity.Smart;
import com.example.database.request.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.access.method.P;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Dev on 25.01.2016.
 */
public class GetSubcategory
{
    public static List<String> getSubcategory(String category)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        List<SubcategoryParent> parentList = session.createCriteria(SubcategoryParent.class)
                .list();

        List<String> listSubcategory = new ArrayList<>();
        try
        {
            for(int i=0; i<parentList.size(); i++)
            {
                if(parentList.get(i).getIdName().getName().equalsIgnoreCase(category))
                {
                    listSubcategory.add(parentList.get(i).getNameSubcategory());
                }
            }
        }
        catch (Exception e)
        {}

        session.close();
        return listSubcategory;
    }

    public static HashSet<String> getListSubcategory()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        HashSet<String> str = new HashSet<>();

        List<SubcategoryParent> parentList = session.createCriteria(SubcategoryParent.class).list();

        for(int i = 0; i < parentList.size(); i++)
        {
            str.add(parentList.get(i).getNameSubcategory());
        }
        session.close();
        return str;
    }

    public static List<? extends SubcategoryParent> getListGoods(String subcategory)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<? extends SubcategoryParent> subcategoryParents = null;

        if(subcategory.equalsIgnoreCase("Smartfon"))
        {
            subcategoryParents = session.createCriteria(Smart.class).list();
        }
        else if(subcategory.equalsIgnoreCase("Notebook"))
        {
            subcategoryParents = session.createCriteria(Notebook.class).list();
        }
        session.close();
        return subcategoryParents;
    }
}
