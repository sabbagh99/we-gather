package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Suburb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuburbRepository extends JpaRepository<Suburb,Long> {
}
