package com.assignment.services;

import java.util.List;

public interface TaskService {
	public List<String> getAllTasks() throws Exception;
	public List<String> getTaskWithThreeSubTask() throws Exception;
	public List<String> getTaskWithParentTaskAndSubTask() throws Exception;
	public List<String> getThirdLevelTask() throws Exception;
	
}
