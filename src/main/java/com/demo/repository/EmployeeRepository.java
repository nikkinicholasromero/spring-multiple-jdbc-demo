package com.demo.repository;

import com.demo.mapper.EmployeeMapper;
import com.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {
    private static final String FIND_ALL = "SELECT * FROM EMPLOYEES";

    @Autowired
    @Qualifier("namedParameterJdbcTemplate1")
    private NamedParameterJdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("namedParameterJdbcTemplate2")
    private NamedParameterJdbcTemplate jdbcTemplate2;

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        employees.addAll(jdbcTemplate1.query(FIND_ALL, employeeMapper));
        employees.addAll(jdbcTemplate2.query(FIND_ALL, employeeMapper));
        return employees;
    }
}
