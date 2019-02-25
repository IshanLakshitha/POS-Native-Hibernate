package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudDAOImpl;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.db.HibernateUtil;
import lk.ijse.dep.app.entity.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ItemDAOImpl extends CrudDAOImpl<Item, String> implements ItemDAO {


}
