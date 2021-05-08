package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments,Long> {
}
