package Tests;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeEntity> getAll ();
    List<EmployeeEntity> getAll(boolean isActive);
    EmployeeEntity getById (int id);

    int create (String firstName, String middleName,String lastName,int companyId);
    void deleteById (int id);
}
