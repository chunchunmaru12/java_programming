
package dao;

import model.Employee;
import java.util.List;

public interface EmployeeDAO {
    void addEmployee(Employee emp);
    Employee getEmployeeById(int id);
    List<Employee> getAllEmployees();
    void updateEmployee(Employee emp);
    void deleteEmployee(int id);
}
