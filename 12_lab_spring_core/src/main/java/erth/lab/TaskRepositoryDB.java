package erth.lab;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@Repository
public class TaskRepositoryDB implements TaskRepository{
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
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
    }

    @Override
    public void delTask(int id) {
        System.out.println("Удаление задачи по ID");
        session = factory.getCurrentSession();
        session.beginTransaction();
        Task delTask = session.get(Task.class, id);
        if (delTask != null){
            session.delete(delTask);
        }
        session.getTransaction().commit();
    }

    @Override
    public void delTask(String name) {
        System.out.println("Удаление задачи по NAME");
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Task> delTasks = session.createQuery("SELECT t FROM Task t WHERE t.name LIKE :name", Task.class).setParameter("name", name).getResultList();
        Iterator<Task> iter = delTasks.iterator();
        while (iter.hasNext()){
            session.delete(iter.next());
        }
        session.getTransaction().commit();
    }

    @Override
    public List<Task> getAllTasks() {
        System.out.println("Получение списка задач");
        session = factory.getCurrentSession();
        session.beginTransaction();
        List<Task> allTasks = session.createQuery("SELECT t FROM Task t", Task.class).getResultList();
        session.getTransaction().commit();

        return allTasks;
    }

    @Override
    public void disconnectRepository() {
        System.out.println("Дисконнект с БД");
        factory.close();
        if (session != null){
            session.close();
        }
    }
}
