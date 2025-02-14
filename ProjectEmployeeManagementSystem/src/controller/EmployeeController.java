
package controller;

import dao.EmployeeDAO;
import dao.impl.EmployeeDAOImpl;
import model.Employee;
import java.util.List;

public class EmployeeController {
    private EmployeeDAO employeeDAO = new EmployeeDAOImpl();

    public void addEmployee(String name, String department, double salary) {
        Employee emp = new Employee(0, name, department, salary);
        employeeDAO.addEmployee(emp);
    }

    public Employee getEmployee(int id) {
        return employeeDAO.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    public void updateEmployee(int id, String name, String department, double salary) {
        Employee emp = new Employee(id, name, department, salary);
        employeeDAO.updateEmployee(emp);
    }

    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
