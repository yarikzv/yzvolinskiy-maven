package service;

import dao.StudyGroupDAOImpl;
import entity.StudyGroup;

import java.util.List;

/**
 * A service class for hiding DAO layer realization for users.
 */
public class StudyGroupService {

    private StudyGroupDAOImpl studyGroupDAOImpl = new StudyGroupDAOImpl();

    public StudyGroup get(Integer id) {
        return studyGroupDAOImpl.get(id);
    }

    public List<StudyGroup> getAll() {
        return studyGroupDAOImpl.getAll();
    }

    public StudyGroup saveOrUpdate(StudyGroup studyGroup) {
        return studyGroupDAOImpl.saveOrUpdate(studyGroup);
    }
}
