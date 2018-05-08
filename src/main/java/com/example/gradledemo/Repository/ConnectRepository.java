package com.example.gradledemo.Repository;

import com.example.gradledemo.Domain.Connect;
import com.example.gradledemo.Domain.TwitterProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectRepository extends CrudRepository<Connect, Long> {

    public List<Connect> findByRelationalUsername(String username);

}
