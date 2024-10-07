package com.hakancem.starter.repository;

import com.hakancem.starter.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployeeList() {
        return employeeList;
    }

    public Employee getEmployeeById(String id) {
        Employee findEmployee = null;
        for (Employee employee : employeeList) {
            if (id.equals(employee.getId())) {
                findEmployee = employee;
                break;
            }
        }
        return findEmployee;
    }

    public List<Employee> getEmployeeWithParams(String firstName, String lastName) {
        List<Employee> employeeListWithParams = new ArrayList<>();
        if (firstName == null && lastName == null) {
            return employeeList;
        }
        for (Employee employee : employeeList) {
            if (firstName != null && lastName != null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)
                        && employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeListWithParams.add(employee);
                }
            }
            if (firstName != null && lastName == null) {
                if (employee.getFirstName().equalsIgnoreCase(firstName)) {
                    employeeListWithParams.add(employee);
                }
            }
            if (lastName != null && firstName == null) {
                if (employee.getLastName().equalsIgnoreCase(lastName)) {
                    employeeListWithParams.add(employee);
                }
            }
        }
        return employeeListWithParams;
    }

    public Employee saveEmployee(Employee newEmployee){
        employeeList.add(newEmployee);
        return newEmployee;
    }

    public boolean deleteEmployee(String id){
        Employee deleteEmployee = null;
        for(Employee employee:employeeList){
            if(id.equals(employee.getId())){
                deleteEmployee = employee;
                break;
            }
        }
        if(id!=null)
            employeeList.remove(deleteEmployee);
        return true;
    }

    public Employee updateEmployee(String id, Employee updatedEmployee){
        Employee newUpdatedEmployee = null;
        for(Employee employee:employeeList){
            if(id.equals(employee.getId())){
                employeeList.remove(employee);
                newUpdatedEmployee = employee;
                break;
            }
        }
        if(id!=null){
            employeeList.add(updatedEmployee);
        }
        return updatedEmployee;
    }

}
