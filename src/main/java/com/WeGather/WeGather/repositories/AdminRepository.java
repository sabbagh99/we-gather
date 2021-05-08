package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Admin;
import com.WeGather.WeGather.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface AdminRepository extends JpaRepository<Admin,Long> {

}
