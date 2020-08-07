package com.vicky.itechapp;

import com.vicky.itechapp.model.Employee;
import com.vicky.itechapp.model.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @RequestMapping(value = "/employee/all")
    List<Employee> getEmployees(){
        List<Employee> employeeList = prepareData();
        return employeeList;
    }

/*    @RequestMapping(value = "/employee/1")
    public Employee getEmployeeOne(){
        List<Employee> employeeList = prepareData();
        for(Employee employee: employeeList) {
            if(employee.getId() == 1) {
                return employee;
            }
        }
        return null;
    }*/

    /*@RequestMapping(value = "/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id){
        List<Employee> employeeList = prepareData();
        for(Employee employee: employeeList) {
            if(employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }*/

    @RequestMapping(value = "/employee/{id}")
    public ResponseEntity getEmployeeById(@PathVariable("id") Integer id) {
        List<Employee> employeeList = prepareData();
        for(Employee employee: employeeList) {
            if(employee.getId() == id) {
                ResponseEntity responseEntity = new ResponseEntity(employee, HttpStatus.OK);
                return responseEntity;
            }
        }
        Map<String, String> map = new HashMap<>();
        map.put("message", "Employee not found");
        ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
        return responseEntity;
    }



    private List<Employee> prepareData() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setName("Vidhya");

        Role role = new Role();
        role.setDesignation("Chief Engineer");
        role.setDept("IT Dept");

        e1.setRole(role);

        Employee e2 = new Employee();
        e2.setId(2);
        e2.setName("Vandhana");

        Role role2 = new Role();
        role2.setDesignation("The CEO");
        role2.setDept("Management");
        e2.setRole(role2);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);

        return employeeList;
    }
}
