package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictRepository extends JpaRepository<District,Long> {


}
