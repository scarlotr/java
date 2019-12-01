package erth.lab;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskConfig.class);

        TaskService taskService = context.getBean("taskService", TaskService.class);
        taskService.addTask(new Task("Задача 3", "Сидоров", "Сидоров", "Сделать задачу"));
        taskService.delTask(20);
        taskService.print();

        taskService.disconnectRepository();
    }
}
