package ru.Korotaev.TestTask.Dao;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;
import ru.Korotaev.TestTask.Services.ProjectService;
import ru.Korotaev.TestTask.Services.TaskService;
import ru.Korotaev.TestTask.Services.UserService;

import java.io.FileReader;
import java.io.IOException;

public class ReadInJSonAndWriteInDB {
    public void readInJSonAndWriteInDB(){
        Project projectDB = new Project();
        User userDB = new User();
        Task taskDB = new Task();
        ProjectService projectService = new ProjectService();
        UserService userService = new UserService();
        TaskService taskService = new TaskService();
        JSONParser parser = new JSONParser();

        try{
            JSONArray company =    (JSONArray) parser.parse(new FileReader("src/Company.json"));
            //variable for project object
            for (Object o :    company){

                JSONObject project = (JSONObject) o;

                String projectName = (String) project.get("name");
//                projectDB.setId(j++);
                projectDB.setName(projectName);
//                Project project1 = new Project(projectDB);
                projectService.saveProject(projectDB);

//                System.out.println(projectDB.getName()+ ":");

                JSONArray users = (JSONArray) project.get("users");

                for (Object u : users){


                    JSONObject user = (JSONObject) u;
                    String userName = (String) user.get("name");

                    userDB.setName(userName);
                    userDB.setProject(projectDB);
                    projectDB.addUser(userDB);

                    userService.saveUser(userDB);
                    projectService.updateProject(projectDB);

//                    System.out.println(userDB.getName());


                    JSONArray tasks = (JSONArray) user.get("tasks");
                    for (Object t : tasks){
                        String taskName = (String) t;
                        taskDB.setName(taskName);
                        taskDB.setUser(userDB);
                        userDB.addTask(taskDB);
                        taskService.saveTask(taskDB);
                        userService.updateUser(userDB);
//                        System.out.println("number"+ " " + (++i)+ ": " + taskDB.getName());

                    }
                }
            }
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
