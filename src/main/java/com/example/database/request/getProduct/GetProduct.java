package com.example.database.request.getProduct;

import com.example.database.parent.SubcategoryParent;
import com.example.database.productEntity.Notebook;
import com.example.database.productEntity.Smart;
import com.example.database.request.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.*;

/**
 * Created by Dev on 24.01.2016.
 */
public class GetProduct
{

    public static List getFullProduct(String numSub)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(numSub == "Smartfon")
        {
            List<Smart> list =session.createCriteria(Smart.class).list();
            return list;
        }
        else if(numSub =="Notebook")
        {
            List<Notebook> list =session.createCriteria(Notebook.class).list();
            return list;
        }
        return null;
    }

    public static Object getListFieldProduct(String subcategory)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(subcategory.equalsIgnoreCase("Smartfon"))
        {
            List<Smart> smartList = session.createCriteria(Smart.class).list();
            session.close();
            return smartList;
        }
        else if(subcategory.equalsIgnoreCase("Notebook"))
        {
            List<Notebook>notebookList = session.createCriteria(Notebook.class).list();
            session.close();
            return notebookList;
        }
        return null;
    }

    public static Object getProductAtId(String idProduct, String subcategory)
    {
        Long id = Long.parseLong(idProduct);
        List<? extends SubcategoryParent> parentList = getArrayFieldProduct(subcategory, id);
        if(parentList.size()>0)
        {
            return parentList.get(0);
        }
        return null;
    }

    public  static Object getListNameProduct(String subcategory)
    {
        if(subcategory.equalsIgnoreCase("Smartfon"))
        {
            Smart smart = new Smart();
            return smart;
        }
        else if(subcategory.equalsIgnoreCase("Notebook"))
        {
            Notebook notebook = new Notebook();
            return notebook;
        }
        return null;
    }

    public static List<? extends SubcategoryParent> getArrayFieldProduct(String subcategory, Long id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        if(subcategory.equalsIgnoreCase("Smartfon"))
        {
            List<Smart> smartList = session.createCriteria(Smart.class).add(Restrictions.eq("id", id)).list();
            session.close();
            return smartList;
        }
        else if(subcategory.equalsIgnoreCase("Notebook"))
        {
            List<Notebook>notebookList = session.createCriteria(Notebook.class).add(Restrictions.eq("id", id)).list();
            session.close();
            return notebookList;
        }
        return null;
    }


    public static List<SubcategoryParent> searchProduct(String name)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<SubcategoryParent> subcategoryParents = session.createCriteria(SubcategoryParent.class).list();


        Set<String> hashSet = new HashSet<>();
        for(int i=0; i<subcategoryParents.size(); i++)
        {
            hashSet.add(subcategoryParents.get(i).getNameSubcategory());

        }

        List<String> allNameSabcategory = new ArrayList<>();
        Iterator<String> iterator = hashSet.iterator();

        while (iterator.hasNext())
        {
            allNameSabcategory.add(iterator.next().toString());
        }


        List<SubcategoryParent>allGoodsInShop = new ArrayList<>();

        for(int i = 0; i <  allNameSabcategory.size(); i++)
        {
            addProductInArray(session, allGoodsInShop, allNameSabcategory.get(i), name);
        }

        session.close();
        return allGoodsInShop;
    }

    public static List<? extends SubcategoryParent> addProductInArray(Session session, List<SubcategoryParent> subcategoryParents, String subcategory ,String name)
    {
        List<SubcategoryParent> array = new ArrayList<>();

        if(subcategory.equalsIgnoreCase("Smartfon"))
        {
            List<Smart>smartList = session.createCriteria(Smart.class).list();
            for (int i=0; i<smartList.size(); i++)
            {
                if(smartList.get(i).getName().toLowerCase().startsWith(name.toLowerCase()))
                {
                    array.add(smartList.get(i));
                }
            }
        }
        else if(subcategory.equalsIgnoreCase("Notebook"))
        {
            List<Notebook>notebooks = session.createCriteria(Notebook.class).list();
            for (int i=0; i<notebooks.size(); i++)
            {
                if(notebooks.get(i).getName().toLowerCase().startsWith(name.toLowerCase()))
                {
                    array.add(notebooks.get(i));
                }
            }
        }

        for(int i = 0; i<array.size(); i++)
        {
            subcategoryParents.add(array.get(i));
        }

        return subcategoryParents;
    }
}
