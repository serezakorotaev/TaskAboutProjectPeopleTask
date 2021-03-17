package ru.Korotaev.TestTask.Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.User;
import ru.Korotaev.TestTask.Utils.HibernateSessionFactoryUtil;

import java.sql.*;

import static ru.Korotaev.TestTask.Dao.ConnectionDao.*;

public class ProjectDao {
    public void selectProjectById(Project project) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from project where id=?");
            preparedStatement.setInt(1 , project.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                System.out.println(project.getName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void selectAllProject(Project project) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from project");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                System.out.println(project.getName());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void saveProject(Project project){
        try{
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("insert into project (?,?)" );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    //////////////////////////////////////////////////////////
    public void save(Project project){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(project);
        tx1.commit();
        session.close();
    }
    public void update(Project project){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(project);
        tx1.commit();
        session.close();
    }
    public void delete(Project project){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(project);
        tx1.commit();
        session.close();
    }
    public User findUserById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class,id);
    }
}

