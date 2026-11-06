package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Branch;
import com.klef.soa.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController
{
	@Autowired
	private BranchService service;

	@GetMapping("/")
	public String demo()
	{
		return "Spring Boot Project";
	}

	// Add Branch
	@PostMapping("/add")
	public ResponseEntity<Branch> addBranch(@RequestBody Branch b)
	{
		Branch branch = service.addBranch(b);
		return ResponseEntity.status(201).body(branch);
	}

	// Display All Branches
	@GetMapping("/displayall")
	public ResponseEntity<List<Branch>> displayAllBranches()
	{
		List<Branch> branches = service.displayAllBranches();
		return ResponseEntity.status(200).body(branches);
	}

	// Display Branch By ID
	@GetMapping("/display")
	public ResponseEntity<?> displayBranchById(@RequestParam Long id)
	{
		Branch branch = service.displayBranchById(id);

		if(branch != null)
		{
			return ResponseEntity.status(200).body(branch);
		}
		else
		{
			return ResponseEntity.status(404).body("Branch ID Not Found");
		}
	}

	// Update Branch
	@PutMapping("/update")
	public ResponseEntity<?> updateBranch(@RequestBody Branch branch)
	{
		Branch b = service.updateBranch(branch);

		if(b != null)
		{
			return ResponseEntity.ok(b);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Branch ID Not Found");
		}
	}

	// Delete Branch By ID
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBranchById(@PathVariable Long id)
	{
		String message = service.deleteBranchById(id);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// Display Branches By Name
	@GetMapping("/displaybyname/{name}")
	public ResponseEntity<List<Branch>> displayBranchesByName(@PathVariable String name)
	{
		List<Branch> branches = service.findByName(name);
		return ResponseEntity.status(200).body(branches);
	}

	// Display Branches By Type
	@GetMapping("/displaybytype/{type}")
	public ResponseEntity<List<Branch>> displayBranchesByType(@PathVariable String type)
	{
		List<Branch> branches = service.findByType(type);
		return ResponseEntity.status(200).body(branches);
	}
}