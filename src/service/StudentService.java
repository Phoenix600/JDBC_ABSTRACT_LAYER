package service;

import model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    public List<Student> listAllStudent() throws SQLException;
    public List<Student> findStudentByName(String name);
    public Student findStudentById(Long id) throws SQLException;
    public List<Student> findStudentByCity(String city);
    public List<Student> findAllStudentByIdAscendingOrder();
    public List<Student> findAllStudentByIdDescendingOrder();
    public void saveStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(Long id);
    public void addAllStudents(List<Student> students) throws SQLException;
}
