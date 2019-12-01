public class MainClass {
    public static void main(String[] args)
    {
        Task task1 = new Task(1, "Сделать ДЗ", "Иванов", "Петров", "Вовремя сделать ДЗ");
        Task task2 = new Task(2, "Поспать", "Пупкин", "Пупкин", "Хорошенько поспать");
        Task task3 = new Task(3, "Задача 3", "Сидоров", "Сидоров", "Сделать задачу");
        Task task4 = new Task(4, "Задача 4", "Сидоров", "Сидоров", "Сделать задачу");
        Task task5 = new Task(5, "Задача 5", "Сидоров", "Сидоров", "Сделать задачу");
        Task task6 = new Task(6, "Задача 6", "Сидоров", "Сидоров", "Сделать задачу");
        Task task7 = new Task(7, "Задача 7", "Сидоров", "Сидоров", "Сделать задачу");
        task1.setStatus(Task.Statuses.IN_WORK);
        task2.setStatus(Task.Statuses.CLOSED);
        task3.setStatus(Task.Statuses.IN_WORK);
        System.out.println(task1);
        System.out.println(task2);

        TaskService taskService = new TaskService("Список 1");

        taskService.addTask(task1);
        taskService.addTask(task2);
        taskService.addTask(task3);
        taskService.addTask(task4);
        taskService.addTask(task5);
        taskService.addTask(task6);

        taskService.print();

        taskService.delTask(5);
        taskService.delTask("Задача 5");
        taskService.addTask(task7);
        taskService.print();

        System.out.println("Stream API:");
        System.out.println(taskService.getTasksByStatus(Task.Statuses.IN_WORK));
        System.out.println("id 1 - " + taskService.isTaskExist(1));
        System.out.println("id 8 - " + taskService.isTaskExist(8));
        System.out.println(taskService.getTasksSortedByStatus());
        System.out.println("Новых задач : " + taskService.getCntTasksWithStatus(Task.Statuses.NEW));
        System.out.println("В работе : " + taskService.getCntTasksWithStatus(Task.Statuses.IN_WORK));
        System.out.println("Закрытых : " + taskService.getCntTasksWithStatus(Task.Statuses.CLOSED));

        System.out.println("IO:");
        taskService.exportToFile("tasks.dat", taskService.getTasksByStatus(Task.Statuses.IN_WORK));
        System.out.println(taskService.importFromFile("tasks.dat"));
    }
}