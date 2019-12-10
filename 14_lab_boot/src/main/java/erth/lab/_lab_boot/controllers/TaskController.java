package erth.lab._lab_boot.controllers;

import erth.lab._lab_boot.entities.Statuses;
import erth.lab._lab_boot.entities.Task;
import erth.lab._lab_boot.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class TaskController {
    private TaskService taskService;

    public TaskController() {
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Task> tasks = taskService.getTasksByFilter(null);
        model.addAttribute("tasks", tasks);
        List<Statuses> statuses = Arrays.asList(new Statuses[]{Statuses.NEW, Statuses.IN_WORK, Statuses.CLOSED});
        model.addAttribute("statuses", statuses);
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "add_task";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("task") Task task){
        taskService.add(task);
        return "redirect:/";
    }

    //Просмотр задачи
    @GetMapping("/task/{id}")
    public String viewTask(Model model, @PathVariable(value = "id") Long id){
        Task task = taskService.getTaskById(id.intValue());
        model.addAttribute("task", task);
        return "view_task";
    }

    //Удаление задачи
    @GetMapping("/del/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id){
        taskService.del(id.intValue());
        return "redirect:/";
    }

    @PostMapping({"/filter"})
    public String filter(@RequestParam(value = "statusId", required = false) Long statusId, Model model) {
        Statuses status = Statuses.getStatusById(statusId.intValue());
        List<Task> tasks = taskService.getTasksByFilter(status);
        model.addAttribute("tasks", tasks);
        List<Statuses> statuses = Arrays.asList(new Statuses[]{Statuses.NEW, Statuses.IN_WORK, Statuses.CLOSED});
        model.addAttribute("statuses", statuses);
        model.addAttribute("curStatus", statusId.intValue());
        return "index";
    }
}
