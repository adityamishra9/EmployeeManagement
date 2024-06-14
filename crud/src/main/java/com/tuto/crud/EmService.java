package com.tuto.crud;

import java.util.List;

public interface EmService {
    List<Employee> readEmployees();
    String createEmployee(Employee employee);
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
}
