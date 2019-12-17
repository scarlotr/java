package com.geekbrains.gwt.client;

import com.geekbrains.gwt.common.StatusDto;
import com.geekbrains.gwt.common.TaskDto;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.*;
import java.util.List;

@Path("/tasks")
public interface TasksClient extends RestService {
    @GET
    void getAllTasks(@QueryParam("name") String name
                    ,@QueryParam("owner") String owner
                    ,@QueryParam("executor") String executor
                    ,@QueryParam("status") Long status
                    ,MethodCallback<List<TaskDto>> tasks
                    );

    @GET
    @Path("/statuses")
    void getStatuses(MethodCallback<List<StatusDto>> statuses);

    @GET
    @Path("remove/{id}")
    void removeTask(@PathParam("id") String id, MethodCallback<Void> result);

    @DELETE
    @Path("/{id}")
    void deleteTask(@PathParam("id") String id, MethodCallback<Void> result);

}
