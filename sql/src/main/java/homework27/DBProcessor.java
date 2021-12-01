package homework27;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  A class for processing database queries using JDBC. Contains four methods.
 *  SQL queries executes by {@code PreparedStatement} using {@code int id} as parameter.
 *  Used {@code try} with resources because {@code PreparedStatement} and connection needs
 *  to be closed.
 */
public class DBProcessor {

    /**
     * This method gets Student's name from {@code university} database.
     * Used checking if parameter not negative or zero.
     *
     * @param id Student's id
     * @return A Student with set field {@code name} by id.
     */
    public static Student getStudentById(int id) {
        Student student = new Student();
        if (id > 0) {
            try (PreparedStatement getStudentByIdStatement = ConnectionUtil.getConnection()
                    .prepareStatement("SELECT name FROM students WHERE student_id = ?")) {
                getStudentByIdStatement.setInt(1, id);
                ResultSet resultSet = getStudentByIdStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    student.setName(name);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    /**
     * This method deletes item from database by id from parameter.
     * Used checking if parameter not negative or zero.
     *
     * @param id Student's id
     * @return True, if id is not negative or zero, and query completed successfully.
     */
    public static boolean deleteStudentById(int id) {
        if (id > 0) {
            try (PreparedStatement deleteStudentByIdStatement = ConnectionUtil.getConnection()
                    .prepareStatement("DELETE FROM students WHERE student_id = ?")) {
                deleteStudentByIdStatement.setInt(1, id);
                deleteStudentByIdStatement.execute();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * This method receives a list of all students in the table and returns it.
     *
     * @return List of all students.
     */
    public static List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        try (PreparedStatement getAllStudentsStatement = ConnectionUtil.getConnection()
                .prepareStatement("SELECT name FROM students")) {
            ResultSet resultSet = getAllStudentsStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                Student student = new Student();
                student.setName(name);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    /**
     * This method receives a list of students by the last name given as a parameter.
     * The list is more than one item if the last name is repeated.
     * Used {@code trim()} method for deleting spaces from String lastName, if presented.
     * {@code null} safe.
     *
     * @param lastName String parameter with last name of student.
     * @return List of students with similar last names or one student.
     */
    public static List<Student> getStudentListByLastName(String lastName) {
        List<Student> studentList = new ArrayList<>();
        if (lastName != null) {
            try (PreparedStatement getStudentListByLastNameStatement = ConnectionUtil.getConnection()
                    .prepareStatement("SELECT name FROM students WHERE name LIKE ?")) {
                String parameter = lastName.trim() + "%";
                getStudentListByLastNameStatement.setString(1, parameter);
                ResultSet resultSet = getStudentListByLastNameStatement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    Student student = new Student();
                    student.setName(name);
                    studentList.add(student);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return studentList;
    }
}
