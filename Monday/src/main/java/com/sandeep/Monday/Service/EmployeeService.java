package com.sandeep.Monday.Service;

import java.util.List;

import com.sandeep.Monday.Model.Employee;

public interface EmployeeService {
    public String createEmployee(Employee employee);
    public String updateEmployee(Employee employee);
    public String deleteEmployee(String employeerId);
    public Employee getEmployee(String employeeId);
    public List<Employee> getAllEmployees();
}
