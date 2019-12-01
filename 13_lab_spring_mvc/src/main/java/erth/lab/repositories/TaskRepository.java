package erth.lab.repositories;

import erth.lab.entities.Task;
import java.sql.SQLException;
import java.util.List;

public interface TaskRepository {
    void addTask(Task task) throws SQLException;
    void delTask(int id);
    void delTask(String name);
    List<Task> getAllTasks();
}