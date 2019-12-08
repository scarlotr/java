package erth.lab._lab_boot.repositories;

import erth.lab._lab_boot.entities.Statuses;
import erth.lab._lab_boot.entities.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class TaskRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public TaskRepository() {
    }

    //Возваращет задачи по условию
    public List<Task> getTasksByFilter(Statuses status) {
        String strQuery = "SELECT t FROM Task t WHERE t.status = :status or :status is null";

        return entityManager.createQuery(strQuery, Task.class).setParameter("status", status) .getResultList();
    }

    public void add(Task task){
        entityManager.persist(task);
    }

    public void del(int id){
        entityManager.createQuery("DELETE FROM Task t WHERE t.id = :id").setParameter("id", id).executeUpdate();
    }

    public Task getTaskById(int id){
        return entityManager.find(Task.class, id);
    }

}
