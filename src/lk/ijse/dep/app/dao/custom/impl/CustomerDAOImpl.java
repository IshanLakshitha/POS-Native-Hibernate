package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudUtil;
import lk.ijse.dep.app.dao.custom.CustomerDAO;
import lk.ijse.dep.app.db.HibernateUtil;
import lk.ijse.dep.app.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public Optional<Customer> find(String customerId) throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = session.find(Customer.class,customerId);
        session.getTransaction().commit();
        return Optional.ofNullable(customer);
    }

    public Optional<List<Customer>> findAll() throws SQLException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String sql = "SELECT * FROM Customer";
        List<Customer> customers = session.createNativeQuery(sql, Customer.class).getResultList();
        session.getTransaction().commit();
        return Optional.ofNullable(customers);
    }

    public boolean save(Customer customer) throws SQLException {
       boolean result = false;
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.save(customer);
       session.getTransaction().commit();
       result = true;
       return result;

    }

    public boolean update(Customer customer) throws SQLException {
       boolean result = false;
       SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
       Session session = sessionFactory.openSession();
       session.beginTransaction();
       session.update(customer);
       session.getTransaction().commit();
       result = true;
       return result;
    }

    public boolean delete(String customerId) throws SQLException {
        boolean result = false;
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Customer customer = new Customer();
        customer.setId(customerId);
        session.delete(customer);
        session.getTransaction().commit();
        result = true;
        return  result;
    }

}
