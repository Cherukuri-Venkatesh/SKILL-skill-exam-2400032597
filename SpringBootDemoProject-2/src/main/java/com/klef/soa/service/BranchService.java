package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Branch;

public interface BranchService
{
    Branch addBranch(Branch b);

    Branch updateBranch(Branch b);

    List<Branch> displayAllBranches();

    Branch displayBranchById(Long id);

    String deleteBranchById(Long id);

    List<Branch> findByName(String name);

    List<Branch> findByType(String type);
}