package com.geekbrains.gwt.client;

public class TasksClient_Generated_RestServiceProxy_ implements com.geekbrains.gwt.client.TasksClient, org.fusesource.restygwt.client.RestServiceProxy {
  private org.fusesource.restygwt.client.Resource resource = null;
  
  public void setResource(org.fusesource.restygwt.client.Resource resource) {
    this.resource = resource;
  }
  public org.fusesource.restygwt.client.Resource getResource() {
    if (this.resource == null) {
      String serviceRoot = org.fusesource.restygwt.client.Defaults.getServiceRoot();
      this.resource = new org.fusesource.restygwt.client.Resource(serviceRoot).resolve("/tasks");
    }
    return this.resource;
  }
  private org.fusesource.restygwt.client.Dispatcher dispatcher = null;
  
  public void setDispatcher(org.fusesource.restygwt.client.Dispatcher dispatcher) {
    this.dispatcher = dispatcher;
  }
  
  public org.fusesource.restygwt.client.Dispatcher getDispatcher() {
    return this.dispatcher;
  }
  public void deleteTask(java.lang.String token, java.lang.String id, org.fusesource.restygwt.client.MethodCallback<java.lang.Void> result) {
    final java.lang.String final_token = token;
    final java.lang.String final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/"+(id== null? null : com.google.gwt.http.client.URL.encodePathSegment(id))+"")
    .delete();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Void>(__method, result) {
        protected java.lang.Void parseResult() throws Exception {
          return (java.lang.Void) null;
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
  public void getAllTasks(java.lang.String token, java.lang.String name, java.lang.String owner, java.lang.String executor, java.lang.Long status, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.geekbrains.gwt.common.TaskDto>> tasks) {
    final java.lang.String final_token = token;
    final java.lang.String final_name = name;
    final java.lang.String final_owner = owner;
    final java.lang.String final_executor = executor;
    final java.lang.Long final_status = status;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .addQueryParam("owner", owner)
    .addQueryParam("executor", executor)
    .addQueryParam("name", name)
    .addQueryParam("status", (status != null ? status.toString() : null))
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.geekbrains.gwt.common.TaskDto>>(__method, tasks) {
        protected java.util.List<com.geekbrains.gwt.common.TaskDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.geekbrains.gwt.common.TaskDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      tasks.onFailure(__method,__e);
    }
  }
  public void getStatuses(java.lang.String token, org.fusesource.restygwt.client.MethodCallback<java.util.List<com.geekbrains.gwt.common.StatusDto>> statuses) {
    final java.lang.String final_token = token;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("/statuses")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.util.List<com.geekbrains.gwt.common.StatusDto>>(__method, statuses) {
        protected java.util.List<com.geekbrains.gwt.common.StatusDto> parseResult() throws Exception {
          try {
            return org.fusesource.restygwt.client.AbstractJsonEncoderDecoder.toList(com.google.gwt.json.client.JSONParser.parse(__method.getResponse().getText()), com.geekbrains.gwt.common.StatusDto_Generated_JsonEncoderDecoder_.INSTANCE);
          } catch (Throwable __e) {
            throw new org.fusesource.restygwt.client.ResponseFormatException("Response was NOT a valid JSON document", __e);
          }
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      statuses.onFailure(__method,__e);
    }
  }
  public void removeTask(java.lang.String token, java.lang.String id, org.fusesource.restygwt.client.MethodCallback<java.lang.Void> result) {
    final java.lang.String final_token = token;
    final java.lang.String final_id = id;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .resolve("remove/"+(id== null? null : com.google.gwt.http.client.URL.encodePathSegment(id))+"")
    .get();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Void>(__method, result) {
        protected java.lang.Void parseResult() throws Exception {
          return (java.lang.Void) null;
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
  public void save(java.lang.String token, com.geekbrains.gwt.common.TaskDto TaskDto, org.fusesource.restygwt.client.MethodCallback<java.lang.Void> result) {
    final java.lang.String final_token = token;
    final com.geekbrains.gwt.common.TaskDto final_TaskDto = TaskDto;
    final org.fusesource.restygwt.client.Method __method =
    getResource()
    .post();
    __method.setDispatcher(this.dispatcher);
    __method.header(org.fusesource.restygwt.client.Resource.HEADER_ACCEPT, org.fusesource.restygwt.client.Resource.CONTENT_TYPE_JSON);
    __method.header("Authorization", token);
    __method.json(com.geekbrains.gwt.common.TaskDto_Generated_JsonEncoderDecoder_.INSTANCE.encode(TaskDto));
    try {
      __method.send(new org.fusesource.restygwt.client.AbstractRequestCallback<java.lang.Void>(__method, result) {
        protected java.lang.Void parseResult() throws Exception {
          return (java.lang.Void) null;
        }
      });
    } catch (com.google.gwt.http.client.RequestException __e) {
      result.onFailure(__method,__e);
    }
  }
}
