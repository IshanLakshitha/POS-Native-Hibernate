package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudUtil;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.db.DBConnection;
import lk.ijse.dep.app.db.HibernateUtil;
import lk.ijse.dep.app.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDAOImpl implements ItemDAO {

    public Optional<List<Item>> findAll() throws SQLException {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "SELECT * FROM Item";
        List<Item> items =  session.createNativeQuery(sql, Item.class).getResultList();
        session.getTransaction().commit();
        return Optional.ofNullable(items);

    }

    public boolean save(Item item) throws SQLException {
        return CrudUtil.<Integer>execute("INSERT INTO Item VALUES (?,?,?,?)",
                item.getCode(),item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()) > 0;
    }

    public boolean update(Item item) throws SQLException {
        return CrudUtil.<Integer>execute("UPDATE Item SET description=?,unitPrice=?,qtyOnHand=? WHERE code=?",
                item.getDescription(), item.getUnitPrice(), item.getQtyOnHand(), item.getCode()) > 0;
    }

    public boolean delete(String code) throws SQLException {
        return CrudUtil.<Integer>execute("DELETE FROM Item WHERE code=?", code) > 0;
    }

    @Override
    public Optional<Item> find(String itemCode) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = session.find(Item.class, itemCode);
        session.getTransaction().commit();
        return Optional.ofNullable(item);

    }
}
