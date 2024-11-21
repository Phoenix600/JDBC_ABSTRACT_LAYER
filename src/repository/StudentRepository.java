package repository;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository {

    /**
     *
     * @return Returns the list of student objects
     * @throws SQLException
     */
    List<Student> findAll() throws SQLException;

    /**
     *
     * @param id
     * @return Returns the student object
     * @throws SQLException
     */
    Student findStudentById(Long id) throws SQLException;

    void addAll(List<Student> students) throws SQLException;

    List<Student> orderById();
    List<Student> orderById(int orderBy) throws SQLException;
}
