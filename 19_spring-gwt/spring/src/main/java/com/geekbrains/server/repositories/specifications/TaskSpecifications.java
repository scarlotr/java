package com.geekbrains.server.repositories.specifications;

import com.geekbrains.server.entities.Statuses;
import com.geekbrains.server.entities.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecifications {
    public static Specification<Task> nameFilter (String name) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Task> ownerFilter (String owner) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("ownerName"), "%" + owner + "%");
    }

    public static Specification<Task> executorFilter (String executor) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("executorName"), "%" + executor + "%");
    }

    public static Specification<Task> statusFilter (Long status) {
        return (Specification<Task>) (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), Statuses.getStatusById(status.intValue()));
    }
}