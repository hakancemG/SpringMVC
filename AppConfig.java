package com.hakancem.starter.config;

import com.hakancem.starter.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList(){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("1","Ali","Veli"));
        employeeList.add(new Employee("2","Ali","Cemil"));
        employeeList.add(new Employee("3","Hakan","Kaya"));
        employeeList.add(new Employee("4","Hakan","Timur"));
        employeeList.add(new Employee("5","Kerem","Aktürkoğlu"));
        employeeList.add(new Employee("6","Kerem","Demirbay"));
        return employeeList;
    }
}
