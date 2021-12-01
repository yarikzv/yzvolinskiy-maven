package dao.interfaces;

import entity.StudyGroup;

import java.util.List;

public interface StudyGroupDAO {

    /**
     * Getting Group by id.
     *
     * @param id Id of Group.
     * @return StudyGroup studyGroup.
     */
    StudyGroup get(Integer id);

    /**
     * Getting list of all Groups from table.
     *
     * @return List of Groups.
     */
    List<StudyGroup> getAll();

    /**
     * Saves Group if id not exist and updates Group if is present.
     *
     * @param studyGroup StudyGroup studyGroup.
     * @return StudyGroup studyGroup.
     */
    StudyGroup saveOrUpdate(StudyGroup studyGroup);
}
