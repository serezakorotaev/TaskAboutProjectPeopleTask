package ru.Korotaev.TestTask;

import ru.Korotaev.TestTask.Dao.ReadInJSonAndWriteInDB;
import ru.Korotaev.TestTask.Dao.WriteOnConsoleAllInformation;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskOne;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskTwo;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;
import ru.Korotaev.TestTask.Services.ProjectService;
import ru.Korotaev.TestTask.Services.Servicesforchaptertwo.SubtaskOneService;
import ru.Korotaev.TestTask.Services.Servicesforchaptertwo.SubtaskTwoService;
import ru.Korotaev.TestTask.Services.TaskService;
import ru.Korotaev.TestTask.Services.UserService;


public class unMarshJson {
    public static void main(String[] args) {
        ReadInJSonAndWriteInDB readInJSonAndWriteInDB = new ReadInJSonAndWriteInDB();
        readInJSonAndWriteInDB.readInJSonAndWriteInDB();

        //Create new project, user on the project and tasks for user
        ////////////////////////////////////////
        ProjectService projectService = new ProjectService();
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        SubtaskOneService subtaskOneService = new SubtaskOneService();
        SubtaskTwoService subtaskTwoService = new SubtaskTwoService();
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
        //Create subtask for task
        SubtaskOne subtaskOne = new SubtaskOne("make sketches", 11);
        subtaskOne.setTask(task);
        task.addSubtaskOne(subtaskOne);
        subtaskOneService.saveSubtaskOne(subtaskOne);
        taskService.updateTask(task);
        //Create subtask for subtask on task
        SubtaskTwo subtaskTwo = new SubtaskTwo("sharpen your pencils", 12);
        subtaskTwo.setSubtaskOne(subtaskOne);
        subtaskOne.addSubtaskTwo(subtaskTwo);
        subtaskTwoService.saveSubtaskTwo(subtaskTwo);
        subtaskOneService.updateSubtaskOne(subtaskOne);
        ////////////////////////////////////////
        System.out.println();
        //This part on this code write all information from database
        WriteOnConsoleAllInformation writeOnConsoleAllInformation = new WriteOnConsoleAllInformation();
        writeOnConsoleAllInformation.allInformationAboutProjectsUsersAndTasks();
    }
}
