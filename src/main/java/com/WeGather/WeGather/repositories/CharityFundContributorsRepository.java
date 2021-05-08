package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.CharityFundContributors;
import com.WeGather.WeGather.models.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CharityFundContributorsRepository extends CrudRepository<CharityFundContributors,Long> {
    @Query(value = "select * from charity_fund_contributors where raised_fund_id=?1 ",nativeQuery = true)
    public List<CharityFundContributors> findByFundRaiserId(Long id);

    @Query(value = "select * from charity_fund_contributors where user_fund_raiser_id=?1 ",nativeQuery = true)
    public List<CharityFundContributors> findByUserFundRaiserId(Long id);

    @Query(value = "select * from charity_fund_contributors",nativeQuery = true)
    public List<CharityFundContributors> findAllData();
}
