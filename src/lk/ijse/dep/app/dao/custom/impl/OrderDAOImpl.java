package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudDAOImpl;
import lk.ijse.dep.app.dao.custom.OrderDAO;
import lk.ijse.dep.app.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderDAOImpl extends CrudDAOImpl<Order, String> implements OrderDAO {

    @Override
    public int count() throws SQLException {
        return 0;
    }
}
