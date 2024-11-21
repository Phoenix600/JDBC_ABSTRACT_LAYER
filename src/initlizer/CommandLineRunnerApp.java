package initlizer;

import core.StatementType;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class CommandLineRunnerApp {

    public static Integer statementType = StatementType.UNDEFINED;
    public static String MYSQL_QUERY = "";

    final static String CURRENT_DATABASE = "MYSQL";
    final static String DB_URL = "jdbc:mysql://localhost:3306/SpringBootCourse";
    final static String USER_NAME = "root";
    final static String USER_PASS = "root";

    static Connection connection = null;
    static Statement statement = null;
    static PreparedStatement preparedStatement = null; // for update statement


    public static void ExecuteBatch(){
        try{
            preparedStatement.executeBatch();
        }catch (Exception e)
        {
            ErrorMessageLogger(e);
        }
    }

    public static void SetAutoCommit(Boolean isAutoCommit) {
        try{
            connection.setAutoCommit(isAutoCommit);
        } catch (Exception e) {
            ErrorMessageLogger(e);
        }
    }

    public static void Commit()
    {
        try{
            if(connection != null)
            {
                connection.commit();
            }
        }catch(Exception e) {
            ErrorMessageLogger(e);
        }
    }

    private static void ErrorMessageLogger(Exception e)
    {
        System.out.println(e.getMessage());
        System.exit(-1);
    }

    private static void LoadDriverManager() {

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (Exception e)
        {
            ErrorMessageLogger(e);
        }
    }

     public static Connection GetConnectionInstance()
    {
//        connection = null;
        if(connection == null)
        {
            LoadDriverManager();
            try{
                connection = DriverManager.getConnection(DB_URL,USER_NAME,USER_PASS);
            }
            catch (Exception e)
            {
                ErrorMessageLogger(e);
            }// sync
        }

        return connection;
    }

    public static Statement GetSQLStatementObject(int eStatementType)
    {
        if(eStatementType == StatementType.UNDEFINED)
        {
            ErrorMessageLogger(new Exception("Please specify the statement type"));
        }

        if(eStatementType == StatementType.STATEMENT)
        {
            try{
                CommandLineRunnerApp.connection = CommandLineRunnerApp.GetConnectionInstance();
                CommandLineRunnerApp.statement = CommandLineRunnerApp.connection.createStatement();
            }
            catch(Exception e)
            {
                ErrorMessageLogger(e);
            }
            return CommandLineRunnerApp.statement;
        }
        else
        {
            try{
                CommandLineRunnerApp.connection = CommandLineRunnerApp.GetConnectionInstance();
                CommandLineRunnerApp.preparedStatement = CommandLineRunnerApp.connection.prepareStatement(MYSQL_QUERY);
            }
            catch(Exception e)
            {
                ErrorMessageLogger(e);
            }
            return CommandLineRunnerApp.preparedStatement;
        }
    }


    public static Statement GetPreparedStatementInstance()
    {
            return preparedStatement;
    }

}
