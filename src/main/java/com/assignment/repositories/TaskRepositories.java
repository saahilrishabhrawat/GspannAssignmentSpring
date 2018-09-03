package com.assignment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.assignment.entities.Task;



public interface TaskRepositories extends JpaRepository <Task, Long> 
{
	
    @Query(nativeQuery=true,
    		value = 
    		"SELECT task.name "+
    		"FROM task_child_task "+ 
    		"INNER JOIN task on task.id=task_child_task.task_id "+
    		"GROUP BY task_id "+
    		"HAVING COUNT(task_id) > 2 ")
    public List<String> findTaskwithThreeSubtask();
    
    
    @Query(nativeQuery=true,
    		value = 
    				"select distinct task.name from task "+
    		        "inner join task_child_task on "+ 
    				"task.id = task_child_task.task_id "+
    		        "inner join task_parent_task on "+
    				"task.id = task_parent_task.task_id ")
    public List<String> findTaskWithParentTaskAndSubTask();
    
    
    
    @Query(nativeQuery=true,
    		value = 
    				"select name from task where id in " + 
    				"(select child_task_id from task_child_task where task_id in " + 
    				"(select child_task_id from task_child_task where task_id in " + 
    				"(select task_id from task_child_task))) ")
    public List<String> findThirdLevelTask();

    @Query(nativeQuery=true,
    		value = 
    				"select name from task ")
	public List<String> findAllTask();
    
	
    

}
