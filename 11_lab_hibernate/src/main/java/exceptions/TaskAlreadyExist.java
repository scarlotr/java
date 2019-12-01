package exceptions;

public class TaskAlreadyExist extends RuntimeException {
    public TaskAlreadyExist(String message) {
        super(message);
    }
}