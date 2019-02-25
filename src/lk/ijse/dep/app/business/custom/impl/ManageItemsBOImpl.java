package lk.ijse.dep.app.business.custom.impl;

import lk.ijse.dep.app.business.Converter;
import lk.ijse.dep.app.business.custom.ManageItemsBO;
import lk.ijse.dep.app.dao.DAOFactory;
import lk.ijse.dep.app.dao.custom.ItemDAO;
import lk.ijse.dep.app.db.HibernateUtil;
import lk.ijse.dep.app.dto.ItemDTO;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ManageItemsBOImpl implements ManageItemsBO {

   private ItemDAO itemDAO;

   public ManageItemsBOImpl(){
       itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ITEM);
   }

   public List<ItemDTO> getItems() throws Exception {
       Session mySession = HibernateUtil.getSessionFactory().openSession();
       try(Session session = mySession) {
           itemDAO.setSesstion(session);
           session.beginTransaction();
           List<ItemDTO> itemDTOS = itemDAO.findAll().map(Converter::<ItemDTO>getDTOList).get();
           session.getTransaction().commit();
           return itemDTOS;
       }  catch (Exception ex) {
           mySession.getTransaction().rollback();
           throw ex;
       }
   }

   public void createItem(ItemDTO dto){

   }

}
