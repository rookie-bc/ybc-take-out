package com.ybc.service;

import com.ybc.dto.EmployeeLoginDTO;
import com.ybc.entity.Employee;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

}
