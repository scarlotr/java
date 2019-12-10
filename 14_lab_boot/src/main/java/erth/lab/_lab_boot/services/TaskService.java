package erth.lab._lab_boot.services;

import erth.lab._lab_boot.entities.Statuses;
import erth.lab._lab_boot.entities.Task;
import erth.lab._lab_boot.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskService() {
    }

    public List<Task> getTasksByFilter(Statuses status){
        return taskRepository.getTasksByFilter(status);
    }

    public void add(Task task){
        taskRepository.add(task);
    }

    public void del(int id){
        taskRepository.del(id);
    }

    public Task getTaskById(int id){
        return taskRepository.getTaskById(id);
    }
}
