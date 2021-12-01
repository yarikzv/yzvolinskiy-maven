package dao;

import dao.interfaces.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

/**
 * Implementation of StudentDAO interface with methods realization.
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public Student get(Integer id) {
        return HibernateUtil.getSessionFactory().openSession().get(Student.class, id);
    }

    @Override
    public Student saveOrUpdate(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Integer id = student.getStudentId();
        if (id == null) {
            session.save(student);
        } else {
            session.merge(student);
        }
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public List<Student> getAll() {
        return (List<Student>) HibernateUtil.getSessionFactory().openSession().createQuery("from Student").list();
    }

    @Override
    public List<Student> findByNameContaining(String partOfFullName) {
        return (List<Student>) HibernateUtil.getSessionFactory().openSession()
                .createQuery("from Student where name like :partName")
                .setParameter("partName", partOfFullName + "%").list();
    }
}
