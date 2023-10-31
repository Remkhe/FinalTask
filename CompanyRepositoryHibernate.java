package Tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class CompanyRepositoryHibernate {
    private final EntityManager entityManager;

    public CompanyRepositoryHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<CompanyEntity> getIsActive(boolean is_active) {
        TypedQuery<CompanyEntity> selectIsActive = entityManager.createQuery("SELECT c from CompanyEntity c where c.isActive = " + is_active, CompanyEntity.class);
        return selectIsActive.getResultList();
    }

    public List<CompanyEntity> getList() {
        TypedQuery<CompanyEntity> selectAll = entityManager.createQuery("SELECT c from CompanyEntity c", CompanyEntity.class);
        return selectAll.getResultList();
    }

    public CompanyEntity create(String nameToBe, String descriptionToBe) {
        CompanyEntity newCompany = new CompanyEntity();
        newCompany.setName(nameToBe);
        newCompany.setDescription(descriptionToBe);
        newCompany.setCreateDateTime(Timestamp.valueOf(LocalDateTime.now()));
        newCompany.setLastChangedDateTime(Timestamp.valueOf(LocalDateTime.now()));
        newCompany.setActive(true);
        entityManager.getTransaction().begin();
        entityManager.persist(newCompany);
        entityManager.getTransaction().commit();
        //entityManager.remove(1);//удалять
        //entityManager.merge();//когда хотим update сущность, comit делаем везде через транзакцию
        return newCompany;
    }

    public CompanyEntity delete(int id) {
        CompanyEntity newCompany = new CompanyEntity();
        newCompany.setId(id);
        newCompany.setDeletedAt(Timestamp.valueOf(LocalDateTime.now()));
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
       // entityManager.merge(newCompany);//когда хотим update сущность, comit делаем везде через транзакцию
        return newCompany;
    }
    public int getCompanyId(String name ){
        TypedQuery<CompanyEntity> id = entityManager.createQuery("SELECT c.id from CompanyEntity c where c.name = "+name, CompanyEntity.class);
        return id.getSingleResult().getId();
    }
    public CompanyEntity getCompanyStatus (int id){
        TypedQuery<CompanyEntity> isActive = entityManager.createQuery("SELECT c from CompanyEntity c where c.id = "+id,CompanyEntity.class);
        return isActive.getSingleResult();
    }
}

