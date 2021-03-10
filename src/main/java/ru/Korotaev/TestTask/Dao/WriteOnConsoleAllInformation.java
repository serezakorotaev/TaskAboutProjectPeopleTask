package ru.Korotaev.TestTask.Dao;

import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskOne;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskTwo;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;

import java.sql.*;

import static ru.Korotaev.TestTask.Dao.ConnectionDao.*;
import static ru.Korotaev.TestTask.Dao.ConnectionDao.PASSWORD;

/**
 * This class write all information from database on console, subtask's time too
 * @author Sergey Korotaev
 */
public class WriteOnConsoleAllInformation {
    /**
     * This method write all information from database on console, subtask's time too
     * @see Project
     * @see User
     * @see Task
     * @see SubtaskOne
     * @see SubtaskTwo
     */
    public void allInformationAboutProjectsUsersAndTasks() {
        Project project = new Project();
        User user = new User();
        Task task = new Task();
        SubtaskOne subtaskOne = new SubtaskOne();
        SubtaskTwo subtaskTwo = new SubtaskTwo();
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from project");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                System.out.println(project.getName());
                //Information from users database
                PreparedStatement preparedStatement1 = connection.prepareStatement("SELECT * from users where project_id=?");
                preparedStatement1.setInt(1 , project.getId());
                ResultSet resultSet1 = preparedStatement1.executeQuery();
                while (resultSet1.next()) {
                    user.setId(resultSet1.getInt("id"));
                    user.setName(resultSet1.getString("firstname"));
                    System.out.println("User: " + user.getName() + " on project - " + project.getName());
                    System.out.println();
                    //Information from task database
                    PreparedStatement preparedStatement2 = connection.prepareStatement("select  * from task where users_id=?");
                    preparedStatement2.setInt(1 , user.getId());
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    while (resultSet2.next()) {
                        int timeSubtaskOne = 0;
                        int timeSubtaskTwo = 0;
                        task.setId(resultSet2.getInt("id"));
                        task.setName(resultSet2.getString("name"));
                        System.out.println("User " + user.getName() + " has task: " + task.getName());
                        System.out.println();

                        //Information from subtaskone database
                        PreparedStatement preparedStatement3 = connection.prepareStatement("select * from subtaskone where task_id=?");
                        preparedStatement3.setInt(1 , task.getId());
                        ResultSet resultSet3 = preparedStatement3.executeQuery();
                        while (resultSet3.next()) {
                            subtaskOne.setId(resultSet3.getInt("id"));
                            subtaskOne.setName(resultSet3.getString("name"));
                            subtaskOne.setTime(resultSet3.getInt("time"));
                            System.out.println("Subtask: " + subtaskOne.getName() + "," + subtaskOne.getTime() + "sec on execution");
                            timeSubtaskOne = timeSubtaskOne + subtaskOne.getTime();
                            //Information from subtasktwo database
                            PreparedStatement preparedStatement4 = connection.prepareStatement("select * from subtasktwo where subtaskOne_id = ?");
                            preparedStatement4.setInt(1 , subtaskOne.getId());
                            ResultSet resultSet4 = preparedStatement4.executeQuery();
                            while (resultSet4.next()) {
                                subtaskTwo.setId(resultSet4.getInt("id"));
                                subtaskTwo.setName(resultSet4.getString("name"));
                                subtaskTwo.setTime(resultSet4.getInt("time"));
                                System.out.println("Subtask: " + subtaskTwo.getName() + "," + subtaskTwo.getTime() + "sec on execution");
                                timeSubtaskTwo = timeSubtaskTwo + subtaskTwo.getTime();
                            }
                        }
                        if(timeSubtaskOne !=0) {
                            System.out.println("All time on execute subtasks: " + timeSubtaskOne + "sec by" + subtaskOne.getName() + " task");
                        }
                        System.out.println();
                        if(timeSubtaskTwo != 0) {
                            System.out.println("All time on execute subtasks in subtask one: " + timeSubtaskTwo + "sec");
                        }
                        if (timeSubtaskOne < timeSubtaskTwo) {
                            System.out.println("THE TIME TO COMPLETE A SUBTASK IS LESS THAN THE TIME TO COMPLETE ITS SUBTASKS");
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
