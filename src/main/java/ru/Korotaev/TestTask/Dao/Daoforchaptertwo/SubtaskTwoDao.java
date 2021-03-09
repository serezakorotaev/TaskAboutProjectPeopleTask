package ru.Korotaev.TestTask.Dao.Daoforchaptertwo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskTwo;
import ru.Korotaev.TestTask.Utils.HibernateSessionFactoryUtil;

import java.sql.*;

import static ru.Korotaev.TestTask.Dao.ConnectionDao.*;
import static ru.Korotaev.TestTask.Dao.ConnectionDao.PASSWORD;

public class SubtaskTwoDao {
    public void selectAllSubtaskTwo(SubtaskTwo subtaskTwo) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from subtasktwo");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subtaskTwo.setId(resultSet.getInt("id"));
                subtaskTwo.setName(resultSet.getString("name"));
                subtaskTwo.setTime(resultSet.getInt("time"));
                System.out.println(subtaskTwo.getName() + " time execution :" + subtaskTwo.getTime());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void selectSubtaskTwoById(SubtaskTwo subtaskTwo) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from subtasktwo where id=?");
            preparedStatement.setInt(1 , subtaskTwo.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subtaskTwo.setId(resultSet.getInt("id"));
                subtaskTwo.setName(resultSet.getString("name"));
                subtaskTwo.setTime(resultSet.getInt("time"));
                System.out.println(subtaskTwo.getName() + " time execution :" + subtaskTwo.getTime());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void save(SubtaskTwo subtaskTwo){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subtaskTwo);
        tx1.commit();
        session.close();
    }
    public void update(SubtaskTwo subtaskTwo){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subtaskTwo);
        tx1.commit();
        session.close();
    }
    public void delete(SubtaskTwo subtaskTwo){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(subtaskTwo);
        tx1.commit();
        session.close();
    }
}
