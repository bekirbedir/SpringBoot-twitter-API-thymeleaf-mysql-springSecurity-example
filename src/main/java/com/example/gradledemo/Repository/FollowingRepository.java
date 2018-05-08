package com.example.gradledemo.Repository;

import com.example.gradledemo.Domain.Followers;
import com.example.gradledemo.Domain.Following;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends CrudRepository<Following, Long> {


}
