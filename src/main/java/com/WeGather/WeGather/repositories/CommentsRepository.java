package com.WeGather.WeGather.repositories;

import com.WeGather.WeGather.models.Comments;
import com.WeGather.WeGather.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {


    @Query(value = "SELECT * FROM  comments where raised_work_fund_id =?1", nativeQuery = true)
    public List<Comments> findRaisedWorkFundId(Long raised_work_fund_id);




    @Query(value = "SELECT * FROM  comments c Full outer join users u on  u.id= c.user_id where raised_work_fund_id=?1 and comment_type_id =?2", nativeQuery = true)
    public List<Comments> findComment(Long user_id,Long status);

//    @Query(value = "SELECT * FROM  comments where user_id =?1", nativeQuery = true)
//    public List<Comments> findUserId(Long user_id);
}
