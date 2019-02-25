package lk.ijse.dep.app.dao;

import lk.ijse.dep.app.entity.SuperEntity;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID extends Serializable> extends SuperDAO {

    Optional<T> find(ID key) throws SQLException, Exception;

    Optional<List<T>> findAll() throws SQLException, Exception;

    void save(T entity) throws SQLException, Exception;

    void update(T entity) throws SQLException, Exception;

    void delete(ID key) throws SQLException, Exception;

}
