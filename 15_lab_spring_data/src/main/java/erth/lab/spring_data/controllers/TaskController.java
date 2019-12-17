package erth.lab.spring_data.controllers;

import erth.lab.spring_data.entities.Task;
import erth.lab.spring_data.repositories.specifications.TaskSpecifications;
import erth.lab.spring_data.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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
    public String index(Model model
                        ,@RequestParam(defaultValue = "1") Long pageNumber
                        ,@RequestParam (required = false) String name
                        ,@RequestParam (required = false) Long status
                        ) {
        int tasksPerPage = 5;
        if (pageNumber < 1L) {
            pageNumber = 1L;
        }
        Specification<Task> spec = Specification.where(null);

        //Spec
        if (name != null && !name.equals("null")) {
            spec = spec.and(TaskSpecifications.nameFilter(name));
        }
        if (status != null && status > 0) {
            spec = spec.and(TaskSpecifications.statusFilter(status));
        }


        Page<Task> tasksPage = taskService.getTasksByFilter(spec, PageRequest.of(pageNumber.intValue() - 1, tasksPerPage, Sort.Direction.ASC, "id"));
        model.addAttribute("tasksPage", tasksPage);

        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        Task task = new Task();
        model.addAttribute("task", task);
        return "add_task";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("task") @Valid Task task
                        , BindingResult bindingResult
                        , @RequestParam Map<String, String> params
                        ,Model model
                      ){
        taskService.add(task);
        return "redirect:/";
    }

    //Просмотр задачи
    @GetMapping("/task/{id}")
    public String viewTask(Model model, @PathVariable(value = "id") Long id){
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return "view_task";
    }

    //Удаление задачи
    @GetMapping("/del/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id){
        taskService.del(id);
        return "redirect:/";
    }
}
