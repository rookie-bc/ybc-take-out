package com.ybc.service;

import com.ybc.dto.EmployeeDTO;
import com.ybc.dto.EmployeeLoginDTO;
import com.ybc.dto.EmployeePageQueryDTO;
import com.ybc.entity.Employee;
import com.ybc.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * 新增员工
     * @param employeeDTO
     */
    void save(EmployeeDTO employeeDTO);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
}
