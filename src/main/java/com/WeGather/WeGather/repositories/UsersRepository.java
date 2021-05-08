package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Admin;
import com.WeGather.WeGather.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public
interface UsersRepository extends JpaRepository<Users,Long> {

    public
    Users findByUsername(String userName);

//    Users findByUserId (Integer id);
}
