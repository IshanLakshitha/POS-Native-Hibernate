package lk.ijse.dep.app.dao.custom.impl;

import lk.ijse.dep.app.dao.CrudDAOImpl;
import lk.ijse.dep.app.dao.custom.QueryDAO;
import lk.ijse.dep.app.entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueryDAOImpl extends CrudDAOImpl implements QueryDAO {


    @Override
    public Optional<List<CustomEntity>> findOrderDetailsWithItemDescriptions(String orderId) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Optional<List<CustomEntity>> findAllOrdersWithCustomerNameAndTotal() throws SQLException {
        return Optional.empty();
    }
}
