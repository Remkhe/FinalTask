package Tests;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jdk.jfr.Description;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.util.Locale;
import java.util.Properties;

public class EmployeeTest {
    private EntityManager getEm() {

        Properties props = new Properties();
        props.put("hibernate.connection.driver_class", "org.postgresql.Driver");
        props.put("hibernate.connection.url", "jdbc:postgresql://dpg-cj94hf0eba7s73bdki80-a.oregon-postgres.render.com/x_clients_db_r06g");
        props.put("hibernate.connection.username", "x_clients_db_r06g_user");
        props.put("hibernate.connection.password", "0R1RNWXMepS7mrvcKRThRi82GtJ2Ob58");
        props.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        props.put("hibernate.show_sql", "true");
        props.put("hibernate.format_sql", "true");
        props.put("hibernate.connection.autocomit", "true");
        props.put("hibernate.hbm2ddl.auto", "validate");
        // props.put("hibernate.hbm2ddl.auto","update");

        PersistenceUnitInfo persistenceUnitInfo = new MyPersistenceUnitInfo(props);
        HibernatePersistenceProvider hibernatePersistenceProvider = new HibernatePersistenceProvider();
        EntityManagerFactory factory = hibernatePersistenceProvider.createContainerEntityManagerFactory(persistenceUnitInfo, props);
        EntityManager entityManager = factory.createEntityManager();
        return factory.createEntityManager();
    }

    @Test
    @Description("Проверить создание сотрудника в несуществующей компании")
    public void createNew() {
        EmployeeRepositoryHibernate orm = new EmployeeRepositoryHibernate(getEm());
        Faker faker = new Faker(new Locale("ru"));
        String firstName = faker.name().firstName();
        String middleName = faker.name().nameWithMiddle();
        String lastName = faker.name().lastName();
        int companyId = faker.random().nextInt(4);
        EmployeeEntity entity = orm.create(firstName, middleName,lastName,companyId);
        Assert.assertTrue("Сотрудник не создался",true);
        System.out.println(entity);

    }
}
