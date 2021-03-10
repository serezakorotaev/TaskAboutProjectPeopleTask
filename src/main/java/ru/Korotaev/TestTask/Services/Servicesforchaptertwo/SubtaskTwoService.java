package ru.Korotaev.TestTask.Services.Servicesforchaptertwo;

import ru.Korotaev.TestTask.Dao.Daoforchaptertwo.SubtaskTwoDao;
import ru.Korotaev.TestTask.Models.Modelsforchapter2.SubtaskTwo;

public class SubtaskTwoService {
    private SubtaskTwoDao subtaskTwoDao;

    public SubtaskTwoService(){
        subtaskTwoDao = new SubtaskTwoDao();
    }
    public void selectAllSubtaskTwo(SubtaskTwo subtaskTwo){
        subtaskTwoDao.selectAllSubtaskTwo(subtaskTwo);
    }
    public void selectSubtaskTwoById(SubtaskTwo subtaskTwo){
        subtaskTwoDao.selectSubtaskTwoById(subtaskTwo);
    }
    public void saveSubtaskTwo(SubtaskTwo subtaskTwo){
        subtaskTwoDao.save(subtaskTwo);
    }
    public void updateSubtaskTwo(SubtaskTwo subtaskTwo){
        subtaskTwoDao.update(subtaskTwo);
    }
    public void deleteSubtaskTwo(SubtaskTwo subtaskTwo){
        subtaskTwoDao.delete(subtaskTwo);
    }
}
