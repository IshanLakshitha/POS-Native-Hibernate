package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudDAOImpl;
import lk.ijse.dep.app.dao.custom.CustomerDAO;
import lk.ijse.dep.app.db.HibernateUtil;
import lk.ijse.dep.app.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl extends CrudDAOImpl<Customer, String> implements CustomerDAO {


}
