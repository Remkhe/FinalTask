package Tests;

import jakarta.persistence.EntityManager;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class EmployeeRepositoryHibernate {
    private final EntityManager entityManager;
    private Object EmployeeEntity;

    public EmployeeRepositoryHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public EmployeeEntity create(String firstName, String middleName,String lastName,int companyId) {
        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setFirstName(firstName);
        newEmployee.setMiddleName(middleName);
        newEmployee.setLastName(lastName);

        newEmployee.setCompanyId(companyId);
        newEmployee.setCreateDateTime(Timestamp.valueOf(LocalDateTime.now()));
        newEmployee.setLastChangedDateTime(Timestamp.valueOf(LocalDateTime.now()));
        entityManager.getTransaction().begin();
        return newEmployee;
    }
}
