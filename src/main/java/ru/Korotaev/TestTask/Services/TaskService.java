package ru.Korotaev.TestTask.Services;

import ru.Korotaev.TestTask.Dao.ProjectDao;
import ru.Korotaev.TestTask.Dao.TaskDao;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;

public class TaskService {
    private TaskDao taskDao;

    public TaskService(){
        taskDao = new TaskDao();
    }
    public void selectAllTask(Task task){
        taskDao.selectAllTask(task);
    }
    public void selectTaskById(Task task){
        taskDao.selectTaskById(task);
    }
    public void saveTask(Task task){
        taskDao.save(task);
    }
    public void updateTask(Task task){
        taskDao.update(task);
    }
    public void deleteTask(Task task){
        taskDao.delete(task);
    }

}
