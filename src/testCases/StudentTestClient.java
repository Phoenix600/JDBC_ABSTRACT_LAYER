package testCases;

import core.OrderBy;
import model.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.sql.SQLException;
import java.util.LinkedList;

public class StudentTestClient {
    public static void main(String[] args) throws SQLException
    {
//        StudentRepository studentRepository = new StudentRepositoryImpl();
////        System.out.println("=========================================================================");
////        System.out.printf("| %6s | %18s | %18s | %18s |\n", "id", "name", "phone", "city");
////        System.out.println("=========================================================================");
//        for (Student x : studentRepository.findAll())
//        {
//            System.out.printf("| %6d | %18s | %18s | %18s |\n", x.getId(), x.getName(), x.getPhone(), x.getCity());
//        }
////        System.out.println("=========================================================================");
//
//        System.out.println(studentRepository.findStudentById(12L));
//
//        Student s1 = new Student();
//
//        s1.setName("Tony Stark");
//        s1.setPhone("3473829473");
//        s1.setCity("New York City");
//
//        Student s2 = new Student();
//
//        s2.setName("Bruce Wayne");
//        s2.setPhone("3473829473");
//        s2.setCity("New York City");
//
//        LinkedList<Student> students = new LinkedList<>();
//        students.add(s1);
//        students.add(s2);
//        studentRepository.addAll(students);

        StudentRepository repository = new StudentRepositoryImpl();
        System.out.println(repository.orderById(OrderBy.DESC));
    }
}
