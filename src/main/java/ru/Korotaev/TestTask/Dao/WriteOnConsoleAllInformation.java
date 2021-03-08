package ru.Korotaev.TestTask.Dao;

import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;

import java.sql.*;

import static ru.Korotaev.TestTask.Dao.ConnectionDao.*;
import static ru.Korotaev.TestTask.Dao.ConnectionDao.PASSWORD;

public class WriteOnConsoleAllInformation {

    public void allInformationAboutProjectsUsersAndTasks() {
        Project project = new Project();
        User user = new User();
        Task task = new Task();
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
                        task.setId(resultSet2.getInt("id"));
                        task.setName(resultSet2.getString("name"));
                        System.out.println("User " + user.getName() + " has task: " + task.getName());
                        System.out.println();
                    }
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
