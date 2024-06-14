package com.tuto.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin("http://localhost:3000")
@RestController
public class EmController {
    
    
    // dependency injection : object hum nhi bnate, IOC Container bna deta h
    @Autowired
    EmService emService; // EmService emService=new EmServiceImpl();

    @GetMapping("emp")
    public List<Employee> getAllEmployees(){
        return emService.readEmployees();
    }

    @PostMapping("emp")
    public String creatEmployee(@RequestBody Employee employee) {
        return emService.createEmployee(employee);
    }

    @DeleteMapping("emp/{id}")
    public String deleteEmployee(@PathVariable Long id){
        if(emService.deleteEmployee(id))
        return "Deleted";
        else 
        return "Not found";
    }

    @PutMapping("emp/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return emService.updateEmployee(id, employee);
    }
    
}
