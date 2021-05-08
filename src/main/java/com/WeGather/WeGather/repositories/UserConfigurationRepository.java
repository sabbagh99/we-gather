package com.WeGather.WeGather.repositories;
import com.WeGather.WeGather.models.UserConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserConfigurationRepository extends JpaRepository<UserConfiguration,Long> {
}