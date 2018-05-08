package com.example.gradledemo.Repository;

import com.example.gradledemo.Domain.Connect;
import com.example.gradledemo.Domain.Followers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepository extends CrudRepository<Followers, Long> {


}
