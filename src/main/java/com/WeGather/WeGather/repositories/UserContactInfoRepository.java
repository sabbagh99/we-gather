package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.UserContactInfo;
import com.WeGather.WeGather.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContactInfoRepository extends JpaRepository<UserContactInfo,Long> {
}
