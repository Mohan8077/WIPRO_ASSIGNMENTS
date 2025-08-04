package com.example.dao;

import com.example.model.Item;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class ItemDAO {

    public void addItem(Item item) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        }
    }

    public List<Item> getAllItems() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Item", Item.class).list();
        }
    }

    public void updateItem(Item item) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        }
    }

    public void deleteItem(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();
            Item item = session.get(Item.class, id);
            if (item != null) {
                session.delete(item);
            }
            tx.commit();
        }
    }

    public Item getItemById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Item.class, id);
        }
    }
}
