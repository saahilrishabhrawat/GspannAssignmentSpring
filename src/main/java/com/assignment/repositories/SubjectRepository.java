package com.assignment.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.assignment.entities.Subject;

@RepositoryRestResource(collectionResourceRel = "subject", path = "subject")
public interface SubjectRepository extends PagingAndSortingRepository<Subject, Integer> 
{
	

}
