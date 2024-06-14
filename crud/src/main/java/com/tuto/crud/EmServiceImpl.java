package com.tuto.crud;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmServiceImpl implements EmService {

    @Autowired
    private EmRepo emRepo; //dependency injection

    @Override
    public List<Employee> readEmployees() {
        List<EmEntity> employeesList=emRepo.findAll();
        List<Employee> employees = new ArrayList<>();
        for(EmEntity emEntity:employeesList){
            Employee emp=new Employee();
            emp.setName(emEntity.getName());
            emp.setEmail(emEntity.getEmail());
            emp.setPhn(emEntity.getPhn());
            emp.setId(emEntity.getId());
            employees.add(emp);
        }
        return employees;
    }

    @Override
    public String createEmployee(Employee employee) {
        EmEntity emEntity = new EmEntity();
        BeanUtils.copyProperties(employee, emEntity);
        // employees.add(employee); doesnt store in database
        emRepo.save(emEntity);
        return "Saved";
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmEntity emp=emRepo.findById(id).get();
        emRepo.delete(emp);
        return true;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmEntity existingEmployee=emRepo.findById(id).get();
        existingEmployee.setName(employee.getName());
        existingEmployee.setPhn(employee.getPhn());
        existingEmployee.setEmail(employee.getEmail());
        emRepo.save(existingEmployee);
        return "Updated";
    }

}
