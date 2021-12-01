package service;

import dao.StudentDAOImpl;
import entity.Student;

import java.util.List;

/**
 * A service class for hiding DAO layer realization for users.
 */
public class StudentService {

    private StudentDAOImpl studentDAOImpl = new StudentDAOImpl();

    public Student get(Integer id) {
        return studentDAOImpl.get(id);
    }

    public Student saveOrUpdate(Student student) {
        return studentDAOImpl.saveOrUpdate(student);
    }

    public List<Student> getAll() {
        return studentDAOImpl.getAll();
    }

    public List<Student> findByNameContaining(String partOfFullName) {
        return studentDAOImpl.findByNameContaining(partOfFullName);
    }


}
