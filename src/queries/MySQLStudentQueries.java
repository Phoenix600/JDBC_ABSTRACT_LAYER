package queries;

/**
 * This class contains SQL queries related to student operations in a MySQL database.
 * It provides constant query strings that can be used to interact with the 'student' table.
 */
public class MySQLStudentQueries {
    public final static String SHOW_ALL_TABLES                      = "SHOW TABLES";
    public final static String SELECT_ALL_STUDENTS                  = "SELECT * FROM student";
    public final static String SELECT_STUDENT_BY_ID                 = "SELECT * FROM student WHERE id = ?";
    public final static String SELECT_STUDENT_BY_ID_ASC             = "SELECT * FROM student ORDER BY id ASC";
    public final static String INSERT_INTO_STUDENT                  = "INSERT INTO student(name,phone,city) VALUES (?,?,?)";
    public final static String SELECT_STUDENT_BY_ID_DES             = "SELECT * FROM student ORDER BY id DESC";
    public final static String REMOVE_STUDENT_BY_ID                 = "DELETE FROM student WHERE id=?";
    public final static String UPDATE_STUDENT_BY_ID                 = "UPDATE student SET name=?, phone=?, city=? WHERE id=?";
    public final static String SELECT_STUDENT_BY_NAME               = "SELECT * FROM student WHERE name = ?";
    public final static String SELECT_STUDENT_BY_NAME_PATTERN       = "SELECT * FROM student WHERE name LIKE ?";
}
