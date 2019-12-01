package erth.lab.controllers;

import erth.lab.entities.Task;
import erth.lab.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
public class TaskController {
    private TaskService taskService;

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(path="/", method = RequestMethod.GET)
    public String showAllTasks(Model model, @RequestParam(value = "note", required = false) String note){
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        String strNote = "Список задач обновлен";
        if (note != null && note.equals("del")){
            strNote = "Задача удалена";
        }
        else if (note != null && note.equals("add")){
            strNote = "Задача добавлена";
        }
        model.addAttribute("note", strNote);
        return "index";
    }
    //Добавление задачи
    @RequestMapping(path="/add_task", method = RequestMethod.GET)
    public String addTask(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "add_task";
    }

    @PostMapping("/add_task")
    public String processForm(@ModelAttribute("task") Task task) throws SQLException {
        taskService.addTask(task);
        return "redirect:/?note=add";
    }

    //Удаление задачи
    @GetMapping("/del/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id){
        taskService.delTask(id.intValue());
        return "redirect:/?note=del";
    }
}
