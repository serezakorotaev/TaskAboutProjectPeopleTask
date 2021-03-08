package ru.Korotaev.TestTask.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;
import ru.Korotaev.TestTask.Utils.HibernateSessionFactoryUtil;

import java.sql.*;

import static ru.Korotaev.TestTask.Dao.ConnectionDao.*;
import static ru.Korotaev.TestTask.Dao.ConnectionDao.PASSWORD;

public class UserDao {
    public void selectAllProject(User user) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                System.out.println(user.getName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectProjectById(User user) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from users where id=?");
            preparedStatement.setInt(1 , user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                System.out.println(user.getName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
    public void save(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }
    public void update(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }
    public void delete(User user){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(user);
        tx1.commit();
        session.close();
    }
    public Task findTaskById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Task.class,id);
    }
}
