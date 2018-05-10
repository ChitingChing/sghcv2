package io.ultimatesoftware.sghc;


import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.util.Properties;
import javafx.scene.control.Alert;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static  String estado="ok";

    // Hibernate 5:
    private static SessionFactory buildSessionFactory() {
        try {

            InputStream input ;
            input= new FileInputStream("connection.properties");
            if (input!=null){

                Properties prop = new Properties();
                prop.load(input);

                Configuration configuration = new Configuration();//
                configuration.setProperties(prop);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("/hibernatefiles/hibernate.cfg.xml")
                        .applySettings(configuration.getProperties()).build();
    //            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
    //                    .configure("/hibernatefiles/hibernate.cfg.xml").build();

                // Create a metadata sources using the specified service registry.
                Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();

                return metadata.getSessionFactoryBuilder().build();}
            else{
                estado="No existe un archivo de conexion a la base de datos. Crearlo usando la opción de parámetros y reinicie la aplicacion.";
                return null;
            }
        } catch (Exception ex) {
//            System.err.println("Initial SessionFactory creation failed." + ex);           
            //throw new ExceptionInInitializerError(ex);
            estado = ex.toString();
            return null;
        }
        
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
