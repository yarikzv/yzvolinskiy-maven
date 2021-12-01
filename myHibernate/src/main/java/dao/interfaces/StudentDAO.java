package dao.interfaces;

import entity.Student;

import java.util.List;

/**
 * An interface for Data Access Layer for Student.
 */
public interface StudentDAO {

    /**
     * Getting Student by id.
     *
     * @param id Id of Student.
     * @return Student student.
     */
    Student get(Integer id);

    /**
     * Saves Student if id not exist and updates Student if is present.
     *
     * @param student Student student.
     * @return Student student.
     */
    Student saveOrUpdate(Student student);

    /**
     * Getting all Students from table.
     *
     * @return List of Students.
     */
    List<Student> getAll();

    /**
     * Searches Students by part of full name.
     *
     * @param partOfFullName String that contains part of name of Student.
     * @return List of found Students.
     */
    List<Student> findByNameContaining(String partOfFullName);
}
