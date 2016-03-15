package com.example.database.request.update;

import com.example.database.parent.SubcategoryParent;
import com.example.database.productEntity.Notebook;
import com.example.database.productEntity.Smart;
import com.example.database.request.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by user on 03.03.16.
 */

public class UpdateValuesGoods
{
    public static String updateValues(String subcategory, String nameCol, String values, long id)
    {
        SubcategoryParent objectProduct = getObjectSubcategory(subcategory, id);
        Class tableProduct = objectProduct.getClass();

        Field fieldArray[]= tableProduct.getDeclaredFields();
        for(int i=0; i<fieldArray.length; i++)
        {
            if(nameCol.equalsIgnoreCase(fieldArray[i].getName().toString()))
            {
                try {
                    if(fieldArray[i].getType().toString().equals("int"))
                    {
                        fieldArray[i].set(objectProduct, Integer.parseInt(values));
                    }
                    else if(fieldArray[i].getType().toString().equals("Long"))
                    {
                        fieldArray[i].set(objectProduct, Long.parseLong(values));
                    }
                    else {
                        fieldArray[i].set(objectProduct, values);
                    }

                }
                catch (Exception e)
                {
                    return "Exception";
                }
            }
        }
        updateDB(objectProduct);
        return "Data obtained";
    }

    private static SubcategoryParent getObjectSubcategory(String subcategory, long id)
    {
        if(subcategory.equalsIgnoreCase("Smartfon"))
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Smart> subcategoryParentList = session.createCriteria(Smart.class).add(Restrictions.eq("id", id)).list();
            session.close();
            if(subcategoryParentList.size()>0)
            {
                return subcategoryParentList.get(0);
            }
        }
        else if(subcategory.equalsIgnoreCase("Notebook"))
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Notebook> subcategoryParentList = session.createCriteria(Notebook.class).add(Restrictions.eq("id", id)).list();
            session.close();
            if(subcategoryParentList.size()>0)
            {
                return subcategoryParentList.get(0);
            }
        }

        return null;
    }

    private static void updateDB(SubcategoryParent subcategoryObj)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.update(subcategoryObj);
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        session.close();
    }
}
