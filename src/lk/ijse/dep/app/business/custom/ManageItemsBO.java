package lk.ijse.dep.app.business.custom;

import lk.ijse.dep.app.business.SuperBO;
import lk.ijse.dep.app.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ManageItemsBO extends SuperBO {

    List<ItemDTO> getItems() throws Exception;

    void createItem(ItemDTO dto) throws SQLException;

    void updateItem(ItemDTO dto) throws SQLException;

    void deleteItem(String code) throws SQLException;

    ItemDTO findItem(String itemCode) throws SQLException;



}
