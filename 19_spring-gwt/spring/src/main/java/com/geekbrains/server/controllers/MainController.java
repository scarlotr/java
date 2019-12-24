package com.geekbrains.server.controllers;

import com.geekbrains.gwt.common.ErrorDto;
import com.geekbrains.gwt.common.StatusDto;
import com.geekbrains.gwt.common.TaskDto;
import com.geekbrains.server.entities.Statuses;
import com.geekbrains.server.entities.Task;
import com.geekbrains.server.exceptions.ResourceAlreadyExistException;
import com.geekbrains.server.repositories.specifications.TaskSpecifications;
import com.geekbrains.server.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class MainController {
    private TaskService taskService;

    @Autowired
    public MainController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<TaskDto> getAllTasks(@RequestParam(name = "name", required = false) String name
                                     ,@RequestParam(name = "owner", required = false) String owner
                                     ,@RequestParam(name = "executor", required = false) String executor
                                     ,@RequestParam(name = "status", required = false) Long status
                                    ) {
        Specification<Task> spec = Specification.where(null);

        if (name != null && !name.equals("null")){
            spec = spec.and(TaskSpecifications.nameFilter(name));
        }
        if (owner != null && !owner.equals("null")){
            spec = spec.and(TaskSpecifications.ownerFilter(owner));
        }
        if (executor != null && !executor.equals("null")){
            spec = spec.and(TaskSpecifications.executorFilter(executor));
        }
        if (status != null && status > 0) {
            spec = spec.and(TaskSpecifications.statusFilter(status));
        }

        List<TaskDto> tasks = taskService.findAll(spec);
        return tasks;
    }

    @GetMapping("/tasks/statuses")
    public List<StatusDto> getStatuses() {
        List<StatusDto> statuses = new ArrayList<>();
        for (Statuses s: Statuses.values()) {
            statuses.add(new StatusDto(s.getStatusId(), s.toString()) );
        }
        return statuses;
    }

    @GetMapping("/tasks/remove/{id}")
    public ResponseEntity<String> removeTasks(@PathVariable Long id) {
        taskService.del(id);
        return new ResponseEntity<String>("Successfully removed", HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.del(id);
        return new ResponseEntity<String>("Successfully removed", HttpStatus.OK);
    }

    @PostMapping("/tasks")
    public TaskDto createNewTask(@ModelAttribute TaskDto taskDto) {
        return taskService.save(taskDto);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> exceptionInterceptor(ResourceAlreadyExistException exc){
        ErrorDto errorDto = new ErrorDto(HttpStatus.BAD_REQUEST.value(), exc.getMessage());
        ResponseEntity<ErrorDto> res = new ResponseEntity<ErrorDto>(errorDto, HttpStatus.BAD_REQUEST);

        return res;
    }
}