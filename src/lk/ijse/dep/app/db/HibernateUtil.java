package lk.ijse.dep.app.db;

import lk.ijse.dep.app.entity.Customer;
import lk.ijse.dep.app.entity.Item;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().loadProperties("resources/application.properties").build();
        Metadata metadata = new MetadataSources(registry)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Item.class)
                .getMetadataBuilder()
                .build();
        SessionFactory factory = metadata.getSessionFactoryBuilder().build();
        return factory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
