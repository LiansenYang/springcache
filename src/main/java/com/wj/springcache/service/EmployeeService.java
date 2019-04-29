package com.wj.springcache.service;

import com.wj.springcache.bean.Employee;
import com.wj.springcache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames="emp")
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable()
    public Employee getEmp(Integer id){
        System.out.println("query..." + id + "  employee");
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }

    @CachePut(key = "#employee.id")
    public Employee updateEmp(Employee employee){
        System.out.println("updateEmp" + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp", key = "#id")
    public void deleteEmp(Integer id){
        System.out.println("deleteEmp: " + id);
    }

    @Caching()
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);

    }
}
