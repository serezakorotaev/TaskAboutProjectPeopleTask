package ru.Korotaev.TestTask.Services.Servicesforchaptertwo;

import ru.Korotaev.TestTask.Dao.Daoforchaptertwo.SubtaskOneDao;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskOne;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskTwo;

public class SubtaskOneService {
    private SubtaskOneDao subtaskOneDao;

    public SubtaskOneService(){
        subtaskOneDao = new SubtaskOneDao();
    }
    public void selectAllSubtaskOne(SubtaskOne subtaskOne){
        subtaskOneDao.selectAllSubtaskOne(subtaskOne);
    }
    public void selectSubtaskById(SubtaskOne subtaskOne){
        subtaskOneDao.selectSubtaskOneById(subtaskOne);
    }
    public void saveSubtaskOne(SubtaskOne subtaskOne){
        subtaskOneDao.save(subtaskOne);
    }
    public void updateSubtaskOne(SubtaskOne subtaskOne){
        subtaskOneDao.update(subtaskOne);
    }
    public void deleteSubtaskOne(SubtaskOne subtaskOne){
        subtaskOneDao.delete(subtaskOne);
    }
    public SubtaskTwo findSubtaskOneById(int id){
        return subtaskOneDao.findTaskById(id);
    }
}
