package com.assignment.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.services.TaskService;
@CrossOrigin
@RestController
public class TaskController {

@Autowired	
private TaskService taskService;
	
@GetMapping("/getAllTasks")
@ResponseBody
public ResponseEntity getAllTasks() {
	System.out.println( "Inside Controller");

    try {
    	List<String> tasks= null;
    	
    	tasks = taskService.getAllTasks();
        if (tasks == null) {
            return ResponseEntity.badRequest().body("Could not find Task.");
        }
        return ResponseEntity.ok(tasks);
    } catch (Exception e) {
     
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
    @GetMapping("/getTaskWithThreeSubTask")
    @ResponseBody
    public ResponseEntity getTaskWithThreeSubTask() {
    	System.out.println( "Inside Controller");

        try {
        	List<String> tasks= null;
        	
        	tasks = taskService.getTaskWithThreeSubTask();
            if (tasks == null) {
                return ResponseEntity.badRequest().body("Could not find Task.");
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
         
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
    @GetMapping("/getTaskWithParentTaskAndSubTask")
    @ResponseBody
    public ResponseEntity getTaskWithParentTaskAndSubTask() {
    	System.out.println( "Inside Controller");

        try {
        	List<String> tasks= null;
        	
        	tasks = taskService.getTaskWithParentTaskAndSubTask();
            if (tasks == null) {
                return ResponseEntity.badRequest().body("Could not find Task.");
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
         
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    
    @GetMapping("/getThirdLevelTask")
    @ResponseBody
    public ResponseEntity getgetThirdLevelTask() {
    	System.out.println( "Inside Controller");

        try {
        	List<String> tasks= null;
        	
        	tasks = taskService.getThirdLevelTask();
            if (tasks == null) {
                return ResponseEntity.badRequest().body("Could not find Task.");
            }
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
         
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
	
	
}
