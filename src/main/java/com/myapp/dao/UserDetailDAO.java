package com.myapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.entity.UserDetail;

@Repository
public interface UserDetailDAO extends JpaRepository<UserDetail, Long> {

}
