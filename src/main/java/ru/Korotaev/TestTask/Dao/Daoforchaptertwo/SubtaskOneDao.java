package ru.Korotaev.TestTask.Dao.Daoforchaptertwo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskOne;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskTwo;
import ru.Korotaev.TestTask.Utils.HibernateSessionFactoryUtil;

import java.sql.*;

import static ru.Korotaev.TestTask.Dao.ConnectionDao.*;
import static ru.Korotaev.TestTask.Dao.ConnectionDao.PASSWORD;

public class SubtaskOneDao {
    public void selectAllSubtaskOne(SubtaskOne subtaskOne) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from substaskone");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subtaskOne.setId(resultSet.getInt("id"));
                subtaskOne.setName(resultSet.getString("name"));
                subtaskOne.setTime(resultSet.getInt("time"));
                System.out.println(subtaskOne.getName() + " time execution :" + subtaskOne.getTime());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void selectSubtaskOneById(SubtaskOne subtaskOne) {
        try {
            Class.forName(DRIVER);
            Connection connection = DriverManager.getConnection(URL , USER , PASSWORD);
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from subtaskone where id=?");
            preparedStatement.setInt(1 , subtaskOne.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                subtaskOne.setId(resultSet.getInt("id"));
                subtaskOne.setName(resultSet.getString("name"));
                subtaskOne.setTime(resultSet.getInt("time"));
                System.out.println(subtaskOne.getName() + " time execution :" + subtaskOne.getTime());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public void save(SubtaskOne subtaskOne){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(subtaskOne);
        tx1.commit();
        session.close();
    }
    public void update(SubtaskOne subtaskOne){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(subtaskOne);
        tx1.commit();
        session.close();
    }
    public void delete(SubtaskOne subtaskOne){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(subtaskOne);
        tx1.commit();
        session.close();
    }
    public SubtaskTwo findTaskById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(SubtaskTwo.class,id);
    }
}
