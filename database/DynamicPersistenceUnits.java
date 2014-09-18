package model.database;

import java.util.logging.Level;

import org.hibernate.ejb.Ejb3Configuration;
import javax.persistence.EntityManagerFactory;

public class DynamicPersistenceUnits {
	

	@SuppressWarnings("deprecation")
	public static EntityManagerFactory createEMF(Class<?>[] entityClasses, String host, String port, String dataBaseName, String dataBaseUser, String password) {
        Ejb3Configuration ejb3conf = new Ejb3Configuration();
        ejb3conf.setProperty("hibernate.hbm2ddl.auto", "update");
        ejb3conf.setProperty("hibernate.show_sql", "false");
        ejb3conf.setProperty("hibernate.format_sql", "false");
        ejb3conf.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        ejb3conf.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        ejb3conf.setProperty("hibernate.connection.url", "jdbc:mysql://" + host + ":" + port + "/" + dataBaseName);
        ejb3conf.setProperty("hibernate.connection.username", dataBaseUser);
        ejb3conf.setProperty("hibernate.connection.password", password);

        for (int i = 0; i < entityClasses.length; i++) {
                assert entityClasses[i] != null;
                ejb3conf.addAnnotatedClass(entityClasses[i]);
        }
        
        return ejb3conf.buildEntityManagerFactory();
	}
}
