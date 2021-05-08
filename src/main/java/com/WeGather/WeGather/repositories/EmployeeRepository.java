package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Employee;
import com.WeGather.WeGather.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface EmployeeRepository extends JpaRepository<Employee,Long> {


}
