package com.example.demo.repository;

import com.example.demo.model.MembersDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MembersDB,Long> {
    Iterable<MembersDB> findByName(String name);
}
