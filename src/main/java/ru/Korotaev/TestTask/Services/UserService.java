package ru.Korotaev.TestTask.Services;

import ru.Korotaev.TestTask.Dao.UserDao;
import ru.Korotaev.TestTask.Models.Task;
import ru.Korotaev.TestTask.Models.User;

public class UserService {
    private UserDao userDao;

    public UserService(){
        userDao = new UserDao();
    }
    public void selectAllUser(User user){
        userDao.selectAllProject(user);
    }
    public void selectUserById(User user){
        userDao.selectProjectById(user);
    }
    public void saveUser(User user){
        userDao.save(user);
    }
    public void updateUser(User user){
        userDao.update(user);
    }
    public void deleteUser(User user){
        userDao.delete(user);
    }
    public Task findTaskById(int id){
        return userDao.findTaskById(id);
    }
}
