package ru.Korotaev.TestTask.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskOne;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Utils.HibernateSessionFactoryUtil;

import java.sql.*;

import static ru.Korotaev.TestTask.Dao.ConnectionDao.*;
import static ru.Korotaev.TestTask.Dao.ConnectionDao.PASSWORD;

public class TaskDao {
    public void selectAllTask(Task task) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from task");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                System.out.println(task.getName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectTaskById(Task task) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from task where id=?");
            preparedStatement.setInt(1 , task.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                task.setId(resultSet.getInt("id"));
                task.setName(resultSet.getString("name"));
                System.out.println(task.getName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void save(Task task){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(task);
        tx1.commit();
        session.close();
    }
    public void update(Task task){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(task);
        tx1.commit();
        session.close();
    }
    public void delete(Task task){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(task);
        tx1.commit();
        session.close();
    }
    public SubtaskOne findSubtaskById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(SubtaskOne.class,id);
    }
}
