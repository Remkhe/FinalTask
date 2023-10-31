package Tests;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jdk.jfr.Description;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

public class CompanyTest {
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
    public void findAll() {
        CompanyRepositoryHibernate orm = new CompanyRepositoryHibernate(getEm());
        List<CompanyEntity> entity = orm.getList();
        System.out.println(entity.size());
    }

    @Test
    @Description("Проверка фильтра isActive")
    public void findIsActive() {
        CompanyRepositoryHibernate orm = new CompanyRepositoryHibernate(getEm());
        int allCompanies = orm.getList().size();
        int notActiveCompanies = orm.getIsActive(false).size();
        int activeCompanies = orm.getIsActive(true).size();
        Assert.assertEquals("Фильтрация работает неверно", allCompanies, notActiveCompanies + activeCompanies);


    }

    @Test
    @Description("Проверить, что у удаленной компании проставляется в БД поле deletedAt")
    public void createNew() {
        CompanyRepositoryHibernate orm = new CompanyRepositoryHibernate(getEm());

        Faker faker = new Faker(new Locale("ru"));
        String nameToBe = faker.company().name();
        String descriptionToBe = faker.address().fullAddress();
        CompanyEntity entity = orm.create(nameToBe, descriptionToBe);
        int companyId = entity.getId();
        orm.delete(companyId);
        System.out.println(orm.getCompanyStatus(companyId).isActive());
        Assert.assertFalse("Компания не удалилась", orm.getCompanyStatus(companyId).isActive());
    }
}