package repository;

import com.mysql.cj.callback.MysqlCallback;
import core.OrderBy;
import core.StatementType;
import core.Switch;
import initlizer.CommandLineRunnerApp;
import model.Student;
import queries.MySQLStudentQueries;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

@FunctionalInterface
interface FunctionPointer{
    public abstract Statement CreateStatementInstance(int statementType);
}


public class StudentRepositoryImpl implements StudentRepository {

    FunctionPointer fp = CommandLineRunnerApp::GetSQLStatementObject;

    @Override
    public List<Student> findAll() throws SQLException {
        List<Student> studentsList = new LinkedList<Student>();
        Student student = null;

        Statement stm = CommandLineRunnerApp.GetSQLStatementObject(StatementType.STATEMENT);
        ResultSet rs =  stm.executeQuery(MySQLStudentQueries.SELECT_ALL_STUDENTS);

        while (rs.next())
        {
            student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setPhone(rs.getString("phone"));
            student.setCity(rs.getString("city"));
            studentsList.add(student);
        }

        return  studentsList;
    }

    @Override
    public Student findStudentById(Long id) throws SQLException {
        CommandLineRunnerApp.MYSQL_QUERY = MySQLStudentQueries.SELECT_STUDENT_BY_ID;
        PreparedStatement preparedStatement =  (PreparedStatement) CommandLineRunnerApp.GetSQLStatementObject(StatementType.PREPARED_STATEMENT);

        preparedStatement.setLong(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Student student = new Student();
        while (resultSet.next())
        {
            student.setId(resultSet.getLong("id"));
            student.setName(resultSet.getString("name"));
            student.setPhone(resultSet.getString("phone"));
            student.setCity(resultSet.getString("city"));
        }

        return student;
    }

    @Override
    public void addAll(List<Student> students) throws SQLException {
        CommandLineRunnerApp.MYSQL_QUERY = MySQLStudentQueries.INSERT_INTO_STUDENT;

        CommandLineRunnerApp.SetAutoCommit(Switch.DISABLE);
        PreparedStatement statement = (PreparedStatement) CommandLineRunnerApp.GetSQLStatementObject(StatementType.PREPARED_STATEMENT);

//        String SqlQuery = String.format(MySQLStudentQueries.INSERT_INTO_STUDENT_PLACEHOLDER,"Pranay Ramteke","934783499","Pune");
//        statement.addBatch(SqlQuery);
//
//        SqlQuery = String.format(MySQLStudentQueries.INSERT_INTO_STUDENT_PLACEHOLDER,"Rajesh Shiyal","934474845","Gujrat");
//        statement.addBatch();

        String InsertQuery = "";
        for (Student student: students)
        {
//            InsertQuery = String.format(MySQLStudentQueries.INSERT_INTO_STUDENT_PLACEHOLDER,student.getName(),student.getPhone(),student.getCity());
            statement.setString(1,student.getName());
            statement.setString(2,student.getPhone());
            statement.setString(3,student.getCity());
            statement.addBatch();
        }

        CommandLineRunnerApp.ExecuteBatch();
        CommandLineRunnerApp.Commit();

    }

    @Override
    public List<Student> orderById() {
        return List.of();
    }

    @Override
    public List<Student> orderById( int orderBy) throws SQLException {

        Statement statement = null;
        statement = CommandLineRunnerApp.GetSQLStatementObject(StatementType.STATEMENT);
        ResultSet rs = null;

        if(orderBy == OrderBy.DESC)
        {
            rs = statement.executeQuery(MySQLStudentQueries.SELECT_STUDENT_BY_ID_DES);
        }
        else if (orderBy == OrderBy.ASC || orderBy == OrderBy.UNDEFINED)
        {
            rs = statement.executeQuery(MySQLStudentQueries.SELECT_STUDENT_BY_ID_ASC);
        }

        List<Student> studentList = new LinkedList<Student>();

        while (rs.next())
        {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setPhone(rs.getString("phone"));
            student.setCity(rs.getString("city"));
            studentList.add(student);
        }

        return studentList;
    }


}
