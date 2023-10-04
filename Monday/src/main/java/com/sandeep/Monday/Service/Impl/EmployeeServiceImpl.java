package com.sandeep.Monday.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sandeep.Monday.Model.Employee;
import com.sandeep.Monday.Repository.EmployeeRepository;
import com.sandeep.Monday.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee created successfully";
    }

    @Override
    public String updateEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            employeeRepository.save(employee); 
            return "Employee updated successfully";
        } else {
            return "Employee not found";
        }
    }

    @Override
    public String deleteEmployee(String employeeId) {
        // Implement the logic to delete an employee by ID
        // Add validation and error handling as needed
        Long id = Long.parseLong(employeeId);
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return "Employee deleted successfully";
        } else {
            return "Employee not found";
        }
    }

    @Override
    public Employee getEmployee(String employeeId) {
        Long id = Long.parseLong(employeeId);
        return employeeRepository.findById(id).orElse(null); 
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
