package com.klef.soa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klef.soa.entity.Branch;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long>
{
    public List<Branch> findByName(String name);

    public List<Branch> findByType(String type);
}