package com.geekbrains.server.repositories;

import com.geekbrains.gwt.common.TaskDto;
import com.geekbrains.server.entities.Task;
import com.geekbrains.server.entities.Statuses;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long>, JpaSpecificationExecutor<Task> {
    //@Query("SELECT new com.geekbrains.gwt.common.TaskDto(t.id, t.name, t.ownerName, t.executorName, t.description) FROM Task t")
    //List<TaskDto> findAllDtos();
}