package dao;

import dao.interfaces.StudyGroupDAO;
import entity.StudyGroup;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

/**
 * Implementation of StudyGroupDAO interface with methods realization.
 */
public class StudyGroupDAOImpl implements StudyGroupDAO {

    @Override
    public StudyGroup get(Integer id) {
        return HibernateUtil.getSessionFactory().openSession().get(StudyGroup.class, id);
    }

    @Override
    public List<StudyGroup> getAll() {
        return (List<StudyGroup>) HibernateUtil.getSessionFactory().openSession().createQuery("from StudyGroup").list();
    }

    @Override
    public StudyGroup saveOrUpdate(StudyGroup studyGroup) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = studyGroup.getStudyGroupId();
        if (id == null) {
            session.save(studyGroup);
        } else {
            session.merge(studyGroup);
        }
        transaction.commit();
        session.close();
        return studyGroup;
    }
}
