package com.assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.assignment.entities.Student;
import com.assignment.entities.Subject;
import com.assignment.entities.Task;
import com.assignment.repositories.StudentRepository;
import com.assignment.repositories.TaskRepositories;


@SpringBootApplication
@Configuration
@ComponentScan({"com.assignment", "com.assignment.entities", "com.assignment.repositories"})
@EnableJpaRepositories(basePackages = {"com.assignment.repositories"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class BootApplication implements CommandLineRunner{

	@Autowired
    private TaskRepositories taskRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... arg0) throws Exception {
		
taskRepository.deleteAll();

//		
		
		Task t1=new Task("Task1"); // Question 1 , having at least three task
		Task t2=new Task("Task2"); // Question 2 , having only one child and one parent
		Task t3=new Task("Task3"); // Question 2 , having Third level Task
		Task st11=new Task("SubTask11");
		Task st12=new Task("SubTask12");
		Task st13=new Task("SubTask13");
		Task st21=new Task("SubTask21");
		Task st31=new Task("SubTask31");
		Task st311=new Task("SubTask311");
		Task pt1=new Task("ParentTask1");
		Task pt2=new Task("ParentTask2");
		
		Set<Task> childtaskSet= new HashSet<>();
		childtaskSet.add(st11);
		childtaskSet.add(st12);
		childtaskSet.add(st13);
		t1.setChildTask(childtaskSet);
		
		Set<Task> childtaskSet2= new HashSet<>();
		childtaskSet2.add(st21);		
		t2.setChildTask(childtaskSet2);
		
		Set<Task> childtaskSet3= new HashSet<>();
		childtaskSet3.add(st31);		
		t3.setChildTask(childtaskSet3);
		
		Set<Task> childtaskSet31= new HashSet<>();
		childtaskSet31.add(st311);		
		st31.setChildTask(childtaskSet31);
		
		
		
		Set<Task> parenttaskSet1= new HashSet<>();
		parenttaskSet1.add(pt1);		
		t1.setParentTask(parenttaskSet1);
		
		
		Set<Task> parenttaskSet2= new HashSet<>();
		parenttaskSet2.add(pt2);	
		t2.setParentTask(parenttaskSet2);
		
		taskRepository.save(t1);
		taskRepository.save(t2);
		taskRepository.save(t3);
		taskRepository.save(st11);
		taskRepository.save(st12);
		taskRepository.save(st13);
		taskRepository.save(st21);
		taskRepository.save(st31);
		taskRepository.save(st311);		
		taskRepository.save(pt1);
		taskRepository.save(pt2);
		
		
		
		List<String> tasks=new ArrayList<String>();
		
	tasks=taskRepository.findTaskwithThreeSubtask();
	System.out.println("List with three tasks ");
	

	for (String task : tasks) {
		System.out.println(task);
	}
		
		
	}
}