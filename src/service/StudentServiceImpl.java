package service;

import model.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    // Creating The Object Of StudentRepository Type
    StudentRepository studentRepository = new StudentRepositoryImpl();

    /**
     *
     * @return List of student
     * @throws SQLException
     */
    @Override
    public List<Student> listAllStudent() throws SQLException {
        return studentRepository.findAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<Student> findStudentByName(String name) {
        return List.of();
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public Student findStudentById(Long id) throws SQLException {
        return studentRepository.findStudentById(id);
    }

    /**
     *
     * @param city
     * @return
     */
    @Override
    public List<Student> findStudentByCity(String city) {
        return List.of();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Student> findAllStudentByIdAscendingOrder() {
        return List.of();
    }

    /**
     *
     * @return
     */
    @Override
    public List<Student> findAllStudentByIdDescendingOrder() {
        return List.of();
    }

    /**
     *
     * @param student
     */
    @Override
    public void saveStudent(Student student) {

    }

    /**
     *
     * @param student
     */
    @Override
    public void updateStudent(Student student) {

    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteStudent(Long id) {

    }

    /**
     *
     * @param students
     */
    @Override
    public void addAllStudents(List<Student> students) throws SQLException {
        studentRepository.addAll(students);
    }
}
