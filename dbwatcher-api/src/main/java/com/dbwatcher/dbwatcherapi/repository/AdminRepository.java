package com.dbwatcher.dbwatcherapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.dbwatcher.dbwatcherapi.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Query("select admin from Admin admin where admin.id < 3")
    List<Admin> findFirstThree();
}
