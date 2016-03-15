package com.example.database.request;

import com.example.database.parent.SubcategoryParent;
import com.example.database.productEntity.Notebook;
import com.example.database.productEntity.Smart;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InsertProduct
{
    private static void insertGoods(Object subcategoryParent)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        session.save(subcategoryParent);
        session.getTransaction().commit();
        session.close();
    }

    public static void insertNewProduct(Map<String, String> arrayData)
    {
        String subcategory = null;
        List<Object> arrayField = new ArrayList<>();
        for (Map.Entry entry: arrayData.entrySet())
        {
            Object key = entry.getKey();
            arrayField.add(key);
        }

        for(int i = 0; i < arrayField.size(); i++)
        {
            if(arrayField.get(i).equals("subcategoryInsert"))
            {
                subcategory =  arrayData.get(arrayField.get(i).toString());
            }
        }

        SubcategoryParent objectProduct = getObject(subcategory);
        Class tableProduct = objectProduct.getClass();

        Field str[]= tableProduct.getDeclaredFields();

        for(int i =0; i<str.length; i++)
        {
            for (int j = 0; j < arrayField.size(); j++)
            {
                if(arrayField.size()>0)
                {
                    if(arrayField.get(j).equals(str[i].getName()))
                    {
                        try
                        {
                            if(str[i].getType().toString().equals("int"))
                            {
                                str[i].set(objectProduct, Integer.parseInt(arrayData.get(arrayField.get(j))));
                                continue;
                            }
                            else
                            {
                                str[i].set(objectProduct, arrayData.get(arrayField.get(j).toString()));
                                continue;
                            }
                        }
                        catch (IllegalAccessException e)
                        {
                            e.printStackTrace();
                        }
                    }
                }
                else
                {
                    System.out.println("Size Array Field 0");
                }
            }
        }
        insertGoods(objectProduct);
    }

    private static SubcategoryParent getObject(String subcategory)
    {
        SubcategoryParent objectProduct = null;

        if(subcategory.equalsIgnoreCase("Smartfon"))
        {
            objectProduct =new Smart();
        }
        else  if(subcategory.equalsIgnoreCase("Notebook"))
        {
            objectProduct = new Notebook();
        }
        insertSubcategoryInTableProduct(objectProduct, subcategory);
        return objectProduct;
    }

    private static void insertSubcategoryInTableProduct(SubcategoryParent object, String subcategory)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SubcategoryParent>list = session.createCriteria(SubcategoryParent.class).add(Restrictions.eq("nameSubcategory", subcategory)).list();
        object.setNameSubcategory(list.get(0).getNameSubcategory());
        session.close();
    }
}
