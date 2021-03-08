package ru.Korotaev.TestTask;

import ru.Korotaev.TestTask.Dao.ReadInJSonAndWriteInDB;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;
import ru.Korotaev.TestTask.Services.ProjectService;
import ru.Korotaev.TestTask.Services.TaskService;
import ru.Korotaev.TestTask.Services.UserService;


public class unMarshJson {
    public static void main(String[] args) {
        ReadInJSonAndWriteInDB readInJSonAndWriteInDB = new ReadInJSonAndWriteInDB();
        readInJSonAndWriteInDB.readInJSonAndWriteInDB();

        //Create new project, user on the project and tasks for user

        ProjectService projectService = new ProjectService();
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        //Create new Project
        Project project = new Project("Build Town");
        projectService.saveProject(project);

        //Create new User on this project
        User newUser = new User("Sergey");
        newUser.setProject(project);
        project.addUser(newUser);
        userService.saveUser(newUser);
        projectService.updateProject(project);
        //Create new task for user
        Task task = new Task("Create drawing by town");
        task.setUser(newUser);
        newUser.addTask(task);
        taskService.saveTask(task);
        userService.updateUser(newUser);
        System.out.println("Project created");
    }
}
