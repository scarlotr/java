package erth.lab.spring_data.repositories.specifications;

import erth.lab.spring_data.entities.Task;
import erth.lab.spring_data.entities.Statuses;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {
    public static Specification<Task> nameFilter (String name) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Task> statusFilter (Long status) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), Statuses.getStatusById(status.intValue()));
    }
}