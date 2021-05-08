package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.CharityWorkContributors;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CharityWorkContributorsRepository extends CrudRepository<CharityWorkContributors,Long> {
    @Query(value = "select * from charity_work_contributors where worked_raiser_id=?1 ",nativeQuery = true)
    public List<CharityWorkContributors> findByWorkRaiserId(Long id);

    @Query(value = "select * from charity_work_contributors where user_work_raiser_id=?1 ",nativeQuery = true)
    public List<CharityWorkContributors> findByUserWorkRaiserId(Long id);

    @Query(value = "select * from charity_work_contributors",nativeQuery = true)
    public List<CharityWorkContributors> findContribute();


    @Query(value = "select user_work_raiser_id from charity_work_contributors where worked_raiser_id=?1",nativeQuery = true)
    public List<Integer> findContributorsIds(Long id);
}
