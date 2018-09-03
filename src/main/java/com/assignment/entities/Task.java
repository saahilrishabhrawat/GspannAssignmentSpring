package com.assignment.entities;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Task {
	public Task(){
		
	}
	public Task(String name){
		
		this.name = name;
	}
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Long id;
	    private String name;
	    
	    @OneToMany	    
	    private Set<Task> childTask = new HashSet();
	    @OneToMany
	    private Set<Task> parentTask = new HashSet();

	    
	    
	    public Set<Task> getParentTask() {
			return parentTask;
		}
		public void setParentTask(Set<Task> parentTask) {
			this.parentTask = parentTask;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Set<Task> getChildTask() {
			return childTask;
		}
		public void setChildTask(Set<Task> childTask) {
			this.childTask = childTask;
		}
}


