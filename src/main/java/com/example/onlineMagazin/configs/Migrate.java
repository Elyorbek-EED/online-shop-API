package com.example.onlineMagazin.configs;

import com.example.onlineMagazin.entity.product.ProductSize;
import com.example.onlineMagazin.entity.size.Size;
import com.example.onlineMagazin.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Migrate {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.sessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();

//        Size size = new Size("XL", 40);
//        session.save(size);

        transaction.commit();
        session.close();
        sessionFactory.close();
    }
}
