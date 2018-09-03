package com.assignment.services.serviceImpls;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.repositories.TaskRepositories;
import com.assignment.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	
	
	
/**
 * Injecting Dependency for Repository
 */
	@Autowired
	private TaskRepositories taskRepository;
	
	
	
	/**
	 * Return All Tasks
	 */
	@Override
	public List<String> getAllTasks() throws Exception {
		List<String> tasks = new ArrayList<String>();
		tasks = taskRepository.findAllTask();
		return tasks;
	}
	
	
/**
 * Return tasks with at least three sub tasks
 */
	@Override
	public List<String> getTaskWithThreeSubTask() throws Exception {

		List<String> tasks = new ArrayList<String>();
		tasks = taskRepository.findTaskwithThreeSubtask();
		return tasks;

	}
	
	
	
	/**
	 * Return tasks with parent and child  tasks
	 */
	@Override
	public List<String> getTaskWithParentTaskAndSubTask() throws Exception {

		List<String> tasks = new ArrayList<String>();

		tasks = taskRepository.findTaskWithParentTaskAndSubTask();
		return tasks;

	}
	
	
	/**
	 * Return tasks at third level in heirarchy
	 */
	@Override
	public List<String> getThirdLevelTask() throws Exception {

		List<String> tasks = new ArrayList<String>();
		tasks = taskRepository.findThirdLevelTask();
		return tasks;
	}





}
