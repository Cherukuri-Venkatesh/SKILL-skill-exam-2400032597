package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Branch;
import com.klef.soa.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService
{

	@Autowired
	private BranchRepository repo;

	@Override
	public Branch addBranch(Branch b)
	{
		return repo.save(b);
	}

	@Override
	public Branch updateBranch(Branch b)
	{
		Optional<Branch> optional = repo.findById(b.getId());

		if(optional.isPresent())
		{
			Branch branch = optional.get();

			branch.setName(b.getName());
			branch.setType(b.getType());
			branch.setStatus(b.isStatus());
			branch.setLocation(b.getLocation());

			return repo.save(branch);
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Branch> displayAllBranches()
	{
		return repo.findAll();
	}

	@Override
	public Branch displayBranchById(Long id)
	{
		return repo.findById(id).orElse(null);
	}

	@Override
	public String deleteBranchById(Long id)
	{
		boolean flag = repo.existsById(id);

		if(flag)
		{
			repo.deleteById(id);
			return "Branch Deleted Successfully";
		}
		else
		{
			return "Branch ID Not Found";
		}
	}

	@Override
	public List<Branch> findByName(String name)
	{
		return repo.findByName(name);
	}

	@Override
	public List<Branch> findByType(String type)
	{
		return repo.findByType(type);
	}

}