package erth.lab.repositories;

import erth.lab.entities.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Repository
@Transactional
public class TaskRepositoryDB implements TaskRepository {
    private Session session;
    private SessionFactory factory;

    public TaskRepositoryDB() {
    }

    @Autowired
    public void setFactory(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void addTask(Task task) throws SQLException {
        System.out.println("Добавление задачи");
        session = factory.getCurrentSession();
        session.save(task);
    }

    @Override
    public void delTask(int id) {
        System.out.println("Удаление задачи по ID");
        session = factory.getCurrentSession();
        Task delTask = session.get(Task.class, id);
        if (delTask != null){
            session.delete(delTask);
        }
    }

    @Override
    public void delTask(String name) {
        System.out.println("Удаление задачи по NAME");
        session = factory.getCurrentSession();
        List<Task> delTasks = session.createQuery("SELECT t FROM Task t WHERE t.name LIKE :name", Task.class).setParameter("name", name).getResultList();
        Iterator<Task> iter = delTasks.iterator();
        while (iter.hasNext()){
            session.delete(iter.next());
        }
    }

    @Override
    public List<Task> getAllTasks() {
        System.out.println("Получение списка задач");
        session = factory.getCurrentSession();
        List<Task> allTasks = session.createQuery("SELECT t FROM Task t", Task.class).getResultList();

        return allTasks;
    }
}