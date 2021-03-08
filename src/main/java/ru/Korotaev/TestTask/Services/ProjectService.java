package ru.Korotaev.TestTask.Services;

import ru.Korotaev.TestTask.Dao.ProjectDao;
import ru.Korotaev.TestTask.Models.Project;
import ru.Korotaev.TestTask.Models.User;

public class ProjectService {
    private ProjectDao projectDao;

    public ProjectService(){
        projectDao = new ProjectDao();
    }
    public void selectAllProject(Project project){
        projectDao.selectAllProject(project);
    }
    public void selectProjectById(Project project){
        projectDao.selectProjectById(project);
    }
    public void saveProject(Project project){
        projectDao.save(project);
    }
    public void updateProject(Project project){
        projectDao.update(project);
    }
    public void deleteProject(Project project){
        projectDao.delete(project);
    }
    public User findUserById(int id){
        return projectDao.findUserById(id);
    }
}
