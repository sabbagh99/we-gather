package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Governorate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GovernorateRepository extends JpaRepository<Governorate,Long> {
}
